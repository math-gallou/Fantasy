import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.stage.Stage;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.*;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.GridPane;
import javafx.scene.control.Label;
import javafx.scene.text.Font;
import javafx.scene.control.Button;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import java.util.*;

public class Monde extends Application{

    private ArrayList<Parcelle> parcelles; 
    private ArrayList<IA> myIA;
    private GridPane central;
    private VBox bas;
    private Label tour;
    private Button deplacement;
    private Button reponse;
    private Button formation;
    private Button sollicitation;
    private Button emancipation;
    private Button negociation;
    private Personnage joueur;
    private int index_elfe;
    private ArrayList<Personnage> personnages;
    private BorderPane cont;


    public ArrayList<Parcelle> getParcelles(){
        return this.parcelles;
    }
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
        this.personnages = new ArrayList<>();
        Random random = new Random();
        int nb = (int) Math.sqrt(this.parcelles.size())+1;
        for (int i = 0; i < nbGnomes ; i++){
            int row = random.nextInt(nb);
            int col = random.nextInt(nb);
            Gnome gnome = new Gnome(this.parcelles.get(row+col), String.valueOf(i));
            this.parcelles.get(row + col).ajouterPerso(gnome);
            this.personnages.add(gnome);
        }
        for (int i = 0; i < nbElfes ; i++){
            int row = random.nextInt(nb);
            int col = random.nextInt(nb);
            Elfe elfe = new Elfe(this.parcelles.get(row+col), String.valueOf(i));
            this.parcelles.get(row + col).ajouterPerso(elfe);
            this.personnages.add(elfe);
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
    private HBox titre(){
        HBox res = new HBox(5);
        res.setPrefWidth(800);
        res.setPrefHeight(20);
        res.setPadding(new Insets(10, 50, 10, 10));
        res.setAlignment(Pos.CENTER);
        Label label = new Label("Fantasy");
        label.setFont(new Font(30));
        res.getChildren().add(label);
        return res;
    }

    private VBox droite(){
        VBox droite = new VBox();
        droite.setPrefWidth(50);
        return droite;
    }

    private VBox gauche(){
        VBox gauche = new VBox();
        gauche.setPrefWidth(50);
        return gauche;
    }

    public Elfe getJoueur(){
        return (Elfe)this.joueur;
    }

    public void setJoueur(Personnage joueur){
        this.joueur = joueur;
    }

    public Personnage getNouveauJoueur(){
        this.joueur = null;
        while (this.joueur == null){
            if (this.index_elfe < this.personnages.size()){
                if (this.personnages.get(this.index_elfe).isElfe())
                    this.joueur = this.personnages.get(this.index_elfe);
                this.index_elfe ++;
            } else {
                this.index_elfe = 0;
            }
        }
        return this.joueur;
    }

    public void updateLabel(){
        this.tour.setText("C'est le tour de " + this.joueur);
    }

    private VBox bas(){
        this.index_elfe = 0;
        HBox label = new HBox(5);
        label.setAlignment(Pos.CENTER);
        this.tour = new Label("C'est le tour de " + this.getNouveauJoueur());
        this.tour.setFont(new Font(15));
        label.getChildren().add(this.tour);

        EventHandler<ActionEvent> eh = new ActionBouton(this);
        this.bas = new VBox(5);
        this.bas.setPadding(new Insets(10,10,10,10));
        HBox buttons1 = new HBox(5);
        HBox buttons2 = new HBox(5);

        this.deplacement = new Button("Se déplacer");
        this.deplacement.setOnAction(eh);
        this.reponse = new Button("Répondre à une sollicitation");
        this.reponse.setOnAction(eh);
        this.formation = new Button("Former sa tribu");
        this.formation.setOnAction(eh);
        this.sollicitation = new Button("Solliciter un chef");
        this.sollicitation.setOnAction(eh);
        this.emancipation = new Button("S'émanciper");
        this.emancipation.setOnAction(eh);
        this.negociation = new Button("Négociation");
        this.negociation.setOnAction(eh);

        buttons1.getChildren().addAll(deplacement, reponse, formation);
        buttons1.setAlignment(Pos.CENTER);
        buttons2.getChildren().addAll(sollicitation, emancipation, negociation);
        buttons2.setAlignment(Pos.CENTER);
        
        this.bas.getChildren().addAll(label, buttons1, buttons2);
        return this.bas;
    }

    /**
     * @return  le graphe de scène de la vue à partir de methodes précédentes
     */
    private Scene laScene(){
        this.cont = new BorderPane();
        GridPane centre = this.central();
        centre.setAlignment(Pos.CENTER);
        this.cont.setCenter(centre);
        this.cont.setTop(this.titre());
        this.cont.setRight(this.droite());
        this.cont.setLeft(this.gauche());
        this.cont.setBottom(this.bas());
        return new Scene(this.cont,1200,1000);
    }

    public void actualiserAffichage(){
        this.cont.setCenter(this.central());
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