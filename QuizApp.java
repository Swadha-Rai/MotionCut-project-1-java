import java.util.ArrayList;
import java.util.Scanner;

class Question {
    String questionText;
    String[] options;
    int correctAnswer;

    Question(String questionText, String[] options, int correctAnswer) {
        this.questionText = questionText;
        this.options = options;
        this.correctAnswer = correctAnswer;
    }

    boolean isCorrect(int answer) {
        return answer == correctAnswer;
    }
}

class Quiz {
    ArrayList<Question> questions = new ArrayList<>();
    int score = 0;

    void addQuestion(Question q) {
        questions.add(q);
    }

    void start() {
        Scanner scanner = new Scanner(System.in);
        for (Question q : questions) {
            System.out.println(q.questionText);
            for (int i = 0; i < q.options.length; i++) {
                System.out.println((i + 1) + ": " + q.options[i]);
            }
            System.out.print("Your answer: ");
            int answer = scanner.nextInt();
            if (q.isCorrect(answer)) {
                System.out.println("Correct!");
                score++;
            } else {
                System.out.println("Wrong answer.");
            }
        }
        System.out.println("Your final score: " + score + "/" + questions.size());
        scanner.close();
    }
}

public class QuizApp {
    public static void main(String[] args) {
        Quiz quiz = new Quiz();
        quiz.addQuestion(new Question("What is the capital of France?", new String[]{"Paris", "London", "Rome", "Berlin"}, 1));
        quiz.addQuestion(new Question("What is 2 + 2?", new String[]{"3", "4", "5", "6"}, 2));
        quiz.start();
    }
}
