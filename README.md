# Mercado Express MVC

Projeto desenvolvido para o CP4 de Java Advanced, com uma aplicação Web MVC usando Spring Boot, Thymeleaf, Spring Security, Spring Data JPA e banco de dados Oracle.

## Links do projeto

- Repositório: https://github.com/EnzoMMaciel10/mercado-express-mvc
- Deploy Render: https://mercado-express-mvc-0zk8.onrender.com
- Prints: [prints/prints-mercado-express.pdf](prints/prints-mercado-express.pdf)
- Vídeo de apresentação: https://youtu.be/litltjHHuE4

> Observação: o deploy está em uma instância gratuita do Render. Após períodos de inatividade, a primeira abertura pode demorar alguns segundos.

## Integrantes

- Enzo Monteiro Maciel - RM563734
- Matheus de Almeida Sousa - RM563557
- Paulo Estalise - RM563811
- Gabriel Bebé Silva - RM562012
- Emanuel Italo - RM561337

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
- Docker
- Render
- HTML5
- CSS3

## Descrição do projeto

O Mercado Express é um sistema web para gerenciamento de produtos de mercado.

A aplicação permite realizar um CRUD completo de produtos, com interface web em Thymeleaf, autenticação com Spring Security e persistência dos dados em banco Oracle.

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

A configuração do banco é feita por variáveis de ambiente, evitando publicar a senha no GitHub.

Exemplo usado no `application.properties`:

```properties
spring.datasource.url=${SPRING_DATASOURCE_URL:jdbc:oracle:thin:@oracle.fiap.com.br:1521:ORCL}
spring.datasource.username=${SPRING_DATASOURCE_USERNAME:RM563734}
spring.datasource.password=${SPRING_DATASOURCE_PASSWORD:}
spring.datasource.driver-class-name=oracle.jdbc.OracleDriver
```

Variáveis necessárias para execução:

```text
SPRING_DATASOURCE_URL=jdbc:oracle:thin:@oracle.fiap.com.br:1521:ORCL
SPRING_DATASOURCE_USERNAME=RM563734
SPRING_DATASOURCE_PASSWORD=SENHA_DO_ORACLE
```

A senha do Oracle não deve ser publicada no GitHub.

## Como executar o projeto localmente

1. Clonar o repositório:

```bash
git clone https://github.com/EnzoMMaciel10/mercado-express-mvc.git
```

2. Abrir o projeto no IntelliJ IDEA.

3. Configurar o JDK do projeto como Java 21.

4. Configurar as variáveis de ambiente com os dados do Oracle.

5. Executar a classe principal:

```text
Cp4Parte2MvcApplication
```

6. Acessar no navegador:

```text
http://localhost:8080
```

## Deploy

O projeto foi publicado no Render utilizando Docker.

A imagem Docker realiza o build com Maven e executa o arquivo JAR gerado pela aplicação Spring Boot.

URL do deploy:

```text
https://mercado-express-mvc-0zk8.onrender.com
```

Como o deploy está no plano gratuito do Render, a aplicação pode entrar em modo de descanso após um período de inatividade. Nesse caso, o primeiro acesso pode demorar alguns segundos.

## Prints da aplicação

Os prints da configuração do Spring Initializr e das telas da aplicação estão disponíveis no arquivo:

[Ver PDF com os prints](prints/prints-mercado-express.pdf)

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

Este projeto foi desenvolvido com foco nos requisitos do CP4 Parte 2, utilizando MVC, Thymeleaf, JPA, Oracle, Spring Security e deploy em nuvem.