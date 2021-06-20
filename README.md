# Changelog

## 1.5.18
 - Filtering tests scenarios by using flags: ``-DfilterTests=regression,ui,etc...``
 [#97](https://github.com/thiagolvlsantos/specrunner/issues/97)  

**IMPORTANTE NOTE**: Due to Sonatype changes **the Specrunner groupId had to change to ``io.github.thiagolvlsantos``**. 

To use this new version replace **groupId** by:

```xml
    <groupId>io.github.thiagolvlsantos</groupId>
    <artifactId>specrunner-XXX</artifactId>
    <version>1.5.18</version>
```
Java packages inside the library have not changed! The only expected change to your project is the ``groupId`` reference. I decided to **not change major version** because running code is not affected, I mean, there is a backward compatibility.

## 1.5.17
- Upgrade jodatime to 2.10 [#96](https://github.com/thiagolvlsantos/specrunner/issues/96) 

## 1.5.16
- Add support for <given><when><then> [#92](https://github.com/thiagolvlsantos/specrunner/issues/92) 

## 1.5.15

- Register should not reorder columns for IIdGenerator keys [#87](https://github.com/thiagolvlsantos/specrunner/issues/87)
- Add bind(clazz,key,instance) to IObjectManager [#91](https://github.com/thiagolvlsantos/specrunner/issues/91)

## 1.5.14
-  compareTree should not require include to be 'expanded' should expand automatically [#85](https://github.com/thiagolvlsantos/specrunner/issues/85)
-  compareTree bug on local parameters for inclusion [#84](https://github.com/thiagolvlsantos/specrunner/issues/84).
	- Behavior as expected.
-  Enable joined plugin to accept, for example, deletions in reverse order [#86](https://github.com/thiagolvlsantos/specrunner/issues/86)
	- When using 'joined' the attribute 'reverse' can be set to true to expand tables in reverse order.

## 1.5.13
	Workaround on Maven repository problems:
		404 - Not Found
		The path /org/specrunner/specrunner-core/1.5.12/specrunner-core-1.5.12.jar is cached until 2017-10-31T02:30:32.073Z as not found in repository M2Repository(id=central-proxy)

## 1.5.12
-  Add log information to property comparisons to discriminate objects under analysis. [#83](https://github.com/thiagolvlsantos/specrunner/issues/83)
	- Bug was related to ICache, and was fixed. Extended log is not required anymore.
-  Update PluginJoined to comply with 'caption' and 'action' patterns of database actions. [#82](https://github.com/thiagolvlsantos/specrunner/issues/82)
-  Change 'include' style 'collapse' to avoid Bootstrap conflicts [#81](https://github.com/thiagolvlsantos/specrunner/issues/81)

## 1.5.11
-  Support to 'caption' attributes to tables [#80](https://github.com/thiagolvlsantos/specrunner/issues/80)
-  Disable @Sentence required to use @Synonyms and not accept "" (empty string) as pattern [#79](https://github.com/thiagolvlsantos/specrunner/issues/79)
-  Support enable or disable scenario listeners in HTML [#78](https://github.com/thiagolvlsantos/specrunner/issues/78)
-  Support ignore="true" in database actions [#77](https://github.com/thiagolvlsantos/specrunner/issues/77)
-  Support for default actions in databases information [#76](https://github.com/thiagolvlsantos/specrunner/issues/76)

## 1.5.10 
-  Converter priority over any type information [#75](https://github.com/thiagolvlsantos/specrunner/issues/75)

## 1.5.09
-  ArrayIndexOutOfRange in AbstractPluginObject line 1211 [#74](https://github.com/thiagolvlsantos/specrunner/issues/74)

## 1.5.08
-  Add 'ignore=true' options for AbstractPluginObject [#73](https://github.com/thiagolvlsantos/specrunner/issues/73)
-  On object creation specify collection type or enable use of 'Collection' [#71](https://github.com/thiagolvlsantos/specrunner/issues/71)

## 1.5.07
-  Make verifyRows behave as verifyObject on 'value' recover. [#62](https://github.com/thiagolvlsantos/specrunner/issues/62)
-  verifyObject NullPointer on invalid feature names. [#63](https://github.com/thiagolvlsantos/specrunner/issues/63)

## 1.5.06
-  Create a plugin to verify objects hierachies [#61](https://github.com/thiagolvlsantos/specrunner/issues/61)

## 1.5.05
-   Limit to string errors in JUnit getMessage() [#58](https://github.com/thiagolvlsantos/specrunner/issues/58)
-   Add an annotation with condicional for test executions [#60](https://github.com/thiagolvlsantos/specrunner/issues/60)

## 1.5.04
-   Remove calls to getValue() [#59](https://github.com/thiagolvlsantos/specrunner/issues/59)

## 1.5.03
-  Enable evaluation of formatter parameters [#54](https://github.com/thiagolvlsantos/specrunner/issues/54)
-  Enable type="date" in web profiles compare using comparators [#55](https://github.com/thiagolvlsantos/specrunner/issues/55)

## 1.5.02
-  Fire events objects only if there are listeners [#53](https://github.com/thiagolvlsantos/specrunner/issues/53)
-  Fix ComparatorTime to work with LocalDateTime class family [#52](https://github.com/thiagolvlsantos/specrunner/issues/52)

## 1.5.01 
-  Upgrade schemacrawler to java7 version. [#51](https://github.com/thiagolvlsantos/specrunner/issues/51)

## 1.5.00
-  Upgrade to jdk## 1.7 [#7](https://github.com/thiagolvlsantos/specrunner/issues/7)

## 1.4.70
-  Repository update failed on previous release.

## 1.4.69
-  On AbstractPluginObject load of fields, check if eval is enabled. [#50](https://github.com/thiagolvlsantos/specrunner/issues/50)

## 1.4.68
-  Make data parsers return null when empty string is passed [#49](https://github.com/thiagolvlsantos/specrunner/issues/49)

## 1.4.67
-  Add plugin 'repeat' for tables to replicate data from header fields to lines [#48](https://github.com/thiagolvlsantos/specrunner/issues/48)
-  On object plugins copy information of other header attributes. [#46](https://github.com/thiagolvlsantos/specrunner/issues/46)
-  Allow objins without reference="" [#45](https://github.com/thiagolvlsantos/specrunner/issues/45)

## 1.4.66
-  String converters family extension [#44](https://github.com/thiagolvlsantos/specrunner/issues/44)
-  Enable ``@null``, ``@empty`` for objins family plugin. [#43](https://github.com/thiagolvlsantos/specrunner/issues/43)

## 1.4.65
-  Update idmanager on 'updates' [#42](https://github.com/thiagolvlsantos/specrunner/issues/42)

## 1.4.64
-  Create a clob converter [#37](https://github.com/thiagolvlsantos/specrunner/issues/37)
-  Create a blob converter [#38](https://github.com/thiagolvlsantos/specrunner/issues/38)
-  Create a reader of URL [#40](https://github.com/thiagolvlsantos/specrunner/issues/40)

## 1.4.63
-  Double calling on attribute value for 'variables' (``global|local|execute|set``) [#35](https://github.com/thiagolvlsantos/specrunner/issues/35)
-  Better error support for errors inside callings to 'value=...' [#36](https://github.com/thiagolvlsantos/specrunner/issues/36)

## 1.4.62
-  Allow converters from same type to same type [#34](https://github.com/thiagolvlsantos/specrunner/issues/34)
-  Adjust debug styles for scenarios. [#33](https://github.com/thiagolvlsantos/specrunner/issues/33)

## 1.4.61
-  Create a blob comparator [#30](https://github.com/thiagolvlsantos/specrunner/issues/30)
-  Create a bytes converter [#32](https://github.com/thiagolvlsantos/specrunner/issues/32)

## 1.4.60
-  Add converter to 'LocalDateTime' type. [#29](https://github.com/thiagolvlsantos/specrunner/issues/29)

## 1.4.59
-  Add more boolean converters enhancement [#28](https://github.com/thiagolvlsantos/specrunner/issues/28)
-  Add 'ignore=true' feature to plugin column. enhancement [#26](https://github.com/thiagolvlsantos/specrunner/issues/26)
-  Adjust time information. [#25](https://github.com/thiagolvlsantos/specrunner/issues/25)
-  Add release method to IStatementFactory interface to perform after pstmt usage [#24](https://github.com/thiagolvlsantos/specrunner/issues/24)

## 1.4.58
-  Add 'ignore' to prepare/verify plugins. [#22](https://github.com/thiagolvlsantos/specrunner/issues/22)

## 1.4.57
-  Make 'execute' protected in scenario listener. [#21](https://github.com/thiagolvlsantos/specrunner/issues/21)
-  Remove title atribute setttings (refactoring of getPath(...)) for scenarios. [#17](https://github.com/thiagolvlsantos/specrunner/issues/17)
-  Define a tag interface to exceptions where stack traces are irrelevant to error undestanding [#20](https://github.com/thiagolvlsantos/specrunner/issues/20)
	- UnstackedException interface created.
-  Cache settings on AbstractCacheFactory [#18](https://github.com/thiagolvlsantos/specrunner/issues/18)
-  Create a <jetty/> plugin. [#6](https://github.com/thiagolvlsantos/specrunner/issues/6)
	- done.
-  sysout - on scenario boundaries [#3](https://github.com/thiagolvlsantos/specrunner/issues/3)
	- INFO level output for scenarios.
-  Add minimize icon to JFrame dialogs. [#4](https://github.com/thiagolvlsantos/specrunner/issues/4)
	- Set resize added.

## 1.4.56
-  Ajuste nos nomes dos subcenários;
-  Usar um método como ``<value='$THIS.getValor(;...)'>`` e tentar não avaliar o conteúdo do ``<td>`` para long ao usar o eval='false';
	- Criado o atributo 'ceval' para indicar nos casos de 'forceContent=true' se deve-se ou não avaliar o conteúdo.

## 1.4.55
-  correção do conversor ``'do'`` para ignorar hora/minuto/segundo.

## 1.4.54
-  Adicionar o contexto do teste ao IObjectCreator, e também o header da tabela de onde está se trabalhando, colocando métodos de busca indexada por nome de coluna, se for o caso;
	(Sem métodos indexados pelos strings, por enquanto.)
-  Na propriedades de uma coluna caso o campo 'field' exista e termine por ponto (.) colocar o conteúdo da coluna como sufixo do campo;
-  Quebrar os métodos de conversão de enumeração para facilitar reuso e criar um que use o name como referência;
-  Verificar o aninhamento de cenário para pegar o nome completo morro acima;
-  ajustar o date only p sumir com os milisegundos;
-  testar lombok;
	- Funcionando.
-  Bugs fix para argumentos de conversores e formatadores no plugin de objetos.

## 1.4.53
-  Valor default para 'sr.threadsafe' passou para false, para minimizar problemas rodando teste web multi-thread.
-  Macros passam a ser globais por padrão.
-  ObjectManagerCleaner adicionado.
-  Interface do IObjectManager modificado para facilitar utilização em Stubs de sistema.

## 1.4.52
-  Bug fix dos providers de conexões.

## 1.4.51
-  Colocar os PluginDbms/etc para aceitar na conexões a class do provider, ou instancias de datasource providers.

## 1.4.50
-  Criar o formatter template de datas/jodatime;

## 1.4.49
-  Corrigir o estilo do 'ResumeDumperHtml' linha 258;
-  Adicionar o conceito de formatter no DatabaseDefault no método protected Value getValue(...), na colunas do banco, foi setado na coluna mas não foi usado para formatar;

## 1.4.48
-  Reduzir o nome dos arquivos de recursos usados (de specrunner.css,... para sr.css) e (specrunner_default.css para sr_d.css)... ;
-  Colocar o mapping de objetos para ter herança (i.e. supermapping="file.hml") busca o pai para carregar antes do filho;

## 1.4.47
-  No StringNormalizerDefault corrigir o normalize para fica nullsafe.

## 1.4.46
-  Correçao do verifyRows para ser somente no primeiro nível de tr e th/tds;
-  Bug fix do leitor de arquivos para não ter problemas em ambientes Linux.

## 1.4.45
-  Bug fix de expressões;

## 1.4.44
-  Rever o scape de $ para ter certeza que a saída é apenas o $ mantido - o comportamento esperado é que ao substituir devemos ter sempre o original caso não haja execução bem sucedida da expressão interna;
-  Refactoring to processador de String para substituir expressões dentro de '${}'

## 1.4.43
- Ajuste do Copyright;
- Criar um reader de arquivos, que aceiti referência relativa via href:
	-  GetValue deve receber o contexto para poder ser relativo;
	-  No processamento de banco de dados há uma substituição pelo valor a ser usado no node holder, deve-se ignorar isso, o reader deve dizer se deve-se ou não avaliar o conteúdo após a leitura, e se deve substituir a apresentação;

## 1.4.42
-  Monte de remoção de private;
-  Formatação comparativa de objetos de diferentes tipos acionada para o PluginEquals.
-  Verificar o caso onde se tem vararg mas não há conversor e se passa uma lista de valores não convertidos;
-  Após a remoção dos modais de plugin pause e plugin error o teste não está mais parando esperando continuar. Seria o caso de colocar uma features indicando se deveria ser modal ou não no dois casos? Parece que sim, com default em modal=true.

## 1.4.41
-  Corrigir o plugin equals para caso ele não ter uma propriedade usar o campo value como base da comparação e o texto como esperado;
	-  É preciso analisar o contexto no getByName para pegar o valor dele com null caso exista perguntando primeiro e containsKey e se tiver pode ser se nulo o resultado;
	-  Depois disso analisar o que o avaliador de expressões faz quando a expressão é inválida para o analisador: deve-se lançar exceção dizendo que o valor não foi aceito pelo ExpressionItem e não retornando nulo, afinal nulo pode ser um valor válido pós avaliação, depois deve-se verificar que o os item de expressões não de deveriam lançar exceções quando o pedido de avaliação seja 'silent=true'.
-  Colocar a possibilidade de aceitar nulos como paths em feature, e também a possibilidade de não haver a propriedade como uma feature do NodeHolder;
-  Corrigir a nomenclatura das variáveis temporárias do getLocalArguments;

## 1.4.40
-  Features para tratamentos de null e propriedades inválidas nos atributos 'property'.

## 1.4.39
-  Corrigir o NodeHolder;
-  Corrigir a ordem do received e expected no PluginEquals;
-  No plugin verify só sobrescrever atributos que não existam no td, e no caso de 'class' adicionar ao final caso exista;
-  Verificar a sobreposição de conversores em plugins do tipo 'eq', principalmente quando falamos de campos de data;
-  Correção do plugin attribute;

## 1.4.38
-  Corrigir a conversão de parâmetros para aceitar nulo como resultado possível. Removendo o !type.instanceOf(valor) do if final pós-conversão no prepareArguments.
-  Fazer o código de verifyrows que acessa propriedades considerar nulo quando o path até uma propriedade simplesmente não existir,
-  Quando o 'pluginEquals' usar uma property e um pode-se obter o value usando converters, verificar via testes se é assim mesmo (provavelmente o problema do path null é resolvido aqui também);
	- Colocar o eq para entender 'getObject', fazendo conversão e verificando nulos como ``<span class="eq" value="null">@null</span>``
	- Analisar o pluginEquals para comparação usando valores @null;

## 1.4.37
-  Colocar ignore para os rows de um verifyRows, de forma que o header possa ter agrupamentos ou footers.
-  Porque não verifyRow com execução ao final (onEnd)?
	- Não será feito para manter compatibilidade com verifyrows to concordion. Será que vale a pena mesmo manter essa compatibilidade?
-  No prepareMethodArguments considerar o caso onde o elemento (0) do método vararg é nulo (exemplo ``<span class="sentence">"@null"</span>``).
-  Remover o 'ignore event' de include dentro de definição de macro.
-  Ajustando contagem de cenários 'skip'|'pending'.
-  Split de método para facilitar a troca do scenario listener de limpeza.

## 1.4.36
-  Devolver o getMethods() do UtilAnnotations, no lugar do declared methods, ou fazer uma busca recursiva para os métodos;
-  Revisar todo o código do JUnit para remover os private;
-  Fazer o plugin sentence poder receber varargs. exemplo public void setCategorias (String... nomes){}
-  Adicionar a exceção gerada no caso de erro das invocações do PluginSentence como resultado apontado pelo 'name';
	- Não será feito.

## 1.4.35
-  Bug de conversores de tempo que estava considerando apenas tempos futuros nos +/- alguma coisa;
-  verificar se tem como colocar o padrão datas +- algo nos preenchimentos de dados em interface gráfica; por exemplo nno compareDate, ou compareTable com data especificando apenas o formato de comparação, sem necessidade de 'plusDays(...)/etc'
	- Observei que posso fazer isso usando o campo format, para usar apenas o conversor e transformar a data para string usando o formatador genérico do tipo com o formato definido em 'format', isso vai permitir o uso de coisas do tipo ``<td convert="t" type="date" format="dd/MM/yyyy HH:mm:ss">data atual + 10 min</td>;``
-  Lançar erro quando se usar uma anotação associada a métodos que não são públicos;
-  Colocar o eval para o pluginSentece de forma que ele não converta automaticamente os valores strings caso não seja de interesse (default é analisar);
	- Não será feito.
-  Colocar os @null e @empty como parte dos valores de expressões;
-  Corrigir o PluginAtt, está errado ele está pegando o valor da propriedade no campo attribute e não o nome do campo;
	- reteste mostrou funcionamento correto sem precisar alterar o código.
-  Remover o modal do ErroFrame;
-  Colocar como Monospaced a fonte;

## 1.4.34
-  Suporte à escolha do leitor usado para obter o conteúdo a se usado como base para os conversores, agora é possível usar o ``reader='<algo>'`` para descrever como deve ser lido o texto, por exemplo, reader='xml' vai retornar o conteúdo XML da célula para uso pelos conversor.
-  Ajuste dos PluginDbms para terem features que permitam trocar a classe que implementa o IDatabase e assim permitir a redefinição simples dessas classes mesmo nos cenários de escopo negativo e positivo.

## 1.4.33
-  definido um extensor automático de condição de espera que adiciona um ``' and @version=<X>'`` nas condições de espera de um componente em tela, isso permite que o desenvolvedor ao realizar uma interação Ajax que mude a renderização do componente na tela possa perguntar qual versão é essa apresentada e assim conseguir esperar pela versão correta.

## 1.4.32
-  Corrigindo listeners, sempre chamando before e after.
-  Colocar o ajuste de timezone para os conversores de ConverterDateTimePatternArgs também, hoje somente para os que extendem o AbstractConverterTimezone;

## 1.4.31
-  Listeners chamando o afterScenario sem fazer o beforeScenario quando tem execute="true". Mudar para rodar o final apenas se o começo foi feito também;
-  Melhorar o suporte para internacionalização dos conversores: i.e. criar arquivos properties por cada tipo com texto em inglês/português/etc.
-  Arquivos de propriedades para os conversores de tempo: sr_converters_date.txt para padrões de data e sr_converters_time.txt para padrões de tempo;
-  Arquivos de propriedades para os campos +- de data, agora os incrementos ou decrementos de tempo podem ser feitos de forma customizavel através de arquivos de propriedades;
-  Corrigir o StringNormalizer: whitespace = false;
-  Colocar o esquema de data +- algo para todos os conversores de 'data atual', só está para o de DateTime e LocalDate por enquanto;

## 1.4.30
-  conversores +- tempo para DateTime e LocalDate criados.

## 1.4.29
-  Criar conversores de data com templates para coisas como 'data atual ((+|-) 30 (dias|meses|anos|horas|minutos|segundos|...)+' [criar teste mostrando como fazer];
-  Colocar o plugin sentence para salvar uma variável global com o resultado da execução, caso se defina um 'name' nela, isso permitirá fazer asserts mais facilmente no resultado recebido (estender o AbstractPluginScoped e fazer bind caso global caso não haja escopo definido) - [criar teste mostrando como fazer];
-  Lançar erro quando uma coluna for repetida no Input/Output do banco de dados, para evitar erro do desenvolvedor ao colocar a coluna repetida;

## 1.4.28
-  Verificar o PluginColumn quando tem o assert com final ?, em atributos javabeans, público funciona, método também;
-  No plugin Column Permitir incluir linhas que são apenas meta-descrições (como agrupadores de colunas, usando ignore);
-  Na comparação de bases ver que o último registro de expected não está sendo mostrado com pendente quando não há conformidade da base com o esperado;
-  Quando a coluna é uma enumeração, deve-se considerar o valor 'inverso' (textual) como base para o tamanho da coluna, ou coloca-se o código seguido da descrição textual limitada ao tamanho conhecido e com '...';
OK- Corrigir o load do URLResolver (retornar ao modelo original);
-  Corrigir um bug que no escopo negativo que é quando um campo tem valor default, mas o usuário quer ajustá-lo para null, ou seja, na base gabarito deveria ir null, mas está indo o valor default setado no arquivo de configuração do mapeamento.

## 1.4.27 
-  Corrigir o rows/cols do plugin table, está erradamente pulando ranges;
-  Criar um waitfor com múltiplas condições de espera. Sugestão separados por ';', ou separador customizado (features). Seria possível uma linguagem de expressões? Ou fazer features com prefixo/sufixo, ao invés de absolutas?
		- Implementado apenas com AND.
-  Fazer o PluginInclude ter os links dos arquivos originais de forma relativa à pasta de saída;
-  Colocar fundo e fonte fixos no tempo dos cenários;
-  Colocar mensagens de timezone para o escopo de trace;
	 R: Mantido em info, mas reduzida a quantidade, colocado apenas no momento do getZone() para colocar na cache.
-  Definir uma forma de chamar o método pelo nome usando o locat no webdriver wait. É possível fazer a chamada de qualquer método estático de ExpectedConditions que receba um 'By' como parâmetros facilmente.
-  Realizar uma implementação própria de URLResolver para resolver mais que 12 níveis;
	?? testes com 20 níveis funcionaram sem problemas.

## 1.4.26
-  Corrigir o pause on failure listener, ele está se perdendo quando se trata de um include com falhas, colocar todos atributos como protected;
-  Alterar o código do IListenerManager para fazer a remoção usando o getName() como referência,e não o equals do Java;
-  Usar http://stackoverflow.com/questions/10797663/removing-tail-of-x-elements-from-a-list para remover os elementos do final da lista de resultado;

## 1.4.25
-  Fazer o analisador e comparador de bases retornarem o relatório como string não fazer System.out;
-  Colocar o campo de 'nome da base' no evento de listener do banco, isso permite fazer um printlistener que filtre apenas as ações de uma base no sql-negative;
	-  Adicionar um getName na fonte de dados.
-  Aumentar o tamanho do campo 'status' no relatório para xx.xxx
-  Na apresentação de erro, verificar se existe o unwrap seria interessante, tem muita mensagem em volta dos errors.
-  Verificar se o valor está no range de índices. Colocado uma verificação de o número de colunas em tabelas de objetos é correspondente à quantidade de headers.
-  de private static final int TO_SECONDS = 1000; para protected;
-  Colocar o evento de click do navegador de erros para fazer o offset do erro ficar na posição esquerda e no topo da tela;
-  Colocar uma feature no include para remover o conteúdo incluído após a execução com sucesso de forma que a tela de resultado fique mais barata de ser exibida, deixando apenas o link para o arquivo original incluído efetivamente, isso acelera a execução dos testes, com menos dados para escrever na saída e também a visualização dos erros no arquivo de saída;
	- Default é não injetar.
-  Colocar o initialize no pluginfactory, expor na interface o initialize(); Chamar o método no momento do getClass(alias);
-  No PluginInclude colocar success na mensagem de que tudo foi bem sucedido;

## 1.4.24
-  criar o subgrupo specrunner-tools;
-  mudar o nome de specrunner-dbms para specrunner-tools-dbms;
-  Fixar o formato da data no header e colocar o tempo total de execução no final;
-  separar a criação do COnnectionDatabase em um método para permitir a redefinição de métodos;
	- Deixar mais reutilizável.
-  Validar arquivos de regras antes de executar o emparelhamento/carga dos bancos de dados;
-  Deixar dois métodos compare e dois métodos analyse para usar os arquivos de configuração padrão quando não forem fornecidos os listeners de tabela ou de coluna;
-  Criar abstrações para receber listas de arquivos de listeners, cada listener pode ter nomes e ser sobrescrito, desta forma podemos ter listeners redefinindo apenas o que for necessário
	- Nesse caso o método compare/analyse refebe algo como TableFiles(....) e ColumnFiles(....), ou o mesmo tipo DbmsFiles(...).
-  Trocar o isOptional por isMandatory() a semântica está invertida;
-  Remover o '	shade' da ferramenta, deixar ela como API mesmo, não precisa ser executável;
-  Colocar o base comparator para receber os arquivos de configuração dos listeners de tabelas e colunas (procurar diretamente e depois via classpath);
-  Criar dois perfis um de impressão completo e um de análise;
-  Finalizar os modelos de listeners em hierarquia com dump apenas se necessário;
-  testar tamanho apenas se forem campos de texto;
-  Criar o comparador de base e o extrator de esquema no perfil dbms usando o schemacrawler;
	- Usar um modelo de listeners para geração de reports customizados, por exemplo, no banco analisar que todo campo ID é chave estrangeira, que todo campo DH é timestamp, que todo campo IB deveria ser smallint, que todo campo campo DT é date;
	- Criar um jar executável que lê arquivo de configuração para carregar os listeners de relatório (isso vai permitir estender a ferramenta out of box);
	- Colocar o javasource para 1.7;

## 1.4.23
Refactorings.
	
## 1.4.22
-  Colocar uma feature para permitir usar ou não o execute="true", isso permitirá deixá-lo habilitado apenas nas execuções dos desenvolvedores, não na integração contínua;
-  PluginSentence linha 274, verificar se o startText != null;

## 1.4.21
-  Colocar o conversor de Enumerações no comando 'not equals' foi feito para o resto mais o not equals não foi;
	- Na verdade o problema é no método revert(....) da classe de template, que deve usar o array de template e não os args reais :)
	- Fazer o campo de template ser protected e não private.
-  Adicionando suporte à conversão reversa no Database select report.

## 1.4.20
-  Criar uma interface reversable converter e no caso do relatório de erros no compareTable usar a interface para fazer a conversão reversa quando for exibir o registro diferente;
	- Isso vai deixar o relatório final muito ninja para os tipos enumerados.
	- Incluidas também marcações para os campos key, reference, virtual, sequence, e date.
-  Colocar um boolean para definir se deve-se mostrar o stacktrace completo no resultado (isso agiliza bastante a exibição dos resultados);
	- Deixar como default exibir tudo.


## 1.4.19
-  Trocar o comando de click() pelo comando:
	```java
	protected void prepare(WebDriver client, WebElement tmp) {
        	Point location = tmp.getLocation();
	        ((JavaExecutor) client).execute("window.scrollTo(" + location.getX() + "," + location.getY() + ")");
	    }
	```
	Usar uma interface para definir como qualquer elemento será preparado para uso antes da ação acontecer e colocar isso no pluginfind.

## 1.4.18
-  Na cache de s deve-se perguntar se o SQL é não vazio;
NÃO - fazer o reuso do connection/statement no database.
-  Resolver os bugs do isDisplayed() no WebDriver.
	Fiz o comparador clicar nos ths/tds antes de perguntar se isDisplayed(), no Chorme isso se mostrou eficaz para realizar o scroll automático, se não funcionar será necessário usar a posição X,Y do component e mandar o WebDriver executar um script de scrollTo.

## 1.4.17
-  Colocar initialize() nos IComparator de PluginCompareBase. Isso valor para toda vez que se quiser fazer qualquer comparação deve-se chamar o initialize antes.
-  Fazer o @BeforeScenario e @AfterScenario poderem chamar método com o contexto, e contexto e resultado;
-  Criar o listener que verifica o banco de dados no final apenas ou apenas no começo;
-  Criar uma cache de  SQL para o mesmo contexto - Lembrar que nesse caso não se pode ter dados binários e também que deve-se ter uma tolerância de tempo maior.
	- Pode-se usar um MD5 para o texto da tabela para verificar se ela já foi calculada alguma vez, se sim usa-se a cache para executar o  associado. 
		Essa cache presente no DatabaseDefault deve ser limpa entre contextos diferentes de execução.
	Implementada usando o toXML() para ser a chave do mapeamento, se isso for muito caro pode-se usar o MD5 no lugar, isso foi apenas para economizar custo de processamento, com objetivo de deixar mais rápido em detrimento à memória. 
         Tanto a cache quanto o md5 estão desabilitados de cara, sendo necessário habilitar, na versão 2.0 pode ser que isso seja padrão, depende dos testes em cenários reais.

## 1.4.16
-  Baixar o memory analyzer Java (RCP ou dentro do Luna), e ver a questão de criação de clones das especificações, conferir que todos os resultados estão sendo liberados ao longo das execuções, sem manutenção completa em memória para não detonar a heap;
	- O problema é executor que está guardando referências para os listeners, deve-se liberar as referências após a execução dos testes.
	```java
		@Override
		protected void runChild(FrameworkMethod method, RunNotifier notifier) {
			if (method == fakeMethod) {
				super.runChild(method, notifier);
				free();
			}
		}

		protected void free() {
			notifier = null;
			fakeMethod = null;
			listeners = null;
			instance = null;
			statement = null;
		}
	```
-  Definir um 'execute="true"'' que será colocado como prioridade em relação aos pending, ou seja, se houver algo com execute 'true' então os demais devem ser considerados pending='true' automagicamente, de forma a rodar apenas 1 cenário selecionado;

## 1.4.15
-  No header do HTML colocar a quantidade de testes com status igual ao status geral da execução.
-  Nos plugin de objetcs só colocar title="X" se o texto dentro dos tds não for "X" (reduz a quantidade de dados na saída);
NO - Adicionar um title 'CENÁRIO IGNORADO' quando for o caso
	Denecessário.
-  Testar melhor o valor de campo quando preenchido com property='x.atributo' ao invés de value, tem que ser mais esperta a resolução;

## 1.4.14
-  Ajuste do bug de relatório HTML final;
-  Realizar update em bloco;
-  remover o comentário de onTableIn no DatabasePrintListener
-  Fazer o lookup de tabelas e campos ser realizado em duas etapas, primeiro pelo alias, se não achar procupar pelo name da entidade no banco, isso permite usar alias ou names nas especificações sem problemas;
-  remover também os acentos dos nomes das tabelas normalizadas no esquema para evitar problemas bestas de acentuação;
-  Jogar sempre os js e css de saída na saída, senão os updates da ferramenta não terão efeito visual. A menos que seja feito sempre o clean da pasta de saida no build do projeto, por exemplo, se a pasta for o target do maven deveria ser sempre removida;
-  Ajustar o verify rows para mostrar os valores excedentes recebidos nas consultas.

## 1.4.13
-  Criar o relatório de resumo das execuções dos testes (fazer por thread de execução, se for 'main' não precisa colocar sufixo no nome do relatório)
	Criar a tabela com todos os testes executados e seus respectivos resultados (versão HTML do relatório textual que é gerado atualmente), tudo linkado
	OK: tem que ser relativo senão não funciona no Jenkins/etc.

-  Quando realizar deleções em bloco não precisa ter campos id e(ou) quantitativo, afinal pode-se querer apagar todos os registros de uma tabela.

## 1.4.12
-  Cenários com ignore=true são tratados adequadamente.
-  Relatório HTML implementado, saída em 'target/output'.

## 1.4.11
-  Criar um tableadapter/rowadapter/celladapter factory;
-  Melhoras de performance escrevendo menos arquivos na saída.

## 1.4.10
-  Criar uma abstração que tenha valor, conversor/etc para usar no Column e não amarrar ao INodeHolder.
-  Colocar getObject(...,true) no reset de colunas, deve ser silenciosa a avaliação do campo 'value'.
-  Fazer o initialize do schema refazer o cálculo somente se mudar o objeto contexto (guardar o contexto velho no momento da chamada ao initialize, para evitar atributo desnecessário no código de Column);

## 1.4.09
OK- Colocar um boolean para saber se o default value é calculado no começo ou a cada uso (implicações de performance);
	Colocado para realizar reset dos valores default de um esquema toda as vezes que houver o reuso do schema;
-  No caso de registros extra ou faltando pode-se omitir as colunas cujo valor esperado seja nullo (por convenção) isso reduz a quantidade de elementos na tela e facilita a leitura.
-  Colocar o nome da coluna em outra linha no relatório textual e no web (alinhados à esquerda);
OK- Colocar um boolean para dizer se deve-se avaliar os argumentos fornecidos no getObject(), para usar no momento do getDefaultValue como uma feature, evitando assim avaliação desnecessária de expressões;
-  Criar um nodeholder factory;
-  Código estranho convertendo os argumentos e depois não usando eles:
	```java
	Object[] args = new Object[arguments.size()];
                for (int i = 0; i < arguments.size(); i++) {
                    args[i] = UtilEvaluator.evaluate(arguments.get(i), context, silent);
                }
                Object convert;
                try {
                    if (UtilLog.LOG.isTraceEnabled()) {
                        UtilLog.LOG.trace("Trying to convert '" + value + "' of type " + (value != null ? value.getClass() : " null") + " using " + converter + " with arguments: " + Arrays.toString(args));
                    }
                    convert = converter.convert(value, arguments.toArray());
                } catch (Exception e) {
                    throw new PluginException(e);
                }
	```
## 1.4.08
-  Imprimir a versão textual do relatório de não conformidades
	TODO: ajustar legibilidade do código, o cálculo do tamanho das colunas está obscuro.
-  Performance continuada dos perfis positive e negative;
	- Colocar 
	```java
	fm.add(PluginConnection.REUSE,true)
	fm.add(PluginSchemaLoader.FEATURE_PROVIDER, SchemaLoaderXOM.class.getName());
	```
-  ajustar estilo para
	```css
	table.sr_treport th.sr_lreport {
		color: black;
		white-space: nowrap;
	}
	```
-  Fazer um listener de cenário que faça sempre o compareBase no final, e o que limpa pode ser uma extensão dele, isso será usado para os testes de pesquisa ou detalhamento, por exemplo;
-  Calcular o valor default apenas quando for o momento de usar, isso tem impactado em testes de longa duração com esquema reusado.

## 1.4.07
-  Resolver os @ScenarioListener incluindos os da super classe, busca recursiva até o object;
-  Alinhar o caption do compareBase à esquerda;
-  No relatório de erro mostrar apenas as colunas conflitantes;
-  Isolar o filtro do prepare/verify do filter do compareBase senão não é possível popular a base com campos que devem ser desconsiderados na comparação final
	Obs: isso pode ser feito colocando-se o modo como parte da assinatura dos métodos filtrados, ou seja, se for modo input, output e compare já resolve.
-  ExpectedMessages aumentado para aceitar substring de mensagens para validação, usar sempre com sorted='true' para funcionar o atributo 'criteria'.
-  Criar os módulos de configuração padrão para os testes que queiram:
	- 1- Fazer testes sem escopo negativo - sem validação de counts; -> specrunner-sql-positive
	- 2- Fazer testes sem escopo negativo - com validação de counts; -> specrunner-sql-positive com o DatabaseCountListener
	- 3- Fazer testes com escopo negativo.                           -> specrunner-sql-negative
	
## 1.4.06
-  trocar a cor do alien;
-  Listener do módulo SQL que limpa a base e compara a base para cada cenario.
-  Fazer mais exemplos de escopo negativo, com tabelas distintas e campos faltando;
-  Não colocar 'order by' no compareBanco se não houver campos chave ou campo reference, usar somente se houver;
-  Colocar o failsafe no segundo grupo

## 1.4.05
-  Simplificar a verificação com escopo negativo (desenvolvedores só conseguem resolver de fato implementação com escopo negativo);
-  Permitir usar tabelas vazias nos prepare e verify, para que o strict funcione verificando que a tabela está vazia;
-  Rever a implementação do IWait que não ficou com a espera automática de campos em tela, tem algo errado no refactoring;

## 1.4.04
-  Colocar tabelas com ignore em colunas ou linha no teste web, de forma que se possa ter na aplicação uma tabela mais complexa que o desejado, e o teste se limitar a ver apenas um grupo de dados:
	- Isso também pode ser conseguido colocando-se o número de linha que se deseja verificar, de preferência por ranges de valores como na impressão de páginas
	- Exemplos:
		```html
		<table class="compareTable"></table> pega tudo
		<table class="compareTable" rows="1" cols="1;5..."></table> só a primeira linha da tabela desejada
		<table class="compareTable" rows="1;6"></table> a primeira e a sexta linha
		<table class="compareTable" rows="1-3;6"></table> da 1 à 3 e da 6;
		<table class="compareTable" rows="1-3;6-8"></table> da 1 à 3 e da 6 à 8;
		<table class="compareTable" rows="1-3;6..."></table> da 1 à 3 e da 6 ao final;
		<table class="compareTable" rows="...3;6..."></table> do início à 3 e da 6 ao final;
		```

## 1.4.03
-  Usar o IFilter na execução dos prepare/verify não apenas no compare base. Isso vai permitir postergar a implementação de requisitos complexos como logs.
	 - Filtrado e pintado.

-  Corrigir o inglês: Number of itens (10) in content is different from expected ones (9).
   - ITEMS... in field... é melhor.

-  Trocar o método getNormalized(....) por um normalizador delegado também, enfim tudo que puder ser delegado e transformado em feature é flexibilidade desejada.
     Criada a interface IStringNormalizer e o método UtilString.normalize deixou de ser estático.

-  Criar uma interface IWait para generalizar a espera pelo webdriver, isso permitirá usar diferentes estratégias sem precisar editar o código da superclasse.
    - Delegação ao invés de herança!

## 1.4.02
-  Bug fix nas ações web aninhadas.

## 1.4.01
-  Cada cenário chama @BeforeScenario e @AfterScenario antes e depois de executado.

## 1.4.00
-  Criação de tags: scenario e title dentro de ``<scenario>`` para os títulos;
-  Upgrade de bibliotecas;
-  Colocar o campo nome do elemento HTML para reduzir digitação
	- Exemplo:  ``<set-valor>dado necessario</set-valor>``
-  Colocar o campo nome junto do css para reduzir digitação
	- Exemplo:  ``<span class="set-valor">dado necessario</span>``
-  Fazer o controle de quantidade final de registros na base de dados usando contadores com dado que e por fim;
	- R: Usar o DatabaseCountListener
-  Colocar um destruidor de recursos que é realizado sempre que um contexto é dropado ou finalizado, isso permite por exemplo finalizar as sessionfactories que são usadas em apenas um teste ou fechar browsers abertos que foram esquecidos pelo testador. Lembrar de não fechar aqueles que são reusados.
	- R: adicionados listeners de contexto e de bloco.
-  Context populator é um listener de contexto;
	- R: populator removido e criado como listener

## 1.3.40
-  Colocar uma opção para adicionar o estilo de debug mesmo sem rodar no modo debug, se o código gerar os tempos de qualquer forma do contrário não serve para nada;
-  A ordem de execução dos listeners nos eventos finais (onEnd) deve ser feita na ordem reversa da inicialização (onStart).
-  Ajustando headers para 2014.

## 1.3.39
-  Colocar a verificação de que há duplicação de nomes/alias de tabelas e de nomes/alias e colunas;
	- R: restrição adicionada
-  Criar uma alias para poder usar por exemplo uma tabela 'Customers' mas na referência usar 'Customer'. :)
	- R: para usar outro nome na coluna é só colocar o atributo 'table=<nome da tabela>'.
-  Ajustar o tratamento de objects no mapeamento usando 'mapping';
	- R: redefinição de campos corrigida vide exemplo TestRedefinition.java
-  Layout de scenarios modificado:
	- R: usando padrão Concordion Plus.

## 1.3.38
-  Ajustes de ações de press/release key, criação de esc, tab e blur.
-  Adicionado listener de tempo para os cenários.

## 1.3.37
-  Criar um mecanismo automático para o waitfor ser injetado automaticamente antes de qualquer ação/comando a ser realizado em tela;
	- R: Default é sempre esperar agora quando o driver não é HtmlUnit
-  Colocar caption: 
	```java 
	FinderXPath.get().addStrategy("legenda", "//table/caption[contains(text(),'{0}')]/..");
	```
	- R: Adicionando 'caption' ao webdriver e ao htmlunit
-  Colocar para o teste raiz desconsiderar as janelas relacionadas aos erros dentro de cenários;
	- R: Agora os erros externos estão segregados dos cenários

## 1.3.36
-  No Database deve-se verificar se os valores (vazios) estão com null na base de dados, ou seja no modo output deve-se verificar as colunas com valores 'null'. Considerar o caso onde se deseja realmente verificar se o valor é String vazia. 
	* Para vazio usar ``@e``

## 1.3.35
-  O reuso de browser está criando sempre novas conexões WebConnectionFile, desta forma a cache de arquivos não é reutilizada entre testes, apenas dentro do mesmo teste, o que não gera o ganho de performance geral desejado, corrigir.
-  ver se os pending estão sendo notificados corretamente pelos listeners de execução junit.
-  Colocar 4 caracteres nos valores de status:
```
+---------------- TXT (STATUS ORDER)---------------------+
                      [# |  TIME (ms) |       % | ON                       | STATUS          | ASSERTS    | INPUT <-> OUTPUT
                      5 |      21584 |   23,11 | 2014-06-27 22:37:32.233  | success 4729/4729 | 14/14      | D:\ThiagoSantos\projetos\AUTRAN\TRUNK\Modelos_e_Implementacao\Java\autran\negocio\target\test-classes\br\gov\bcb\autran\crt2\dominio\concessao\TestCadastroConcessaoGrupo.html <-> D:\ThiagoSantos\projetos\AUTRAN\TRUNK\Modelos_e_Implementacao\Java\autran\negocio\target\output\br\gov\bcb\autran\crt2\dominio\concessao\TestCadastroConcessaoGrupo.html
```

## 1.3.34
-  Rever necessidade de gerar screenshoot de cada célula de uma tabela inválida, afinal a tabela é a mesma, só está custando mais gerar os arquivos.
-  Integrar a execução via HTML unit com suas otimizações (i.e. cache de arquivos) dentro do perfil do webdriver quando ele usar o HTMLUnit;

## 1.3.33
-  Corrigir o timeout padrão do webdriver, o maxwait é dado em segundos e não em milisegundos;
-  Colocar uns fire listeners nos cenários JUnit a medida que forem passando (falhando).

## 1.3.32
-  Criar um "cuspidor de SQL" para gerar avulsos a partir dos testes (por exemplo, o de parâmetros de sistema);
-  BUG: nos plugins que estendem AbstractPluginFind há falso positivo quando os elementos desejados não são encontrados, por exemplo, um enabled/disabled de um checkbox que não existe na tela.
	- Ou seja, nos elementos que permitem ações sobre múltiplos componentes deve-se verificar se foi encontrado pelo menos 1, do contrário lançar erro.
-  CSS: Colocar fundo branco no grupo de detalhamento do resultado;
-  JS: Colocar para a exceção fazer scroll para a posição dela na tela, e no canto esquerdo.

## 1.3.31
-  colocar uma campo de mensagem nas anotações pause, exemplos:
	``<pause msg="parei aqui"/>``, ``<span class="pause" msg="parei aqui"/>``,``<span pause="parei aqui"/>``.
-  Transformar o pause em um frame independente feito o errors messages, para ele aparecer independentemente do Eclipse, o que facilita a visão do option.

## 1.3.30
-  Fazer os campos de select selecionarem, ou verificarem os itens de forma normalizada (mas podendo escolher se não normaliza, default sempre normaliza), isso evita muito falso negativo;

## 1.3.29
-  quando houver erro no plugin sentence, mostrar sempre a exceção encapsulada que tiver o tipo diferente de runtime, ou que seja do tipo IPresentation;
-  o Runner só deve fazer sleep/wait para ações que não são 'nop';

## 1.3.28
-  Ver a questão do assert de tela ser feito usando os próprios componentes visuais (exemplo: select) - usado estratégia do 'as=<tipo>';
-  Corrigir o código de URI.resolve para aceitar mais que 12 níveis de '../' (http://www.ietf.org/rfc/rfc2396.txt  - Seção 5.2);
    Nesse ponto adicionei um IResolver para usar a estratégia que quiser além do URI.resolve(...);

## 1.3.27
-  Melhorando a estratégia de JOINED com nomes de tabelas, CSS e tratamento de erro instrutivo.

## 1.3.26
-  Criar uma estratégia para representar tabelas JOINED do hibernate usando apenas uma tabela única, agregando nela todos os atributos das demais tabelas, na verdade é fazer algo como o secondary table funcionar no nível da especificação. (usar a combinação de colgroup com transformador).

## 1.3.25
-  Adicionar uma feature para ignorar determinados status ou comand types, por exemplo, ignorar os warnings no anotador de saída.
-  Adicionar o navegador de errors na tela. (Java).
-  Melhor deixar (colocar só um title?)! - Colocar o warning para não gerar botão de expansão; -> Decidi permitir filtrar os IResult direto no result set.

## 1.3.24
-  No momento que der erro de comparação com os dados da base, mostrar dentro do parênteses o valor que veio da base, e não o valor já da tela, 
-  Bem como no caso de clobs mostrar a comparação com strings e não to toString() do clob para se saber qual o conteúdo.

## 1.3.23.
-  Formatação e numeração dos botões de acordo com o tipo da ação.

## 1.3.22
-  Quando os valores de comparação de base não coincidirem colocar os tipos ao lado para facilitar a identificação dos erros;
-  No relatório de escopo negativo transformar os clobs em texto para exibição (colocar um boolean para indicar se deve ser assim ou não, pois pode haver sistemas que tenha clobs realmente grandes que não devem ser exibidos);
-  No relatório de escopo negativo usar texto ao invés de title e css para mostrar os campos das tabelas;
-  Corrigir o "protected void performUpdate(", ele deve sempre ter ou key ou reference para usar no WHERE, quando não tiver lancar um erro (não precisa, vai haver um update com set e where idênticos, aí aponta o erro de id/references);
-  Aumentar o nível de log para trace no ``"2014-04-14 13:24:24,144 [main] DEBUG on [FeatureManagerImpl.java,163] - Feature 'org.specrunner.listeners.core.PauseOnFailureNodeListener.condition' set to object 'org"``;

## 1.3.21
-  Testar escopo negativo apenas com reference;
-  Ver o enumerador de resultset, está dando falso positivo no escopo negativo.
-  Verificar se o virtual do comparador de bases funciona mesmo com update.
-  Parametrizar o PluginObjectManager para ser ThreadLocal ou não, isso é necessário nos testes envolvendo o Jetty que cria threads específicos para cada requisição.
-  Criar o conceito de listeners por cenários, para, por exemplo, limpar os objetos em memória.
-  Resolver o problema de timestamp Vs date na base de dados. Coloquei uma feature para timezone nos conversores date/timestamp.
-  Colocar o pause failure listener para ter o mesmo modelo de pausa condicionada de forna a não travar integração contínua;
-  Verificar o plugin sentence que não está aceitando apenas o argumento como texto;
-  Criar um comparador de tempo que aceite qualquer combinação de tipos date/timestamp/jodatime.
-  Criar um comparator de strings com trim e um normalizado para uso com o banco de dados;
-  Ver se é possível manter os valores de campos enumerados no resultado para facilitar a visualização
-  Ver uma estratégia para resolver registros de log de auditoria;
-  Colocar uma feature para habilitar ou não a pausa, de forma que no Linux, por exemplo, a pausa nunca seja executada p/não travar a integração contínua;
-  Fazer o plugindatabase poder escolher entre doStart e doEnd (in e out); Usando o doEnd;
-  Lançar erros quando cenários tiverem os mesmos nomes;
-  Reduzir o log do reuso de imagens no resultado para nível 'trace';
-  No uso de imagens idênticas no mesmo arquivo usar uma cache com o nome do gerado para economizar cópias na saída;
-  Ver porque que as imagens dentro de tables não não estão sendo copiadas para o destino dentro de compareTable;

-  targets ajustados para Linux
```
URI:file:/opt/java/hudson/workspace/disin.autran/web/target/test-classes/br/gov/bcb/autran/web/crt2/servidores.html
TARGET:/opt/java/hudson/workspace/disin.autran/web/target/test-classes/br/gov/bcb/autran/web/crt2/servidores.html
URI:jar:file:/opt/java/hudson/workspace/disin.autran/negocio/target/negocio-1.0.0-tests.jar!/objetos/servidor.html
TARGET:jar:file:/opt/java/hudson/workspace/disin.autran/negocio/target/negocio-1.0.0-tests.jar!/objetos/servidor.html
URI:file:/opt/java/hudson/workspace/disin.autran/web/target/test-classes/br/gov/bcb/autran/web/crt2/login/login.html
TARGET:/opt/java/hudson/workspace/disin.autran/web/target/test-classes/br/gov/bcb/autran/web/crt2/login/login.html
```

- Delegar a criação de:
	- 1- PageListeners;
    - 2-WritablePages  - OK feito!

para poder substituir quando quiser, o uso de herança inviabiliza a substituição.

-  O renaming de arquivos no Linux não funciona direito, substituir pelo código: FileUtils.moveDirectory(from, to); 

- Corrigir todo ponto de "file:" para deixar esperto o suficiente para funcionar em Linux (sources, includes, runners, etc) - unificar código para facilitar manutenção.
USAR como exemplo:
```java
-      URL location = clazz.getProtectionDomain().getCodeSource().getLocation();
        String str;
        try {
            URI ui = location.toURI();
            System.out.println("UI:" + ui);
            File file = new File(ui);
            str = file.toString();
            System.out.println("FILE:" + file);
            if (file.isDirectory()) {
                str = str + File.separator;
            }
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }
```
-  Corrigir os links do recursos (screen/source) para serem relativos ao arquivo de saída.
-  Colocar todas as caches de objetos como no mínimo protected para permitir reuso. 
- Trocar os valores dos campos na especificação também para as telas, assim com foi feito para o SQL, melhora a depuração; 
-  Fazer também no SQL depois que ele realizar a conversão, para melhorar a tela. 
-  MELHORAR O LEITOR DE  SQL; 

----------------------
CRÍTICAS:

- Criar um filtro de pacotes para a impressão das exceções, para reduzir logs inúteis escondendo por exemplo os do próprio junit.runners.*/etc.

- Adicionar a criação de subobjetos em cadastros de objetos com objins/etc:
	por exemplo i) colocar um atributo que seja uma coleção de strings, e ii) depois uma coleção de sub-objetos
?? - Adicionar a exceção gerada no caso de erro das invocações do PluginSentence como resultado apontado pelo 'name';
	Precisa?
- Colocar o access factory para PluginAbstractObject, e colocar field ou feature no campo a ser sensibilizado;
- Colocar parâmetros na chamada de macro feito tem em includes;
- Ver o verifyRows se tem como ficar + simples;
- Ver se tem como remover a pilha de erros do trace o próprio JUnit. Provavelmente se não anexar a causa ele não vai colocar a pilha, ver se é possível para reduzir o log quando a quanidade de erros for muito grande, o que dá erro no surefire report;
	
- Disponibilizar o proxy de jdbc dentro do pacote specrunner tools;

- Adicionar um modo DEBUG para o comparador de bases;

SPRING-BOOT:
- Ver as configurações do projeto para criar o spring boot sprunner que permitiria realizar testes automatizados usando trechos em HTML dispersos na aplicação
	- Tipo não precisar de um contexto complexo para rodar apenas a preparação da base de dados lendo de arquivos, por exemplo.


PRIORITÁRIAS:
- Criar um listener para transpor uma tabela escrita no formato
	<coluna><valor><valor>...
        <coluna><valor><valor>....
	para a coluna normal que temos hoje, e depois de rodar transpor de volta ao formato original para facilitar o debug.

- Seria possível generalizar a estratégia dos args (usada em PluginSentence) para plugins como PluginEquals?

- Encontrar formas de especificar condições de espera com coisas como tamanho de tabelas/etc [criar teste mostrando como fazer].

- Melhorar o formatador de colunas para calcular os tamanhos dos campos corretamente;

- Corrigir a referência para imagens/recursos que tenha espaço em branco no nome (fazer o URL enconding);


ALTA:
- Criar um conceito de objeto com atributos dinâmicos para gerar mapas de objetos (exemplo: um objeto onde os campos são na verdade um Map<Campo,Valor>)

- Fazer um esquema para chamar REST e verificar a resposta;

- Olhar o WaitPageToLoad (Selenesse);

- Criar um PluginConnection/PluginRollback para colocar a conexão no modo de autofush 'false' e limpar a base ao final de cada cenário (fazer isso para cada cenário).

- Criar cenários aninhados no JUnit runner;

- Analisar o PluginInclude para saber se ele está chamando o código do saveLocal no contexto na posição certa dos dados incluídos, para evitar variáveis estranhas;

- Colocar a lista de cenários no contexto, e se foi bem sucedido ou não. Para realizar o dump deles no relatório de saída TXT e HTML.

- Normalizar o valor default caso seja null, nos demais casos considerar o valor recebido mesmo (colocar algo para ele saber se deve testar case sensitive ou não);

- Criar um leitor de esquemas usando o SchemaCrawler, que gera um nu.xom.Document:
	- Generalizar o leitor de Document para receber um document no load, será usado no SchemaLoaderXML e no SchemaLoaderBase(a ser criado);
	- Criar um composite loader para usar a abordagem de realizar merge do que foi lido da base mais o que foi lido do arquivo, isso permitirá economizar escrita como os tipos básicos usados em cada coluna, campos de data, campos de chave, transformadores padrão, etc.

- Testar a combinação de HTMLUnit com Wicket6 para resolver o problema definitivamente.
	- Wicket 6 mudou o modelo de eventos e o JS do HtmlUnit se perdeu.

- Criar um plugin que faça a verificação de todas opções de um select e que faça também a verificação dos selecionados;
- Fazer o download do compare files no notepad++;

MÉDIA:
- Criar um modelo onde se possa definir os estados dos mocks no início e o estado deles no final para fazer escopo negativo de mocks também;

- No plugin sentence usar o exemplo <sentence>vai<arg>0002</arg></sentence>, e ver o que acontece:
	public void vai(String str) {
		// deveria receber a string sem fazer avaliação
	}
- Fazer o leitor de esquema a partir da base.
- Como fazer tabelas domínio? Como controlar o drop e create das tabelas sem precisar fazer isso com as tabelas domínio? Definir essa abordagem para economizar na execução dos testes.

BAIXA:
- Usar 'lazy creation' para tudo (principalmente os mapas).

- Criar uma cache para os conversores de enumeração para minimizar tempo de execução;

- Colocar o tipo SQL do campo no header relatório de comparar Base:
	http://stackoverflow.com/questions/6437790/jdbc-get-the-sql-type-name-from-java-sql-type-code

- Implementar um hbnsel para realizar select geral de objetos e ver se o conteúdo está lá completo;
	- Criar uma consulta antes e depois sair removendo à medida que se encontra os objetos, isso vai evitar também tapear usando o mesmo elemento no resultado:
		- Usar o HashBuilder nos campos para evitar pesquisar pelo mesmo elemento várias vezes;
- Implementar um verifyAll para realizar o select completo de uma tabela:
	- Fazer um select considerando campos de ordenação definidos na tabela: ``<table class="verifyAll" ...order="nome,telefone,data">...</table>``

- No caso de escopo negativo pintar os verify com status informativo, e não de sucesso? Fica bom?

- Usar o TableReport para falhas no escopo positivo (compensa fazer? Pensando bem acho que não):
	- Aqui pode-se usar o mesmo modelo de escopo positivo, a diferença é que testa-se apenas as tabelas que são informadas no por fim, apenas as perguntadas, usando-se inclusive a base auxiliar.
	- Se usar o filter para ignorar demais tabelas lembrar de fazer um AND com os métodos do filtro já existente.

- Criar o perfil specrunner-sql-select para fazer o teste final usando apenas os selects dos campos, sem necessidade de base extra, ou seja o que seria o ...-sql-positive hoje.
	- Só fazer se for feita a de cima também.

- criar o result que sempre aparece expandido de cara;

- Baixar o jailer;

- Trocar todos os UtilXXX por métodos não estáticos acessíveis a partir do SRServices, como foi feito com o IStringNormalizer.

- Colocar para não realizar eval de expressões somente se eval for false, usar como exemplo um nome de arquivo, com ';';
          ? Remover ou não as strings

- Fazer o plugin sentence trabalhar com features e não apenas métodos;

- Criar o conceito de composite action, para tarefas agrupadas, e o somatório ser segregado, bem com a exibição no relatório de debug. (Precisa?)

Exemplo de report:
```html
<html>

<head>
    < src="http://code.jquery.com/jquery-1.9.1.min.js"></>
    <>
	
	$( document ).ready(function() {
        $("body").click(function (e) {
				var show = e.target == document.getElementById("componente") 
					|| e.target.parentNode == document.getElementById("componente");
				if(show) {
					$("#componente").show();
				} else {
					show = e.target == document.getElementById("controle");
					if(show) {
						$("#componente").show();
						$("#componente").offset($("#controle").offset());
					} else {
						$("#componente").hide();
					}
				}
		});
    });

    </>
</head>

<style>
.sr_frame_link_div {
    background-color: white;
    padding: 5px;
    text-align: right;
    font-weight: bold;
    font-size: 10pt;
    font-family: verdana;
    /* always visible */
    border: 1px solid [#A2D9EF;
	display: none;
}
</style>

<p> </p>
<p> </p>
<p> </p>
<p> </p>
<p> </p>
<p> </p>
<p> </p>
<p> </p>
<p> </p>
<p> </p>
<p> </p>
<p> </p>
<p> </p>
<p> </p>
<p> </p>
<p> </p>
<p> </p>
<p> </p>
<p> </p>
<p> </p>
<p> </p>
<p> </p>
<p> </p>
<p> </p>
<p> </p>
<p> </p>
<p> </p>
<p> </p>
<p> </p>
<p> </p>
<p> </p>
<p> </p>
<p> </p>
<p> </p>
<p> </p>
<p> </p>

<div style="text-align:center;">
	<input type="button" id="controle" value="Mostrar"/>
</div>


<span class="sr_frame_link_div" id="componente">Estou <input type="radio" name="sex" value="male">AQUI<br></span>

</html>
```
