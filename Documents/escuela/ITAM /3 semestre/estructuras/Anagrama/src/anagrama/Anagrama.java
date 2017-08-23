//Escriba un metodo que dada una cadena de n caracteres escriba la n! permutaciones de sus elementos
package anagrama;

/**
 *
 * @author americacastrejon
 */


public class Anagrama {
    private static void anagrama(String s1, String s2){
        char c;
        String resto;
        if(s1.length()==0){
            System.out.print(s2);
            System.out.print("\n");
            
        }else{
        
            for(int i=0; i<s1.length();i++){
                c=s1.charAt(i);
                resto=s1.substring(0,i)+s1.substring(i+1);
                anagrama(resto,c+s2);
            }
        }
    
    }
    public static void ana(String s1){
        anagrama(s1,"");
    }
    
    public static void main(String[] args) {
       ana("fer");
    }
    
}
