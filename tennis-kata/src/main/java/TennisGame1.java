
public class TennisGame1 implements TennisGame {

    private int scorePlayer1 = 0;
    private int scorePlayer2 = 0;
    public final String playerName1;
    public final String playerName2;

    public TennisGame1(String player1Name, String playerName2) {
        this.playerName1 = player1Name;
        this.playerName2 = playerName2;
    }

    public void wonPoint(String playerName) {
        if (playerName.equals(this.playerName1)) {
            scorePlayer1 += 1;
        } else {
            scorePlayer2 +=1;
        }
    }

    public String getScore() {
        String score = "";
        if (scorePlayer1 == scorePlayer2)
        {
            score = equalPoints();
        } else if ((scorePlayer1 >= 4) || (scorePlayer2 >= 4)) {
            score = advance();
        }else {
            score = points(scorePlayer1) + "-" + points(scorePlayer2);
        }
        return score;
    }

    private String equalPoints() {
        switch (scorePlayer1)
        {
            case 0:
                return "Love-All";
            case 1:
                return "Fifteen-All";
            case 2:
                return "Thirty-All";
            default:
                return "Deuce";
        }
    }

    private String advance() {
        int diferenciadePuntaje = this.scorePlayer1 - this.scorePlayer2;
        switch (diferenciadePuntaje) {
            case 1:
                return "Advantage player1";
            case -1:
                return "Advantage player2";
            default:
                return (diferenciadePuntaje >= 2)? "Win for player1" : "Win for player2";
        }
    }


    private String points(int scorePlayer1) {
        switch (scorePlayer1){
            case 0:
                return "Love";
            case 1:
                return "Fifteen";
            case 2:
                return "Thirty";
            default:
                return "Forty";

        }

    }

}
