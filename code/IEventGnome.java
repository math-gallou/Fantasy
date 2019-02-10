import java.util.ArrayList;

public interface IEventGnome {

  public void deplacementElfe();

  public void elfeRepondSollicitation();

  public void elfeFormeTribu();

  public void elfeSollicite(Tribu nouvelle_tribu, ArrayList<Parcelle> parcelles);

  public void elfeSEmancipe();

  public void elfeNegocie();

}