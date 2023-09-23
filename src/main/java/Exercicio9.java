/*

Escrever um algoritmo que leia 4 números e conte quantos deles estão nos seguintes intervalos:
[0.25], [26,50], [51,75] e [76,100].

*/

import org.apache.commons.lang3.tuple.Pair;

import java.util.*;

public class Exercicio9 {

    public static int getNumber(Scanner scanner){
        int number;
        System.out.println("Enter a number");
        try{
            number = scanner.nextInt();
        }
        catch(Exception e){
            if(e instanceof InputMismatchException){
                System.out.println("Please, enter a integer number");
                scanner.next();
                number = getNumber(scanner);
            }
            else{
                throw e;
            }
        }

        return number;
    }

    public static void compareIntervals(Scanner scanner, Map<Integer, Pair<Integer,Integer>> intervals, ArrayList<Integer> gottenNumbers){
        int numbersInIntervals = 0;
        Map<Integer,Integer> results = new HashMap<>();
        results.put(1,0);
        results.put(2,0);
        results.put(3,0);
        results.put(4,0);

        for(int number:gottenNumbers){
            for(Map.Entry<Integer,Pair<Integer,Integer>> entry : intervals.entrySet()){
                if(number >= entry.getValue().getLeft() && number <= entry.getValue().getRight()){
                    results.put(entry.getKey(),results.get(entry.getKey())+1);
                    numbersInIntervals ++;
                    System.out.println(results.get(entry.getKey()));
                }
            }
        }
        System.out.printf("""
                **************************************************
                O total de números presentes nos intervalos é  %d;
                **************************************************
                Números presentes no intervalo entre [%d ,%d]:  %d;
                --------------------------------------------------
                Números presentes no intervalo entre [%d,%d]:  %d;
                --------------------------------------------------
                Números presentes no intervalo entre [%d,%d]:  %d;
                --------------------------------------------------
                Números presentes no intervalo entre [%d,%d]: %d;
                **************************************************
                """,numbersInIntervals,
                intervals.get(1).getLeft(),intervals.get(1).getRight(), results.get(1),
                intervals.get(2).getLeft(),intervals.get(2).getRight(), results.get(2),
                intervals.get(3).getLeft(),intervals.get(3).getRight(), results.get(3),
                intervals.get(4).getLeft(),intervals.get(4).getRight(), results.get(4)
                );
    }

    public static void main(String[]args){
        Scanner scanner = new Scanner(System.in);
        Map<Integer,Pair<Integer,Integer>> intervals = new HashMap<>();
        intervals.put(1,Pair.of(0,25));
        intervals.put(2,Pair.of(26,50));
        intervals.put(3,Pair.of(51,75));
        intervals.put(4,Pair.of(76,100));

        ArrayList<Integer> gottenNumbers = new ArrayList<>();
        for(int i = 0; i < 4; i++){
            gottenNumbers.add(getNumber(scanner));
        }

        compareIntervals(scanner,intervals,gottenNumbers);

    }

}
