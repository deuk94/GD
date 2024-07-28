package budgetmanager;

// 5번 기능 구현 클래스입니다.
public class PercentUI {

	// Expense 클래스의 인스턴스를 생성
	private Expense expense = new Expense();

	// 입력받은 달의 각 소비 데이터 타입별 비율을 그래프로 나타냄
	public void showUI(String month) {
		// 해당 월의 총 지출 금액을 가져옴
		int totalExpense = expense.MonthTotalExpense(month);

		// 해당 월의 각 항목별 지출 금액을 가져옴
		int savingExpense = expense.getMonthSavingExpense(month);
		int insuranceExpense = expense.getMonthInsuranceExpense(month);
		int ottExpense = expense.getMonthOttExpense(month);
		int foodExpense = expense.getMonthFoodExpense(month);
		int transportExpense = expense.getMonthTransportExpense(month);
		int cultureExpense = expense.getMonthCultureExpense(month);
		int hospitalExpense = expense.getMonthHospitalExpense(month);
		int shoppingExpense = expense.getMonthShoppingExpense(month);
		int etcExpense = expense.getMonthEtcExpense(month);

		// 각 항목별 지출 비율을 계산
		double savingPercentage = Math.round((double) savingExpense / totalExpense * 100);
		double insurancePercentage = Math.round((double) insuranceExpense / totalExpense * 100);
		double ottPercentage = Math.round((double) ottExpense / totalExpense * 100);
		double foodPercentage = Math.round((double) foodExpense / totalExpense * 100);
		double transportPercentage = Math.round((double) transportExpense / totalExpense * 100);
		double culturePercentage = Math.round((double) cultureExpense / totalExpense * 100);
		double hospitalPercentage = Math.round((double) hospitalExpense / totalExpense * 100);
		double shoppingPercentage = Math.round((double) shoppingExpense / totalExpense * 100);
		double etcPercentage = Math.round((double) etcExpense / totalExpense * 100);

		// 비율을 저장하기 위한 임시 변수
		int temp;

		// 각 항목별 비율을 그래프로 출력
		System.out.print("저축 비율 \t: \t\t");
		temp = (int) savingPercentage;
		printGraph(savingPercentage);
		System.out.printf("\t%d%%\n", temp);

		System.out.print("보험 비율 \t: \t\t");
		temp = (int) insurancePercentage;
		printGraph(insurancePercentage);
		System.out.printf("\t%d%%\n", temp);

		System.out.print("정기결제 비율 : \t\t");
		temp = (int) ottPercentage;
		printGraph(ottPercentage);
		System.out.printf("\t%d%%\n", temp);

		System.out.print("식비 비율 \t: \t\t");
		temp = (int) foodPercentage;
		printGraph(foodPercentage);
		System.out.printf("\t%d%%\n", temp);

		System.out.print("교통 비율 \t: \t\t");
		temp = (int) transportPercentage;
		printGraph(transportPercentage);
		System.out.printf("\t%d%%\n", temp);

		System.out.print("문화생활 비율 : \t\t");
		temp = (int) culturePercentage;
		printGraph(culturePercentage);
		System.out.printf("\t%d%%\n", temp);

		System.out.print("병원 비율 \t: \t\t");
		temp = (int) hospitalPercentage;
		printGraph(hospitalPercentage);
		System.out.printf("\t%d%%\n", temp);

		System.out.print("쇼핑 비율 \t: \t\t");
		temp = (int) shoppingPercentage;
		printGraph(shoppingPercentage);
		System.out.printf("\t%d%%\n", temp);

		System.out.print("기타 비율 \t: \t\t");
		temp = (int) etcPercentage;
		printGraph(etcPercentage);
		System.out.printf("\t%d%%\n", temp);
	}

	// 그래프를 출력하는 메서드
	private void printGraph(double percentage) {
		// 10 퍼센트 단위로 ■ 출력하기
		for (int i = 0; i < 10; i++) {
			if (percentage >= 10) {
				System.out.print("■ ");
				percentage -= 10;
			} else {
				// 1 퍼센트 이상일 경우 ■ 출력하기
				if (percentage > 0) {
					System.out.print("■ ");
					percentage = 0;
				} else {
					// 나머지 부분은 □ 출력하기
					System.out.print("□ ");
				}
			}
		}
	}
}
