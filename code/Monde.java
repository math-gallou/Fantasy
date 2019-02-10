import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.*;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
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
    private Elfe joueur;
    private int index_elfe;
    private ArrayList<Personnage> personnages;
    private BorderPane cont;
    private ArrayList<Tribu> tribus;
    private int nbJoueurs;
    private int nbIA;
    private int limite_parcelle;

    // getter et setter

    public ArrayList<Parcelle> getParcelles(){
        return this.parcelles;
    }

    public Elfe getJoueur(){
        return (Elfe)this.joueur;
    }

    public void setJoueur(Personnage joueur){
        this.joueur = (Elfe) joueur;
    }

    // fonctions

    /**
     * permet de choisir le nombre de parcelles
     * et de les créer
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

        this.parcelles = new ArrayList<>();
        int nb = 0;
        if (result.get() == boutonTrois){
            System.out.println("Choix 3x3");
            nb = 3;
        } else if (result.get() == boutonQuatre) {
            System.out.println("Choix 4x4");
            nb = 4;
        } else if (result.get() == boutonCinq) {
            System.out.println("Choix 5x5");
            nb = 5;
        } else {
            this.nbParcelles();
        }

        for (int i = 0; i < nb; i++){
            for (int j = 0; j < nb; j++){
                this.parcelles.add(new Parcelle(j, i));
            }
        }
    }

    /**
     * permet de choisir le nombre de joueurs
     * et d'IA
     */
    private void nbJoueurs(){
        Alert alert = new Alert(AlertType.CONFIRMATION);
        alert.setTitle("Nombre de joueurs");
        alert.setHeaderText("Choisissez le nombre de joueurs");

        ButtonType boutonChoixUn = new ButtonType("1 joueur et 3 IA");
        ButtonType boutonChoixDeux = new ButtonType("2 joueurs et 2 IA");
        ButtonType boutonChoixTrois = new ButtonType("3 joueurs et 3 IA");
        ButtonType boutonChoixQuatre = new ButtonType("4 joueurs et 3 IA");

        alert.getButtonTypes().setAll(boutonChoixUn, boutonChoixDeux, boutonChoixTrois, boutonChoixQuatre);

        Optional<ButtonType> result = alert.showAndWait();

        if (result.get() == boutonChoixUn){
            System.out.println("Choix 1 joueur");
            this.nbJoueurs = 1;
            this.nbIA = 3;
        } else if (result.get() == boutonChoixDeux) {
            System.out.println("Choix 2 joueurs");
            this.nbJoueurs = 2;
            this.nbIA = 2;
        } else if (result.get() == boutonChoixTrois) {
            System.out.println("Choix 3 joueurs");
            this.nbJoueurs = 3;
            this.nbIA = 1;
        } else if (result.get() == boutonChoixQuatre){
            this.nbJoueurs = 4;
            this.nbIA = 0;
            System.out.println("Choix 4 joueurs");
        } else {
            this.nbPersos();
        }
    }

    /**
     * permet de créer les personnages
     * de bases
     */
    private void nbPersos(){
        Alert alert = new Alert(AlertType.CONFIRMATION);
        alert.setTitle("Nombre de personnages");
        alert.setHeaderText("Choisissez le nombre d'elfes par joueurs");

        ButtonType boutonChoixUn = new ButtonType("3 Elfes");
        ButtonType boutonChoixDeux = new ButtonType("4 Elfes");
        ButtonType boutonChoixTrois = new ButtonType("5 Elfes");

        alert.getButtonTypes().setAll(boutonChoixUn, boutonChoixDeux, boutonChoixTrois);

        Optional<ButtonType> result = alert.showAndWait();

        if (result.get() == boutonChoixUn){
            System.out.println("Choix 40 Gnomes et 12 Elfes");
            this.limite_parcelle = 10;
            this.repartirPersonnages(40,12);
        } else if (result.get() == boutonChoixDeux) {
            System.out.println("Choix 60 Gnomes et 16 Elfes");
            this.limite_parcelle = 15;
            this.repartirPersonnages(50,16);
        } else if (result.get() == boutonChoixTrois) {
            System.out.println("Choix 80 Gnomes et 20 Elfes");
            this.limite_parcelle = 20;
            this.repartirPersonnages(80,20);
        } else {
            this.nbPersos();
        }
        this.repartirTribu();
    }

    /**
     * Réparti les personnages dans les parcelles
     */
    private void repartirPersonnages(int nbGnomes, int nbElfes){
        for (Parcelle p : this.parcelles){
            p.setNbPlaces(this.limite_parcelle);
        }
        this.personnages = new ArrayList<>();
        Random random = new Random();
        int nb = (int) Math.sqrt(this.parcelles.size());
        for (int i = 0; i < nbElfes ; i++){
            int row = random.nextInt(nb);
            int col = random.nextInt(nb);
            while(!this.parcelles.get(row*nb + col).restePlace()){
                row = random.nextInt(nb);
                col = random.nextInt(nb);
            }
            Elfe elfe = new Elfe(this.parcelles.get(row*nb + col), String.valueOf(i));
            this.parcelles.get(row*nb + col).ajouterPerso(elfe);
            this.personnages.add(elfe);
        }
        for (int i = 0; i < nbGnomes ; i++){
            int row = random.nextInt(nb);
            int col = random.nextInt(nb);
            while(!this.parcelles.get(row*nb + col).restePlace()){
                row = random.nextInt(nb);
                col = random.nextInt(nb);
            }
            Gnome gnome = new Gnome(this.parcelles.get(row*nb + col), String.valueOf(i));
            this.parcelles.get(row*nb + col).ajouterPerso(gnome);
            this.personnages.add(gnome);
        }
    }

    /**
     * crée les premières tribus du jeu pour le lancer
     * par défaut : on parcourt chaque parcelle et
     * on prend un elfe au hasard pour créer une tribu
     */
    public void repartirTribu(){
        this.tribus = new ArrayList<>();
        Random r = new Random();
        for (Parcelle p : this.parcelles){
            if (p.getElfes().size() > 0){
                int index_chef = r.nextInt(p.getElfes().size());
                Elfe nouveau_chef = p.getElfes().get(index_chef);
                nouveau_chef.devenirChef();
                Tribu b = new Tribu(nouveau_chef, p.getPerso());
                p.ajouterTribu(b);
                this.tribus.add(b);
                for (Personnage perso : p.getPerso()){
                    perso.setTribu(b);
                }
                for (Gnome g : p.getGnomes()){
                    g.getControleur().changerEtat(new GnomeProtege());
                }
            }
        }
    }

    /**
     * permet d'activer ou désactiver les options
     * de jeu
     * implémentés : déplacement, sollicitation
     */
    public void activerBouton() {
        if(this.joueur.peutSeDeplacer(this.parcelles)){
            this.deplacement.setDisable(true);
        } else {
            this.deplacement.setDisable(false);
        }

        if (this.joueur.isChef()){
            this.sollicitation.setDisable(false);
            this.reponse.setDisable(false);
            this.formation.setDisable(true);
            this.emancipation.setDisable(false);
            this.negociation.setDisable(false);
        } else {
            this.sollicitation.setDisable(true);
            this.reponse.setDisable(true);
            this.formation.setDisable(false);
            this.emancipation.setDisable(true);
            this.negociation.setDisable(true);
        }
    }

    /**
     * @return le panel central avec le plateau de jeu
     */
    private GridPane central(){
        this.central = new GridPane();
        for (int i = 0; i < Math.sqrt(this.parcelles.size()); i++){
            for (int j = 0; j < Math.sqrt(this.parcelles.size()); j++){
                this.central.add(this.parcelles.get(j*(int)Math.sqrt(this.parcelles.size())+i).dessiner(), i, j);
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

    /**
     * n'affiche rien en particulier pour le moment
     * @return
     */
    private VBox droite(){
        VBox droite = new VBox();
        droite.setPrefWidth(50);
        return droite;
    }

    /**
     * début des infos sur les tribus
     * @return le panel de gauche avec des infos sur les tribus
     */
    private ScrollPane gauche(){
        ScrollPane spane = new ScrollPane();
        VBox gauche = new VBox();
        for (Parcelle p : this.parcelles){
            for (Tribu b : p.getTribus()){
                gauche.getChildren().add(new Text(b.affichage()));
            }
        }
        spane.setContent(gauche);
        return spane;
    }

    /**
     * @return le prochain elfe qui doit jouer
     */
    public Personnage getNouveauJoueur(){
        this.joueur = null;
        while (this.joueur == null){
            if (this.index_elfe < this.personnages.size()){
                if (this.personnages.get(this.index_elfe).isElfe())
                    this.joueur = (Elfe) this.personnages.get(this.index_elfe);
                this.index_elfe ++;
            } else {
                this.index_elfe = 0;
            }
        }
        return this.joueur;
    }

    /**
     * met à jour l'affichage de l'elfe qui joue
     */
    public void updateLabel(){
        this.tour.setText("C'est le tour de " + this.joueur);
    }

    /**
     * @return le panel avec les boutons de jeu
     */
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
        this.activerBouton();

        buttons1.getChildren().addAll(deplacement, reponse, formation);
        buttons1.setAlignment(Pos.CENTER);
        buttons2.getChildren().addAll(sollicitation, emancipation, negociation);
        buttons2.setAlignment(Pos.CENTER);

        this.bas.getChildren().addAll(label, buttons1, buttons2);
        return this.bas;
    }

    /**
     * met à jour l'affichage du panel et des boutons
     * après un tour de jeu
     */
    public void actualiserAffichage(){
        GridPane centre = this.central();
        centre.setAlignment(Pos.CENTER);
        this.cont.setCenter(centre);
        this.activerBouton();
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

    /**
     * Crée le modèle
     * @param stage la fenêtre principale
     */
    @Override
    public void start(Stage stage) {
        this.nbParcelles();
        this.nbPersos();
        this.nbJoueurs();
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