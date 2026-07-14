package DataStructure.ex7;

public class Forecast {
     public double calculateFutureValue(double presentValue,
                                       double growthRate,
                                       int years) {

        // Base case
        if (years == 0) {
            return presentValue;
        }

        // Recursive call
        return calculateFutureValue(
                presentValue * (1 + growthRate),
                growthRate,
                years - 1
        );
    }
    
    
}
