package filehandler;

import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.*;

public class RecordDeleter {
	// CSV 파일 경로를 지정
	File file = new File("C:\\AccountBook\\budget.csv");
	private String categorys;

	// CSV 파일의 특정 레코드를 삭제
	public void deleteRecord(String category, String date) {
		// 카테고리 번호에 따라 카테고리 문자열을 설정
		if (category.equals("1"))
			this.categorys = "saving";
		else if (category.equals("2"))
			this.categorys = "insurance";
		else if (category.equals("3"))
			this.categorys = "ott";
		else if (category.equals("4"))
			this.categorys = "food";
		else if (category.equals("5"))
			this.categorys = "transport";
		else if (category.equals("6"))
			this.categorys = "culture";
		else if (category.equals("7"))
			this.categorys = "hospital";
		else if (category.equals("8"))
			this.categorys = "shopping";
		else if (category.equals("9"))
			this.categorys = "etc";

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

		// 파일 읽기
		try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
			String line;
			while ((line = reader.readLine()) != null) {
				String[] parts = line.split(",");
				// 카테고리와 날짜가 일치하지 않는 레코드만 리스트에 추가
				if (!(parts[0].equals(categorys) && parts[1].equals(date))) {
					fileContent.add(line);
				} else {
					recordFound = true; // 레코드를 찾았음을 표시
				}
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
		}
	}
}
