package org.lhill.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.lhill.index.ElasticIndexService;
import org.lhill.index.IIndexService;
import org.lhill.index.IndexQuery;
import org.lhill.search.SearchQuery;
import org.lhill.search.SearchResponse;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

/**
 * Created by Lucas on 10/15/2014.
 */
@RestController
@RequestMapping("/index")
public class IndexRestController {
    private final IIndexService indexService = new ElasticIndexService();
    private final ObjectMapper mapper = new ObjectMapper();

    @RequestMapping(value = "/subreddit", method = RequestMethod.POST)
    public void createIndexFromSubreddit(@RequestBody String query) {
        IndexQuery indexQuery = null;
        try {
            indexQuery = mapper.readValue(query, IndexQuery.class);
        } catch (IOException e) {
            e.printStackTrace();
        }

        indexService.processSubredditRequest(indexQuery);
    }
}