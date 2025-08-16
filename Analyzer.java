import java.util.Scanner;

public class Analyzer{

private static String[] days = new String[]{"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
private static int[] temp;

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        boolean runner = true;
        temp = new int[7];

        for(int i = 0; i < days.length; i++){
            System.out.println("Enter temperature for " + days[i] + "(in degrees): ");
            int dayTemp = scanner.nextInt();
            scanner.nextLine();
            temp[i] = dayTemp;
        }
       
        while(runner){
            System.out.println("What would you like to do?");
            System.out.println("1. View average temperature");
            System.out.println("2. View coldest temperature");
            System.out.println("3 View hottest temperature");
            System.out.println("4. View weather this week");
            System.out.println("5. Exit");
            System.out.println("Enter number: ");
            int choice = scanner.nextInt();

            switch(choice){
                //view average temperature
                case 1:
                averageTemp();
                break;

                //view max temp
                case 2:
                minTemp();
                break;

                //view min temp
                case 3:
                maxTemp();
                break;

                //view weather this week
                case 4:
                weatherInfo();
                break;

                //exiting program
                case 5:
                runner = false;
                break;
            }
        }
    }

    private static void averageTemp(){
        int averageTemperature = 0;
        for(int i = 0; i < temp.length; i++){
            averageTemperature += temp[i];
        }
        System.out.println("Average temperature for week: " + averageTemperature/temp.length + " degrees");
    }

    private static void minTemp(){
        int minTemp = 999999999;
        int minIndex = 0;
        for(int i = 0; i < temp.length; i++){
            if(temp[i] < minTemp){
                minTemp = temp[i];
                minIndex = i;
            }
        }

        System.out.println("Coolest temperature: " + minTemp + " degrees, Day: " + days[minIndex]);
    }

    private static void maxTemp(){
        int maxTemp = 0;
        int maxIndex = 0;

        for(int i = 0; i < temp.length; i++){
            if(temp[i] > maxTemp){
                maxTemp = temp[i];
                maxIndex = i;
            }
        }

        System.out.println("Warmest temperature: " + maxTemp  + " degrees, Day: " + days[maxIndex]);
    }

    private static void weatherInfo(){
        for(int i = 0; i < temp.length; i++){
            System.out.println(days[i] + ": " + temp[i] + " degrees");
        }
        System.out.println("----------------");
        averageTemp();
        minTemp();
        maxTemp();
    }

}