package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class CancionDao {
    //Atributos para realizar operaciones sobre la BD
    Connection con; //Objeto para la conexion
    PreparedStatement ps;//Objeto para llamar las sentencias preparadas
    ResultSet rs;//objeto para almacenar los resultados de las consultas
    String sql=null;//Variable para almacenar las sentencias de SQL
    int d;

    //Metodos
    public int registrar(CancionVo canciones) throws SQLException{
        sql = "INSERT INTO Cancion (nombreC,fgrab,duraC,estadoC) values (?,?,?,?)";

        try {
            con = conexion.conectar();//Abrir conexion
            ps = con.prepareStatement(sql); //Preparar sentencia
            ps.setString(1,canciones.getNombreC());
            ps.setString(2,canciones.getFgrab());
            ps.setString(3,canciones.getDuraC());
            ps.setBoolean(4, canciones.getEstadoC());
            System.out.println(ps);
            ps.executeUpdate(); //Ejecutar sentencia
            ps.close(); //cerrar sentencia
            System.out.println("Se registró el Cancion correctamente");
        } catch (Exception e) {
            System.out.println("Error en el regisro "+e.getMessage().toString());
        }finally{
            con.close();//cerrando conexión
        } 
        return d;
    }
 
    public List<CancionVo> listarC() throws Exception{
        List<CancionVo> canciones = new ArrayList<>();
        sql = "SELECT * FROM Cancion";

        try {
            con = conexion.conectar();//Abre la conexion
            ps = con.prepareStatement(sql); //Prepara la sentencia select
            rs = ps.executeQuery();//Ejecutamos la setencia y guardamos los resultados 

            while (rs.next()) {
                CancionVo d = new CancionVo();
                d.setIdC(rs.getInt("idC"));
                d.setNombreC(rs.getString("nombreC"));
                d.setFgrab(rs.getString("fgrab"));
                d.setDuraC(rs.getString("duraC"));
                d.setEstadoC(rs.getBoolean("estadoC"));
                canciones.add(d);
            }

            ps.close();
            System.out.println("Consulta exitosa");

        } catch (Exception e) {

            System.out.println("Error de conexión a la base de datos "+e.getMessage().toString());
        } finally{
            con.close();//cerrando la conexion
        }
        return canciones;
    }

    public void eliminarCancion(int idC)throws SQLException{
        sql="DELETE FROM Cancion WHERE idC="+idC;
        System.out.println(sql);
        try{
            con=conexion.conectar();
            ps=con.prepareStatement(sql);
            System.out.println(ps);
            ps.executeUpdate(sql);
            ps.close();
            System.out.println("Elimino correctamente la Cancion");
        }catch(Exception e){
            System.out.println("Error no se Elimino"+e.getMessage());
        }
        finally{
            con.close();
        }
    }
    public void activarC(int IdC) throws SQLException {
        sql = "UPDATE Cancion SET estadoC = '1' WHERE idC = " + IdC;
        System.out.println(sql);
        try {
          con=conexion.conectar();
          ps=con.prepareStatement(sql);
          ps.executeUpdate();
          ps.close();
          System.out.println("Se activo la cancion");
        }catch(Exception e) {
          System.out.println("Error en la inactivacion del registro "+e.getMessage());
        }
        finally {
          con.close();
        }
      }

      public void desactivarC(int IdC) throws SQLException {
        sql = "UPDATE Cancion SET estadoC = '0' WHERE idC = " + IdC;
        System.out.println(sql);
        try {
          con=conexion.conectar();
          ps=con.prepareStatement(sql);
          ps.executeUpdate();
          ps.close();
          System.out.println("Se desactivo la cancion");
        }catch(Exception e) {
          System.out.println("Error en la inactivacion del registro "+e.getMessage());
        }
        finally {
          con.close();
        }
      }
      public void modificarC(int IdC, String NombreC, String Fgrab, String DuraC) throws SQLException {
        sql = "UPDATE Cancion SET nombreC = '" + NombreC + "' ,fgrab = '"+Fgrab+"' ,fgrab = '"+Fgrab+"' ,DuraC = '"+DuraC+"' WHERE idC = " + IdC;
        System.out.println(sql);
        try {
          con = conexion.conectar();
          ps = con.prepareStatement(sql);
          System.out.println(ps);
          ps.executeUpdate();
          ps.close();
          System.out.println("Se actualizo la Cancion");
        } catch (Exception e) {
          System.out.println("Error en la actualizacion del registro " + e.getMessage());
        } finally {
          con.close();
        }
      }
}
