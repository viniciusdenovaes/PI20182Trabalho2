package my.view;

import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.*;


@SuppressWarnings("serial")
public class GetImageFrame extends JFileChooser{
  public GetImageFrame() {
    super(System.getProperty("user.dir") + File.separator + "data" + File.separator + "images");
  }

  public BufferedImage getImage(){

    int returnValue = this.showOpenDialog(null);

    if (returnValue == JFileChooser.APPROVE_OPTION) {
      try{
        File selectedFile = this.getSelectedFile();
        BufferedImage img = ImageIO.read(new File(selectedFile.getAbsolutePath()));
        return img;
      }
      catch(Exception e){
        JOptionPane.showMessageDialog(null, 
                                      "Problema ao pegar imagem", 
                                      "Erro em GetImage", 
                                      JOptionPane.INFORMATION_MESSAGE);
      }
    }
    else{
      System.exit(0);
    }
    return null;
  }
}

