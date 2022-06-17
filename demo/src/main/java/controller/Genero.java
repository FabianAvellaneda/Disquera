package controller;

//Librerias de mi servlet
import java.util.List;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//importar modelo
import model.GeneroDao;
import model.GeneroVo;
import model.CancionDao;
import model.CancionVo;

public class Genero extends HttpServlet {

    GeneroDao GDao= new GeneroDao();
    GeneroVo GVo = new GeneroVo();
    CancionDao CDao= new CancionDao();
    CancionVo CVo = new CancionVo();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Entro al DoGet");
        String accion = req.getParameter("accion");
        switch (accion) {
            case "abrirFormGen":
                abrirForm(req,resp);
                break;
            case "listarGenero":
                listar(req,resp);
                break;
                case "abrirFormC":
                abrirFormC(req,resp);
                break;
            case "listarC":
                listarC(req,resp);
                break;
            case "eliminarGenero":
            eliminarGenero(req, resp);
            break;
            case "eliminarCancion":
            eliminarCancion(req, resp);
            break;
            case "activar":
            activar(req, resp);
            break;
            case "desactivar":
            desactivar(req, resp);
            break;
            case "activarC":
            activarC(req, resp);
            break;
            case "desactivarC":
            desactivarC(req, resp);
            break;
            case "abrir":
            abrir(req, resp);
            break;
            case "abrirC":
            abrirC(req, resp);
            break;
            case "actualizar":
            actualizar(req,resp);
            case "actualizarC":
            actualizarC(req,resp);
            default:
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        System.out.println("Entró al DoPost");
        String accion=req.getParameter("accion");

        switch(accion){
            case "añadirGen":
                añadirGen(req,resp); 
            break;
            case "añadirC":
            añadirC(req,resp); 
            break;
            case "modificar":
            actualizar(req, resp); 
            break;
            case "modificarC":
            actualizarC(req, resp); 
            break;
        }
    }

    private void abrirForm(HttpServletRequest req, HttpServletResponse resp) {
        try{
            req.getRequestDispatcher("views/formulario.jsp").forward(req, resp);
            System.out.println("El formulario ha sido abierto");
        }catch(Exception e){
            System.out.println("El formulario NO ha sido abierto"+e.getMessage().toString());
        }
    }

    private void añadirGen(HttpServletRequest req, HttpServletResponse resp) {
        GeneroDao GDao= new GeneroDao();
        GeneroVo GVo = new GeneroVo();

        if(req.getParameter("nombre")!=null){
            GVo.setNombre(req.getParameter("nombre"));
        }
        if(req.getParameter("estado")!=null){
            GVo.setEstado(true);
        }else{
            GVo.setEstado(false);
        }
        try {
            GDao.registrar(GVo);
            resp.sendRedirect("Genero?accion=listarGenero");
            System.out.println("Registro insertado correctamente");
        } catch (Exception e) {
            req.setAttribute("msje","no se pudo registrar el Genero"+e.getMessage());
            System.out.println("Error en la inserción del registro "+e.getMessage().toString());
        } 
    }


    private void listar(HttpServletRequest req, HttpServletResponse resp) {
        try {
            List<GeneroVo> Genero=GDao.listar();
            req.setAttribute("generos", Genero);
            req.getRequestDispatcher("views/genero.jsp").forward(req, resp);
            System.out.println("Datos listados correctamente");
        } catch (Exception e) {
            System.out.println("Hay problemas al listar los datos "+e.getMessage().toString());
        }
    }

    private void eliminarGenero(HttpServletRequest req, HttpServletResponse resp) {
   
        if(req.getParameter("id")!=null) {
            GVo.setId(Integer.parseInt(req.getParameter("id")));
        }
        try{
            GDao.eliminarGenero(GVo.getId());
            resp.sendRedirect("Genero?accion=listarGenero");
            System.out.println("Genero Eliminado");
        }catch(Exception e){
            req.setAttribute("msje", "No se pudo eliminar el registro" + e.getMessage());
            System.out.println("No se pudo eliminar el registro" + e.getMessage());
        }finally{
            
        }
    }
    private void activar(HttpServletRequest req, HttpServletResponse resp) {
       
        GeneroDao GDao = new GeneroDao();
        GeneroVo GVo = new GeneroVo();

        if(req.getParameter("id")!=null) {
          GVo.setId(Integer.parseInt(req.getParameter("id")));
        }
        try{
          GDao.activar(GVo.getId());
          resp.sendRedirect("?accion=listarGenero");
          System.out.println("Genero Activado");
        }catch(Exception e){
          req.setAttribute("msje", "No se pudo eliminar el registro" + e.getMessage());
            System.out.println("No se pudo eliminar el registro" + e.getMessage());
          }finally{
    
          }
        }
        private void desactivar(HttpServletRequest req, HttpServletResponse resp) {
       
            GeneroDao GDao = new GeneroDao();
            GeneroVo GVo = new GeneroVo();
    
            if(req.getParameter("id")!=null) {
              GVo.setId(Integer.parseInt(req.getParameter("id")));
            }
            try{
              GDao.desactivar(GVo.getId());
              resp.sendRedirect("?accion=listarGenero");
              System.out.println("Genero Desactivado");
            }catch(Exception e){
              req.setAttribute("msje", "No se pudo eliminar el registro" + e.getMessage());
                System.out.println("No se pudo eliminar el registro" + e.getMessage());
              }finally{
        
              }
            }

            private void abrir(HttpServletRequest req, HttpServletResponse resp) {
                req.setAttribute("id", req.getParameter("id"));
                req.setAttribute("nombre", req.getParameter("nombre"));
                try {
                  req.getRequestDispatcher("views/formulario1.jsp").forward(req, resp);
                  System.out.println("El formulario ha sido abierto");
                } catch (Exception e) {
                  System.out.println("El formulario NO ha sido abierto" + e.getMessage().toString());
                }
              }
    
              private void actualizar(HttpServletRequest req, HttpServletResponse resp) {
                //Validar Datos
                if (req.getParameter("Id") != null) {
                  GVo.setId(Integer.parseInt(req.getParameter("Id")));
                }
          
                if (req.getParameter("Nombre") != null) {
                  GVo.setNombre(req.getParameter("Nombre"));
                }
          
                try {
                  GDao.modificar(GVo.getId(), GVo.getNombre());
                  System.out.println("Registro Editado Correctamente");
                  resp.sendRedirect("Genero?accion=listarGenero");
                } catch (Exception e) {
                  System.out.println("Error en la edicion del registro" + e.getMessage().toString());
                }
              }

//cancion

private void abrirFormC(HttpServletRequest req, HttpServletResponse resp) {
    try{
        req.getRequestDispatcher("views/formulario2.jsp").forward(req, resp);
        System.out.println("El formulario ha sido abierto");
    }catch(Exception e){
        System.out.println("El formulario NO ha sido abierto"+e.getMessage().toString());
    }
}

private void listarC(HttpServletRequest req, HttpServletResponse resp) {
    try {
        List<CancionVo> Cancion=CDao.listarC();
        req.setAttribute("canciones", Cancion);
        req.getRequestDispatcher("views/cancion.jsp").forward(req, resp);
        System.out.println("Datos listados correctamente");
    } catch (Exception e) {
        System.out.println("Hay problemas al listar los datos "+e.getMessage().toString());
    }
}

private void añadirC(HttpServletRequest req, HttpServletResponse resp) {
    CancionDao CDao= new CancionDao();
    CancionVo CVo = new CancionVo();

    if(req.getParameter("nombreC")!=null){
        CVo.setNombreC(req.getParameter("nombreC"));
    }
    if(req.getParameter("fgrab")!=null){
        CVo.setFgrab(req.getParameter("fgrab"));
    }
    if(req.getParameter("duraC")!=null){
        CVo.setDuraC(req.getParameter("duraC"));
    }
    if(req.getParameter("estadoC")!=null){
        CVo.setEstadoC(true);
    }else{
        CVo.setEstadoC(false);
    }
    try {
        CDao.registrar(CVo);
        resp.sendRedirect("Genero?accion=listarC");
        System.out.println("Registro insertado correctamente");
    } catch (Exception e) {
        req.setAttribute("msje","no se pudo registrar el Cancion"+e.getMessage());
        System.out.println("Error en la inserción del registro "+e.getMessage().toString());
    } 
}

private void eliminarCancion(HttpServletRequest req, HttpServletResponse resp) {
   
    if(req.getParameter("idC")!=null) {
        CVo.setIdC(Integer.parseInt(req.getParameter("idC")));
    }
    try{
        CDao.eliminarCancion(CVo.getIdC());
        resp.sendRedirect("Genero?accion=listarC");
        System.out.println("Cancion Eliminado");
    }catch(Exception e){
        req.setAttribute("msje", "No se pudo eliminar el registro" + e.getMessage());
        System.out.println("No se pudo eliminar el registro" + e.getMessage());
    }finally{
        
    }
}
private void activarC(HttpServletRequest req, HttpServletResponse resp) {
       
    CancionDao cDao = new CancionDao();
    CancionVo cVo = new CancionVo();

    if(req.getParameter("idC")!=null) {
      cVo.setIdC(Integer.parseInt(req.getParameter("idC")));
    }
    try{
      cDao.activarC(cVo.getIdC());
      resp.sendRedirect("?accion=listarC");
      System.out.println("Cancion Activado");
    }catch(Exception e){
      req.setAttribute("msje", "No se pudo eliminar el registro" + e.getMessage());
        System.out.println("No se pudo eliminar el registro" + e.getMessage());
      }finally{

      }
    }
    private void desactivarC(HttpServletRequest req, HttpServletResponse resp) {
   
        CancionDao cDao = new CancionDao();
        CancionVo cVo = new CancionVo();

        if(req.getParameter("idC")!=null) {
          cVo.setIdC(Integer.parseInt(req.getParameter("idC")));
        }
        try{
          cDao.desactivarC(cVo.getIdC());
          resp.sendRedirect("?accion=listarC");
          System.out.println("Cancion Desactivada");
        }catch(Exception e){
          req.setAttribute("msje", "No se pudo eliminar el registro" + e.getMessage());
            System.out.println("No se pudo eliminar el registro" + e.getMessage());
          }finally{
    
          }
        }
        private void abrirC(HttpServletRequest req, HttpServletResponse resp) {
          req.setAttribute("idC", req.getParameter("idC"));
          req.setAttribute("nombreC", req.getParameter("nombreC"));
          req.setAttribute("fgrab", req.getParameter("fgrab"));
          req.setAttribute("duraC", req.getParameter("duraC"));
          try {
            req.getRequestDispatcher("views/formulario3.jsp").forward(req, resp);
            System.out.println("El formulario ha sido abierto");
          } catch (Exception e) {
            System.out.println("El formulario NO ha sido abierto" + e.getMessage().toString());
          }
        }
        private void actualizarC(HttpServletRequest req, HttpServletResponse resp) {
          //Validar Datos
          if (req.getParameter("IdC") != null) {
            CVo.setIdC(Integer.parseInt(req.getParameter("IdC")));
          }
    
          if (req.getParameter("NombreC") != null) {
            CVo.setNombreC(req.getParameter("NombreC"));
          }
          if (req.getParameter("Fgrab") != null) {
            CVo.setFgrab(req.getParameter("Fgrab"));
          }
          if (req.getParameter("DuraC") != null) {
            CVo.setDuraC(req.getParameter("DuraC"));
          }
    
          try {
            CDao.modificarC(CVo.getIdC(), CVo.getNombreC(), CVo.getFgrab(), CVo.getDuraC());
            System.out.println("Registro Editado Correctamente");
            resp.sendRedirect("Genero?accion=listarC");
          } catch (Exception e) {
            System.out.println("Error en la edicion del registro" + e.getMessage().toString());
          }
        }
}
