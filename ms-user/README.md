<h1 align="center">MS User</h1>

![Badge Concluído](https://img.shields.io/static/v1?label=Status&message=In+progress&color=yellow&style=for-the-badge)
![Badge Java](https://img.shields.io/static/v1?label=Java&message=17&color=orange&style=for-the-badge&logo=java)
![Badge Spring](https://img.shields.io/static/v1?label=SpringBoot&message=v3.3.1&color=brightgreen&style=for-the-badge&logo=SpringBoot)
![Badge swagger](https://img.shields.io/static/v1?label=Swagger&message=2.6.0&color=green&style=for-the-badge&logo=Swagger)

## Project summary
This is a microservice that will be part of a sales ecosystem, its responsibility is CRUD for users who can be ADMIN, CLIENT and SELLER.

## API Documentation

#### Insert User

```http
  POST /users
```

| Body   | Tipo       | Descrição                           |
| :---------- | :--------- | :---------------------------------- |
| `name` | `string` |  User name  |
| `email` | `string` | **Required**. User email |
| `type` | `string` | **Required**. User type. |

#### Insert User ADMIN

```http
  POST /users/admins
```

| Body   | Tipo       | Descrição                           |
| :---------- | :--------- | :---------------------------------- |
| `name` | `string` |  User name  |
| `email` | `string` | **Required**. User email |
| `password` | `string` | **Required**. User password. |



#### Delete user by id

```http
  DELETE /users/${id}
```

| Parâmetro   | Tipo       | Descrição                                   |
| :---------- | :--------- | :------------------------------------------ |
| `id`      | `Long` | **Obrigatório**. User id to be deleted  |

#### Update user by id

```http
  PUT /users/${id}
```

| Parâmetro   | Tipo       | Descrição                                   |
| :---------- | :--------- | :------------------------------------------ |
| `id`      | `Long` | **Obrigatório**. User id to be update |

| Body   | Tipo       | Descrição                                   |
| :---------- | :--------- | :------------------------------------------ |
| `name`      | `String` | User name to be update |
| `email`      | `String` | User email to be update |

#### Find all

```http
  GET /users/search/all
```
#### Find by id

```http
  GET /users/search/${id}
```
| Parâmetro   | Tipo       | Descrição                                   |
| :---------- | :--------- | :------------------------------------------ |
| `id`      | `Long` | **Obrigatório**. User id to find |

#### Find by type seller

```http
  GET /users/search/type/seller
```
#### Find by type client

```http
  GET /users/search/type/client
```

To view full documentation, go to: <http://localhost:8081/swagger-ui.html>.

#### If you want to see the complete application with all microservices, visit: https://github.com/jvictornascimento/microservice.git

## Technologies

- `Intellij`
- `Java 17`
- `Maven`
- `Spring Boot, Spring web, Spring Data JPA, Spring Validation, Spring amqp`
- `Docker`
- `DTO`
- `PostgreSQL`
- `MapStruct`

## Future updates
- [ ] Create automated tests.
- [ ] HATEOAS to help customers consume to API without the need for prior knowledge
- [ ] To set up CORS.
- [x] update project Docker image.
- [ ] Access to resources only authenticated.
- [ ] Deploy the application to a cloud service.