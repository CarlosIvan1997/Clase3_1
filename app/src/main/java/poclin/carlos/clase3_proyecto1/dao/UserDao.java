package poclin.carlos.clase3_proyecto1.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

import poclin.carlos.clase3_proyecto1.MySQLiteOpenHelper;
import poclin.carlos.clase3_proyecto1.model.UserModel;

/**
 * Created by Alumno on 24/09/2017.
 */

public class UserDao {

    private MySQLiteOpenHelper sqLiteOpenHelper;
    private SQLiteDatabase sqLiteDatabase;

    public UserDao(Context context) {
        this.sqLiteOpenHelper=new MySQLiteOpenHelper(context);
        this.sqLiteDatabase=sqLiteOpenHelper.getWritableDatabase();
    }

    public long insertarUser(UserModel user){

        ContentValues valoresInsertar = new ContentValues();
        valoresInsertar.put(UserModel.NAMES_FIELD,user.getNombres());
        valoresInsertar.put(UserModel.AP_FIELD,user.getApellidoPaterno());
        valoresInsertar.put(UserModel.AM_FIELD,user.getApellidoMaterno());
        valoresInsertar.put(UserModel.CORREO_FIELD,user.getCorreo());
        valoresInsertar.put(UserModel.PASS_FIELD,user.getPass());

        long result = sqLiteDatabase.insert(UserModel.TABLE_NAME, null, valoresInsertar);

        return result;
    }

    public int actualizarUser(UserModel user){

        ContentValues valoresActualizar = new ContentValues();
        valoresActualizar.put(UserModel.AP_FIELD,user.getApellidoPaterno());
        valoresActualizar.put(UserModel.AM_FIELD,user.getApellidoMaterno());
        valoresActualizar.put(UserModel.CORREO_FIELD,user.getCorreo());
        valoresActualizar.put(UserModel.PASS_FIELD,user.getPass());

        String whereClause = UserModel.NAMES_FIELD+"=?";

        String [] whereArgs = {user.getNombres()};

        //Retorna la cantidad de filas actulizadas
        //Retorna 0 si no actualizado nada
        int resultado = sqLiteDatabase.update(UserModel.TABLE_NAME, valoresActualizar, whereClause, whereArgs);

        return resultado;
    }

    public int eliminarUser (UserModel user){

        String whereClause = UserModel.NAMES_FIELD+"=?";

        String [] whereArgs = {user.getNombres()};

        int resultado = sqLiteDatabase.delete(UserModel.TABLE_NAME,whereClause,whereArgs);

        return resultado;
    }

    public List<UserModel> obtenerUsers (){

        String [] fields = {
                UserModel.NAMES_FIELD,
                UserModel.AP_FIELD,
                UserModel.AM_FIELD,
                UserModel.CORREO_FIELD,
                UserModel.PASS_FIELD};

        Cursor cursor = sqLiteDatabase.query(UserModel.TABLE_NAME,fields,null,null,null,null,null);

        return convertCursorToList(cursor);
    }

    private List<UserModel> convertCursorToList (Cursor mCursor){
        List<UserModel> arrList = new ArrayList<>();
        if (mCursor.moveToFirst()){
            do{
                UserModel model = new UserModel();
                model.setNombres(mCursor.getString(mCursor.getColumnIndex(UserModel.NAMES_FIELD)));
                model.setApellidoPaterno(mCursor.getString(mCursor.getColumnIndex(UserModel.AP_FIELD)));
                model.setApellidoMaterno(mCursor.getString(mCursor.getColumnIndex(UserModel.AM_FIELD)));
                model.setCorreo(mCursor.getString(mCursor.getColumnIndex(UserModel.CORREO_FIELD)));
                model.setPass(mCursor.getString(mCursor.getColumnIndex(UserModel.PASS_FIELD)));

                //model.(msetCodigoCursor.getInt(mCursor.getColumnIndex(UserModel.COD_FIELD)));

                arrList.add(model);
            }while (mCursor.moveToNext());
        }
        return arrList;
    }
}
