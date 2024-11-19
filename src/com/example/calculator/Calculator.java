package com.example.calculator;

import java.util.ArrayList;
import java.util.List;

public class Calculator {
    private final List<Integer> results;  // 연산 결과를 저장하는 컬렉션

    public Calculator() {
        results = new ArrayList<>();
    }


    // 사칙연산을 수행하는 메서드
    public int calculate(int num1, int num2, char operator) {
        int result;
        switch (operator) {
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
                    throw new ArithmeticException("0으로 나눌 수 없습니다.");
                }
                break;
            case '%':
                if (num2 != 0) {
                    result = num1 % num2;
                } else {
                    throw new ArithmeticException("0으로 나눌 수 없습니다.");
                }

                break;
            default:
                throw new IllegalArgumentException("유효하지 않은 연산자입니다.");
        }
        addResult(result);  // 결과를 저장
        return result;
    }

    // 결과를 results에 추가하는 메서드 (Setter 역할)
    private void addResult(int result) {
        results.add(result);
    }

    // results 컬렉션을 반환하는 메서드 (Getter 역할)
    public List<Integer> getResults() {
        return new ArrayList<>(results); // 캡슐화 유지 위해 복사본 반환
    }

    // 첫 번째 저장된 결과를 삭제하는 메서드
    public void removeResult() {
        results.remove(0);

    }

    // 저장된 전체 결과를 삭제하는 메서드
    public void clearResults() {
        results.clear();
    }
}
