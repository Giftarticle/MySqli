package dreamswayapp.mysqli;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabaseCorruptException;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import dreamswayapp.mysqli.adapter.DataAdapter;
import dreamswayapp.mysqli.database.SQlStoryConHelp;
import dreamswayapp.mysqli.database.StoryTbl;
import dreamswayapp.mysqli.utils.ExitStrategy;

public class MainActivity extends AppCompatActivity {
//
    private List<StoryTbl> addDataList = new ArrayList<>();
    @BindView(R.id.rvHomePage)
    RecyclerView rvHomePage;
    DataAdapter dataAdapter;

    SQlStoryConHelp sQlStoryConHelp;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        ButterKnife.bind(this);
        init();
    }

    private void init() {

        dataAdapter = new DataAdapter(addDataList);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(this);
        rvHomePage.setLayoutManager(mLayoutManager);
        rvHomePage.setItemAnimator(new DefaultItemAnimator());
        rvHomePage.setAdapter(dataAdapter);


        sQlStoryConHelp.open_DB();
        ArrayList<StoryTbl> reg=sQlStoryConHelp.selectfulldata();
        sQlStoryConHelp.close_DB();


        for(StoryTbl temp:reg)
        {
            Log.e("Row---->","Story id >> "+temp.getStoryId()
                    +" && Storyname >> "+temp.getStoryTitle()
                    +" && StoryData >> "+temp.getStoryData());
        }


//        setTitleText("Home");
//        dataAdapter = new DataAdapter(addDataList);
//        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getActivity());
//        rvHomePage.setLayoutManager(mLayoutManager);
//        rvHomePage.setItemAnimator(new DefaultItemAnimator());
//        rvHomePage.setAdapter(dataAdapter);
//        prepareAddData();
    }




    @Override
    public void onBackPressed() {
        try {
                if (ExitStrategy.canExit()) {
                    super.onBackPressed();
                } else {
                    ExitStrategy.startExitDelay(2000);
                    Toast.makeText(this, getString(R.string.exit_msg),
                            Toast.LENGTH_SHORT).show();
                }
        } catch (Exception e) {

        }

    }
}
