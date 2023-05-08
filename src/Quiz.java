//TODO add header, add comments, add more questions, test for invalid inputs
import java.util.*;

public class Quiz {
    public static void main(String[] args) {
        Quiz main = new Quiz();

        while (true)
        {
            main.titleScreen();
            main.askQuestion();
            main.askQuestion();
            main.askQuestion();
            main.askQuestion();
            main.askQuestion();
            main.setValidPool();
            main.gameEnd();
            main.tempStop(5);
        }

    }

    //Global Variables Declration
    Questions questions = new Questions();
    String playerStart;
    int playerScore;
    int RandomizervalidPool[] = {1, 2, 3, 4, 5};


    boolean gameStart;


    public void gameEnd() {
        textClear();

        System.out.println("Congrats! You ended with " + playerScore + " points!");
        playerScore = 0;
        tempStop(3);
        System.out.println("We will now send you back to the main menu!");
    }

    public void askQuestion() {
        Scanner userInput = new Scanner(System.in);
        String input;
        boolean validInput = false;

        questionRandomizer();
        System.out.println(questions.getQuestion());
        String currentOptions[] = (questions.getOptions()).clone();
        System.out.println("Please choose an option between 0 - 3!");
        System.out.println("0:" + currentOptions[0]);
        System.out.println("1:" + currentOptions[1]);
        System.out.println("2:" + currentOptions[2]);
        System.out.println("3:" + currentOptions[3]);
        input = userInput.nextLine();
        while (!validInput) {
            if (input.equals("0") || input.equals("1") || input.equals("2") || input.equals("3")) {
                validInput = true;
            } else {
                System.out.println("Please enter a valid input:");
                input = userInput.nextLine();
            }
        }
        if (questions.checkAnswer(input)) {
            playerScore = playerScore + 10;
            System.out.println("Correct!");
            System.out.println("You have " + playerScore + " points!");
            tempStop(3);
            System.out.println();
            System.out.println();
        } else {
            playerScore = playerScore - 5;
            System.out.println("Incorrect!");
            System.out.println("You have " + playerScore + " points!");
            tempStop(3);
            System.out.println();
            System.out.println();
        }
    }

    public void setValidPool() {
        RandomizervalidPool = new int[]{1, 2, 3, 4, 5};
    }

    public void questionRandomizer() {
        int currentRand;
        boolean newQuestion = false;
        while (!newQuestion) {

            currentRand = (int) (Math.random() * 5 + 0);

            if (RandomizervalidPool[currentRand] == 1) {
                RandomizervalidPool[currentRand] = 0;
                questions.setQuestion("What does KAY/O stand for?");
                questions.setAnswer("Kill All Your Opponents");
                questions.setOptions(new String[]{"Kill All Your Opponents", "Nothing", "Knock Out!", "Keep All Your 0's"});
                newQuestion = true;
            }

            if (RandomizervalidPool[currentRand] == 2) {
                RandomizervalidPool[currentRand] = 0;
                questions.setQuestion("Who developed & published Valorant?");
                questions.setAnswer("Riot Games");
                questions.setOptions(new String[]{"Rockstar Games", "Ubisoft", "Electronic Arts", "Riot Games"});
                newQuestion = true;
            }

            if (RandomizervalidPool[currentRand] == 3) {
                RandomizervalidPool[currentRand] = 0;
                questions.setQuestion("The ability \"Paranoia\" is used by what agent?");
                questions.setAnswer("Omen");
                questions.setOptions(new String[]{"Fade", "Omen", "Brimstone", "Gecko"});
                newQuestion = true;
            }

            if (RandomizervalidPool[currentRand] == 4) {
                RandomizervalidPool[currentRand] = 0;
                questions.setQuestion("Which of these are NOT maps in Valorant?");
                questions.setAnswer("House");
                questions.setOptions(new String[]{"Fracture", "Ascent", "Split", "House"});
                newQuestion = true;
            }

            if (RandomizervalidPool[currentRand] == 5) {
                RandomizervalidPool[currentRand] = 0;
                questions.setQuestion("The \"Vandal\" weapon is modeled after what real life gun?");
                questions.setAnswer("Ak-47");
                questions.setOptions(new String[]{"Ak-47", "M4 Assault Rifle", "MP5 Parrebluem", "Glock-19"});
                newQuestion = true;
            }
        }
    }


    public void textClear() {
        for (int row = 1; row <= 21; row = row + 1) {
            for (int clear = 1; clear <= 2; clear = clear + 1) {
                System.out.println();
            }
        }
    }

    public void tempStop(int seconds) {
        int milliseconds;
        milliseconds = seconds * 1000;
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException ie) {
        }
    }

    public boolean titleScreen() {
        System.out.println();
        System.out.println();
        System.out.println("Welcome all to");
        System.out.println("███████████ █████                  █████   █████           ████                                           █████          ██████                ███            \n" +
                "░█░░░███░░░█░░███                  ░░███   ░░███           ░░███                                          ░░███         ███░░░░███             ░░░             \n" +
                "░   ░███  ░  ░███████    ██████     ░███    ░███   ██████   ░███   ██████  ████████   ██████   ████████   ███████      ███    ░░███ █████ ████ ████   █████████\n" +
                "    ░███     ░███░░███  ███░░███    ░███    ░███  ░░░░░███  ░███  ███░░███░░███░░███ ░░░░░███ ░░███░░███ ░░░███░      ░███     ░███░░███ ░███ ░░███  ░█░░░░███ \n" +
                "    ░███     ░███ ░███ ░███████     ░░███   ███    ███████  ░███ ░███ ░███ ░███ ░░░   ███████  ░███ ░███   ░███       ░███   ██░███ ░███ ░███  ░███  ░   ███░  \n" +
                "    ░███     ░███ ░███ ░███░░░       ░░░█████░    ███░░███  ░███ ░███ ░███ ░███      ███░░███  ░███ ░███   ░███ ███   ░░███ ░░████  ░███ ░███  ░███    ███░   █\n" +
                "    █████    ████ █████░░██████        ░░███     ░░████████ █████░░██████  █████    ░░████████ ████ █████  ░░█████     ░░░██████░██ ░░████████ █████  █████████\n" +
                "   ░░░░░    ░░░░ ░░░░░  ░░░░░░          ░░░       ░░░░░░░░ ░░░░░  ░░░░░░  ░░░░░      ░░░░░░░░ ░░░░ ░░░░░    ░░░░░        ░░░░░░ ░░   ░░░░░░░░ ░░░░░  ░░░░░░░░░ \n" +
                "                                                                                                                                                               \n" +
                "                                                                                                                                                               \n" +
                "                                                                                                                                                               ");
        System.out.println("Made by Muhammad Sheikh!");
        System.out.println();
        System.out.println();
        System.out.println("TYPE IN THE OPTION YOU WANT!");
        System.out.println("START");
        System.out.println("EXIT");

        Scanner input = new Scanner(System.in);
        playerStart = input.nextLine();
        boolean validInput = false;

        while (!validInput) {
            if (playerStart.equals("START") || playerStart.equals("start") || playerStart.equals("Start")) {
                validInput = true;
                return gameStart = true;
            } else if (playerStart.equals("EXIT") || playerStart.equals("exit") || playerStart.equals("Exit")) {
                validInput = true;
                System.exit(0);
            } else {
                System.out.println("Please enter a valid input!");
                playerStart = input.nextLine();
            }
        }
        return gameStart = false;
    }

    class Questions {
        private String Answer;

        private String Question;

        private String QuestionOptions[];

        public String getQuestion() {
            return Question;
        }

        public String[] getOptions() {
            String[] returnOptions = QuestionOptions.clone();
            return returnOptions;
        }

        public boolean checkAnswer(String toCheck) {
            return Objects.equals(Answer, QuestionOptions[Integer.parseInt(toCheck)]);
        }

        public void setAnswer(String newAnswer) {
            Answer = newAnswer;
        }

        public void setOptions(String[] question1Options) {
            QuestionOptions = question1Options.clone();
        }

        public void setQuestion(String newQuestion) {
            Question = newQuestion;
        }

    }

}