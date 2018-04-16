package view;

import javax.swing.*;
import java.awt.*;

public class PanelBase extends JPanel implements VisualWindow{

    TelaCadastro cadastro;
    TelaContatos contatos;

    public static final int CONTATOS = 1;
    public static final int CADASTRO = 2;


    public PanelBase(){
        setLayout();
        setComponents();
        setEvents();
    }

    @Override
    public void setLayout() {
        setLayout(new CardLayout());
    }

    @Override
    public void setComponents() {
        contatos = new TelaContatos();
        cadastro = new TelaCadastro();

        add(contatos,"contatos");
        add(cadastro, "cadastro");
    }

    @Override
    public void setEvents() {

    }
}
