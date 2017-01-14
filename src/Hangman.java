import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

/**
 * Created by Joseph on 1/5/17.
 */
public class Hangman {

    private JButton aButton;
    private JButton bButton;
    private JButton cButton;
    private JButton dButton;
    private JButton eButton;
    private JButton fButton;
    private JButton gButton;
    private JButton hButton;
    private JButton iButton;
    private JButton jButton;
    private JButton kButton;
    private JButton lButton;
    private JButton mButton;
    private JButton nButton;
    private JButton oButton;
    private JButton pButton;
    private JButton qButton;
    private JButton rButton;
    private JButton sButton;
    private JButton tButton;
    private JButton xButton;
    private JButton wButton;
    private JButton vButton;
    private JButton uButton;
    private JButton yButton;
    private JButton zButton;
    private JPanel keyboardPanel;
    private JPanel mainPanel;
    private JButton startStopButton;
    private JLabel wordLabel;
    private JLabel triesLabel;

    private boolean started = false;
    private int tries;
    private String word;
    private Set<Character> guessedLetters = new HashSet<>();
    private static final String[] words = {"computer", "java", "algorithm", "science",
                                           "programming", "test", "android", "object",
                                           "inheritance", "dijkstra", "debugging"};

    public Hangman() {
        addListeners();
        render();
    }

    /**
     * Adds the action listeners to the GUI components
     */
    public void addListeners() {
        ActionListener keyboardListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) { guessCharacter(e.getActionCommand().charAt(0));}
        };

        ActionListener startStopListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                toggleStarted();
            }
        };

        aButton.addActionListener(keyboardListener);
        bButton.addActionListener(keyboardListener);
        cButton.addActionListener(keyboardListener);
        dButton.addActionListener(keyboardListener);
        fButton.addActionListener(keyboardListener);
        gButton.addActionListener(keyboardListener);
        hButton.addActionListener(keyboardListener);
        iButton.addActionListener(keyboardListener);
        jButton.addActionListener(keyboardListener);
        lButton.addActionListener(keyboardListener);
        mButton.addActionListener(keyboardListener);
        nButton.addActionListener(keyboardListener);
        oButton.addActionListener(keyboardListener);
        pButton.addActionListener(keyboardListener);
        qButton.addActionListener(keyboardListener);
        rButton.addActionListener(keyboardListener);
        sButton.addActionListener(keyboardListener);
        tButton.addActionListener(keyboardListener);
        xButton.addActionListener(keyboardListener);
        wButton.addActionListener(keyboardListener);
        vButton.addActionListener(keyboardListener);
        uButton.addActionListener(keyboardListener);
        yButton.addActionListener(keyboardListener);
        zButton.addActionListener(keyboardListener);
        eButton.addActionListener(keyboardListener);
        kButton.addActionListener(keyboardListener);
        startStopButton.addActionListener(startStopListener);
    }

    /**
     * Switches the game between started and stopped states
     */
    public void toggleStarted() {
        started = !started;
        if (started) start();
        else stop();
    }

    /**
     * Starts the game and selects a new word
     */
    public void start() {
        tries = 0;
        startStopButton.setText("Stop Game");
        word = getWord(words);
        render();
    }

    /**
     * Stops the game and resets the guessed letters
     */
    public void stop(){
        startStopButton.setText("Start Game");
        guessedLetters.clear();
        render();
    }

    /**
     * Increases the number of tries when a new letter is guessed
     */
    public void guessCharacter(char letter) {
        if (guessedLetters.add(letter)) {
            tries++;
            render();
        }
    }

    /**
     * Updates the applications interface
     */
    public void render() {
        if (word != null) {
            String label = "";
            for (char c : word.toCharArray()) label += guessedLetters.contains(c) ? Character.toString(c) :  "-";
            wordLabel.setText(label);
        }
        triesLabel.setText(tries + " Tries");
        for (Component c: keyboardPanel.getComponents()) c.setEnabled(started);
    }

    /**
     * Returns a random word from a predefined list of words.
     */
    public static String getWord(String[] words) {
        return words[new Random().nextInt(words.length)].toUpperCase();
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Hangman");
        frame.setContentPane(new Hangman().mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
