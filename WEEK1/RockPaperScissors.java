import java.util.Random;
import java.util.Scanner;

public class RockPaperScissors {

public static String playRound(String playerMove, String computerMove) {
if (playerMove.equals(computerMove)) {
return "Draw";
}
if ((playerMove.equals("Rock") && computerMove.equals("Scissors")) ||
(playerMove.equals("Paper") && computerMove.equals("Rock")) ||
(playerMove.equals("Scissors") && computerMove.equals("Paper"))) {
return "Player Wins";
}
return "Computer Wins";
}

public static void main(String[] args) {
Scanner scanner = new Scanner(System.in);
String[] moves = {"Rock", "Paper", "Scissors"};
Random random = new Random();

System.out.print("Enter number of rounds: ");
int N = scanner.nextInt();

String[] playerMoves = new String[N];
String[] computerMoves = new String[N];
String[] roundResults = new String[N];
int wins = 0;
int losses = 0;
int draws = 0;

for (int i = 0; i < N; i++) {
System.out.print("Round " + (i + 1) + " - Enter your move (Rock/Paper/Scissors): ");
String playerMove = scanner.next();
playerMoves[i] = playerMove;

String computerMove = moves[random.nextInt(3)];
computerMoves[i] = computerMove;

String result = playRound(playerMove, computerMove);
roundResults[i] = result;

if (result.equals("Player Wins")) {
wins++;
} else if (result.equals("Computer Wins")) {
losses++;
} else {
draws++;
}
}

System.out.println("Round | Player Move | Computer Move | Result");
for (int i = 0; i < N; i++) {
System.out.println((i + 1) + " | " + playerMoves[i] + " | " + computerMoves[i] + " | " + roundResults[i]);
}

double winPercentage = (wins * 100.0) / N;
System.out.println("Wins: " + wins + " | Losses: " + losses + " | Draws: " + draws + " | Win % = " + winPercentage + "%");

scanner.close();
}
}