
package sudoku;

import java.util.Iterator;

/**
 *
 * @author 
 */
public interface ConjuntoADT <T> 
{
    public boolean agrega(T d);
    public T remueve(T d);
    public boolean esElemento(T d);
    public int cardinalidad();
    public boolean esVacio();
    public Object union (Object obj);
    public Object interseccion(Object obj);
    public Object diferencia(Object obj);
    public Iterator <T> iterator();
}






















