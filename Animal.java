import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Animal {

    private int idAnimal;
    private String nome;
    private String especie;

    public Animal(
        int idAnimal,
        String nome,
        String especie

    )throws SQLException{
        this.idAnimal = idAnimal;
        this.nome = nome;
        this.especie = especie;

        PreparedStatement stmt = DAO.createConnection().prepareStatement(
            "INSERT INTO animal (idAnimal, nome, especie) VALUES (?, ?, ?)"
        );
        stmt.setInt(1, idAnimal);
        stmt.setString(2, nome);
        stmt.setString(3, especie);
        stmt.execute();
        stmt.close();
    }

    public static void listarAnimal() throws SQLException{
        Connection connec = DAO.createConnection();
        ResultSet rs = connec.createStatement().executeQuery(
            "SELECT * FROM Animal;"
        );
        while(rs.next()){
            System.out.println(
                "ID: " + rs.getInt("idAnimal") + "-"+
                "nome: " + rs.getString("nome") + "-"+
                "especie: " + rs.getString("especie")
            );
        }
    }

    public static void updateAnimal(String nome, String especie, int idAnimal) throws SQLException{
        PreparedStatement stmt = DAO.createConnection().prepareStatement(
            "UPDATE animal SET nome = ?, especie = ? WHERE idAnimal = ?;"
        );
        stmt.setString(1, nome);
        stmt.setString(2, especie);
        stmt.setInt(3, idAnimal);
        stmt.execute();
        stmt.close();
    }

    public static void deleteAnimal(int idAnimal) throws SQLException{
        PreparedStatement stmt = DAO.createConnection().prepareStatement(
                "DELETE FROM animal WHERE idAnimal = ?;"
        );
        stmt.setInt(1, idAnimal);
        stmt.execute();
        stmt.close();
    }
    
    public int getIdAnimal(){
        return idAnimal;
    }
    public void setId(int idAnimal){
        this.idAnimal = idAnimal;
    }
    public String getNome(){
        return nome;
    }
    public void setNome(String nome){
        this.nome = nome;
    }
    public String getEspecie(){
        return especie;
    }
    public void setEspecie(String especie){
        this.especie = especie;
    }

    @Override
    public String toString(){
        return "Id: " + idAnimal + "\n"
        + "Nome: " + nome + "\n"
        + "Especie: " + especie + "\n";
    } 

    @Override 
    public boolean equals (Object object){
        if(object == null || !(object instanceof Animal)){
            return false;
        }
        final Animal other = (Animal) object;

        return this.getIdAnimal() == other.getIdAnimal();
    }
}