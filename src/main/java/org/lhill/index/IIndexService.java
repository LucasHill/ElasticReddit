package org.lhill.index;

import org.lhill.reddit.RedditPost;

import java.util.List;

/**
 * Created by Lucas on 10/16/2014.
 */
public interface IIndexService {

    void processSubredditRequest(IndexQuery indexQuery);

    void indexRedditPosts(List<RedditPost> redditPosts);
}
