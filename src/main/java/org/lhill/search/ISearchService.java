package org.lhill.search;

import java.util.List;

/**
 * Created by Lucas Hill on 10/15/2014.
 */
public interface ISearchService {

    SearchResponse executeSearch(SearchQuery searchQuery);
}
