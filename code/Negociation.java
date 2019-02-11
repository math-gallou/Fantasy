public class Negociation {
    private Elfe lanceur;

    public Negociation(Elfe lanceur){
        this.lanceur = lanceur;
    }

    public Elfe getLanceur(){
        return this.lanceur;
    }

    public String toString(){
        return "Négociation avec " + lanceur;
    }
}
