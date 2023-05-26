import javax.xml.crypto.dsig.spec.XSLTTransformParameterSpec;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Random;

public class Main {

    public static String pustaTablica = "***";
    public static void main(String[] args) {
        System.out.println("Hello world!");
        List blue = new ArrayList<>();
        List red = new ArrayList<>();
        int x=10,y=20;
        Plansza plansza = new Plansza(x,y);
        int[] T1 = new int[]{10,6,6,5,10,3};
        int[] T2 = new int[]{1,3,8,6,8,5};
        int suma=0;
        dodanie_do_listy(red,T1,"czerwona");
        dodanie_do_listy(blue,T2,"niebieska");
        plansza.wspłrzędne(red, blue);

        int runda = 0;
        plansza.Plansza_wyświetl();
        while(runda<10){
            //loop game:
            runda++;
            System.out.println("--------------------");

            for(Object l1 : red){
                ((Rycerz)l1).tura(plansza,red,blue);

            }
            for(Object l2 : blue){
                ((Rycerz)l2).tura(plansza,red,blue);


            }

            System.out.println("Runda: "+runda);
            plansza.Plansza_wyświetl();


            //break;
        }
        //ilość jednostek pozostałych na polu bitwy na koniec wszystkich rund
        System.out.println("Czerwoni: "+red.size());
        System.out.println("Niebiescy: "+blue.size());

    }

    public static void dodanie_do_listy(List lista,int[] T,String strona){
        for (int i=0;i<T[0];i++){
            lista.add(new Rycerz());
            int ind = i;
            String id = String.valueOf(ind);
            if(i<10)
            (((Rycerz)lista.get(i)).nazwa)+="0"+id;
            else (((Rycerz)lista.get(i)).nazwa)+=id;
        }
        int ind=0;
        for (int i=T[0];i<T[0]+T[1];i++){
            lista.add(new Łucznik());
            String id = String.valueOf(ind);
            if(ind<10) (((Łucznik)lista.get(i)).nazwa)+="0"+id;
            else (((Łucznik)lista.get(i)).nazwa)+=id;
            ind++;
        }
        ind=0;
        for (int i=T[0]+T[1];i<T[0]+T[1]+T[2];i++){
            lista.add(new Jeździec());
            String id = String.valueOf(ind);
            if(ind<10) (((Jeździec)lista.get(i)).nazwa)+="0"+id;
            else (((Jeździec)lista.get(i)).nazwa)+=id;
            ind++;
        }
        ind=0;
        for (int i=T[0]+T[1]+T[2];i<T[0]+T[1]+T[2]+T[3];i++){
            lista.add(new Rycerz_elitarny());
            String id = String.valueOf(ind);
            if(ind<10) (((Rycerz_elitarny)lista.get(i)).nazwa)+="0"+id;
            else (((Rycerz_elitarny)lista.get(i)).nazwa)+=id;
            ind++;
        }
        ind=0;
        for (int i=T[0]+T[1]+T[2]+T[3];i<T[0]+T[1]+T[2]+T[3]+T[4];i++){
            lista.add(new Kusznik());
            String id = String.valueOf(ind);
            if(ind<10)(((Kusznik)lista.get(i)).nazwa)+="0"+id;
            else (((Kusznik)lista.get(i)).nazwa)+=id;
            ind++;
        }
        ind=0;
        for (int i=T[0]+T[1]+T[2]+T[3]+T[4];i<T[0]+T[1]+T[2]+T[3]+T[4]+T[5];i++){
            lista.add(new Armata());
            String id = String.valueOf(ind);
            if(ind<10) (((Armata)lista.get(i)).nazwa)+="0"+id;
            else (((Armata)lista.get(i)).nazwa)+=id;
            ind++;
        }

            for (int i = 0; i < lista.size(); i++) {
                if(strona == "czerwona" ) {
                (((Rycerz) lista.get(i)).strona) = "czerwona";
                }else (((Rycerz)lista.get(i)).strona) ="niebieska";
            }
    }

}


