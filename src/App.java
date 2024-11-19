


import java.util.Scanner;


public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input;

        System.out.println("간단한 계산기입니다. 'exit'을 입력하면 프로그램이 종료됩니다.");

        while (true) {
            System.out.print("첫 번째 숫자를 입력하세요 (또는 'exit' 입력): ");
            input = scanner.next();
            if (input.equals("exit")) {
                System.out.println("프로그램을 종료합니다.");
                break;
            }

            int num1;
            try {
                num1 = Integer.parseInt(input);  // 첫 번째 숫자
            } catch (NumberFormatException e) {
                System.out.println("유효한 숫자를 입력하세요.");
                continue;



            }

            char a;
            while (true) {
                System.out.print("연산자를 입력하세요 (+, -, *, /, %): ");
                a = scanner.next().charAt(0);

                // 유효한 연산자인지 확인
                if (a == '+' || a == '-' || a == '*' || a == '/' || a == '%') {
                    break;
                } else {
                    System.out.println("유효하지 않은 연산자입니다. 다시 입력하세요.");
                }
            }





            System.out.print("두 번째 숫자를 입력하세요: ");
            input = scanner.next();
            if (input.equals("exit")) {
                System.out.println("프로그램을 종료합니다.");
                break;
            }

            int num2;
            try {
                num2 = Integer.parseInt(input);  // 두 번째 숫자
            } catch (NumberFormatException e) {
                System.out.println("유효한 숫자를 입력하세요.");
                continue;
            }

            int result = 0;
            boolean data = true;

            switch (a) {
                case '+':
                    result = num1 + num2;
                    break;
                case '-':
                    result = num1 - num2;
                    break;
                case '*':
                    result = num1 * num2;
                    break;
                case '/':
                    if (num2 != 0) {
                        result = num1 / num2;
                    } else {
                        System.out.println("오류: 0으로 나눌 수 없습니다.");
                        data = false;
                    }
                    break;
                case '%':
                    if (num2 != 0) {
                        result = num1 % num2;
                    } else {
                        System.out.println("오류: 0으로 나눌 수 없습니다.");
                        data = false;
                    }
                    break;

            }

            if (data) {
                System.out.println("결과: " + result);
            }
        }


    }
}
