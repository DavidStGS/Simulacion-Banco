package BDConexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class ConexionBD {
    Connection cn;
    Statement st;

public Connection Conexion(){
try {

    cn=(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/Banco","root","");
    System.out.println("Conexión exitosa");
}   catch (Exception e) {
        System.err.println(e.getMessage());
        System.out.println(e);
}
return cn;
}
}
