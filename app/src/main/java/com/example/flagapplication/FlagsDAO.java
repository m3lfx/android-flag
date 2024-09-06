package com.example.flagapplication;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

public class FlagsDAO {
    public ArrayList<FlagModel> getRandomTenQuestion(FlagsDatabase fd)
    {
        ArrayList<FlagModel> modelArrayList = new ArrayList<>();
        SQLiteDatabase liteDatabase = fd.getWritableDatabase();
        Cursor cursor = liteDatabase.rawQuery("SELECT * FROM flagquizgametable ORDER BY RANDOM () LIMIT 10",null);

        int flagIdIndex = cursor.getColumnIndex("flag_id");
        int flagNameIndex = cursor.getColumnIndex("flag_name");
        int flagImageIndex = cursor.getColumnIndex("flag_image");

        while (cursor.moveToNext())
        {
            FlagModel model = new FlagModel(cursor.getInt(flagIdIndex)
                    ,cursor.getString(flagNameIndex)
                    ,cursor.getString(flagImageIndex));

            modelArrayList.add(model);
        }
        return modelArrayList;
    }

    public ArrayList<FlagModel> getRandomThreeOptions(FlagsDatabase fd, int flag_id)
    {
        ArrayList<FlagModel> modelArrayList = new ArrayList<>();
        SQLiteDatabase liteDatabase = fd.getWritableDatabase();
        Cursor cursor = liteDatabase.rawQuery("SELECT * FROM flagquizgametable WHERE flag_id !="+flag_id+" ORDER BY RANDOM () LIMIT 3",null);

        int flagIdIndex = cursor.getColumnIndex("flag_id");
        int flagNameIndex = cursor.getColumnIndex("flag_name");
        int flagImageIndex = cursor.getColumnIndex("flag_image");

        while (cursor.moveToNext())
        {
            FlagModel model = new FlagModel(cursor.getInt(flagIdIndex)
                    ,cursor.getString(flagNameIndex)
                    ,cursor.getString(flagImageIndex));

            modelArrayList.add(model);
        }
        return modelArrayList;
    }
}
