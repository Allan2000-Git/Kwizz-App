package com.example.miniproject_quipzapp;

import android.provider.BaseColumns;

public final class QuizContract {

    public QuizContract() {
    }

    public static class QuestionTable implements BaseColumns
    {

        public static final String TABLE_NAME = "quiz_questions"; //constant to create a table
        public static final String COLUMN_QUESTION = "questions"; //constant to create a column
        public static final String COLUMN_OPTION1 = "option1"; //constant to create a column for option1
        public static final String COLUMN_OPTION2 = "option2"; //constant to create a column for option2
        public static final String COLUMN_OPTION3 = "option3"; //constant to create a column for option3
        public static final String COLUMN_OPTION4 = "option4"; //constant to create a column for option4
        public static final String COLUMN_ANSWER_NUM = "answer_num";

        public static final String COLUMN_CATEGORY = "category";

        //public static final String COLUMN_LEVELS_ID = "levelsid";

         //BaseColumns : The BaseColumns interface provides names for the very common _ID and _COUNT columns.
        //Using common names enables the Android platform (and developers as well) to address any data item,
        // regardless of its overall structure (i.e. other, non-ID columns) in a unified way.
        // Defining constants for commonly used strings in an interface/class avoids repetition and typos all over the code.
    }
}
