package controll;

import model.Pessoa;
import view.TelaCadastro;
import view.TelaContatos;

import javax.swing.*;
import java.util.ArrayList;


public class ContatosController {
    static DefaultListModel model = new DefaultListModel();

    static Pessoa pessoa;
    TelaContatos telaContatos;

    public ContatosController(TelaContatos telaContatos){
        this.telaContatos = telaContatos;
    }


    public static void populaLista(JList<Object> list){

        model.clear();

        for (Pessoa p:Pessoa.todos()
             ) {
            model.addElement(p);
        }

         list.setModel(model);
    }

    public void info(JList list){
        DefaultListModel model = (DefaultListModel) list.getModel();
        int selectedIndex = list.getSelectedIndex();
        if(selectedIndex != -1){
            Pessoa p = (Pessoa) model.getElementAt(selectedIndex);
            JOptionPane.showMessageDialog(null,"Nome: "+p.getNome()
            +"\nEndereco: "+p.getEndereco()+"\nTelefone: "+p.getTelefone()
            +"\nCelular: "+p.getCelular()+"\nEmail: "+p.getEmail()+"\nData Nascimento: "+p.getDataNascimento());
        }else{
            JOptionPane.showMessageDialog(null,"Selecione um contato para exibir mais informações.");
        }


    }

    public  void delete(JList list){
        DefaultListModel model = (DefaultListModel) list.getModel();
        int selectedIndex = list.getSelectedIndex();
        if (selectedIndex != -1) {
            Pessoa p = (Pessoa) model.getElementAt(selectedIndex);
            if(JOptionPane.showConfirmDialog(null,"Realmente deseja excluir "+p.getNome()+" ?" ) == 0){
                p.delete();
                model.remove(selectedIndex);
            }

        }else{
            JOptionPane.showMessageDialog(null,"Selecione o contato que deseja excluir.");
        }
    }

    public static Pessoa editar(JList list){
        DefaultListModel model = (DefaultListModel) list.getModel();
        int selectedIndex = list.getSelectedIndex();
        if (selectedIndex != -1) {
            pessoa = (Pessoa) model.getElementAt(selectedIndex);

            TelaCadastro.preencheCampos(pessoa.getNome(),
                    pessoa.getEndereco(),
                    pessoa.getTelefone(),
                    pessoa.getCelular(),
                    pessoa.getEmail(),
                    pessoa.getDataNascimento());


            return pessoa;
        }
        return null;
    }

    public static Pessoa getPessoa(){
        return pessoa;
    }


    public  void pesquisa(String nome, JList list){
        ArrayList<Pessoa>  p = new ArrayList<>();

        p.addAll(Pessoa.pesquisa(nome));
        if(!(p.isEmpty())){
            model.clear();

            for (Pessoa pessoa:p) {
                model.addElement(pessoa);
            }

            list.setModel(model);
        }
    }
}
