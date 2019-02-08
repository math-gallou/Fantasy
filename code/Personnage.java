import javafx.scene.shape.Shape;

public abstract class Personnage extends Element {

    protected String nom;
    protected Tribu tribu;
    protected Parcelle parcelle;

    public abstract Shape dessiner();

    public void agir() {
        
    }

    public void setTribu(Tribu tribu){
        this.tribu = tribu;
    }

    public void setParcelle(Parcelle p) {
        this.parcelle = p;
    }

    public boolean isTribu(){
        return false;
    }
}