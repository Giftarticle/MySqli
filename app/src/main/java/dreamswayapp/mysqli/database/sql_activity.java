//package dreamswayapp.mysqli;
//
//import android.os.Bundle;
//import android.support.v7.app.AppCompatActivity;
//import android.util.Log;
//import android.view.View;
//import android.widget.Button;
//import android.widget.EditText;
//
//import java.util.ArrayList;
//
//public class sql_activity extends AppCompatActivity {
//
//    EditText name,email,pass;
//    Button btn,sbtn;
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_sql_activity);
//
//        name=(EditText)findViewById(R.id.name);
//        email=(EditText)findViewById(R.id.emailid);
//        pass=(EditText)findViewById(R.id.password);
//
//        btn=(Button)findViewById(R.id.btn);
//        sbtn=(Button)findViewById(R.id.show);
//
//        final SQlConHelp sQlConHelp=new SQlConHelp(sql_activity.this);
//
//        btn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//            sQlConHelp.open_DB();
//
//                sQlConHelp.insertregdata(new RegistrationTbl(0,name.getText().toString(),email.getText().toString(),pass.getText().toString()));
//
//                sQlConHelp.close_DB();
//
//
//            }
//        });
//
//        sbtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//                sQlConHelp.open_DB();
//                ArrayList<RegistrationTbl> reg=sQlConHelp.selectfulldata();
//                sQlConHelp.close_DB();
//
//
//                for(RegistrationTbl temp:reg)
//                {
//                    Log.e("Row---->","Emp id >> "+temp.getEmpid()
//                            +" && Empname >> "+temp.getEmpname()
//                            +" && EmpEmail >> "+temp.getEmpemail()
//                            +" && Emppassword >> "+temp.getEmppass());
//                }
//
//            }
//        });
//
//    }
//}
