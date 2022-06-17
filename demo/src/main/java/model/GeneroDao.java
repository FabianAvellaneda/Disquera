package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class GeneroDao {
        //Atributos para realizar operaciones sobre la BD
        Connection con; //Objeto para la conexion
        PreparedStatement ps;//Objeto para llamar las sentencias preparadas
        ResultSet rs;//objeto para almacenar los resultados de las consultas
        String sql=null;//Variable para almacenar las sentencias de SQL
        int r;
    
        //Metodos
    
        public int registrar(GeneroVo generos) throws SQLException{
            sql = "INSERT INTO genero (nombre,estado) values (?,?)";
    
            try {
                con = conexion.conectar();//Abrir conexion
                ps = con.prepareStatement(sql); //Preparar sentencia
                ps.setString(1,generos.getNombre());
                ps.setBoolean(2, generos.getEstado());
                System.out.println(ps);
                ps.executeUpdate(); //Ejecutar sentencia
                ps.close(); //cerrar sentencia
                System.out.println("Se registró el genero correctamente");
            } catch (Exception e) {
                System.out.println("Error en el regisro "+e.getMessage().toString());
            }finally{
                con.close();//cerrando conexión
            } 
            return r;
        }
     
        public List<GeneroVo> listar() throws Exception{
            List<GeneroVo> generos = new ArrayList<>();
            sql = "SELECT * FROM genero";
    
            try {
                con = conexion.conectar();//Abre la conexion
                ps = con.prepareStatement(sql); //Prepara la sentencia select
                rs = ps.executeQuery();//Ejecutamos la setencia y guardamos los resultados 
    
                while (rs.next()) {
                    GeneroVo r = new GeneroVo();
                    r.setId(rs.getInt("id"));
                    r.setNombre(rs.getString("nombre"));
                    r.setEstado(rs.getBoolean("estado"));
                    generos.add(r);
                }
    
                ps.close();
                System.out.println("Consulta exitosa");
    
            } catch (Exception e) {
    
                System.out.println("Error de conexión a la base de datos "+e.getMessage().toString());
            } finally{
                con.close();//cerrando la conexion
            }
            return generos;
        }
        public void eliminarGenero(int id)throws SQLException{
            sql="DELETE FROM Genero WHERE id="+id;
            System.out.println(sql);
            try{
                con=conexion.conectar();
                ps=con.prepareStatement(sql);
                System.out.println(ps);
                ps.executeUpdate(sql);
                ps.close();
                System.out.println("Elimino correctamente el Genero");
            }catch(Exception e){
                System.out.println("Error no se Elimino"+e.getMessage());
            }
            finally{
                con.close();
            }
        }
        public void activar(int Id) throws SQLException {
            sql = "UPDATE Genero SET estado = '1' WHERE id = " + Id;
            System.out.println(sql);
            try {
              con=conexion.conectar();
              ps=con.prepareStatement(sql);
              ps.executeUpdate();
              ps.close();
              System.out.println("Se activo el genero");
            }catch(Exception e) {
              System.out.println("Error en la inactivacion del registro "+e.getMessage());
            }
            finally {
              con.close();
            }
          }

          public void desactivar(int Id) throws SQLException {
            sql = "UPDATE Genero SET estado = '0' WHERE id = " + Id;
            System.out.println(sql);
            try {
              con=conexion.conectar();
              ps=con.prepareStatement(sql);
              ps.executeUpdate();
              ps.close();
              System.out.println("Se desactivo el genero");
            }catch(Exception e) {
              System.out.println("Error en la inactivacion del registro "+e.getMessage());
            }
            finally {
              con.close();
            }
          }
          
          public void modificar(int Id, String Nombre) throws SQLException {
            sql = "UPDATE Genero SET nombre = '" + Nombre + "' WHERE id = " + Id;
            System.out.println(sql);
            try {
              con = conexion.conectar();
              ps = con.prepareStatement(sql);
              System.out.println(ps);
              ps.executeUpdate();
              ps.close();
              System.out.println("Se actualizo el genero");
            } catch (Exception e) {
              System.out.println("Error en la actualizacion del registro " + e.getMessage());
            } finally {
              con.close();
            }
          }
}
