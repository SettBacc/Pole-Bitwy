import java.util.ArrayList;
import java.util.List;

public class Rycerz {
    public Rycerz() {
        this.nazwa = "R";
        this.hp = 1000;
        this.atak = 400;
        this.movement = 1;
        this.x = 0;
        this.y = 0;
        this.strona = "strona";
        this.leczenie = 20;
    }

    public String nazwa;
    public int hp;
    protected int atak;
    protected int movement;
    public int x;
    public int y;
    protected String strona;
    protected int leczenie;

    public int getHP() {
        return this.hp;
    }

    public void setHP(int hp) {
        this.hp = hp;
    }

    public int getX() {
        return this.x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return this.y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public String getNazwa() {
        return this.nazwa;
    }

    public int getAtak() {
        return this.atak;
    }

    public int getLeczenie() {
        return this.leczenie;
    }

    void tura(Plansza plansza, List red, List blue) {
        String s1 = plansza.getT(this.x, this.y);
        String t1 = s1.substring(4, 5);
        //System.out.println(nazwa + " " + x + " " + y + " " + hp + " " + movement);
        if (t1.equals("c")) {
            if (y < movement) {
                return;
            }
            String s2 = plansza.getT(this.x, this.y - movement);
            String t2 = s2.substring(4, 5);

            if (plansza.getT(this.x, this.y - movement) == " *** ") {
                plansza.setT(this.x, this.y - movement, s1);
                plansza.setT(this.x, this.y, " *** ");
                this.y = y - movement;
                //System.out.println(x+" "+y +" " + s1);
            } else if (!t1.equals(t2)) {
                System.out.println("Walka " + "\u001B[31m" + plansza.getT(this.x, this.y).substring(0, 4) + "\u001B[0m" + " z " + "\u001B[34m" + plansza.getT(this.x, this.y - movement).substring(0, 4) + "\u001B[0m");
                //walka
                for (Object l1 : blue) {
                    Rycerz b = Rycerz.class.cast(l1);
                    if (b.getX() == this.x && b.getY() == this.y - 1)
                    {
                        if(b.getNazwa().substring(1) == "E")//niedziałające sprawdzanie czy przeciwnik jest elitarny
                        {
                            Rycerz_elitarny e = Rycerz_elitarny.class.cast(l1);
                            e.setHP(e.getHP() - this.atak + e.getTarcza());
                            if (e.getHP() > 0)
                            {
                                e.setHP(e.getHP() + e.getLeczenie());
                            }
                            System.out.println("\u001B[34m"+"Hp niebieskiego: " + e.getHP()+"\u001B[0m");
                            if (e.getHP() <= 0)
                            {
                                System.out.println("\u001B[34m"+e.getNazwa()+"\u001B[0m"+" umiera z kretesem");
                                System.out.println("----------------------");
                                blue.remove(blue.indexOf(l1));
                                plansza.setT(this.x, this.y - 1, " *** ");
                                break;
                            }
                            System.out.println("----------------------");
                        }
                        else {
                            b.setHP(b.getHP() - this.atak);
                            System.out.println("\u001B[34m"+"Hp niebieskiego: " + b.getHP()+"\u001B[0m");
                            if (b.getHP() > 0) {
                                b.setHP(b.getHP() + b.getLeczenie());
                                //int nice = b.getHP()-b.getLeczenie();
                                //System.out.println("Using healing: "+nice+" -> "+b.getHP());
                            }
                            if (b.getHP() <= 0) {
                                System.out.println("\u001B[34m"+b.getNazwa()+"\u001B[0m"+" umiera z kretesem");
                                System.out.println("----------------------");
                                blue.remove(blue.indexOf(l1));
                                plansza.setT(this.x, this.y - 1, " *** ");
                                break;
                            }
                            System.out.println("----------------------");
                        }
                    }
                }
            }

        } else if (t1.equals("n")) {
            if (this.y >= plansza.getY() - movement) {
                return;
            }
            String s2 = plansza.getT(this.x, this.y + movement);
            String t2 = s2.substring(4, 5);

            if (plansza.getT(this.x, this.y + movement) == " *** ") {
                plansza.setT(this.x, this.y + movement, s1);
                plansza.setT(this.x, this.y, " *** ");
                this.y = y + movement;
            } else if (!t1.equals(t2)) {
                System.out.println("Walka " + "\u001B[34m" + plansza.getT(this.x, this.y).substring(0, 4) + "\u001B[0m" + " z " + "\u001B[31m" + plansza.getT(this.x, this.y + 1).substring(0, 4) + "\u001B[0m");
                //walka
                for (Object l1 : red) {
                    Rycerz r = Rycerz.class.cast(l1);
                    if (r.getX() == this.x && r.getY() == this.y + 1) {

                        if(r.getNazwa().substring(1) == "E")//niedziałające sprawdzanie czy przeciwnik jest elitarny
                        {
                            Rycerz_elitarny e = Rycerz_elitarny.class.cast(l1);
                            e.setHP(e.getHP() - this.atak + e.getTarcza());
                            if (e.getHP() > 0) {
                                e.setHP(e.getHP() + e.getLeczenie());
                            }
                            System.out.println("\u001B[31m"+"Hp czerwonego: " + e.getHP()+"\u001B[0m");
                            if (e.getHP() <= 0) {
                                System.out.println("\u001B[31m"+e.getNazwa()+"\u001B[0m"+" umiera z kretesem");
                                System.out.println("----------------------");
                                red.remove(red.indexOf(l1));
                                plansza.setT(this.x, this.y - 1, " *** ");
                                break;
                            }
                            System.out.println("----------------------");
                        }
                        else
                        {
                            r.setHP(r.getHP() - this.atak);
                            if (r.getHP() > 0) {
                                r.setHP(r.getHP() + r.getLeczenie());
                                //int nice = r.getHP()-r.getLeczenie();
                                //System.out.println("Using healing: "+nice+" -> "+r.getHP());
                            }
                            System.out.println("\u001B[31m"+"Hp czerwonego: " + r.getHP()+"\u001B[0m");
                            if (r.getHP() <= 0) {
                                System.out.println("\u001B[31m"+r.getNazwa()+"\u001B[0m"+" umiera z kretesem");
                                System.out.println("----------------------");
                                red.remove(red.indexOf(l1));
                                plansza.setT(this.x, this.y + 1, " *** ");
                                break;
                            }
                            System.out.println("----------------------");
                        }

                    }
                }
            }
        }
    }

}


