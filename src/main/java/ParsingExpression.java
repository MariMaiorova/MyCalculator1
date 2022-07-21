import java.util.Arrays;
import java.util.StringTokenizer;

public class ParsingExpression {

    public void Test() {


        String calcText = "1+ 6 -5+1 /8";
        StringTokenizer st = new StringTokenizer(calcText, " +-/ ");
        while (st.hasMoreTokens()) {
            System.out.println(st.nextToken());
        }

        // String calcText = "one,two,,three,,four,,    , ,";


        String[] resultArray = Arrays.stream(calcText.split(""))
                .map(e -> e.trim())
                .filter(e -> e.length() > 0)
                .toArray(String[]::new);
        System.out.println(Arrays.toString(resultArray));
        String ZEICHEN = "+-*/";
        String NUMMER = "1234567890";
        double res = 0;
        ;
        //  res = result(resultArray, ZEICHEN, NUMMER );
        System.out.println("Summe ist - " + res);
    }


    public static double result(String[] strExpression, String zeichenSet, String numberSet) {
        double sum = 0;
        String zeichen = "!";
        String number = "";
        for (String s : strExpression) {
            if (numberSet.indexOf(s) >= 0) {
                number = number+s;
            }
            else if (zeichenSet.indexOf(s) >= 0) {
                switch (zeichen) {
                    case "+": { sum +=Integer.parseInt(s);
                        break; }
                    case "-": { sum -=Integer.parseInt(s);
                        break; }
                    case "*": { sum *=Integer.parseInt(s);
                        break; }
                    case "/": { sum /=Integer.parseInt(s);
                        break; }
                    case "!": { sum = Integer.parseInt(s);
                        break; }
                    default:
                        System.out.println("Not found indexex. Not normal");
                }
                zeichen = s;
                number = "";
            }
            else System.out.println("Not found " + s);
        }
        return sum;

    }
}
