package poclin.carlos.clase3_proyecto1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class Activity1 extends AppCompatActivity {

    //Paso 2

    @BindView(R.id.et_nombres) EditText mEtName;
    @BindView(R.id.et_ap) EditText mEtAp;
    @BindView(R.id.et_am) EditText mEtAm;
    @BindView(R.id.et_correo) EditText mEtCorreo;
    @BindView(R.id.et_password) EditText mEtPass;

    @BindView(R.id.iv_1) ImageView mIv1;
    @BindView(R.id.btn_guardar) Button mBtnGuardar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_1);

        //Paso 1

        ButterKnife.bind(this);

        //Escribir codigo


    }

    //Paso 3

    @OnClick({R.id.btn_guardar, R.id.iv_1}) public void onButtonClick (){
        Toast.makeText(this, "Hola", Toast.LENGTH_SHORT).show();
    }
}
