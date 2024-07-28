package filehandler;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class SaveRecords {

	private String categorys;
	File file = new File("C:\\AccountBook\\budget.csv");

	// 입력받는 형태 category, date, money
	// 카테고리, 날짜, 금액을 받아 레코드를 저장하는 메서드
	public void saveRecord(String category, String date, int money) {

		// 카테고리 번호에 따라 카테고리 문자열을 설정
		switch (category) {
		case "1":
			this.categorys = "saving";
			break;
		case "2":
			this.categorys = "insurance";
			break;
		case "3":
			this.categorys = "ott";
			break;
		case "4":
			this.categorys = "food";
			break;
		case "5":
			this.categorys = "transport";
			break;
		case "6":
			this.categorys = "culture";
			break;
		case "7":
			this.categorys = "hospital";
			break;
		case "8":
			this.categorys = "shopping";
			break;
		case "9":
			this.categorys = "etc";
			break;
		default:
			System.out.println("카테고리가 다릅니다");
			return;
		}

		// 날짜 형식 및 범위 검증
		DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		try {
			LocalDate parsedDate = LocalDate.parse(date, dateFormatter);
		} catch (DateTimeParseException e) {
			System.out.println("올바르지 않은 날짜 입력 형태이거나 범위를 벗어났습니다 : " + date);
			return;
		}

		// 파일이 존재하지 않을 경우 파일을 생성
		try {
			if (!file.exists()) {
				file.createNewFile();
			}

			// 파일에 추가 모드로 FileWriter와 BufferedWriter를 사용하여 데이터 작성
			FileWriter fw = new FileWriter(file, true);
			BufferedWriter writer = new BufferedWriter(fw);

			// 입력받은 데이터를 카테고리, 날짜, 금액 순으로 파일에 작성
			writer.write(categorys + "," + date + "," + money);
			writer.newLine(); // 줄바꿈

			// 버퍼를 비우고 닫음
			writer.flush();
			writer.close();

		} catch (IOException e) {
			e.printStackTrace(); // 입출력 예외 발생 시 스택 추적을 출력
		}
	}
}
