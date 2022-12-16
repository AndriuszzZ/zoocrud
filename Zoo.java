import java.util.Scanner;

import javax.print.PrintException;

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
                    cadastrarAnimal();
                    break;
                case 2:
                    Animal.listarAnimal();
                    break;
                case 3:
                    updateAnimal();
                    break;
                case 4:
                    System.out.println("Id do Animal no qual deseja excluir");
                    int idAnimal = scanner.nextInt();
                    Animal.deleteAnimal(idAnimal);
                    break;
                case 5:
                    cadastrarJaula();
                    break;
                case 6:
                    Jaula.listarJaula();
                    break;
                case 7:
                    updateJaula();
                    break;
                case 8:
                    System.out.println("Informe o id do Jaula: ");
                    int idJaula = scanner.nextInt();
                    try{
                        Jaula.deleteJaula(idJaula);
                        System.out.println("Jaula removida com sucesso!");
                    }catch(Exception e){
                        System.out.println("Erro ao remover!");
                    }
                    break;
            }
        }while(op!= 0);
        scanner.close();
    }


    public static void cadastrarAnimal() throws SQLException{
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

    public static void updateAnimal()throws SQLException{
        System.out.println("nome");
        String nome = scanner.next();
        System.out.println("especie");
        String especie = scanner.next();
        System.out.println("Informe o Id do animal que você gostaria de alterar: ");
        int idAnimal = scanner.nextInt();
        try{
            Animal.updateAnimal(
                nome,
                especie,
                idAnimal
            );
        }catch(Exception e){
            e.printStackTrace();
            System.out.println("Erro ao Alterar as informações");
        }
    }

    public static void cadastrarJaula()throws SQLException{
        try{
            System.out.println("Cadastro de Jaulas");
            System.out.println("Digite o Id do Jaula");
            int idJaula = scanner.nextInt();
            System.out.println("Digite o nome da Jaula: ");
            String nome = scanner.next();
            System.out.println("Digite o tipo da Jaula: ");
            String tipo = scanner.next();
            System.out.println("Digite o animal que ficara na jaula: ");
            int idAnimal = scanner.nextInt();
            
            new Jaula(idJaula, nome, tipo, idAnimal);
        }catch(SQLException e){
            e.printStackTrace();
            System.out.println("Erro ao cadastrar o Jaula");
        }
    }

    
    public static void updateJaula() throws SQLException{
        System.out.println("Nome: ");
        String nome = scanner.next();
        System.out.println("Tipo: ");
        String tipo = scanner.next();
        System.out.println("id do Animal da jaula");
        int idAnimal = scanner.nextInt();
        System.out.println("Informe o Id do Jaula que você gostaria de alterar: ");
        int idJaula = scanner.nextInt();
        try{
            Jaula.updateJaula(
            nome,
            tipo,
            idAnimal,
            idJaula
            );
        }catch(SQLException e){
            e.printStackTrace();
            System.out.println("Erro ao Alterar as informações");
        }
    }

    public static Scanner scanner = new Scanner(System.in);

}