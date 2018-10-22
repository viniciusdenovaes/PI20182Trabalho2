package teste;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import my.controller.Controller;
import my.model.Cinza;

public class Teste {
  Controller controller;
  public Teste() {
    controller = new Controller(new  BotaoBlurBehavior(), 
                                new BotaoSharpBehavior(), 
                                new BotaoLinesBehavior());
  }
  
  //////////////////////////////////////////////////////////
  //                                       BLUR           //
  // MEXER AQUI PARA FAZER A AÇÃO DO BOTAO BLUR           //
  //                                       BLUR           //
  //////////////////////////////////////////////////////////
  public class BotaoBlurBehavior implements ActionListener{
    @Override
    public void actionPerformed(ActionEvent e) {
      // A classe Cinza é só um inteiro, 
      // mas garante que este inteiro estará entre 0 e 255
      
      // Esta matriz eh a matriz da imagem original
      Cinza[][] matriz = controller.getMatrizImagemEntrada();
      // Esta sera a matriz da nova imagem
      Cinza[][] novaMatriz = new Cinza[matriz.length][];
      for(int i=0; i<matriz.length; ++i){
        novaMatriz[i] = new Cinza[matriz[i].length];
        for(int j=0; j<matriz[i].length; ++j){
          novaMatriz[i][j] = new Cinza((i+j)/10); // aqui estou definindo qual será a nova matriz
        }
      }
      // Passando a matriz da nova imagem para fazer uma janela com ela
      controller.showImagemFromMatriz(novaMatriz);
    }
  }
  
  //////////////////////////////////////////////////////////
  //                                       SHARPETING     //
  // MEXER AQUI PARA FAZER A AÇÃO DO BOTAO SHARPETING     //
  //                                       SHARPETING     //
  //////////////////////////////////////////////////////////
  public class BotaoSharpBehavior implements ActionListener{
    @Override
    public void actionPerformed(ActionEvent e) {
      Cinza[][] matriz = controller.getMatrizImagemEntrada();
      Cinza[][] novaMatriz = new Cinza[matriz.length][];
      for(int i=0; i<matriz.length; ++i){
        novaMatriz[i] = new Cinza[matriz[i].length];
        for(int j=0; j<matriz[i].length; ++j){
          // aqui estou definindo qual será a nova matriz
          novaMatriz[i][j] = new Cinza((int)(0.5*(double)matriz[i][j].v) + (i-j)/10);
        }
      }
      controller.showImagemFromMatriz(novaMatriz);
    }
  }
  
  //////////////////////////////////////////////////////////
  //                                       LINES          //
  // MEXER AQUI PARA FAZER A AÇÃO DO BOTAO LINES          //
  //                                       LINES          //
  //////////////////////////////////////////////////////////
  public class BotaoLinesBehavior implements ActionListener{
    @Override
    public void actionPerformed(ActionEvent e) {
      Cinza[][] matriz = controller.getMatrizImagemEntrada();
      Cinza[][] novaMatriz = new Cinza[matriz.length][];
      for(int i=0; i<matriz.length; ++i){
        novaMatriz[i] = new Cinza[matriz[i].length];
        for(int j=0; j<matriz[i].length; ++j){
          // aqui estou definindo qual será a nova matriz
          novaMatriz[i][j] = new Cinza(2*matriz[i][j].v);
        }
      }
      controller.showImagemFromMatriz(novaMatriz);
    }
  }
  
}









