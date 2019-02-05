import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.stage.Stage;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.*;


import java.util.*;

public class Monde {

    private ArrayList<Parcelle> parcelles;
    private ArrayList<IA> myIA;

    /**
     * @return le panel du nombre de parcelles
     */
    private VBox nbParcelles(){
        VBox res=new VBox(5);
        return res;
    }

    /**
     * @return le panel du nombre de personnages
     */
    private VBox nbPersos(){
        VBox res=new VBox(5);
        return res;
    }


    /**
     * @return le panel central avec le plateau de jeu
     */
    private VBox central(){
        VBox res=new VBox(5);
        return res;
    }

    /**
     * @return le panel contenant le titre du jeu
     */
    private FlowPane titre(){
        FlowPane res = new FlowPane();
        return res;
    }

    /**
     * @return  le graphe de scène de la vue à partir de methodes précédentes
     */
    private Scene laScene(){
        BorderPane cont = new BorderPane();
        return new Scene(cont,700,800);
    }

    /**
     * Crée le modèle
     * @param stage la fenêtre principale
     */
    @Override
    public void start(Stage stage) {
        stage.setTitle("Fantasy");
        stage.setScene(this.laScene());
        stage.show();
    }

    /**
     * Programme principal
     * @param args inutilisé
     */
    public static void main(String[] args) {
        launch(args);
    }

}