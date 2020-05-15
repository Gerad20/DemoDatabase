package c346.rp.edu.demodatabase;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;

public class DBHelper extends SQLiteOpenHelper {
    private static final int DATABASE_VER = 1;
    private static final String DATABASE_name = "task.db";

    //creates the database tables name
    private static final String TABLE_TASK = "task";
    private static final String COLOUMN_ID = "_id";
    private static final String COLOUMN_DESCRIPTION = "description";
    private static final String COLOUMN_DATE = "date";



    public DBHelper(Context context){
        super(context, DATABASE_name,null , DATABASE_VER );



    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTableSql = "CREATE TABLE " + TABLE_TASK + "(" + COLOUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + COLOUMN_DESCRIPTION + " TEXT, " + COLOUMN_DATE + " TEXT ) ";
        db.execSQL(createTableSql);
        Log.i("Created?", "Created tables ");

    }
    //when Chainging the database
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldversion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_TASK);
        onCreate(db);

    }

    public void insertTask(String description, String date ){
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();

        values.put(COLOUMN_DESCRIPTION, description);
        values.put(COLOUMN_DATE, date);

        db.insert(TABLE_TASK,null,values);

        db.close();
    }
    public ArrayList<Task> getTaskContent(){
        ArrayList<Task> tasks = new ArrayList<Task>();
        String selectQuery = "SELECT *" + " FROM " + TABLE_TASK;

        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.rawQuery(selectQuery,null);
        if(cursor.moveToFirst()){
            do{
                int id = cursor.getInt(0);
                String description = cursor.getString(1);
                String date = cursor.getString(2);
                Task obj = new Task(id, description, date);
                tasks.add(obj);
            }while(cursor.moveToNext());

        }
        cursor.close();
        return tasks;
    }


}
