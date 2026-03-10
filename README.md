# SGHSS - Sistema de Gestão Hospitalar e de Serviços de Saúde 🏥

Este projeto foi desenvolvido como parte do **Projeto Multidisciplinar** do curso de **CST em Análise e Desenvolvimento de Sistemas** da **Centro Universitário Internacional UNINTER**.

O **SGHSS** é uma **API REST de gestão hospitalar** projetada para centralizar o ecossistema de saúde da rede **VidaPlus**, garantindo **segurança, rastreabilidade e integridade de dados médicos**, com conformidade a boas práticas de engenharia de software e princípios de segurança da informação.

---

# 📌 Objetivo do Projeto

O objetivo do SGHSS é fornecer uma infraestrutura backend capaz de gerenciar:

- Pacientes
- Profissionais de saúde
- Consultas médicas
- Prontuários eletrônicos
- Receitas digitais
- Teleatendimento
- Auditoria e controle de acesso

A API foi projetada considerando **sistemas de alta criticidade**, como os utilizados no setor da saúde.

---

# 🛠️ Stack Tecnológica

| Tecnologia | Descrição |
|------------|-----------|
| **Java 17** | Linguagem principal da aplicação |
| **Spring Boot 3** | Framework para desenvolvimento da API |
| **Spring Security** | Controle de autenticação e autorização |
| **JWT (JSON Web Token)** | Autenticação stateless |
| **Spring Data JPA** | Camada de persistência |
| **Hibernate** | ORM para mapeamento objeto-relacional |
| **MySQL** | Banco de dados relacional |
| **Flyway** | Versionamento e migração de banco de dados |
| **Bean Validation** | Validação de dados de entrada |
| **Postman** | Testes de endpoints |

---

# 🧠 Arquitetura do Sistema

O projeto segue o padrão de **Arquitetura em Camadas**, separando responsabilidades para facilitar manutenção e escalabilidade.

Controller Layer
↓
Service Layer
↓
Repository Layer
↓
Database


### Controller
Responsável por expor os **endpoints REST da aplicação**.

### Service
Implementa as **regras de negócio do sistema**.

### Repository
Responsável pela **comunicação com o banco de dados via JPA**.

---

# 🔐 Segurança

O sistema utiliza **autenticação baseada em tokens JWT**, garantindo comunicação segura entre cliente e servidor.

Principais características:

- Autenticação **stateless**
- Proteção de rotas via **Spring Security**
- Tokens assinados com **chave secreta**
- Controle de acesso baseado em autenticação

Fluxo de autenticação:


Cliente → Login → API

API → Gera Token JWT

Cliente → Requisições com Token

API → Validação do Token


---

# ✨ Boas Práticas Implementadas

O projeto implementa diversas boas práticas modernas de desenvolvimento backend:

### DTO Pattern
Separação entre **entidades de domínio** e **objetos de transferência de dados**.

### Soft Delete
Exclusão lógica de registros para manter histórico e permitir auditoria.

### Tratamento Global de Exceções
Padronização de respostas de erro utilizando:

```java
@RestControllerAdvice
Bean Validation

Validação automática de dados de entrada com anotações como:

@NotNull
@NotBlank
@Email
API RESTful

Endpoints seguindo princípios REST:

Uso correto de métodos HTTP

Respostas padronizadas

Estrutura clara de rotas

📂 Estrutura do Projeto
src
 └── main
     └── java
         └── com.sghss
             ├── controller
             ├── service
             ├── repository
             ├── domain
             ├── dto
             ├── security
             └── exception

📋 Como Executar a Aplicação

Pré-requisitos

Java JDK 17

Maven 3.x

MySQL 8.x

1️⃣ Clonar o repositório
git clone https://github.com/lucasmarchant/sghss-api.git
2️⃣ Acessar o projeto
cd sghss-api
3️⃣ Configurar banco de dados

No arquivo:

src/main/resources/application.properties

configure:

spring.datasource.url=jdbc:mysql://localhost:3306/sghss_db
spring.datasource.username=root
spring.datasource.password=a.123456

spring.jpa.show-sql=true
spring.jpa.properties.hibernate.format_sql=true

server.error.include-stacktrace=never
4️⃣ Configuração do Token JWT
api.security.token.secret=${JWT_SECRET:12345678}
5️⃣ Executar a aplicação
mvn spring-boot:run

Ou:

./mvnw spring-boot:run
🔎 Exemplos de Endpoints
Autenticação
POST /auth/login
Pacientes
GET /pacientes
POST /pacientes
PUT /pacientes/{id}
DELETE /pacientes/{id}
Consultas
GET /consultas
POST /consultas
Prontuário
GET /prontuario/{pacienteId}
POST /prontuario
🧪 Testes da API

Os testes da API podem ser realizados utilizando:

Postman

Insomnia

curl

Exemplo de requisição autenticada:

Authorization: Bearer TOKEN_JWT
📊 Possíveis Evoluções

O sistema pode evoluir para incluir:

Gestão de leitos hospitalares

Integração com laboratórios

Sistema completo de prontuário eletrônico

Telemedicina avançada

Arquitetura baseada em microsserviços

Testes automatizados e testes de carga

👨‍💻 Autor

Lucas Cardoso Marchant

Analista de Sistemas | Desenvolvedor Backend Java

Engenharia de Software

APIs REST

Microsserviços

Integrações de sistemas

GitHub:

https://github.com/lucasmarchant
📄 Licença

Este projeto foi desenvolvido para fins acadêmicos como parte do curso de Análise e Desenvolvimento de Sistemas - UNINTER.
