import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public interface IStrategie {
  
  public void repondSollicitation(Elfe chef);

  public void formeTribu(Elfe chef, Monde m);

  public void sollicite(Elfe elfe, Monde m);

  public void sEmancipe(Elfe elfe);

  public void negocie(Elfe chef, Elfe lanceur);

  public Circle dessiner(Color couleur);

  public boolean isChef();

  public boolean peutSEmanciper(Elfe elfe);

  public boolean peutNegocier();

  public boolean peutRepondre(Elfe joueur);
}