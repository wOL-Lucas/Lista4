/*

8. Numa eleição existem três candidatos.
Faça um programa que peça o número total de eleitores.
Peça para cada eleitor votar e ao final mostrar o número de votos de cada candidato.
*/

import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Scanner;


public class Exercicio8 {

    public static int getNumber(Scanner scanner){
        int number;
        System.out.println("Enter your vote");
        try{
            number = scanner.nextInt();
            if(number < 0){
                throw new InputMismatchException();
            }
        }
        catch(Exception e){
            if(e instanceof InputMismatchException){
                System.out.println("Please, enter only positive integer numbers");
                scanner.next();
                number = getNumber(scanner);
            }
            else{
                throw e;
            }
        }
        return number;
    }
    public static void main(String[]args){
        Scanner scanner = new Scanner(System.in);
        HashMap<Integer,Integer> candidateVotes = new HashMap<>();
        candidateVotes.put(1,0);
        candidateVotes.put(2,0);
        candidateVotes.put(3,0);

        int votesQuantity = getNumber(scanner);
        for(int i = 0; i < votesQuantity; i++){
            int vote = getNumber(scanner);
            try{
                candidateVotes.put(vote,candidateVotes.get(vote) + 1);
            }
            catch(Exception e){
                if(e instanceof NullPointerException){
                    System.out.println("Por favor, insira um número de 1 a 3");
                    vote = getNumber(scanner);
                }
            }
        }

    }
}
