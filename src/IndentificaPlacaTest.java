/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package indentificaplacatest;

import java.io.BufferedReader;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author arauj
 */
public class IndentificaPlacaTest {

    /**
     * @param args the command line arguments
     */
    
    public static int linhas(String file) throws IOException{
        BufferedReader input = new BufferedReader(new FileReader(file));
        int i = 0;
        while (input.readLine() != null) {
            i++;
        }
        input.close();
        return i-1;
    }

    public static ArrayList<Estados> adiciona(String file, int tam) throws IOException{
        ArrayList <Estados> relacao = new ArrayList<Estados>();
        BufferedReader input = new BufferedReader(new FileReader(file));
        String aux[] = new String [3];
        for (int j = 0; j < tam; j++) {
            String linha = input.readLine();
            if(j >= 3){
                /*
                String vetorStr[] = linha.split("\\s+|\\s+");
                for (int i = 0; i < 3; i++)
                    aux[i] = format(vetorStr[i]);
                */
                //  System.out.println(linha.substring(2,4)+"\t"+linha.substring(7,10)+"\t"+linha.substring(13,16));
                relacao.add(new Estados(linha.substring(2,4), linha.substring(7,10), linha.substring(13,16)));
            }
        }
        input.close();
        return relacao;
    }
    
    public static int FindSmallest (int [] arr1){//start method

       int index = 0;
       int min = arr1[index];
       for (int i=1; i<arr1.length; i++){

           if (arr1[i] < min ){
               min = arr1[i];
               index = i;
           }


       }
        System.out.println("menor:\t"+arr1[index]);
       return index ;

    }
    
    public static int compara(String placa, String de, String ate){
        int j = 0, k = 0;
        for (int i = 0; i < placa.length(); i++) {
            char aa = placa.charAt(i);
            String a = "";
            a+=aa;
            
            char bb = de.charAt(i);
            String b = "";
            b+=bb;
            
            char cc = ate.charAt(i);
            String c = "";
            c+=cc;
            
            if(i == 0 && (aa!=bb && aa!=cc)){
                j+=1000;
                k+=1000;
            }
            if(j >= 100 && k>= 100){
                j+=1000;
                k+=1000;
            }
            j += Math.abs(b.compareTo(a));
            k += Math.abs(c.compareTo(a));
            //System.out.println("Main:\t"+aa+"\ta:\t"+bb+"\tb:\t"+cc);
        }
        if( j == 0 || k == 0){
            j = 0;
            k = 0;
        }
        return j+k;
    }
    
    public static int intCompara(String codigo, ArrayList <Estados> relacao){   //  Intermediário compara
        boolean resultado = false;
        int tam[] = new int[relacao.size()];
        for (int i = 0; i < relacao.size(); i++){
            //System.out.println("bingo");
            tam[i] = compara(codigo.substring(0, 3), relacao.get(i).getDe(), relacao.get(i).getAte());
        }
        int i = FindSmallest(tam);
        return i;
    }
    
    public static void main(String[] args)throws IOException{
        // TODO code application logic here
        int l = linhas("valid.txt");
        ArrayList <Estados> relacao = adiciona("valid.txt", l);
        
        System.out.println("\nEntre com a placa:\t");
        Scanner entrada = new Scanner(System.in);
        String placa = entrada.next();

        Placa codigo = new Placa(placa, null);
        
        int x = intCompara(codigo.getCodigo(), relacao);
        codigo.setEstado(relacao.get(x).getUF());
        
        System.out.println("Placa:\t"+codigo.getCodigo()+"\tEstado:\t"+codigo.getEstado());
    }
    
}
