package view;

import javax.swing.*;
import java.awt.*;

public class TelaLogo {
    private final int LARGURA = 400;
    private final int ALTURA = 300;
    private final int TEMPO = 6000;
    private final String CAMINHO = "img/logo.png";
    ImageIcon img = new ImageIcon(getClass().getResource(CAMINHO));

    public TelaLogo(){
        img.setImage(img.getImage().getScaledInstance(250,250,100));
        JWindow janelaSplash = new JWindow();
    try{
        janelaSplash.getContentPane().add(new JLabel(
         img));

    }catch (Exception e){
          e.printStackTrace();
    }

        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension dimension = toolkit.getScreenSize();

        janelaSplash.setBounds(
                (dimension.width-LARGURA)/2,
                (dimension.height-ALTURA)/2,
                LARGURA,
                ALTURA
        );

        janelaSplash.setVisible(true);


        try{
          Thread.sleep(TEMPO);

        }catch (InterruptedException e){
            e.printStackTrace();
        }
        janelaSplash.dispose();

    }
}
