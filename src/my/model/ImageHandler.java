package my.model;

import java.awt.image.BufferedImage;
import java.awt.image.Raster;

public class ImageHandler {
  public static Cinza[][] getMatrizImagem(BufferedImage image) {
    int altura = image.getHeight();
    int largura = image.getWidth();
    Raster raster = image.getData();
    Colorido[][] matrizDaImagemColorida = new Colorido[largura][altura];
    for(int x=0; x<largura; ++x) {
      for(int y=0; y<altura; ++y) {
        matrizDaImagemColorida[x][y] = new Colorido(raster.getSample(x, y, 0), 
                                                    raster.getSample(x, y, 1), 
                                                    raster.getSample(x, y, 2) );
      }
    }
    Cinza[][] matrizDaImagemCinza = new Cinza[largura][altura];
    for(int x=0; x<largura; ++x) {
      for(int y=0; y<altura; ++y) {
        matrizDaImagemCinza[x][y] = new Cinza( matrizDaImagemColorida[x][y].grey() );
      }
    }
    
    return matrizDaImagemCinza;
  }
  public static BufferedImage getImageFromMatriz(Cinza[][] matrizDaImagem) {
    if(matrizDaImagem.length<1 || matrizDaImagem[0].length<1)
      throw new RuntimeException("ERRO: em ImageHandler.printImage, matriz da imagem vazia");
    int largura = matrizDaImagem.length;
    int altura = matrizDaImagem[0].length;
    BufferedImage image = new BufferedImage(largura, 
                                            altura, 
                                            BufferedImage.TYPE_INT_RGB);
    for(int x=0; x<largura; ++x) {
      for(int y=0; y<altura; ++y) {
        int valor = matrizDaImagem[x][y].v;
        int rgb = valor;
        rgb = (rgb<<8) + valor;
        rgb = (rgb<<8) + valor;
        image.setRGB(x, y, rgb);
      }
    }
    return image;
  }
}
