import java.util.ArrayList;

public interface IEtatGnome {
  
  public void deplacementElfe(AutomateGnome automate);

  public void elfeRepondSollicitation(AutomateGnome automate);

  public void elfeFormeTribu(AutomateGnome automate);

  public void elfeSollicite(AutomateGnome automate, Tribu nouvelle_tribu, ArrayList<Parcelle> parcelles);

  public void elfeseSEmancipe(AutomateGnome automate);

  public void elfeNegocie(AutomateGnome automate);

}