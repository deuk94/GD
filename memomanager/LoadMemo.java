package memomanager;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

// 파일로부터 불러온 데이터를 저장합니다.
// 구현 -> getSaving / getInsurance / getOtt .....
// 메모 전체 출력(날짜순으로 정령 기능은 없음) ,  특정 날짜 메모 출력 기능
public class LoadMemo {
	File file = new File("C:\\AccountBook\\memo.csv");

	public List<List<String>> getList() {
		List<List<String>> csvList = new ArrayList<List<String>>();
		BufferedReader br = null;
		String line = "";

		try {
			br = new BufferedReader(new FileReader(file));
			while ((line = br.readLine()) != null) {
				List<String> aLine = new ArrayList<String>();
				String[] lineArr = line.split("/");
				aLine = Arrays.asList(lineArr);
				csvList.add(aLine);
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

		return csvList;
	}

	// 전체출력
	public void getAll() {
		List<List<String>> csvList = getList();
		// 날짜 기준 정렬 (오름차순)
		csvList.sort((a, b) -> {
			try {
				// 날짜 문자열을 LocalDate 객체로 변환 LocalDate 사용을 위해 MM-dd 에서 yyyy-MM-dd로 변경
				LocalDate date1 = LocalDate.parse(a.get(0), DateTimeFormatter.ofPattern("yyyy-MM-dd"));
				LocalDate date2 = LocalDate.parse(b.get(0), DateTimeFormatter.ofPattern("yyyy-MM-dd"));
				return date1.compareTo(date2); // 오름차순 정렬
			} catch (Exception e) {
				System.out.println("[오류] 날짜 형식 오류: " + e.getMessage());
				return 0; // 오류 발생 시 0으로 처리하여 정렬 결과에 영향을 미치지 않도록 함
			}
		});
		System.out.println("\n[전체 출력]");
		for (int i = 0; i < csvList.size(); i++) {
			System.out.println("\n");
			System.out.println("| 날짜: " + csvList.get(i).get(0) + "| 내용: " + csvList.get(i).get(1));
		}
	}

	// findMemo 클래스로
	public void getFind() {

		Scanner sc = new Scanner(System.in);
		System.out.println("\n5.조회 날짜 입력 하면 해당 날짜 메모 블러오기");
		System.out.print("날짜를 입력 (Ex: 2024-01-01) => ");
		String strDay = sc.nextLine();

		List<List<String>> csvList = getList();

		for (int i = 0; i < csvList.size(); i++) {
			if (csvList.get(i).get(0).equals(strDay)) {
				System.out.println("| 날짜: " + csvList.get(i).get(0) + "| 내용: " + csvList.get(i).get(1));
			}
		}

	}

}
