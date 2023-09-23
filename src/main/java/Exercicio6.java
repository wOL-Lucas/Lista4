import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Scanner;

/*
Faça um programa que calcule o valor total investido por um colecionador em sua
coleção de CDs e o valor médio gasto em cada um deles.
O usuário deverá informar a quantidade de CDs e o valor para em cada um.
*/
public class Exercicio6 {
    public static int getQuantity(Scanner scanner){
        System.out.println("Insira a quantidade de cds comprados");
        int quantity;
        try{
            quantity = scanner.nextInt();
            if(quantity < 0){
                throw new InputMismatchException();
            }
        }
        catch(Exception e){
            if(e instanceof InputMismatchException){
                System.out.println(("Insira um valor válido"));
                scanner.next();
                quantity = getQuantity(scanner);
            }
            else{
                throw e;
            }
        }
        return quantity;
    }

    public static double getCdValue(Scanner scanner, int idCd){
        System.out.printf("Insira o valor do %do CD%n",idCd+1);
        double cdValue;
        try{
            cdValue = scanner.nextDouble();
            if(cdValue < 0){
                throw new InputMismatchException();
            }
        }
        catch(Exception e){
            if(e instanceof InputMismatchException){
                System.out.println("Insira um valor positivo");
                scanner.next();
                cdValue = getCdValue(scanner,idCd + 1);
            }
            else{
                throw e;
            }
        }

        return cdValue;
    }

    public static double sumCdValues(HashMap<Integer,Double> cdValues){
        double total = 0;
        for(int i = 0; i < cdValues.size(); i++){
            total += cdValues.get(i);
        }

        return total;
    }

    public static double getMiddleCollectionValue(HashMap<Integer,Double> cdValues){
        return sumCdValues(cdValues) / cdValues.size();
    }

    public static void main(String []  args){
        Scanner scanner = new Scanner(System.in);

        HashMap<Integer,Double> cdValues = new HashMap<>();
        int cdQuantity = getQuantity(scanner);
        for(int i = 0; i < cdQuantity; i++){
            cdValues.put(i,getCdValue(scanner,i));
        }

        System.out.printf("O valor total gasto na sua coleção é R$ %.2f%nO valor médio gasto na sua coleção é R$ %.2f", sumCdValues(cdValues), getMiddleCollectionValue(cdValues));

    }
}
