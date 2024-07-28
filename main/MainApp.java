package main;

import java.util.Scanner;

import budgetmanager.Calculator;
import budgetmanager.DailyBudget;
import budgetmanager.Exchange;
import budgetmanager.GetRecordsByType;
import budgetmanager.Loan;
import budgetmanager.MaxMinMonth;
import budgetmanager.PercentUI;
import filehandler.ModifyRecords;
import filehandler.RecordDeleter;
import filehandler.SaveRecords;
import memomanager.FindMemo;
import memomanager.LoadMemo;
import memomanager.SaveMemo;

/**
 * 주요 애플리케이션 클래스. 개인 재무 및 기타 유틸리티를 관리
 */
public class MainApp {

	public static void main(String[] args) {

		// 필요한 컴포넌트 초기화
		SaveRecords saveRecords = new SaveRecords();
		PercentUI percentUI = new PercentUI();
		GetRecordsByType getRecordsByType = new GetRecordsByType();
		DailyBudget dailyBudget = new DailyBudget();
		ModifyRecords modifyRecords = new ModifyRecords();
		RecordDeleter recordDeleter = new RecordDeleter();
		MaxMinMonth maxMinMonth = new MaxMinMonth();
		Calculator calculator = new Calculator();
		LoginManager loginManager = new LoginManager();
		Loan loan = new Loan();
		Exchange exchange = new Exchange();
		SaveMemo saveMemo = new SaveMemo();
		LoadMemo loadMemo = new LoadMemo();
		FindMemo findMemo = new FindMemo();

		boolean isRunning = true;
		Scanner scanner = new Scanner(System.in);

		// 로그인 화면 표시
		loginManager.displayLogin();

		while (isRunning) {
			// 메인 메뉴 표시
			System.out.println("----------------------------------------------------------");
			System.out.println("                          가 계 부                          ");
			System.out.println("----------------------------------------------------------");
			System.out.println();
			System.out.println("1. 가계부 기입, 수정, 삭제(수입/지출)");
			System.out.println("2. 메모장");
			System.out.println("3. 예산");
			System.out.println("4. 검색");
			System.out.println("5. 계산기");
			System.out.println("6. 대출이자 계산기");
			System.out.println("7. 환율 계산기");
			System.out.println("9. 종료");

			System.out.print("선택하실 메뉴의 번호를 작성해주세요 => ");
			String menuChoice = scanner.nextLine();

			switch (menuChoice) {
			case "1":
				handleRecordManagement(scanner, saveRecords, modifyRecords, recordDeleter);
				break;
			case "2":
				handleMemoManagement(scanner, loadMemo, saveMemo, findMemo);
				break;
			case "3":
				handleBudgetManagement(scanner, dailyBudget);
				break;
			case "4":
				handleSearch(scanner, getRecordsByType, percentUI, maxMinMonth, dailyBudget);
				break;
			case "5":
				calculator.calculator();
				break;
			case "6":
				loan.inputLoanAmount();
				loan.inputAnnualInterestRate();
				loan.inputLoanTerm();
				loan.calculateAndPrintInterest();
				break;
			case "7":
				exchange.inputExchangeRate();
				exchange.inputUsd();
				exchange.exchangeMoney();
				break;
			case "9":
				System.out.println("가계부를 종료합니다.");
				isRunning = false;
				break;
			default:
				System.out.println("잘못된 선택입니다. 다시 시도해주세요.");
				break;
			}
		}
		scanner.close(); // 자원 누수를 방지하기 위해 스캐너 닫기
	}

	// 가계부 내역 기입, 수정, 삭제를 처리
	private static void handleRecordManagement(Scanner scanner, SaveRecords saveRecords, ModifyRecords modifyRecords,
			RecordDeleter recordDeleter) {
		boolean isSubmenuRunning = true;

		while (isSubmenuRunning) {
			System.out.println("\n=========================================================");
			System.out.println("1. 가계부 내역 작성    2. 가계부 내역 수정       3. 가계부 내역 삭제    4. 뒤로가기");
			System.out.print("원하시는 메뉴를 작성해주세요 => ");
			String firstMenu = scanner.nextLine();

			switch (firstMenu) {
			case "1":
				addRecord(scanner, saveRecords);
				break;
			case "2":
				modifyRecord(scanner, modifyRecords);
				break;
			case "3":
				deleteRecord(scanner, recordDeleter);
				break;
			case "4":
				isSubmenuRunning = false;
				break;
			default:
				System.out.println("잘못된 선택입니다.");
				break;
			}
		}
	}

	// 새 기록을 가계부에 추가
	private static void addRecord(Scanner scanner, SaveRecords saveRecords) {
		System.out.println("\n=========================================================");
		System.out.print("금액을 사용하신 날짜를 입력해주세요 (Ex: 2024-07-12) => ");
		String date = scanner.nextLine();

		System.out.println("1. 적금       / 2. 보험료     / 3. 정기결제 / 4. 식비 / 5. 교통비 ");
		System.out.println("6. 문화생활비  / 7. 병원비     / 8. 쇼핑     / 9. 기타");
		System.out.print("기입하시려는 정보의 종류 번호를 선택해주세요 => ");
		String recordType = scanner.nextLine();

		System.out.print("금액을 작성해주세요 => ");
		String amountStr = scanner.nextLine();
		int amount = Integer.parseInt(amountStr);

		saveRecords.saveRecord(recordType, date, amount);
	}

	// 기존 기록을 수정
	private static void modifyRecord(Scanner scanner, ModifyRecords modifyRecords) {
		System.out.println("\n=========================================================");

		System.out.print("수정하실 날짜를 입력해주세요 (Ex: 2024-07-12) => ");
		String date = scanner.nextLine();

		System.out.println("1. 적금       / 2. 보험료     / 3. 정기결제 / 4. 식비 / 5. 교통비 ");
		System.out.println("6. 문화생활비  / 7. 병원비     / 8. 쇼핑     / 9. 기타");
		System.out.print("수정하시려는 종류 번호를 선택해주세요 => ");
		String recordType = scanner.nextLine();

		System.out.print("수정하실 액수를 입력해주세요 => ");
		String amountStr = scanner.nextLine();
		int amount = Integer.parseInt(amountStr);

		modifyRecords.modifyCsv(recordType, date, amount);
	}

	// 기존 기록을 삭제
	private static void deleteRecord(Scanner scanner, RecordDeleter recordDeleter) {
		System.out.println("\n=========================================================");

		System.out.print("삭제하실 날짜를 입력해주세요 (Ex: 2024-07-12) => ");
		String date = scanner.nextLine();

		System.out.println("1. 적금       / 2. 보험료     / 3. 정기결제 / 4. 식비 / 5. 교통비 ");
		System.out.println("6. 문화생활비  / 7. 병원비     / 8. 쇼핑     / 9. 기타");
		System.out.print("삭제하시려는 종류 번호를 선택해주세요 => ");
		String recordType = scanner.nextLine();

		recordDeleter.deleteRecord(recordType, date);
	}

	// 메모 관리 옵션을 처리 : 전체 출력, 메모 작성, 수정, 삭제.
	private static void handleMemoManagement(Scanner scanner, LoadMemo loadMemo, SaveMemo saveMemo, FindMemo findMemo) {
		boolean isSubmenuRunning = true;

		while (isSubmenuRunning) {
			System.out.println("\n=========================================================");
			System.out.println(
					"1. 전체 출력        2. 메모작성        3. 수정        4. 삭제        5. 조회 날짜 입력 하면 해당 날짜 메모 불러오기    6. 뒤로가기");
			System.out.print("원하시는 종류 번호를 선택해주세요 => ");
			String memoOption = scanner.nextLine();

			switch (memoOption) {
			case "1":
				loadMemo.getAll();
				break;
			case "2":
				saveMemo.setMemo();
				break;
			case "3":
				findMemo.editMemo();
				break;
			case "4":
				findMemo.deleteMemo();
				break;
			case "5":
				loadMemo.getFind();
				break;
			case "6":
				isSubmenuRunning = false;
				break;
			default:
				System.out.println("잘못된 선택입니다.");
				break;
			}
		}
	}

	// 예산 관리 옵션을 처리 : 입력, 읽기, 추가, 재설정.
	private static void handleBudgetManagement(Scanner scanner, DailyBudget dailyBudget) {
		boolean isSubmenuRunning = true;

		while (isSubmenuRunning) {
			System.out.println("\n=========================================================");
			System.out.println("1. 예산 입력    2. 예산 읽기    3. 예산 추가    4. 예산 재설정    5. 뒤로가기");
			System.out.print("원하시는 메뉴의 번호를 선택해주세요 => ");
			String budgetOption = scanner.nextLine();

			switch (budgetOption) {
			case "1":
				dailyBudget.inputBudget();
				break;
			case "2":
				dailyBudget.readBudget();
				break;
			case "3":
				dailyBudget.addBudget();
				break;
			case "4":
				dailyBudget.resetBudget();
				break;
			case "5":
				isSubmenuRunning = false;
				break;
			default:
				System.out.println("잘못된 선택입니다.");
				break;
			}
		}
	}

	// 검색 옵션을 처리 : 수입/지출 조회, 예산 비율 보기, 월별 최대/최소 금액 보기.
	private static void handleSearch(Scanner scanner, GetRecordsByType getRecordsByType, PercentUI percentUI,
			MaxMinMonth maxMinMonth, DailyBudget dailyBudget) {
		boolean isSubmenuRunning = true;

		while (isSubmenuRunning) {
			System.out.println("\n=========================================================");
			System.out.println("1. 수입/지출 조회     2. 지출 비율 보기     3. 최다 & 최소 지출월 보기    4. 일일사용가능 금액 	5. 뒤로가기");
			System.out.print("원하시는 메뉴의 번호를 선택해주세요 => ");
			String searchOption = scanner.nextLine();

			switch (searchOption) {
			case "1":
				handleIncomeExpenseSearch(scanner, getRecordsByType);
				break;
			case "2":
				System.out.print("확인하고 싶은 달(월)의 숫자를 입력해주세요 (Ex : 02, 11) => ");
				String searchMonth = scanner.nextLine();
				percentUI.showUI(searchMonth);
				break;
			case "3":
				maxMinMonth.getMaxMonth();
				maxMinMonth.getMinMonth();
				break;
			case "4":
				dailyBudget.setBudget();
				break;
			case "5":
				isSubmenuRunning = false;
				break;
			default:
				System.out.println("잘못된 선택입니다.");
				break;
			}
		}
	}

	private static void handleIncomeExpenseSearch(Scanner scanner, GetRecordsByType getRecordsByType) {
		boolean isSubmenuRunning = true;

		while (isSubmenuRunning) {
			System.out.println("\n=========================================================");
			System.out.println("1. 월별 지출 \t 2. 연간 지출    3. 뒤로가기");
			System.out.print("확인하시고 싶은 기간을 선택해주세요 => ");
			String searchPeriod = scanner.nextLine();

			switch (searchPeriod) {
			case "1":
				handleMonthlyExpenseSearch(scanner, getRecordsByType);
				break;
			case "2":
				handleAnnualExpenseSearch(scanner, getRecordsByType);
				break;
			case "3":
				isSubmenuRunning = false;
				break;
			default:
				System.out.println("잘못된 선택입니다.");
				break;
			}
		}
	}

	private static void handleMonthlyExpenseSearch(Scanner scanner, GetRecordsByType getRecordsByType) {
		System.out.println("\n=========================================================");
		System.out.println("1. 적금       / 2. 보험료     / 3. 정기결제 / 4. 식비 / 5. 교통비 ");
		System.out.println("6. 문화생활비  / 7. 병원비     / 8. 쇼핑     / 9. 기타");
		System.out.print("확인하시고싶은 지출 타입을 선택해주세요. => ");
		String searchExpenseType = scanner.nextLine();

		System.out.println("\n=========================================================");
		System.out.print("확인하고 싶은 달(월)의 숫자를 입력해주세요 (Ex : 02, 11) => ");
		String findMonth = scanner.nextLine();

		getRecordsByType.searchDataTypewithMonth(searchExpenseType, findMonth);
	}

	private static void handleAnnualExpenseSearch(Scanner scanner, GetRecordsByType getRecordsByType) {
		System.out.println("\n=========================================================");
		System.out.println("1. 적금       / 2. 보험료     / 3. 정기결제 / 4. 식비 / 5. 교통비 ");
		System.out.println("6. 문화생활비  / 7. 병원비     / 8. 쇼핑     / 9. 기타");
		System.out.print("확인하시고싶은 지출 타입을 선택해주세요. => ");
		String searchExpenseType = scanner.nextLine();

		getRecordsByType.searchDataType(searchExpenseType);
	}
}
