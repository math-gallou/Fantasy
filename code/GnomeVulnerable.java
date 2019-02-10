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

  public void elfeSollicite(AutomateGnome automate){}

  public void elfeseSEmancipe(AutomateGnome automate){}

  public void elfeNegocie(AutomateGnome automate){}
}