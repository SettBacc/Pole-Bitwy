import java.security.PublicKey;
import java.util.List;
import java.util.Random;

public class Plansza {

    Plansza(){
        this.x=10;
        this.y=10;
        T = new String[x][y];
        this.Plansza_domyślna();
    }
    Plansza(int x, int y){
        this.x=x;
        this.y=y;
        T = new String[x][y];
        this.Plansza_domyślna();
    }

    private int x, y;
    private String[][] T;
   public String getT(int x,int y){
        return this.T[x][y];
    }
    public void setT(int x,int y, String nazwa) {
        T[x][y] = nazwa;
    }
    public int getX()
    {
        return this.x;
    }
    public int getY()
    {
        return this.y;
    }

    private void Plansza_domyślna(){
        for(int j=0;j<y;j++){
            for(int i=0;i<x;i++){
                T[i][j] = " *** ";
            }
        }
    }
    public void Plansza_wyświetl(){
        String s;
        for(int j=0;j<y;j++){
            for(int i=0;i<x;i++){
                s = T[i][j];
                if(s.substring(4).equals("n")) System.out.print("\u001B[34m"+s.substring(0, 4)+"\u001B[0m");
                else if(s.substring(4).equals("c")) System.out.print("\u001B[31m"+s.substring(0, 4)+"\u001B[0m");
                else System.out.print(s.substring(0, 4));
            }
            System.out.println();
        }
    }
    public void wspłrzędne(List listaC , List listaN){
        Random random = new Random();
        //System.out.println(listaN.size());
        int k=0;
        for(int i=0;i<listaN.size();i++) {

            do{
                ((Rycerz)listaN.get(i)).x = random.nextInt(x);
                (((Rycerz)listaN.get(i)).y) = random.nextInt(y/2-1);
                //System.out.println(k+" "+Plansza[(((Rycerz)listaN.get(i)).x)][(((Rycerz)listaN.get(i)).y)]+" "+(((Rycerz)listaN.get(i)).nazwa)+" "+(((Rycerz)listaN.get(i)).y));
            }while(T[((Rycerz)listaN.get(i)).x][((Rycerz)listaN.get(i)).y]!=" *** ") ;
            k++;
            //System.out.println("cos");
            T[((Rycerz)listaN.get(i)).x][((Rycerz)listaN.get(i)).y]=" "+((Rycerz)listaN.get(i)).nazwa+"n";
        }
        for(int i=0;i<listaC.size();i++) {

            do{
                ((Rycerz)listaC.get(i)).x = random.nextInt(x);
                (((Rycerz)listaC.get(i)).y) = y-1-random.nextInt(y/2-1);
                //System.out.println(k+" "+Plansza[(((Rycerz)listaC.get(i)).x)][(((Rycerz)listaC.get(i)).y)]+" "+(((Rycerz)listaC.get(i)).nazwa)+" "+(((Rycerz)listaC.get(i)).y));
            }while(T[((Rycerz)listaC.get(i)).x][((Rycerz)listaC.get(i)).y]!=" *** ") ;
            k++;
            //System.out.println("cos");
            T[((Rycerz)listaC.get(i)).x][((Rycerz)listaC.get(i)).y]=" "+((Rycerz)listaC.get(i)).nazwa+"c";
        }



    }

}