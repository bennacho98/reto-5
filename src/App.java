import views.View;

//Pruebas unicamente
public class App {
    
    public static void main(String[] args) throws Exception {
    //Pruebas locales
    View principal = new View("jdbc:mysql://localhost:3306/proyectos");
    // View principal = new View("jdbc:sqlite:ProyectosConstruccion.db");
   
    principal.setVisible(true);
    }
   }
