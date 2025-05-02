# Autenticação e Autorização com Spring Security, JWT Tokens e Roles

![Java](https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=openjdk&logoColor=white)
![Spring](https://img.shields.io/badge/spring-%236DB33F.svg?style=for-the-badge&logo=spring&logoColor=white)
![JWT](https://img.shields.io/badge/JWT-black?style=for-the-badge&logo=JSON%20web%20tokens)
![Docker](https://img.shields.io/badge/docker-%230db7ed.svg?style=for-the-badge&logo=docker&logoColor=white)
![MySQL](https://img.shields.io/badge/mysql-4479A1.svg?style=for-the-badge&logo=mysql&logoColor=white)

Este é um projeto de API REST com autenticação e autorização utilizando **Spring Security** com **JWT (JSON Web Token)** e controle de acesso baseado em **roles**, feito com base na biblioteca https://github.com/auth0/java-jwt

## 🚀 Tecnologias Utilizadas
- **Java**
- **Spring Boot**
- **Docker (para MySQL, uso opcional)**

## 🛠️ Instalação
### 1. Clone o repositório:
```bash
git clone https://github.com/mariaeac/authentication-api.git
```
### 2. Instale as dependências do Maven
### 3. Configure o MySQL (execute o arquivo docker-compose já presente no repositório caso deseje utilizar via Docker)

## 🔗 Endpoints
### 📌 Login de usuário
- **Método:** `POST`
- **Endpoint:** `/auth/login`
- **Corpo da requisição:**

  ```json
  {
  "username": "john_doe",
  "password": "mypassword"
  }
  ```

### 📌 Registro de usuário
- **Método:** `POST`
- **Endpoint:** `/auth/register`
- **Corpo da requisição:**

  ```json
  {
  "username": "john_doe",
  "password": "mypassword",
  "role": "USER"
  }
  ```

### 📌 Buscar lista com produtos cadastrados.
- **Método:** `GET`
- **Endpoint:** `/product`

### 📌 Cadastrar novo produto (Apenas usuários autenticados)
- **Método:** `POST`
- **Endpoint:** `/product`
- **Corpo da requisição:**
  
   ```json
  {
  "name": "john_doe",
  "price": "mypassword",
  }
  ```




