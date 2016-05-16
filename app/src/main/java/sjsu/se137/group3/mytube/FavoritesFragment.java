package sjsu.se137.group3.mytube;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubeThumbnailLoader;
import com.google.android.youtube.player.YouTubeThumbnailView;
import com.google.api.client.http.HttpRequest;
import com.google.api.client.http.HttpRequestInitializer;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.services.youtube.YouTube;
import com.google.api.services.youtube.model.SearchResult;
import com.google.api.services.youtube.model.SearchResultSnippet;
import com.google.api.services.youtube.model.Video;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


/**
 *
 */
public class FavoritesFragment extends Fragment {
    public final static String YOUTUBE_KEY = Settings.getKey();
    public static List<SearchResult> favoritesList;
    private YouTube youTube;
    private SearchResultsAdapter _searchResultsAdapter;
    private RecyclerView mSearchResultsRecyclerView;


    public FavoritesFragment() {
        super();
        if (favoritesList != null) {

        } else {
            favoritesList = new ArrayList<>();
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_favorites, container, false);

        youTube = new YouTube.Builder(new NetHttpTransport(), new JacksonFactory(), new HttpRequestInitializer() {
            @Override
            public void initialize(HttpRequest request) throws IOException {

            }
        }).setApplicationName("MyTube").build();

        mSearchResultsRecyclerView = (RecyclerView) view.findViewById(R.id.recycler_view_favorites);
        mSearchResultsRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        mSearchResultsRecyclerView.setAdapter(new SearchResultsAdapter(favoritesList));
        return view;
    }

    private class SearchResultsHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private String selectedID;
        private YouTubeThumbnailView youTubeThumbnailView;
        private TextView textViewTitle;
        private TextView textViewCount;
        private TextView textViewPublishDate;
        private Video video;

        public SearchResultsHolder(View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);

            textViewTitle = (TextView) itemView.findViewById(R.id.text_view_title);
            textViewCount = (TextView) itemView.findViewById(R.id.text_view_count);
            textViewPublishDate = (TextView) itemView.findViewById(R.id.text_view_publish_date);
            youTubeThumbnailView = (YouTubeThumbnailView) itemView.findViewById(R.id.thumbnail);
        }

        private void bindResult(SearchResult searchResult) {
            selectedID = searchResult.getId().getVideoId();
            SearchResultSnippet searchResultSnippet = searchResult.getSnippet();
            String title = searchResultSnippet.getTitle();
            String publishedDate = "Published: " + searchResultSnippet.getPublishedAt().toString();
            String viewCount = "View count: ";
            final String videoID = searchResult.getId().getVideoId();
            final SearchResult _searchResult = searchResult;

            try {
                final YouTube.Videos.List youtubeVideoList = youTube.videos().list("statistics");
                youtubeVideoList.setId(searchResult.getId().getVideoId());
                youtubeVideoList.setKey(YOUTUBE_KEY);
                Thread k = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            video = youtubeVideoList.execute().getItems().get(0);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                });
                k.start();
                try {
                    k.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                viewCount += video.getStatistics().getViewCount();
            } catch (IOException e) {
                e.printStackTrace();
            }

            youTubeThumbnailView.initialize(YOUTUBE_KEY, new YouTubeThumbnailView.OnInitializedListener() {
                @Override
                public void onInitializationSuccess(YouTubeThumbnailView youTubeThumbnailView, YouTubeThumbnailLoader youTubeThumbnailLoader) {
                    youTubeThumbnailLoader.setVideo(videoID);
                }

                @Override
                public void onInitializationFailure(YouTubeThumbnailView youTubeThumbnailView, YouTubeInitializationResult youTubeInitializationResult) {

                }
            });

            textViewTitle.setText(title);
            textViewCount.setText(viewCount);
            textViewPublishDate.setText(publishedDate);
        }

        @Override
        public void onClick(View v) {
            Intent intent = new Intent(getActivity(), YouTubeActivity.class);
            intent.putExtra(YouTubeActivity.VIDEO_ID_KEY, selectedID);
            startActivity(intent);
        }
    }

    private class SearchResultsAdapter extends RecyclerView.Adapter<SearchResultsHolder> {
        List<SearchResult> searchResults;

        public SearchResultsAdapter(List<SearchResult> searchResults) {
            this.searchResults = searchResults;
        }

        @Override
        public SearchResultsHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            LayoutInflater layoutInflater = LayoutInflater.from(getActivity());
            View view = layoutInflater.inflate(R.layout.fragment_search_item, parent, false);
            return new SearchResultsHolder(view);
        }

        @Override
        public void onBindViewHolder(SearchResultsHolder holder, int position) {
            holder.bindResult(searchResults.get(position));
        }

        @Override
        public int getItemCount() {
            return searchResults.size();
        }
    }
}
