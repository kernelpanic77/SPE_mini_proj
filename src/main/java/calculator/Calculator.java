package calculator;

import java.util.InputMismatchException;
import java.util.Scanner;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Calculator {

    private static final Logger logger = LogManager.getLogger(Calculator.class);
    public Calculator() {
    }

    public double fact(double num) {
        double facto = 1;
        for(int i = 1; i <= num; ++i)
        { facto *= i;   }
        return  facto;
    }

    public double Factorial(double num1) {
        double res = fact(num1);
        logger.info("[FACTORIAL] - " + num1 + " [RESULT - FACTORIAL] - " + res);
        return res;
    }

    public double SquareRoot(double num1) {
        double res  = Math.sqrt(num1);
        logger.info("[SQROOT] - " + num1 + " [RESULT - SQROOT] - " + res);
        return res;
    }

    public double Power(double num1, double num2) {
        double res = Math.pow(num1, num2);
        logger.info("[POWER] - " + num1 + " [RAISED_TO] " + num2 + " [RESULT - POWER] - " + res);
        return res;
    }

    public double NaturalLog(double num1) {
        double res = 0;
        try {

            if (num1 <0 ) {
                res = Double.NaN;
                throw new ArithmeticException("Case of NaN 0.0/0.0");
            }
            else {
                res = Math.log(num1);
            }
        } catch (ArithmeticException error) {
            System.out.println("[EXCEPTION - LOG] - Cannot find log of negative numbers " + error.getLocalizedMessage());
        }
        logger.info("[NATURAL_LOG] - " + num1 + " [RESULT - NATURAL_LOG] - " + res) ;
        return res;
    }
    

    public static void main(String[] args) {

        Calculator calculator = new Calculator();
        Scanner scanner = new Scanner(System.in);
        double number1, number2;
        do {
            System.out.println("Choose from the operations below:");
            System.out.print("1. Power\n2. Square root\n3. Factorial\n4. Natural Logarithm\n" +
                    "5. Exit\nEnter your choice: ");
            int choice;
            try {
                choice = scanner.nextInt();
            } catch (InputMismatchException error) {
                scanner.close();
                return;
            }

            switch (choice) {
                case 1:
                    // Power
                    System.out.print("Enter the first number : ");
                    number1 = scanner.nextDouble();
                    System.out.print("Enter the second number : ");
                    number2 = scanner.nextDouble();
                    System.out.println(number1+ " raised to power "+number2+" is : " + calculator.Power(number1, number2));
                    System.out.println("\n");
                    break;
                case 2:
                    // Square root
                    System.out.print("Enter a number : ");
                    number1 = scanner.nextDouble();
                    System.out.println("Square root of "+number1+" is : " + calculator.SquareRoot(number1));
                    System.out.println("\n");
                    break;
                case 3:
                    // Factorial
                    System.out.print("Enter a number : ");
                    number1 = scanner.nextDouble();
                    System.out.println("Factorial of "+number1+" is : " + calculator.Factorial(number1));
                    System.out.println("\n");
                    break;
                case 4:
                    // Natural log
                    System.out.print("Enter a number : ");
                    number1 = scanner.nextDouble();
                    System.out.println("Natural log of "+number1+" is : " + calculator.NaturalLog(number1));
                    System.out.println("\n");

                    break;
                default:
                    System.out.println("Exiting....");
                    scanner.close();
                    return;
            }
        } while (true);
    }
}
