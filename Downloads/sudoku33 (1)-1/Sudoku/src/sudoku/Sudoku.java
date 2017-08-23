/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sudoku;

/**
 *
 * @author 
 */

public class Sudoku {
    
    protected int matriz[][];
    private Conjunto<Integer> numeros; 
    
    /**
    *Constructor del Objeto Sudoku.
    */
    
    Sudoku(int matriz[][]) {
        this.matriz = matriz;
        numeros = new Conjunto<Integer>();
        int i;
        for(i = 1; i < 10; i++)
            numeros.agrega(i);
    }
    
    
    /**
     * toString
     * Lo utilizamos para chequeos en el Sudoku, especificamente cuando se necesita checar los datos de la matriz del Sudoku
     * @return 
     */
    public String toString(){
        
        int i, j, k;
        String cad = "";
        for (i=0;i<9;i++)
        {
            cad = cad + "\n";
            if (i % 3 == 0)
            {
                for ( k = 1; k <= 40; k++)
                    cad = cad + "_";
                cad = cad + "\n";
            }
            for(j=1;j<10;j++)
                if (j == 1)
                    cad = cad +  "|  " + matriz[i][j-1] + "   ";
                else
                    if (j % 3 == 0 )
                        cad = cad +  matriz[i][j-1] + " |  ";
                    else
                        cad = cad + matriz[i][j-1] + "   ";
        }
        cad = cad + "\n";
        for ( k = 1; k <= 40; k++)
            cad = cad + "_";
        return cad;
    }
    
    
    /**
     * Regresa la matriz completa
     * @return 
     */
    public int[][] getMatriz(){
        return matriz;
    }
    
    
    /**
     * Cambia el valor almacenado en la posición (r,c)
     * @param a
     * @param b
     * @param d 
     */
    public void setMatriz(int a,int b, int d){
        matriz[a][b] = d;
    }
    
    
    /**
     * Devuelve el valor que se encuentra en la posición (a,b)
     * @param a
     * @param b
     * @return 
     */
    public int getNumero(int a, int b){
        return matriz[a][b];
    }
    
    /**
     * 
     * @return 
     */
        public boolean checarRenglones(){
        Conjunto<Integer> a;
        a = new Conjunto<Integer>();
        return checarRenglones(a);
    }

    private boolean checarRenglones(Conjunto <Integer> a){
        boolean resp;
        int i;
        int j;
        resp = true;
        i = 0;
        j = 0;
        while (resp && i < 9)
        {
            while (j < 9 && resp)
            {
                if (matriz[i][j] != 0)
                {
                    resp = a.esElemento(matriz[i][j]);
                    if (resp == true)
                        resp = false;
                    else
                        resp = a.agrega(matriz[i][j]);
                }  
                j = j + 1;
            }
            a = (Conjunto)a.diferencia(numeros);
            j=0;//agrego esta linea para restringir todos los renglones
            i = i + 1;
        }
        return resp;
    }
    
    
    /**
     * 
     * @return
     */
    public boolean checarColumnas(){
        Conjunto<Integer> a = new Conjunto<Integer>();
        return checarColumnas(a);
    }
    
    private boolean checarColumnas(Conjunto <Integer> a){
        boolean resp;
        int i;
        int j;
        resp = true;
        i = j = 0; 
        while (resp && i < 9)
        {
            while (j < 9 && resp){
                if (matriz[j][i] != 0){
                    resp = a.esElemento(matriz[j][i]);
                    if (resp == true)
                        resp = false;
                    else
                        resp = a.agrega(matriz[j][i]);
                }  
                j = j + 1;
            }
            a = (Conjunto)a.diferencia(numeros);
            j=0;//se agrego al proyecto antes no checaba si estaba sobrerestringido en todas las columnas 
            i = i + 1;
        }
        return resp;
    }
    
    
    /**
     * 
     * @return 
     */
    public boolean checarRegion(){
        Conjunto <Integer> a = new Conjunto<Integer>();
        Conjunto <Integer> b = new Conjunto<Integer>();
        Conjunto <Integer> c = new Conjunto<Integer>();
        return checarRegion(a,b,c,0,0,true);
    }
    
    private boolean checarRegion(Conjunto<Integer> a, Conjunto<Integer> b, Conjunto<Integer> c, int i, int j, boolean res){
        if (j > 8 || !res) 
            return res;
        else 
            if (i < 3) 
                if (matriz[j][i] != 0 || matriz[j][i + 3] != 0 || matriz[j][i + 6] != 0) 
                    if (matriz[j][i] == 0) 
                        if (matriz[j][i + 3] == 0) 
                            return checarRegion(a, b, c, i + 1, j, c.agrega(matriz[j][i + 6]));
                         else 
                            if (matriz[j][i + 6] == 0) 
                                return checarRegion(a, b, c, i + 1, j, b.agrega(matriz[j][i + 3]));
                             else 
                                return checarRegion(a, b, c, i + 1, j, b.agrega(matriz[j][i + 3]) && c.agrega(matriz[j][i + 6]));                        
                    else
                        if (matriz[j][i + 3] == 0) 
                            if (matriz[j][i + 6] == 0) 
                                return checarRegion(a, b, c, i + 1, j, a.agrega(matriz[j][i]));
                            else 
                                return checarRegion(a, b, c, i + 1, j, a.agrega(matriz[j][i]) && c.agrega(matriz[j][i + 6]));
                            
                        else
                            if (matriz[j][i + 6] == 0) 
                                return checarRegion(a, b, c, i + 1, j, a.agrega(matriz[j][i]) && b.agrega(matriz[j][i + 3]));
                            else 
                                return checarRegion(a, b, c, i + 1, j, a.agrega(matriz[j][i]) && b.agrega(matriz[j][i + 3]) && c.agrega(matriz[j][i + 6]));
                else 
                    return checarRegion(a, b, c, i + 1, j, res);
            else 
                if (j % 3 == 2 && j != 0) 
                {
                    i = 0;
                    a = (Conjunto<Integer>) a.diferencia(numeros);
                    b = (Conjunto<Integer>) b.diferencia(numeros);
                    c = (Conjunto<Integer>) c.diferencia(numeros);
                    return checarRegion(a, b, c, 0, j + 1, res);
                } 
                else 
                    return checarRegion(a, b, c, 0, j + 1, res);
    }
    
    /**
     * Método para ver si un dato n se encuentra en el renglón r
     * @param r
     * @param n
     * @return 
     */
    public boolean estaEnRenglon(int r, int n){
        boolean resp;
        int c;
        resp = true;
        c = 0;
        while (c < 9 && resp)
        {
            if (matriz[r][c] == n) 
                resp = false;
            c = c + 1;
        }
        return resp;
    }
    
    /**
     * Método para ver si un dato n está en la columna c
     * @param c
     * @param n
     * @return 
     */
    public boolean estaEnColumna(int c, int n){
        boolean resp;
        int r;
        resp = true;
        r = 0;
        while (r < 9 && resp)
        {
            if (matriz[r][c] == n) 
                resp = false;
            r = r + 1;
        }
        return resp;
    }
 
    /**
     * Método para ver si un número n se encuentra en una región específica de las 9.
     * @param r
     * @param c
     * @param n
     * @return 
     */
    public boolean EstaEnRegion(int r, int c, int n){
        int i, j;
        boolean resp;
        resp = true;
        j = 0;
        r = (r / 3) * 3;
        c = (c / 3) * 3;

       while ( j < 3 && resp)
       {
            i = 0;
            while (i < 3 && resp)
                if (matriz[r + j][c + i] == n)
                    resp =  false;
                else
                    i = i + 1;
            j = j + 1;
        }
        return resp;
    }
    
    /**
     * Métodos recursovos que checan si hay datos que se repiten en renglones, columnas y regiones y que en base a eso van agregando los datos de la solución.
     * @return 
     */
    public boolean resuelve(){
        if (!checarRenglones() || !checarColumnas() || !checarRegion()) 
            return false;
        else
            return resuelve(0, 0);
    }
    
    private boolean resuelve(int r, int c){
        int i;
        if (r > 8)
            return true;
        else
            if (c > 8) 
                return resuelve(r + 1, 0);
            else
                if (matriz[r][c] != 0) 
                    return resuelve(r, c + 1);
                else
                    for (i = 1; i < 10; i++) 
                    {
                        if (estaEnRenglon(r, i) && estaEnColumna(c, i) && EstaEnRegion(r, c, i)) 
                        {
                            matriz[r][c] = i;
                            if (resuelve(r, c + 1)) 
                                return true;
                        }
                    }
        matriz[r][c] = 0;
        return false;
    }

}