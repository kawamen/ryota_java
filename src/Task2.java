import java.util.Scanner;

public class Task2 {
    public static void main(String[] args) {
        int STUDENT_NUM = 8;

        String[] nameList = new String[STUDENT_NUM];
        double[] scoreList = new double[STUDENT_NUM];

        Scanner sc = new Scanner(System.in);
        System.out.println("名前と素点を8人分入れてください。");
        System.out.println("間に空白を入れてください");
        System.out.print("> ");
        for (int i=0; i<STUDENT_NUM; i++) {
            nameList[i] = sc.next();
            scoreList[i] = sc.nextDouble();
        }

        double average = calcAverage(scoreList);
        double standerdDeviation = calcStanderdDeviation(scoreList, average);

        double[][] scoreAndStdScrList = new double[STUDENT_NUM][2];
        for (int i=0; i<STUDENT_NUM; i++) {
            double score = scoreList[i];
            scoreAndStdScrList[i][0] = score;
            scoreAndStdScrList[i][1] = 50 + (score - average) / standerdDeviation * 10;
        }

        System.out.println("Average = " + new java.text.DecimalFormat("0.#").format(average));
        System.out.println("Standerd Deviation = " + new java.text.DecimalFormat("0.0#").format(standerdDeviation));
        System.out.print("\t\t");
        for (String name : nameList) {
            System.out.print(name + "\t");
        }
        System.out.println();
        System.out.print("Score\t");
        for (double score : scoreList) {
            System.out.print(String.format("%-4s", new java.text.DecimalFormat("0.#").format(score)) + "\t");
        }
        System.out.println();
        System.out.print("StdScr\t");
        for (int i=0; i<STUDENT_NUM; i++) {
            System.out.print(String.format("%-4s", new java.text.DecimalFormat("0.0#").format(scoreAndStdScrList[i][1])) + "\t");
        }
        System.out.println();

    }

    public static double calcAverage(double[] scoreList) {
        double sum = 0;
        for (double score : scoreList) {
            sum += score;
        }
        double average = sum / scoreList.length;
        return average;
    }

    public static double calcStanderdDeviation(double[] scoreList, double average) {
        double sumOfSquaresDeviation = 0;
        for(double score : scoreList) {
            double deviation = score - average;
            sumOfSquaresDeviation += deviation * deviation;
        }
        double standerdDeviation = Math.sqrt(sumOfSquaresDeviation/scoreList.length);
        return standerdDeviation;
    }
}
