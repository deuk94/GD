package main;

import java.io.*;
import java.util.Random;
import java.util.Scanner;

public class LoginManager {

	private String userCode;
	private static final String USER_CODE_FILE = "user_code.txt";

	// 생성자: 사용자 코드를 로드
	public LoginManager() {
		userCode = loadUserCode();
	}

	// 로그인 화면을 구성하고 사용자 입력을 처리
	public void displayLogin() {
		Scanner scanner = new Scanner(System.in);
		boolean isRunning = true;

		while (isRunning) {
			System.out.println("\n=========================================================");
			System.out.println("1. 회원 코드 발급");
			System.out.println("2. 로그인");
			System.out.println("3. 종료하기");
			System.out.print("메뉴를 선택해주세요 => ");
			
			int choice = scanner.nextInt();
			scanner.nextLine(); // 입력 버퍼 비우기

			//1번-회원코드 발금 , 2번-회원코드 입력 , 3번-종료
			switch (choice) {
			case 1:
				if (userCode == null) {
					userCode = generateUserCode();
					saveUserCode(userCode);
					System.out.println("발급된 회원 코드: " + userCode);
					System.out.println("주의! 다시 찾을 수 없으니 메모해두세요.");
					isRunning = false;
				} else {
					System.out.println("이미 회원 코드가 발급되었습니다.");
				}
				break;
			case 2:
				System.out.print("회원 코드를 입력하세요: ");
				String inputCode = scanner.nextLine();
				if (inputCode.equals(userCode)) {
					System.out.println("로그인 성공");
					isRunning = false;
				} else {
					System.out.println("회원 코드가 일치하지 않습니다.");
				}
				break;
			case 3:
				System.exit(0);
				break;
			default:
				System.out.println("잘못된 선택입니다.");
				break;
			}
		}
	}

	// 사용자 코드를 반환
	public String getUserCode() {
		return userCode;
	}

	// 8자리의 랜덤한 사용자 코드를 생성
	private String generateUserCode() {
		Random random = new Random();
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < 8; i++) {
			int randNum = random.nextInt(36); // 0-9 && a-z
			if (randNum < 10) {
				sb.append(randNum); // 0-9
			} else {
				sb.append((char) (randNum + 87)); // a-z
			}
		}
		return sb.toString();
	}

	// 사용자 코드를 파일에 저장
	private void saveUserCode(String userCode) {
		try (BufferedWriter writer = new BufferedWriter(new FileWriter(USER_CODE_FILE))) {
			writer.write(userCode);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// 파일에서 사용자 코드를 로드
	private String loadUserCode() {
		File file = new File(USER_CODE_FILE);
		if (file.exists()) {
			try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
				return reader.readLine();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return null;
	}
}
