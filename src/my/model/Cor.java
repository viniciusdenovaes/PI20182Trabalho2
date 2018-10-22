package my.model;

public abstract class Cor {
  public int v;
  public Cor(int aValor) {
    this.v = Cor.limit(aValor);
  }
  public Cor() {
    this(0);
  }
  
  @Override
  public String toString() {
    String res = "";
    res += this.v;
    return res;
  }
  public void set(int c) {
    this.v = Cor.limit(c);
  }
  public static int limit(int v){
    v = Integer.min(255, v);
    v = Integer.max(0, v);
    return v;
  }
}
