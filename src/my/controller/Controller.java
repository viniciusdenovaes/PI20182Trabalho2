package my.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

import javax.swing.JFrame;

import my.model.CalculoHandler;
import my.model.Cinza;
import my.model.ImageHandler;
import my.view.GetImageFrame;
import my.view.JanelaImagem;
import my.view.JanelaInputMascara;

public class Controller {
  JanelaInputMascara janelaInputMascara;
  JanelaImagem janelaImagemEntrada;
  BufferedImage imagemEntrada;
  
  public Controller(ActionListener acao) {
    janelaInputMascara = new JanelaInputMascara();
    janelaInputMascara.addCalculaActionListener(acao);
    janelaInputMascara.addModificaTamanhoActionListener(new MudaTamanhoBehavior());
    GetImageFrame getImageFrame = new GetImageFrame();
    imagemEntrada = getImageFrame.getImage();
    imagemEntrada = ImageHandler.getImageFromMatriz(ImageHandler.getMatrizImagem(imagemEntrada));
    janelaImagemEntrada = new JanelaImagem(imagemEntrada, 
                                           "Janela Imagem Entrada");
        
  }
  
  public double[][] getMascara(){
    String[][] mascaraTexto = janelaInputMascara.getMascaraValor();
    double[][] mascaraValor = new double[mascaraTexto.length][];
    for(int i=0; i<mascaraTexto.length; ++i){
      mascaraValor[i] = new double[mascaraTexto[i].length];
      for(int j=0; j<mascaraTexto[i].length; ++j){
        mascaraValor[i][j] = CalculoHandler.getValorEscrito(mascaraTexto[i][j]);
      }
    }
    return mascaraValor;
  }
  public double getEscalar() {
    return CalculoHandler.getValorEscrito(janelaInputMascara.getEscalarValor());
  }
  public Cinza[][] getMatrizImagemEntrada(){
    return ImageHandler.getMatrizImagem(this.imagemEntrada);
  }
  public void setMatrizImagemEntrada(Cinza[][] matrizEntrada){
    this.imagemEntrada = ImageHandler.getImageFromMatriz(matrizEntrada);
  }
  public void showImagemFromMatriz(Cinza[][] matriz) {
    BufferedImage imagemResultado = ImageHandler.getImageFromMatriz(matriz);
    JanelaImagem janelaImagem = new JanelaImagem(imagemResultado, 
                                                 "Imagem Resultado");
    janelaImagem.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
  }
  class MudaTamanhoBehavior implements ActionListener{
    int tamanhoMascaraAtual;
    int tamanhoMascaraResultante;
    @Override
    public void actionPerformed(ActionEvent e) {
      tamanhoMascaraAtual = janelaInputMascara.getSizeMascara();
      if(e.getSource() == janelaInputMascara.getBotaoDiminui())
        diminuiMascara();
      else if(e.getSource() == janelaInputMascara.getBotaoAumenta())
        aumentaMascara();
      janelaInputMascara.setSizeMascara(tamanhoMascaraResultante);
      janelaInputMascara.resetPainelCentral();
    }
    private void diminuiMascara(){
      if(tamanhoMascaraAtual>=3)
        tamanhoMascaraResultante = tamanhoMascaraAtual - 2;
    }
    private void aumentaMascara(){
      tamanhoMascaraResultante = tamanhoMascaraAtual + 2;
    }
  }
}
