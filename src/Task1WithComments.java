import java.util.Arrays;
import java.util.Scanner;

public class Task1WithComments {
    /**
     * main関数。結局全てはこの中身を実行してるだけ
     */
    public static void main(String args[]) {
        /**
         * Scannerクラスを利用
         * 2行目でimportしている。他の人が作った便利なもの（クラス・設計図）を借りてる
         * インスタンス化し（設計図から実物を作っ）て使えるようにする
         * これは、標準入力に打ったものを読み取ることができる
         */
        Scanner sc = new Scanner(System.in);

        /**
         * while文。条件が常にtrueにしてるため、breakするまでずっと中身を繰り返す
         */
        while(true) {
            /**
             * 標準出力に色々説明を出す。プリント
             */
            System.out.println("-----------------------------------------");
            System.out.println("二次方程式「ax^2 + bx + c = 0」の解を求めます");
            System.out.println("パラメータを「a,b,c」と入力してください");
            System.out.println("「quit」と入力すると終了します");
            System.out.print("> ");

            /**
             * 標準出力の1行を読み取る。inputと名前をつける
             */
            String input = sc.nextLine();

            /**
             * inputがquitならbreakしてwhile文を抜ける
             */
            if (input.equals("quit")) {
                break;

            /**
             * そうじゃなかったら
             */
            } else {
                /**
                 * inputを","で分ける。それをdouble型の配列に入れる
                 * うまく切り分けられなかったら エラー
                 */
                try {
                    double[] param = Arrays.stream(input.split(",")).mapToDouble(Double::parseDouble).toArray();
                    /**
                     * 配列の0,1,2番目を引数として、自分で作った関数"solvingQuadraticEquations"を呼び出す（メソッド呼び出し）
                     */
                    solvingQuadraticEquations(param[0], param[1], param[2]);
                /**
                 * エラーが出たら
                 * その説明を出す
                 * try-catchをしないとエラーが起きたらプログラムが落ちる
                 */
                } catch (RuntimeException e) {
                    System.out.println("入力フォーマットが違います。");
                }
                /**
                 * 1周の処理が終わったら見やすいように改行しとく
                 */
                System.out.println();
            }
        }
    }

    /**
     * 解を求めてプリントする関数（メソッド）を作る
     *
     * public・・・誰でも使える
     * static・・・インスタンス化なしで使える
     * void・・・返り値はない
     * solvingQuadraticEquations・・・自分でつけたメソッド名（処理がわかるようにつける）
     * ()カッコ内・・・引数は二次方程式のパラメータ3つ
     * @param a double型
     * @param b double型
     * @param c double型
     */
    public static void solvingQuadraticEquations(double a, double b, double c) {
        System.out.println(a + "x^2 + " + b + "x + " + c + " = 0 を解くと");

        /**
         * 二次方程式は判別式Dによって解の種類が変わる
         * 先に計算しとく
         */
        double D = b * b - 4 * a * c;

        /**
         * aが0なら一次方程式じゃん。ってことでこのif文が書いてあるけど、
         * 今回は問題文に「二次方程式」って書いてあるから、ここはいらないかも
         * （そんなこと言ったら「a==0 && b==0」、「a==0 && b==0 && c==0」、「a==0 && b==0 && c!=0」もやらないと変よね。
         * 　だからこの分岐作った人頭悪いかも）
         */
        if (a == 0) {
            double x = -c / b;
            System.out.println("x = " + x);
        }

        /**
         * 二次方程式だった時
         * Dによって場合分け
         */
        else {
            /**
             * D>0なら異なる実数解2つもつ
             * それぞれ解の公式から求める
             * 最後にプリント
             */
            if (D > 0) {
                double x1 = (-b + Math.sqrt(D))/ (2 * a);
                double x2 = (-b - Math.sqrt(D))/ (2 * a);
                System.out.println("x = " + x1 + ", " + x2);
            }
            /**
             * D==0なら重解
             */
            else if (D == 0) {
                double x = (-b + Math.sqrt(D))/ (2 * a);
                System.out.println("重解 x = " + x);
            }
            /**
             * D<0なら解なし
             * （正しくは、虚数解。だけど今回はそこまでやってない）
             */
            else if(D < 0) {
                System.out.println("解なし");
            }
        }
    }
}
