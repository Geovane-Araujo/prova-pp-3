## Prova Padroes de projeto 3

### Descricao

A ideia do projeto é simular uma empresa que precisa fazer pesquisas, aqui pode-se cadastrar as perguntas
o tipo de resposta que pode ser aceita e a origem se é uma pesquisa interna ou externa

As pesquisas internas são feitos na propria empresa, sendo assim elas somente serão respondidas
via email

Ja as pesquisas externas são feitas por ligação!!

### Padrões utilizados
* Singleton
  * Optei pelo singleton para a conexão com o banco de dados, uma vez que inicia a 
    applicação ele mantem a conexão aberta para as operações, somente fecha quando encerra 
    a aplicação
* Iterator
  * O itertor uso para percorrer as perguntas tanto para salvar quanto para fazer a pessoa
    que está respondendo a pesquisa
* Strategy
  * Como o projeto tem a possibilidade de espandir o ecossitema de atendimentos não 
  * somente por email e ligação optei pelo strategy.



### Vantagens e desvantagens

* Singleton
  * A vantagem do uso deste padrão é que garantimos que teremos somente uma conexão aberta, como 
    fazemos uso do banco SQLite que só permite 1 conexão isso evita possiveis conflicos com a 
    possibilidade de abrir várias conexões
  * No caso em específico não vejo desvantagens, porem em um ambiente que o banco possa ser compartilhado entre 
    duas aplicações ja da ruim o seu uso
  * 
* Iterator
  * No contexto deste projeto não há vantagens por duas razões, o objeto que faz a iteração não
    é complexo, e outra razão é que o Java já possui na api java.utils o padrão iterator, não 
    podendo ser usado aplicado dentro de uma lista
  * A grande desvantagem além claro de ja ter uma api nativa que implemta é que pode deixar a 
    aplicação um pouco mais lenta se comparado ao uso de um for normal.
* Strategy
  * A grande vantagem que observo é na questão da escalbilidade, e na propria separação de responsabilidades
    visto que conseguimos definir as classes de acordo com o que realmente ela vai tratar
    reduzindo assim a possibilidade de uma classa acabar possuindo muitas responsabilidades
    Outra vantagem é sobre vc poder trocar o tipo de instanciação em tempo de execução




    
O projeto ta meio sem vergonha é que estava meio sem ideia  kkkk


referencias:<br/>
[Strategy](https://refactoring.guru/pt-br/design-patterns/strategy)

[Iterator](https://refactoring.guru/pt-br/design-patterns/iterator)

[Singleton](https://refactoring.guru/pt-br/design-patterns/singleton)