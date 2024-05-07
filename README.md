# Aplicação Spring Boot - Gestão de Turmas e Instrutores


## Pré-requisitos

    - Java JDK 17
    - Maven 3.6.3+
    - Docker
    - Docker Compose

## Ferramentas de Desenvolvimento

Este projeto foi desenvolvido utilizando as seguintes ferramentas:

 - **Visual Studio Code:** Um editor de código fonte altamente configurável, construído para desenvolvimento eficiente.

 - **Spring Boot Extension Pack:** Uma extensão para o VSCode que oferece suporte ao desenvolvimento de aplicativos Spring Boot, fornecendo funcionalidades como realce de sintaxe, completude de código e depuração.

 - **Extension Pack for Java:** Um conjunto de extensões para o VSCode que oferece suporte ao desenvolvimento em Java, incluindo funcionalidades como realce de sintaxe, completude de código, depuração e gerenciamento de dependências.

 - **Database Client JDBC by Weijan Chen:** Uma extensão útil para gerenciar bancos de dados diretamente no VSCode, permitindo que você visualize esquemas de banco de dados, execute consultas SQL e gerencie seus dados sem sair do editor.
   
 - **REST Client:** Uma extensão que permite testar chamadas de API diretamente do VSCode, com suporte a sintaxe de cURL, além de oferecer recursos como histórico de solicitações e visualização de respostas.

## Configuração do Banco de Dados

Este projeto utiliza um banco de dados MySQL. Para configurar o banco de dados localmente, siga estas etapas:

1. Certifique-se de ter o Docker e o Docker Compose instalados em sua máquina.
2. No diretório raiz do projeto, abra o arquivo **docker-compose.yml.**
3. Verifique e, se necessário, atualize as seguintes configurações do banco de dados:
   - Nome do banco de dados: **api_spring**
   - Usuário do banco de dados: **root**
   - Senha do banco de dados: **12345678**
4. Salve as alterações no arquivo **docker-compose.yml.**

## Configuração Inicial

Clone e entre no diretório do projeto:

```sh
git clone git@github.com:everton-nfs/api.git
cd api
```
## Execução com Docker Compose

1. Construir e rodar a aplicação:

```sh
docker-compose up --build
```
A aplicação estará disponível em **http://localhost:8080.**

2. Parar a aplicação:

```sh
docker-compose down
```

## Documentação da API com Swagger

A documentação da API está disponível através do Swagger UI. Para acessá-la, navegue até:

**http://localhost:8080/swagger-ui/index.html**

Através do Swagger UI, você pode visualizar todos os endpoints disponíveis, seus parâmetros, e realizar chamadas de teste diretamente pela interface.

