import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

import java.util.ArrayList;
import java.util.Optional;

public class Chef implements IStrategie {

  public void repondSollicitation(Elfe chef){
    System.out.println("Je réponds à une sollicitation");
    Negociation nego = chef.choisiNego();
    Elfe autre = nego.getLanceur();

    Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
    alert.setTitle("Negociation");
    alert.setHeaderText("Répondez à la proposition de " + autre);

    ButtonType fusion = new ButtonType("Fusionner les deux tribus");
    ButtonType statuQuo = new ButtonType("Ne rien faire (statuQuo)");

    alert.getButtonTypes().setAll(fusion, statuQuo);

    Optional<ButtonType> result = alert.showAndWait();
    if (result.get() == fusion){
      System.out.println("Fusion !!");
    } else if (result.get() == statuQuo) {
      System.out.println("Rien du tout, statuQuo");
    }
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

  public void negocie(Elfe chef, Elfe lanceur){
    System.out.println("Je négocie avec " + chef);
    chef.ajouterNegociation(new Negociation(lanceur));
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

  public boolean peutRepondre(Elfe joueur){
      return joueur.getNegociations().size() > 0;
  }

}