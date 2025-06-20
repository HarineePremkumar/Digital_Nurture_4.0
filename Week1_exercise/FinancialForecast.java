public class FinancialForecast {

    
    public static double forecastValue(int years, double initialAmount, double growthRate) {
        
        if (years == 0) {
            return initialAmount;
        }

        
        return forecastValue(years - 1, initialAmount, growthRate) * (1 + growthRate);
    }

    public static void main(String[] args) {
        double initialAmount = 10000;  
        double growthRate = 0.05;      
        int years = 5;

        double futureValue = forecastValue(years, initialAmount, growthRate);
        System.out.printf("Future value after %d years: %.2f\n", years, futureValue);
    }
}


