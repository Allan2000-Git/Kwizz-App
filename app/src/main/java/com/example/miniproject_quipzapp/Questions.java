package com.example.miniproject_quipzapp;

public class Questions
{

    public static final String CATEGORY_HISTORY = "History";
    public static final String CATEGORY_MATHS = "Maths";
    public static final String CATEGORY_SPORTS = "Graphics";
    public static final String CATEGORY_ENGLISH = "English";
    public static final String CATEGORY_COMPUTERS = "Computers";
    public static final String CATEGORY_APTITUDE = "Aptitude";
    public static final String CATEGORY_CURRENTAFFAIRS = "CurrentAffairs";
    public static final String CATEGORY_GEOGRAPHY = "Geography";

//    public static final int LEVEL1 = 1;
//    public static final int LEVEL2 = 2;
//    public static final int LEVEL3 = 3;

    private String question;
    private String option1;
    private String option2;
    private String option3;
    private String option4;
    private int answerNum;

    private String category;

    //private int levels;

    public Questions()
    {

    }

    public Questions(String question, String option1, String option2, String option3, String option4, int answerNum, String category)
    {
        this.question = question;
        this.option1 = option1;
        this.option2 = option2;
        this.option3 = option3;
        this.option4 = option4;
        this.answerNum = answerNum;
        this.category = category;
        //this.levels = levels;
    }

    public String getQuestion() {
        return question;
    }

    public String getOption1() {
        return option1;
    }

    public String getOption2() {
        return option2;
    }

    public String getOption3() {
        return option3;
    }

    public String getOption4() {
        return option4;
    }

    public int getAnswerNum() {
        return answerNum;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public void setOption1(String option1) {
        this.option1 = option1;
    }

    public void setOption2(String option2) {
        this.option2 = option2;
    }

    public void setOption3(String option3) {
        this.option3 = option3;
    }

    public void setOption4(String option4) {
        this.option4 = option4;
    }

    public void setAnswerNum(int answerNum) {
        this.answerNum = answerNum;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    /*public int getLevels() {
        return levels;
    }

    public void setLevels(int levels) {
        this.levels = levels;
    }*/
}
