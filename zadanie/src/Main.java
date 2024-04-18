import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
class Calculation {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input: ");
        String expression = scanner.nextLine();
        System.out.println(parse(expression));
    }

    public static String parse(String expression) throws Exception {
        int num1;
        int num2;
        String op;
        String res;
        boolean isCa;
        String[] oper = expression.split("[+\\-*/]");
        if (oper.length != 2) throw new Exception("Должно быть два операнда");//т.к. формат математической операции не удовлетворяет заданию - два операнда и один оператор (+, -, /, *)
        op = kill(expression);
        if (op == null) throw new Exception("Неподдерживаемая операция");
        if (Calcu.isCa(oper[0]) && Calcu.isCa(oper[1])) {
            num1 = Calcu.convertArab(oper[0]);
            num2 = Calcu.convertArab(oper[1]);
            isCa = true;
        }
        else if (!Calcu.isCa(oper[0]) && !Calcu.isCa(oper[1])) {
            num1 = Integer.parseInt(oper[0]);
            num2 = Integer.parseInt(oper[1]);
            isCa = false;
        }
        else {
            throw new Exception("Числа должны быть в одном формате");
        }
        if (num1 > 10 || num2 > 10) {
            throw new Exception("Числа должны быть от 1 до 10");
        }
        int arab = calc(num1, num2, op);
        if (isCa) {
            if (arab <= 0) {
                throw new Exception("Римское число должно быть больше нуля");
            }
            res = Calcu.convertToArabic(arab);
        } else {
            res = String.valueOf(arab);
        }
        return res;
    }
    static String kill(String expression) {
        if (expression.contains("+")) return "+";
        else if (expression.contains("-")) return "-";
        else if (expression.contains("*")) return "*";
        else if (expression.contains("/")) return "/";
        else return null;
    }
    static int calc(int a, int b, String oper) {
        if (oper.equals("+")) return a + b;
        else if (oper.equals("-")) return a - b;
        else if (oper.equals("*")) return a * b;
        else return a / b;
    }
}
    class Calcu {
    static String[] Ar = new String[]{"0", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X", "XI",
            "XII", "XIII", "XIV", "XV", "XVI", "XVII", "XVIII", "XIX", "XX", "XXI", "XXII", "XXIII", "XXIV",
            "XXV", "XXVI", "XXVII", "XXVIII", "XXIX", "XXX", "XXXI", "XXXII", "XXXIII", "XXXIV", "XXXV", "XXXVI",
            "XXXVII", "XXXVIII", "XXXIX", "XL", "XLI", "XLII", "XLIII", "XLIV", "XLV", "XLVI", "XLVII", "XLVIII",
            "XLIX", "L", "LI", "LII", "LIII", "LIV", "LV", "LVI", "LVII", "LVIII", "LIX", "LX", "LXI", "LXII",
            "LXIII", "LXIV", "LXV", "LXVI", "LXVII", "LXVIII", "LXIX", "LXX", "LXXI", "LXXII", "LXXIII", "LXXIV",
            "LXXV", "LXXVI", "LXXVII", "LXXVIII", "LXXIX", "LXXX", "LXXXI", "LXXXII", "LXXXIII", "LXXXIV", "LXXXV",
            "LXXXVI", "LXXXVII", "LXXXVIII", "LXXXIX", "XC", "XCI", "XCII", "XCIII", "XCIV", "XCV", "XCVI", "XCVII",
            "XCVIII", "XCIX", "C"};

    public static boolean isCa(String val) {
        for (int i = 0; i < Ar.length; i++) {
            if (val.equals(Ar[i])) {
                return true;
            }
        }
        return false;
    }
    public static int convertArab(String con) {
        for (int i = 0; i < Ar.length; i++) {
            if (con.equals(Ar[i])) {
                return i;
            }
        }
        return -1;
    }
    public static String convertToArabic(int arabian) {
        return Ar[arabian];
    }
}