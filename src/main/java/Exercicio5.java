
/*
Desenvolva um gerador de tabuada, capaz de gerar a tabuada de qualquer
número inteiro entre 1 a 10.
O usuário deve informar de qual numero ele deseja
ver a tabuada. A saída deve ser conforme o exemplo abaixo:
*/
import java.util.InputMismatchException;
import java.util.Scanner;
public class Exercicio5 {

    public static void generateMultiples(int number){
        for(int i =1; i <= 10; i++){
            System.out.printf("%d x %d = %d%n",number,i,number *i);
        }
    }

    public static int getNumber(Scanner scanner){
        int number;
        System.out.println("Insira um numero");
        try{
            number = scanner.nextInt();
            if(number < 0){
                throw new InputMismatchException();
            }
        }
        catch(Exception e){
            if(e instanceof InputMismatchException){
                System.out.println("Insira um numero inteiro positivo");
                number = getNumber(scanner);
            }
            else{
                throw e;
            }
        }
        return number;
    }

    public static void main(String [] args){
        generateMultiples(getNumber(new Scanner(System.in)));
    }
}
