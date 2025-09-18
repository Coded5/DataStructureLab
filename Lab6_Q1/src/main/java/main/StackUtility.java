package main;

public class StackUtility {
    static String alphabets = "abcdefghijklmnopqrstuvwxyz";

    public static String operate(MyStack s1, MyStack s2) throws Exception {
        MyStack result = new StackArray();

        while (s1.size() >= 2 && !s2.isEmpty()) {
            int num1 = s1.top();
            s1.pop();
            int num2 = s1.top();
            s1.pop();

            int operation = s2.top();
            s2.pop();

            int sign = (operation >= 0) ? 1 : -1;

            int letter = num1 + num2 * sign;
            result.push(letter);
        }

        String word = "";
        while (!result.isEmpty()) {
            word += alphabets.charAt(result.top());
            result.pop();
        }

        return word;
    }
}
