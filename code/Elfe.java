import javafx.scene.control.ChoiceDialog;
import javafx.scene.shape.Shape;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.paint.Color;
import java.util.*;

public class Elfe extends Personnage {

  private IStrategie role;

  public Elfe(Parcelle p, String name){
    this.parcelle = p;
    this.nom = name;
    this.role = new Normal();
    this.tribu = null;
  }

  public Shape dessiner(Color couleur){
    return this.role.dessiner(couleur);
  }

  public void seDeplacer(Monde m) {
    this.deplacementPerso(this.choisirDeplacement(m));
  }

  public void repondSollicitation() {
    this.role.repondSollicitation();
  }

  public void formeTribu(Monde m) {
    this.role.formeTribu(this, m);
  }

  public void sollicite(Monde m) {
    this.role.sollicite(this, m);
  }

  public void sEmancipe() {
    this.role.sEmancipe(this);
  }

  public void negocie(Elfe chef) {
    this.role.negocie(chef);
  }

  public void devenirChef() {
    this.role = new Chef();
  }

  public void devenirNormal(){
    this.role = new Normal();
  }

  public boolean isChefSupreme() {
    return false;
  }

  public boolean isElfe(){
    return true;
  }

  public boolean isGnome(){
    return false;
  }

  public String toString(){
    return "E"+this.nom;
  }

  public Parcelle choisirDeplacement(Monde m){
    Parcelle p_res = null;
    Alert alert = new Alert(AlertType.CONFIRMATION);
    alert.setTitle("Déplacement");
    alert.setHeaderText("Choisissez la nouvelle parcelle");

    Parcelle pgauche = this.parcelle.getGauche(m.getParcelles());
    Parcelle pdroit = this.parcelle.getDroite(m.getParcelles());
    Parcelle pbas = this.parcelle.getBas(m.getParcelles());
    Parcelle phaut = this.parcelle.getHaut(m.getParcelles());

    ButtonType gauche = new ButtonType("Aller gauche");
    ButtonType droite = new ButtonType("Aller droite");
    ButtonType haut = new ButtonType("Aller haut");
    ButtonType bas = new ButtonType("Aller bas");

    alert.getButtonTypes().setAll(gauche, droite, haut, bas);

    if (pbas == null){
      alert.getDialogPane().lookupButton(bas).setDisable(true);
    }
    if (pdroit == null){
      alert.getDialogPane().lookupButton(droite).setDisable(true);
    }
    if (pgauche == null){
      alert.getDialogPane().lookupButton(gauche).setDisable(true);
    }
    if (phaut == null){
      alert.getDialogPane().lookupButton(haut).setDisable(true);
    }

    Optional<ButtonType> result = alert.showAndWait();
    if (result.get() == gauche){
      System.out.println("La parcelle de gauche");
      p_res = pgauche;
    } else if (result.get() == droite) {
      System.out.println("La parcelle de droite");
      p_res = pdroit;
    } else if (result.get() == haut) {
      System.out.println("La parcelle du haut");
      p_res = phaut;
    } else if (result.get() == bas){
      System.out.println("La parcelle du bas");
      p_res = pbas;
    }
    return p_res;
  }

  public boolean isChef(){
    return this.role.isChef();
  }

  public Parcelle getParcelle(){
    return this.parcelle;
  }

  public boolean peutSeDeplacerGauche(ArrayList<Parcelle> p){
    if (this.parcelle.getGauche(p) != null){
      return this.parcelle.getGauche(p).restePlace();
    }
    return false;
  }

  public boolean peutSeDeplacerDroite(ArrayList<Parcelle> p){
    if (this.parcelle.getDroite(p) != null){
      return this.parcelle.getDroite(p).restePlace();
    }
    return false;
  }

  public boolean peutSeDeplacerHaut(ArrayList<Parcelle> p){
    if (this.parcelle.getHaut(p) != null){
      return this.parcelle.getHaut(p).restePlace();
    }
    return false;
  }

  public boolean peutSeDeplacerBas(ArrayList<Parcelle> p){
    if (this.parcelle.getBas(p) != null){
      return this.parcelle.getBas(p).restePlace();
    }
    return false;
  }

  public boolean peutSeDeplacer(ArrayList<Parcelle> p){
    return this.peutSeDeplacerBas(p) || this.peutSeDeplacerHaut(p) || this.peutSeDeplacerDroite(p) || this.peutSeDeplacerGauche(p);
  }

  public boolean peutSEmanciper(){
    return this.role.peutSEmanciper(this);
  }

  public boolean peutNegocier(){
    return this.role.peutNegocier();
  }

  public Elfe choisiNegociant(ArrayList<Parcelle> parcelles){
    ArrayList<Elfe> choix = new ArrayList<>();
    if (this.parcelle.getGauche(parcelles) != null){
      choix.addAll(this.parcelle.getGauche(parcelles).getElfesChefsEgaux(this));
    }
    if (this.parcelle.getDroite(parcelles) != null){
      choix.addAll(this.parcelle.getDroite(parcelles).getElfesChefsEgaux(this));
    }
    if (this.parcelle.getHaut(parcelles) != null){
      choix.addAll(this.parcelle.getHaut(parcelles).getElfesChefsEgaux(this));
    }
    if (this.parcelle.getBas(parcelles) != null){
      choix.addAll(this.parcelle.getBas(parcelles).getElfesChefsEgaux(this));
    }

    ChoiceDialog<Elfe> dialog = new ChoiceDialog<>(choix.get(0), choix);
    dialog.setTitle("Négociation");
    dialog.setHeaderText("Choisissez un elfe pour négocier");
    dialog.setContentText("Chef : ");

    Optional<Elfe> result = dialog.showAndWait();

    return result.get();
  }
}