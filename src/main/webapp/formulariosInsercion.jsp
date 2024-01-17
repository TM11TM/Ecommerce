<%-- 
    Document   : formulariosInsercion
    Created on : 9 ene 2024, 20:28:20
    Author     : Carlos
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <style>
            body, h1, h2, h3, p, ul, li, form, input {
                margin: 0;
                padding: 0;
            }

            body {
                font-family: 'Arial', sans-serif;
                background-color: #f4f4f4;
                color: #333;
                line-height: 1.6;
            }

            header {
                background-color: #3498db;
                color: #fff;
                padding: 20px;
                text-align: center;
            }

            nav {
                background-color: #2980b9;
            }

            nav ul {
                list-style: none;
                display: flex;
                justify-content: center;
                padding: 10px 0;
            }

            nav a {
                text-decoration: none;
                color: #fff;
                padding: 10px 20px;
                margin: 0 10px;
                border-radius: 5px;
                transition: background-color 0.3s;
            }

            nav a:hover {
                background-color: #1c4966;
            }

            main {
                max-width: 800px;
                margin: 20px auto;
                padding: 20px;
                background-color: #fff;
                box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            }

            form {
                margin-top: 20px;
            }

            form label {
                display: block;
                margin-bottom: 8px;
                color: #333;
            }

            form input {
                width: 100%;
                padding: 10px;
                margin-bottom: 15px;
                border: 1px solid #ccc;
                border-radius: 4px;
                box-sizing: border-box;
            }

            form input[type="submit"] {
                background-color: #2ecc71;
                color: white;
                padding: 15px 20px;
                border: none;
                border-radius: 4px;
                cursor: pointer;
                width: 100%;
                font-size: 16px;
            }

            form input[type="submit"]:hover {
                background-color: #27ae60;
            }

            footer {
                background-color: #3498db;
                color: #fff;
                text-align: center;
                padding: 10px;
                position: fixed;
                bottom: 0;
                width: 100%;
            }
        </style>
    </head>
    <body>

        <header>
            <h1>Tienda de Productos Deportivos</h1>
        </header>

        <nav>
            <ul>
                 <li><a href="producto.jsp">Crear producto</a></li>
            <li><a href="formulariosInsercion.jsp">Crear cliente</a></li>
            </ul>
        </nav>

        <main>
            <section id="formulario">
                <h2>Formulario de Registro Cliente</h2>
                <form action="svecommerce">
                    Nombre:<input type="text" name="nombre"><br>
                    Apellido:<input type="text" name="apellido"><br>
                    Dirección:<input type="text" name="direccion"><br>
                    Correo Electrónico:<input type="email" name="correo"><br>
                    Teléfono:<input type="text" name="telefono"><br>
                    <input type="hidden" name="task" value="insert">
                    <input type="submit" value="Insertar cliente">
                </form>
            </section>

        </main>

        <footer>
            <p>&copy; 2024 Tienda de Productos Deportivos. Todos los derechos reservados.</p>
        </footer>

    </body>
</html>
