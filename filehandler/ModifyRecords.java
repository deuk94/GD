package filehandler;

import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.*;

public class ModifyRecords {
	// CSV 파일 경로를 지정
	File file = new File("C:\\AccountBook\\budget.csv");
	private String categorys;

	// CSV 파일의 특정 레코드를 수정
	public void modifyCsv(String category, String date, int newMoney) {
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
			System.out.println("Invalid category");
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

		// 파일 내용을 저장할 리스트를 초기화
		List<String> fileContent = new ArrayList<>();
		boolean recordFound = false; // 레코드를 찾았는지 여부를 나타내는 플래그

		// 파일을 읽어들입니다.
		try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
			String line;
			while ((line = reader.readLine()) != null) {
				String[] parts = line.split(",");
				// 카테고리와 날짜가 일치하는 레코드를 찾기
				if (parts[0].equals(categorys) && parts[1].equals(date)) {
					parts[2] = String.valueOf(newMoney); // 금액을 수정
					line = String.join(",", parts);
					recordFound = true; // 레코드를 찾았음을 표시
				}
				fileContent.add(line); // 파일 내용을 리스트에 추가
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		// 레코드를 찾은 경우 파일을 다시 작성
		if (recordFound) {
			try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
				for (String line : fileContent) {
					writer.write(line);
					writer.newLine();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else {
			System.out.println("해당 항목을 발견하지 못했습니다."); // 레코드를 찾지 못한 경우 메시지를 출력
		}
	}
}
