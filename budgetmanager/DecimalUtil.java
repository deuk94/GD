package budgetmanager;

import java.text.DecimalFormat;

public class DecimalUtil {

// 3자리 마다 콤마(,)를 찍는 메서드 
	public static String decimalComma(int input) {
		DecimalFormat df = new DecimalFormat("#,##0");
		String result = df.format(input);
		return result;
	}
}