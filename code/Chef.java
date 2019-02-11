import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class Chef implements IStrategie {

  public void repondSollicitation(){
    System.out.println("Je réponds à une sollicitation");
  }

  public void formeTribu(Elfe chef, Monde m){
    System.out.println("Je ne peux pas former de tribu");
  }

  public void sollicite(){
    System.out.println("Je sollicite");
  }

  public void sEmancipe(){
    System.out.println("Je m'émancipe");
  }

  public void negocie(Elfe chef){
    System.out.println("Je négocie");
  }

  public Circle dessiner(Color couleur){
    Circle res = new Circle(2);
    res.setFill(couleur);
    return res;
  }

  public boolean isChef(){
    return true;
  }

  public boolean peutSEmanciper(Elfe elfe){
    return elfe.getTribu().hasParent();
  }

}