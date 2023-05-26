public class Rycerz_elitarny extends Rycerz{
    public Rycerz_elitarny() {
        this.nazwa = "E";
        this.atak=320;
        this.hp = 1300;
        this.tarcza = 50;
        this.leczenie = 30;
    }
    private int tarcza;
    public int getTarcza()
    {
        return this.tarcza;
    }

}
