package teste;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import my.controller.Controller;
import my.model.Cinza;

public class Teste {
  Controller controller;
  public Teste() {
    controller = new Controller(new Acao());
  }
  public class Acao implements ActionListener{
    @Override
    public void actionPerformed(ActionEvent e) {
      Cinza[][] matriz = controller.getMatrizImagemEntrada();
      double[][] mascara = controller.getMascara();
      double escalar = controller.getEscalar();
      Cinza[][] novaMatriz = new Cinza[matriz.length][];
      for(int i=0; i<matriz.length; ++i){
        novaMatriz[i] = new Cinza[matriz[i].length];
        for(int j=0; j<matriz[i].length; ++j){
          novaMatriz[i][j] = new Cinza();
        }
      }
      passaMascara(novaMatriz, matriz, mascara, escalar);
      controller.showImagemFromMatriz(novaMatriz);
      //controller.setMatrizImagemEntrada(novaMatriz);
    }
  }
  
  public void passaMascara(Cinza[][] novaMatriz, Cinza[][] matriz, double[][] mascara, double escalar){
    for(int x=0; x<matriz.length; ++x) {
      for(int y=0; y<matriz[x].length; ++y) {
        Cinza novaCorCinza = passaMascara(matriz, mascara, escalar, x, y);
        novaMatriz[x][y].set(novaCorCinza.v);
      }
    }
  }
  
  public Cinza passaMascara(final Cinza[][]    matriz, 
                            final double[][] mascara, 
                            final double     escalar, 
                            final int px, final int py){
    if(   px <                     mascara.length/2 
        ||px >=matriz    .length - mascara.length/2
        ||py <                     mascara.length/2
        ||py >=matriz[py].length - mascara.length/2
       ){
      return matriz[px][py];
    }
    int novaCorValor = 0;
    for(int x=0; x<mascara.length; ++x) {
      for(int y=0; y<mascara.length; ++y) {
        novaCorValor += (int)(escalar * 
                              mascara[x][y] *
                              (double) matriz [ px + ( x-(mascara.length/2) ) ]
                                              [ py + ( y-(mascara.length/2) ) ].v );
      }
    }
    Cinza novaCor = new Cinza(novaCorValor);
    return novaCor;
  }
  
}









