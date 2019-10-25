package patterns.structural.facade;

import org.apache.commons.lang3.StringUtils;

public class AccessVerifier {

    private static final String DEFAULT_USER_NAME = "Vitaliy";


    public boolean hasAccess(final String userName) {
        return StringUtils.equalsIgnoreCase(userName, DEFAULT_USER_NAME);
    }
}
