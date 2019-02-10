import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class Normal implements IStrategie {

  public void repondSollicitation(){}

  public void formeTribu(){}

  public void sollicite(){}

  public void sEmancipe(){}

  public void negocie(Elfe chef){}

  public void devenirChef(){}

  public Circle dessiner(Color couleur){
    Circle res = new Circle(2);
    res.setFill(couleur);
    return res;
  }

  public boolean isChef(){
    return false;
  }
}