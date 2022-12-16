import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class Jaula{

    private int idJaula;
    private String nome;
    private String tipo;
    private int idAnimal;

    public Jaula(
        int idJaula,
        String nome,
        String tipo,
        int idAnimal
    )throws SQLException{
        this.idJaula = idJaula;
        this.nome = nome;
        this.tipo = tipo;
        this.idAnimal = idAnimal;

        PreparedStatement stmt = DAO.createConnection().prepareStatement(
            "INSERT INTO Jaula (idJaula, nome, tipo, idAnimal) VALUES (?, ?, ?, ?)"
        );
        stmt.setInt(1, idJaula);
        stmt.setString(2, nome);
        stmt.setString(3, tipo);
        stmt.setInt(4, idAnimal);
        stmt.execute();
        stmt.close();
    }

    public static void listarJaula() throws SQLException{
        Connection connec = DAO.createConnection();
        ResultSet rs = connec.createStatement().executeQuery(
            "SELECT * FROM Jaula;"
        );
        while(rs.next()){
            System.out.println(
                "Id: " + rs.getInt("idJaula") + "-"+
                "Nome: " + rs.getString("nome") +"-"+
                "Tipo: " + rs.getString("tipo") +"-"+
                "idAnimal: " + rs.getInt("idAnimal")
            );
        }
    }
    public static void updateJaula(String nome, String tipo, int idAnimal,int idJaula) throws SQLException{
        PreparedStatement stmt = DAO.createConnection().prepareStatement(
            "UPDATE Jaula SET nome = ?, tipo = ?, idAnimal = ? WHERE idJaula = ?;"
            );

            stmt.setString(1, nome);
            stmt.setString(2, tipo);
            stmt.setInt(3, idAnimal);
            stmt.setInt(4, idJaula);
            stmt.close();
    }
    public static void deleteJaula(int idJaula) throws SQLException{
        PreparedStatement stmt = DAO.createConnection().prepareStatement(
            "DELETE FROM Jaula WHERE idJaula = ?;"
            );
            stmt.setInt(1, idJaula);
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

    @Override 
    public String toString(){
        return "Id: " + idJaula + "\n"
            + "Nome: " + nome + "\n"
            + "tipo: " + tipo + "\n"
            + "Animal: " + this.idAnimal + "\n";
    }
    
    @Override
    public boolean equals (Object object){
        if(object == null || !(object instanceof Jaula)){
            return false;
        }
        final Jaula other = (Jaula) object;
        
        return this.getId() == other.getId();
    }
}