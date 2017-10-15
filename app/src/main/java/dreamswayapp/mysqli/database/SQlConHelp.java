//package dreamswayapp.mysqli;
//
//import android.content.ContentValues;
//import android.content.Context;
//import android.database.Cursor;
//import android.database.sqlite.SQLiteDatabase;
//import android.database.sqlite.SQLiteOpenHelper;
//
//import java.util.ArrayList;
//
///**
// * Created by Pratik on 8/10/2017.
// */
//
//public class SQlConHelp {
//
//    public final String DB_nme="My_db";
//    public final String Tbl_name="emptbl";
//    public final String emp_pk="empid";
//    public final String emp_name="empname";
//    public final String emp_email="empemail";
//    public final String emp_pass="emppass";
//
//    Context context;
//    SQLiteDatabase sqLiteDatabase;
//
//    class Sqlconnection extends SQLiteOpenHelper {
//
//
//        public Sqlconnection(Context context) {
//            super(context,DB_nme,null,1);
//        }
//
//
//        @Override
//        public void onCreate(SQLiteDatabase db) {
//            String creat_tbl=" CREATE TABLE "+Tbl_name+" ("
//                    +emp_pk+" integer primary key autoincrement ,"
//                    +emp_name+" text,"
//                    +emp_email+" text,"
//                    +emp_pass+" text)";
//
//            db.execSQL(creat_tbl);
//
//        }
//
//        @Override
//        public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
//
//        }
//    }
//
//    SQlConHelp(Context context)
//    {
//        this.context=context;
//    }
//
//    public void open_DB()
//    {
//        sqLiteDatabase=new Sqlconnection(context).getWritableDatabase();
//    }
//
//    public void close_DB()
//    {
//        if(sqLiteDatabase.isOpen() && sqLiteDatabase!=null)
//        {
//            sqLiteDatabase.close();
//        }
//    }
//
//    public long insertregdata(RegistrationTbl reg)
//    {
//        ContentValues contentValues=new ContentValues();
//        contentValues.put(emp_name,reg.getEmpname());
//        contentValues.put(emp_email,reg.getEmpemail());
//        contentValues.put(emp_pass,reg.getEmppass());
//
//       return sqLiteDatabase.insert(Tbl_name,null,contentValues);
//    }
//
//    public ArrayList<RegistrationTbl> selectfulldata()
//    {
//        ArrayList<RegistrationTbl> arlist=new ArrayList<>();
//
//        Cursor cursor=sqLiteDatabase.query(Tbl_name,null,null,null,null,null,null,null);
//
//        while(cursor.moveToNext())
//        {
//            int pk=cursor.getInt(cursor.getColumnIndex(emp_pk));
//            String name=cursor.getString(cursor.getColumnIndex(emp_name));
//            String email=cursor.getString(cursor.getColumnIndex(emp_email));
//            String pass=cursor.getString(cursor.getColumnIndex(emp_pass));
//
//            RegistrationTbl registrationTbl=new RegistrationTbl(0,name,email,pass);
//
//            arlist.add(registrationTbl);
//        }
//
//
//
//        return arlist;
//    }
//
//}
