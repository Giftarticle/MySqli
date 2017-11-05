package dreamswayapp.mysqli.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import dreamswayapp.mysqli.R;
import dreamswayapp.mysqli.database.StoryTbl;

/**
 * Created by VivEk on 13-10-2017.
 */
public class DataAdapter extends RecyclerView.Adapter<DataAdapter.MyViewHolder> {

    private List<StoryTbl> dataList;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView tvId,tvTitle,tvStory;

        public MyViewHolder(View view) {
            super(view);
            tvId = (TextView) view.findViewById(R.id.tvId);
            tvTitle = (TextView) view.findViewById(R.id.tvTitle);
            tvStory = (TextView) view.findViewById(R.id.tvStory);
        }
    }


    public DataAdapter(List<StoryTbl> dataList) {
        this.dataList = dataList;
}

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.data_list_item, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        StoryTbl movie = dataList.get(position);
        holder.tvId.setText(movie.getStoryId());
        holder.tvTitle.setText(movie.getStoryTitle());
        holder.tvStory.setText(movie.getStoryData());
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }
}
