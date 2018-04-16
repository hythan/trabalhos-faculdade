package view;

import controll.ContatosController;


import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TelaContatos extends JPanel implements VisualWindow {
    private JButton novo;
    private JButton excluir;
    private JButton editar;
    private JButton info;


    private JTextField textFieldPesquisa;
    private JButton buttonPesquisa;
    private JList<Object> jList;
    private JScrollPane jScrollPane;
    private DefaultListModel<Object> listModel = new DefaultListModel();


    private TelaCadastro cadastro;

    ContatosController contatosController = new ContatosController(this);

    public TelaContatos(){
        setLayout();
        setComponents();
        setEvents();
    }

    @Override
    public void setLayout() {
        setLayout(new BorderLayout());
    }

    @Override
    public void setComponents() {
        JPanel painel = new JPanel(new FlowLayout(FlowLayout.LEFT));

        ImageIcon imgNovo = new ImageIcon(getClass().getResource("img/novo.png"));
        imgNovo.setImage(imgNovo.getImage().getScaledInstance(25,25,100));

        ImageIcon imgExcluir = new ImageIcon(getClass().getResource("img/excluir.png"));
        imgExcluir.setImage(imgExcluir.getImage().getScaledInstance(25,25,100));

        ImageIcon imgEditar = new ImageIcon(getClass().getResource("img/editar.png"));
        imgEditar.setImage(imgEditar.getImage().getScaledInstance(25,25,100));

        ImageIcon imgInfo = new ImageIcon(getClass().getResource("img/info.png"));
        imgInfo.setImage(imgInfo.getImage().getScaledInstance(25,25,100));

        novo = new JButton();
        novo.setIcon(imgNovo);
        novo.setPreferredSize(new Dimension(65,35));
        novo.setToolTipText("Novo");

        excluir = new JButton();
        excluir.setIcon(imgExcluir);
        excluir.setPreferredSize(new Dimension(65,35));
        excluir.setToolTipText("Excluir");

        info = new JButton();
        info.setIcon(imgInfo);
        info.setPreferredSize(new Dimension(65,35));
        info.setToolTipText("Informações");

        editar = new JButton();
        editar.setIcon(imgEditar);
        editar.setPreferredSize(new Dimension(65,35));
        editar.setToolTipText("Editar");


        painel.add(novo);
        painel.add(excluir);
        painel.add(editar);
        painel.add(info);

        add(painel,BorderLayout.NORTH);

        JPanel p = new JPanel(null);

        textFieldPesquisa = new JTextField();
        buttonPesquisa = new JButton();

        ImageIcon imgPesquisar = new ImageIcon(getClass().getResource("img/pesquisar.png"));
        imgPesquisar.setImage(imgPesquisar.getImage().getScaledInstance(36,30,100));
        buttonPesquisa.setIcon(imgPesquisar);

        jList = new JList<>(listModel);

        textFieldPesquisa.setBounds(120,30,250,30);
        buttonPesquisa.setBounds(370,30,100,30);
        buttonPesquisa.setToolTipText("Pesquisar");


        p.add(textFieldPesquisa);
        p.add(buttonPesquisa);

        jList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);


        jScrollPane = new JScrollPane();
        jScrollPane.setViewportView(jList);
        jScrollPane.setBounds(50,80,580,350);

        p.add(jScrollPane);


        add(p);


    }

    @Override
    public void setEvents() {

        novo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                TelaCadastro.limpaCampos();
                MainFrame.changeScreen(PanelBase.CADASTRO);
            }
        });

        excluir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                contatosController.delete(jList);

            }
        });

        editar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                TelaCadastro.limpaCampos();
                MainFrame.changeScreen(PanelBase.CADASTRO,contatosController.editar(jList));

                }
        });

        info.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                contatosController.info(jList);
            }
        });

        buttonPesquisa.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                contatosController.pesquisa(textFieldPesquisa.getText(),jList);
            }
        });
    }

    public void atualizaLista(){
        ContatosController.populaLista(jList);
    }


}
