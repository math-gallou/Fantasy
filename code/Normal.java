import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class Normal implements IStrategie {

  public void repondSollicitation(Elfe chef){
    System.out.println("Je ne peux pas répondre à une négociation");
  }

  public void formeTribu(Elfe chef, Monde m){
    Tribu nouvelle_tribu = new Tribu(chef, chef.getParcelle().getPerso());
    nouvelle_tribu.setParent(chef.getTribu());
    chef.getParcelle().ajouterTribu(nouvelle_tribu);
    chef.getParcelle().enleverTribu(chef.getTribu());
    chef.getTribu().ajouterEnfant(nouvelle_tribu);
    chef.setTribu(nouvelle_tribu);
    chef.devenirChef();
    m.ajouterTribu(nouvelle_tribu);
    for (Gnome g : chef.getParcelle().getGnomes()){
      if (g.hasTribu()){
        g.getTribu().enleverEnfant(g);
      }
      g.setTribu(nouvelle_tribu);
      g.getControleur().changerEtat(new GnomeProtege());
    }
    System.out.println("Je forme ma tribu");
  }

  public void sollicite(Elfe elfe, Monde m){
    System.out.println("Je ne peux pas solliciter");
  }

  public void sEmancipe(Elfe elfe){
    System.out.println("Je ne peux pas m'émanciper");
  }

  public void negocie(Elfe chef, Elfe lanceur){
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

  public boolean peutSEmanciper(Elfe elfe){
    return false;
  }

  public boolean peutNegocier(){
    return false;
  }

  public boolean peutRepondre(Elfe joueur){
      return false;
  }
}