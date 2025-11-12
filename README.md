# 🧩 Workshop Spring Boot 3 + JPA  
Repositório: [PedroThiago02/workshop-springboot3-jpa](https://github.com/PedroThiago02/workshop-springboot3-jpa)

## 📘 Descrição  
Este projeto é um **workshop prático** desenvolvido com **Spring Boot 3**, **Spring Data JPA** e **Java 21**, com o objetivo de demonstrar como construir uma **API RESTful completa** utilizando os principais recursos do ecossistema Spring.  

O sistema realiza operações de CRUD para usuários e consultas de leitura (GET) para categorias, pedidos e produtos, simulando uma estrutura típica de e-commerce.  

## 🚀 Objetivos do projeto  
- Criar uma API REST com Spring Boot 3.  
- Mapear entidades JPA e seus relacionamentos.  
- Implementar persistência de dados com Spring Data JPA.  
- Utilizar o banco de dados **H2 em memória** (padrão) ou outro configurado.  
- Popular dados iniciais e executar operações CRUD básicas.  

---

## 🧰 Tecnologias utilizadas  
- ☕ **Java 21**  
- 🌱 **Spring Boot 3**  
- 🗄️ **Spring Data JPA**  
- 💾 **H2 Database** (modo de teste)  
- 🧩 **Maven**  

---

## ⚙️ Pré-requisitos  
Antes de rodar o projeto, certifique-se de ter:  
- Java JDK 21 instalado e configurado  
- Maven instalado (ou usar o wrapper `mvnw`)  
- Git instalado  
- IDE de sua preferência (IntelliJ IDEA, Eclipse, VS Code, etc.)

---

## ▶️ Como executar o projeto  

1. **Clone o repositório**  
   ```bash
   git clone https://github.com/PedroThiago02/workshop-springboot3-jpa.git
   ```

2. **Acesse a pasta do projeto**  
   ```bash
   cd workshop-springboot3-jpa
   ```

3. **Execute o projeto**  
   ```bash
   mvn spring-boot:run
   ```
   ou  
   ```bash
   ./mvnw spring-boot:run
   ```

4. **Acesse o servidor local**  
   ```
   http://localhost:8080
   ```

5. **Console do H2 (opcional)**  
   ```
   http://localhost:8080/h2-console
   ```
   (Verifique o `application-test.properties` para o JDBC URL)

---

## 🧱 Estrutura principal do projeto  

```
src/main/java/com/example/course
 ├── config/          # Configurações iniciais e carga de dados (seeds)
 ├── entites/         # Classes de entidade JPA (User, Order, Product, Category)
 ├── enums/           # Enumerações usadas nas entidades (ex: OrderStatus)
 ├── pk/              # Classes auxiliares de chave composta
 ├── repositories/    # Interfaces que estendem JpaRepository
 ├── resources/       # Controladores REST (endpoints da API)
 ├── services/        # Camada de serviços (regras de negócio)
 └── CourseApplication.java  # Classe principal (Spring Boot)
```

---

## 🌐 Endpoints da API  

### 🧍 Usuários (`/users`)
| Método | Endpoint | Descrição |
|:-------|:----------|:----------|
| `GET` | `/users` | Lista todos os usuários |
| `GET` | `/users/{id}` | Retorna um usuário específico |
| `POST` | `/users` | Cria um novo usuário |
| `PUT` | `/users/{id}` | Atualiza os dados de um usuário existente |
| `DELETE` | `/users/{id}` | Remove um usuário do sistema |

#### 🧾 Exemplo de requisição `POST /users`
```bash
curl -X POST http://localhost:8080/users \
-H "Content-Type: application/json" \
-d '{
  "name": "João Silva",
  "email": "joao@email.com",
  "phone": "999999999",
  "password": "123456"
}'
```

#### Exemplo de resposta
```json
{
  "id": 5,
  "name": "João Silva",
  "email": "joao@email.com",
  "phone": "999999999"
}
```

---

### 📦 Produtos (`/products`)
| Método | Endpoint | Descrição |
|:-------|:----------|:----------|
| `GET` | `/products` | Lista todos os produtos |
| `GET` | `/products/{id}` | Retorna um produto específico |

---

### 🏷️ Categorias (`/categories`)
| Método | Endpoint | Descrição |
|:-------|:----------|:----------|
| `GET` | `/categories` | Lista todas as categorias |
| `GET` | `/categories/{id}` | Retorna uma categoria específica |

---

### 🧾 Pedidos (`/orders`)
| Método | Endpoint | Descrição |
|:-------|:----------|:----------|
| `GET` | `/orders` | Lista todos os pedidos |
| `GET` | `/orders/{id}` | Retorna um pedido específico |

---

## 🧮 Configuração padrão do banco de dados  

O projeto utiliza o **H2 Database** por padrão, já configurado em `application-test.properties`:  

```properties
# DATASOURCE
spring.datasource.driverClassName=org.h2.Driver
spring.datasource.url=jdbc:h2:mem:testdb
spring.datasource.username=sa
spring.datasource.password=

# H2 CLIENT
spring.h2.console.enabled=true
spring.h2.console.path=/h2-console

# JPA, SQL
spring.jpa.database-platform=org.hibernate.dialect.H2Dialect
spring.jpa.defer-datasource-initialization=true
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.format_sql=true
```

---

## 🌍 Deploy no Render  

O projeto está hospedado na plataforma **Render**, no endereço:

👉 [https://workshop-springboot3-jpa-1-znm3.onrender.com](https://workshop-springboot3-jpa-1-znm3.onrender.com)

> ⚠️ **Atenção:**  
> A instância utiliza o **plano gratuito** do Render, que possui **modo de hibernação automática**.  
> - Quando o serviço fica **inativo por alguns minutos**, ele é pausado para economizar recursos.  
> - Na primeira requisição após esse período, a aplicação precisa ser **“acordada”**, o que pode causar um **atraso de até 50 segundos** na resposta inicial.  
> - Após o carregamento, as requisições seguintes funcionam normalmente e com velocidade padrão.  

---

## 🔧 Possíveis melhorias  
- Implementar DTOs e validação de entrada (`@Valid`, `Bean Validation`).  
- Adicionar tratamento de exceções global com `@ControllerAdvice`.    
- Integrar documentação da API com **SpringDoc / Swagger UI**.  
- Criar testes unitários e de integração.  

---

## 🤝 Contribuição  
Contribuições são bem-vindas!  
Sinta-se à vontade para abrir **issues** ou enviar **pull requests** com melhorias e correções.  

---

💡 *Desenvolvido durante o workshop de Spring Boot 3 + JPA — um passo essencial para dominar o ecossistema Spring moderno!* 🚀
