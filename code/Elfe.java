public class Elfe extends Personnage {

  private IStrategie role;

  public Elfe(){
    this.role = new Normal();
  }

  public void seDeplacer() {
  }

  public void repondSollicitation() {
  }

  public void formeTribu() {
  }

  public void sollicite() {
  }

  public void sEmancipe() {
  }

  public void negocie(Elfe chef) {
  }

  public void devenirChef() {
  }

  public void isChefSupreme() {
  }

  public boolean isElfe(){
    return true;
  }

  public boolean isGnome(){
    return false;
  }

}