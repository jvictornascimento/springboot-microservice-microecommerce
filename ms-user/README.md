
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

## Technologies

- `Intellij`
- `Java 17`
- `Maven`
- `Spring Boot, Spring web, Spring Data JPA, Spring Validation, Spring amqp`
- `Docker`
- `DTO`
- `PostgreSQL`
- `MapStruct`
