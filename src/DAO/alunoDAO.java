package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import java.util.ArrayList;
import java.util.List;

import Classes.aluno;
import Classes.telefone;
import factory.aluno_factory;


public class alunoDAO {
    
    public void save(aluno aluno){
        
        String sql ="INSERT INTO aluno(nome,cidade,estado) VALUES(?, ?, ?)";

        Connection conn = null;
        PreparedStatement pstm = null;


        try{
            conn= aluno_factory.createConnectionToMySQL();
            pstm = (PreparedStatement) conn.prepareStatement(sql);
            pstm.setString(1,aluno.getNome());
            pstm.setString(2, aluno.getCidade());
            pstm.setString(3, aluno.getEstado());


        pstm.execute();
        
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            try{
                if(pstm!=null){
                    pstm.close();
                }
                if(conn!=null){
                    conn.close();
                }
            }catch(Exception e){
                e.printStackTrace();
            }
        }
    }
    
    public void savetelefone(telefone telefone){
        
        String sql ="INSERT INTO telefone(idaluno,numero) VALUES(?, ?)";

        Connection conn = null;
        PreparedStatement pstm = null;


        try{
            conn= aluno_factory.createConnectionToMySQL();
            pstm = (PreparedStatement) conn.prepareStatement(sql);
            pstm.setInt(1, telefone.getIdaluno());
            pstm.setString(2, telefone.getNumero());
            


        pstm.execute();
        System.out.println("Executado com sucesso!");
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            try{
                if(pstm!=null){
                    pstm.close();
                }
                if(conn!=null){
                    conn.close();
                }
            }catch(Exception e){
                e.printStackTrace();
            }
        }
    }
  
  
    public List<aluno> getaluno() throws Exception{

        String sql ="SELECT * FROM aluno";

        List<aluno> alunos = new ArrayList<aluno>();

        Connection conn =null;
        PreparedStatement pstm = null;

        ResultSet rset = null;
        
        try{
            conn = aluno_factory.createConnectionToMySQL();

            pstm = conn.prepareStatement(sql);

            rset = pstm.executeQuery();

            while(rset.next()){
                aluno aluno = new aluno();
                

                aluno.setIdaluno(rset.getInt("idaluno"));

                aluno.setNome(rset.getString("nome"));

                aluno.setCidade(rset.getString("cidade"));

                aluno.setEstado(rset.getString("estado"));

                alunos.add(aluno);

            }
            
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            try{
                if(rset!=null){
                    rset.close();
                }
                if(pstm!=null){
                    pstm.close();
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        
        return alunos;

    }

    public void update_aluno(aluno aluno) throws Exception{

        String sql = "UPDATE aplicativo_java.aluno SET nome=? ,cidade =?, estado= ?"+" WHERE (idaluno = ?)";

        Connection conn=null;

        PreparedStatement pstm = null;

        try{
            conn = aluno_factory.createConnectionToMySQL();

            pstm = conn.prepareStatement(sql);
            pstm.setString(1, aluno.getNome());
            pstm.setString(2, aluno.getCidade());
            pstm.setString(3, aluno.getEstado());
            pstm.setInt(4, aluno.getIdaluno());

            pstm.execute();
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            try{
                if(pstm!=null){
                    pstm.close();
                }
                if(conn!=null){
                    conn.close();
                }
            }catch(Exception e){
                e.printStackTrace();
            }
        }
    }

    public void deletar_aluno(int idaluno) throws Exception{

        String sql = "DELETE FROM aluno WHERE idaluno=?";
        Connection conn =null;
        PreparedStatement pstm=null;

        try{
            conn=aluno_factory.createConnectionToMySQL();
            pstm  = conn.prepareStatement(sql);
            pstm.setInt(1, idaluno);

            pstm.execute();
            System.out.println("Aluno de ID "+idaluno+" apagado, com sucesso!");
        }catch (Exception e){
            e.printStackTrace();
        }finally{
            try{
                if(pstm!=null){
                    pstm.close();
                }
                if(conn!=null){
                    conn.close();
                }
            }catch(Exception e){
                e.printStackTrace();
            }
        }
    }



    public List<telefone> gettelefone(int Idaluno) throws Exception{

        String sql ="SELECT * FROM telefone WHERE idaluno IN (?)";

        List<telefone> telefones = new ArrayList<telefone>();

        Connection conn =null;
        PreparedStatement pstm = null;

        ResultSet rset = null;

        try{
            conn = aluno_factory.createConnectionToMySQL();

            pstm = conn.prepareStatement(sql);

            pstm.setInt(1, Idaluno);

            rset = pstm.executeQuery();

            while(rset.next()){
                telefone telefone = new telefone();
                
                telefone.setIdaluno(rset.getInt("idaluno"));
                telefone.setIdtelefone(rset.getInt("idtelefone"));  
                telefone.setNumero(rset.getString("numero"));
                
                telefones.add(telefone);

            }
            
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            try{
                if(rset!=null){
                    rset.close();
                }
                if(pstm!=null){
                    pstm.close();
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        return telefones;

    }

    public int last_ID(){

        String sql ="select max(idaluno) from aluno";


        Connection conn =null;
        PreparedStatement pstm = null;
        int id=0;
        ResultSet rset = null;

        try{
            conn= aluno_factory.createConnectionToMySQL();
            pstm = (PreparedStatement) conn.prepareStatement(sql);
            
            rset =pstm.executeQuery();
            rset.next();
            id= rset.getInt("max(idaluno)");
           
        System.out.println("Executado com sucesso!");
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            try{
                if(pstm!=null){
                    pstm.close();
                }
                if(conn!=null){
                    conn.close();
                }
            }catch(Exception e){
                e.printStackTrace();
            }
        }
        return id;
    }

}
