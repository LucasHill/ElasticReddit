package org.lhill.index;

import lombok.Getter;
import lombok.Setter;

/**
 * Created by Lucas on 10/16/2014.
 */
@Getter
@Setter
public class IndexQuery {
    private String subreddit;
    private Integer numSubmissions;
}
