/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lista;
import java.util.Stack;
/**
 *
 * @author americacastrejon
 */
public class Lista<T> {
    private Nodo<T> cabeza;
    private int cont;
    
    public void Lista(){
        cabeza=new Nodo<T>();
        cont=0;
    }
    
    public void agrega(T dato){
        Nodo <T> nuevo = new Nodo (dato);
        if (isEmpty())
            cabeza = nuevo;
        else{
            Nodo <T> apuntador = cabeza;
            while (apuntador.getSig() != null)
                apuntador = apuntador.getSig();
            apuntador.setSig(nuevo);
        }
        
    }
    
     public boolean isEmpty() {
        return cabeza == null;
    }
    
    /* INVERSO PILA 
     public void inversoPila(){
         Stack<T> pila = new Stack<T>();
         Nodo<T> current=primero.getSiguiente();
         for(int i=0; i<cuantosElementos()-1; i++){
             pila.push(current.getDato());
             current=current.getSiguiente();
         }
         
         while(!pila.isEmpty()){
             System.out.print(pila.pop()+ "\t");
         }
         
    }
     */
     
    //INVERSO PILA RECURSIVO 
    public void inversoPila(){
         Stack<T> pila = new Stack<T>();
         Nodo<T> actual=cabeza.getSig();
         for(int i=0; i<cont-1; i++){
             pila.push(actual.getDato());
             actual=actual.getSig();
         }
         
        imprimePilaR(actual);
         
    }
    
    private void imprimePilaR(Nodo<T> actual){
        if(actual==null){
            return;
        }
        
        imprimePilaR(actual.getSig());
        System.out.println(actual.getDato());
    }
    
    public void invierteElem(){
         Stack<T> pila = new Stack<T>();
         Nodo<T> actual=cabeza.getSig();
         for(int i=0; i<cont-1; i++){
             pila.push(actual.getDato());
             actual=actual.getSig();
         }
         
        invierteElem(actual);
         
    }
    
    //INVIERTE ELEMENTOS
    private Nodo<T> invierteElem(Nodo<T> actual){
        T elem;
        if(actual==null){
            return cabeza.getSig();
        }
        elem=actual.getDato();
        Nodo<T> temp=invierteElem(actual.getSig());
        temp.setDato(elem);
        return temp.getSig();
    }
    
    //INVIERTE LISTA
    private Nodo<T> invierteLista(Nodo<T> actual){
        if(actual==null){
            return actual;
        }
        if(actual.getSig()==null){
            cabeza.setSig(actual);
            return actual;
        }
        Nodo<T> sig=invierteLista(actual.getSig());
        sig.setSig(actual);
        actual.setSig(null);
        return actual;
    }
    
    public void invierte(){
        invierteLista(cabeza.getSig());
    }

    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
           Lista<Integer> lista=new Lista<>();
         
        System.out.println("Insercion de numeros del 0 al 9 en forma de cola");
        for(int i=0;i<10;i++){
            lista.agrega(i);
        }
         
        //Mostramos la lista
        lista.inversoPila(); 
        lista.invierteElem();
        lista.invierte();
        
         
         
    }
    
}
