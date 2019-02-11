import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class Normal implements IStrategie {

  public void repondSollicitation(){
    System.out.println("Je ne peux pas répondre à une négociation");
  }

  public void formeTribu(Elfe chef){
    System.out.println("Je forme ma tribu");
  }

  public void sollicite(){
    System.out.println("Je ne peux pas solliciter");
  }

  public void sEmancipe(){
    System.out.println("Je ne peux pas m'émanciper");
  }

  public void negocie(Elfe chef){
    System.out.println("Je ne peux pas négocier");
  }

  public Circle dessiner(Color couleur){
    Circle res = new Circle(2);
    res.setFill(couleur);
    return res;
  }

  public boolean isChef(){
    return false;
  }
}