import com.sun.org.apache.xml.internal.utils.SystemIDResolver;

import java.util.ArrayList;
import java.util.Random;

public class GnomeProtege implements IEtatGnome {

  public GnomeProtege(){}

  public void deplacementElfe(AutomateGnome automate){
    Gnome gnome = automate.getControle();
    int i = 0;
    while (i < gnome.getTribu().getElfes().size()){
      if (gnome.getTribu().getElfes().get(i).getParcelle().equals(gnome.getParcelle())){
        automate.changerEtat(new GnomeVulnerable());
        System.out.println(gnome + " devient vulnérable");
        i = gnome.getTribu().getElfes().size();
      }
      i ++;
    }
    if (!gnome.getTribu().getChef().getParcelle().equals(gnome.getParcelle())){
      automate.changerEtat(new GnomeIsole());
      System.out.println(gnome + " devient plutot isolé");
      Random rand = new Random();
      int choix = rand.nextInt(1);
      if (choix == 1){
        gnome.refugierGnome();
      }
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