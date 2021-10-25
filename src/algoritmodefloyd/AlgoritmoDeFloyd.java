package algoritmodefloyd;

import java.util.Scanner;

public class AlgoritmoDeFloyd {
    public static void main(String[] args) {
        
        Scanner entrada = new Scanner (System.in);
        int tamanho, contLinha =1, contColuna=1;
        
        System.out.print("Digite o tamanho da matriz: ");
        tamanho = entrada.nextInt();
        
        int matriz[][] = new int[tamanho][tamanho];
        
        //Receber itens da matriz
        for (int i=0; i<matriz.length;i++){
            for (int j=0; j< matriz[i].length;j++){
                System.out.print("Digite o valor da " + contLinha + "º linha" + " e " + contColuna + "º coluna( digite -1 para infinito) : " );
                matriz[i][j] = entrada.nextInt();
                //Imprimir cada vez que adiciona um numero
                imprimeMatriz(matriz);
                contColuna++;
                
                if (contColuna > matriz.length){
                    contColuna =1;
                }
            }
            contLinha++;
        }

        System.out.println("");
        
        //Imprimir Matriz original
        System.out.println("Matriz inicial:");
        imprimeMatriz(matriz);
        
        //Realiza algoritmo na matriz de adjacencia
        algFloyd(matriz);
        
        System.out.println("");
        
        //Imprimir matriz final
        System.out.println("Matriz final: ");
        imprimeMatriz(matriz);
        
        
    }
    
    public static int[][] imprimeMatriz(int[][] m){
        for (int i=0; i<m.length;i++){
            for (int j=0; j <m[i].length; j++){
                System.out.print(m[i][j] + "\t");
            }
            System.out.println("");
        }
        return m;
    }
    
    public static int[][] algFloyd(int[][] m ){
        for(int k=0; k<m.length;k++){
            for (int i=0; i<m.length;i++){
                for(int j=0; j<m.length;j++){
                    if (i != k || j != k || i!= j){
                        if (m[i][j] == -1){
                            if( m[i][k] != -1 && m[k][j] != -1 ){
                                m[i][j] = m[i][k] + m[k][j];
                            }
                        }
                        else if (m[i][j] > m[i][k] + m[k][j]){
                            if(m[i][k] != -1 && m[k][j] != -1){
                                m[i][j] = m[i][k] + m[k][j];
                            }
                            else{
                                m[i][j] = -1;
                            }
                        }
                        
                     }
                }
            }
        }
        
        return m;
    }
    
    
}
