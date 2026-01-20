# ⚙️ EstoquePro API - Serviço de Back-end

Este é o motor central do sistema **EstoquePro**. Trata-se de uma API RESTful construída com Java e Spring Boot, projetada para gerenciar a lógica de negócios, a persistência de dados com SQL Server e a comunicação segura com o Front-end.

## 🛠️ Arquitetura e Tecnologias

- **Java 17**: Linguagem principal para garantir performance e robustez.
- **Spring Boot 3**: Framework utilizado para desenvolvimento ágil e configuração pronta para produção.
- **Spring Data JPA & Hibernate**: Utilizados para o Mapeamento Objeto-Relacional (ORM), facilitando a gestão dos dados no SQL Server.
- **SQL Server**: Banco de dados relacional de nível industrial para armazenamento seguro dos dados.
- **Maven**: Automação de compilação e gerenciamento de dependências.
- **Padrão MVC**: Organizado em camadas (Controller, Service, Repository e Model) para melhor manutenção e escalabilidade.

## 🚀 Principais Funcionalidades

- **Lógica de Controle de Estoque**: Regras avançadas para evitar estoque negativo e garantir a integridade dos dados durante as transações.
- **Cálculos Automatizados**: Cálculo em tempo real dos valores totais de venda com base nos preços atuais dos produtos.
- **Configuração de CORS**: Comunicação segura entre origens, permitindo especificamente o acesso do Front-end React (Porta 3000).
- **Estrutura Escalável**: Preparado para novas implementações, como autenticação JWT e relatórios avançados.

## 📂 Estrutura do Projeto

- `model`: Entidades que representam as tabelas do banco de dados.
- `repository`: Interfaces para comunicação direta com o SQL Server.
- `service`: O "cérebro" da aplicação, contendo todas as regras de negócio e validações.
- `controller`: Os pontos de entrada (endpoints) que recebem as requisições do Front-end.

## 🛣️ Endpoints da API (Principais)

| Método | Endpoint | Descrição |
| :--- | :--- | :--- |
| GET | `/api/produtos` | Lista todos os itens do estoque |
| POST | `/api/produtos` | Cadastra um novo produto |
| POST | `/vendas` | Processa uma venda e atualiza o estoque |
| GET | `/vendas` | Retorna o histórico completo de vendas |
| GET | `/usuarios` | Lista todos os funcionários registrados |

## 🔧 Como Configurar

1. **Pré-requisitos**: Ter o JDK 17 e o SQL Server instalados.
2. **Configuração do Banco de Dados**: 
   - Abra o arquivo `src/main/resources/application.properties`.
   - Atualize os campos `spring.datasource.url`, `username` e `password` com suas credenciais locais do SQL Server.
3. **Executar a Aplicação**: 
   - Abra o projeto no IntelliJ ou Eclipse.
   - Execute a classe `SistemaEstoqueApiApplication`.
   - O servidor iniciará em `http://localhost:8080`.

## 👤 Autor

**Bruno Mota** - GitHub: [@bbmbrunomota](https://github.com/bbmbrunomota)
- LinkedIn: [(https://www.linkedin.com/in/bruno-mota-76976973/)]
# ⚙️ EstoquePro API - Back-end Service

This is the core engine of the **EstoquePro** system. It is a RESTful API built with Java and Spring Boot, designed to handle business logic, database persistence with SQL Server, and secure communication with the Front-end.

## 🛠️ Architecture & Technologies

- **Java 17**: The primary programming language for robust performance.
- **Spring Boot 3**: Framework for rapid development and production-ready configuration.
- **Spring Data JPA & Hibernate**: Used for Object-Relational Mapping (ORM) to manage SQL Server data efficiently.
- **SQL Server**: Industrial-grade relational database for data persistence.
- **Maven**: Dependency management and build automation.
- **MVC Pattern**: Organized into Controller, Service, Repository, and Model layers for better maintainability.

## 🚀 Key Features

- **Inventory Control Logic**: Advanced logic to prevent negative stock and ensure data integrity during transactions.
- **Automated Calculations**: Real-time calculation of total sale values based on current product prices.
- **CORS Configuration**: Secured cross-origin communication specifically allowed for the React Front-end (Port 3000).
- **Scalable Structure**: Ready for new features like JWT authentication and advanced reporting.

## 📂 Project Structure

- `model`: Data entities representing the database tables.
- `repository`: Interfaces for direct communication with SQL Server.
- `service`: The "brain" of the app, containing all business rules and validations.
- `controller`: The entry points (endpoints) that receive requests from the Front-end.

## 🛣️ API Endpoints (Main)

| Method | Endpoint | Description |
| :--- | :--- | :--- |
| GET | `/api/produtos` | Lists all inventory items |
| POST | `/api/produtos` | Registers a new product |
| POST | `/vendas` | Processes a sale and updates stock |
| GET | `/vendas` | Returns the complete sales history |
| GET | `/usuarios` | Lists all registered employees |

## 🔧 How to Setup

1. **Prerequisites**: Have JDK 17 and SQL Server installed.
2. **Database Configuration**: 
   - Open `src/main/resources/application.properties`.
   - Update `spring.datasource.url`, `username`, and `password` with your local SQL Server credentials.
3. **Run the App**: 
   - Open the project in IntelliJ or Eclipse.
   - Run the `SistemaEstoqueApiApplication` class.
   - The server will start on `http://localhost:8080`.

## 👤 Author

**Bruno Mota** - GitHub: [@bbmbrunomota](https://github.com/bbmbrunomota)
- LinkedIn: (https://www.linkedin.com/in/bruno-mota-76976973/)
