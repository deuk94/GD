package budgetmanager;

import java.util.*;

public class Calculator {
	Scanner sc = new Scanner(System.in);

	public void calculator() {
		System.out.println("-----------------------------------------------------------------------------");
		System.out.println("계산기를 실행합니다.");

		System.out.print("\n첫번째 숫자를 입력하세요 =>");
		int num1 = Integer.parseInt(sc.nextLine());

		System.out.print("두번째 숫자를 입력하세요 =>");
		int num2 = Integer.parseInt(sc.nextLine());

		System.out.print("연산자를 입력하세요(+, -, *, /) =>");
		String operator = sc.nextLine();

		switch (operator) {
		case "+":
			System.out.println(num1 + " + " + num2 + " = " + (num1 + num2)); // 더하기 출력
			break;
		case "-":
			System.out.println(num1 + " - " + num2 + " = " + (num1 - num2)); // 빼기 출력
			break;
		case "*":
			System.out.println(num1 + " * " + num2 + " = " + (num1 * num2)); // 곱하기 출력
			break;
		case "/":
			if (num1 == 0 || num2 == 0) {
				System.out.println("0으로 나눌수 없습니다."); // 0으로 나눌 시 에러 발생 방지
			}
			System.out.println(num1 + " / " + num2 + " = " + ((double) num1 / num2)); // 나누기 출력
			break;
		default:
			System.out.println("잘못된 연산입니다."); // 연산자 오류 출력
			break;
		}
	}
}