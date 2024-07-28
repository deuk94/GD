package budgetmanager;

// 특정 소비 데이터 타입별로 월별 및 연간 지출을 검색
public class GetRecordsByType {

	// 지출 관련 데이터를 처리하는 객체입니다.
	Expense expense = new Expense();

	private String types;

	// 소비 데이터 타입별로 해당 월에 얼마를 썼는지 알려줌
	public void searchDataTypewithMonth(String type, String month) {

		// 입력받은 타입 번호에 따라 타입 문자열을 설정
		if (type.equals("1"))
			this.types = "saving";
		else if (type.equals("2"))
			this.types = "insurance";
		else if (type.equals("3"))
			this.types = "ott";
		else if (type.equals("4"))
			this.types = "food";
		else if (type.equals("5"))
			this.types = "transport";
		else if (type.equals("6"))
			this.types = "culture";
		else if (type.equals("7"))
			this.types = "hospital";
		else if (type.equals("8"))
			this.types = "shopping";
		else if (type.equals("9"))
			this.types = "etc";

		// 입력받은 타입별로 월별 지출 금액을 출력
		switch (types) {
		case "saving":
			int savingMonthExpense = expense.getMonthSavingExpense(month);
			System.out.printf("%s월에 저금한 총 금액은 %d원 입니다.\n", month, savingMonthExpense);
			break;
		case "insurance":
			int insuranceExpense = expense.getMonthInsuranceExpense(month);
			System.out.printf("%s월에 사용한 보험금은 총 %d원 입니다.\n", month, insuranceExpense);
			break;
		case "ott":
			int ottExpense = expense.getMonthOttExpense(month);
			System.out.printf("%s월에 사용한 정기결제비용은 총 %d원 입니다.\n", month, ottExpense);
			break;
		case "food":
			int foodExpense = expense.getMonthFoodExpense(month);
			System.out.printf("%s월에 사용한 식비는 총 %d원 입니다.\n", month, foodExpense);
			break;
		case "transport":
			int transportExpense = expense.getMonthTransportExpense(month);
			System.out.printf("%s월에 사용한 교통비는 총 %d원 입니다.\n", month, transportExpense);
			break;
		case "culture":
			int cultureExpense = expense.getMonthCultureExpense(month);
			System.out.printf("%s월에 사용한 문화생활비는 총 %d원 입니다.\n", month, cultureExpense);
			break;
		case "hospital":
			int hospitalExpense = expense.getMonthHospitalExpense(month);
			System.out.printf("%s월에 사용한 병원비는 총 %d원 입니다.\n", month, hospitalExpense);
			break;
		case "shopping":
			int shoppingExpense = expense.getMonthShoppingExpense(month);
			System.out.printf("%s월에 사용한 쇼핑 총 %d원 입니다.\n", month, shoppingExpense);
			break;
		case "etc":
			int etcExpense = expense.getMonthEtcExpense(month);
			System.out.printf("%s월에 사용한 기타 총액은 %d원 입니다.\n", month, etcExpense);
			break;
		}
	}

	// 소비 데이터 타입별로 1년간 얼마를 썼는지 알려줌
	public void searchDataType(String type) {

		// 입력받은 타입 번호에 따라 타입 문자열을 설정
		if (type.equals("1"))
			this.types = "saving";
		else if (type.equals("2"))
			this.types = "insurance";
		else if (type.equals("3"))
			this.types = "ott";
		else if (type.equals("4"))
			this.types = "food";
		else if (type.equals("5"))
			this.types = "transport";
		else if (type.equals("6"))
			this.types = "culture";
		else if (type.equals("7"))
			this.types = "hospital";
		else if (type.equals("8"))
			this.types = "shopping";
		else if (type.equals("9"))
			this.types = "etc";

		// 입력받은 타입별로 연간 지출 금액을 출력
		switch (types) {
		case "saving":
			int savingYearExpense = expense.getYearSavingExpense();
			System.out.printf("1년동안 저금은 총 %d원 입니다.\n", savingYearExpense);
			break;
		case "insurance":
			int insuranceYearExpense = expense.getYearInsuranceExpense();
			System.out.printf("1년동안 보험금은 총 %d원 입니다.\n", insuranceYearExpense);
			break;
		case "ott":
			int ottYearExpense = expense.getYearOttExpense();
			System.out.printf("1년동안 정기결제비용은 총 %d원 입니다.\n", ottYearExpense);
			break;
		case "food":
			int foodYearExpense = expense.getYearFoodExpense();
			System.out.printf("1년동안 식비는 총 %d원 입니다.\n", foodYearExpense);
			break;
		case "transport":
			int transportYearExpense = expense.getYearTransportExpense();
			System.out.printf("1년동안 교통비는 총 %d원 입니다.\n", transportYearExpense);
			break;
		case "culture":
			int cultureYearExpense = expense.getYearCultureExpense();
			System.out.printf("1년동안 문화생활비는 총 %d원 입니다.\n", cultureYearExpense);
			break;
		case "hospital":
			int hospitalYearExpense = expense.getYearHospitalExpense();
			System.out.printf("1년동안 병원비는 총 %d원 입니다.\n", hospitalYearExpense);
			break;
		case "shopping":
			int shoppingYearExpense = expense.getYearShoppingExpense();
			System.out.printf("1년동안 쇼핑 총 %d원 입니다.\n", shoppingYearExpense);
			break;
		case "etc":
			int etcYearExpense = expense.getYearEtcExpense();
			System.out.printf("1년동안 기타 총액은 %d원 입니다.\n", etcYearExpense);
			break;
		}
	}
}
