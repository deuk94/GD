package budgetmanager;

import java.util.Scanner;

public class Exchange {

	Scanner scanner = new Scanner(System.in);

	private int exchangerate; // 환율
	private double money; // 한국 돈

	// 환율 메서드 ex) 1$ = 1377원 -> 1387 | 1€ = 1557원 -> 1557
	public void inputExchangeRate() {
		System.out.print("환율을 입력하세요 => ");
		exchangerate = Integer.parseInt(scanner.nextLine());
	}

	// 변환활 금액
	public void inputUsd() {
		System.out.print("바꾸실 금액을 입력하세요 => ");
		money = Integer.parseInt(scanner.nextLine());

	}

	// 변환된 금액 메서드
	public void exchangeMoney() {
		double calculate = money / exchangerate;
		System.out.printf("변환된 달러: %.2f (달러)\n", calculate);
	}

}
