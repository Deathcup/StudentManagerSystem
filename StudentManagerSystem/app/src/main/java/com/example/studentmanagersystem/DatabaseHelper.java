package com.example.studentmanagersystem;

import android.content.Context;
import android.database.sqlite.*;

import androidx.annotation.Nullable;

public class DatabaseHelper extends SQLiteOpenHelper {

    public DatabaseHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //数据库建立
        db.execSQL("CREATE TABLE information(\n" +
                "             id INTEGER PRIMARY KEY NOT NULL,\n" +
                "             name TEXT NOT NULL,\n" +
                "             sex TEXT NOT NULL,\n" +
                "             native TEXT NOT NULL,\n" +
                "             score INTEGER NOT NULL\n" +
                "             )");
//        db.execSQL("INSERT into information(id,name,sex,native,score) VALUES (20184229,\"张三\",\"男\",\"山东\",98);");
//        db.execSQL("INSERT into information(id,name,sex,native,score) VALUES (20184228,\"李四\",\"男\",\"辽宁\",100);");
//        db.execSQL("INSERT into information(id,name,sex,native,score) VALUES (20184230,\"李妮\",\"女\",\"湖南\",88);");
//        db.execSQL("INSERT into information(id,name,sex,native,score) VALUES (20184233,\"王剪\",\"女\",\"重庆\",85);");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
