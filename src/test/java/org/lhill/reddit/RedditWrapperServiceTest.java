package org.lhill.reddit;

import com.github.jreddit.entity.Submission;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.List;

/**
 * Created by Lucas on 10/15/2014.
 */
public class RedditWrapperServiceTest {
    private static RedditWrapperService redditWrapperService = null;

    @BeforeClass
    public static void setUp() {
        redditWrapperService = new RedditWrapperService();
    }
    @Test
    public void getTopSubmissionsForSubRedditTest() {
        int submissionSize = 10;
        List<Submission> submissionList = redditWrapperService.getTopSubmissionsForSubReddit("all", submissionSize);
        Assert.assertEquals(submissionSize, submissionList.size());
    }
}
