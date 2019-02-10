import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public interface IStrategie {
  
  public void repondSollicitation();

  public void formeTribu();

  public void sollicite();

  public void sEmancipe();

  public void negocie(Elfe chef);

  public void devenirChef();

  public Circle dessiner(Color couleur);

  public boolean isChef();
}