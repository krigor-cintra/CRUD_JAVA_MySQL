import Classes.Controle;
import Menu.menu;


public class App {
    public static void main(String[] args) throws Exception {
        menu menu = new menu();
        Controle controle = new Controle();

        //controle.cad_aluno(); // cria o cadastro ( do telefone também) e joga no banco de dados
       //controle.cad_telefone(); // cria os telefones da criaturas - se não tiver colocado quando criou o demonio ( vai pedir o id da criatura)

        //controle.apagar_aluno(); //apaga tudo
        menu.prit();
        //controle.dados_aluno();//mostra os dados do aluno(id-nome-cidade-estado-telefone-idtelefone)
        //controle.ultimo_id();
       //controle.atualizar_aluno();//atualiza



    }
}
