package memomanager;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

//2번기능 구현 class 입니다.
//수정 삭제
public class FindMemo {
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

	// 수정기능
	public void editMemo() {
		/**
		 * 날자를 입력받아 해당 날짜의 메모를 csv파일에서수정 하는 코드
		 */
		Scanner sc = new Scanner(System.in);
		// 날짜 입력
		System.out.print("수정할 메모 날짜를 입력 (Ex: 2024-01-01) => ");
		String strDay = sc.nextLine();
		// System.out.print("원래 메모 내용을 확인 할려면 조회를 먼저 ");
		System.out.print("수정할 메모 내용을 입력하세요 => ");
		String newMemo = sc.nextLine();

		// CSV 파일 읽어오기
		List<List<String>> csvList = getList();

		// 일치하는 날짜 찾기 및 수정
		boolean found = false;
		for (int i = 0; i < csvList.size(); i++) {
			if (csvList.get(i).get(0).equals(strDay)) {
//				 oldMemo = csvList.get(i).get(i);
				csvList.get(i).set(1, newMemo); // 메모 내용 수정
				found = true;
				break;
			}
		}

		// 수정 결과 출력 및 CSV 파일 다시 쓰기
		if (found) {
			System.out.println("메모 수정 완료!");
			try {
				if (!file.exists()) {
					file.createNewFile();
				}

				FileWriter fw = new FileWriter(file, false); // "false" - 기존 내용 지우고 쓰기
				BufferedWriter writer = new BufferedWriter(fw);

				for (List<String> entry : csvList) {
					writer.write(entry.get(0) + "/" + entry.get(1));
					writer.newLine();
				}

				writer.flush();
				writer.close();

			} catch (IOException e) {
				e.printStackTrace();
			}
		} else {
			System.out.println("수정할 메모를 찾을 수 없습니다.");
		}
	}

	// 삭제
	public void deleteMemo() {
		/**
		 * 날자를 입력받아 해당 날짜의 메모를 csv파일에서 삭제 하는 코드
		 */
		Scanner sc = new Scanner(System.in);

		System.out.print("삭제할 메모 날짜를 입력 (Ex: 2024-01-01) => ");
		String strDay = sc.nextLine();

		// CSV 파일 읽어오기
		List<List<String>> csvList = getList();

		// 일치하는 날짜 찾아서 삭제
		boolean found = false;
		for (int i = 0; i < csvList.size(); i++) {
			if (csvList.get(i).get(0).equals(strDay)) {
				csvList.remove(i); // 해당 날짜 메모 삭제
				found = true;
				break;
			}
		}

		// 삭제 결과 출력 및 CSV 파일 다시 쓰기
		if (found) {
			System.out.println("메모 삭제 완료!");
			try {
				if (!file.exists()) {
					file.createNewFile();
				}

				FileWriter fw = new FileWriter(file, false); // "false" - 기존 내용 지우고 쓰기
				BufferedWriter writer = new BufferedWriter(fw);

				for (int i = 0; i < csvList.size(); i++) {

					writer.write(csvList.get(i).get(0) + "/" + csvList.get(i).get(1));
					writer.newLine();
				}

				writer.flush();
				writer.close();

			} catch (IOException e) {
				e.printStackTrace();
			}
		} else {
			System.out.println("삭제할 메모를 찾을 수 없습니다.");
		}
	}

}