import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Jaula {

    private int idJaula;
    private String nome;
    private String tipo;
    private int idAnimal;

    public Jaula(
        int idJaula,
        String nome,
        String tipo,
        int idAnimal

    ) throws SQLException{
        this.idJaula = idJaula;
        this.nome = nome;

        PreparedStatement stmt = DAO.createConnection().prepareStatement(
            "INSERT INTO Fabricante (idJaula, nome, tipo, idAnimal) VALUES (?, ? , ?)"
        );
        stmt.setInt(1, idJaula);
        stmt.setString(2, nome);
        stmt.setString(3, tipo);
        stmt.setInt(4, idAnimal);
        stmt.execute();
        stmt.close();
    }
    public int getId(){
        return idJaula;
    }
    public void setId(int idJaula){
        this.idJaula = idJaula;
    }
    public String nome(){
        return nome;
    }
    public void setNome(String nome){
        this.nome = nome;
    }
    public String tipo(){
        return tipo;
    }
    public void setTipo(String tipo){
        this.tipo = tipo;
    }

    public static void listarJaula() throws SQLException{
        Connection connec = DAO.createConnection();
        ResultSet rs = connec.createStatement().executeQuery(
            "SELECT * FROM Jaula;"
        );
        while(rs.next()){
            System.out.println(
                "Id: " + rs.getInt("id") + 
                "Nome: " + rs.getString("nome") + 
                "Tipo: " + rs.getString("tipo") +
                "idAnimal: " + rs.getInt("idAnimal")
            );
        }
    }
    public static void updateJaula(int idJaula) throws SQLException{
        PreparedStatement stmt = DAO.createConnection().prepareStatement(
            "UPDATE Jaula SET id = ? WHERE nome = ?;"
            );
            stmt.setInt(1, idJaula);
            stmt.setString(2, "jaula");
            stmt.setString(3, "ferro");
            stmt.setString(4, "urso");
            stmt.close();
    }
    public static void deleteJaula(int idJaula) throws SQLException{
        PreparedStatement stmt = DAO.createConnection().prepareStatement(
            "DELETE FROM Jaula WHERE id = ?;"
            );
            stmt.setInt(1, idFabricante);
            stmt.execute();
            stmt.close();
    }
}