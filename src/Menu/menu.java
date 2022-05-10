package Menu;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import Classes.Controle;

public class menu {
    private int escolha;
    Scanner sc1 = new Scanner(System.in);
    boolean rum = false;


   
    Controle controle = new Controle();

    public void prit() throws Exception{
        System.out.println("Escolha uma interação com o banco de dados:");
        System.out.println("0-Sair \n1  - Incluir Aluno \n2 - Atualizar Cadastro \n3 - Exibir Dados \n4 - Apagar Dados \n5  - Atualizar telefones");
        System.out.println("Escolha uma opção: ");
        

        try{
            this.escolha=sc1.nextInt();
            
        }catch (InputMismatchException e){
                    
            do{
                rum=true;
                System.out.println("Escolha um numero!");
                try{
                    Scanner sc2 =new Scanner(System.in);
                this.escolha=sc2.nextInt();
                    rum=false;
                }catch (Exception f){
                    rum=true;
                }
            }while(rum);
            
            
    }

        escolha();
    }   


    public void escolha() throws Exception{

        switch(escolha){
            case 0:
                break;

            case 1:
                 controle.cad_aluno();
                 prit();
                break;
            case 2:
                controle.atualizar_aluno();
                prit();
                break;

            case 3:
                controle.dados_aluno();
                prit();
                break;
            case 4:
                controle.apagar_aluno();
                prit();
                break;

            case 5:
                controle.cad_telefone();
                prit();
                break;



            default:
            System.out.println("Opção invalida");

        }
    }
}
