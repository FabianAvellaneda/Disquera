<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html lang="en">
<head> 
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Disquera</title>
    <style>
        body {
  margin:0;
  background-image: url('https://p4.wallpaperbetter.com/wallpaper/1000/734/452/headphones-music-audifonos-wallpaper-preview.jpg');
  background-size: cover;
  min-height:100vh;
  display:flex;
  align-items:center;
  justify-content:center;
  font-family:Helvetica,Sans-serif;
}
a {
  text-decoration:none;
  color:#FFF;
  text-size-adjust: auto;
}
.rainbow-button {
  width:calc(20vw + 6px);
  height:calc(8vw + 6px);
  background-image: linear-gradient(90deg, #00C0FF 0%, #FFCF00 49%, #FC4F4F 80%, #00C0FF 100%);
  border-radius:5px;
  display:flex;
  align-items:center;
  justify-content:center;
  text-transform:uppercase;
  font-size:3vw;
  font-weight:bold;
}
.rainbow-button:after {
  content:attr(alt);
  width:20vw;
  height:8vw;
  background-color:#191919;
  display:flex;
  align-items:center;
  justify-content:center;
}
.rainbow-button:hover {
  animation:slidebg 2s linear infinite;
}

@keyframes slidebg {
  to {
    background-position:20vw;
  }
}
    </style>
</head>
<body>
    <header>
        <div class="back">
            <nav>
                <a class="rainbow-button" alt="Inicio" href="index.jsp"></a>
                <br>
                <a class="rainbow-button" alt="Genero" href="Genero?accion=listarGenero"></a>
                <br>
                <a class="rainbow-button" alt="Cancion" href="Genero?accion=listarC"></a>
            </nav>
        </div>
    </header>
</body>
</html>