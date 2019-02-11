import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

import java.util.ArrayList;

public class Chef implements IStrategie {

  public void repondSollicitation(){
    System.out.println("Je réponds à une sollicitation");
  }

  public void formeTribu(Elfe chef, Monde m){
    System.out.println("Je ne peux pas former de tribu");
  }

  public void sollicite(Elfe elfe, Monde m){
    System.out.println("Je sollicite");

    ArrayList<Gnome> gnomesVoisins = new ArrayList<>();
    gnomesVoisins.addAll(elfe.getParcelle().getGnomes());
    if (elfe.getParcelle().getBas(m.getParcelles()) != null){
      gnomesVoisins.addAll(elfe.getParcelle().getBas(m.getParcelles()).getGnomes());
    }
    if (elfe.getParcelle().getHaut(m.getParcelles()) != null){
      gnomesVoisins.addAll(elfe.getParcelle().getHaut(m.getParcelles()).getGnomes());
    }
    if (elfe.getParcelle().getDroite(m.getParcelles()) != null){
      gnomesVoisins.addAll(elfe.getParcelle().getDroite(m.getParcelles()).getGnomes());
    }
    if (elfe.getParcelle().getGauche(m.getParcelles()) != null){
      gnomesVoisins.addAll(elfe.getParcelle().getGauche(m.getParcelles()).getGnomes());
    }

    for (Gnome g : gnomesVoisins){
      if (g.hasTribu()){
        if (!g.getTribu().equals(elfe.getTribu()) && elfe.getTribu().piedDEgalite(g.getTribu())){
          g.elfeSollicite(elfe.getTribu(), m.getParcelles());
        }
      } else {
        g.elfeSollicite(elfe.getTribu(), m.getParcelles());
      }
    }
  }

  public void sEmancipe(Elfe elfe){
    System.out.println("Je m'émancipe");
    elfe.getTribu().couperLesLiens();
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

  public boolean peutNegocier(){
    return true;
  }

}