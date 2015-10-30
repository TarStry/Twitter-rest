package com.taran.twitter_rest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.app.ListActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;

import com.twitter.sdk.android.tweetui.SearchTimeline;
import com.twitter.sdk.android.tweetui.TweetTimelineListAdapter;

public class TwitterListActivity extends ListActivity {

    private static final String SEARCH_QUERY = "#Baltimore AND" + "(#health OR #medicine)";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_INDETERMINATE_PROGRESS);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_twitter_list);

        SearchTimeline searchTimeline = new SearchTimeline.Builder().query(SEARCH_QUERY).build();

        final TweetTimelineListAdapter timelineAdapter = new TweetTimelineListAdapter(this, searchTimeline);
        setListAdapter(timelineAdapter);
        getListView().setEmptyView(findViewById(R.id.loading));

        final ImageView back = (ImageView) findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                onBackPressed();
            }
        });
    }
}
