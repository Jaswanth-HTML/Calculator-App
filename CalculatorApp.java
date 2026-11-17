import java.util.Scanner;

// Base class for basic arithmetic operations
class BasicCalculator {
    public double add(double a, double b) {
        return a + b;
    }
    
    public double subtract(double a, double b) {
        return a - b;
    }
    
    public double multiply(double a, double b) {
        return a * b;
    }
    
    public double divide(double a, double b) {
        if (b == 0) {
            System.out.println("Error: Division by zero is not allowed.");
            return 0;
        }
        return a / b;
    }
}

// AdvancedCalculator inherits from BasicCalculator
class AdvancedCalculator extends BasicCalculator {
    public double power(double base, double exponent) {
        return Math.pow(base, exponent);
    }
    
    public double squareRoot(double a) {
        if (a < 0) {
            System.out.println("Error: Cannot calculate square root of a negative number.");
            return 0;
        }
        return Math.sqrt(a);
    }
}

// Main class with interactive menu and Scanner input
public class CalculatorApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        AdvancedCalculator calc = new AdvancedCalculator();
        boolean running = true;
        
        while (running) {
            System.out.println("\n--- Interactive Calculator ---");
            System.out.println("1. Addition (+)");
            System.out.println("2. Subtraction (-)");
            System.out.println("3. Multiplication (*)");
            System.out.println("4. Division (/)");
            System.out.println("5. Power (^)");
            System.out.println("6. Square Root (√)");
            System.out.println("7. Exit");
            System.out.print("Select an option (1-7): ");
            
            int choice = scanner.nextInt();
            
            if (choice == 7) {
                System.out.println("Exiting calculator. Goodbye!");
                break;
            }
            
            double a = 0, b = 0;
            
            // Get inputs based on operation requirements
            if (choice >= 1 && choice <= 5) {
                System.out.print("Enter first number: ");
                a = scanner.nextDouble();
                System.out.print("Enter second number: ");
                b = scanner.nextDouble();
            } else if (choice == 6) {
                System.out.print("Enter number: ");
                a = scanner.nextDouble();
            }
            
            // Execute operation via inheritance
            switch (choice) {
                case 1:
                    System.out.println("Result: " + calc.add(a, b));
                    break;
                case 2:
                    System.out.println("Result: " + calc.subtract(a, b));
                    break;
                case 3:
                    System.out.println("Result: " + calc.multiply(a, b));
                    break;
                case 4:
                    System.out.println("Result: " + calc.divide(a, b));
                    break;
                case 5:
                    System.out.println("Result: " + calc.power(a, b));
                    break;
                case 6:
                    System.out.println("Result: " + calc.squareRoot(a));
                    break;
                default:
                    System.out.println("Invalid choice! Please select between 1 and 7.");
            }
        }
        scanner.close();
    }
}