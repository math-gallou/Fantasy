import java.util.ArrayList;
import java.util.Random;

public class GnomeVulnerable implements IEtatGnome {

  public GnomeVulnerable(){}

  public void deplacementElfe(AutomateGnome automate){
    Gnome gnome = automate.getControle();
    if (gnome.memeParcelleChef()){
      automate.changerEtat(new GnomeProtege());
      System.out.println(gnome + " devient protégé");
    } else {
      boolean ok = false;
      int i = 0;
      while (i < gnome.getTribu().getElfes().size() && !ok){
        ok = gnome.getTribu().getElfes().get(i).getParcelle().equals(gnome.getParcelle());
        i ++;
      }
      if (!ok){
        automate.changerEtat(new GnomeIsole());
        System.out.println(gnome + " devient isolé");
      }
    }
  }

  public void elfeRepondSollicitation(AutomateGnome automate){}

  public void elfeFormeTribu(AutomateGnome automate){}

  public void elfeSollicite(AutomateGnome automate, Tribu nouvelle_tribu, ArrayList<Parcelle> parcelles){
    Random rand = new Random();
    int choix = rand.nextInt(2);
    if (choix == 1){
      automate.getControle().deserterGnome(nouvelle_tribu);
      automate.changerEtat(new GnomeProtege());
    } else {
      automate.getControle().fuirGnome(parcelles, nouvelle_tribu.getChef().getParcelle());
    }
  }

  public void elfeseSEmancipe(AutomateGnome automate){}

  public void elfeNegocie(AutomateGnome automate){}
}