import java.util.*;

public class Question {
    private String questionSentence;
    private ArrayList<String> answers;
    private Map<String, String> rightAnswers;
    private int pointsTotal;

    private String questionType;


    Question(String questionSentence, ArrayList<String> answers, Map<String, String> rightAnswers, int pointsTotal, String questionType){
        this.questionSentence = questionSentence;
        this.answers = answers;
        this.rightAnswers = rightAnswers;
        this.pointsTotal = pointsTotal;
        this.questionType = questionType;
    }


    public Map<String, String> getRightAnswers() {
        return rightAnswers;
    }

    public void printQuestion(){
        System.out.println(questionSentence);
        for (String answer:answers){
            System.out.println(answer);
        }
    }

    public void checkQuestion(Player player,Question question, String answer){
        int points = 0;
        if (questionType == "single") {
            if(question.getRightAnswers().containsKey(answer)||question.getRightAnswers().containsValue(answer)){
                points++;
                System.out.println("Correct, you have earned 1 point. Proceed to next question! ");
            } else {
                System.out.println("Sorry, wrong answer. Try another question! ");
            }
        } else if (questionType == "multiple") {
            ArrayList<String> multipleAnswers = new ArrayList<>(Arrays.asList(answer.split("\s+")));//split answer into list of answers ignoring whitespace
            HashSet<String> setFromMultipleAnswers = new HashSet<>(multipleAnswers); //creating set of multiple answers to avoid duplicit strings
            for(Map.Entry<String, String> entry:rightAnswers.entrySet()){
                if(setFromMultipleAnswers.contains(entry.getValue())&&setFromMultipleAnswers.contains(entry.getKey())){ // removing duplicit anwers
                    setFromMultipleAnswers.remove(entry.getValue());
                }
            }
            for(String multipleAnswer:multipleAnswers){
                if(question.getRightAnswers().containsKey(multipleAnswer)||question.getRightAnswers().containsValue(multipleAnswer)){
                    points++;
                }
            }
            if(points==0){
                System.out.println("Sorry, wrong answers! ");
            } else {
                System.out.println("Correct, you have earned " + points + " points out of " + pointsTotal + ". Proceed to next Question! ");
            }
        }
        player.setPoints(player.getPoints()+points);
    }
}
