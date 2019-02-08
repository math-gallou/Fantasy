import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;

public class ActionBouton implements EventHandler<ActionEvent> {

    private Monde m;
    private Elfe joueur;

    public ActionBouton(Monde m){
        this.m = m;
        this.joueur = joueur;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        Button b = (Button) actionEvent.getSource();
        String texte = b.getText();
        switch (texte){
            case "Se déplacer":
                    System.out.println("Se déplacer");
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
    }
}