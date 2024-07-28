package filehandler;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// 파일로부터 불러온 데이터를 저장
public class LoadRecords {
	// 파일 경로를 지정
	File file = new File("C:\\AccountBook\\budget.csv");

	// CSV 파일을 읽어와 리스트로 반환
	public List<List<String>> getList() {
		List<List<String>> csvList = new ArrayList<List<String>>();
		BufferedReader br = null;
		String line = "";

		try {
			// 파일을 읽기 위한 BufferedReader를 생성
			br = new BufferedReader(new FileReader(file));
			// 파일의 각 라인을 읽어 리스트에 추가합니다.
			while ((line = br.readLine()) != null) {
				List<String> aLine = new ArrayList<String>();
				String[] lineArr = line.split(",");
				aLine = Arrays.asList(lineArr);
				csvList.add(aLine);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace(); // 파일을 찾지 못했을 경우 예외 처리
		} catch (IOException e) {
			e.printStackTrace(); // 입출력 오류 발생 시 예외 처리
		} finally {
			// BufferedReader 닫기
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace(); // 닫기 중 오류 발생 시 예외 처리
				}
			}
		}

		return csvList;
	}

	// 'saving' 카테고리에 해당하는 데이터를 반환
	public List<List<String>> getSaving() {
		List<List<String>> csvList = getList();
		List<List<String>> csvSaving = new ArrayList<>();

		for (int i = 0; i < csvList.size(); i++) {
			if (csvList.get(i).get(0).equals("saving")) {
				csvSaving.add(csvList.get(i));
			}
		}

		return csvSaving;
	}

	// 'insurance' 카테고리에 해당하는 데이터를 반환
	public List<List<String>> getInsurance() {
		List<List<String>> csvList = getList();
		List<List<String>> csvInsurance = new ArrayList<>();

		for (int i = 0; i < csvList.size(); i++) {
			if (csvList.get(i).get(0).equals("insurance")) {
				csvInsurance.add(csvList.get(i));
			}
		}

		return csvInsurance;
	}

	// 'ott' 카테고리에 해당하는 데이터를 반환
	public List<List<String>> getOtt() {
		List<List<String>> csvList = getList();
		List<List<String>> csvOtt = new ArrayList<>();

		for (int i = 0; i < csvList.size(); i++) {
			if (csvList.get(i).get(0).equals("ott")) {
				csvOtt.add(csvList.get(i));
			}
		}

		return csvOtt;
	}

	// 'food' 카테고리에 해당하는 데이터를 반환
	public List<List<String>> getFood() {
		List<List<String>> csvList = getList();
		List<List<String>> csvFood = new ArrayList<>();

		for (int i = 0; i < csvList.size(); i++) {
			if (csvList.get(i).get(0).equals("food")) {
				csvFood.add(csvList.get(i));
			}
		}

		return csvFood;
	}

	// 'transport' 카테고리에 해당하는 데이터를 반환
	public List<List<String>> getTransport() {
		List<List<String>> csvList = getList();
		List<List<String>> csvTransport = new ArrayList<>();

		for (int i = 0; i < csvList.size(); i++) {
			if (csvList.get(i).get(0).equals("transport")) {
				csvTransport.add(csvList.get(i));
			}
		}

		return csvTransport;
	}

	// 'culture' 카테고리에 해당하는 데이터를 반환
	public List<List<String>> getCulture() {
		List<List<String>> csvList = getList();
		List<List<String>> csvCulture = new ArrayList<>();

		for (int i = 0; i < csvList.size(); i++) {
			if (csvList.get(i).get(0).equals("culture")) {
				csvCulture.add(csvList.get(i));
			}
		}

		return csvCulture;
	}

	// 'hospital' 카테고리에 해당하는 데이터를 반환
	public List<List<String>> getHospital() {
		List<List<String>> csvList = getList();
		List<List<String>> csvHospital = new ArrayList<>();

		for (int i = 0; i < csvList.size(); i++) {
			if (csvList.get(i).get(0).equals("hospital")) {
				csvHospital.add(csvList.get(i));
			}
		}

		return csvHospital;
	}

	// 'shopping' 카테고리에 해당하는 데이터를 반환
	public List<List<String>> getShopping() {
		List<List<String>> csvList = getList();
		List<List<String>> csvShopping = new ArrayList<>();

		for (int i = 0; i < csvList.size(); i++) {
			if (csvList.get(i).get(0).equals("shopping")) {
				csvShopping.add(csvList.get(i));
			}
		}

		return csvShopping;
	}

	// 'etc' 카테고리에 해당하는 데이터를 반환
	public List<List<String>> getEtc() {
		List<List<String>> csvList = getList();
		List<List<String>> csvEtc = new ArrayList<>();

		for (int i = 0; i < csvList.size(); i++) {
			if (csvList.get(i).get(0).equals("etc")) {
				csvEtc.add(csvList.get(i));
			}
		}

		return csvEtc;
	}

}
