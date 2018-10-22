package my.model;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class CalculoHandler {
  public static double getValorEscrito(String valorEscrito) {
    double valor = 0;
    valorEscrito = valorEscrito.replaceAll(" ", "");
    if(valorEscrito.trim().equals(""))
      valor = 0;
    else {
      try{
        ScriptEngineManager mgr = new ScriptEngineManager();
        ScriptEngine engine = mgr.getEngineByName("JavaScript");
        valor = Double.parseDouble(String.valueOf( engine.eval(valorEscrito)));
      }catch(ScriptException e){
        e.printStackTrace();
      }
    }
    return valor;
  }

}
