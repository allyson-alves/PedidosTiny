# Projeto de Pedidos Tiny

#### Automação criada para sanar o problema da Equipe AllFilmes, odne o principal caso era ter que atualizar pedidos um a um na mão, com a automação otimizamos o tempo da equipe, para que os pedidos sejam atualizado automaticamente dia a dia.

# Frameworks utilizados:
### Git

# Projeto de Automação

Este projeto visa automatizar tarefas de coleta de dados de pedidos de uma loja virtual e atualizar os valores com base em uma lista de preços específica usando Java, Selenium e RestAssured.

## Configuração do Ambiente

Certifique-se de ter o seguinte ambiente configurado:

- [Java Development Kit (JDK)](https://www.oracle.com/java/technologies/javase-downloads.html) - Versão 8 ou superior.
- [Apache Maven](https://maven.apache.org/download.cgi) - Para gerenciamento de dependências.
- [Selenium WebDriver](https://www.selenium.dev/documentation/en/webdriver/driver_requirements/) - Configurado para automação web.
- [RestAssured](https://rest-assured.io/) - Para automação de API.

## Configuração do Projeto

1. Clone este repositório:
git clone https://github.com/seu-usuario/nome-do-projeto.git

2. Abra o projeto em sua IDE favorita.

3. Certifique-se de que as dependências estão sendo gerenciadas corretamente pelo Maven.

4. Configuração das URLs e Tokens:
   - Atualize as URLs da API e os tokens de acesso em seus respectivos locais no código-fonte.

## Uso

O projeto consiste em duas partes principais:

### Automação Web

A automação web é responsável por coletar informações de pedidos em uma loja virtual. Certifique-se de que o Selenium WebDriver esteja configurado e os locais dos elementos HTML estejam definidos corretamente no código-fonte.

Para executar a automação web, você pode usar a classe `ReceberPedidos`. Lembre-se de configurar os detalhes de autenticação, navegação e coleta de dados de acordo com o ambiente específico.

### Automação de API

A automação de API é responsável por buscar informações de pedidos em uma API e atualizar os valores com base em uma lista de preços. Certifique-se de que o RestAssured esteja configurado corretamente.

Para executar a automação de API, você pode usar as classes `PesquisarPedidos` e `ListaPrecos`. Certifique-se de configurar os parâmetros da API, tokens e URLs corretamente.

### Execução Geral

A classe `AutomationClass` é responsável por orquestrar a execução de ambas as automações. Certifique-se de chamar as automações web e de API de acordo com suas necessidades.

## Contribuição

Contribuições são bem-vindas! Se você deseja contribuir para este projeto, siga os seguintes passos:

1. Fork o projeto.
2. Crie uma nova branch para sua contribuição: `git checkout -b minha-contribuicao`
3. Faça suas alterações e commit: `git commit -m 'Minha contribuição'`
4. Push para o repositório: `git push origin minha-contribuicao`
5. Abra um pull request.

## Licença

Este projeto está licenciado sob a [Licença MIT](LICENSE.md).
