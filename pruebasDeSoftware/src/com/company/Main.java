package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        //Tenemos una mina de diamantes, representada mediante una cadena de caracteres '<' y '>' de cualquier longitud
        // y orden, devolver el número de diamantes que existen en la mina. Un diamante está formado por el
        // símbolo '<' seguido de '>', esto es "<>". Hay que tener en cuenta que cada vez que se extrae un
        // diamante podría formarse otro.


        System.out.println("¿Cuántos diamantes has extraído de la mina?");
        Scanner sc = new Scanner(System.in);

        String diamante = sc.nextLine();

        int stringLenght = diamante.length();

        int stringLengthWithoutSpaces = diamante.replace(" ", "").length();

        int total1 = 0;
        char temp1;

        int total2 = 0;
        char temp2;

        int result=0;


        for(int i=0;i<diamante.length(); i++){


            temp1 = diamante.charAt(i);
            if (temp1 == '<')
                total1++;


        }

        for(int i=0;i<diamante.length(); i++){


            temp2 = diamante.charAt(i);
            if (temp2 == '>')
                total2++;


        }

        if(total1 == total2){

            result=(total1+total2)/2;
        }else {

           result = (total1+total2)%2 ;

        }

        System.out.printf("Hay un total de %d diamantes", result);








    }
}
