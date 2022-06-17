<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <style>
      @import url(https://fonts.googleapis.com/css?family=Lato:100,300,400);

input::-webkit-input-placeholder, textarea::-webkit-input-placeholder {
  color: #aca49c;
  font-size: 0.875em;
}

input:focus::-webkit-input-placeholder, textarea:focus::-webkit-input-placeholder {
  color: #bbb5af;
}

input::-moz-placeholder, textarea::-moz-placeholder {
  color: #aca49c;
  font-size: 0.875em;
}

input:focus::-moz-placeholder, textarea:focus::-moz-placeholder {
  color: #bbb5af;
}

input::placeholder, textarea::placeholder {
  color: #aca49c;
  font-size: 0.875em;
}

input:focus::placeholder, textarea::focus:placeholder {
  color: #bbb5af;
}

input::-ms-placeholder, textarea::-ms-placeholder {
  color: #aca49c;
  font-size: 0.875em;
}

input:focus::-ms-placeholder, textarea:focus::-ms-placeholder {
  color: #bbb5af;
}

body {
  font-family: 'Lato', sans-serif;
  background: #2a2929;
  color: #0d6df4;
}

h1 {
  position: relative;
  margin: 100px 0 25px 0;
  font-size: 1.7em;
  text-align: center;
  letter-spacing: 3px;
}

#form {
  position: relative;
  width: 600px;
  margin: 50px auto 100px auto;
}

input {
  font-family: 'Lato', sans-serif;
  font-size: 0.875em;
  width: 400px;
  height: 50px;
  padding: 0px 15px 0px 15px;
  background: transparent;
  outline: none;
  color: #0d6df4;
  border: solid 1px #0d6df4;
  transition: all 0.3s ease-in-out;
  -webkit-transition: all 0.3s ease-in-out;
  -moz-transition: all 0.3s ease-in-out;
  -ms-transition: all 0.3s ease-in-out;
}

input:hover {
  background: #b3aca7;
  color: #0d6df4;
}

label{
  color: #0d6df4;
}

#submit {
  width: 500px;
  padding: 0;
  margin: -5px 0px 0px 0px;
  font-family: 'Lato', sans-serif;
  font-size: 0.875em;
  color: #0d6df4;
  outline:none;
  cursor: pointer;
  border: solid 1px #0d6df4;
  margin-top: auto;
  height: 50px;
}

#submit:hover {
  color: #e2dedb;
}
    </style>
    <title>vGenero</title>
</head>
<body>
    <div class="container">
        <div class="cover">
          <h1>Escribe el nombre del Genero que desea Actualizar</h1>
          <form id="form" class="topBefore" method="post" action="Genero">
            <input type="text" name="Id" id="Id" value='<%=request.getAttribute("id")%>' readonly >
            <input type="text" name="Nombre" id="Nombre" placeholder="Ejemplo: Salsa" value='<%=request.getAttribute("nombre")%>'>
            <button name="accion" type="submit" value="modificar">Actualizar</button>
          </form>
     </div>
     </div>
</body>
</html>