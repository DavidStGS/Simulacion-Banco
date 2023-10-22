package BDConexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class ConexionBD {

    Connection cn;
    Statement st;

    public Connection Conexion() {
        try {

            cn = (Connection) DriverManager.getConnection("jdbc:mysql://bancobd.mysql.database.azure.com:3306/bankbd", "DavidSGS", "24082001Sepulveda");
        } catch (SQLException e) {
        }
        return cn;
    }
}
