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
    Scanner userInput = new Scanner(System.in);

    int inp = userInput.nextInt();


    questionRandomizer();


    System.out.println(questions.getQuestion1());

    if(questions.checkAnswer1(inp))
    {
        System.out.println("Correct!");
    } else
    {
        System.out.println("Inorrect!");
    }
}
    public void questionRandomizer()
    {
        int  currentRand;
        currentRand = 1;
        double currentvalidPool [] = {1, 2 ,3, 4, 5};
        for (int i = 0; i <= 4; i++)
        {

          //currentRand = Math.random() * (5 - 1 + 1) + 1;

              currentvalidPool[(int) currentRand] = 0;
              questions.setQuestion1("What does KAY/O stand for?");
              questions.setAnswer1("Kill All Your Opponents");
              questions.setOptions1(new String[] {"Kill All Your Opponents", "Nothing", "Knock Out!", "Keep All Your 0's"});


          if(currentvalidPool[(int) currentRand] == 2)
          {

          }

          if(currentvalidPool[(int) currentRand] == 2)
          {

          }

          if(currentvalidPool[(int) currentRand] == 2)
          {

          }

          if(currentvalidPool[(int) currentRand] == 2)
          {

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
    private String Answer1, Answer2, Answer3, Answer4, Answer5;

    private String Question1, Question2, Question3, Question4, Question5;

    private String Question1Options[];


    public String getQuestion1 ()
    {
        return Question1;
    }
    public boolean checkAnswer1(int toCheck) {
        return Objects.equals(Answer1, Question1Options[toCheck]);
    }
    public void setAnswer1(String newAnswer) {
        Answer1 = newAnswer;
    }

    public  void setOptions1(String [] question1Options)
    {
        Question1Options = question1Options.clone();
    }

    public void setQuestion1(String newQuestion) {
        Question1 = newQuestion;
    }

}



}


