package poclin.carlos.clase3_proyecto1;


import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import poclin.carlos.clase3_proyecto1.model.UserModel;

public class MySQLiteOpenHelper extends SQLiteOpenHelper{

    private static final String TAG = "MySQLiteOpenHelper";

    public static final String NOMBRE_DE = "mydb.db";
    public static final Integer VERSION_DE = 2;

    private static StringBuilder sbCreateTableUserSQL = new StringBuilder()
            .append("CREATE TABLE" + UserModel.TABLE_NAME+" ( ")
            .append(UserModel.NAMES_FIELD+ " TEXT PRIMARY KEY, ")
            .append(UserModel.AP_FIELD + " TEXT, ")
            .append(UserModel.AM_FIELD + " TEXT, ")
            .append(UserModel.CORREO_FIELD + " TEXT, ")
            .append(UserModel.PASS_FIELD + " TEXT ) ");
    public MySQLiteOpenHelper(Context context){
        super(context,NOMBRE_DE,null,VERSION_DE);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        //Crear base de datos
        Log.d(TAG, "onCreate(database)");
        sqLiteDatabase.execSQL(sbCreateTableUserSQL.toString());
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        //select a todas las tablas
        //3 alter table, 2 create table, 1 drop table
        //obtengo la info del backup
    }
}
