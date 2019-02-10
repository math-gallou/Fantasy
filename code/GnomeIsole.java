import java.util.ArrayList;

public class GnomeIsole implements IEtatGnome {

  public GnomeIsole(){}

  public void deplacementElfe(AutomateGnome automate){
    Gnome gnome = automate.getControle();
    if (gnome.getTribu().getChef().getParcelle().equals(gnome.getParcelle())){
      automate.changerEtat(new GnomeProtege());
      System.out.println(gnome + " devient protégé");
    } else {
      int i = 0;
      while (i < gnome.getTribu().getElfes().size()){
        if (gnome.getTribu().getElfes().get(i).getParcelle().equals(gnome.getParcelle())){
          automate.changerEtat(new GnomeVulnerable());
          System.out.println(gnome + " devient vulnérable");
          i = gnome.getTribu().getElfes().size();
        }
        i ++;
      }
    }
  }

  public void elfeRepondSollicitation(AutomateGnome automate){}

  public void elfeFormeTribu(AutomateGnome automate){}

  public void elfeSollicite(AutomateGnome automate, Tribu nouvelle_tribu, ArrayList<Parcelle> parcelles){
    automate.getControle().deserterGnome(nouvelle_tribu);
    automate.changerEtat(new GnomeProtege());
  }

  public void elfeseSEmancipe(AutomateGnome automate){}

  public void elfeNegocie(AutomateGnome automate){}
}