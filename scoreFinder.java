import java.util.ArrayList;
import java.util.Scanner;

public class scoreFinder {
	static ArrayList<Integer> scores = new ArrayList<Integer>();
	static ArrayList<Integer> attempts = new ArrayList<Integer>();

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter your original score: ");
		int score = scanner.nextInt();
		bestCaseScenario(score);
		System.out.println();
		System.out.println();
		System.out.print("Enter how many questions you think you attempted: ");
		int attempted = scanner.nextInt();
		worstCaseScenario(score, attempted);
		scanner.close();
	}

	private static void bestCaseScenario(int score) {
		for (int i = score; i <= 240; i += 8) {
			if (i % 6 == 0) {
				System.out.print(i + " " + (i / 6) + " ");
				if (40 - (i / 6) < i / 6) {

					System.out.println(40 - (i / 6));
				} else {
					System.out.println();
				}
				scores.add(i);
				attempts.add(i / 6);
			}
		}
	}

	private static void worstCaseScenario(int score, int attempted) {
		int qWrong = 0;
		int worstScore = 0;
		for (int i = 0; i < scores.size(); i++) {
			int qRight = scores.get(i) / 6;
			if (attempts.get(i) + 1 >= attempted && attempts.get(i) - 1 <= attempted) {
				qWrong = (scores.get(i) - score) / 8;
				qRight -= (scores.get(i) - score) / 8;
			}
			if (40 - (scores.get(i) / 6) < scores.get(i) / 6) {
				qWrong += 40 - (scores.get(i) / 6);
			}
			worstScore = (6 * qRight) - (2 * qWrong);
			System.out.println(worstScore + " " + qRight + " " + qWrong);
		}
	}
}