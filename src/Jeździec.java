import java.util.List;

public class Jeździec extends Rycerz{
    public Jeździec() {
        this.nazwa = "J";
        this.hp = 1100;
        this.movement =2;
        this.atak=480;
        this.leczenie = 25;
    }
   void tura(Plansza plansza,List red, List blue){
        String s1 = plansza.getT(this.x,this.y);
        String t1 = s1.substring(4,5);

        if(t1.equals("c")) {

            if (y < movement) {
                return;
            }
            String s2 = plansza.getT(this.x, this.y - movement);
            String t2 = s2.substring(4, 5);
            String s3 = plansza.getT(this.x, this.y - movement + 1);
            String t3 = s3.substring(4, 5);
            if (s2 == " *** " && (t3 == t1 || s3 == " *** ")) {
                plansza.setT(this.x, this.y - movement, s1);
                plansza.setT(this.x, this.y, " *** ");
                this.y = y - movement;
                //System.out.println(x+" "+y +" " + s1);
            } else if (!t1.equals(t3) && s2!=" *** " && s3!=" *** ") {
                System.out.println("Walka " + "\u001B[34m" + plansza.getT(this.x, this.y).substring(0, 4) + "\u001B[0m" + " z " + "\u001B[31m" + plansza.getT(this.x, this.y - 1).substring(0, 4) + "\u001B[0m");
                for (Object l1 : blue) {
                    Rycerz b = Rycerz.class.cast(l1);
                    if (b.getX() == this.x && b.getY() == this.y - 1) {
                        if(b.getNazwa().substring(1) == "E")//niedziałające sprawdzanie czy przeciwnik jest elitarny
                        {
                            Rycerz_elitarny e = Rycerz_elitarny.class.cast(l1);
                            e.setHP(e.getHP() - this.atak + e.getTarcza());
                            if (e.getHP() > 0) {
                                e.setHP(e.getHP() + e.getLeczenie());
                            }
                            System.out.println("\u001B[34m"+"Hp niebieskiego: " + e.getHP()+"\u001B[0m");
                            if (e.getHP() <= 0) {
                                System.out.println("\u001B[34m"+e.getNazwa()+"\u001B[0m"+" umiera z kretesem");
                                System.out.println("----------------------");
                                blue.remove(blue.indexOf(l1));
                                plansza.setT(this.x, this.y - 1, " *** ");
                                break;
                            }
                            System.out.println("----------------------");
                        }
                        else
                        {
                            b.setHP(b.getHP() - this.atak);
                            if (b.getHP() > 0) {
                                b.setHP(b.getHP() + b.getLeczenie());
                            }
                            System.out.println("\u001B[34m"+"Hp niebieskiego: " + b.getHP()+"\u001B[0m");
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
            } else if (s3 == " *** ") {
                plansza.setT(this.x, this.y - movement + 1, s1);
                plansza.setT(this.x, this.y, " *** ");
                this.y = y - movement + 1;
            }
            else if (plansza.getT(this.x, this.y - 1) == " *** ") {//if żeby koń podążał za przyjazną jednostką
                plansza.setT(this.x, this.y - 1, s1);
                plansza.setT(this.x, this.y, " *** ");
                this.y = y - 1;
            }
        }

        else  if(t1.equals("n")) {


            if(this.y>=plansza.getY()-movement)
            {
                 return;
            }
            String s2 = plansza.getT(this.x,this.y+movement);
            String t2 = s2.substring(4,5);
            String s3 = plansza.getT(this.x,this.y+movement-1);
            String t3 = s3.substring(4,5);
            if(s2 == " *** " && ( t3 == t1 || s3==" *** " ) ){
                plansza.setT(this.x,this.y+movement, s1);
                plansza.setT(this.x,this.y, " *** ");
                this.y = y+movement;
                //System.out.println(x+" "+y +" " + s1);
            }else if(!t1.equals(t3) && s2!=" *** " && s3!=" *** "){
                System.out.println("Walka "+"\u001B[34m"+plansza.getT(this.x,this.y).substring(0, 4)+"\u001B[0m" + " z " + "\u001B[31m"+plansza.getT(this.x,this.y+1).substring(0, 4)+"\u001B[0m");
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
                            if (e.getHP() <= 0)
                            {
                                System.out.println("\u001B[31m"+e.getNazwa()+"\u001B[0m"+" umiera z kretesem");
                                System.out.println("----------------------");
                                blue.remove(blue.indexOf(l1));
                                plansza.setT(this.x, this.y - 1, " *** ");
                                break;
                            }
                            System.out.println("----------------------");

                        }
                        else
                        {
                            r.setHP(r.getHP() - this.atak);
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
            else if(s3 == " *** ")
            {
                plansza.setT(this.x,this.y+movement-1, s1);
                plansza.setT(this.x,this.y, " *** ");
                this.y = y+movement-1;
            }
            else if (plansza.getT(this.x, this.y + 1) == " *** ") {//if żeby koń podążał za przyjazną jednostką
                plansza.setT(this.x, this.y + 1, s1);
                plansza.setT(this.x, this.y, " *** ");
                this.y = y + 1;
            }

        }

    }
}
