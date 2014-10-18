package org.lhill.reddit;

import com.github.jreddit.entity.Submission;
import lombok.Getter;
import lombok.Setter;

/**
 * Created by Lucas on 10/15/2014.
 */
@Getter
@Setter
public class RedditPost {
    private final String title;
    private final String url;
    private final String author;
    private final String subreddit;
    private final String subredditId;
    private final String thumbnail;
    private final String selfText;
    private final String domain;
    private final String identifier;
    private final String fullIdentifier;
    private final Boolean nsfw;
    private final Double createdDate;
    private final Double createdDateUTC;
    private final Long commentCount;
    private final Long score;


    public RedditPost(Submission submission) {
        this.title = submission.getTitle();
        this.url = submission.getUrl();
        this.author = submission.getAuthor();
        this.subreddit = submission.getSubreddit();
        this.subredditId = submission.getSubredditId();
        this.thumbnail = submission.getThumbnail();
        this.selfText = submission.getSelftext();
        this.domain = submission.getDomain();
        this.commentCount = submission.getCommentCount();
        this.score = submission.getScore();
        this.createdDate = submission.getCreated();
        this.createdDateUTC = submission.getCreatedUTC();
        this.identifier = submission.getIdentifier();
        this.fullIdentifier = submission.getFullName();
        this.nsfw = submission.isNSFW();
    }

}
