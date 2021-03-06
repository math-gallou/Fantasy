import javafx.scene.paint.Color;
import javafx.scene.shape.Shape;

public abstract class Personnage extends Element {

    protected String nom;
    protected Tribu tribu;
    protected Parcelle parcelle;

    public abstract Shape dessiner(Color couleur);

    public void agir() { }

    public void setTribu(Tribu tribu){
        this.tribu = tribu;
    }

    public void setParcelle(Parcelle p) {
        this.parcelle = p;
    }

    public boolean isTribu(){
        return false;
    }

    public boolean hasTribu(){
        return this.tribu!=null;
    }

    public boolean isSurParcelle(Parcelle p){
        return this.parcelle.equals(p);
    }

    public Tribu getTribu(){
        return this.tribu;
    }

    public Parcelle getParcelle(){
        return this.parcelle;
    }

    public void deplacementPerso(Parcelle nouvelle_parcelle){
        this.parcelle.enleverPerso(this);
        this.parcelle = nouvelle_parcelle;
        this.parcelle.ajouterPerso(this);
    }

}