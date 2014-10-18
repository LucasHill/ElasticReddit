package org.lhill.reddit;

import com.github.jreddit.entity.Submission;
import com.github.jreddit.entity.User;
import com.github.jreddit.retrieval.Submissions;
import com.github.jreddit.retrieval.params.SubmissionSort;
import com.github.jreddit.utils.restclient.HttpRestClient;
import com.github.jreddit.utils.restclient.RestClient;

import java.util.List;

/**
 * Created by Lucas on 10/15/2014.
 */
public class RedditWrapperService {
    private final User redditUser;
    private final RestClient restClient;

    private static final String loginProperties = "redditLoginConfig.properties";

    public RedditWrapperService() {
        restClient = new HttpRestClient();
        redditUser = new RedditUserWrapper(loginProperties, restClient).getUser();
    }

    public List<Submission> getTopSubmissionsForSubReddit(String subReddit, Integer numSubmissions) {
        if(null == numSubmissions || numSubmissions < 1) {
            numSubmissions = 100;
        }

        Submissions subms = new Submissions(restClient, redditUser);
        return subms.ofSubreddit(subReddit, SubmissionSort.TOP, -1, numSubmissions, null, null, true);
    }
}
