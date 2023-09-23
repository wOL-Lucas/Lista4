/*

8. Numa eleição existem três candidatos.
Faça um programa que peça o número total de eleitores.
Peça para cada eleitor votar e ao final mostrar o número de votos de cada candidato.
*/

import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Scanner;
public class Exercicio8{

    public static int getVotesQuantity(Scanner scanner){
        int quantity;
        System.out.println("Please, enter the quantity of votes that will be taken.");
        try{
            quantity = scanner.nextInt();
            if(quantity < 1){
                throw new InputMismatchException();
            }
        }
        catch(Exception e){
            if(e instanceof InputMismatchException){
                System.out.println("Something went wrong. The quantity of votes to be taken needs to a integer number bigger than zero. Please, try again.");
                scanner.next();
                quantity = getVotesQuantity(scanner);
            }
            else{
                throw e;
            }
        }
        return quantity;
    }

    public static int getVote(Scanner scanner){
        int vote;
        try{
            vote = scanner.nextInt();
            if(!(vote > 0 && vote <=3)){
                throw new InputMismatchException();
            }
        }
        catch(Exception e){
            if(e instanceof InputMismatchException){
                System.out.println("The vote number must be an integer between 1 and 3. Please try again.");
                scanner.next();
                vote = getVote(scanner);
            }
            else{
                throw e;
            }
        }
        return vote;
    }

    public static void doVotation(Scanner scanner, HashMap<Integer,Integer> candidatesVotes, int votesQuantity){
        int vote;

        for(int i = 1; i <= votesQuantity; i++){
            System.out.println("Insert your vote:\nChoose between:number 1, number 2 OR number 3");
            vote = getVote(scanner);
            candidatesVotes.put(vote,candidatesVotes.get(vote) + 1);
        }

        System.out.printf("""
                ******************************************************
                ----
                Election has ended with a total of %d votes.
                Here are the results:
                ----
                1st candidate has ended with %d votes;
                2nd candidate has ended with %d votes;
                3rd candidate has ended with %d votes;
                
                ******************************************************
                
                """,votesQuantity,candidatesVotes.get(1),candidatesVotes.get(2),candidatesVotes.get(3));
    }

    public static void main(String [] args){
        Scanner scanner = new Scanner(System.in);
        HashMap<Integer,Integer> candidatesVotes = new HashMap<>();
        candidatesVotes.put(1,0);
        candidatesVotes.put(2,0);
        candidatesVotes.put(3,0);

        doVotation(scanner,candidatesVotes,getVotesQuantity(scanner));

    }

}