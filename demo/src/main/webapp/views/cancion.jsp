<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html lang="en"> 
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.1.1/css/all.min.css" integrity="sha512-KfkfwYDsLkIlwQp6LFnl8zNdLGxu9YAA1QvwINks4PhcElQSvqcyVLLD9aMhXd13uQjoXtEKNosOWaZqXgel0g==" crossorigin="anonymous" referrerpolicy="no-referrer" />
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <script src="//cdn.jsdelivr.net/npm/sweetalert2@11"></script>
    <title>Disquera</title>
    <style>
        body{
        background-image: url('https://www.xtrafondos.com/wallpapers/resized/panal-de-colores-3d-hexagonos-3584.jpg?s=large');
        background-size: cover;
        }
        h1{
            margin-top: 25px;
            color: white;
        }
    </style>
    <%-- borrar --%>
     <script>
        function borrar(e,cod,cont){
         e.preventDefault();
         console.log(cont);
         Swal.fire({
             title: 'Eliminar registro',
             text: "Estas seguro de elimar el registro?",
             icon: 'warning',
             showCancelButton: true,
             confirmButtonText: 'Si, deseo elimnarlo',
             cancelButtonText: 'No, cancelar!',
             reverseButtons: true
           }).then((result) => {
             if (result.isConfirmed) {
               ruta=cont+"?accion=eliminarCancion&idC="+cod;
               console.log(ruta);
               window.setTimeout(function(){window.location.href = ruta},2000)
               Swal.fire({ 
                 position: 'top-end',
                 icon: 'success',
                 title: 'El registro ha sido borrado',
                 showConfirmButton: false,
                 timer: 1500
               })
             } 
             
             else{
                 Swal.fire( 
                     'cancelado',
                     'cancelaste la eliminacion',
                     'error');
             } 
         })};
    </script>
    <%-- activar --%>
    <script>
        function activar(e, cod, cont) {
     e.preventDefault();
     console.log(cont);
     Swal.fire({
       title: 'Esta seguro de activar este genero?',
       text: 'Esta accion no se puede reversar!',
       icon: 'warning',
       showCancelButton: true,
       confirmButtonColor: '#3085d6',
       cancelButtonColor: '#d33',
       confirmButtonText: 'Si, Activalo!',
       cancelButtonText: 'No, Cancelar!',
     }).then((result) => {
       if (result.isConfirmed) {
         ruta = cont + '?accion=activarC&idC=' + cod;
         console.log(ruta);
         window.setTimeout(function () {
           window.location.href = ruta;
         }, 2000);
         Swal.fire({
           position: 'top-end',
           icon: 'success',
           title: 'El genero ha sido activado',
           showConfirmButton: false,
           timer: 1500,
         });
       } else {
         Swal.fire('Cancelado', 'Cancelaste la activacion', 'error');
       }
     });
   }
    </script>
    <%-- desactivar --%>
    <script>
        function desactivar(e, cod, cont) {
     e.preventDefault();
     console.log(cont);
     Swal.fire({
       title: 'Esta seguro de desactivar este genero?',
       text: 'Esta accion no se puede reversar!',
       icon: 'warning',
       showCancelButton: true,
       confirmButtonColor: '#3085d6',
       cancelButtonColor: '#d33',
       confirmButtonText: 'Si, Desactivalo!',
       cancelButtonText: 'No, Cancelar!',
     }).then((result) => {
       if (result.isConfirmed) {
         ruta = cont + '?accion=desactivarC&idC=' + cod;
         console.log(ruta);
         window.setTimeout(function () {
           window.location.href = ruta;
         }, 2000);
         Swal.fire({
           position: 'top-end',
           icon: 'success',
           title: 'El genero ha sido desactivado',
           showConfirmButton: false,
           timer: 1500,
         });
       } else {
         Swal.fire('Cancelado', 'Cancelaste la desactivacion', 'error');
       }
     });
   }
    </script>
</head>
<body>

    <h1><center>Lista de Canciones</center></h1>
    <a type="button" class="btn btn-success" href="Genero?accion=abrirFormC">Añadir Cancion</a>
    <a type="button" class="btn btn-success" href="index.jsp">Volver a Incio</a><br><br>
    <table class="table table-success table-striped">
        <thead>
            <tr>
                <th><center> Id Cancion</center></th>
                <th><center> Nombre Cancion</center></th>
                <th><center> Fecha Grabacion Cancion</center></th>
                <th><center> Duracion Cancion</center></th>
                <th><center>Estado Cancion</center></th>
                <th><center>¿Quiere?</center></th>            
                <th colspan="2"><center>Acciones</center></th>
            </tr>
        </thead>

        <tbody>
            <c:forEach var="Cancion" items="${canciones}">         
                <tr>
                    <td><center>${Cancion.getIdC()}</center></td>
                    <td><center>${Cancion.getNombreC()}</center></td>
                    <td><center>${Cancion.getFgrab()}</center></td>
                    <td><center>${Cancion.getDuraC()}</center></td>
                    <c:if test="${Cancion.getEstadoC() == true}">
                    <td><center><span class="badge bg-success active">Activo</span></center></td> 
                    </c:if>
                    <c:if test="${Cancion.getEstadoC() == false}">
                        <td><center><span class="badge bg-danger active">Inactivo</span></center></td> 
                    </c:if>
                    
                    <td>
                        <c:if test="${Cancion.getEstadoC() == true}">
                            <a rol="button" class="btn btn-danger" onclick="desactivar(event,'${Cancion.getIdC()}','Genero')">desactivar</a>
                        </c:if>
                        
                            <c:if test="${Cancion.getEstadoC() == false}">
                                <a rol="button" class="btn btn-success" onclick="activar(event,'${Cancion.getIdC()}','Genero')">activar</a>
                            </c:if>
                    </td>
                    
                    <td>
                    <a type="button " href="Genero?accion=abrirC&idC=${Cancion.getIdC()}&nombreC=${Cancion.getNombreC()}&fgrab=${Cancion.getFgrab()}&duraC=${Cancion.getDuraC()}">
                    <i class="fa-solid fa-pencil"></i>
                    </a>
        
                    <a rol="button" class="btn btn-danger" onclick="borrar(event, '${Cancion.getIdC()}','Genero')">
                    <i class="fa-solid fa-trash-can"></i>
                    </a>
                    
                    </td>
                            </tr>
        </c:forEach>
        </tbody>
        <script src="//cdn.jsdelivr.net/npm/sweetalert2@11"></script>
      </table>
</body>
</html>