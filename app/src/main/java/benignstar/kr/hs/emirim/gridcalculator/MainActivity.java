package benignstar.kr.hs.emirim.gridcalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button num[] = new Button[10];
    EditText edit1, edit2;
    Button add, sub, div, mul;
    TextView text_result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        for (int i = 0; i < 10; i++) {
            num[i] = (Button) findViewById(R.id.n0 + i);
            num[i].setOnClickListener(butCalculHandler);
        }
        edit1 = (EditText) findViewById(R.id.edit1);
        edit2 = (EditText) findViewById(R.id.edit2);
        add = (Button) findViewById(R.id.add_btn);
        sub = (Button) findViewById(R.id.sub_btn);
        div = (Button) findViewById(R.id.div_btn);
        mul = (Button) findViewById(R.id.mul_btn);
        text_result = (TextView) findViewById(R.id.text_result);

        for (int i = 0; i < 10; i++) {
            num[i].setOnClickListener(butCalculHandler);
        }
        add.setOnClickListener(butCalculHandler);
        sub.setOnClickListener(butCalculHandler);
        div.setOnClickListener(butCalculHandler);
        mul.setOnClickListener(butCalculHandler);
    }

    View.OnClickListener butCalculHandler = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            int num_first = Integer.parseInt(edit1.getText().toString());
            int num_second = Integer.parseInt(edit2.getText().toString());
            int result = 0;

            switch (view.getId()) {
                case R.id.add_btn:
                    result = num_first + num_second;
                    break;
                case R.id.sub_btn:
                    result = num_first - num_second;
                    break;
                case R.id.mul_btn:
                    result = num_first * num_second;
                    break;
                case R.id.div_btn:
                    result = num_first / num_second;
                    break;
            }

            text_result.setText("실행결과 : " + result);
        }
    };
}
/*
* Event Programing
* 숫자 버튼들에  OnClickListener 설정 : Handler연결
* 연산 버튼들에 OnClickListener 설정 : Handler연결
* 숫자 버튼이 클릭되었을 때 EditText에 선택된 숫자가 표시되게*/