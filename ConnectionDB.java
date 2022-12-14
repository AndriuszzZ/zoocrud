import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ConnectionDB {
    public static void main(String[] args) {
        try{
            Connection conex = DAO.createConnection();

            imprimirUsuarios(conex);

            PreparedStatement stmt = conex.prepareStatement(
                "DELETE FROM usuario WHERE id = ?;"
            );
            stmt.setInt(1, 2);
            stmt.execute();
            imprimirUsuarios(conex);

            stmt = conex.prepareStatement(
                "UPGRADE usuario SET user_name = ?, name = ?, password = ? WHERE id = ?;"
            );
            stmt.setString();
            stmt.setString();
            stmt.setString();
            stmt.setInt();
            stmt.execute();
            imprimirUsuarios(conex);
        } catch (Exception e) {
            System.out.println(e);
        }

    }

    public static void imprimirUsuarios(Connection conex) throws Exception {
        ResultSet rs = conex.createStatement().executeQuery(
            "SELECT * FROM usuario;"
        );
        while(rs.next()){
            User usuario2 = new Usuario(
                rs.getInt(),
                rs.getString(),
                rs.getString(),
                rs.getString()
            );
            System.out.println(usuario2);
            System.out.println("========")
        }
    }
}