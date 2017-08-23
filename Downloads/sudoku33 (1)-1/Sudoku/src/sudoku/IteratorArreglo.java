/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sudoku;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 *
 * @author
 */
public class IteratorArreglo <T> implements Iterator<T> {
    private T[] coleccion;
    private int total;
    private int actual;
    
    public IteratorArreglo(T arreglo[], int tam){
        coleccion = arreglo;
        total = tam;
        actual=0;
    }
    
    public boolean hasNext(){
        return actual<total;
    }
    
    public T next(){
        if(!hasNext()){
            throw new NoSuchElementException("-");
        }
        else{
            T result = coleccion[actual];
            actual++;
            return result;
        }
    }
    
    public void remove(){
        throw new UnsupportedOperationException();
    }
    
    
}
