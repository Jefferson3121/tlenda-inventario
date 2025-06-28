 Tlenda 🛒

Sistema básico de inventario desarrollado en Java para práctica educativa.  
Permite gestionar productos y categorías utilizando una base de datos PostgreSQL.

---

 🚀 Tecnologías usadas

- Java 17
- PostgreSQL
- Maven
- HikariCP (pool de conexiones)
- JDBC

---

 📂 Estructura del proyecto

src/
└── main/
└── java/
└── com.tienda/
├── bd/ # Conexión a la base de datos
├── dao/ # Acceso a datos (consultas SQL)
├── models/ # Clases de dominio (Producto, Categoría)
└── Main.java # Punto de entrada de la aplicación



---

 ⚙️ ¿Cómo correr el proyecto?

1. Asegúrate de tener Java y PostgreSQL instalados
2. Crea una base de datos llamada `tienda_inventario`
3. Configura el usuario y contraseña en `ConexionBD.java`
4. Ejecuta `Main.java` desde tu IDE o con Maven

---

 📌 Funcionalidades actuales

- [x] Conexión a PostgreSQL con HikariCP
- [ ] DAO para productos
- [ ] CRUD completo de productos
- [ ] Visualización por categoría
- [ ] Validaciones y manejo de errores

---

 📜 Licencia

Este proyecto es de uso libre con fines educativos.



