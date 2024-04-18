import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Main {

    public static void main(String[] args) {
        // Estabelece a conexão com o banco de dados
        Conexao conexao = new Conexao("localhost", "3306", "javaJdbc", "root", "");
        Connection connection = conexao.connect();

        // Verifica se a conexão foi estabelecida com sucesso
        if (connection != null) {
            System.out.println("Conexão estabelecida com sucesso!");

            // Aqui você pode realizar operações no banco de dados, se desejar
        } else {
            System.err.println("Falha ao conectar ao banco de dados.");
        }

        // Fecha a conexão com o banco de dados
        conexao.closeConnection();
    }
}

class Conexao {

    private String host;
    private String port;
    private String dbName;
    private String dbUser;
    private String dbPass;
    private Connection connection;

    public Conexao(String host, String port, String dbName, String dbUser, String dbPass) {
        this.host = host;
        this.port = port;
        this.dbName = dbName;
        this.dbUser = dbUser;
        this.dbPass = dbPass;
    }

    public Connection connect() {
        String strConn = "jdbc:mysql://" + host + ":" + port + "/" + dbName;

        try {
            connection = DriverManager.getConnection(strConn, dbUser, dbPass);
            return connection;
        } catch (SQLException e) {
            System.err.println("Erro ao conectar ao banco de dados: " + e.getMessage());
            return null;
        }
    }

    public void closeConnection() {
        try {
            if (connection != null) {
                connection.close();
                System.out.println("Conexão fechada com sucesso!");
            }
        } catch (SQLException e) {
            System.err.println("Erro ao fechar a conexão com o banco de dados: " + e.getMessage());
        }
    }
}
