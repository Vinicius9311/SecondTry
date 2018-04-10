package examplet.com.firstactivity;

import android.content.Intent;
import android.renderscript.Sampler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    private TextView showMessage;
    private Button backButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Bundle extras = getIntent().getExtras();

        showMessage = (TextView) findViewById(R.id.showTextViewID);
        backButton = (Button) findViewById(R.id.goBackButtonID);

        //check
        if (extras != null) {
            String message = extras.getString("Message");
            int myInt = extras.getInt("Value");


            showMessage.setText(String.valueOf(myInt));
        }

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent returnIntent = getIntent();
                returnIntent.putExtra("returnData", "From Second Activity");
                setResult(RESULT_OK, returnIntent);
                finish();
            }
        });
    }


}
