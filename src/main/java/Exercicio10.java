/*
Escreva um algoritmo que leia 200 valores inteiros e positivos e:
• encontre o maior valor;
• encontre o menor valor;
• calcule a média dos números lidos.
*/

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Exercicio10 {

    public static int getNumber(Scanner scanner){
        int number;
        System.out.println("Please, enter a positive integer number");
        try{
            number = scanner.nextInt();
            if(number < 0) throw new InputMismatchException();
        }
        catch(Exception e){
            if(e instanceof InputMismatchException){
                System.out.println("Invalid input. Try again.");
                scanner.next();
                number = scanner.nextInt();
            }
            else{
                throw e;
            }
        }
        return number;
    }

    public static void analyzeNumbers(ArrayList<Integer> numbers){
        int max = numbers.stream().mapToInt(a -> a).max().getAsInt();
        int min = numbers.stream().mapToInt(a -> a).min().getAsInt();
        double average = numbers.stream().mapToInt(a -> a).average().getAsDouble();

        System.out.printf("""
                **************************************************
                The biggest value among the 200 integers is: %d
                --------------------------------------------------
                The lowest value among the 200 integers is: %d
                --------------------------------------------------
                The middle of the 200 integers is: %.2f
                **************************************************
                """, max,min,average);
    }
    public static void main(String[]args){
        ArrayList<Integer> numbers = new ArrayList<>();
        for(int i =0;i <= 200; i++){
            //numbers.add(getNumber(new Scanner(System.in)));
            numbers.add(i); //Use this to test :)

        }
        analyzeNumbers(numbers);
    }
}
