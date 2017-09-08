/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algoritmosordenamiento;

/**
 *
 * @author americacastrejon
 */
public class AlgoritmosOrdenamiento {
    
    //O(n^)
    public static void seleccion_directa(int v[]) {
   int min, tmp; // elemento de menor peso y elemento temporal
 
   /* recorremos todo el vector */
   for(int i = 0; i < v.length - 1; i++) {
      /* suponemos que es el primero */
      min = i;
      /* recorremos la parte no ordenada */
      for(int j = i+1; j < v.length; j++) {
         /* buscamos el de menor peso */
         if(v[j] < v[min]) min = j;
      }
      /* intercambio posicion i por el de menor peso */
      tmp = v[i];
      v[i] = v[min];
      v[min] = tmp;  
   }
}
    
    //O(n^2)
    public static void insercionDirecta(int datos[]){
    int cabeza;
    int aux;
        for (int i = 1; i < datos.length; i++){ 
                  aux = datos[i]; 
                  cabeza = i - 1; 
                  while ((cabeza >= 0) && (aux < datos[cabeza])){ 
                        datos[cabeza + 1] = datos[cabeza];
                        cabeza--;                  
                  }
                  datos[cabeza + 1] = aux; 
        }
    }
    
    public static void bubbleSort(int datos[]){
        int aux=0;
        for(int j=datos.length; j>=0; j--){
            for(int i=0; i<datos.length-1; i++){
                if(datos[i]>datos[i+1]){
                    aux=datos[i+1];
                    datos[i+1]=datos[i];
                    datos[i]=aux;
                }
            }  
        }
    }
    
    static int findPartition(int arr[], int left, int right){
        int x=0;
        for(int i=0; i<arr.length;i++){
          if((left<right)&&(arr[left]>arr[left+1])){
              x=arr[left];
              arr[left]=arr[left+1];
              arr[left+1]=x;
              left++;
          }
          
          if((left<right-1)&&(arr[left]<arr[left+1])){
              left++;
          }
          
        }
          
      return left;
}
 
    static void quickSort(int datos[], int inf, int sup) {
    int pivote=0;
   if(inf>=sup){
       return;
   }   
   pivote=findPartition(datos,inf,sup);
   
   quickSort(datos,inf,pivote);
   quickSort(datos,pivote+1,sup);
   
}

    public static void imprimeArreglo(int[]a){
			for(int i=0;i<a.length;i++){
				System.out.print("\t" +a[i]);
			}
			System.out.println();
	}
    
   
   public static void mergeSort(int[] datos, int min, int max) {
        int pivote;

        if (min >= max) {
            return;
        }
        
        pivote = (min + max) / 2;
        mergeSort(datos, min, pivote);
        mergeSort(datos, pivote + 1, max);

        int i=min, j=pivote+1, k=0;
        int[] temp= new int[max-min+1];
        
        while(i<=pivote && j<=max){
            if(datos[i]<datos[j]){
                temp[k]=datos[i];
                i++;
            } else {
                temp[k]=datos[j];
                j++;
            }
            k++;
        }
        if(i<=pivote){
            while(i<=pivote){
              temp[k]=datos[i];
              k++;
              i++;
            }
        } else {
            while(j<=max){
                temp[k]=datos[j];
                k++;
                j++;
            }
        }
        for (int n=0;n<temp.length;n++){
            datos[min+n]=temp[n];
        }
    }
    
    
    public static void main(String[] args) {
        int[] datos={20,3,2,19,94,85,12,56,73,-6};
        imprimeArreglo(datos);
        
       insercionDirecta(datos);
        imprimeArreglo(datos);
        
        
        int[] datos3={20,3,2,19,94,85,12,56,73,-6};
        imprimeArreglo(datos3);
        
 
        seleccion_directa(datos3);
        imprimeArreglo(datos3);
        
        
       int[] datos2={20,3,2,19,94,85,12,56,73,-6};
        imprimeArreglo(datos2);
  
        bubbleSort(datos2);
        imprimeArreglo(datos2);
        
        int[] datos4={10,9,12,13,6,5,4,8,2,7};
        imprimeArreglo(datos4);

       quickSort(datos4,0,datos4.length-1);
        imprimeArreglo(datos4);
        
        int[] datos5={10,9,12,13,6,5,4,8,2,7};
        imprimeArreglo(datos5);
        
        mergeSort(datos5, 0, datos.length-1);
        imprimeArreglo(datos5);

       
    }
    
}
