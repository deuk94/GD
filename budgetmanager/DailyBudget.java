package budgetmanager;

import java.util.*;
import java.util.Calendar;
import java.util.Scanner;
import filehandler.*;

//1번기능 구현 class 입니다.

public class DailyBudget {
	Scanner sc = new Scanner(System.in);
	Calendar calendar = Calendar.getInstance();
	Expense ex = new Expense();

	// 예산
	private int budget;

	// 예산 읽기
	public void readBudget() {
		System.out.println("이번달 예산 => " + DecimalUtil.decimalComma(budget) + "원");
	}

	// 예산 입력
	public void inputBudget() {
		System.out.print("예산을 입력하세요 => ");
		this.budget = Integer.parseInt(sc.nextLine());
		readBudget();
	}

	// 예산 추가
	public void addBudget() {
		System.out.print("추가 할 예산을 입력하세요 => ");
		int addMoney = Integer.parseInt(sc.nextLine());

		this.budget += addMoney;
		readBudget();
	}

	// 예산 초기화
	public void resetBudget() {
		this.budget = 0;
		readBudget();
	}

	// 오늘 날짜 기준 남은 예산을 바탕으로 일일 사용 가능 금액 출력
	public void setBudget() {
		if (budget == 0) {
			System.out.println("예산을 설정해주세요."); // 예산이 0 일시 나오는 출력
		} else {
			System.out.println("-----------------------------------------------------------------------------");
			System.out.println("이번달 남은 일수: " + getRemainingDaysInMonth() + "일");
			System.out.println("일일 사용 가능 금액: " + DecimalUtil.decimalComma(dayExpense()) + "원");
		}
	}

	// 오늘 날짜 기준 남은 일수 계산
	public int getRemainingDaysInMonth() {
		int today = calendar.get(Calendar.DAY_OF_MONTH); // 이번달 남은 일수
		int daysInMonth = calendar.getActualMaximum(Calendar.DAY_OF_MONTH); // 이번달 최대 일수
		return daysInMonth - today;
	}

	// 일일 사용 가능 금액
	public int dayExpense() {
		String day = String.format("%02d", calendar.get(calendar.MONTH) + 1); // 이번달을 00 포맷 문자열로 변수에 저장
		return (budget - ex.MonthTotalExpense(day)) / getRemainingDaysInMonth(); // (예산 - 이번달 총 지출) / 이번달 남은 일수
	}
}