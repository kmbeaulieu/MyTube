package sjsu.se137.group3.mytube;

import android.os.Bundle;

import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;

public class YouTubeActivity extends YouTubeBaseActivity {
    private final static String YOUTUBE_KEY = Settings.getKey();
    private YouTubePlayerView youTubePlayerView;
    private YouTubePlayer _youTubePlayer;

    public final static String VIDEO_ID_KEY = "VIDEO_ID_KEY";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_you_tube);
        final String idSent = getIntent().getStringExtra(VIDEO_ID_KEY);
        youTubePlayerView = (YouTubePlayerView) findViewById(R.id.view_youtube_player);
        youTubePlayerView.initialize(YOUTUBE_KEY, new YouTubePlayer.OnInitializedListener(){

            @Override
            public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean b) {
                _youTubePlayer = youTubePlayer;
                _youTubePlayer.loadVideo(idSent);
                _youTubePlayer.play();
            }

            @Override
            public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {
                System.out.println("<<<<<<<<<<<<<<<<<< PLAYER FAILED TO INITIALIZE >>>>>>>>>>>>>>>>>>>");
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
