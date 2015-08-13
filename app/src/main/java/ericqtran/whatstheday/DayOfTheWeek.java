package ericqtran.whatstheday;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class DayOfTheWeek extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        final String[] daysOfWeek = {"Sunday","Monday","Tuesday","Wednesday","Thursday","Friday","Saturday"};

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_day_of_the_week);

        final EditText dateBox = (EditText)findViewById(R.id.dateBox);
        final TextView output = (TextView)findViewById(R.id.result);
        final TextView belowInput = (TextView)findViewById(R.id.belowInputBox);
        final Date outputDate = new Date();


        Button calcButt = (Button)findViewById(R.id.calculateButton);

        calcButt.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {


                String inputDate = dateBox.getText().toString();

                if(inputDate.matches(""))
                {
                    output.setText("Please input a date");
                    return;
                }
                else if(!inputDate.matches("([0-9]{1,2})/([0-9]{1,2})/([0-9]{4})"))
                {
                    output.setText("Please input a valid date");
                    return;
                }
                Date result = outputDate.parseDate(inputDate);

                int theCalculatedResult = result.dayOfTheWeekCalc(result);

                String finalResult = daysOfWeek[theCalculatedResult];

                output.setText(finalResult);

            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_day_of_the_week, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
