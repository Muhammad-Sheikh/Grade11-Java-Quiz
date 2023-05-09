/*
Purpose: Valorant themed quiz that award points based on correct points. Cleans inputs, and makes sure there are no repeat
questions in a play through.
Instructor: Mr. Anthony
Class Code: ICS3U-4
Name of Programmer: Muhammad Sheikh
Date: 2023-05-4
Challenge Features:
1)Questions are randomly selected from a larger pool of questions and do not repeat within the same play-through
2)Ensure it is impossible for the user to enter “bad input” (if they enter something that doesn’t make sense, force them to enter again) There must be no runtime errors.
 */
import java.util.*;

public class Quiz {
    public static void main(String[] args) {
        //Declares an object to call all functions, as they are all public functions needing to be called with the context of an object.
        Quiz main = new Quiz();

        //While loop ensures the program keeps going through itself until the user decides to exit at the main menu.
        while (true)
        {
            //Calls the title screen method. More is explained in the function.
            main.titleScreen();
            //Calls the "ask question" method 5 times, to give the user 5 questions. More is explained in the function.
            main.askQuestion();
            main.askQuestion();
            main.askQuestion();
            main.askQuestion();
            main.askQuestion();
            //Sets the valid pool of questions back to its default values. Once played, questions are ensured not to show up again.
            //This can be a problem for repeat play through, so this makes all questions valid selections again.
            main.setValidPool();
            //Calls the end credits, which shows final score and tells the user they will be taken back to the title screen.
            main.gameEnd();
            //Stops program execution for 5 seconds to allow used to read everything.
            main.tempStop(5);
        }

    }

    //Global Variables Declaration
    //makes the questions object based on the Questions class to be called by various methods.
    Questions questions = new Questions();
    //Used to indicate the players choice as a string during the main menu
    String playerStart;
    //sets a global player score that many methods can use
    int playerScore;
    //Sets the initial valid question pool
    int RandomizervalidPool[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

    public void gameEnd() {
        /*
        This is the function the user gets at the end of the play through. It is called once after every run to indicate the game is over.
         */
        //Calls the text clear method. This clears the terminal from the previous questions, making the end screen more diverse and readable.
        textClear();
        //Prints the end player score and a congrats message.
        System.out.println("Congrats! You ended with " + playerScore + " points!");
        //Resets the players score to 0 for next play through
        playerScore = 0;
        //Stops for 3 seconds to let player read everything
        tempStop(3);
        //Indicates to the player they will be returned to the menu.
        System.out.println("We will now send you back to the main menu!");
    }

    public void askQuestion() {
        /*
        This function handles the asking of the question, printing the question, options and checking if its correct.
        It also cleans the input the player may enter here.
         */

        //Variable declaration of Inputs, and if the input is valid.
        Scanner userInput = new Scanner(System.in);
        String input;
        boolean validInput = false;

        //Calls the question randomizer function, which selects a random question along with its answer and options that hasn't already been used.
        questionRandomizer();
        //Using the questions object, it gets the question that the randomizer has set.
        System.out.println(questions.getQuestion());
        //Clones the questions options into an array to use locally. Array is set here to indicate the cloning of a string type array.
        String currentOptions[] = (questions.getOptions()).clone();
        //Prints how to enter your answer.
        System.out.println("Please choose an option between 0 - 3!");
        //Prints the array number as the option linked directly to the options array, associating option 0 with index 0 in the options array.
        System.out.println("0:" + currentOptions[0]);
        System.out.println("1:" + currentOptions[1]);
        System.out.println("2:" + currentOptions[2]);
        System.out.println("3:" + currentOptions[3]);
        //asks the user for input
        input = userInput.nextLine();
        //assumes the user will not put in any valid input, so runs the while loop
        while (!validInput) {
            //Checks if the user has entered any option from 0-3, the only valid options
            if (input.equals("0") || input.equals("1") || input.equals("2") || input.equals("3")) {
                //sets a valid input to be true
                validInput = true;
            } else {
                //otherwise keeps asking the user to enter a valid input until it matches the if statement above.
                System.out.println("Please enter a valid input:");
                input = userInput.nextLine();
            }
        }
        //uses the questions object to check the answer stored in the questions class with the input number entered.
        if (questions.checkAnswer(input)) {
            //If correct they get 10 points, and adds some spaces to help formatting
            playerScore = playerScore + 10;
            System.out.println("Correct!");
            System.out.println("You have " + playerScore + " points!");
            tempStop(3);
            System.out.println();
            System.out.println();
        } else {
            System.out.println("Incorrect!");
            System.out.println("You have " + playerScore + " points!");
            tempStop(3);
            System.out.println();
            System.out.println();
        }
    }

    public void setValidPool() {
        //Function used to reset the valid pool that the question randomizer uses
        RandomizervalidPool = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
    }

    public void questionRandomizer() {
        /*
        This function is the one that chooses what the current question, its options and answers will be.
        It does this by picking a random number from 0-9, which is then used by an array for its index number.
        All the questions,answers and options are then put into an if statement, and if the array index matches
        their number (example, random number of 4, makes question 5 the current random question) it then sets it to
        0 so it cant be used again. Eventually sets 5 numbers in the array to 0, as those are the 5 random ones chosen.
         */

        //Scope Variable Declaration
        //Declares current random number
        int currentRand;
        /*
        Assumes the current question has been used already. This ensures that if the random number lands on a number it
        already has, it re-picks one until it finds a new question.
         */
        boolean newQuestion = false;
        //While loop that runs until a new question is found


        while (!newQuestion) {
            //Picks a random number from 0-9 to use as an index value for RandomizervalidPool
            currentRand = (int) (Math.random() * 10 + 0);

            //If the random index number in RandomizervalidPool lines up with this, it sets the current question, options and answer.
            if (RandomizervalidPool[currentRand] == 1) {
                //Sets its own index value to 0, so it cannot be used again
                RandomizervalidPool[currentRand] = 0;
                //Uses the question object to set question
                questions.setQuestion("What does KAY/O stand for?");
                //Sets the answer using the question object
                questions.setAnswer("Kill All Your Opponents");
                //Sets all the options as an array which is then sent to the questions class
                questions.setOptions(new String[]{"Kill All Your Opponents", "Nothing", "Knock Out!", "Keep All Your 0's"});
                //Exits the while loop by indicating a new question is found
                newQuestion = true;
            }

            //If the random index number in RandomizervalidPool lines up with this, it sets the current question, options and answer.
            if (RandomizervalidPool[currentRand] == 2) {
                //Sets its own index value to 0, so it cannot be used again
                RandomizervalidPool[currentRand] = 0;
                //Uses the question object to set question
                questions.setQuestion("Who developed & published Valorant?");
                //Sets the answer using the question object
                questions.setAnswer("Riot Games");
                //Sets all the options as an array which is then sent to the questions class
                questions.setOptions(new String[]{"Rockstar Games", "Ubisoft", "Electronic Arts", "Riot Games"});
                //Stops program execution for 5 seconds to allow used to read everything.
                newQuestion = true;
            }

            //If the random index number in RandomizervalidPool lines up with this, it sets the current question, options and answer.
            if (RandomizervalidPool[currentRand] == 3) {
                //Sets its own index value to 0, so it cannot be used again
                RandomizervalidPool[currentRand] = 0;
                //Uses the question object to set question
                questions.setQuestion("The ability \"Paranoia\" is used by what agent?");
                //Sets the answer using the question object
                questions.setAnswer("Omen");
                //Sets all the options as an array which is then sent to the questions class
                questions.setOptions(new String[]{"Fade", "Omen", "Brimstone", "Gecko"});
                //Stops program execution for 5 seconds to allow used to read everything.
                newQuestion = true;
            }

            //If the random index number in RandomizervalidPool lines up with this, it sets the current question, options and answer.
            if (RandomizervalidPool[currentRand] == 4) {
                //Sets its own index value to 0, so it cannot be used again
                RandomizervalidPool[currentRand] = 0;
                //Uses the question object to set question
                questions.setQuestion("Which of these are NOT maps in Valorant?");
                //Sets the answer using the question object
                questions.setAnswer("House");
                //Sets all the options as an array which is then sent to the questions class
                questions.setOptions(new String[]{"Fracture", "Ascent", "Split", "House"});
                //Stops program execution for 5 seconds to allow used to read everything.
                newQuestion = true;
            }

            //If the random index number in RandomizervalidPool lines up with this, it sets the current question, options and answer.
            if (RandomizervalidPool[currentRand] == 5) {
                //Sets its own index value to 0, so it cannot be used again
                RandomizervalidPool[currentRand] = 0;
                //Uses the question object to set question
                questions.setQuestion("The \"Vandal\" weapon is modeled after what real life gun?");
                //Sets the answer using the question object
                questions.setAnswer("Ak-47");
                //Sets all the options as an array which is then sent to the questions class
                questions.setOptions(new String[]{"Ak-47", "M4 Assault Rifle", "MP5 Parrebluem", "Glock-19"});
                //Stops program execution for 5 seconds to allow used to read everything.
                newQuestion = true;
            }

            //If the random index number in RandomizervalidPool lines up with this, it sets the current question, options and answer.
            if (RandomizervalidPool[currentRand] == 6) {
                //Sets its own index value to 0, so it cannot be used again
                RandomizervalidPool[currentRand] = 0;
                //Uses the question object to set question
                questions.setQuestion("What kind of headgear does \"Brimstone\" wear in Valorant?");
                //Sets the answer using the question object
                questions.setAnswer("Beret");
                //Sets all the options as an array which is then sent to the questions class
                questions.setOptions(new String[]{"Beret", "Top Hat", "Combat Helmet", "Nothing"});
                //Stops program execution for 5 seconds to allow used to read everything.
                newQuestion = true;
            }

            //If the random index number in RandomizervalidPool lines up with this, it sets the current question, options and answer.
            if (RandomizervalidPool[currentRand] == 7) {
                //Sets its own index value to 0, so it cannot be used again
                RandomizervalidPool[currentRand] = 0;
                //Uses the question object to set question
                questions.setQuestion("What is the latest map added to Valorant?");
                //Sets the answer using the question object
                questions.setAnswer("Lotus");
                //Sets all the options as an array which is then sent to the questions class
                questions.setOptions(new String[]{"Split", "Lotus", "Breeze", "House"});
                //Stops program execution for 5 seconds to allow used to read everything.
                newQuestion = true;
            }

            //If the random index number in RandomizervalidPool lines up with this, it sets the current question, options and answer.
            if (RandomizervalidPool[currentRand] == 8) {
                //Sets its own index value to 0, so it cannot be used again
                RandomizervalidPool[currentRand] = 0;
                //Uses the question object to set question
                questions.setQuestion("What are the player characters called in Valorant?");
                //Sets the answer using the question object
                questions.setAnswer("Agents");
                //Sets all the options as an array which is then sent to the questions class
                questions.setOptions(new String[]{"Operators", "Agents", "Specialists", "Deadshots"});
                //Stops program execution for 5 seconds to allow used to read everything.
                newQuestion = true;
            }

            //If the random index number in RandomizervalidPool lines up with this, it sets the current question, options and answer.
            if (RandomizervalidPool[currentRand] == 9) {
                //Sets its own index value to 0, so it cannot be used again
                RandomizervalidPool[currentRand] = 0;
                //Uses the question object to set question
                questions.setQuestion("The ability \"ZERO/point\" is used by who?");
                //Sets the answer using the question object
                questions.setAnswer("KAYO");
                //Sets all the options as an array which is then sent to the questions class
                questions.setOptions(new String[]{"Breach", "Gecko", "KAYO", "Viper"});
                //Stops program execution for 5 seconds to allow used to read everything.
                newQuestion = true;
            }

            //If the random index number in RandomizervalidPool lines up with this, it sets the current question, options and answer.
            if (RandomizervalidPool[currentRand] == 10) {
                //Sets its own index value to 0, so it cannot be used again
                RandomizervalidPool[currentRand] = 0;
                //Uses the question object to set question
                questions.setQuestion("The abilities of the character \"Harbour\" are based off what element?");
                //Sets the answer using the question object
                questions.setAnswer("Water");
                //Sets all the options as an array which is then sent to the questions class
                questions.setOptions(new String[]{"Earth", "Wind", "Fire", "Water"});
                //Stops program execution for 5 seconds to allow used to read everything.
                newQuestion = true;
            }


        }
    }


    public void textClear() {
        //Prints blank lines to basically clear the entire console
        for (int row = 1; row <= 21; row = row + 1) {
            for (int clear = 1; clear <= 2; clear = clear + 1) {
                System.out.println();
            }
        }
    }

    public void tempStop(int seconds) {
        //When given seconds, pauses execution until the set time period is over

        //Scope Variable Declaration
        int milliseconds;

        //sets the input seconds to milliseconds
        milliseconds = seconds * 1000;
        //try and catch to use .sleep for the new millisecond value
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException ie) {
        }
    }

    public void titleScreen() {
        //Prints blank lines
        System.out.println();
        System.out.println();
        //Prints title using ASCII art
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
        System.out.println("Based on the Tactical 5v5 shooter made by Riot Games!");
        System.out.println("Made by Muhammad Sheikh!");
        System.out.println();
        System.out.println();
        //Asks the user for input, takes all upper case, lower case and standard caps
        System.out.println("TYPE IN THE OPTION YOU WANT!");
        System.out.println("START");
        System.out.println("EXIT");

        //Declares scanner variable and uses previously set player start variable
        Scanner input = new Scanner(System.in);
        playerStart = input.nextLine();
        //Defaults to assuming an invalid input by the player
        boolean validInput = false;

        while (!validInput) {
            //checks if the player has entered start
            if (playerStart.equals("START") || playerStart.equals("start") || playerStart.equals("Start")) {
                //makes the input valid and exits the function
                validInput = true;
                //checks if the player has entered exit
            } else if (playerStart.equals("EXIT") || playerStart.equals("exit") || playerStart.equals("Exit")) {
                //makes the input valid
                validInput = true;
                //exits the entire program
                System.exit(0);
                //Keeps asking for valid input by the user
            } else {
                System.out.println("Please enter a valid input!");
                playerStart = input.nextLine();
            }
        }
    }

    class Questions {
        /*
        The questions class stores the questions, answers and options as private variables that can only be set and got by calling methods in this class.
        This uses encapsulation to make sure data is stored and used only when needed.
         */

        //Scope Variable Declaration
        //Declares private variables to be only used and stored in this scope such as the answer, question and options
        private String Answer;

        private String Question;

        private String QuestionOptions[];

        //When called, returns the string value of the question.
        public String getQuestion() {
            return Question;
        }

        //When called, clones the stored questions options and returns it as an array.
        public String[] getOptions() {
            String[] returnOptions = QuestionOptions.clone();
            return returnOptions;
        }

        //When given a string answer to check, uses .equals to check if the answer is correct. Returns true or false.
        public boolean checkAnswer(String toCheck) {
            //Parses the string number input to a int to check if the selected answer is correct in the options array with the stored answer.
            return Objects.equals(Answer, QuestionOptions[Integer.parseInt(toCheck)]);
        }

        //Overwrites the currently stored answer with a new string value.
        public void setAnswer(String newAnswer) {
            Answer = newAnswer;
        }

        //Overwrites the stored options by cloning a string array inputs
        public void setOptions(String[] question1Options) {
            QuestionOptions = question1Options.clone();
        }

        //Overwrites the currently stored question with a new string value.
        public void setQuestion(String newQuestion) {
            Question = newQuestion;
        }

    }

}