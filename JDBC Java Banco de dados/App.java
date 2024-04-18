import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class App {

    public static void main(String[] args) {
        ArrayList<Pessoa> pessoas = new ArrayList<Pessoa>();
        Conexao conexao = new Conexao("localhost", "3306", "aulajdbc", "root", "" );
        Connection connection = conexao.getConnection();
        //System.out.println(connection);

        try {
            PreparedStatement statementSql = connection.prepareStatement("select * from pessoas");
            ResultSet rs = statementSql.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String nome = rs.getString("nome");
                Pessoa p = new Pessoa(nome);
                p.setId(id);
                pessoas.add(p);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        //System.out.println(pessoas);
        for (Pessoa p : pessoas){
            System.out.println(p.getNome());
        }
    }
}