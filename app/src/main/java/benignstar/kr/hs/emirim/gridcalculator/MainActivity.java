package benignstar.kr.hs.emirim.gridcalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button num[] = new Button[10];
    EditText edit1, edit2;
    Button add, sub, div, mul; // Button butOps=new Button[4];
    TextView text_result;
    public static final int SELECT_EDIT1=0;
    public static final int SELECT_EDIT2=1;
    int selectEdit=SELECT_EDIT1;
    String numStr="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        for (int i = 0; i < 10; i++) {
            num[i] = (Button) findViewById(R.id.n0 + i);
            num[i].setOnClickListener(butNumHandler);
        }
        edit1 = (EditText) findViewById(R.id.edit1);
        edit2 = (EditText) findViewById(R.id.edit2);
        edit1.setOnTouchListener(editHandler);
        edit2.setOnTouchListener(editHandler);

        add = (Button) findViewById(R.id.add_btn);
        sub = (Button) findViewById(R.id.sub_btn);
        div = (Button) findViewById(R.id.div_btn);
        mul = (Button) findViewById(R.id.mul_btn);
        text_result = (TextView) findViewById(R.id.text_result);

        add.setOnClickListener(butCalculHandler);
        sub.setOnClickListener(butCalculHandler);
        div.setOnClickListener(butCalculHandler);
        mul.setOnClickListener(butCalculHandler);
    }

    View.OnTouchListener editHandler= new View.OnTouchListener() {
        @Override
        public boolean onTouch(View view, MotionEvent motionEvent) {
            numStr="";
            switch (view.getId()){
                case R.id.edit1 :
                    selectEdit=SELECT_EDIT1;
                    break;
                case R.id.edit2 :
                    selectEdit=SELECT_EDIT2;
                    break;
            }
            return true;
        }
    };

    View.OnClickListener butNumHandler=new View.OnClickListener(){
        @Override
        public void onClick(View view) {
            Button but=(Button)view;
            numStr+=but.getText();
            switch (selectEdit){
                case SELECT_EDIT1 :
                    edit1.setText(numStr);
                    break;
                case SELECT_EDIT2 :
                    edit2.setText(numStr);
                    break;
            }
        }
    };

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