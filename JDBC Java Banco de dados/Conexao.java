import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {

    private String host;
    private String port; 
    private String dbName;
    private String dbUser;
    private String dbPass;

    public Conexao(String host, String port, String dbName, String dbUser, String dbPass){
        this.host = host;
        this.port = port;
        this.dbName = dbName;
        this.dbUser = dbUser;
        this.dbPass = dbPass;
    }

public Connection getConnection(){
    String strConn = "jdbc:mysql://" + host + ":" + port + "/" + dbName;
    Connection connection = null;
    
    try {
        connection = DriverManager.getConnection(strConn, this.dbUser, this.dbPass);

    } catch (SQLException e){
        e.printStackTrace();
    }

    return connection;
}

}