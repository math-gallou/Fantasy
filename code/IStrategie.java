import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public interface IStrategie {
  
  public void repondSollicitation();

  public void formeTribu(Elfe chef, Monde m);

  public void sollicite();

  public void sEmancipe(Elfe elfe);

  public void negocie(Elfe chef);

  public Circle dessiner(Color couleur);

  public boolean isChef();

  public boolean peutSEmanciper(Elfe elfe);
}