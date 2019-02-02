package epam.cdp.utils;

import java.net.MalformedURLException;
import java.net.URL;

public class URLUtils {

    private URLUtils() {
    }

    public static URL resolveUrl(final String url) {
        URL resolvedUrl = null;
        try {
            resolvedUrl = new URL(url);
        } catch (MalformedURLException e) {
            throw new IllegalArgumentException(String.format("Could not resolve URL from string [%s]", url), e);
        }
        return resolvedUrl;
    }
}
