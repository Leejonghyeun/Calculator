package com.example.calculator;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Calculator calculator = new Calculator();
        String input;


        System.out.println("간단한 계산기입니다. 'exit'을 입력하면 프로그램이 종료됩니다.");
        // 계산기 인터페이스 구축
        while (true) {
            System.out.println("첫 번째 숫자를 입력하세요 (또는 'exit' 입력): ");
            System.out.println("현재까지의 모든 연산 결과: " + calculator.getResults());

            input = scanner.next();
            if (input.equals("exit")) {
                System.out.println("프로그램을 종료합니다.");
                break;
            }

            // 예외 처리 try catch 사용
            int num1;
            try {
                num1 = Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("유효한 숫자를 입력하세요.");
                continue;
            }

            System.out.println("연산자를 입력하세요 (+, -, *, /, %): ");
            char operator = scanner.next().charAt(0);

            System.out.println("두 번째 숫자를 입력하세요: ");
            System.out.println("현재까지의 모든 연산 결과: " + calculator.getResults());
            input = scanner.next();
            if (input.equals("exit")) {
                System.out.println("프로그램을 종료합니다.");
                break;
            }

            int num2;
            try {
                num2 = Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("유효한 숫자를 입력하세요.");
                continue;
            }

            try {
                int result = calculator.calculate(num1, num2, operator);
                System.out.println("결과: " + result);
            } catch (ArithmeticException | IllegalArgumentException e) {
                System.out.println("오류: " + e.getMessage());
                continue;
            }

            // 전체 결과 출력
            System.out.println("현재까지의 모든 연산 결과: " + calculator.getResults());

            // 첫 번째 저장된 결과 삭제 기능
            System.out.print("첫 번째 결과를 삭제하시겠습니까? (y/n) or 모든 연산 결과를 삭제하시겠습니까? (Y/N)): ");
            String delete = scanner.next();
            if (delete.equals("y")) {
                calculator.removeResult();
                System.out.println("첫 번째 결과가 삭제되었습니다.");
                System.out.println("현재 남은 연산 결과: " + calculator.getResults());
            }
            if (delete.equals("Y")) {
                calculator.clearResults();
                System.out.println("모든 연산 결과가 삭제되었습니다.");
                System.out.println("현재 남은 연산 결과: " + calculator.getResults());
            }
        }
        scanner.close();
    }
}
