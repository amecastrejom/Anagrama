package sudoku;

import java.util.Iterator;

/**
 *
 * @author
 */
public class Conjunto<T> implements ConjuntoADT<T> {
    private final int MAX = 50;
    private T conjunto[];
    private int cardinalidad;
    public Conjunto(){
        cardinalidad = 0;
        conjunto = (T[]) new Object[MAX];
    }
    
    public String toString(){
        int i, c;
        String cad;
        i = 0;
        c = 0;
        cad = "";
        while (c < cardinalidad && i < MAX){
            if (conjunto[i] != null){
                cad = cad + "\n" + conjunto[i];
                c = c + 1;
            }
            i = i + 1;
        }
        return cad;
    }
    
    public boolean agrega(T d)
    {
        int i;
        boolean resp;
        resp = false;
        if (!this.esElemento(d))
            if (cardinalidad < MAX)
            {
                i = (int)(Math.random()* MAX);
                while (conjunto[i] != null)
                    i = (int)(Math.random()* MAX);
                conjunto[i] = d;
                cardinalidad = cardinalidad + 1;
                resp = true;
            }
        return resp;
    }
    public T remueve(T d)
    {
        T resp;
        int i, c;
        resp = null;
        i = 0;
        c = 0;
        while (resp == null && c < cardinalidad && i < MAX)
        {
            if (conjunto[i] != null)
                if (conjunto[i].equals(d))
                {
                    resp = conjunto[i];
                    conjunto[i] = null;
                    cardinalidad = cardinalidad - 1;
                }
                else
                    c = c + 1;
            i = i + 1;
        }
        return resp;
    }
    public boolean esElemento(T d)
    {
        boolean resp;
        int  i, c;
        resp = false;
        i = 0;
        c = 0;
        while (!resp && c < cardinalidad && i < MAX)
        {
            if (conjunto[i] != null)
                if (conjunto[i].equals(d))
                    resp = true;
                else
                    c = c + 1;
            i = i + 1;
        }
        return resp;
    }
    public int cardinalidad()
    {
        return cardinalidad;
    }
    public boolean esVacio()
    {
        return cardinalidad == 0;
    }
    public Object union (Object obj)
    {
        Conjunto<T> b;
        Conjunto<T> resp;
        int i, c;
        b = (Conjunto<T>)obj;
        resp = new Conjunto<T>();
        i = 0;
        c = 0;
        while (c < cardinalidad && i < MAX)
        {
            if (conjunto[i] != null)
            {
                resp.conjunto[i] = conjunto[i];
                c = c + 1;
            }
            i = i + 1;
        }
        resp.cardinalidad = cardinalidad;
        c = 0;
        i = 0;
        while (c < b.cardinalidad && i < MAX)
        {
            if (b.conjunto[i] != null)
            {
                resp.agrega(b.conjunto[i]);
                c = c + 1;
            }
            i = i + 1;
        }
        return resp;
    }
    public Object interseccion(Object obj)
    {
        Conjunto<T> b;
        Conjunto<T> resp;
        int  i, c;
        b = (Conjunto<T>)obj;
        resp = new Conjunto<T>();
        i = 0;
        c = 0;
        while (c < cardinalidad && i < MAX)
        {
            if (conjunto[i] != null)
            {
                if (b.esElemento(conjunto[i]))
                    resp.agrega(conjunto[i]);
                c = c + 1;
            }
            i = i + 1;
        }
        return resp;
    }
    public Object diferencia(Object obj)
    {
        int i, c;
        Conjunto<T> resp;
        Conjunto<T> b;
        resp = new Conjunto<T>();
        b = (Conjunto<T>)obj;
        c = 0;
        i = 0;
        while (c < cardinalidad && i < MAX)
        {
            if (conjunto[i] != null)
            {
                if (!b.esElemento(conjunto[i]))
                
                    resp.agrega(conjunto[i]);
                c = c + 1;
            }
            i = i + 1;
        }
      return resp;  
    }
    public T remueveSiguiente()
    {
        T resp;
        int i;
        resp = null;
        i = 0;
  
        while (resp == null  && i < MAX)
        {
            if (conjunto[i] != null)
            {
               resp = conjunto[i];
               conjunto[i] = null;
                    cardinalidad = cardinalidad - 1;
            }
                else
                    i = i + 1;
        }
        return resp;
    }
   
    public boolean equals(Object otro){
        boolean resp=false;
        if (otro!=null && otro instanceof Conjunto){
            Conjunto<T> c = (Conjunto) otro;
            if(cardinalidad == c.cardinalidad){
                resp=equals(0,c);
            }
        }
        return resp;
    }
    private boolean equals (int i, Conjunto<T> c){
        if(i==cardinalidad)
            return true;
        else{
            if(c.esElemento(conjunto[i]))
                return equals (i+1, c);
            else
                return false;
        }
    }
    public Iterator<T> iterator(){
        return new IteratorArreglo(conjunto, cardinalidad);
    }
}