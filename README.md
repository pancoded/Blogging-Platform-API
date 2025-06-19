# 📝 Blogging Platform API - RESTful API con Spring Boot
https://roadmap.sh/projects/blogging-platform-api

Este proyecto es una API RESTful para una plataforma de blogs personales. Permite realizar operaciones CRUD sobre publicaciones, así como buscarlas por término en el título, contenido o categoría.

---

## 🚀 Tecnologías utilizadas

- **Lenguaje:** Java
- **Framework:** Spring Boot
- **Base de datos:** MySQL (`utf8mb4_spanish_ci`)
- **ORM:** Spring Data JPA
- **Dependencias:**
  - Spring Web
  - Spring Boot DevTools
  - Lombok
  - Spring Data JPA
  - MySQL Driver

---

## 🧱 Instalación

1. **Clona este repositorio:**

```bash
git clone https://github.com/pancoded/Blogging-Platform-API.git
```

2. **Navega a la carpeta del proyecto:**

```bash
cd Blogging-Platform-API
```

3. **Crea una base de datos llamada `posts` con codificación `utf8mb4_spanish_ci`:**

```sql
CREATE DATABASE posts CHARACTER SET utf8mb4 COLLATE utf8mb4_spanish_ci;
```

4. **La configuración ya viene incluida** en `src/main/resources/application.properties`. Solo asegúrate de tener tu usuario y contraseña correctos.

5. **Ejecuta el proyecto desde tu IDE o con Maven:**

```bash
./mvnw spring-boot:run
```

6. **Accede a la API en:**  
[http://localhost:8080](http://localhost:8080)

---

## 📂 Estructura del proyecto

```
📦 Blogging-Platform-API
├── 📁 controller         # Maneja las peticiones HTTP (REST controllers)
├── 📁 service            # Contiene la lógica del negocio
├── 📁 repository         # Interfaces JPA para acceso a datos
├── 📁 model              # Entidades de la base de datos (JPA models)
├── 📁 dto                # Objetos de transferencia de datos (Data Transfer Objects)
├── 📄 BlogApplication.java  # Punto de entrada principal (main)
└── 📁 resources
    └── 📄 application.properties  # Configuración de la conexión a base de datos
```

---

## 📬 Endpoints disponibles

| Método | Endpoint       | Descripción                              |
|--------|----------------|------------------------------------------|
| POST   | `/posts`       | Crear una nueva publicación              |
| PUT    | `/posts/{id}`  | Actualizar una publicación existente     |
| DELETE | `/posts/{id}`  | Eliminar una publicación                 |
| GET    | `/posts/{id}`  | Obtener una publicación por su ID        |
| GET    | `/posts`       | Obtener todas las publicaciones          |
| GET    | `/posts?term=` | Filtrar publicaciones por búsqueda       |

---

## 🧪 Ejemplos de uso (Postman)

### ✅ Crear una publicación

**POST** `/posts`

```json
{
  "title": "Mi primer post",
  "content": "Este es el contenido de mi primer post.",
  "category": "Tecnología",
  "tags": ["Java", "Spring Boot"]
}
```

📥 Respuesta:

```json
{
  "id": 1,
  "title": "Mi primer post",
  "content": "Este es el contenido de mi primer post.",
  "category": "Tecnología",
  "tags": ["Java", "Spring Boot"],
  "createdAt": "2025-06-19T10:00:00Z",
  "updatedAt": "2025-06-19T10:00:00Z"
}
```

---

### 🛠️ Actualizar una publicación

**PUT** `/posts/1`

```json
{
  "title": "Post actualizado",
  "content": "Este es el nuevo contenido.",
  "category": "Programación",
  "tags": ["Java", "API"]
}
```

---

### ❌ Eliminar una publicación

**DELETE** `/posts/1`

- `204 No Content` si se elimina correctamente.
- `404 Not Found` si no existe.

---

### 🔍 Obtener una publicación por ID

**GET** `/posts/1`

```json
{
  "id": 1,
  "title": "Mi primer post",
  "content": "Este es el contenido de mi primer post.",
  "category": "Tecnología",
  "tags": ["Java", "Spring Boot"],
  "createdAt": "2025-06-19T10:00:00Z",
  "updatedAt": "2025-06-19T10:00:00Z"
}
```

---

### 📚 Obtener todas las publicaciones

**GET** `/posts`

```json
[
  {
    "id": 1,
    "title": "Mi primer post",
    "content": "Este es el contenido de mi primer post.",
    "category": "Tecnología",
    "tags": ["Java", "Spring Boot"],
    "createdAt": "2025-06-19T10:00:00Z",
    "updatedAt": "2025-06-19T10:00:00Z"
  }
]
```

---

### 🔎 Buscar publicaciones por término

**GET** `/posts?term=java`

```json
[
  {
    "id": 1,
    "title": "Mi primer post",
    "content": "Este es el contenido de mi primer post.",
    "category": "Tecnología",
    "tags": ["Java", "Spring Boot"],
    "createdAt": "2025-06-19T10:00:00Z",
    "updatedAt": "2025-06-19T10:00:00Z"
  }
]
```

---

## 🛠️ Consideraciones técnicas

- Se utilizó manejo de errores con `try-catch`.
- No se implementan autenticación, paginación ni autorización.
- Estructura en capas (MVC + DTO).
- El punto de entrada principal del proyecto es `BlogApplication.java`.

---

## 📄 Licencia

Este proyecto es de uso libre para fines educativos y personales.

