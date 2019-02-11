import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public interface IStrategie {
  
  public void repondSollicitation();

  public void formeTribu(Elfe chef);

  public void sollicite();

  public void sEmancipe();

  public void negocie(Elfe chef);

  public Circle dessiner(Color couleur);

  public boolean isChef();
}