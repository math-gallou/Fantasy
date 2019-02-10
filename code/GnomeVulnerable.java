import java.util.ArrayList;
import java.util.Random;

public class GnomeVulnerable implements IEtatGnome {

  public GnomeVulnerable(){}

  public void deplacementElfe(AutomateGnome automate){
    Gnome gnome = automate.getControle();
    automate.changerEtat(new GnomeIsole());
    System.out.println(gnome + " devient isolé");
    if (gnome.getTribu().getChef().getParcelle().equals(gnome.getParcelle())){
      automate.changerEtat(new GnomeProtege());
      System.out.println(gnome + " devient plutot protégé");
    } else {
      int i = 0;
      while (i < gnome.getTribu().getElfes().size()){
        if (gnome.getTribu().getElfes().get(i).getParcelle().equals(gnome.getParcelle())){
          automate.changerEtat(new GnomeVulnerable());
          System.out.println(gnome + " devient plutot vulnérable");
          i = gnome.getTribu().getElfes().size();
        }
        i ++;
      }
    }
  }

  public void elfeRepondSollicitation(AutomateGnome automate){}

  public void elfeFormeTribu(AutomateGnome automate){}

  public void elfeSollicite(AutomateGnome automate, Tribu nouvelle_tribu, ArrayList<Parcelle> parcelles){
    Random rand = new Random();
    int choix = rand.nextInt(1);
    if (choix == 1){
      automate.getControle().deserterGnome(nouvelle_tribu);
      automate.changerEtat(new GnomeProtege());
    } else {
      automate.getControle().fuirGnome(parcelles);
    }
  }

  public void elfeseSEmancipe(AutomateGnome automate){}

  public void elfeNegocie(AutomateGnome automate){}
}