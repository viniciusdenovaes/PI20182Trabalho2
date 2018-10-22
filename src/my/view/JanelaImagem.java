package my.view;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import javax.swing.JComponent;
import javax.swing.JFrame;

@SuppressWarnings("serial")
public class JanelaImagem extends JFrame{
  private static int number = 0;
  BufferedImage imagem;
  public JanelaImagem(BufferedImage aImagem) {
    this(aImagem, "");
  }
  public JanelaImagem(BufferedImage aImagem, String s) {
    super(s + number++);
    this.imagem = aImagem;
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    add(new DesenhoDaImagem());
    pack();
    setVisible(true);
  }
  class DesenhoDaImagem extends JComponent{
    @Override
    public void paintComponent(Graphics g) {
      g.drawImage(JanelaImagem.this.imagem, 0, 0, null);
    }
    @Override
    public Dimension getPreferredSize() {
      return new Dimension(JanelaImagem.this.imagem.getWidth(), 
                           JanelaImagem.this.imagem.getHeight());
    }
  }
}
