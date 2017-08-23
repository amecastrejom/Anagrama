//Dadas dos cadenas s1 y s2 calcula su distancia en cuanto al numero de operaciones que toma convertir s1 
//en s2 las operaciones son:
//SUSTITUCION: fer se convierte en far se sustituye la e con la a
//REMOCION: fer de sonvierte en fr removiendo la e
//ADICION: fer se convierte en fera agregando la a
package anagrama;

/**
 *
 * @author americacastrejon
 */
public class CorrectorOrtografia {
public static void distancia(String s1, String s2){
    System.out.print(distancia(s1,s2,0));
}
private static int distancia(String s1,String s2,int cont){
    int m1=100000,m2=100000,m3=100000,m4=100000;
    if(!s1.isEmpty()&&!s2.isEmpty()){
        if(s1.charAt(0)==s2.charAt(0)){
            m1=distancia(s1.substring(1),s2.substring(1),cont);
        }else{
            m2=distancia(s1,s2.substring(1),cont++);
            m3=distancia(s1.substring(1),s2,cont++);
            m4=distancia(s1.substring(1),s2.substring(1),cont++);
        }
        return Math.min(Math.min(Math.min(m1, m2), m3),m4);
    }else{
        return cont+s1.length()+s2.length();
    }
    
}

public static void main(String[] args) {
       System.out.print("Para combertir 'a' a 'ahora', se necesitan: ");
       distancia("a","ahora");
       System.out.print(" movimientos");
       
       System.out.print("\n");
       System.out.print("Para combertir 'francisco' a 'fer', se necesitan: ");
       distancia("francisco","fer");
       System.out.print(" movimientos");
       
       System.out.print("\n");
       System.out.print("Para combertir 'jejejeje' a 'jajaja', se necesitan: ");
       distancia("jejejeje","jajaja");
       System.out.print(" movimientos");
       
    }

    
}
