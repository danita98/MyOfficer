package asjita.danita98.myofficer;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

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

        //For Register
        if (v == textView) {
            startActivity(new Intent(MainActivity.this,RegisterActivity.class));
        }

    } //onClick
}   // Main Class
