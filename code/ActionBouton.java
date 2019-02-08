import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;

public class ActionBouton implements EventHandler<ActionEvent> {

    private Monde m;
    private Elfe joueur;

    public ActionBouton(Monde m, Elfe joueur){
        this.m = m;
        this.joueur = joueur;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        Button b = (Button) actionEvent.getSource();
        System.out.println("Clique");
    }
}