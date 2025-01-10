# FórumHub

Bem-vindo ao **FórumHub**! Este é um projeto desenvolvido como parte do desafio "Challenge Back End" da Alura. Nosso objetivo é criar uma API REST para gerenciar um fórum de discussão, replicando funcionalidades essenciais de um sistema de fórum, incluindo o gerenciamento de tópicos e autenticação.

---

## ⚡ Funcionalidades Principais

1. **CRUD de Tópicos**:
    - Criar um novo tópico.
    - Listar todos os tópicos.
    - Consultar um tópico específico por ID.
    - Atualizar um tópico existente.
    - Deletar um tópico.

2. **Autenticação e Autorização**:
    - Implementação de serviço de login com validação de credenciais.
    - Restrição de acesso a rotas específicas com base em permissões.

3. **Validação e Regras de Negócio**:
    - Regras de validação para criação e atualização de tópicos.
    - Retorno de mensagens claras em caso de erros.

4. **Base de Dados Relacional**:
    - Persistência de informações de tópicos, usuários e autenticação em um banco de dados relacional.

---

## 🔧 Tecnologias Utilizadas

- **Java 17**: Linguagem de programação principal.
- **Spring Boot**: Framework para criação da aplicação.
- **Spring Data JPA**: Para interação com o banco de dados.
- **Spring Security**: Para autenticação e autorização.
- **Flyway**: Gerenciamento de migrações no banco de dados.
- **MySQL**: Banco de dados relacional.
- **SpringDoc OpenAPI**: Geração da documentação da API.

---

## 🖌þ⏳ Estrutura do Projeto

O projeto segue uma estrutura organizada baseada em boas práticas do Spring Boot:

```
forumhub/
├── src/main/java/com/andrezorek/forumhub/
│   ├── model/                    # Classes de modelo, entidades JPA
│   ├── controller/               # Controladores REST
│   ├── service/                  # Camada service para cuidar das regras de negócio
│   ├── dto/                      # Objetos de Transferência de Dados
│   ├── repository/               # Repositórios para interação com o banco
│   ├── infra/                    # Implementações relacionada a infraestrutura
│   └── config/                   # Configurações 
├── src/main/resources/
│   ├── application.properties    # Configurações da aplicação
│   └── db/migration/             # Scripts de migração do Flyway
```

---

## ⚠ Requisitos para Executar

- **JDK 17+**
- **Maven 3.8+**
- **MySQL 8**

---

## 🚀 Como Rodar a Aplicação

1. Clone o repositório:
   ```bash
   git clone https://github.com/ahzorek/forumhub.git
   cd forumhub
   ```

2. Edite seu arquivo *.env.example* para **.env** e preencha com seus detalhes:
   ```bash
   DB_HOST=localhost
   DB_PORT=3306
   DB_NAME=forumhub
   DB_USER=seu-usuario
   DB_PASSWORD=sua-senha
   JWT_TOKEN=CHAVESECRETAPARAGERACAODETOKEN
   ```

3. Inicie a aplicação:
   ```bash
   ./mvnw spring-boot:run
   ```

4. Acesse a documentação da API:
    - [Swagger UI](http://localhost:8080/swagger-ui.html)

---

## 🔎 Melhorias Futuras

- Implementar funcionalidades de resposta aos tópicos.
- Melhorar as regras de validação para evitar duplicidade de tópicos.
- Implementar paginação para as respostas de um tópico.
- Adicionar testes unitários e de integração.

---
