/*
Faça um programa que imprima na tela a soma dos valores de um intervalo definido pelo usuário.
*/

import java.util.InputMismatchException;
import java.util.Scanner;
public class Exercicio3 {

    public static void SumNumbers(int Start,int End){
        int sum = 0;
        for(int i = Start; i <= End; i++){
            sum += i;
        }
        System.out.printf("A soma do intervalo entre %d e %d é %d",Start,End,sum);
    }
    public static int getNumber(Scanner scanner){
        int number;
        try{
            number = scanner.nextInt();
            if(number < 0){
                throw new InputMismatchException();
            }
        }
        catch(Exception e){
            if(e instanceof InputMismatchException){
                System.out.println("Insira um valor válido");
                scanner.next();
                number = getNumber(scanner);
            }
            else{
                throw e;
            }
        }
        return number;

    }

    public static void main(String [] args){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Insira o intervalo dos números");
        int start = getNumber(scanner);

        System.out.println("Insira o segundo número");

        int end = getNumber(scanner);
        SumNumbers(start,end);
    }

}
