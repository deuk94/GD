package budgetmanager;

public class MaxMinMonth {
    Expense ex = new Expense();

    // 가장 많이 소비한 달
    public void getMaxMonth() {
        int maxExpense = Integer.MIN_VALUE;
        String maxMonth = "";
        String[] months = { "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12" };

        for (String month : months) {
            int monthExpense = ex.MonthTotalExpense(month);
            if (monthExpense > maxExpense) {
                maxExpense = monthExpense;
                maxMonth = month;
            }
        }
        System.out.println("가장 많이 지출한 달: " + maxMonth + "월" + " (총 지출: " + DecimalUtil.decimalComma(maxExpense) + "원)");
    }

    // 가장 적게 소비하는 달
    public void getMinMonth() {
        int minExpense = Integer.MAX_VALUE;
        String minMonth = "";
        String[] months = { "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12" };

        for (String month : months) {
            int monthExpense = ex.MonthTotalExpense(month);
            if (monthExpense < minExpense) {
                minExpense = monthExpense;
                minMonth = month;
            }
        }

        System.out.println("가장 적게 지출한 달: " + minMonth + "월" + " (총 지출: " + DecimalUtil.decimalComma(minExpense) + "원)");
    }
}