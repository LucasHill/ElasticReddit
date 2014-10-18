package org.lhill.reddit;

import com.github.jreddit.entity.User;
import com.github.jreddit.utils.restclient.RestClient;
import lombok.Getter;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Created by Lucas on 10/18/2014.
 */
@Getter
public class RedditUserWrapper {
    private final User user;

    public RedditUserWrapper(String propertiesName, RestClient restClient) {
        InputStream inputStream = getClass().getClassLoader().getResourceAsStream(propertiesName);

        Properties prop = new Properties();
        try {
            prop.load(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }

        user = new User(restClient, prop.getProperty("username"), prop.getProperty("password"));
    }
}
