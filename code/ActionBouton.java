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
                    Parcelle ancienne = this.joueur.getParcelle();
                    this.joueur.seDeplacer(this.m);
                    for (Gnome g : this.joueur.getParcelle().getGnomes()){
                        if (g.hasTribu()){
                            if (g.getTribu().equals(this.joueur.getTribu())){
                                g.deplacementElfe();
                            }
                        }
                    }
                    for (Gnome g : ancienne.getGnomes()){
                        if (g.hasTribu()){
                            if (g.getTribu().equals(this.joueur.getTribu())){
                                g.deplacementElfe();
                            }
                        }
                    }
                    break;
            case "Répondre à une sollicitation":
                    System.out.println("Répondre à une sollicitation");
                    this.joueur.repondSollicitation();
                    break;
            case "Former sa tribu":
                    System.out.println("Former sa tribu");
                    this.joueur.formeTribu(this.m);
                    break;
            case "Solliciter":
                    System.out.println("Solliciter");
                    this.joueur.sollicite(this.m);
                    break;
            case "S'émanciper":
                    System.out.println("S'émanciper");
                    this.joueur.sEmancipe();
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