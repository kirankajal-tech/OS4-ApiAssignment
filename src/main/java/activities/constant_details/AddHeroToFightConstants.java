package activities.constant_details;

import core.api.Constants;

public class AddHeroToFightConstants extends Constants {
    public static final String path = "/fight/addHero";
    public static final String body = "/constant_details/json_file/AddHeroToFight.json";

    public static final String getBody(String heroId) {
        String apiBody = createBody(body);
        return getFormatter().format(apiBody, heroId)
                .toString();
    }
}