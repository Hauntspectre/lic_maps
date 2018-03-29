package vastav.chin.srivastava.googlematrixapi_demo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

/*Replace YOUR_API_KEY in String url with your API KEY obtained by registering your application with google.

 */
public class MainActivity extends AppCompatActivity implements GeoTask.Geo {
    EditText edttxt_from,edttxt_to,edttext_to2;
    Button btn_get;
    String str_from,str_to,str_to2;
    TextView tv_result1,tv_result2,tv_result3,tv_result4,info;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initialize();
        btn_get.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                str_from=edttxt_from.getText().toString();
                str_to=edttxt_to.getText().toString();
                str_to2=edttext_to2.getText().toString();
                Toast.makeText(MainActivity.this,str_to2,Toast.LENGTH_LONG).show();
                if(!str_to2.equals("")) {
                    String url = "https://maps.googleapis.com/maps/api/distancematrix/json?origins=" + str_from + "&destinations=" + str_to + "|" + str_to2 + "&mode=driving&language=fr-FR&avoid=tolls&key=AIzaSyDiyKh9ya2s6T3AqOxQ-wWnipvpGivwlsQ";
                    new GeoTask(MainActivity.this).execute(url);
                }else{
                    String url = "https://maps.googleapis.com/maps/api/distancematrix/json?origins=" + str_from + "&destinations=" + str_to + "&mode=driving&language=fr-FR&avoid=tolls&key=AIzaSyDiyKh9ya2s6T3AqOxQ-wWnipvpGivwlsQ";
                    new GeoTask(MainActivity.this).execute(url);
                }

            }
        });

    }

    

    @Override
    public void setDouble(String result) {
        Toast.makeText(this,result,Toast.LENGTH_LONG).show();
//        String res[]=result.split(",");
//        Double min=Double.parseDouble(res[0])/60;
//        int dist=Integer.parseInt(res[1])/1000;
//        String res2[]=result.split(";");
//        Double min2=Double.parseDouble(res[0])/60;
//        int dist2=Integer.parseInt(res[1])/1000;
//
//        tv_result1.setText("Duration= " + (int) (min / 60) + " hr " + (int) (min % 60) + " mins");
//        tv_result2.setText("Distance= " + dist + " kilometers");
//
//        tv_result3.setText("Duration= " + (int) (min2 / 60) + " hr " + (int) (min % 60) + " mins");
//        tv_result4.setText("Distance= " + dist2 + " kilometers");
//        info.setText(result);

    }
    public void initialize()
    {
        edttxt_from= (EditText) findViewById(R.id.editText_from);
        edttxt_to= (EditText) findViewById(R.id.editText_to);
        edttext_to2= (EditText) findViewById(R.id.editText_to2);
        btn_get= (Button) findViewById(R.id.button_get);
        tv_result1= (TextView) findViewById(R.id.textView_result1);
        tv_result2=(TextView) findViewById(R.id.textView_result2);

        tv_result3= (TextView) findViewById(R.id.textView_result3);
        tv_result4=(TextView) findViewById(R.id.textView_result4);
        info=(TextView)findViewById(R.id.textView_info);
    }
}
