package controll;

import model.Pessoa;
import view.MainFrame;
import view.PanelBase;
import view.TelaCadastro;

import javax.swing.*;

public class CadastroController {


    public static void salvarContato(String nome,String endereco, String telefone, String celular, String email, String dataNascimento){
        try{
            Pessoa p = ContatosController.getPessoa();
            if( p != null){

                p.setNome(nome);
                p.setEndereco(endereco);
                p.setTelefone(telefone);
                p.setCelular(celular);
                p.setEmail(email);
                p.setDataNascimento(dataNascimento);

            }else {
                p = new Pessoa(nome,
                        endereco,
                        telefone,
                        celular,
                        email,
                        dataNascimento);

            }

            p.salvar();
            MainFrame.changeScreen(PanelBase.CONTATOS,p);
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
