package universidadejemplo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.Month;
import javax.swing.JOptionPane;

public class UniversidadEjemplo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        try{
            // Cargar drive de conexion.
            Class.forName("org.mariadb.jdbc.Driver");
            
            // Conexion a la base de datos
            Connection conn = DriverManager.getConnection("jdbc:mariadb://localhost/universidadulp","root", ""); 
        
            // Agregar una materia
            
            /*String sql = "insert into materia (nombre, año, estado) values ('Laboratorio 2',2,true)";
            PreparedStatement ps = conn.prepareStatement(sql);
            int filas = ps.executeUpdate();
            if(filas > 0){
                JOptionPane.showMessageDialog(null,"Materia agregada Exitosamente");
            }*/
            
            // Agregar un alumno
            
//            String sql = "insert into alumno (dni, apellido, nombre, fechaNacimiento, estado) values (52745628, 'Lopez', 'Juan', '"+LocalDate.of(2000,Month.AUGUST,29)+"', true);";
//            PreparedStatement ps = conn.prepareStatement(sql);
//            int filas = ps.executeUpdate();
//            if(filas > 0){
//                JOptionPane.showMessageDialog(null,"Alumno agregado Exitosamente");
//            }

            // Obtener todos los alumnos activos y listarlos por consola.
            
//            String sql = "select * from alumno where estado = true";
//            PreparedStatement ps = conn.prepareStatement(sql);
//            ResultSet resultado = ps.executeQuery();
//            
//            while(resultado.next()){
//                System.out.println("Id "+resultado.getInt("idAlumno"));
//                System.out.println("DNI "+resultado.getInt("dni"));
//                System.out.println("Apellido "+resultado.getString("apellido"));
//                System.out.println("Nombre "+resultado.getString("nombre"));
//                System.out.println("Fecha de Nacimiento "+resultado.getDate("fechaNacimiento"));
//                System.out.println("--------------------------------------------------------...");
//            }
            
            // Dar de baja a un alumno
            
            
            String sql="update alumno set estado = false where dni = 52745628";
            PreparedStatement ps = conn.prepareStatement(sql);
            int filas = ps.executeUpdate();
            if(filas > 0){
              JOptionPane.showMessageDialog(null,"Alumno dado de baja Exitosamente");
            }
        }catch (ClassNotFoundException ex){
            JOptionPane.showMessageDialog(null,"Debe agregar los driver del proyecto!!!");
        }catch (SQLException ex){
            JOptionPane.showMessageDialog(null,"Error "+ex.getMessage());
        }
        
    }
    
}
