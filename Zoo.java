import java.util.Scanner;
import java.sql.SQLException;

public class Zoo {

    public static void main(String[] args) throws Exception{
        Scanner scanner = new Scanner(System.in);
        int op = 0;

        System.out.println("Boas vindas ao zoologico!!");

        do{
            System.out.println("-----------------------");
            System.out.println("1 - Cadastrar Animal ");
            System.out.println("2 - Listar Animal ");
            System.out.println("3 - Atualizar Animal ");
            System.out.println("4 - Excluir Animal ");
            System.out.println("5 - Cadastrar Jaula ");
            System.out.println("6 - Listar Jaula ");
            System.out.println("7 - Atualizar Jaula ");
            System.out.println("8 - Excluir Jaula ");
            System.out.println("-----------------------");

            try{
                op = scanner.nextInt();
            }catch (Exception e){
                op = 0;
            }

            switch (op) {
                case 1:
                    cadastrarAnimal(scanner);
                    break;
                case 2:
                
                    Animal.listarAnimal();
                    break;
                case 3:
                    System.out.println("Informe o Id do Animal que você gostaria de alterar: ");
                    int idAnimal = scanner.nextInt();
                    Animal.updateAnimal(idAnimal);
                    break;
                case 4:
                    deleteAnimal(scanner);
                    break;
                case 5:
                    cadastrarJaula(scanner);
                    break;
                case 6:
                    Jaula.listarJaula();
                case 7:
                    System.out.println("Informe o Id do Jaula que você gostaria de alterar: ");
                    int idJaula = scanner.nextInt();
                    Jaula.updateJaula(idJaula);
                    break;
                case 8:
                    deleteJaula(scanner);
                    break;
            }
        }while(op!= 0);
        scanner.close();
    }

    public static void cadastrarAnimal(Scanner scanner){
        try{
            System.out.println("Cadastro de Animal");
            System.out.println("Digite o Id do Animal: ");
            int id = scanner.nextInt();
            System.out.println("Digite nome do Animal: ");
            String nome = scanner.next();
            System.out.println("Digite a especie desse Animal: ");
            String especie = scanner.next();
            
            new Animal(id, nome, especie);
        }catch(Exception e){
            System.out.println("Erro ao cadastrar o Animal");
        }
    }

    public static void deleteAnimal(Scanner scanner) throws SQLException{
        try{
        System.out.println("Informe o id do Animal");
        int idAnimal = scanner.nextInt();
        Animal.deleteAnimal(idAnimal);
        System.out.println("Animal removido com sucesso!");
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    public static void cadastrarJaula(Scanner scanner) throws SQLException{
        try{
            System.out.println("Cadastro de Jaulas");
            System.out.println("Digite o Id do Jaula");
            int id = scanner.nextInt();
            System.out.println("Digite o nome da Jaula: ");
            String nome = scanner.next();
            System.out.println("Digite o tipo da Jaula: ");
            String tipo = scanner.next();
            System.out.println("Digite o animal que ficara na jaula: ");
            int idAnimal = scanner.nextInt();
            
            new Jaula(id, nome, tipo, idAnimal);
        }catch(Exception e){
            System.out.println("Erro ao cadastrar o Jaula");
        }
    }

    public static void deleteJaula(Scanner scanner) throws SQLException{
        try{
            System.out.println("Informe o id do Jaula: ");
            int idJaula = scanner.nextInt();
            Jaula.deleteJaula(idJaula);
            System.out.println("Jaula removida com sucesso!");
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    } 
}