package budgetmanager;

import java.util.List;

import filehandler.LoadRecords;

// 지출 관련 데이터를 관리
public class Expense {
	// 각 지출 항목별 필드 선언
	public int foodExpense;
	public int transportExpense;
	public int cultureExpense;
	public int hospitalExpense;
	public int shoppingExpesen;
	public int etcExpense;

	// LoadRecords 객체를 통해 데이터를 로드
	LoadRecords loadRecords = new LoadRecords();

	// 1년간 저금한 총 금액을 계산
	public int getYearSavingExpense() {
		List<List<String>> csvList = loadRecords.getSaving();
		int yearSavingExpense = 0;

		// CSV 파일 데이터를 읽어와 총 저축 금액을 계산
		for (int i = 0; i < csvList.size(); i++) {
			String expenseString = csvList.get(i).get(2);	//CSV의 [2]가 금액을 나타냄
			int expense = Integer.parseInt(expenseString);
			yearSavingExpense += expense;
		}

		return yearSavingExpense;
	}

	// 1년간 보험료 총 금액을 계산
	public int getYearInsuranceExpense() {
		List<List<String>> csvList = loadRecords.getInsurance();
		int yearInsuranceExpense = 0;

		// CSV 파일 데이터를 읽어와 총 보험료를 계산
		for (int i = 0; i < csvList.size(); i++) {
			String expenseString = csvList.get(i).get(2);
			int expense = Integer.parseInt(expenseString);
			yearInsuranceExpense += expense;
		}

		return yearInsuranceExpense;
	}

	// 1년간 OTT 서비스 사용료 총 금액을 계산
	public int getYearOttExpense() {
		List<List<String>> csvList = loadRecords.getOtt();
		int yearOttExpense = 0;

		// CSV 파일 데이터를 읽어와 총 OTT 서비스 사용료를 계산
		for (int i = 0; i < csvList.size(); i++) {
			String expenseString = csvList.get(i).get(2);
			int expense = Integer.parseInt(expenseString);
			yearOttExpense += expense;
		}

		return yearOttExpense;
	}

	// 1년간 식비 총 금액을 계산
	public int getYearFoodExpense() {
		List<List<String>> csvList = loadRecords.getFood();
		int yearFoodExpense = 0;

		// CSV 파일 데이터를 읽어와 총 식비를 계산
		for (int i = 0; i < csvList.size(); i++) {
			String expenseString = csvList.get(i).get(2);
			int expense = Integer.parseInt(expenseString);
			yearFoodExpense += expense;
		}

		return yearFoodExpense;
	}

	// 1년간 교통비 총 금액을 계산
	public int getYearTransportExpense() {
		List<List<String>> csvList = loadRecords.getTransport();
		int yearTransportExpense = 0;

		// CSV 파일 데이터를 읽어와 총 교통비를 계산
		for (int i = 0; i < csvList.size(); i++) {
			String expenseString = csvList.get(i).get(2);
			int expense = Integer.parseInt(expenseString);
			yearTransportExpense += expense;
		}

		return yearTransportExpense;
	}

	// 1년간 문화생활비 총 금액을 계산
	public int getYearCultureExpense() {
		List<List<String>> csvList = loadRecords.getCulture();
		int yearCultureExpense = 0;

		// CSV 파일 데이터를 읽어와 총 문화생활비를 계산
		for (int i = 0; i < csvList.size(); i++) {
			String expenseString = csvList.get(i).get(2);
			int expense = Integer.parseInt(expenseString);
			yearCultureExpense += expense;
		}

		return yearCultureExpense;
	}

	// 1년간 병원비 총 금액을 계산
	public int getYearHospitalExpense() {
		List<List<String>> csvList = loadRecords.getHospital();
		int yearHospitalExpense = 0;

		// CSV 파일 데이터를 읽어와 총 병원비를 계산
		for (int i = 0; i < csvList.size(); i++) {
			String expenseString = csvList.get(i).get(2);
			int expense = Integer.parseInt(expenseString);
			yearHospitalExpense += expense;
		}

		return yearHospitalExpense;
	}

	// 1년간 쇼핑 총 금액을 계산
	public int getYearShoppingExpense() {
		List<List<String>> csvList = loadRecords.getShopping();
		int yearShoppingExpense = 0;

		// CSV 파일 데이터를 읽어와 총 쇼핑 비용을 계산합니다.
		for (int i = 0; i < csvList.size(); i++) {
			String expenseString = csvList.get(i).get(2);
			int expense = Integer.parseInt(expenseString);
			yearShoppingExpense += expense;
		}

		return yearShoppingExpense;
	}

	// 1년간 기타 지출 총 금액을 계산
	public int getYearEtcExpense() {
		List<List<String>> csvList = loadRecords.getEtc();
		int yearEtcExpense = 0;

		// CSV 파일 데이터를 읽어와 총 기타 지출 금액을 계산합니다.
		for (int i = 0; i < csvList.size(); i++) {
			String expenseString = csvList.get(i).get(2);
			int expense = Integer.parseInt(expenseString);
			yearEtcExpense += expense;
		}

		return yearEtcExpense;
	}

	// 1년간 총 지출 금액을 계산
	public int yearTotalExpense() {
		int sum = getYearSavingExpense() + getYearInsuranceExpense() + getYearOttExpense() + getYearFoodExpense()
				+ getYearTransportExpense() + getYearCultureExpense() + getYearHospitalExpense()
				+ getYearShoppingExpense() + getYearEtcExpense();

		return sum;
	}

	// 입력받은 월의 저축 총 금액을 계산
	public int getMonthSavingExpense(String month) {
		List<List<String>> csvList = loadRecords.getSaving();
		int monthSavingExpense = 0;

		// CSV 파일 데이터를 읽어와 입력받은 월의 총 저축 금액을 계산
		for (int i = 0; i < csvList.size(); i++) {
			String date = csvList.get(i).get(1);
			String[] dateParts = date.split("-");
			String expenseMonth = dateParts[1];

			if (month.equals(expenseMonth)) {
				String expenseString = csvList.get(i).get(2);
				int expense = Integer.parseInt(expenseString);
				monthSavingExpense += expense;
			}
		}

		return monthSavingExpense;
	}

	// 입력받은 월의 보험료 총 금액을 계산
	public int getMonthInsuranceExpense(String month) {
		List<List<String>> csvList = loadRecords.getInsurance();
		int monthInsuranceExpense = 0;

		// CSV 파일 데이터를 읽어와 입력받은 월의 총 보험료를 계산
		for (int i = 0; i < csvList.size(); i++) {
			String date = csvList.get(i).get(1);
			String[] dateParts = date.split("-");
			String expenseMonth = dateParts[1];

			if (month.equals(expenseMonth)) {
				String expenseString = csvList.get(i).get(2);
				int expense = Integer.parseInt(expenseString);
				monthInsuranceExpense += expense;
			}
		}

		return monthInsuranceExpense;
	}

	// 입력받은 월의 OTT 서비스 사용료 총 금액을 계산
	public int getMonthOttExpense(String month) {
		List<List<String>> csvList = loadRecords.getOtt();
		int monthOttExpense = 0;

		// CSV 파일 데이터를 읽어와 입력받은 월의 총 OTT 서비스 사용료를 계산
		for (int i = 0; i < csvList.size(); i++) {
			String date = csvList.get(i).get(1);
			String[] dateParts = date.split("-");
			String expenseMonth = dateParts[1];

			if (month.equals(expenseMonth)) {
				String expenseString = csvList.get(i).get(2);
				int expense = Integer.parseInt(expenseString);
				monthOttExpense += expense;
			}
		}

		return monthOttExpense;
	}

	// 입력받은 월의 식비 총 금액을 계산
	public int getMonthFoodExpense(String month) {
		List<List<String>> csvList = loadRecords.getFood();
		int monthFoodExpense = 0;

		// CSV 파일 데이터를 읽어와 입력받은 월의 총 식비를 계산합니다.
		for (int i = 0; i < csvList.size(); i++) {
			String date = csvList.get(i).get(1);
			String[] dateParts = date.split("-");
			String expenseMonth = dateParts[1];

			if (month.equals(expenseMonth)) {
				String expenseString = csvList.get(i).get(2);
				int expense = Integer.parseInt(expenseString);
				monthFoodExpense += expense;
			}
		}

		return monthFoodExpense;
	}

	// 입력받은 월의 교통비 총 금액을 계산
	public int getMonthTransportExpense(String month) {
		List<List<String>> csvList = loadRecords.getTransport();
		int monthTransportExpense = 0;

		// CSV 파일 데이터를 읽어와 입력받은 월의 총 교통비를 계산
		for (int i = 0; i < csvList.size(); i++) {
			String date = csvList.get(i).get(1);
			String[] dateParts = date.split("-");
			String expenseMonth = dateParts[1];

			if (month.equals(expenseMonth)) {
				String expenseString = csvList.get(i).get(2);
				int expense = Integer.parseInt(expenseString);
				monthTransportExpense += expense;
			}
		}

		return monthTransportExpense;
	}

	// 입력받은 월의 문화생활비 총 금액을 계산
	public int getMonthCultureExpense(String month) {
		List<List<String>> csvList = loadRecords.getCulture();
		int monthCultureExpense = 0;

		// CSV 파일 데이터를 읽어와 입력받은 월의 총 문화생활비를 계산
		for (int i = 0; i < csvList.size(); i++) {
			String date = csvList.get(i).get(1);
			String[] dateParts = date.split("-");
			String expenseMonth = dateParts[1];

			if (month.equals(expenseMonth)) {
				String expenseString = csvList.get(i).get(2);
				int expense = Integer.parseInt(expenseString);
				monthCultureExpense += expense;
			}
		}

		return monthCultureExpense;
	}

	// 입력받은 월의 병원비 총 금액을 계산
	public int getMonthHospitalExpense(String month) {
		List<List<String>> csvList = loadRecords.getHospital();
		int monthHospitalExpense = 0;

		// CSV 파일 데이터를 읽어와 입력받은 월의 총 병원비를 계산
		for (int i = 0; i < csvList.size(); i++) {
			String date = csvList.get(i).get(1);
			String[] dateParts = date.split("-");
			String expenseMonth = dateParts[1];

			if (month.equals(expenseMonth)) {
				String expenseString = csvList.get(i).get(2);
				int expense = Integer.parseInt(expenseString);
				monthHospitalExpense += expense;
			}
		}

		return monthHospitalExpense;
	}

	// 입력받은 월의 쇼핑 총 금액을 계산
	public int getMonthShoppingExpense(String month) {
		List<List<String>> csvList = loadRecords.getShopping();
		int monthShoppingExpense = 0;

		// CSV 파일 데이터를 읽어와 입력받은 월의 총 쇼핑 금액을 계산
		for (int i = 0; i < csvList.size(); i++) {
			String date = csvList.get(i).get(1);
			String[] dateParts = date.split("-");
			String expenseMonth = dateParts[1];

			if (month.equals(expenseMonth)) {
				String expenseString = csvList.get(i).get(2);
				int expense = Integer.parseInt(expenseString);
				monthShoppingExpense += expense;
			}
		}

		return monthShoppingExpense;
	}

	// 입력받은 월의 기타 지출 총 금액을 계산
	public int getMonthEtcExpense(String month) {
		List<List<String>> csvList = loadRecords.getEtc();
		int monthEtcExpense = 0;

		// CSV 파일 데이터를 읽어와 입력받은 월의 총 기타 지출 금액을 계산
		for (int i = 0; i < csvList.size(); i++) {
			String date = csvList.get(i).get(1);
			String[] dateParts = date.split("-");
			String expenseMonth = dateParts[1];

			if (month.equals(expenseMonth)) {
				String expenseString = csvList.get(i).get(2);
				int expense = Integer.parseInt(expenseString);
				monthEtcExpense += expense;
			}
		}

		return monthEtcExpense;
	}

	// 입력받은 월의 총 지출 금액을 계산
	public int MonthTotalExpense(String month) {
		int sum = getMonthSavingExpense(month) + getMonthInsuranceExpense(month) + getMonthOttExpense(month)
				+ getMonthFoodExpense(month) + getMonthTransportExpense(month) + getMonthCultureExpense(month)
				+ getMonthHospitalExpense(month) + getMonthShoppingExpense(month) + getMonthEtcExpense(month);

		return sum;
	}
}
