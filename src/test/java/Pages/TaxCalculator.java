package Pages;

public class TaxCalculator {
        public static void main(String[] args) {
            // Example values for item total and tax amount
            double itemTotal = 45.98; // Replace with the actual item total
            double taxAmount = 3.68;   // Replace with the actual tax amount

            // Calculate the tax percentage
            double taxPercentage = calculateTaxPercentage(itemTotal, taxAmount);

            // Print the result
            System.out.printf("The tax percentage is: %.2f%%\n", taxPercentage);
        }

        public static double calculateTaxPercentage(double itemTotal, double taxAmount) {
            if (itemTotal <= 0) {
                throw new IllegalArgumentException("Item total must be greater than zero.");
            }
            return (taxAmount / itemTotal) * 100;
        }
    }

