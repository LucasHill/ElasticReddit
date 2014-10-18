package org.lhill.search;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Lucas on 10/15/2014.
 */
@Getter
@Setter
public class SearchQuery {
    private final String queryString;
    private final List<String> facetList;

    public SearchQuery(String queryString, List<String> facetList) {
        this.queryString = queryString;
        this.facetList = facetList;
    }
}
