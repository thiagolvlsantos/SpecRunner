-----------------------------------------------------------
1.4.67
OK - On object plugins copy information of other header attributes. #46 https://github.com/thiagolvlsantos/specrunner/issues/46
OK - Allow objins without reference="" #45 https://github.com/thiagolvlsantos/specrunner/issues/45

1.4.66
OK - String converters family extension #44 https://github.com/thiagolvlsantos/specrunner/issues/44
OK - Enable @null, @empty for objins family plugin. #43 https://github.com/thiagolvlsantos/specrunner/issues/43

1.4.65
OK - Update idmanager on 'updates' #42 https://github.com/thiagolvlsantos/specrunner/issues/42

1.4.64
OK - Create a clob converter #37 https://github.com/thiagolvlsantos/specrunner/issues/37
OK - Create a blob converter #38 https://github.com/thiagolvlsantos/specrunner/issues/38
OK - Create a reader of URL #40 https://github.com/thiagolvlsantos/specrunner/issues/40

1.4.63
OK - Double calling on attribute value for 'variables' (global|local|execute|set) #35 https://github.com/thiagolvlsantos/specrunner/issues/35
OK - Better error support for errors inside callings to 'value=...' #36 https://github.com/thiagolvlsantos/specrunner/issues/36

1.4.62
OK - Allow converters from same type to same type #34 https://github.com/thiagolvlsantos/specrunner/issues/34
OK - Adjust debug styles for scenarios. #33 https://github.com/thiagolvlsantos/specrunner/issues/33

1.4.61
OK - Create a blob comparator #30 https://github.com/thiagolvlsantos/specrunner/issues/30
OK - Create a bytes converter #32 https://github.com/thiagolvlsantos/specrunner/issues/32

1.4.60
OK - Add converter to 'LocalDateTime' type. #29 https://github.com/thiagolvlsantos/specrunner/issues/29

1.4.59
OK - Add more boolean converters enhancement #28 https://github.com/thiagolvlsantos/specrunner/issues/28
OK - Add 'ignore=true' feature to plugin column. enhancement #26 https://github.com/thiagolvlsantos/specrunner/issues/26
OK - Adjust time information. #25 https://github.com/thiagolvlsantos/specrunner/issues/25
OK - Add release method to IStatementFactory interface to perform after pstmt usage #24 https://github.com/thiagolvlsantos/specrunner/issues/24

1.4.58
OK - Add 'ignore' to prepare/verify plugins. #22 https://github.com/thiagolvlsantos/specrunner/issues/22

1.4.57
OK - Make 'execute' protected in scenario listener. #21 https://github.com/thiagolvlsantos/specrunner/issues/21
OK - Remove title atribute setttings (refactoring of getPath(...)) for scenarios. #17 https://github.com/thiagolvlsantos/specrunner/issues/17
OK - Define a tag interface to exceptions where stack traces are irrelevant to error undestanding #20 https://github.com/thiagolvlsantos/specrunner/issues/20
	- UnstackedException interface created.
OK - Cache settings on AbstractCacheFactory #18 https://github.com/thiagolvlsantos/specrunner/issues/18
OK - Create a <jetty/> plugin. #6 https://github.com/thiagolvlsantos/specrunner/issues/6
	- done.
OK - sysout - on scenario boundaries #3 https://github.com/thiagolvlsantos/specrunner/issues/3
	- INFO level output for scenarios.
OK - Add minimize icon to JFrame dialogs. #4 https://github.com/thiagolvlsantos/specrunner/issues/4
	- Set resize added.

1.4.56
OK - Ajuste nos nomes dos subcen�rios;
OK - Usar um m�todo como <value='$THIS.getValor(;...)'> e tentar n�o avaliar o conte�do do <td> para long ao usar o eval='false';
	- Criado o atributo 'ceval' para indicar nos casos de 'forceContent=true' se deve-se ou n�o avaliar o conte�do.

1.4.55
OK - corre��o do conversor 'do' para ignorar hora/minuto/segundo.

1.4.54
OK - Adicionar o contexto do teste ao IObjectCreator, e tamb�m o header da tabela de onde est� se trabalhando, colocando m�todos de busca indexada por nome de coluna, se for o caso;
	(Sem m�todos indexados pelos strings, por enquanto.)
OK - Na propriedades de uma coluna caso o campo 'field' exista e termine por ponto (.) colocar o conte�do da coluna como sufixo do campo;
OK - Quebrar os m�todos de convers�o de enumera��o para facilitar reuso e criar um que use o name como refer�ncia;
OK - Verificar o aninhamento de cen�rio para pegar o nome completo morro acima;
OK - ajustar o date only p sumir com os milisegundos;
OK - testar lombok;
	- Funcionando.
OK - Bugs fix para argumentos de conversores e formatadores no plugin de objetos.

1.4.53
OK - Valor default para 'sr.threadsafe' passou para false, para minimizar problemas rodando teste web multi-thread.
OK - Macros passam a ser globais por padr�o.
OK - ObjectManagerCleaner adicionado.
OK - Interface do IObjectManager modificado para facilitar utiliza��o em Stubs de sistema.

1.4.52
OK - Bug fix dos providers de conex�es.

1.4.51
OK - Colocar os PluginDbms/etc para aceitar na conex�es a class do provider, ou instancias de datasource providers.

1.4.50
OK - Criar o formatter template de datas/jodatime;

1.4.49
OK - Corrigir o estilo do 'ResumeDumperHtml' linha 258;
OK - Adicionar o conceito de formatter no DatabaseDefault no m�todo protected Value getValue(...), na colunas do banco, foi setado na coluna mas n�o foi usado para formatar;

1.4.48
OK - Reduzir o nome dos arquivos de recursos usados (de specrunner.css,... para sr.css) e (specrunner_default.css para sr_d.css)... ;
OK - Colocar o mapping de objetos para ter heran�a (i.e. supermapping="file.hml") busca o pai para carregar antes do filho;

1.4.47
OK - No StringNormalizerDefault corrigir o normalize para fica nullsafe.

1.4.46
OK - Corre�ao do verifyRows para ser somente no primeiro n�vel de tr e th/tds;
OK - Bug fix do leitor de arquivos para n�o ter problemas em ambientes Linux.

1.4.45
OK - Bug fix de express�es;

1.4.44
OK - Rever o scape de $ para ter certeza que a sa�da � apenas o $ mantido - o comportamento esperado � que ao substituir devemos ter sempre o original caso n�o haja execu��o bem sucedida da express�o interna;
OK - Refactoring to processador de String para substituir express�es dentro de '${}'

1.4.43
- Ajuste do Copyright;
- Criar um reader de arquivos, que aceiti refer�ncia relativa via href:
	OK - GetValue deve receber o contexto para poder ser relativo;
	OK - No processamento de banco de dados h� uma substitui��o pelo valor a ser usado no node holder, deve-se ignorar isso, o reader deve dizer se deve-se ou n�o avaliar o conte�do ap�s a leitura, e se deve substituir a apresenta��o;

1.4.42
OK - Monte de remo��o de private;
OK - Formata��o comparativa de objetos de diferentes tipos acionada para o PluginEquals.
OK - Verificar o caso onde se tem vararg mas n�o h� conversor e se passa uma lista de valores n�o convertidos;
OK - Ap�s a remo��o dos modais de plugin pause e plugin error o teste n�o est� mais parando esperando continuar. Seria o caso de colocar uma features indicando se deveria ser modal ou n�o no dois casos? Parece que sim, com default em modal=true.

1.4.41
OK - Corrigir o plugin equals para caso ele n�o ter uma propriedade usar o campo value como base da compara��o e o texto como esperado;
	OK - � preciso analisar o contexto no getByName para pegar o valor dele com null caso exista perguntando primeiro e containsKey e se tiver pode ser se nulo o resultado;
	OK - Depois disso analisar o que o avaliador de express�es faz quando a express�o � inv�lida para o analisador: deve-se lan�ar exce��o dizendo que o valor n�o foi aceito pelo ExpressionItem e n�o retornando nulo, afinal nulo pode ser um valor v�lido p�s avalia��o, depois deve-se verificar que o os item de express�es n�o de deveriam lan�ar exce��es quando o pedido de avalia��o seja 'silent=true'.
OK - Colocar a possibilidade de aceitar nulos como paths em feature, e tamb�m a possibilidade de n�o haver a propriedade como uma feature do NodeHolder;
OK - Corrigir a nomenclatura das vari�veis tempor�rias do getLocalArguments;

1.4.40
OK - Features para tratamentos de null e propriedades inv�lidas nos atributos 'property'.

1.4.39
OK - Corrigir o NodeHolder;
OK - Corrigir a ordem do received e expected no PluginEquals;
OK - No plugin verify s� sobrescrever atributos que n�o existam no td, e no caso de 'class' adicionar ao final caso exista;
OK - Verificar a sobreposi��o de conversores em plugins do tipo 'eq', principalmente quando falamos de campos de data;
OK - Corre��o do plugin attribute;

1.4.38
OK - Corrigir a convers�o de par�metros para aceitar nulo como resultado poss�vel. Removendo o !type.instanceOf(valor) do if final p�s-convers�o no prepareArguments.
OK - Fazer o c�digo de verifyrows que acessa propriedades considerar nulo quando o path at� uma propriedade simplesmente n�o existir,
OK - Quando o 'pluginEquals' usar uma property e um pode-se obter o value usando converters, verificar via testes se � assim mesmo (provavelmente o problema do path null � resolvido aqui tamb�m);
	- Colocar o eq para entender 'getObject', fazendo convers�o e verificando nulos como <span class="eq" value="null">@null</span>
	- Analisar o pluginEquals para compara��o usando valores @null;

1.4.37
OK - Colocar ignore para os rows de um verifyRows, de forma que o header possa ter agrupamentos ou footers.
OK - Porque n�o verifyRow com execu��o ao final (onEnd)?
	- N�o ser� feito para manter compatibilidade com verifyrows to concordion. Ser� que vale a pena mesmo manter essa compatibilidade?
OK - No prepareMethodArguments considerar o caso onde o elemento (0) do m�todo vararg � nulo (exemplo <span class="sentence">"@null"</span>).
OK - Remover o 'ignore event' de include dentro de defini��o de macro.
OK - Ajustando contagem de cen�rios 'skip'|'pending'.
OK - Split de m�todo para facilitar a troca do scenario listener de limpeza.

1.4.36
OK - Devolver o getMethods() do UtilAnnotations, no lugar do declared methods, ou fazer uma busca recursiva para os m�todos;
OK - Revisar todo o c�digo do JUnit para remover os private;
OK - Fazer o plugin sentence poder receber varargs. exemplo public void setCategorias (String... nomes){}
OK - Adicionar a exce��o gerada no caso de erro das invoca��es do PluginSentence como resultado apontado pelo 'name';
	- N�o ser� feito.

1.4.35
OK - Bug de conversores de tempo que estava considerando apenas tempos futuros nos +/- alguma coisa;
OK - verificar se tem como colocar o padr�o datas +- algo nos preenchimentos de dados em interface gr�fica; por exemplo nno compareDate, ou compareTable com data especificando apenas o formato de compara��o, sem necessidade de 'plusDays(...)/etc'
	- Observei que posso fazer isso usando o campo format, para usar apenas o conversor e transformar a data para string usando o formatador gen�rico do tipo com o formato definido em 'format', isso vai permitir o uso de coisas do tipo <td convert="t" type="date" format="dd/MM/yyyy HH:mm:ss">data atual + 10 min</td>;
OK - Lan�ar erro quando se usar uma anota��o associada a m�todos que n�o s�o p�blicos;
OK - Colocar o eval para o pluginSentece de forma que ele n�o converta automaticamente os valores strings caso n�o seja de interesse (default � analisar);
	- N�o ser� feito.
OK - Colocar os @null e @empty como parte dos valores de express�es;
OK - Corrigir o PluginAtt, est� errado ele est� pegando o valor da propriedade no campo attribute e n�o o nome do campo;
	- reteste mostrou funcionamento correto sem precisar alterar o c�digo.
OK - Remover o modal do ErroFrame;
OK - Colocar como Monospaced a fonte;

1.4.34
OK - Suporte � escolha do leitor usado para obter o conte�do a se usado como base para os conversores, agora � poss�vel usar o reader='<algo>' para descrever como deve ser lido o texto, por exemplo, reader='xml' vai retornar o conte�do XML da c�lula para uso pelos conversor.
OK - Ajuste dos PluginDbms para terem features que permitam trocar a classe que implementa o IDatabase e assim permitir a redefini��o simples dessas classes mesmo nos cen�rios de escopo negativo e positivo.

1.4.33
OK - definido um extensor autom�tico de condi��o de espera que adiciona um ' and @version=<X>' nas condi��es de espera de um componente em tela, isso permite que o desenvolvedor ao realizar uma intera��o Ajax que mude a renderiza��o do componente na tela possa perguntar qual vers�o � essa apresentada e assim conseguir esperar pela vers�o correta.

1.4.32
OK - Corrigindo listeners, sempre chamando before e after.
OK - Colocar o ajuste de timezone para os conversores de ConverterDateTimePatternArgs tamb�m, hoje somente para os que extendem o AbstractConverterTimezone;

1.4.31
OK - Listeners chamando o afterScenario sem fazer o beforeScenario quando tem execute="true". Mudar para rodar o final apenas se o come�o foi feito tamb�m;
OK - Melhorar o suporte para internacionaliza��o dos conversores: i.e. criar arquivos properties por cada tipo com texto em ingl�s/portugu�s/etc.
OK - Arquivos de propriedades para os conversores de tempo: sr_converters_date.txt para padr�es de data e sr_converters_time.txt para padr�es de tempo;
OK - Arquivos de propriedades para os campos +- de data, agora os incrementos ou decrementos de tempo podem ser feitos de forma customizavel atrav�s de arquivos de propriedades;
OK - Corrigir o StringNormalizer: whitespace = false;
OK - Colocar o esquema de data +- algo para todos os conversores de 'data atual', s� est� para o de DateTime e LocalDate por enquanto;

1.4.30
OK - conversores +- tempo para DateTime e LocalDate criados.

1.4.29
OK - Criar conversores de data com templates para coisas como 'data atual ((+|-) 30 (dias|meses|anos|horas|minutos|segundos|...)+' [criar teste mostrando como fazer];
OK - Colocar o plugin sentence para salvar uma vari�vel global com o resultado da execu��o, caso se defina um 'name' nela, isso permitir� fazer asserts mais facilmente no resultado recebido (estender o AbstractPluginScoped e fazer bind caso global caso n�o haja escopo definido) - [criar teste mostrando como fazer];
OK - Lan�ar erro quando uma coluna for repetida no Input/Output do banco de dados, para evitar erro do desenvolvedor ao colocar a coluna repetida;

1.4.28
OK - Verificar o PluginColumn quando tem o assert com final ?, em atributos javabeans, p�blico funciona, m�todo tamb�m;
OK - No plugin Column Permitir incluir linhas que s�o apenas meta-descri��es (como agrupadores de colunas, usando ignore);
OK - Na compara��o de bases ver que o �ltimo registro de expected n�o est� sendo mostrado com pendente quando n�o h� conformidade da base com o esperado;
OK - Quando a coluna � uma enumera��o, deve-se considerar o valor 'inverso' (textual) como base para o tamanho da coluna, ou coloca-se o c�digo seguido da descri��o textual limitada ao tamanho conhecido e com '...';
OK- Corrigir o load do URLResolver (retornar ao modelo original);
OK - Corrigir um bug que no escopo negativo que � quando um campo tem valor default, mas o usu�rio quer ajust�-lo para null, ou seja, na base gabarito deveria ir null, mas est� indo o valor default setado no arquivo de configura��o do mapeamento.

1.4.27 
OK - Corrigir o rows/cols do plugin table, est� erradamente pulando ranges;
OK - Criar um waitfor com m�ltiplas condi��es de espera. Sugest�o separados por ';', ou separador customizado (features). Seria poss�vel uma linguagem de express�es? Ou fazer features com prefixo/sufixo, ao inv�s de absolutas?
		- Implementado apenas com AND.
OK - Fazer o PluginInclude ter os links dos arquivos originais de forma relativa � pasta de sa�da;
OK - Colocar fundo e fonte fixos no tempo dos cen�rios;
OK - Colocar mensagens de timezone para o escopo de trace;
	 R: Mantido em info, mas reduzida a quantidade, colocado apenas no momento do getZone() para colocar na cache.
OK - Definir uma forma de chamar o m�todo pelo nome usando o locat no webdriver wait. � poss�vel fazer a chamada de qualquer m�todo est�tico de ExpectedConditions que receba um 'By' como par�metros facilmente.
OK - Realizar uma implementa��o pr�pria de URLResolver para resolver mais que 12 n�veis;
	?? testes com 20 n�veis funcionaram sem problemas.

1.4.26
OK - Corrigir o pause on failure listener, ele est� se perdendo quando se trata de um include com falhas, colocar todos atributos como protected;
OK - Alterar o c�digo do IListenerManager para fazer a remo��o usando o getName() como refer�ncia,e n�o o equals do Java;
OK - Usar http://stackoverflow.com/questions/10797663/removing-tail-of-x-elements-from-a-list para remover os elementos do final da lista de resultado;

1.4.25
OK - Fazer o analisador e comparador de bases retornarem o relat�rio como string n�o fazer System.out;
OK - Colocar o campo de 'nome da base' no evento de listener do banco, isso permite fazer um printlistener que filtre apenas as a��es de uma base no sql-negative;
	OK - Adicionar um getName na fonte de dados.
OK - Aumentar o tamanho do campo 'status' no relat�rio para xx.xxx
OK - Na apresenta��o de erro, verificar se existe o unwrap seria interessante, tem muita mensagem em volta dos errors.
OK - Verificar se o valor est� no range de �ndices. Colocado uma verifica��o de o n�mero de colunas em tabelas de objetos � correspondente � quantidade de headers.
OK - de private static final int TO_SECONDS = 1000; para protected;
OK - Colocar o evento de click do navegador de erros para fazer o offset do erro ficar na posi��o esquerda e no topo da tela;
OK - Colocar uma feature no include para remover o conte�do inclu�do ap�s a execu��o com sucesso de forma que a tela de resultado fique mais barata de ser exibida, deixando apenas o link para o arquivo original inclu�do efetivamente, isso acelera a execu��o dos testes, com menos dados para escrever na sa�da e tamb�m a visualiza��o dos erros no arquivo de sa�da;
	- Default � n�o injetar.
OK - Colocar o initialize no pluginfactory, expor na interface o initialize(); Chamar o m�todo no momento do getClass(alias);
OK - No PluginInclude colocar success na mensagem de que tudo foi bem sucedido;

1.4.24
OK - criar o subgrupo specrunner-tools;
OK - mudar o nome de specrunner-dbms para specrunner-tools-dbms;
OK - Fixar o formato da data no header e colocar o tempo total de execu��o no final;
OK - separar a cria��o do COnnectionDatabase em um m�todo para permitir a redefini��o de m�todos;
	- Deixar mais reutiliz�vel.
OK - Validar arquivos de regras antes de executar o emparelhamento/carga dos bancos de dados;
OK - Deixar dois m�todos compare e dois m�todos analyse para usar os arquivos de configura��o padr�o quando n�o forem fornecidos os listeners de tabela ou de coluna;
OK - Criar abstra��es para receber listas de arquivos de listeners, cada listener pode ter nomes e ser sobrescrito, desta forma podemos ter listeners redefinindo apenas o que for necess�rio
	- Nesse caso o m�todo compare/analyse refebe algo como TableFiles(....) e ColumnFiles(....), ou o mesmo tipo DbmsFiles(...).
OK - Trocar o isOptional por isMandatory() a sem�ntica est� invertida;
OK - Remover o '	shade' da ferramenta, deixar ela como API mesmo, n�o precisa ser execut�vel;
OK - Colocar o base comparator para receber os arquivos de configura��o dos listeners de tabelas e colunas (procurar diretamente e depois via classpath);
OK - Criar dois perfis um de impress�o completo e um de an�lise;
OK - Finalizar os modelos de listeners em hierarquia com dump apenas se necess�rio;
OK - testar tamanho apenas se forem campos de texto;
OK - Criar o comparador de base e o extrator de esquema no perfil dbms usando o schemacrawler;
	- Usar um modelo de listeners para gera��o de reports customizados, por exemplo, no banco analisar que todo campo ID � chave estrangeira, que todo campo DH � timestamp, que todo campo IB deveria ser smallint, que todo campo campo DT � date;
	- Criar um jar execut�vel que l� arquivo de configura��o para carregar os listeners de relat�rio (isso vai permitir estender a ferramenta out of box);
	- Colocar o javasource para 1.7;

1.4.23
Refactorings.
	
1.4.22
OK - Colocar uma feature para permitir usar ou n�o o execute="true", isso permitir� deix�-lo habilitado apenas nas execu��es dos desenvolvedores, n�o na integra��o cont�nua;
OK - PluginSentence linha 274, verificar se o startText != null;

1.4.21
OK - Colocar o conversor de Enumera��es no comando 'not equals' foi feito para o resto mais o not equals n�o foi;
	- Na verdade o problema � no m�todo revert(....) da classe de template, que deve usar o array de template e n�o os args reais :)
	- Fazer o campo de template ser protected e n�o private.
OK - Adicionando suporte � convers�o reversa no Database select report.

1.4.20
OK - Criar uma interface reversable converter e no caso do relat�rio de erros no compareTable usar a interface para fazer a convers�o reversa quando for exibir o registro diferente;
	- Isso vai deixar o relat�rio final muito ninja para os tipos enumerados.
	- Incluidas tamb�m marca��es para os campos key, reference, virtual, sequence, e date.
OK - Colocar um boolean para definir se deve-se mostrar o stacktrace completo no resultado (isso agiliza bastante a exibi��o dos resultados);
	- Deixar como default exibir tudo.


1.4.19
OK - Trocar o comando de click() pelo comando:
	protected void prepare(WebDriver client, WebElement tmp) {
        	Point location = tmp.getLocation();
	        ((JavaExecutor) client).execute("window.scrollTo(" + location.getX() + "," + location.getY() + ")");
	    }
	Usar uma interface para definir como qualquer elemento ser� preparado para uso antes da a��o acontecer e colocar isso no pluginfind.

1.4.18
OK - Na cache de s deve-se perguntar se o SQL � n�o vazio;
N�O - fazer o reuso do connection/statement no database.
OK - Resolver os bugs do isDisplayed() no WebDriver.
	Fiz o comparador clicar nos ths/tds antes de perguntar se isDisplayed(), no Chorme isso se mostrou eficaz para realizar o scroll autom�tico, se n�o funcionar ser� necess�rio usar a posi��o X,Y do component e mandar o WebDriver executar um script de scrollTo.

1.4.17
OK - Colocar initialize() nos IComparator de PluginCompareBase. Isso valor para toda vez que se quiser fazer qualquer compara��o deve-se chamar o initialize antes.
OK - Fazer o @BeforeScenario e @AfterScenario poderem chamar m�todo com o contexto, e contexto e resultado;
OK - Criar o listener que verifica o banco de dados no final apenas ou apenas no come�o;
OK - Criar uma cache de  SQL para o mesmo contexto - Lembrar que nesse caso n�o se pode ter dados bin�rios e tamb�m que deve-se ter uma toler�ncia de tempo maior.
	- Pode-se usar um MD5 para o texto da tabela para verificar se ela j� foi calculada alguma vez, se sim usa-se a cache para executar o  associado. 
		Essa cache presente no DatabaseDefault deve ser limpa entre contextos diferentes de execu��o.
	Implementada usando o toXML() para ser a chave do mapeamento, se isso for muito caro pode-se usar o MD5 no lugar, isso foi apenas para economizar custo de processamento, com objetivo de deixar mais r�pido em detrimento � mem�ria. 
         Tanto a cache quanto o md5 est�o desabilitados de cara, sendo necess�rio habilitar, na vers�o 2.0 pode ser que isso seja padr�o, depende dos testes em cen�rios reais.

1.4.16
OK - Baixar o memory analyzer Java (RCP ou dentro do Luna), e ver a quest�o de cria��o de clones das especifica��es, conferir que todos os resultados est�o sendo liberados ao longo das execu��es, sem manuten��o completa em mem�ria para n�o detonar a heap;
	O problema � executor que est� guardando refer�ncias para os listeners, deve-se liberar as refer�ncias ap�s a execu��o dos testes.
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
OK - Definir um 'execute="true"'' que ser� colocado como prioridade em rela��o aos pending, ou seja, se houver algo com execute 'true' ent�o os demais devem ser considerados pending='true' automagicamente, de forma a rodar apenas 1 cen�rio selecionado;

1.4.15
OK - No header do HTML colocar a quantidade de testes com status igual ao status geral da execu��o.
OK - Nos plugin de objetcs s� colocar title="X" se o texto dentro dos tds n�o for "X" (reduz a quantidade de dados na sa�da);
NO - Adicionar um title 'CEN�RIO IGNORADO' quando for o caso
	Denecess�rio.
OK - Testar melhor o valor de campo quando preenchido com property='x.atributo' ao inv�s de value, tem que ser mais esperta a resolu��o;

1.4.14
OK - Ajuste do bug de relat�rio HTML final;
OK - Realizar update em bloco;
OK - remover o coment�rio de onTableIn no DatabasePrintListener
OK - Fazer o lookup de tabelas e campos ser realizado em duas etapas, primeiro pelo alias, se n�o achar procupar pelo name da entidade no banco, isso permite usar alias ou names nas especifica��es sem problemas;
OK - remover tamb�m os acentos dos nomes das tabelas normalizadas no esquema para evitar problemas bestas de acentua��o;
OK - Jogar sempre os js e css de sa�da na sa�da, sen�o os updates da ferramenta n�o ter�o efeito visual. A menos que seja feito sempre o clean da pasta de saida no build do projeto, por exemplo, se a pasta for o target do maven deveria ser sempre removida;
OK - Ajustar o verify rows para mostrar os valores excedentes recebidos nas consultas.

1.4.13
OK - Criar o relat�rio de resumo das execu��es dos testes (fazer por thread de execu��o, se for 'main' n�o precisa colocar sufixo no nome do relat�rio)
	Criar a tabela com todos os testes executados e seus respectivos resultados (vers�o HTML do relat�rio textual que � gerado atualmente), tudo linkado
	OK: tem que ser relativo sen�o n�o funciona no Jenkins/etc.

OK - Quando realizar dele��es em bloco n�o precisa ter campos id e(ou) quantitativo, afinal pode-se querer apagar todos os registros de uma tabela.

1.4.12
OK - Cen�rios com ignore=true s�o tratados adequadamente.
OK - Relat�rio HTML implementado, sa�da em 'target/output'.

1.4.11
OK - Criar um tableadapter/rowadapter/celladapter factory;
OK - Melhoras de performance escrevendo menos arquivos na sa�da.

1.4.10
OK - Criar uma abstra��o que tenha valor, conversor/etc para usar no Column e n�o amarrar ao INodeHolder.
OK - Colocar getObject(...,true) no reset de colunas, deve ser silenciosa a avalia��o do campo 'value'.
OK - Fazer o initialize do schema refazer o c�lculo somente se mudar o objeto contexto (guardar o contexto velho no momento da chamada ao initialize, para evitar atributo desnecess�rio no c�digo de Column);

1.4.09
OK- Colocar um boolean para saber se o default value � calculado no come�o ou a cada uso (implica��es de performance);
	Colocado para realizar reset dos valores default de um esquema toda as vezes que houver o reuso do schema;
OK - No caso de registros extra ou faltando pode-se omitir as colunas cujo valor esperado seja nullo (por conven��o) isso reduz a quantidade de elementos na tela e facilita a leitura.
OK - Colocar o nome da coluna em outra linha no relat�rio textual e no web (alinhados � esquerda);
OK- Colocar um boolean para dizer se deve-se avaliar os argumentos fornecidos no getObject(), para usar no momento do getDefaultValue como uma feature, evitando assim avalia��o desnecess�ria de express�es;
OK - Criar um nodeholder factory;
OK - C�digo estranho convertendo os argumentos e depois n�o usando eles:
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

1.4.08
OK - Imprimir a vers�o textual do relat�rio de n�o conformidades
	TODO: ajustar legibilidade do c�digo, o c�lculo do tamanho das colunas est� obscuro.
OK - Performance continuada dos perfis positive e negative;
	- Colocar 
	fm.add(PluginConnection.REUSE,true)
	fm.add(PluginSchemaLoader.FEATURE_PROVIDER, SchemaLoaderXOM.class.getName());
OK - ajustar estilo para
	table.sr_treport th.sr_lreport {
		color: black;
		white-space: nowrap;
	}
OK - Fazer um listener de cen�rio que fa�a sempre o compareBase no final, e o que limpa pode ser uma extens�o dele, isso ser� usado para os testes de pesquisa ou detalhamento, por exemplo;
OK - Calcular o valor default apenas quando for o momento de usar, isso tem impactado em testes de longa dura��o com esquema reusado.

1.4.07
OK - Resolver os @ScenarioListener incluindos os da super classe, busca recursiva at� o object;
OK - Alinhar o caption do compareBase � esquerda;
OK - No relat�rio de erro mostrar apenas as colunas conflitantes;
OK - Isolar o filtro do prepare/verify do filter do compareBase sen�o n�o � poss�vel popular a base com campos que devem ser desconsiderados na compara��o final
	Obs: isso pode ser feito colocando-se o modo como parte da assinatura dos m�todos filtrados, ou seja, se for modo input, output e compare j� resolve.
OK - ExpectedMessages aumentado para aceitar substring de mensagens para valida��o, usar sempre com sorted='true' para funcionar o atributo 'criteria'.
OK - Criar os m�dulos de configura��o padr�o para os testes que queiram:
	1- Fazer testes sem escopo negativo - sem valida��o de counts; -> specrunner-sql-positive
	2- Fazer testes sem escopo negativo - com valida��o de counts; -> specrunner-sql-positive com o DatabaseCountListener
	3- Fazer testes com escopo negativo.                           -> specrunner-sql-negative
	
1.4.06
OK - trocar a cor do alien;
OK - Listener do m�dulo SQL que limpa a base e compara a base para cada cenario.
OK - Fazer mais exemplos de escopo negativo, com tabelas distintas e campos faltando;
OK - N�o colocar 'order by' no compareBanco se n�o houver campos chave ou campo reference, usar somente se houver;
OK - Colocar o failsafe no segundo grupo

1.4.05
OK - Simplificar a verifica��o com escopo negativo (desenvolvedores s� conseguem resolver de fato implementa��o com escopo negativo);
OK - Permitir usar tabelas vazias nos prepare e verify, para que o strict funcione verificando que a tabela est� vazia;
OK - Rever a implementa��o do IWait que n�o ficou com a espera autom�tica de campos em tela, tem algo errado no refactoring;

1.4.04
OK - Colocar tabelas com ignore em colunas ou linha no teste web, de forma que se possa ter na aplica��o uma tabela mais complexa que o desejado, e o teste se limitar a ver apenas um grupo de dados:
	- Isso tamb�m pode ser conseguido colocando-se o n�mero de linha que se deseja verificar, de prefer�ncia por ranges de valores como na impress�o de p�ginas
	- Exemplos:
		<table class="compareTable"></table> pega tudo
		<table class="compareTable" rows="1" cols="1;5..."></table> s� a primeira linha da tabela desejada
		<table class="compareTable" rows="1;6"></table> a primeira e a sexta linha
		<table class="compareTable" rows="1-3;6"></table> da 1 � 3 e da 6;
		<table class="compareTable" rows="1-3;6-8"></table> da 1 � 3 e da 6 � 8;
		<table class="compareTable" rows="1-3;6..."></table> da 1 � 3 e da 6 ao final;
		<table class="compareTable" rows="...3;6..."></table> do in�cio � 3 e da 6 ao final;

1.4.03
OK - Usar o IFilter na execu��o dos prepare/verify n�o apenas no compare base. Isso vai permitir postergar a implementa��o de requisitos complexos como logs.
	 - Filtrado e pintado.

OK - Corrigir o ingl�s: Number of itens (10) in content is different from expected ones (9).
   - ITEMS... in field... � melhor.

OK - Trocar o m�todo getNormalized(....) por um normalizador delegado tamb�m, enfim tudo que puder ser delegado e transformado em feature � flexibilidade desejada.
     Criada a interface IStringNormalizer e o m�todo UtilString.normalize deixou de ser est�tico.

OK - Criar uma interface IWait para generalizar a espera pelo webdriver, isso permitir� usar diferentes estrat�gias sem precisar editar o c�digo da superclasse.
    - Delega��o ao inv�s de heran�a!

1.4.02
OK - Bug fix nas a��es web aninhadas.

1.4.01
OK - Cada cen�rio chama @BeforeScenario e @AfterScenario antes e depois de executado.

1.4.00
OK - Cria��o de tags: scenario e title dentro de <scenario> para os t�tulos;
OK - Upgrade de bibliotecas;
OK - Colocar o campo nome do elemento HTML para reduzir digita��o
	- Exemplo:  <set-valor>dado necessario</set-valor>
OK - Colocar o campo nome junto do css para reduzir digita��o
	- Exemplo:  <span class="set-valor">dado necessario</span>
OK - Fazer o controle de quantidade final de registros na base de dados usando contadores com dado que e por fim;
	R: Usar o DatabaseCountListener
OK - Colocar um destruidor de recursos que � realizado sempre que um contexto � dropado ou finalizado, isso permite por exemplo finalizar as sessionfactories que s�o usadas em apenas um teste ou fechar browsers abertos que foram esquecidos pelo testador. Lembrar de n�o fechar aqueles que s�o reusados.
	R: adicionados listeners de contexto e de bloco.
OK - Context populator � um listener de contexto;
	R: populator removido e criado como listener

1.3.40
OK - Colocar uma op��o para adicionar o estilo de debug mesmo sem rodar no modo debug, se o c�digo gerar os tempos de qualquer forma do contr�rio n�o serve para nada;
OK - A ordem de execu��o dos listeners nos eventos finais (onEnd) deve ser feita na ordem reversa da inicializa��o (onStart).
OK - Ajustando headers para 2014.

1.3.39
OK - Colocar a verifica��o de que h� duplica��o de nomes/alias de tabelas e de nomes/alias e colunas;
	R: restri��o adicionada
OK - Criar uma alias para poder usar por exemplo uma tabela 'Customers' mas na refer�ncia usar 'Customer'. :)
	R: para usar outro nome na coluna � s� colocar o atributo 'table=<nome da tabela>'.
OK - Ajustar o tratamento de objects no mapeamento usando 'mapping';
	R: redefini��o de campos corrigida vide exemplo TestRedefinition.java
OK - Layout de scenarios modificado:
	R: usando padr�o Concordion Plus.

1.3.38
OK - Ajustes de a��es de press/release key, cria��o de esc, tab e blur.
OK - Adicionado listener de tempo para os cen�rios.

1.3.37
OK - Criar um mecanismo autom�tico para o waitfor ser injetado automaticamente antes de qualquer a��o/comando a ser realizado em tela;
	R: Default � sempre esperar agora quando o driver n�o � HtmlUnit
OK - Colocar caption: FinderXPath.get().addStrategy("legenda", "//table/caption[contains(text(),'{0}')]/..");
	R: Adicionando 'caption' ao webdriver e ao htmlunit
OK - Colocar para o teste raiz desconsiderar as janelas relacionadas aos erros dentro de cen�rios;
	R: Agora os erros externos est�o segregados dos cen�rios

1.3.36
OK - No Database deve-se verificar se os valores (vazios) est�o com null na base de dados, ou seja no modo output deve-se verificar as colunas com valores 'null'. Considerar o caso onde se deseja realmente verificar se o valor � String vazia. 
	* Para vazio usar @e

1.3.35
OK - O reuso de browser est� criando sempre novas conex�es WebConnectionFile, desta forma a cache de arquivos n�o � reutilizada entre testes, apenas dentro do mesmo teste, o que n�o gera o ganho de performance geral desejado, corrigir.
OK - ver se os pending est�o sendo notificados corretamente pelos listeners de execu��o junit.
OK - Colocar 4 caracteres nos valores de status:
+---------------- TXT (STATUS ORDER)---------------------+
                      # |  TIME (ms) |       % | ON                       | STATUS          | ASSERTS    | INPUT <-> OUTPUT
                      5 |      21584 |   23,11 | 2014-06-27 22:37:32.233  | success 4729/4729 | 14/14      | D:\ThiagoSantos\projetos\AUTRAN\TRUNK\Modelos_e_Implementacao\Java\autran\negocio\target\test-classes\br\gov\bcb\autran\crt2\dominio\concessao\TestCadastroConcessaoGrupo.html <-> D:\ThiagoSantos\projetos\AUTRAN\TRUNK\Modelos_e_Implementacao\Java\autran\negocio\target\output\br\gov\bcb\autran\crt2\dominio\concessao\TestCadastroConcessaoGrupo.html


1.3.34
OK - Rever necessidade de gerar screenshoot de cada c�lula de uma tabela inv�lida, afinal a tabela � a mesma, s� est� custando mais gerar os arquivos.
OK - Integrar a execu��o via HTML unit com suas otimiza��es (i.e. cache de arquivos) dentro do perfil do webdriver quando ele usar o HTMLUnit;

1.3.33
OK - Corrigir o timeout padr�o do webdriver, o maxwait � dado em segundos e n�o em milisegundos;
OK - Colocar uns fire listeners nos cen�rios JUnit a medida que forem passando (falhando).

1.3.32
OK - Criar um "cuspidor de SQL" para gerar avulsos a partir dos testes (por exemplo, o de par�metros de sistema);
OK - BUG: nos plugins que estendem AbstractPluginFind h� falso positivo quando os elementos desejados n�o s�o encontrados, por exemplo, um enabled/disabled de um checkbox que n�o existe na tela.
	Ou seja, nos elementos que permitem a��es sobre m�ltiplos componentes deve-se verificar se foi encontrado pelo menos 1, do contr�rio lan�ar erro.
OK - CSS: Colocar fundo branco no grupo de detalhamento do resultado;
OK - JS: Colocar para a exce��o fazer scroll para a posi��o dela na tela, e no canto esquerdo.

1.3.31
OK - colocar uma campo de mensagem nas anota��es pause, exemplos:
	<pause msg="parei aqui"/>, <span class="pause" msg="parei aqui"/>, <span pause="parei aqui"/>.
OK - Transformar o pause em um frame independente feito o errors messages, para ele aparecer independentemente do Eclipse, o que facilita a vis�o do option.

1.3.30
OK - Fazer os campos de select selecionarem, ou verificarem os itens de forma normalizada (mas podendo escolher se n�o normaliza, default sempre normaliza), isso evita muito falso negativo;

1.3.29
OK - quando houver erro no plugin sentence, mostrar sempre a exce��o encapsulada que tiver o tipo diferente de runtime, ou que seja do tipo IPresentation;
OK - o Runner s� deve fazer sleep/wait para a��es que n�o s�o 'nop';

1.3.28
OK - Ver a quest�o do assert de tela ser feito usando os pr�prios componentes visuais (exemplo: select) - usado estrat�gia do 'as=<tipo>';
OK - Corrigir o c�digo de URI.resolve para aceitar mais que 12 n�veis de '../' (http://www.ietf.org/rfc/rfc2396.txt  - Se��o 5.2);
    Nesse ponto adicionei um IResolver para usar a estrat�gia que quiser al�m do URI.resolve(...);

1.3.27
OK - Melhorando a estrat�gia de JOINED com nomes de tabelas, CSS e tratamento de erro instrutivo.

1.3.26
OK - Criar uma estrat�gia para representar tabelas JOINED do hibernate usando apenas uma tabela �nica, agregando nela todos os atributos das demais tabelas, na verdade � fazer algo como o secondary table funcionar no n�vel da especifica��o. (usar a combina��o de colgroup com transformador).

1.3.25
OK - Adicionar uma feature para ignorar determinados status ou comand types, por exemplo, ignorar os warnings no anotador de sa�da.
OK - Adicionar o navegador de errors na tela. (Java).
OK - Melhor deixar (colocar s� um title?)! - Colocar o warning para n�o gerar bot�o de expans�o; -> Decidi permitir filtrar os IResult direto no result set.

1.3.24
OK - No momento que der erro de compara��o com os dados da base, mostrar dentro do par�nteses o valor que veio da base, e n�o o valor j� da tela, 
OK - Bem como no caso de clobs mostrar a compara��o com strings e n�o to toString() do clob para se saber qual o conte�do.

1.3.23.
OK - Formata��o e numera��o dos bot�es de acordo com o tipo da a��o.

1.3.22
OK - Quando os valores de compara��o de base n�o coincidirem colocar os tipos ao lado para facilitar a identifica��o dos erros;
OK - No relat�rio de escopo negativo transformar os clobs em texto para exibi��o (colocar um boolean para indicar se deve ser assim ou n�o, pois pode haver sistemas que tenha clobs realmente grandes que n�o devem ser exibidos);
OK - No relat�rio de escopo negativo usar texto ao inv�s de title e css para mostrar os campos das tabelas;
OK - Corrigir o "protected void performUpdate(", ele deve sempre ter ou key ou reference para usar no WHERE, quando n�o tiver lancar um erro (n�o precisa, vai haver um update com set e where id�nticos, a� aponta o erro de id/references);
OK - Aumentar o n�vel de log para trace no "2014-04-14 13:24:24,144 [main] DEBUG on [FeatureManagerImpl.java,163] - Feature 'org.specrunner.listeners.core.PauseOnFailureNodeListener.condition' set to object 'org";

1.3.21
OK - Testar escopo negativo apenas com reference;
OK - Ver o enumerador de resultset, est� dando falso positivo no escopo negativo.
OK - Verificar se o virtual do comparador de bases funciona mesmo com update.
OK - Parametrizar o PluginObjectManager para ser ThreadLocal ou n�o, isso � necess�rio nos testes envolvendo o Jetty que cria threads espec�ficos para cada requisi��o.
OK - Criar o conceito de listeners por cen�rios, para, por exemplo, limpar os objetos em mem�ria.
OK - Resolver o problema de timestamp Vs date na base de dados. Coloquei uma feature para timezone nos conversores date/timestamp.
OK - Colocar o pause failure listener para ter o mesmo modelo de pausa condicionada de forna a n�o travar integra��o cont�nua;
OK - Verificar o plugin sentence que n�o est� aceitando apenas o argumento como texto;
OK - Criar um comparador de tempo que aceite qualquer combina��o de tipos date/timestamp/jodatime.
OK - Criar um comparator de strings com trim e um normalizado para uso com o banco de dados;
OK - Ver se � poss�vel manter os valores de campos enumerados no resultado para facilitar a visualiza��o
OK - Ver uma estrat�gia para resolver registros de log de auditoria;
OK - Colocar uma feature para habilitar ou n�o a pausa, de forma que no Linux, por exemplo, a pausa nunca seja executada p/n�o travar a integra��o cont�nua;
OK - Fazer o plugindatabase poder escolher entre doStart e doEnd (in e out); Usando o doEnd;
OK - Lan�ar erros quando cen�rios tiverem os mesmos nomes;
OK - Reduzir o log do reuso de imagens no resultado para n�vel 'trace';
OK - No uso de imagens id�nticas no mesmo arquivo usar uma cache com o nome do gerado para economizar c�pias na sa�da;
OK - Ver porque que as imagens dentro de tables n�o n�o est�o sendo copiadas para o destino dentro de compareTable;

OK - targets ajustados para Linux
------
URI:file:/opt/java/hudson/workspace/disin.autran/web/target/test-classes/br/gov/bcb/autran/web/crt2/servidores.html
TARGET:/opt/java/hudson/workspace/disin.autran/web/target/test-classes/br/gov/bcb/autran/web/crt2/servidores.html
URI:jar:file:/opt/java/hudson/workspace/disin.autran/negocio/target/negocio-1.0.0-tests.jar!/objetos/servidor.html
TARGET:jar:file:/opt/java/hudson/workspace/disin.autran/negocio/target/negocio-1.0.0-tests.jar!/objetos/servidor.html
URI:file:/opt/java/hudson/workspace/disin.autran/web/target/test-classes/br/gov/bcb/autran/web/crt2/login/login.html
TARGET:/opt/java/hudson/workspace/disin.autran/web/target/test-classes/br/gov/bcb/autran/web/crt2/login/login.html
------

- Delegar a cria��o de:
	1- PageListeners;
        2-WritablePages  - OK feito!
para poder substituir quando quiser, o uso de heran�a inviabiliza a substitui��o.

OK - O renaming de arquivos no Linux n�o funciona direito, substituir pelo c�digo: FileUtils.moveDirectory(from, to); 

Corrigir todo ponto de "file:" para deixar esperto o suficiente para funcionar em Linux (sources, includes, runners, etc) - unificar c�digo para facilitar manuten��o.
USAR como exemplo:
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
-------------------------------------------------------------------------
OK

OK - Corrigir os links do recursos (screen/source) para serem relativos ao arquivo de sa�da.
OK - Colocar todas as caches de objetos como no m�nimo protected para permitir reuso. 
OK -Trocar os valores dos campos na especifica��o tamb�m para as telas, assim com foi feito para o SQL, melhora a depura��o; 
OK - Fazer tamb�m no SQL depois que ele realizar a convers�o, para melhorar a tela. 
OK - MELHORAR O LEITOR DE  SQL; 


----------------------
CR�TICAS:

- Criar um filtro de pacotes para a impress�o das exce��es, para reduzir logs in�teis escondendo por exemplo os do pr�prio junit.runners.*/etc.

- Adicionar a cria��o de subobjetos em cadastros de objetos com objins/etc:
	por exemplo i) colocar um atributo que seja uma cole��o de strings, e ii) depois uma cole��o de sub-objetos
?? - Adicionar a exce��o gerada no caso de erro das invoca��es do PluginSentence como resultado apontado pelo 'name';
	Precisa?
- Colocar o access factory para PluginAbstractObject, e colocar field ou feature no campo a ser sensibilizado;
- Colocar par�metros na chamada de macro feito tem em includes;
- Ver o verifyRows se tem como ficar + simples;
- Ver se tem como remover a pilha de erros do trace o pr�prio JUnit. Provavelmente se n�o anexar a causa ele n�o vai colocar a pilha, ver se � poss�vel para reduzir o log quando a quanidade de erros for muito grande, o que d� erro no surefire report;
	
- Disponibilizar o proxy de jdbc dentro do pacote specrunner tools;

- Adicionar um modo DEBUG para o comparador de bases;

SPRING-BOOT:
- Ver as configura��es do projeto para criar o spring boot sprunner que permitiria realizar testes automatizados usando trechos em HTML dispersos na aplica��o
	- Tipo n�o precisar de um contexto complexo para rodar apenas a prepara��o da base de dados lendo de arquivos, por exemplo.


PRIORIT�RIAS:
- Criar um listener para transpor uma tabela escrita no formato
	<coluna><valor><valor>...
        <coluna><valor><valor>....
	para a coluna normal que temos hoje, e depois de rodar transpor de volta ao formato original para facilitar o debug.

- Seria poss�vel generalizar a estrat�gia dos args (usada em PluginSentence) para plugins como PluginEquals?

- Encontrar formas de especificar condi��es de espera com coisas como tamanho de tabelas/etc [criar teste mostrando como fazer].

- Melhorar o formatador de colunas para calcular os tamanhos dos campos corretamente;

- Corrigir a refer�ncia para imagens/recursos que tenha espa�o em branco no nome (fazer o URL enconding);


ALTA:
- Criar um conceito de objeto com atributos din�micos para gerar mapas de objetos (exemplo: um objeto onde os campos s�o na verdade um Map<Campo,Valor>)

- Fazer um esquema para chamar REST e verificar a resposta;

- Olhar o WaitPageToLoad (Selenesse);

- Criar um PluginConnection/PluginRollback para colocar a conex�o no modo de autofush 'false' e limpar a base ao final de cada cen�rio (fazer isso para cada cen�rio).

- Criar cen�rios aninhados no JUnit runner;

- Analisar o PluginInclude para saber se ele est� chamando o c�digo do saveLocal no contexto na posi��o certa dos dados inclu�dos, para evitar vari�veis estranhas;

- Colocar a lista de cen�rios no contexto, e se foi bem sucedido ou n�o. Para realizar o dump deles no relat�rio de sa�da TXT e HTML.

- Normalizar o valor default caso seja null, nos demais casos considerar o valor recebido mesmo (colocar algo para ele saber se deve testar case sensitive ou n�o);

- Criar um leitor de esquemas usando o SchemaCrawler, que gera um nu.xom.Document:
	- Generalizar o leitor de Document para receber um document no load, ser� usado no SchemaLoaderXML e no SchemaLoaderBase(a ser criado);
	- Criar um composite loader para usar a abordagem de realizar merge do que foi lido da base mais o que foi lido do arquivo, isso permitir� economizar escrita como os tipos b�sicos usados em cada coluna, campos de data, campos de chave, transformadores padr�o, etc.

- Testar a combina��o de HTMLUnit com Wicket6 para resolver o problema definitivamente.
	- Wicket 6 mudou o modelo de eventos e o JS do HtmlUnit se perdeu.

- Criar um plugin que fa�a a verifica��o de todas op��es de um select e que fa�a tamb�m a verifica��o dos selecionados;
- Fazer o download do compare files no notepad++;

M�DIA:
- Criar um modelo onde se possa definir os estados dos mocks no in�cio e o estado deles no final para fazer escopo negativo de mocks tamb�m;

- No plugin sentence usar o exemplo <sentence>vai<arg>0002</arg></sentence>, e ver o que acontece:
	public void vai(String str) {
		// deveria receber a string sem fazer avalia��o
	}
- Fazer o leitor de esquema a partir da base.
- Como fazer tabelas dom�nio? Como controlar o drop e create das tabelas sem precisar fazer isso com as tabelas dom�nio? Definir essa abordagem para economizar na execu��o dos testes.

BAIXA:
- Usar 'lazy creation' para tudo (principalmente os mapas).

- Criar uma cache para os conversores de enumera��o para minimizar tempo de execu��o;

- Colocar o tipo SQL do campo no header relat�rio de comparar Base:
	http://stackoverflow.com/questions/6437790/jdbc-get-the-sql-type-name-from-java-sql-type-code

- Implementar um hbnsel para realizar select geral de objetos e ver se o conte�do est� l� completo;
	- Criar uma consulta antes e depois sair removendo � medida que se encontra os objetos, isso vai evitar tamb�m tapear usando o mesmo elemento no resultado:
		- Usar o HashBuilder nos campos para evitar pesquisar pelo mesmo elemento v�rias vezes;
- Implementar um verifyAll para realizar o select completo de uma tabela:
	- Fazer um select considerando campos de ordena��o definidos na tabela: <table class="verifyAll" ...order="nome,telefone,data">...</table>

- No caso de escopo negativo pintar os verify com status informativo, e n�o de sucesso? Fica bom?

- Usar o TableReport para falhas no escopo positivo (compensa fazer? Pensando bem acho que n�o):
	- Aqui pode-se usar o mesmo modelo de escopo positivo, a diferen�a � que testa-se apenas as tabelas que s�o informadas no por fim, apenas as perguntadas, usando-se inclusive a base auxiliar.
	- Se usar o filter para ignorar demais tabelas lembrar de fazer um AND com os m�todos do filtro j� existente.

- Criar o perfil specrunner-sql-select para fazer o teste final usando apenas os selects dos campos, sem necessidade de base extra, ou seja o que seria o ...-sql-positive hoje.
	- S� fazer se for feita a de cima tamb�m.

- criar o result que sempre aparece expandido de cara;

- Baixar o jailer;

- Trocar todos os UtilXXX por m�todos n�o est�ticos acess�veis a partir do SRServices, como foi feito com o IStringNormalizer.

- Colocar para n�o realizar eval de express�es somente se eval for false, usar como exemplo um nome de arquivo, com ';';
          ? Remover ou n�o as strings

- Fazer o plugin sentence trabalhar com features e n�o apenas m�todos;

- Criar o conceito de composite action, para tarefas agrupadas, e o somat�rio ser segregado, bem com a exibi��o no relat�rio de debug. (Precisa?)

Exemplo de report:
-----------------


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
    border: 1px solid #A2D9EF;
	display: none;
}
</style>

<p>�</p>
<p>�</p>
<p>�</p>
<p>�</p>
<p>�</p>
<p>�</p>
<p>�</p>
<p>�</p>
<p>�</p>
<p>�</p>
<p>�</p>
<p>�</p>
<p>�</p>
<p>�</p>
<p>�</p>
<p>�</p>
<p>�</p>
<p>�</p>
<p>�</p>
<p>�</p>
<p>�</p>
<p>�</p>
<p>�</p>
<p>�</p>
<p>�</p>
<p>�</p>
<p>�</p>
<p>�</p>
<p>�</p>
<p>�</p>
<p>�</p>
<p>�</p>
<p>�</p>
<p>�</p>
<p>�</p>
<p>�</p>

<div style="text-align:center;">
	<input type="button" id="controle" value="Mostrar"/>
</div>


<span class="sr_frame_link_div" id="componente">Estou <input type="radio" name="sex" value="male">AQUI<br></span>

</html>
