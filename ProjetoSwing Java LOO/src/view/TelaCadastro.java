package view;

import controll.CadastroController;


import javax.swing.*;
import javax.swing.text.MaskFormatter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class TelaCadastro extends JPanel implements VisualWindow {

    private static JTextField textFieldNome;
    private static JTextField textFieldEndereco;
    private static JTextField textFieldEmail;
    private static JFormattedTextField textFieldTelefone;
    private static JFormattedTextField textFieldCelular;
    private static JFormattedTextField textFieldDataNascimento;
    private JLabel labelNome, labelEndereco, labelTelefone,labelCelular,labelEmail,labelDataNascimento;


    private JButton buttonSalvar,buttonCancelar;



    public TelaCadastro(){
        setLayout();
        setComponents();
        setEvents();
    }

    @Override
    public void setLayout() {
        setLayout(null);

    }

    @Override
    public void setComponents() {

        Panel p = new Panel(new GridBagLayout());

        JLabel titulo = new JLabel("Cadastro");
        titulo.setFont(new Font("arial",Font.BOLD,30));
        titulo.setBounds(250,55,150,40);
        add(titulo);


        labelNome = new JLabel("Nome: ");
        labelNome.setPreferredSize(new Dimension(50,25));
        labelCelular = new JLabel("Celular: ");
        labelCelular.setPreferredSize(new Dimension(55,25));
        labelDataNascimento = new JLabel("Data Nascimento: ");
        labelDataNascimento.setPreferredSize(new Dimension(107,25));
        labelEmail = new JLabel("Email: ");
        labelEmail.setPreferredSize(new Dimension(47,25));
        labelEndereco = new JLabel("Endereco: ");
        labelEndereco.setPreferredSize(new Dimension(65,25));
        labelTelefone = new JLabel("Telefone: ");
        labelTelefone.setPreferredSize(new Dimension(62,25));

        textFieldNome = new JTextField(15);
        textFieldEndereco = new JTextField(20);
        textFieldTelefone = new JFormattedTextField(Mascara("(##)####-####"));
        textFieldTelefone.setPreferredSize(new Dimension(90,25));
        textFieldCelular = new JFormattedTextField(Mascara("(##)#####-####"));
        textFieldCelular.setPreferredSize(new Dimension(90,25));
        textFieldEmail = new JTextField(15);
        textFieldDataNascimento = new JFormattedTextField(Mascara("##/##/####"));
        textFieldDataNascimento.setPreferredSize(new Dimension(80,25));

        buttonCancelar = new JButton();

        ImageIcon imgCancelar = new ImageIcon(getClass().getResource("img/cancelar.png"));
        imgCancelar.setImage(imgCancelar.getImage().getScaledInstance(25,25,100));

        buttonCancelar.setIcon(imgCancelar);
        buttonCancelar.setToolTipText("Cancelar");


        buttonSalvar = new JButton();

        ImageIcon imgSalvar = new ImageIcon(getClass().getResource("img/salvar.png"));
        imgSalvar.setImage(imgSalvar.getImage().getScaledInstance(25,25,100));

        buttonSalvar.setIcon(imgSalvar);
        buttonSalvar.setToolTipText("Salvar");


        GridBagConstraints c = new GridBagConstraints();

        c.gridx = 0;
        c.gridy = 0;

        c.anchor = GridBagConstraints.LINE_END;

        p.add(labelNome,c);
        c.gridy ++;
        p.add(labelEndereco,c);
        c.gridy ++;
        p.add(labelTelefone,c);
        c.gridy ++;
        p.add(labelCelular,c);
        c.gridy ++;
        p.add(labelEmail,c);
        c.gridy ++;
        p.add(labelDataNascimento,c);


        buttonCancelar.setBounds(535,420,65,35);
        add(buttonCancelar);

        c.anchor = GridBagConstraints.LINE_START;

        c.gridx = 1;
        c.gridy = 0;

        p.add(textFieldNome, c);
        c.gridy ++;
        p.add(textFieldEndereco, c);
        c.gridy ++;
        p.add(textFieldTelefone, c);
        c.gridy ++;
        p.add(textFieldCelular, c);
        c.gridy ++;
        p.add(textFieldEmail, c);
        c.gridy ++;
        p.add(textFieldDataNascimento, c);


        buttonSalvar.setBounds(600,420,65,35);
        add(buttonSalvar);

        p.setBounds(160,70,380,300);
        add(p);
    }

    @Override
    public void setEvents() {

        buttonCancelar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MainFrame.changeScreen(PanelBase.CONTATOS);
            }
        });

        buttonSalvar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    if(textFieldNome.getText().isEmpty()){
                        throw new RuntimeException("O campo Nome nao pode ser vazio!");
                    }
                    if(textFieldCelular.getText().equals("(  )     -    ")){
                        throw new RuntimeException("O campo Celular nao pode ser vazio!");
                    }
                    if(textFieldEmail.getText().isEmpty()){
                        throw new RuntimeException("O campo Email nao pode ser vazio!");
                    }
                    CadastroController.salvarContato(textFieldNome.getText(),
                            textFieldEndereco.getText(),
                            textFieldTelefone.getText(),
                            textFieldCelular.getText(),
                            textFieldEmail.getText(),
                            textFieldDataNascimento.getText()
                    );

                }catch (RuntimeException ex){
                    JOptionPane.showMessageDialog(null,ex.getMessage());
                }

            }
        });
    }

    private MaskFormatter Mascara(String Mascara){
        MaskFormatter F_Mascara = new MaskFormatter();
        try{
            F_Mascara.setMask(Mascara);
            F_Mascara.setPlaceholderCharacter(' ');
        }
        catch (Exception excecao) {
            excecao.printStackTrace();
        }
        return F_Mascara;
    }


    public static void limpaCampos(){
        textFieldNome.setText(null);
        textFieldEndereco.setText(null);
        textFieldTelefone.setText(null);
        textFieldCelular.setText(null);
        textFieldEmail.setText(null);
        textFieldDataNascimento.setText(null);
    }

    public static void preencheCampos(String nome,String endereco, String telefone, String celular, String email, String dataNascimento){

        textFieldNome.setText(nome);
        textFieldEndereco.setText(endereco);
        textFieldTelefone.setText(telefone);
        textFieldCelular.setText(celular);
        textFieldEmail.setText(email);
        textFieldDataNascimento.setText(dataNascimento);

    }

}
