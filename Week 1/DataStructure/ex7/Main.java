package DataStructure.ex7;

public class Main {
     public static void main(String[] args) {

        Forecast forecast = new Forecast();

        double presentValue = 10000;
        double growthRate = 0.10;   // 10%
        int years = 5;

        double futureValue = forecast.calculateFutureValue(
                presentValue,
                growthRate,
                years
        );

        System.out.println("Present Value : " + presentValue);
        System.out.println("Growth Rate   : " + (growthRate * 100) + "%");
        System.out.println("Years         : " + years);
        System.out.println("Future Value  : " + futureValue);

    }
    
}
