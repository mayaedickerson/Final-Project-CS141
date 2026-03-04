import java.util.Scanner;

public class MentalHealthQuiz {

    // NOTE; The quiz has 3 categories each with 5 questions. The user will be scored out of 15 in all 3 categories.


    // initialize quiz questions for each mental health category (Stress, Anxiety, Depression)
    private static String[] stressQuestions = {
        "I feel overwhelmed with all of my responsibilities and tasks",
        "I feel like I am unable to relax and unwind in my spare time",
        "I feel tense, restless, or physically uncomfortable due to my stress",
        "I get irritable or grouchy towards others because I am overwhelmed",
        "I feel like my life is out of control due to tasks piling up"
    };

    private static String[] anxietyQuestions = {
        "I feel nervous, anxious, or on edge even when there is no reason to be",
        "I feel unable to stop or control my worrying",
        "I lose sleep because I worry so much at night",
        "I often feel afraid as if something bad may happen at any moment",
        "I am restless, tense, or have trouble relaxing because of anxiety and constant worry",
    };

    private static String[] depressionQuestions = {
        "I generally feel down and unhappy",
        "I have a hard time finding joy in activities that I used to love",
        "I often feel so down that I have a hard time taking care of my mental/physical health, my hygiene, or my surroundings",
        "I have committed self-harm or considered self-harm",
        "I have experienced suicidal thoughts"
    };

    // Initialize scores for each mental health category
    private static int stressScore = 0;
    private static int anxietyScore = 0;
    private static int depressionScore = 0;


    // Prints the answer options for each question (each question has the same answer options: never, sometimes, often, almost always.)
    public static void printOptions() {
        System.out.println("Enter 1, 2, 3, or 4 to answer.");
        System.out.println("1. Never");
        System.out.println("2. Sometimes");
        System.out.println("3. Often");
        System.out.println("4. Almost Always");
    }

    /*
    prints the question prompt and the answer options. 
    Then, takes user int input for the answer and increments the category score by input - 1.
    Returns the category score as an int.
    */
    public static int askCategoryQuestions(String[] categoryQuestions, int categoryScore) {
        Scanner scnr = new Scanner(System.in);
        int q;
        int answer;
        for (q = 0; q < categoryQuestions.length; q++) {
            System.out.println(categoryQuestions[q]);
            printOptions();
            answer = scnr.nextInt();
            
            if (answer >= 1 && answer <= 4) {
                categoryScore += (answer - 1);
                System.out.println();
            }
            else {
                while (answer < 1 || answer > 4) {
                    System.out.println("Invalid answer. Please type a number 1-4 to select your answer.");
                    answer = scnr.nextInt();
                }
                categoryScore += (answer - 1);
            }
        }
        return categoryScore;

    }

    // Prints the category score out of 15 points.
    public static void printScore(int categoryScore) {
        System.out.println(categoryScore + "/15");
    }

    // The following evaluate methods print personalized messages based on the user score for each mental health category.
    public static void evaluateStressScores(int categoryScore) {
        String stressEval;
        if (categoryScore >= 0 && categoryScore <= 5) {
            stressEval = "Your Stress scores show that you likely have low stress levels. Great job managing stress in a healthy way!";
        }
        else if (categoryScore >= 6 && categoryScore <= 10) {
            stressEval = "Your Stress scores show that you likely have moderate stress levels. Try to set aside enough time for relaxation, exercise, and socializaion.";
        }
        else {
            stressEval = "Your Stress scores show that you are likely under severe stress. When overwhelmed, prioritize immediate calming techniques like breathing and grounding exercises.";
        }
        System.out.println(stressEval);
    }

    public static void evaluateAnxietyScores(int categoryScore) {
        String anxietyEval;
        if (categoryScore >= 0 && categoryScore <= 5) {
            anxietyEval = "Your Anxiety scores show that you likely have low anxiety levels. Great job staying calm and collected!";
        }
        else if (categoryScore >= 6 && categoryScore <= 10) {
            anxietyEval = "Your Anxiety scores show that you likely have moderate anxiety levels. Deep breathing, journaling, or support groups can help declutter your mind.";
        }
        else {
            anxietyEval = "Your Anxiety scores show that you likely have severe anxiety. Use grounding techniques in moments of high anxiety. Consulting a medical professional is recommended.";
        }

        System.out.println(anxietyEval);
    }

    public static void evaluateDepressionScores(int categoryScore) {
        String depressionEval;
        if (categoryScore >= 0 && categoryScore <= 5) {
            depressionEval = "Your Depression scores show that you likely are not depressed. Keep up the good work and stay smiling :)";
        }
        else if (categoryScore >= 6 && categoryScore <= 10) {
            depressionEval = "Your Depression scores show that there is a moderate chance of depression. Stay connected - Don't be afraid to reach out to friends and family.";
        }
        else {
            depressionEval = "Your Depression scores show that there is a likelihood of severe depression. Please seek immediate professional care and reach out to loved ones.";
            
        }
        System.out.println(depressionEval);
    }


    /* 
    IMPORTANT: Calling the takeStressCheck method starts the quiz. 
    Calls askCategoryQuestions for each mental health category.
    Prints score for each category and gives personalized commentary on score using evaluate methods.
    */
    public static void takeStressCheck() {
        System.out.println("This quiz is for educational purposes only, it is not a diagnostic tool.");
        System.out.println();
        stressScore = askCategoryQuestions(stressQuestions, stressScore);
        anxietyScore = askCategoryQuestions(anxietyQuestions, anxietyScore);
        depressionScore = askCategoryQuestions(depressionQuestions, depressionScore);

        System.out.print("Your stress score: ");
        printScore(stressScore);

        System.out.print("Your anxiety score: ");
        printScore(anxietyScore);

        System.out.print("Your depression score: ");
        printScore(depressionScore);
        
        System.out.println();

        evaluateStressScores(stressScore);
        evaluateAnxietyScores(anxietyScore);
        evaluateDepressionScores(depressionScore);

            System.out.println();
            System.out.println("Mental Health/Suicide Crisis Hotline: Call 988!");
            System.out.println();
        }
    }