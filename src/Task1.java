import java.util.Arrays;
import java.util.Scanner;

public class Task1 {
    //
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        while(true) {
            System.out.println("-----------------------------------------");
            System.out.println("二次方程式「ax^2 + bx + c = 0」の解を求めます");
            System.out.println("パラメータを「a,b,c」と入力してください");
            System.out.println("「quit」と入力すると終了します");
            System.out.print("> ");
            String input = sc.nextLine();

            if (input.equals("quit")) {
                break;
            } else {
                try {
                    double[] param = Arrays.stream(input.split(",")).mapToDouble(Double::parseDouble).toArray();
                    solvingQuadraticEquations(param[0], param[1], param[2]);
                } catch (RuntimeException e) {
                    System.out.println("入力フォーマットが違います。");
                }
                System.out.println();
            }
        }
    }

    public static void solvingQuadraticEquations(double a, double b, double c) {
        System.out.println(a + "x^2 + " + b + "x + " + c + " = 0 を解くと");
        double D = b * b - 4 * a * c;
        if (a == 0) {
            double x = -c / b;
            System.out.println("x = " + x);
        }
        else {
            if (D > 0) {
                double x1 = (-b + Math.sqrt(D))/ (2 * a);
                double x2 = (-b - Math.sqrt(D))/ (2 * a);
                System.out.println("x = " + x1 + ", " + x2);
            }
            else if (D == 0) {
                double x = (-b + Math.sqrt(D))/ (2 * a);
                System.out.println("重解 x = " + x);
            }
            else if(D < 0) {
                System.out.println("解なし");
            }
        }
    }
}
