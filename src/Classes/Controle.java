package Classes;
import DAO.alunoDAO;

import java.util.Scanner;

public class Controle {
    public int idaluno;
    public String nome,cidade,estado,numero = "";
    alunoDAO alunoDAO = new alunoDAO();
    aluno aluno = new aluno();
    Scanner sc = new Scanner(System.in);
    //cadastro de aluno + telefone do mesmo ( se quiser)
    public void cad_aluno(){

        alunoDAO alunoDAO = new alunoDAO();
        aluno aluno = new aluno();
      
        System.out.println("Digite o nome do aluno: ");
        nome=sc.nextLine();
        
        aluno.setNome(nome);
        System.out.println("Digite a Cidade: ");
        cidade=sc.nextLine();
        aluno.setCidade(cidade);
        System.out.println("Digite o estado: ");
        estado=sc.nextLine();
        aluno.setEstado(estado);


        alunoDAO.save(aluno);
        
        cad_telefone(alunoDAO.last_ID());
    }
  
    //cadastro de telefone de aluno cujo ja tenha o id 
    public void cad_telefone(int idaluno){
        
        telefone telefone = new telefone();
        System.out.println("Cadastro de telefone do Aluno"+"\n Caso não queiraca cadastrar digite 0.");
     
        telefone.setIdaluno(idaluno);
        for(int cont=0;cont<=2;cont++){
            System.out.println("Digite o numero do aluno: ");
            numero=sc.next();

            if(numero.equals("0")){
                
                break;
            }
            
                telefone.setNumero(numero);
                
                alunoDAO.savetelefone(telefone);
            
            
            
        }
        
    }
 
    //dados dos alunos + o telefone da criatura
    public void dados_aluno() throws Exception{
        alunoDAO alunoDAO = new alunoDAO();
        
        for(aluno aluno :(alunoDAO.getaluno())){
            System.out.println("ID Aluno: "+aluno.getIdaluno()+ " Aluno: " + aluno.getNome() +  "\nCidade: "+aluno.getCidade() + " Estado: " + aluno.getEstado());
            telef(aluno.getIdaluno());
        }
    }
 
    //atualizar cadastro de aluno
    public void atualizar_aluno() throws Exception{
        alunoDAO alunoDAO = new alunoDAO();
        aluno aluno = new aluno();
        
        System.out.println("Qual ID do Aluno: ");
        idaluno=sc.nextInt();
        aluno.setIdaluno(idaluno);
        System.out.println("Digite o nome do Aluno: ");
        nome=sc.next();
        aluno.setNome(nome);
        System.out.println("Digite o estado: ");
        estado=sc.next();
        aluno.setEstado(estado);
        System.out.println("Digite a Cidade");
        cidade=sc.next();
        aluno.setCidade(cidade);
        
        alunoDAO.update_aluno(aluno);
    }
   
    //apagar a criatura do banco de dados
    public void apagar_aluno() throws Exception{

        System.out.println("Digite o Id do aluno que deseja deletar: ");
        idaluno=sc.nextInt();
        alunoDAO.deletar_aluno(idaluno);
    }
  
    //exibir telefone dos alunos pede o id
    public void exibir_telefones_aluno() throws Exception{
        System.out.println("Digite o idaluno: ");
        idaluno=sc.nextInt();
        alunoDAO.gettelefone(idaluno);

        for(telefone telefone :(alunoDAO.gettelefone(idaluno))){
            System.out.println("ID Aluno: "+telefone.getIdaluno()+" ID Telefone: "+telefone.getIdtelefone()+"\n Numero: "+telefone.getNumero());
        }

    }
   
    //exibir telefone usado no dados do aluno 
    public void telef(int idaluno) throws Exception{
       
        alunoDAO.gettelefone(idaluno);

        for(telefone telefone :(alunoDAO.gettelefone(idaluno))){
            System.out.println(" ID Telefone: "+telefone.getIdtelefone()+" Numero: "+telefone.getNumero());
        }
        System.out.println("\n");
    }
  
    // retornar o ultimo id 
    public void ultimo_id(){
        alunoDAO.last_ID();
        System.out.println(alunoDAO.last_ID());
    }

    //cadastrar telefone_Solicita o ID do aluno
    public void cad_telefone(){
        
        telefone telefone = new telefone();
        System.out.println("Cadastro de telefone do Aluno"+"\n Caso não queiraca cadastrar digite 0.");
     
        idaluno=sc.nextInt();
        telefone.setIdaluno(idaluno);
        for(int cont=0;cont<=2;cont++){
            System.out.println("Digite o numero do aluno: ");
            numero=sc.next();

            if(numero.equals("0")){
                
                break;
            }
            
                telefone.setNumero(numero);
                
                alunoDAO.savetelefone(telefone);
            
            
            
        }
        
    }
 
    

}
