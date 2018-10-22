package my.model;

public class Colorido extends Cor{
  public int r, g, b;
  public Colorido(int aRed, int aGreen, int aBlue) {
    this.r = aRed;
    this.g = aGreen;
    this.b = aBlue;
  }
  public Colorido(int aValor) {
    this(aValor, aValor, aValor);
  }
  
  @Override
  public String toString() {
    String res = "";
    res = "(" + this.r + ", "+
                this.g + ", "+
                this.b + ")";
    return res;
  }
  @Override
  public void set(int c) {
    c = Cor.limit(c);
    this.r = 
    this.g = 
    this.b = c;
  }
  public int grey(){
    return (r+g+b)/3;
  }
}
