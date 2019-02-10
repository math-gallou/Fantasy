import com.sun.org.apache.xml.internal.utils.SystemIDResolver;

public class GnomeProtege implements IEtatGnome {

  public GnomeProtege(){}

  public void deplacementElfe(AutomateGnome automate){
    Gnome gnome = automate.getControle();
    if (!gnome.getTribu().getChef().getParcelle().equals(gnome.getParcelle())){
      automate.changerEtat(new GnomeIsole());
      System.out.println(gnome + " devient isolé");
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

  public void elfeSollicite(AutomateGnome automate){}

  public void elfeseSEmancipe(AutomateGnome automate){}

  public void elfeNegocie(AutomateGnome automate){}
}