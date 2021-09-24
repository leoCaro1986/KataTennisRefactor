
public class TennisGame3 implements TennisGame {
    
    private int player2;
    private int player1;
    private String p1N;
    private String p2N;

    public TennisGame3(String p1N, String p2N) {
        this.p1N = p1N;
        this.p2N = p2N;
    }

    public String getScore() {
        String player11 = pScore();
        if (player11 != null) return player11;
        if (player1 == player2) return "Deuce";
        return playerAdvance();

    }

    private String pScore() {
        String[] p = new String[]{"Love", "Fifteen", "Thirty", "Forty"};
        String player11 = allScore(p);
        if (player11 != null) return player11;
        return null;
    }

    private String allScore(String[] p) {
        String score;
        if (player1 < 4 && player2 < 4 && !(sumPlayer() == 6)) {
            score = p[player1];
            return (player1 == player2) ? score + "-All" : score + "-" + p[player2];
        }
        return null;
    }

    private int sumPlayer() {
        return player1 + player2;
    }

    private String playerAdvance() {
        String score;
        score = player1 > player2 ? p1N : p2N;
        return (diferPlayer() == 1) ? "Advantage " + score : "Win for " + score;
    }

    private int diferPlayer() {
        return (player1 - player2)*(player1 - player2);
    }

    public void wonPoint(String playerName) {
        if (playerName != null && playerName.equals("player1") )
            this.player1 += 1;
        else
            this.player2 += 1;
        
    }

}
