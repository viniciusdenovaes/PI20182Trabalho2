package my.view;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

@SuppressWarnings("serial")
public class JanelaBotoes extends JFrame{
  JButton filterBlur;
  JButton filterSharp;
  JButton filterLines;
  public JanelaBotoes() {
    super("Escolha de Filtros");
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    JPanel painelBotoes = new JPanel();
    painelBotoes.setLayout(new FlowLayout());
    
    filterBlur  = new JButton("Blur");
    filterSharp = new JButton("Sharpening");
    filterLines = new JButton("Lines");
    
    painelBotoes.add(filterBlur);
    painelBotoes.add(filterSharp);
    painelBotoes.add(filterLines);
    
    add(painelBotoes);
    setVisible(true);
    pack();
  }
  public void  setBlurBehavior(ActionListener al){filterBlur .addActionListener(al);}
  public void setSharpBehavior(ActionListener al){filterSharp.addActionListener(al);}
  public void setLinesBehavior(ActionListener al){filterLines.addActionListener(al);}
}
