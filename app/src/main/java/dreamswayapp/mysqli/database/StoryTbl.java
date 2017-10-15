package dreamswayapp.mysqli.database;

/**
 * Created by Pratik on 8/10/2017.
 */

public class StoryTbl {

    private int storyId;
    private String storyTitle;
    private String storyData;

    public StoryTbl(int storyId, String storyTitle, String storyData)
    {
        this.storyId=storyId;
        this.storyTitle=storyTitle;
        this.storyData=storyData;
    }

    public int getStoryId() {
        return storyId;
    }

    public String getStoryTitle() {
        return storyTitle;
    }

    public String getStoryData() {
        return storyData;
    }
}
