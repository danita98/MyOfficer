package asjita.danita98.myofficer;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    //Explicit  นี่รือการประกาศตัวแปร ค่ะ
    private EditText userEditText, passwordEditText;
    private Button button;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //Bind Widget  ผูกความสัมพันธ์
        bindWidget();

        //Controller
        controller();
    }   //Main Method

    private void controller() {
        button.setOnClickListener(MainActivity.this);
        textView.setOnClickListener(MainActivity.this);
    }

    private void bindWidget() {
        userEditText = (EditText) findViewById(R.id.edtUser);
        passwordEditText = (EditText) findViewById(R.id.edtPassword);
        button = (Button) findViewById(R.id.btnLogin);
        textView = (TextView) findViewById(R.id.txtRegister);

    }

    @Override
    public void onClick(View v) {

        //For Login
        if (v == button) {

            //Get Value From Edit text
            String strUser = userEditText.getText().toString().trim();
            String strPassword = passwordEditText.getText().toString().trim();

            //Check Space
            if (strUser.equals("")|| strPassword.equals("")) {
                myAleart("มีช่องว่างค่ะ");

            }else {
                try {


                    MyGetData myGetData = new MyGetData(MainActivity.this);
                    myGetData.execute("http://swiftcodingthai.com/4mar/getMaster.php");

                    String strJSON = myGetData.get();
                            Log.d("19MarchV1", "JSoN ==>" + strJSON);
            }catch (Exception e){
                   Log.d("19MarchV1","e ==> " + e.toString());
                }
            }



        } //if

        //For Register
        if (v == textView) {
            startActivity(new Intent(MainActivity.this,RegisterActivity.class));
        }

    } //onClick

    private void myAleart(String strMessage) {
        Toast.makeText(MainActivity.this, strMessage,Toast.LENGTH_SHORT).show();
    }
}   // Main Class
