package dreamswayapp.mysqli;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;

import dreamswayapp.mysqli.database.SQlStoryConHelp;
import dreamswayapp.mysqli.database.StoryTbl;

public class InsertDataStory extends AppCompatActivity {

    EditText title,data;
    Button btn,sbtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sql_activity);

        title=(EditText)findViewById(R.id.name);
        data=(EditText)findViewById(R.id.emailid);

        btn=(Button)findViewById(R.id.btn);
        sbtn=(Button)findViewById(R.id.show);

        final SQlStoryConHelp sQlStoryConHelp=new SQlStoryConHelp(InsertDataStory.this);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                sQlStoryConHelp.open_DB();

                sQlStoryConHelp.insertregdata(new StoryTbl(0,title.getText().toString(),data.getText().toString()));

                sQlStoryConHelp.close_DB();


            }
        });

        sbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                sQlStoryConHelp.open_DB();
                ArrayList<StoryTbl> reg=sQlStoryConHelp.selectfulldata();
                sQlStoryConHelp.close_DB();


                for(StoryTbl temp:reg)
                {
                    Log.e("Row---->","Story id >> "+temp.getStoryId()
                            +" && Storyname >> "+temp.getStoryTitle()
                            +" && StoryData >> "+temp.getStoryData());
                }

            }
        });

    }
}
