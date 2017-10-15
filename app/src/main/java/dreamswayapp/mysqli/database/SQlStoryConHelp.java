package dreamswayapp.mysqli.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

import dreamswayapp.mysqli.database.StoryTbl;

/**
 * Created by Pratik on 8/10/2017.
 */

public class SQlStoryConHelp {

    public final String DB_nme="Story_db";
    public final String Tbl_name="StoryTbl";
    public final String Story_pk="storyid";
    public final String Story_Title="storytitle";
    public final String Story_Data="storydata";

    Context context;
    SQLiteDatabase sqLiteDatabase;

    class Sqlconnection extends SQLiteOpenHelper {


        public Sqlconnection(Context context) {
            super(context,DB_nme,null,1);
        }


        @Override
        public void onCreate(SQLiteDatabase db) {
            String creat_tbl=" CREATE TABLE "+Tbl_name+" ("
                    +Story_pk+" integer primary key autoincrement ,"
                    +Story_Title+" text,"
                    +Story_Data+" text)";
            db.execSQL(creat_tbl);

        }

        @Override
        public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

        }
    }

    public SQlStoryConHelp(Context context)
    {
        this.context=context;
    }

    public void open_DB()
    {
        sqLiteDatabase=new Sqlconnection(context).getWritableDatabase();
    }

    public void close_DB()
    {
        if(sqLiteDatabase.isOpen() && sqLiteDatabase!=null)
        {
            sqLiteDatabase.close();
        }
    }

    public long insertregdata(StoryTbl reg)
    {
        ContentValues contentValues=new ContentValues();
        contentValues.put(Story_Title,reg.getStoryTitle());
        contentValues.put(Story_Data,reg.getStoryData());

       return sqLiteDatabase.insert(Tbl_name,null,contentValues);
    }

    public ArrayList<StoryTbl> selectfulldata()
    {
        ArrayList<StoryTbl> arlist=new ArrayList<>();

        Cursor cursor=sqLiteDatabase.query(Tbl_name,null,null,null,null,null,null,null);

        while(cursor.moveToNext())
        {
            int pk=cursor.getInt(cursor.getColumnIndex(Story_pk));
            String title=cursor.getString(cursor.getColumnIndex(Story_Title));
            String data=cursor.getString(cursor.getColumnIndex(Story_Data));

            StoryTbl storyTbl=new StoryTbl(pk,title,data);

            arlist.add(storyTbl);
        }



        return arlist;
    }

}
