import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class QuizApplication extends JFrame {
    private JLabel questionLabel;
    private JRadioButton[] options;
    private ButtonGroup buttonGroup;
    private JButton submitButton;
    private Timer timer;
    private int timeLeft;
    private int currentQuestionIndex;
    private int score;
    private String[][] quizData = {
            {"Question 1: What is the capital of France?", "Paris", "London", "Berlin", "Madrid", "Paris"},
            {"Question 2: What is the largest planet in our solar system?", "Jupiter", "Saturn", "Mars", "Earth", "Jupiter"},
            {"Question 3: Who wrote the play 'Romeo and Juliet'?", "William Shakespeare", "Jane Austen", "Charles Dickens", "Mark Twain", "William Shakespeare"}
            // Add more questions here
    };

    public QuizApplication() {
        setTitle("Quiz Application");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        questionLabel = new JLabel();
        add(questionLabel, BorderLayout.NORTH);

        JPanel optionsPanel = new JPanel(new GridLayout(4, 1));
        options = new JRadioButton[4];
        buttonGroup = new ButtonGroup();
        for (int i = 0; i < 4; i++) {
            options[i] = new JRadioButton();
            optionsPanel.add(options[i]);
            buttonGroup.add(options[i]);
        }
        add(optionsPanel, BorderLayout.CENTER);

        submitButton = new JButton("Submit");
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                checkAnswer();
                showNextQuestion();
            }
        });
        add(submitButton, BorderLayout.SOUTH);

        pack();
        setLocationRelativeTo(null);

        showNextQuestion();
    }

    private void showNextQuestion() {
        if (currentQuestionIndex < quizData.length) {
            questionLabel.setText(quizData[currentQuestionIndex][0]);
            for (int i = 0; i < 4; i++) {
                options[i].setText(quizData[currentQuestionIndex][i + 1]);
                options[i].setSelected(false);
            }
            startTimer();
        } else {
            showResult();
        }
    }

    private void startTimer() {
        timeLeft = 10; // 10 seconds per question
        timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (timeLeft > 0) {
                    timeLeft--;
                } else {
                    timer.stop();
                    checkAnswer();
                    showNextQuestion();
                }
            }
        });
        timer.start();
    }

    private void checkAnswer() {
        for (int i = 0; i < 4; i++) {
            if (options[i].isSelected() && options[i].getText().equals(quizData[currentQuestionIndex][5])) {
                score++;
                break;
            }
        }
        currentQuestionIndex++;
    }

    private void showResult() {
        JOptionPane.showMessageDialog(this, "Quiz completed!\nScore: " + score + "/" + quizData.length,
                "Result", JOptionPane.INFORMATION_MESSAGE);
        System.exit(0);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new QuizApplication().setVisible(true);
            }
        });
    }
}
