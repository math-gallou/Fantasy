import java.util.ArrayList;

public class GnomeProtege implements IEtatGnome {

  public GnomeProtege(){}

  public void deplacementElfe(AutomateGnome automate){
    Gnome gnome = automate.getControle();
    boolean ok = false;
    int i = 0;
    while (i < gnome.getTribu().getElfes().size() && !ok){
      ok = gnome.getTribu().getElfes().get(i).getParcelle().equals(gnome.getParcelle());
      i ++;
    }
    if (!ok && !gnome.memeParcelleChef()){
      automate.changerEtat(new GnomeIsole());
      System.out.println(gnome + " devient isolé");
    } else if (ok && !gnome.memeParcelleChef()){
      automate.changerEtat(new GnomeVulnerable());
      System.out.println(gnome + " devient vulnérable");
    }
  }

  public void elfeRepondSollicitation(AutomateGnome automate){}

  public void elfeFormeTribu(AutomateGnome automate){}

  public void elfeSollicite(AutomateGnome automate, Tribu nouvelle_tribu, ArrayList<Parcelle> parcelles){
    System.out.println(automate.getControle() + " est protégé et ne réagit pas à la sollicitation");
  }

  public void elfeseSEmancipe(AutomateGnome automate){}

  public void elfeNegocie(AutomateGnome automate){}
}