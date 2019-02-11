import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class Normal implements IStrategie {

  public void repondSollicitation(){
    System.out.println("Je ne peux pas répondre à une négociation");
  }

  public void formeTribu(Elfe chef, Monde m){
    Tribu nouvelle_tribu = new Tribu(chef, chef.getParcelle().getPerso());
    chef.getParcelle().ajouterTribu(nouvelle_tribu);
    chef.getParcelle().enleverTribu(chef.getTribu());
    chef.setTribu(nouvelle_tribu);
    chef.devenirChef();
    m.ajouterTribu(nouvelle_tribu);
    for (Gnome g : chef.getParcelle().getGnomes()){
      g.deserterGnome(nouvelle_tribu);
    }
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