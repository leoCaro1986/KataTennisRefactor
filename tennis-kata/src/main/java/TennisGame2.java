import java.util.Arrays;
import java.util.List;

public class TennisGame2 implements TennisGame
{
    private int ScorePlayer1 = 0;
    private int ScorePlayer2 = 0;
    private String PlayerName1;
    private String PlayerName2;

    public TennisGame2(String Player1Name, String Player2Name) {
        this.PlayerName1 = Player1Name;
        this.PlayerName2 = Player2Name;
    }

    public String getScore(){
        String Score = "";
        if (equal()){
            Score = equalsPoints();
        }  else if(selectorAdvance()){
            int DiferenciaDePuntaje = ScorePlayer1 - ScorePlayer2;
            Score = advance(DiferenciaDePuntaje);
        } else {
            Score = point(ScorePlayer1) + "-" + point(ScorePlayer2);
        }
        return Score;
    }

    public void wonPoint(String Player) {
        var point = (Player == "player1") ? (ScorePlayer1 ++) : (ScorePlayer2 ++);
    }


    public boolean equal(){
        return (ScorePlayer1 == ScorePlayer2);
    }


    public boolean selectorAdvance(){
        return ((ScorePlayer1 >= 4) || (ScorePlayer2 >= 4));
    }


    public String equalsPoints() {
        List<String> points = Arrays.asList("Love-All", "Fifteen-All", "Thirty-All", "Deuce", "Deuce");
        return points.get(ScorePlayer1);
    }


    public String advance(int diferPoints){
        switch (diferPoints){
            case 1:
                return "Advantage player1";
            case -1:
                return "Advantage player2";
            default:
                return (diferPoints >= 2)? "Win for player1" : "Win for player2";
        }
    }

    public String point(int ScorePlayer){
        List<String> Puntajes = Arrays.asList("Love", "Fifteen", "Thirty", "Forty");
        return Puntajes.get(ScorePlayer);
    }
}