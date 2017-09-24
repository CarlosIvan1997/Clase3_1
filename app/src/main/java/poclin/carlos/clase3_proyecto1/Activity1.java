package poclin.carlos.clase3_proyecto1;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import poclin.carlos.clase3_proyecto1.dao.UserDao;
import poclin.carlos.clase3_proyecto1.model.UserModel;

public class Activity1 extends AppCompatActivity {

    private static final String TAG = "Activity1";
    private UserDao userDao;

    @BindView(R.id.tv_1)
    TextView tv1;
    @BindView(R.id.et_nombres)
    EditText etNombres;
    @BindView(R.id.et_ap)
    EditText etAp;
    @BindView(R.id.et_am)
    EditText etAm;
    @BindView(R.id.et_correo)
    EditText etCorreo;
    @BindView(R.id.et_password)
    EditText etPassword;
    @BindView(R.id.iv_1)
    ImageView iv1;
    @BindView(R.id.btn_guardar)
    Button btnGuardar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_1);

        ButterKnife.bind(this);

        /*String query = "select sqlite_version() AS sqlite_version";
        SQLiteDatabase db = SQLiteDatabase.openOrCreateDatabase(":memory:", null);
        Cursor cursor = db.rawQuery(query, null);
        String sqliteVersion = "";
        if (cursor.moveToNext()) {
            sqliteVersion = cursor.getString(0);
        }

        Log.v("Activity1",sqliteVersion);*/

        MySQLiteOpenHelper openHelper = new MySQLiteOpenHelper(this);

        userDao = new UserDao(this);

        UserModel user = new UserModel();
        user.setNombres("Carlos");
        user.setApellidoMaterno("Meza");
        user.setApellidoPaterno("Poclin");
        user.setCorreo("carlos@poclin.com");
        user.setPass("1234");

        long result = userDao.insertarUser(user);

        if(result != -1){
            Log.i(TAG,"EXITO");
        }else{
            Log.v(TAG,"ERROR");
        }
    }

    @OnClick(R.id.btn_guardar)
    public void onViewClicked() {
        Toast.makeText(this, "Hola", Toast.LENGTH_SHORT).show();
    }
}
