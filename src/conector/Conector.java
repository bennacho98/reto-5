package conector;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.DriverManager;

 public class Conector {

     private static Connection connect;
    
     public Conector(String url) {
         super();
         connectDB(url);
     }

     public static Connection getConnect() {
         return connect;
     }
 
     public ResultSet getReq1DB() {
         
         String sql = "SELECT SUM(cantidad) as total, id_proyecto, pagado, proveedor FROM Compra WHERE pagado = 'No' GROUP BY ID_Proyecto HAVING (Total) > 50;"; 
         return executeQuery(sql);
         }

     public ResultSet getReq2DB() {

         
         String sql = "SELECT Proyecto.Fecha_Inicio  as inicio, Tipo.Financiable, Tipo.Estrato , Proyecto.Porcentaje_Cuota_Inicial * 100 FROM Tipo, Proyecto WHERE Proyecto.ID_Tipo = Tipo.ID_Tipo AND Proyecto.Porcentaje_Cuota_Inicial  > 0.2 AND Tipo.Estrato >= 5 AND Tipo.Financiable = 0 ORDER BY inicio;"; 
         return executeQuery(sql);
         }

     public ResultSet getReq3DB() {
     
         
         String sql = "SELECT Proyecto.Clasificacion, Proyecto.ID_Proyecto, Compra.pagado FROM MaterialConstruccion, Compra, Proyecto WHERE MaterialConstruccion.Importado = 'Si' AND Compra.ID_MaterialConstruccion = MaterialConstruccion.ID_MaterialConstruccion AND Proyecto.ID_Proyecto = Compra.ID_Proyecto AND Compra.Pagado IN ('Parcialmente','No') AND Proyecto.Clasificacion IN ('Apartamento','Apartaestudio') AND Proyecto.Acabados = 'No' GROUP BY Proyecto.ID_Proyecto;"; 
         return executeQuery(sql);
         }

     public Connection connectDB(String url) {

         try {
             connect = DriverManager.getConnection(url, "root", "");
             boolean isValid = connect.isValid(500);
             System.out.println(isValid ? "Connected" : "Failed"); 
         } catch (Exception e) {
             System.out.println(e.getMessage());
         }
         return connect;
     }

     public ResultSet executeQuery(String sql) {
         ResultSet rs = null;
         try {
             Statement stmt = connect.createStatement();
             rs = stmt.executeQuery(sql);
         } catch (SQLException e) {
             e.printStackTrace();
         }
         return rs;
     }
 }