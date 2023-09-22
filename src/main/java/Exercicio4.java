/*
Faça um programa que leia 5 números e informe o maior número.
*/

import java.sql.Array;
import java.util.*;

public class Exercicio4 {

    public static int getNumber(Scanner scanner){
        System.out.println("Insira um número");
        int number;
        try{
            number = scanner.nextInt();
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

    public static int biggerNumber(List<Integer> numbers){
        return numbers.stream().max(Integer::compare).get();
    }

    public static void main(String[]args){
        List<Integer> numbers =  new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        int gottenNumbersCount = 0;
        while(gottenNumbersCount < 5){
            numbers.add(getNumber(scanner));
            gottenNumbersCount ++;
        }

        System.out.printf("O maior numero é %d", biggerNumber(numbers));
    }
}
