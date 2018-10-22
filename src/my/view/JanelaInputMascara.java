package my.view;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

@SuppressWarnings("serial")
public class JanelaInputMascara extends JFrame{
  JTextField[][] mascaraInput;
  JTextField     escalarInput;
  JPanel painelCentral;
  int TamanhoMascara = 3;
  JButton diminui;
  JButton aumenta;
  JButton calcula;
  public JanelaInputMascara() {
    super("Entrada Máscara");
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    JPanel painelEscalar = new JPanel();
    escalarInput = new JTextField(3);
    painelEscalar.add(escalarInput);
    
    JPanel painelBotao = new JPanel();
    calcula = new JButton("Passar Máscara");
    painelBotao.add(calcula);
    
    JPanel painelMudaTamanho = new JPanel();
    painelMudaTamanho.setLayout(new GridLayout(2,1));
    //painelMudaTamanho.setPreferredSize(new Dimension(50,100));
    diminui = new JButton("V");
    aumenta = new JButton("A");
    painelMudaTamanho.add(aumenta);
    painelMudaTamanho.add(diminui);
    
    
    setLayout(new BorderLayout());
    add(painelEscalar    , BorderLayout.WEST);
    add(painelBotao      , BorderLayout.SOUTH);
    add(painelMudaTamanho, BorderLayout.EAST);
    
    resetPainelCentral();
    
    setVisible(true);
    
  }
  
  public void resetPainelCentral(){
    painelCentral = new JPanel();
    painelCentral.setLayout(new GridLayout(TamanhoMascara,TamanhoMascara));
    mascaraInput = new JTextField[TamanhoMascara][TamanhoMascara];
    for(int x=0; x<TamanhoMascara; ++x) {
      for(int y=0; y<TamanhoMascara; ++y) {
        mascaraInput[x][y] = new JTextField("1", 4);
        painelCentral.add(mascaraInput[x][y]);
      }
    }
    add(painelCentral    , BorderLayout.CENTER);
    SwingUtilities.updateComponentTreeUI(this);
//    frame.invalidate();
//    frame.validate();
//    frame.repaint();
    pack();
  }
  
  public int getSizeMascara(){
    return this.TamanhoMascara;
  }
  public void setSizeMascara(int tamanho){
    this.TamanhoMascara = tamanho;
  }
  public void addCalculaActionListener(ActionListener al){
    calcula.addActionListener(al);
  }
  public JButton getBotaoDiminui(){
    return this.diminui;
  }
  public JButton getBotaoAumenta(){
    return this.aumenta;
  }
  public void addModificaTamanhoActionListener(ActionListener al){
    diminui.addActionListener(al);
    aumenta.addActionListener(al);
  }
  
  public String[][] getMascaraValor(){
    String[][] mascaraValor = new String[TamanhoMascara][TamanhoMascara];
    for(int y=0; y<TamanhoMascara; ++y) {
      for(int x=0; x<TamanhoMascara; ++x) {
        mascaraValor[x][y] = mascaraInput[x][y].getText();
      }
    }
    return mascaraValor;
  }
  
  public String getEscalarValor() {
    return escalarInput.getText();
  }
  
}
