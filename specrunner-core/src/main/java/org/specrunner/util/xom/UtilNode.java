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
package org.specrunner.util.xom;

import nu.xom.Attribute;
import nu.xom.Element;
import nu.xom.Node;
import nu.xom.Nodes;

import org.specrunner.plugins.PluginException;

/**
 * Node utility class.
 * 
 * @author Thiago Santos
 * 
 */
public final class UtilNode {

    /**
     * Any node in specification with attribute "ignore=true" will not be
     * evaluated. Ignore is also used in plugin specific features such as to
     * avoid cell comparison inside tables in WebDriver profile.
     */
    public static final String IGNORE = "ignore";
    /**
     * The CSS attribute name.
     */
    public static final String ATT_CSS = "class";

    /**
     * The CSS which set the left argument.
     */
    public static final String CSS_LETF = "left";
    /**
     * The CSS which set the right argument.
     */
    public static final String CSS_RIGHT = "right";

    /**
     * Hidden constructor.
     */
    private UtilNode() {
    }

    /**
     * Check is a node is marked to be ignored.
     * 
     * @param node
     *            The node to be checked.
     * @return true, if node can be ignored, false, otherwise.
     */
    public static boolean isIgnore(Node node) {
        return node instanceof Element && ((Element) node).getAttribute(IGNORE) != null;
    }

    /**
     * Adds the information that a given node might be ignored by runners.
     * 
     * @param node
     *            The node to be ignored.
     */
    public static void setIgnore(Node node) {
        if (node instanceof Element) {
            ((Element) node).addAttribute(new Attribute(IGNORE, "true"));
        }
    }

    /**
     * Add a CSS to the node.
     * 
     * @param node
     *            The node.
     * @param css
     *            The css to be added (appended).
     * @return The node.
     */
    public static Node appendCss(Node node, String css) {
        if (node instanceof Element) {
            Element ele = (Element) node;
            Attribute att = ele.getAttribute(ATT_CSS);
            if (att == null) {
                ele.addAttribute(new Attribute(ATT_CSS, css));
            } else {
                String value = att.getValue();
                if (!value.contains(css)) {
                    att.setValue(value + " " + css);
                }
            }
        }
        return node;
    }

    /**
     * Remove a CSS from node.
     * 
     * @param node
     *            Node object.
     * @param css
     *            The node.
     */
    public static void removeCss(Node node, String css) {
        if (node instanceof Element) {
            Element ele = (Element) node;
            Attribute att = ele.getAttribute(ATT_CSS);
            if (att != null) {
                att.setValue(att.getValue().toLowerCase().replace(css, ""));
            }
        }
    }

    /**
     * Get child elements as a String.
     * 
     * @param parent
     *            The parent element.
     * @return The inner XML.
     */
    public static String getChildrenAsString(Node parent) {
        StringBuilder str = new StringBuilder();
        Nodes children = parent.query("child::node()");
        for (int i = 0; i < children.size(); i++) {
            str.append(children.get(i).toXML());
        }
        return str.toString();
    }

    /**
     * Get the highest node in the specification hierarchy.
     * 
     * @param nodes
     *            List of nodes.
     * @return The highest node.
     */
    public static Node getHighest(Nodes nodes) {
        Node result = null;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < nodes.size(); i++) {
            Node n = nodes.get(i);
            int t = getDepth(n);
            if (t < min) {
                result = n;
                min = t;
            }
        }
        return result;
    }

    /**
     * Get the node depth in the specification.
     * 
     * @param node
     *            The node.
     * @return The height.
     */
    public static int getDepth(Node node) {
        int i = 0;
        Node parent = node.getParent();
        while (parent != null) {
            parent = parent.getParent();
            i++;
        }
        return i;
    }

    /**
     * Check if node matchs the XPath.
     * 
     * @param node
     *            The node.
     * @param xpath
     *            The xpath.
     * @return true, if matched, false, otherwise.
     */
    public static boolean matches(Node node, String xpath) {
        return node.getDocument().query(xpath).contains(node);
    }

    /**
     * Check if a node is a table.
     * 
     * @param node
     *            The node.
     * @return true, if is a table, false, otherwise.
     */
    public static boolean isTable(Node node) {
        return node instanceof Element && "table".equalsIgnoreCase(((Element) node).getQualifiedName());
    }

    /**
     * Creates a table adapter for the given node.
     * 
     * @param node
     *            The node.
     * @return The adapter.
     */
    public static TableAdapter newTableAdapter(Node node) {
        if (!isTable(node)) {
            throw new IllegalArgumentException("Node is not a table.");
        }
        return new TableAdapter((Element) node);
    }

    /**
     * Creates a element adapter for the given node.
     * 
     * @param node
     *            The node.
     * @return The adapter.
     */
    public static INodeHolder newNodeHolder(Node node) {
        return new NodeHolder(node);
    }

    /**
     * Get highest descendant node with class 'CSS_LEFT'.
     * 
     * @param root
     *            The root.
     * @return The node, if exist.
     * @throws PluginException
     *             If node does not exist.
     */
    public static Node getLeft(Node root) throws PluginException {
        return getCssNode(root, CSS_LETF);
    }

    /**
     * Get highest descendant node with class 'CSS_RIGHT'.
     * 
     * @param root
     *            The root.
     * @return The node, if exist.
     * @throws PluginException
     *             If node does not exist.
     */
    public static Node getRight(Node root) throws PluginException {
        return getCssNode(root, CSS_RIGHT);
    }

    /**
     * Get the highest node with the style given.
     * 
     * @param root
     *            The root node.
     * @param css
     *            The expected css.
     * @return The expected node.
     * @throws PluginException
     *             If child with css does not exist.
     */
    public static Node getCssNode(Node root, String css) throws PluginException {
        Nodes exps = root.query("descendant::*[contains(@class,'" + css + "')]");
        Node expected = UtilNode.getHighest(exps);
        if (expected == null) {
            throw new PluginException("Expected value not found. Missing a element with class='" + css + "' in element:" + root.toXML());
        }
        return expected;
    }

    /**
     * Check if a node is of a given tag type.
     * 
     * @param node
     *            The node.
     * @param tag
     *            The tag.
     * @return true, if is element of given tag name, false, otherwise.
     */
    public static boolean isElement(Node node, String tag) {
        if (node instanceof Element) {
            return (((Element) node).getQualifiedName().equals(tag));
        }
        return false;
    }
}