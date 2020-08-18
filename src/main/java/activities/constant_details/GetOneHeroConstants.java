package activities.constant_details;

import core.api.Constants;

public class GetOneHeroConstants extends Constants {
    public static final String path = "/heroes/{heroID}";
    public static final String pathParam = "heroID:%s";

    public static final String getPathParameter(String heroID) {
        return String.format(pathParam, heroID);
    }
}
