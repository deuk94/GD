package memomanager;

import java.io.*;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

//데이터를 파일에 저장하기
//구현 -> setSaving / setInsurance / setOtt .....
//저장하는 형태 Ex) saving , 2024-07-26 , 300000
//날짜는 YYYY-MM-dd 형태로 해주세요.
//split 는 ',' 입니다.
public class SaveMemo {

	File file = new File("C:\\AccountBook\\memo.csv");
	// 쓰는거

	//
	public List<List<String>> getList() {
		List<List<String>> csvList = new ArrayList<List<String>>();
		BufferedReader br = null;
		String line = "";

		try {
			if (!file.exists()) {
				file.createNewFile();
			}
			br = new BufferedReader(new InputStreamReader(new FileInputStream(file), "UTF-8"));
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
	//

	public void saveRecord(String date, String memo) {

		// 파일이 존재하지 않을 경우 생성하기
		try {
			if (!file.exists()) {
				file.createNewFile();
			}

			FileWriter fw = new FileWriter(file, true);
			BufferedWriter writer = new BufferedWriter(fw);

			writer.write(date + "/" + memo);
			writer.newLine();

			writer.flush();
			writer.close();

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	// 저장
	public void setMemo() {
		//
		Scanner sc = new Scanner(System.in);
		System.out.print("날짜를 입력 (Ex: 2024-01-01) => ");
		String strDay = sc.nextLine();

		List<List<String>> csvList = getList();
		// 날짜 형식 검증
		if (!isValidDate(strDay)) {
			System.out.println("날짜 형식이 올바르지 않습니다. (YYYY-MM-dd 형식)");
			return;
		}
		boolean dayData = false; // 날짜에 메모가 있는지 여부
		for (int i = 0; i < csvList.size(); i++) {
			if (csvList.get(i).get(0).equals(strDay)) {
				dayData = true;
			}
		}
		if (dayData) {
			System.out.println("이미 해당 날짜에 메모가 존재합니다. 수정 기능을 이용 바랍니다");
			return;
		}

		System.out.print("작성 내용=> ");
		String strMemo = sc.nextLine();

		saveRecord(strDay, strMemo);
	}

	// 날짜 형식 검증 메서드
	private boolean isValidDate(String date) {
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			sdf.setLenient(false); // 날짜 형식이 엄격하게 검사되도록 설정
			sdf.parse(date);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
}
