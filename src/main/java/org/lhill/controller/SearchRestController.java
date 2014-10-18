package org.lhill.controller;

/**
 * Created by Lucas on 10/15/2014.
 */
import org.lhill.search.ISearchService;
import org.lhill.search.MockSearchService;
import org.lhill.search.SearchQuery;
import org.lhill.search.SearchResponse;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/search")
public class SearchRestController {
    private final ISearchService searchService = new MockSearchService();

    @RequestMapping(value = "/result", method = RequestMethod.GET)
    public SearchResponse getSearchResult(@RequestParam String query) {
        return searchService.executeSearch(new SearchQuery(query, null));
    }
}