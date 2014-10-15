package org.lhill.search;

import org.lhill.reddit.RedditPost;

import java.util.List;

/**
 * Created by Lucas on 10/15/2014.
 */
public class SearchResponse {
    private final List<RedditPost> redditPosts;

    public SearchResponse(List<RedditPost> redditPosts) {
        this.redditPosts = redditPosts;
    }

}
