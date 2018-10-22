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
import my.view.JanelaBotoes;

public class Controller {
  JanelaBotoes janelaBotoes;
  JanelaImagem janelaImagemEntrada;
  BufferedImage imagemEntrada;
  
  public Controller(ActionListener  blurBehavior, 
                    ActionListener sharpBehavior, 
                    ActionListener linesBehavior) {
    janelaBotoes = new JanelaBotoes();
    janelaBotoes. setBlurBehavior(blurBehavior);
    janelaBotoes.setSharpBehavior(sharpBehavior);
    janelaBotoes.setLinesBehavior(linesBehavior);
    GetImageFrame getImageFrame = new GetImageFrame();
    imagemEntrada = getImageFrame.getImage();
    imagemEntrada = ImageHandler.getImageFromMatriz(ImageHandler.getMatrizImagem(imagemEntrada));
    janelaImagemEntrada = new JanelaImagem(imagemEntrada, 
                                           "Janela Imagem Entrada");
        
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
}
