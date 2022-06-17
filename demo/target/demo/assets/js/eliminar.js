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
              ruta=cont+"?accion=eliminarGenero&id="+cod;
              console.log(ruta);
              window.setTimeout(function(){window.location.href = ruta},200)
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