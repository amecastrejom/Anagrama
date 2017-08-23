/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sudoku;
import java.io.*;
import java.util.*;
import javax.swing.JOptionPane;
/**
 *
 * @author
 */

public class ResuelveSudoku {
  
    public ResuelveSudoku() {
        
    }
    
    /**
     * Método que imprime sudoku
     * en Consola
     * @param m 
     */
    public static void escribeSodoku(int m[][]){
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
                    cad = cad +  "|  " + m[i][j-1] + "   ";
                else
                    if (j % 3 == 0 )
                        cad = cad +  m[i][j-1] + " |  ";
                    else
                        cad = cad + m[i][j-1] + "   ";
        }
        cad = cad + "\n";
        for ( k = 1; k <= 40; k++)
            cad = cad + "_";
        System.out.println(cad);
    }
    
    /**
     * Metodo que dice si el sudoku tiene solucion:
     * si no tiene, manda una advertencia que el sudoku no tiene solucion
     * si si tiene, manda una advertencia diciendo que el sudoku tiene solucion
     * @param a 
     */
    public static void solucion(Sudoku a){
        boolean resp; 
        resp = encuentraSolucion(a);
        if(!resp){
            System.out.println("\n\n\tSudoku sin solución");
            JOptionPane.showMessageDialog(null, "Sudoku sin solución.\n Problema sobre-restringido", "Error", JOptionPane.ERROR_MESSAGE);
        }
        else
        {
            System.out.println("\n\n\tSolución del Sudoku.");
            JOptionPane.showMessageDialog(null ,"Sudoku con Solucion", "Sudoku", JOptionPane.PLAIN_MESSAGE);
            escribeSodoku(a.getMatriz());
        }
    }
    
    /**
     * Método que recibe un Sudoku y va checando recursivamente los números que llenan
     * el sudoku, nuevamente va checando si estan en region , renglon o columna para
     * poder llenarlo como es requerido
     * @param s
     * @return 
     */
    public static boolean encuentraSolucion(Sudoku s){
        if (!s.checarRenglones() || !s.checarColumnas() || !s.checarRegion()) 
            return false;
        else
            return encuentraSolucion(0, 0 , s);
    }

    private static boolean encuentraSolucion(int r, int c, Sudoku s){
        int i;
        if (r > 8)
            return true;
        else
            if (c > 8) 
                return encuentraSolucion(r + 1, 0, s);
            else
                if (s.getMatriz()[r][c] != 0)
                    return encuentraSolucion(r, c + 1, s);
        else
            for (i = 1; i < 10; i++) 
                if (s.estaEnRenglon(r, i) && s.estaEnColumna(c, i) && s.EstaEnRegion(r, c, i)) 
                {
                    s.setMatriz(r, c, i);
                    if (encuentraSolucion(r, c + 1, s)) 
                        return true;  
                }
        s.setMatriz(r, c, 0);
        return false;
    }

    
}
