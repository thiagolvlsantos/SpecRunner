/*
    SpecRunner - Acceptance Test Driven Development Tool
    Copyright (C) 2011-2013  Thiago Santos

    This program is free software: you can redistribute it and/or modify
    it under the terms of the GNU General Public License as published by
    the Free Software Foundation, either version 3 of the License, or
    (at your option) any later version.

    This program is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU General Public License for more details.

    You should have received a copy of the GNU General Public License
    along with this program.  If not, see <http://www.gnu.org/licenses/>
 */
package org.specrunner.plugins.impl.language;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

import nu.xom.Element;
import nu.xom.Node;
import nu.xom.Text;

import org.specrunner.context.IContext;
import org.specrunner.junit.ExpectedMessage;
import org.specrunner.parameters.DontEval;
import org.specrunner.plugins.ActionType;
import org.specrunner.plugins.PluginException;
import org.specrunner.plugins.impl.AbstractPlugin;
import org.specrunner.plugins.impl.elements.PluginHtml;
import org.specrunner.plugins.impl.var.PluginBean;
import org.specrunner.plugins.type.Assertion;
import org.specrunner.plugins.type.Command;
import org.specrunner.plugins.type.Undefined;
import org.specrunner.result.IResultSet;
import org.specrunner.result.status.Failure;
import org.specrunner.result.status.Success;
import org.specrunner.util.UtilLog;
import org.specrunner.util.UtilString;
import org.specrunner.util.aligner.impl.DefaultAlignmentException;
import org.specrunner.util.converter.UtilConverter;
import org.specrunner.util.xom.INodeHolder;
import org.specrunner.util.xom.UtilNode;

/**
 * A natural language plugin to perform pattern matching like
 * JBehave/Cucumber/Twist fixtures.
 * 
 * Method match by default is performed from Java to arguments, the other
 * direction is possible using <code>after=true</code>.
 * 
 * @author Thiago Santos
 * 
 */
public class PluginSentence extends AbstractPlugin {

    /**
     * The plugin type.
     */
    private ActionType type = Undefined.INSTANCE;

    /**
     * Method to call.
     */
    private String method;

    /**
     * Flag to enable lookup method after arguments conversion.
     */
    private Boolean after = Boolean.FALSE;

    @Override
    public ActionType getActionType() {
        return type;
    }

    /**
     * Get method name.
     * 
     * @return The method name.
     */
    public String getMethod() {
        return method;
    }

    /**
     * The method to call to this sentence.
     * 
     * @param method
     *            The method name.
     */
    @DontEval
    public void setMethod(String method) {
        this.method = method;
    }

    /**
     * The flag status.
     * 
     * @return true, to perform method lookup after arguments conversion, false,
     *         to perform method.
     */
    public Boolean getAfter() {
        return after;
    }

    /**
     * The flag to perform method lookup after arguments conversion.
     * 
     * @param after
     *            true, to lookup method after arguments conversion, false,
     *            otherwise.
     */
    public void setAfter(Boolean after) {
        this.after = after;
    }

    @Override
    public void doEnd(IContext context, IResultSet result) throws PluginException {
        Object target = getObject(context);
        if (target == null) {
            throw new PluginException("Target object cannot be null.");
        }
        StringBuilder methodName = new StringBuilder();
        List<Object> arguments = new LinkedList<Object>();
        extractMethodNameArguments(context, methodName, arguments);
        String methodToCall = method != null ? method : UtilString.camelCase(methodName.toString());
        if (UtilLog.LOG.isDebugEnabled()) {
            UtilLog.LOG.debug("FULL:" + context.getNode().toXML());
            UtilLog.LOG.debug("TEXT:" + methodName);
            UtilLog.LOG.debug("METH:" + methodToCall);
            UtilLog.LOG.debug("ARGS:" + arguments);
        }
        Throwable error = null;
        Method m = after ? getMethodAfter(target, methodToCall, arguments) : getMethodBefore(target, methodToCall, arguments);
        if (m.getReturnType() == Boolean.class || m.getReturnType() == boolean.class) {
            type = Assertion.INSTANCE;
        } else {
            type = Command.INSTANCE;
        }
        try {
            if (after) {
                prepareArgumentsAfter(context, m, arguments);
            } else {
                prepareArgumentsBefore(context, m, arguments);
            }
            if (UtilLog.LOG.isDebugEnabled()) {
                UtilLog.LOG.debug("TYPED ARGS:" + arguments);
            }
            Object tmp = m.invoke(target, arguments.toArray());
            if (type == Assertion.INSTANCE) {
                if (tmp instanceof Boolean && !((Boolean) tmp)) {
                    throw new PluginException("Expected result of " + method + " must be 'true'. Received 'false'.");
                }
            }
            result.addResult(Success.INSTANCE, context.peek());
        } catch (IllegalArgumentException e) {
            error = e.getCause() != null ? e.getCause() : e;
        } catch (IllegalAccessException e) {
            error = e.getCause() != null ? e.getCause() : e;
        } catch (InvocationTargetException e) {
            error = e.getCause() != null ? e.getCause() : e;
        } catch (PluginException e) {
            error = e;
        }
        ExpectedMessage em = m.getAnnotation(ExpectedMessage.class);
        if (error != null) {
            if (em == null) {
                throw new PluginException(error);
            }
            String received = error.getMessage();
            String expectation = em.message();
            if (expectation.equals(received)) {
                result.addResult(Success.INSTANCE, context.peek());
                return;
            }
            result.addResult(Failure.INSTANCE, context.peek(), new DefaultAlignmentException("" + m + arguments + "\nExpected message does not match.", expectation, received));
        } else {
            if (em != null) {
                result.addResult(Failure.INSTANCE, context.peek(), "Expected message not received.\nMessage: " + em.message());
            }
        }
    }

    /**
     * Get the object instance to be used by plugin actions.
     * 
     * @param context
     *            The context.
     * @return An object instance where all actions will taken over.
     */
    protected Object getObject(IContext context) {
        Object instance = PluginBean.getBean(context);
        if (instance == null) {
            instance = PluginHtml.getTestInstance();
        }
        return instance;
    }

    /**
     * Extract text and arguments.
     * 
     * @param context
     *            The context.
     * @param text
     *            The text part.
     * @param args
     *            The argument objects.
     * @throws PluginException
     *             On errors.
     */
    protected void extractMethodNameArguments(IContext context, StringBuilder text, List<Object> args) throws PluginException {
        Node node = context.getNode();
        if (node.getChildCount() == 1 && node.getChild(0) instanceof Text) {
            onlyText(context, node, text, args);
        } else {
            onlyArgs(context, node, text, args);
        }
    }

    /**
     * Extract parameters from text. In this approach, all parameters are
     * expected as strings.
     * 
     * @param context
     *            The context.
     * @param node
     *            The current node.
     * @param text
     *            The text.
     * @param args
     *            The arguments.
     * @throws PluginException
     *             On errors.
     */
    protected void onlyText(IContext context, Node node, StringBuilder text, List<Object> args) throws PluginException {
        INodeHolder holder = UtilNode.newNodeHolder(node);
        String tmp = String.valueOf(holder.getObject(context, true));
        Stack<StringBuilder> stack = new Stack<StringBuilder>();
        stack.push(new StringBuilder());
        for (int i = 0; i < tmp.length(); i++) {
            char c = tmp.charAt(i);
            if (c == '"') {
                if (i > 0 && tmp.charAt(i - 1) == '\\') {
                    stack.peek().setLength(stack.peek().length() - 1);
                    stack.peek().append(c);
                    continue;
                }
                if (stack.size() == 1) {
                    stack.push(new StringBuilder());
                } else {
                    args.add(stack.pop().toString());
                }
                continue;
            }
            stack.peek().append(c);
        }
        text.append(stack.pop().toString());
    }

    /**
     * Extract arguments from nodes.
     * 
     * @param context
     *            The context.
     * @param node
     *            The node.
     * @param text
     *            The text.
     * @param args
     *            The arguments.
     * @throws PluginException
     *             On errors.
     */
    protected void onlyArgs(IContext context, Node node, StringBuilder text, List<Object> args) throws PluginException {
        if (node instanceof Text) {
            text.append(node.getValue());
        }
        for (int i = 0; i < node.getChildCount(); i++) {
            Node n = node.getChild(i);
            if (n instanceof Element) {
                INodeHolder h = UtilNode.newNodeHolder(n);
                if (h.hasName("arg") || h.attributeContains("class", "arg")) {
                    args.add(h.getObject(context, true));
                } else {
                    onlyArgs(context, n, text, args);
                }
            } else {
                onlyArgs(context, n, text, args);
            }
        }
    }

    /**
     * Get object method.
     * 
     * @param target
     *            The object target.
     * @param method
     *            The method name.
     * @param args
     *            Possible arguments.
     * @return The corresponding method.
     * @throws PluginException
     *             On method lookup errors.
     * 
     */
    protected Method getMethodBefore(Object target, String method, List<Object> args) throws PluginException {
        Class<?> type = target.getClass();
        Method[] methods = type.getMethods();
        for (Method m : methods) {
            if (m.getName().equals(method) && m.getParameterTypes().length == args.size()) {
                return m;
            }
        }
        throw new PluginException("Method named '" + method + "' with " + args.size() + " parameter(s) not found for " + type);
    }

    /**
     * Prepare argument list, based on parameter types.
     * 
     * @param context
     *            The context.
     * @param method
     *            The method.
     * @param arguments
     *            The arguments.
     * @throws PluginException
     *             On preparation errors.
     */
    protected void prepareArgumentsBefore(IContext context, Method method, List<Object> arguments) throws PluginException {
        UtilConverter.prepareMethodArguments(method, arguments);
    }

    /**
     * Get object method.
     * 
     * @param target
     *            The object target.
     * @param method
     *            The method name.
     * @param args
     *            Possible arguments.
     * @return The corresponding method.
     * @throws PluginException
     *             On method lookup errors.
     * 
     */
    protected Method getMethodAfter(Object target, String method, List<Object> args) throws PluginException {
        Class<?> type = target.getClass();
        Class<?>[] types = new Class<?>[args.size()];
        for (int i = 0; i < args.size(); i++) {
            Object tmp = args.get(i);
            types[i] = tmp != null ? tmp.getClass() : Object.class;
        }
        try {
            return type.getMethod(method, types);
        } catch (SecurityException e) {
            throw new PluginException(e);
        } catch (NoSuchMethodException e) {
            throw new PluginException(e);
        }
    }

    /**
     * Prepare argument list, based on parameter types.
     * 
     * @param context
     *            The context.
     * @param method
     *            The method.
     * @param arguments
     *            The arguments.
     * @throws PluginException
     *             On preparation errors.
     */
    protected void prepareArgumentsAfter(IContext context, Method method, List<Object> arguments) throws PluginException {
        // nothing to change.
    }
}
