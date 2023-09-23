/*
O Sr. Manoel Joaquim acaba de adquirir uma panificadora e pretende implantar a metodologia da tabelinha,
que já é um sucesso na sua loja de 1,99.
Você foi contratado para desenvolver o programa que monta a tabela de preços de pães, de 1 até 50 pães,
a partir do preço do pão informado pelo usuário, conforme o exemplo abaixo:
*/

import java.util.InputMismatchException;
import java.util.Scanner;
public class Exercicio7 {

    public static double getBreadValue(Scanner scanner){
        System.out.println("Enter the value of the bread");
        double breadValue;
        try{
            breadValue = scanner.nextDouble();
            if(breadValue < 0.0){
                throw new InputMismatchException();
            };
        }
        catch(Exception e){
            if(e instanceof InputMismatchException){
                System.out.println("The bread value cannot be negative or zero. Please enter a value price");
                scanner.next();
                breadValue = getBreadValue(scanner);
            }
            else{
                throw e;
            }
        }

        return breadValue;
    }

    public static void displayBreadValuesTable(double breadValue){
        for(int i = 1; i <= 50; i++){
            System.out.printf("%d - R$ %.2f%n",i,breadValue * i);
        }
    }
    public static void main(String[]args){
        displayBreadValuesTable(getBreadValue(new Scanner(System.in)));
    }


}
