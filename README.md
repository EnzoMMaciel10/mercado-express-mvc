# CP4 Parte 2 - Mercado Express

Projeto desenvolvido para o CP4 de Java Advanced, com uma aplicação Web MVC usando Spring Boot, Thymeleaf, Spring Security, Spring Data JPA e banco de dados Oracle.

## Integrante

- Nome: Enzo Monteiro Maciel
- RM: RM563734

- Nome: Matheus de Almeida Sousa
- RM: RM563557

- Nome: Paulo Estalise
- RM: RM563811

- Nome: Gabriel Bebé Silva
- RM: RM562012

- Nome: Emanuel Italo
- RM: RM561337

## Tecnologias utilizadas

- Java 21
- Spring Boot 3.5.5
- Maven
- Spring Web
- Thymeleaf
- Spring Security
- Spring Data JPA
- Bean Validation
- Lombok
- Oracle Database
- HTML5
- CSS3

## Descrição do projeto

O Mercado Express é um sistema web para gerenciamento de produtos de mercado.

A aplicação permite realizar um CRUD completo de produtos, com interface web em Thymeleaf e persistência dos dados em banco Oracle.

## Funcionalidades

- Listagem de produtos
- Busca de produtos por nome
- Cadastro de produto
- Visualização de detalhes
- Edição de produto
- Exclusão de produto
- Login com Spring Security
- Rotas públicas e privadas

## Entidade principal

A entidade `Mercado` possui os seguintes campos:

- `id`
- `nome`
- `tipo`
- `setor`
- `tamanho`
- `preco`

## Rotas da aplicação

### Rotas públicas

- `GET /`
- `GET /mercado`
- `GET /mercado/detalhes/{id}`
- `GET /login`

### Rotas privadas

- `GET /mercado/novo`
- `POST /mercado`
- `GET /mercado/editar/{id}`
- `POST /mercado/editar/{id}`
- `POST /mercado/excluir/{id}`

## Usuário para teste

```text
Usuário: admin
Senha: 123456
```

## Banco de dados

A aplicação utiliza Oracle Database.

Configuração usada no `application.properties`:

```properties
spring.datasource.url=jdbc:oracle:thin:@oracle.fiap.com.br:1521:ORCL
spring.datasource.username=RM563734
spring.datasource.password=SENHA_DO_ORACLE
spring.datasource.driver-class-name=oracle.jdbc.OracleDriver
```

A senha não deve ser publicada no GitHub.

## Como executar o projeto

1. Clonar o repositório:

```bash
git clone https://github.com/EnzoMMaciel10/mercado-express-mvc.git
```

2. Abrir o projeto no IntelliJ IDEA.

3. Configurar o JDK do projeto como Java 21.

4. Configurar o arquivo `application.properties` com os dados corretos do Oracle.

5. Executar a classe principal:

```text
Cp4Parte2MvcApplication
```

6. Acessar no navegador:

```text
http://localhost:8080
```

## Estrutura do projeto

```text
src/main/java/cp4_parte2_mvc
├── config
│   └── SecurityConfig.java
├── controller
│   ├── HomeController.java
│   ├── LoginController.java
│   └── MercadoController.java
├── model
│   └── Mercado.java
├── repository
│   └── MercadoRepository.java
├── service
│   └── MercadoService.java
└── Cp4Parte2MvcApplication.java
```

```text
src/main/resources
├── static
│   └── css
│       └── style.css
├── templates
│   ├── home.html
│   ├── login.html
│   └── mercado
│       ├── lista.html
│       ├── form.html
│       └── detalhes.html
└── application.properties
```

## Segurança

O projeto utiliza Spring Security.

Usuários não autenticados podem acessar a página inicial, a listagem de produtos, os detalhes dos produtos e a tela de login.

Para cadastrar, editar ou excluir produtos, é necessário fazer login.

## Observação

Este projeto foi desenvolvido com foco nos requisitos do CP4 Parte 2, utilizando MVC, Thymeleaf, JPA, Oracle e Spring Security.