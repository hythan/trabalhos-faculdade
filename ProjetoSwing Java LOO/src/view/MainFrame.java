package view;

import com.jgoodies.looks.plastic.Plastic3DLookAndFeel;
import com.jgoodies.looks.plastic.PlasticLookAndFeel;
import com.jgoodies.looks.plastic.theme.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class MainFrame extends JFrame implements VisualWindow{


    private static PanelBase panelBase;
    private static CardLayout cardLayout;


    public MainFrame(){
        new TelaLogo();
        setLayout();
        setComponents();
        setEvents();
        repaintAll();
        panelBase.contatos.atualizaLista();


    }

    @Override
    public void setLayout() {
        setLayout(new BorderLayout());
        setSize(700,500);
        setResizable(false);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setTitle("My Contacts Book");

        PlasticLookAndFeel.setPlasticTheme(new Silver());
        try {
                UIManager.setLookAndFeel(new Plastic3DLookAndFeel());
        } catch (UnsupportedLookAndFeelException ex) {
                 ex.printStackTrace();
        }
    }

    @Override
    public void setComponents() {


        panelBase = new PanelBase();

        cardLayout = new CardLayout();
        cardLayout = (CardLayout) panelBase.getLayout();

        add(panelBase,BorderLayout.CENTER);



    }

    @Override
    public void setEvents() {

    }

    public static void changeScreen(int screen){
        switch (screen){
            case 1:
                cardLayout.show(panelBase,"contatos");
                panelBase.contatos.atualizaLista();
                break;
            case 2:
                cardLayout.show(panelBase,"cadastro");
                break;
        }
    }

    public static void changeScreen(int screen, Object data){
        switch (screen){
            case 1:
                cardLayout.show(panelBase,"contatos");
                panelBase.contatos.atualizaLista();
                break;
            case 2:
                cardLayout.show(panelBase,"cadastro");
                break;

        }
    }


    private void repaintAll() {
        SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {
                repaint();
                pack();
                setSize(700,500);
            }
        });
    }

}


