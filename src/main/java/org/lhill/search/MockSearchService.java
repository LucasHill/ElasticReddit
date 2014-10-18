package org.lhill.search;

import com.github.jreddit.entity.Submission;
import org.lhill.reddit.RedditPost;

import java.util.ArrayList;


/**
 * Created by Lucas on 10/15/2014.
 */
public class MockSearchService implements ISearchService{

    @Override
    public SearchResponse executeSearch(SearchQuery searchQuery) {
        ArrayList<RedditPost> redditPosts = new ArrayList<RedditPost>();
        redditPosts.add(new RedditPost(new Submission(null)));

        return new SearchResponse(redditPosts);
    }
}
