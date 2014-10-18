package org.lhill.index;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.jreddit.entity.Submission;
import org.elasticsearch.action.bulk.BulkRequestBuilder;
import org.elasticsearch.action.bulk.BulkResponse;
import org.elasticsearch.client.Client;
import org.elasticsearch.node.Node;
import org.lhill.reddit.RedditPost;
import org.lhill.reddit.RedditWrapperService;

import java.util.ArrayList;
import java.util.List;

import static org.elasticsearch.node.NodeBuilder.nodeBuilder;

/**
 * Created by Lucas on 10/16/2014.
 */
public class ElasticIndexService implements IIndexService {
    private final RedditWrapperService redditWrapperService;
    private final ObjectMapper jsonMapper = new ObjectMapper();
    private final Client elasticClient;

    public ElasticIndexService() {
        redditWrapperService = new RedditWrapperService();
        Node node = nodeBuilder().clusterName("testCluster").node();
        elasticClient = node.client();
    }
    @Override
    public void processSubredditRequest(IndexQuery indexQuery) {
        List<Submission> submissions = redditWrapperService.getTopSubmissionsForSubReddit(indexQuery.getSubreddit(), indexQuery.getNumSubmissions());
        List<RedditPost> posts = transformSearchSubmissions(submissions);
        indexRedditPosts(posts);
    }

    @Override
    public void indexRedditPosts(List<RedditPost> redditPosts) {
        BulkRequestBuilder bulkRequest = elasticClient.prepareBulk();

        for(RedditPost redditPost : redditPosts) {
            String jsonString = null;
            try {
                jsonString = jsonMapper.writeValueAsString(redditPost);
            } catch (JsonProcessingException e) {
                e.printStackTrace();
            }
            if(null != jsonString) {
                bulkRequest.add(elasticClient.prepareIndex("reddit", "post", redditPost.getFullIdentifier())
                                .setSource(jsonString
                                )
                );
            }
        }

        BulkResponse bulkResponse = bulkRequest.execute().actionGet();
    }

    private List<RedditPost> transformSearchSubmissions(List<Submission> submissions) {
        List<RedditPost> redditPosts = new ArrayList<RedditPost>();

        for(Submission submission : submissions) {
            //TODO check if submission is already in index list
            redditPosts.add(new RedditPost(submission));
        }
        return redditPosts;
    }
}
