import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;

public class ActionBouton implements EventHandler<ActionEvent> {

    private Monde m;
    private Elfe joueur;

    public ActionBouton(Monde m){
        this.m = m;
        this.joueur = m.getJoueur();
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        Button b = (Button) actionEvent.getSource();
        String texte = b.getText();
        switch (texte){
            case "Se déplacer":
                    System.out.println("Se déplacer");
                    this.joueur.seDeplacer(this.m);
                    break;
            case "Répondre à une sollicitation":
                    System.out.println("Répondre à une sollicitation");
                    break;
            case "Former sa tribu":
                    System.out.println("Former sa tribu");
                    break;
            case "Solliciter un chef":
                    System.out.println("Solliciter un chef");
                    break;
            case "S'émanciper":
                    System.out.println("S'émanciper");
                    break;
            case "Négociation":
                    System.out.println("Négociation");
                    break;
            default: 
                    System.out.println("Action par défault ");
                    break;        
        }
        this.joueur = (Elfe)this.m.getNouveauJoueur();
        this.m.setJoueur(this.joueur);
        this.m.updateLabel();
        this.m.actualiserAffichage();
    }
}