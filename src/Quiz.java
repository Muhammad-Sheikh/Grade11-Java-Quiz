import java.util.Objects;
import java.util.Scanner;

public class Quiz {
    public static void main(String[] args)
    {
        Quiz main = new Quiz();

        main.test();


        //Object Declaration
        //Calls title screen
        //main.titleScreen();
        while (main.gameStart)
        {

        }
    }

    //Global Variables Declration
    Questions questions = new Questions();
    String playerStart;

    boolean gameStart;
public  void test()
{
    questionRandomizer();
    System.out.println(questions.getQuestion());


    Scanner userInput = new Scanner(System.in);

    int inp = userInput.nextInt();


    if(questions.checkAnswer(inp))
    {
        System.out.println("Correct!");
    } else
    {
        System.out.println("Inorrect!");
    }
}
    public void questionRandomizer()
    {
        double currentRand;
        double currentvalidPool [] = {1, 2 ,3, 4, 5};

          currentRand = Math.random() * (4 - 1 + 1) + 1;

            if(currentvalidPool[(int) currentRand] == 1)
            {
                currentvalidPool[(int) currentRand] = 0;
                questions.setQuestion("What does KAY/O stand for?");
                questions.setAnswer("Kill All Your Opponents");
                questions.setOptions(new String[]{"Kill All Your Opponents", "Nothing", "Knock Out!", "Keep All Your 0's"});
            }

          if(currentvalidPool[(int) currentRand] == 2)
          {
              currentvalidPool[(int) currentRand] = 0;
              questions.setQuestion("Who developed & published Valorant??");
              questions.setAnswer("Riot Games");
              questions.setOptions(new String[]{"Rockstar Games", "Ubisoft", "Electronic Arts", "Riot Games"});
          }

          if(currentvalidPool[(int) currentRand] == 3)
          {
              currentvalidPool[(int) currentRand] = 0;
              questions.setQuestion("The ability  \"Paranoia\" is used by what agent?");
              questions.setAnswer("Omen");
              questions.setOptions(new String[]{"Fade", "Omen", "Brimstone", "Gecko"});
          }

          if(currentvalidPool[(int) currentRand] == 4)
          {
              currentvalidPool[(int) currentRand] = 0;
              questions.setQuestion("Which of these are NOT maps in Valorant?");
              questions.setAnswer("Clock");
              questions.setOptions(new String[]{"Fracture", "Ascent", "Split", "House"});
          }

          if(currentvalidPool[(int) currentRand] == 5)
          {
              currentvalidPool[(int) currentRand] = 0;
              questions.setQuestion("The \"Vandal\" weapon is modeled after what real life gun?");
              questions.setAnswer("Ak-47");
              questions.setOptions(new String[]{"Ak-47", "M4 Assault Rifle", "MP5 Parrebluem", "Glock-19"});
          }
    }


    public void textClear() {
        for (int row = 1; row <= 21; row = row + 1) {
            for (int clear = 1; clear <= 2; clear = clear + 1) {
                System.out.println();
            }
        }
    }

    public void tempStop(int seconds)
    {
        int milliseconds;
        milliseconds = seconds * 1000;
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException ie) {
        }
    }

public boolean titleScreen()
{
    System.out.println("TYPE IN THE OPTION YOU WANT!");
    System.out.println("START");
    System.out.println("CREDITS");
    System.out.println("EXIT");
    Scanner input = new Scanner(System.in);
    playerStart = input.nextLine();
    System.out.println(playerStart);
    if (playerStart.equals("START") || playerStart.equals("start") || playerStart.equals("Start")) {
        return gameStart = true;
    } else if (playerStart.equals("CREDITS") || playerStart.equals("credits")) {


        tempStop(30);
        System.exit(0);

    } else if (playerStart.equals("EXIT") || playerStart.equals("exit")) {
        System.exit(0);
    }
    return gameStart = false;
}

class Questions
{
    private String Answer;

    private String Question;

    private String QuestionOptions[];

    public String getQuestion ()
    {
        return Question;
    }
    //public String getOptions
    public boolean checkAnswer(int toCheck) { return Objects.equals(Answer, QuestionOptions[toCheck]);}
    public void setAnswer(String newAnswer) {
        Answer = newAnswer;
    }
    public  void setOptions(String [] question1Options)
    {
        QuestionOptions = question1Options.clone();
    }
    public void setQuestion(String newQuestion) {
        Question = newQuestion;
    }

}

}


