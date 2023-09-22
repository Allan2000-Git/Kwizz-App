package com.example.miniproject_quipzapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.example.miniproject_quipzapp.QuizContract.*;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class QuizDbHelper extends SQLiteOpenHelper
{
    private static final String DATABASE_NAME = "Quizzy";
    private static final int DATABASE_VERSION = 3;
    private SQLiteDatabase db;

    public QuizDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        this.db=db;

        final String SQL_QUESTIONS_TABLE_CREATION = " CREATE TABLE " +
                QuestionTable.TABLE_NAME + " ( " +
                QuestionTable._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                QuestionTable.COLUMN_QUESTION + " TEXT, " +
                QuestionTable.COLUMN_OPTION1 + " TEXT, " +
                QuestionTable.COLUMN_OPTION2 + " TEXT, " +
                QuestionTable.COLUMN_OPTION3 + " TEXT, " +
                QuestionTable.COLUMN_OPTION4 + " TEXT, " +
                QuestionTable.COLUMN_ANSWER_NUM + " INTEGER, " +
                QuestionTable.COLUMN_CATEGORY + " TEXT " +
                ")";

        db.execSQL(SQL_QUESTIONS_TABLE_CREATION);

        fillQuestionsTable(); //once db is created we call this function so that it loads all the questions to be displayed on the screen.

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(" DROP TABLE IF EXISTS " + QuestionTable.TABLE_NAME);
        onCreate(db);
    }

    //to fill questions to the questions table
    private void fillQuestionsTable()
    {
        //------------------------------------COMPUTERS-----------------------------------
        Questions q1 = new Questions("Which of the following statement is correct?","1 KB = 1024 bytes","1 MB=2048 bytes","1 MB = 1000 kilobytes","1 KB = 1000 bytes",1, Questions.CATEGORY_COMPUTERS);
        addQuestions(q1);


        Questions q2 = new Questions("The fourth generation computers are based on","Transistor","Integrated circuit"," VLSI microprocessor","ULSI microprocessor",3, Questions.CATEGORY_COMPUTERS);
        addQuestions(q2);


        Questions q3 = new Questions("A CD-RW has a speed rating of 12x 10x 32x. What do the three numbers refer to in order?","Write, rewrite, read","Read, write, rewrite","Rewrite, read, write","Write, read, rewrite",1, Questions.CATEGORY_COMPUTERS);
        addQuestions(q3);


        Questions q4 = new Questions("Malware is the short form for malicious software and used to refer to","Spyware","Worm","Virus","All of the above",4, Questions.CATEGORY_COMPUTERS);
        addQuestions(q4);


        Questions q5 = new Questions("The computer language used for artificial intelligence is","FOTRAN","C","PROLOG","COBOL",2, Questions.CATEGORY_COMPUTERS);
        addQuestions(q5);


        Questions q6 = new Questions("A standard computer keyboard has how many keys?","104","84","94","114",1, Questions.CATEGORY_COMPUTERS);
        addQuestions(q6);

        Questions q6_1 = new Questions("Computer Moniter is also known as :","UVD","DVU","VDU","CCTV",3, Questions.CATEGORY_COMPUTERS);
        addQuestions(q6_1);

        //------------------------------------MATHS-----------------------------------

        Questions q7 = new Questions("1 + 1 = ? ","0","11","2","21",3, Questions.CATEGORY_MATHS);
        addQuestions(q7);

        Questions q8 = new Questions("From the following numbers, which number is not a rational number?","PI","22/7","3/4","0.666666",1, Questions.CATEGORY_MATHS);
        addQuestions(q8);

        Questions q9 = new Questions("What is the rate of discount if a car which price was $4,000 was sold for $3,200 ?","14%","16%","18%","20%",4, Questions.CATEGORY_MATHS);
        addQuestions(q9);

        Questions q91 = new Questions("If David’s age is 27 years old in 2011. What was his age in 2003?","17 years","37 years","20 years","19 years",4, Questions.CATEGORY_MATHS);
        addQuestions(q91);

        Questions q92 = new Questions("In a century how many months are there?","12","120","1200","12000",3, Questions.CATEGORY_MATHS);
        addQuestions(q92);

        Questions q93 = new Questions("10-2 means","milli","centi","micro","deci",2, Questions.CATEGORY_MATHS);
        addQuestions(q93);


        //------------------------------------HISTORY-----------------------------------

        Questions q10 = new Questions("'Ayurveda' has its origin in","Rig Veda","Sama Veda","Yajur Veda","Atharva Veda",4, Questions.CATEGORY_HISTORY);
        addQuestions(q10);

        Questions q11 = new Questions("The Vedic deity Indra was the god of","Fire","Rain and Thunder","Eternity","Wind",2, Questions.CATEGORY_HISTORY);
        addQuestions(q11);

        Questions q12 = new Questions("Which was the first State to be created on linguistic basis ?","Andhra State","Madras","Karnataka","Gujarath",1, Questions.CATEGORY_HISTORY);
        addQuestions(q12);

        Questions q13 = new Questions("Who first imposed Jizya Tax in India?","Allaudin khilji","Qutb-ud-din Aibak","Mohammad Bin Qasim","Aurangzeb",2, Questions.CATEGORY_HISTORY);
        addQuestions(q13);

        Questions q14 = new Questions("The word Gotra occurs for the first time in","Yajur Veda","Sama Veda","Rig Veda","Atharva Veda",3, Questions.CATEGORY_HISTORY);
        addQuestions(q14);

        Questions q15 = new Questions("The first Mughal building with complete marble facing was","Humayun's tomb","Itmad-ud-daulah's tomb\n","Taj Mahal","Moti Masjid",1, Questions.CATEGORY_HISTORY);
        addQuestions(q15);

        //------------------------------------ENGLISH-----------------------------------

        Questions q16 = new Questions("Antonym of the word: VANITY","Pride","Humility","Conceit","Ostentatious",2, Questions.CATEGORY_ENGLISH);
        addQuestions(q16);

        Questions q17 = new Questions("Antonym of the word: TACITURN","Judge","Silent","Talkative","Immense",3, Questions.CATEGORY_ENGLISH);
        addQuestions(q17);

        Questions q18 = new Questions("Synonym of the word: DIVERSION","Distortion","Change","Deviation","Amusement",1, Questions.CATEGORY_ENGLISH);
        addQuestions(q18);

        Questions q19 = new Questions("Synonym of the word: AUGUST","Petty","Ridiculous","Common","Dignified",4, Questions.CATEGORY_ENGLISH);
        addQuestions(q19);

        Questions q20 = new Questions("A person who insists on something is called ?","Disciplinarian","Stickler","Instantaneous","Boaster",2, Questions.CATEGORY_ENGLISH);
        addQuestions(q20);

        Questions q21 = new Questions("A remedy for all diseases is called ?","Stoic","Recompense","Marvel","Panacea",4, Questions.CATEGORY_ENGLISH);
        addQuestions(q21);

        //------------------------------------SPORTS-----------------------------------

        Questions q22 = new Questions("Ryder cup is related to which sports?","Polo","Golf","Tennis","Lawn Tennis",2, Questions.CATEGORY_SPORTS);
        addQuestions(q22);

        Questions q23 = new Questions("Where were the first Summer Olympics held?","Singapore","South Korea","Germany","Greece",4, Questions.CATEGORY_SPORTS);
        addQuestions(q23);

        Questions q24 = new Questions("In which place, the first modern Olympic Games was held?","Paris","Athens","Berlin","Amsterdam",2, Questions.CATEGORY_SPORTS);
        addQuestions(q24);

        Questions q25 = new Questions("Which country will host the 2022 Asian Games?","China","India","Japan","Netherlands",1, Questions.CATEGORY_SPORTS);
        addQuestions(q25);

        Questions q26 = new Questions("Which sport’s competition is known as the “Curtis Cup”?","Squash","Cricket","Golf","Polo",3, Questions.CATEGORY_SPORTS);
        addQuestions(q26);

        Questions q27 = new Questions("Which sport’s three main play styles are outside fighter, brawler, and inside fighter?","Weightlifting","Archery","Wrestling","Boxing",4, Questions.CATEGORY_SPORTS);
        addQuestions(q27);

        //------------------------------------CURRENT AFFAIRS-----------------------------------

        Questions q28 = new Questions("As per a recent study, Pathogens named as critical by the WHO is found in which river?","Ganges","Yamuna","Krishna","Kaveri",2, Questions.CATEGORY_CURRENTAFFAIRS);
        addQuestions(q28);

        Questions q29 = new Questions("Where is India’s first multi-modal logistics park being set up?","Andhra Pradesh","West Bengal","Kerala","Assam",4, Questions.CATEGORY_CURRENTAFFAIRS);
        addQuestions(q29);

        Questions q30 = new Questions("Megascope, which was seen in news recently, has been launched by which organisation?","NITI Aayog","Reserve Bank of India","IIT Alumni Council","NABARD",3, Questions.CATEGORY_CURRENTAFFAIRS);
        addQuestions(q30);

        Questions q31 = new Questions("‘Basaveshwara’ is a famous statesman-saint of which Indian state/UT?","Karnataka","Tamil Nadu","Andhra Pradesh","Kerala",1, Questions.CATEGORY_CURRENTAFFAIRS);
        addQuestions(q31);

        Questions q32 = new Questions("In which year was the Indus water Treaty signed between India and Pakistan?","1991","1950","1960","1947",3, Questions.CATEGORY_CURRENTAFFAIRS);
        addQuestions(q32);

        Questions q33 = new Questions("Which mapping company has integrated into the Government’s Co-WIN portal?","Zee Maps","MapMyIndia","Google Maps","Yahoo Find",2, Questions.CATEGORY_CURRENTAFFAIRS);
        addQuestions(q33);

        //------------------------------------GE0GRAPHY-----------------------------------

        Questions q34 = new Questions("Slate is an example of:","Igneous rock","Metamorphic rock","Sedimentary rock","Intrusive igneous rock",2, Questions.CATEGORY_GEOGRAPHY);
        addQuestions(q34);

        Questions q35 = new Questions("The logo of World Wildlife Fund (WWF) is depicts which among the following animals?","Panda","Polar Bear","Tiger","Stag",1, Questions.CATEGORY_GEOGRAPHY);
        addQuestions(q35);

        Questions q36 = new Questions("Rhodesia is the old name of ?","Zaire","Malawi","Switzerland","Zimbabwe",4, Questions.CATEGORY_GEOGRAPHY);
        addQuestions(q36);

        Questions q37 = new Questions("What is the name of the first white dwarf to be discovered?","Procyon B","Betelgeuse","Sirius B","Eridani B",3, Questions.CATEGORY_GEOGRAPHY);
        addQuestions(q37);

        Questions q38 = new Questions("Which planet is also called as the winter planet?","Jupiter","Uranus","Neptune","Mercury",1, Questions.CATEGORY_GEOGRAPHY);
        addQuestions(q38);

        Questions q39 = new Questions("Which among the following landforms is also called as sheepback?","Hogback","Roche moutonnee","Ergs","Inselbergs",2, Questions.CATEGORY_GEOGRAPHY);
        addQuestions(q39);

        //------------------------------------APTITUDE-----------------------------------

        Questions q40 = new Questions("What will be the fraction of 20% ?","1/4","1/5","1/10","None of the above",2, Questions.CATEGORY_APTITUDE);
        addQuestions(q40);

        Questions q41 = new Questions("Find the third proportional to 9 and 12 ?","9","108","16","48",3, Questions.CATEGORY_APTITUDE);
        addQuestions(q41);

        Questions q42 = new Questions("Find the value of 1/(3+1/(3+1/(3-1/3)))","27/89","10/3","3/10","89/27",1, Questions.CATEGORY_APTITUDE);
        addQuestions(q42);

        Questions q43 = new Questions("(256)^0.16 x (256)^0.09 = ?","16","64","256.25","4",4, Questions.CATEGORY_APTITUDE);
        addQuestions(q43);

        Questions q44 = new Questions("Find the simple interest on Rs.500 for 9 months at 6 paisa per month ?","324","275","270","345",3, Questions.CATEGORY_APTITUDE);
        addQuestions(q44);

        Questions q45 = new Questions("A number exceeds by 25 from its 3/8 part. Then the number is ?","39","32","270","35",2, Questions.CATEGORY_APTITUDE);
        addQuestions(q45);

        Questions q46 = new Questions("LCM of 87 and 145 is :","48","875","1305","435",4, Questions.CATEGORY_APTITUDE);
        addQuestions(q46);

        Questions q47 = new Questions("Find the roots of the quadratic equation: x2 + 2x - 15 = 0.","(-5,3)","(3,5)","(-3,5)","(-3,-5)",1, Questions.CATEGORY_APTITUDE);
        addQuestions(q47);

        Questions q48 = new Questions("Average of all prime numbers between 30 to 50 is","37","39.8","37.8","39",2, Questions.CATEGORY_APTITUDE);
        addQuestions(q48);

        Questions q49 = new Questions("Which header file is required to use setw() function?","conio.h","iostream.h","stdlib.h","iomanip.h",4, Questions.CATEGORY_APTITUDE);
        addQuestions(q49);

        Questions q50 = new Questions("Which is not a bitwise operator?","&","<<","&&","|",3, Questions.CATEGORY_APTITUDE);
        addQuestions(q50);

        Questions q51 = new Questions("int x = 10 ^ 2. What will be the value of x ?","5","8","7","6",2, Questions.CATEGORY_APTITUDE);
        addQuestions(q51);

        Questions q52 = new Questions("Left shift (<<) and Right shift (>>) operators are equivalent to _____________ by 2.","Division & Multiplication","Multiplication & Remainder","Multiplication & Division","Remainder & Multiplication",3, Questions.CATEGORY_APTITUDE);
        addQuestions(q52);

        Questions q53 = new Questions("Which is an incorrect declaration of one dimensional array ?","int x[5]={1,2,3,4,5};","int x[5]={1,2};","int x[5];","int x[];",4, Questions.CATEGORY_APTITUDE);
        addQuestions(q53);

    }

    //to create questions table
    private void addQuestions(Questions questions)
    {
        ContentValues cv = new ContentValues(); //it is used to add values to database table
        cv.put(QuestionTable.COLUMN_QUESTION,questions.getQuestion());
        cv.put(QuestionTable.COLUMN_OPTION1,questions.getOption1());
        cv.put(QuestionTable.COLUMN_OPTION2,questions.getOption2());
        cv.put(QuestionTable.COLUMN_OPTION3,questions.getOption3());
        cv.put(QuestionTable.COLUMN_OPTION4,questions.getOption4());
        cv.put(QuestionTable.COLUMN_ANSWER_NUM,questions.getAnswerNum());
        cv.put(QuestionTable.COLUMN_CATEGORY,questions.getCategory());
        //cv.put(QuestionTable.COLUMN_LEVELS_ID,questions.getLevels());

        db.insert(QuestionTable.TABLE_NAME,null,cv);
    }

    public ArrayList<Questions> getAllQuestions()
    {
        ArrayList<Questions> questionsList = new ArrayList<>();

        db=getReadableDatabase();

        String Display[]={
                QuestionTable._ID,
                QuestionTable.COLUMN_QUESTION,
                QuestionTable.COLUMN_OPTION1,
                QuestionTable.COLUMN_OPTION2,
                QuestionTable.COLUMN_OPTION3,
                QuestionTable.COLUMN_OPTION4,
                QuestionTable.COLUMN_ANSWER_NUM
        };

        Cursor cursor = db.query(QuestionTable.TABLE_NAME,
                Display,
                null,
                null,
                null,
                null,
                null);

        //if there is already an entry then we are making it as first entry
        if(cursor.moveToFirst())
        {
            //remaining entries, we are making as second,third and so forth
            //this will put the questions in their respective table, so continue to execute until all the questions given above are filled.
            do {
                Questions questions = new Questions();
                questions.setQuestion(cursor.getString(cursor.getColumnIndex(QuestionTable.COLUMN_QUESTION)));
                questions.setOption1(cursor.getString(cursor.getColumnIndex(QuestionTable.COLUMN_OPTION1)));
                questions.setOption2(cursor.getString(cursor.getColumnIndex(QuestionTable.COLUMN_OPTION2)));
                questions.setOption3(cursor.getString(cursor.getColumnIndex(QuestionTable.COLUMN_OPTION3)));
                questions.setOption4(cursor.getString(cursor.getColumnIndex(QuestionTable.COLUMN_OPTION4)));
                questions.setAnswerNum(cursor.getInt(cursor.getColumnIndex(QuestionTable.COLUMN_ANSWER_NUM)));

                questionsList.add(questions);

            }while (cursor.moveToNext());

        }
        cursor.close(); // we close the cursor so that it does not occupy extra memory in db
        return questionsList;
    }

    public ArrayList<Questions> getAllQuestionsCategory(String category)
    {
        ArrayList<Questions> questionsList = new ArrayList<>();

        db=getReadableDatabase();

        String Display[]={
                QuestionTable._ID,
                QuestionTable.COLUMN_QUESTION,
                QuestionTable.COLUMN_OPTION1,
                QuestionTable.COLUMN_OPTION2,
                QuestionTable.COLUMN_OPTION3,
                QuestionTable.COLUMN_OPTION4,
                QuestionTable.COLUMN_ANSWER_NUM,
                QuestionTable.COLUMN_CATEGORY
        };

        //sets the category to selection. So that selected category questions appear
        String selection = QuestionTable.COLUMN_CATEGORY + " = ? ";
        String selectionArgs[] = {category};

        Cursor cursor = db.query(QuestionTable.TABLE_NAME,
                Display,
                selection,
                selectionArgs,
                null,
                null,
                null);

        //if there is already an entry then we are making it as first entry
        if(cursor.moveToFirst())
        {
            //remaining entries, we are making as second,third and so forth
            //this will put the questions in their respective table, so continue to execute until all the questions given above are filled.
            do {
                Questions questions = new Questions();
                questions.setQuestion(cursor.getString(cursor.getColumnIndex(QuestionTable.COLUMN_QUESTION)));
                questions.setOption1(cursor.getString(cursor.getColumnIndex(QuestionTable.COLUMN_OPTION1)));
                questions.setOption2(cursor.getString(cursor.getColumnIndex(QuestionTable.COLUMN_OPTION2)));
                questions.setOption3(cursor.getString(cursor.getColumnIndex(QuestionTable.COLUMN_OPTION3)));
                questions.setOption4(cursor.getString(cursor.getColumnIndex(QuestionTable.COLUMN_OPTION4)));
                questions.setAnswerNum(cursor.getInt(cursor.getColumnIndex(QuestionTable.COLUMN_ANSWER_NUM)));
                questions.setCategory(cursor.getString(cursor.getColumnIndex(QuestionTable.COLUMN_CATEGORY)));

                questionsList.add(questions);

            }while (cursor.moveToNext());

        }
        cursor.close(); // we close the cursor so that it does not occupy extra memory in db
        return questionsList;
    }
}
