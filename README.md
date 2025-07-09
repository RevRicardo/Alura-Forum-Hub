# 💬 Alura Forum Hub

**Alura Forum Hub** é uma aplicação backend construída em **Java 17** com o framework **Spring Boot**, com a proposta de simular uma API de fórum educacional inspirada no estilo da plataforma Alura. Este projeto serve como ambiente de estudos práticos sobre REST, autenticação, persistência com JPA, e boas práticas de arquitetura de software.

---

## 🧠 Objetivo do Projeto

O propósito é oferecer uma base completa para quem está aprendendo desenvolvimento backend em Java. Entre os conceitos aplicados estão:
- Estruturação de APIs RESTful
- Organização modular seguindo padrão MVC
- Persistência de dados com JPA e Hibernate
- Segurança com autenticação JWT

---

## 🗂️ Estrutura do Projeto

Organização dos pacotes em `src`:

| Pacote        | Função |
|---------------|--------|
| `controller`  | Controla as rotas HTTP e as entradas dos usuários |
| `service`     | Contém a lógica de negócio da aplicação |
| `model`       | Define as entidades que representam os dados (JPA) |
| `repository`  | Interfaces que fazem a comunicação com o banco de dados |

---

## 🧪 Tecnologias e Dependências

- 🟢 Java 17
- 🌱 Spring Boot
  - `spring-boot-starter-web`
  - `spring-boot-starter-data-jpa`
  - `spring-boot-starter-security` (planejado)
- 🗃️ Banco de dados:
  - `MySQL` para produção (planejado)

---

## 🚀 Como executar localmente

### Pré-requisitos
- Instalar Java 17+
- Instalar Maven 3.2+

### Passos para rodar o projeto

```bash
# Clone o repositório
git clone https://github.com/RevRicardo/Alura-Forum-Hub.git
cd Alura-Forum-Hub

# Execute usando Maven
./mvnw spring-boot:run
O backend estará disponível em http://localhost:8080

✅ Funcionalidades implementadas
[x] Cadastro e listagem de usuários

[ ] CRUD de tópicos de discussão

[ ] Sistema de respostas e votos

[ ] Autenticação com JWT

[ ] Validação e exceções customizadas

🔮 Funcionalidades planejadas
Integração com PostgreSQL

Documentação interativa dos endpoints com Swagger UI

Testes unitários e de integração

Deploy na nuvem (Heroku ou Railway)

CI/CD com GitHub Actions

📌 Endpoints (exemplo)
http
GET /usuarios
POST /usuarios
GET /topicos
POST /topicos
Detalhes completos dos endpoints serão incluídos com a futura integração do Swagger

👨‍💻 Autor
Projeto desenvolvido por RevRicardo como parte dos estudos do curso da Alura.

📃 Licença
Este projeto está licenciado sob a MIT License


Se quiser, posso criar diagramas, g
