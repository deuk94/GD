package budgetmanager;

import java.util.Scanner;

public class Loan {
	private int loanAmount;
	private double annualInterestRate;
	private int loanTerm;

	Scanner scanner = new Scanner(System.in);

	// 대출 금액 입력
	public void inputLoanAmount() {
		System.out.print("대출 금액을 입력하세요 => ");
		loanAmount = Integer.parseInt(scanner.nextLine());
	}

	// 연이율 입력
	public void inputAnnualInterestRate() {
		System.out.print("연이율(%)을 입력하세요 => ");
		annualInterestRate = Double.parseDouble(scanner.nextLine()) / 100.0;
	}

	// 대출 기간 입력
	public void inputLoanTerm() {
		System.out.print("대출 기간(년)을 입력하세요 => ");
		loanTerm = scanner.nextInt();
	}

	// 대출 이자 상환
	public void calculateAndPrintInterest() {
		int interestprice = (int) (loanAmount * annualInterestRate * loanTerm);
		System.out.printf("총 대출이자: %s (원)\n", DecimalUtil.decimalComma(interestprice));
	}

}