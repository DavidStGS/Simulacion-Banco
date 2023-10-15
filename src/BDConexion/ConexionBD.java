package BDConexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class ConexionBD {
    Connection cn;
    Statement st;

public Connection Conexion(){
try {

    cn=(Connection) DriverManager.getConnection("jdbc:mysql:127.0.0.1:3306/banco","root","");
}   catch (SQLException e) {
}
return cn;
}
}
