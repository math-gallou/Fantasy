import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.stage.Stage;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.*;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.control.Label;
import javafx.scene.shape.Rectangle;
import java.util.*;

public class Monde extends Application{

    private ArrayList<Parcelle> parcelles; 
    private ArrayList<IA> myIA;
    private GridPane central;

    /**
     * @return le panel du nombre de parcelles
     */
    private void nbParcelles(){
        Alert alert = new Alert(AlertType.CONFIRMATION);
        alert.setTitle("Taille du plateau");
        alert.setHeaderText("Choisissez la taille du plateau");

        ButtonType boutonTrois = new ButtonType("3x3");
        ButtonType boutonQuatre = new ButtonType("4x4");
        ButtonType boutonCinq = new ButtonType("5x5");

        alert.getButtonTypes().setAll(boutonTrois, boutonQuatre, boutonCinq);

        Optional<ButtonType> result = alert.showAndWait();

        this.parcelles = new ArrayList<Parcelle>();

        if (result.get() == boutonTrois){
            System.out.println("Choix 3x3");
            for (int i = 0; i < 3; i++){
                for (int j = 0; j < 3; j++){
                    this.parcelles.add(new Parcelle(i, j));
                }
            }
        } else if (result.get() == boutonQuatre) {
            System.out.println("Choix 4x4");
            for (int i = 0; i < 4; i++){
                for (int j = 0; j < 4; j++){
                    this.parcelles.add(new Parcelle(i, j));
                }
            }
        } else if (result.get() == boutonCinq) {
            System.out.println("Choix 5x5");
            for (int i = 0; i < 5; i++){
                for (int j = 0; j < 5; j++){
                    this.parcelles.add(new Parcelle(i, j));
                }
            }
        } else {
            this.nbParcelles();
        }
    }

    /**
     * @return le panel du nombre de personnages
     */
    private void nbPersos(){
        Alert alert = new Alert(AlertType.CONFIRMATION);
        alert.setTitle("Nombre de personnages");
        alert.setHeaderText("Choisissez le nombre de personnages");

        ButtonType boutonChoixUn = new ButtonType("30 Gnomes et 10 Elfes");
        ButtonType boutonChoixDeux = new ButtonType("50 Gnomes et 15 Elfes");
        ButtonType boutonChoixTrois = new ButtonType("80 Gnomes et 20 Elfes");

        alert.getButtonTypes().setAll(boutonChoixUn, boutonChoixDeux, boutonChoixTrois);

        Optional<ButtonType> result = alert.showAndWait();

        if (result.get() == boutonChoixUn){
            System.out.println("Choix 30 Gnomes et 10 Elfes");
            this.repartirPersonnages(30,10);
        } else if (result.get() == boutonChoixDeux) {
            System.out.println("Choix 50 Gnomes et 15 Elfes");
            this.repartirPersonnages(50,15);
        } else if (result.get() == boutonChoixTrois) {
            System.out.println("Choix 80 Gnomes et 20 Elfes");
            this.repartirPersonnages(80,20);
        } else {
            this.nbPersos();
        }
    }

        /**
     * @return le panel du nombre de personnages
     */
    private void nbJoueurs(){
        Alert alert = new Alert(AlertType.CONFIRMATION);
        alert.setTitle("Nombre de joueurs");
        alert.setHeaderText("Choisissez le nombre de joueurs");

        ButtonType boutonChoixUn = new ButtonType("1 joueur");
        ButtonType boutonChoixDeux = new ButtonType("2 joueurs");
        ButtonType boutonChoixTrois = new ButtonType("3 joueurs");

        alert.getButtonTypes().setAll(boutonChoixUn, boutonChoixDeux, boutonChoixTrois);

        Optional<ButtonType> result = alert.showAndWait();

        if (result.get() == boutonChoixUn){
            System.out.println("Choix 1 joueur");
        } else if (result.get() == boutonChoixDeux) {
            System.out.println("Choix 2 joueurs");
        } else if (result.get() == boutonChoixTrois) {
            System.out.println("Choix 3 joueurs");
        } else {
            this.nbPersos();
        }
    }

        /**
     * @return le panel du nombre de personnages
     */
    private void nbIA(){
        Alert alert = new Alert(AlertType.CONFIRMATION);
        alert.setTitle("Nombre d'ordinateurs adverses");
        alert.setHeaderText("Choisissez le nombre d'ordinateurs adverses");

        ButtonType boutonChoixUn = new ButtonType("1 ordinateur adverse");
        ButtonType boutonChoixDeux = new ButtonType("2 ordinateurs adverses");
        ButtonType boutonChoixTrois = new ButtonType("3 ordinateurs adverses");

        alert.getButtonTypes().setAll(boutonChoixUn, boutonChoixDeux, boutonChoixTrois);

        Optional<ButtonType> result = alert.showAndWait();

        if (result.get() == boutonChoixUn){
            System.out.println("1 ordinateur adverse");
        } else if (result.get() == boutonChoixDeux) {
            System.out.println("2 ordinateurs adverses");
        } else if (result.get() == boutonChoixTrois) {
            System.out.println("3 ordinateurs adverses");
        } else {
            this.nbPersos();
        }
    }

    /**
     * Réparti les personnages dans les parcelles
     */
    private void repartirPersonnages(int nbGnomes, int nbElfes){
        Random random = new Random();
        int nb = (int) Math.sqrt(this.parcelles.size())+1;
        for (int i = 0; i < nbGnomes ; i++){
            int row = random.nextInt(nb);
            int col = random.nextInt(nb);
            this.parcelles.get(row + col).ajouterPerso(new Gnome(this.parcelles.get(row+col), String.valueOf(i)));
        }
        for (int i = 0; i < nbElfes ; i++){
            int row = random.nextInt(nb);
            int col = random.nextInt(nb);
            this.parcelles.get(row + col).ajouterPerso(new Elfe(this.parcelles.get(row+col), String.valueOf(i)));
        }
    }

    /**
     * @return le panel central avec le plateau de jeu
     */
    private GridPane central(){
        this.central = new GridPane();
        for (int i = 0; i < Math.sqrt(this.parcelles.size()); i++){
            for (int j = 0; j < Math.sqrt(this.parcelles.size()); j++){
                this.central.add(this.parcelles.get(i*(int)Math.sqrt(this.parcelles.size())+j).dessiner(), i, j);
                this.parcelles.get(i*(int)Math.sqrt(this.parcelles.size())+j).dessinerPersonnages();
            }
        }
        return this.central;
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
        cont.setCenter(this.central());
        return new Scene(cont,700,800);
    }

    /**
     * Crée le modèle
     * @param stage la fenêtre principale
     */
    @Override
    public void start(Stage stage) {
        this.nbParcelles();
        this.nbPersos();
        this.nbJoueurs();
        this.nbIA();
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