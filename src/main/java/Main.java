import java.util.*;

public class Main {
    public static void main(String[] args) {
        String question1String = "What is the correct x value?\n2 + 2 = x (single answer)";
        ArrayList<String> question1AllAnswers = new ArrayList<>(Arrays.asList("a: 3","b: 4","c: 5"));
        Map<String, String> question1RightAnswers = Map.of("b","4");
        Question question1 = new Question(question1String, question1AllAnswers,
                question1RightAnswers,1, "single");

        String question2String = "What is the square root of 169? Please separate your answers with [SPACE]:";
        ArrayList<String> question2AllAnswers = new ArrayList<>(Arrays.asList("a: 13","b: -13","c: 16"));
        Map<String,String> question2RightAnswers = Map.of("a","13","b","-13");
        Question question2 = new Question(question2String, question2AllAnswers,
                question2RightAnswers,2, "multiple");

        String question3String = "What is the value of PI? (single answer)";
        ArrayList<String> question3AllAnswers = new ArrayList<>(Arrays.asList("a: 3.14","b: 2.89","c: 2.24"));
        Map<String,String> question3RightAnswers = Map.of("a","3.14");
        Question question3 = new Question(question3String, question3AllAnswers, question3RightAnswers, 1,"single");
        ArrayList<Question> questions = new ArrayList<>();

        questions.add(question1);
        questions.add(question2);
        questions.add(question3);

        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to Quizshow, please enter player name: ");
        String name = scanner.nextLine();
        if(name.isEmpty()||name.isBlank()){
            System.out.println("Your default name is Player1! ");
            name = "Player1";
        }
        Player player = new Player(name,0);
        boolean play;
        play = true;

        while(play){
            for(Question question:questions){
                question.printQuestion();
                String answer = scanner.nextLine();
                while(answer.isBlank() || answer.isEmpty()){
                    System.out.println("Write your answer please.");
                    answer = scanner.nextLine();
                }
                question.checkQuestion(player, question, answer);
            }
            System.out.println(player.getName() + " has " + player.getPoints() + " points!");
            play = false;
        }
    }
}
