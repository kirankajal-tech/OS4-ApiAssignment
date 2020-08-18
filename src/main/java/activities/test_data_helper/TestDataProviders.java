package activities.test_data_helper;

import org.apache.http.HttpStatus;
import org.testng.annotations.DataProvider;

public class TestDataProviders {
    @DataProvider(name = "getOneHeroData")
    public static Object[][] getOneHeroData() {
        Object[][] getOneHero = {
                {"Y", "Positive - Verifying with passing valid parameter : ", "THR", HttpStatus.SC_OK, null}
        };
        return getOneHero;
    }

    @DataProvider(name = "addSingleHeroToFightData")
    public static Object[][] addSingleHeroToFightData() {
        Object[][] addSingleHeroToFight = {
                {"Y", "Positive - Verifying with passing valid parameter for 1st hero_id : ", "THR", HttpStatus.SC_OK, null},
                {"Y", "Negative - Verifying with passing same as 1st hero_id parameter : ", "THR", HttpStatus.SC_BAD_REQUEST, "Thor could not be added because is already in the fight."},
                {"Y", "Negative - Verifying without passing parameter : ", "", HttpStatus.SC_BAD_REQUEST, "Hero ID must be passed on the POST request"},
                {"Y", "Negative - Verifying with passing invalid parameter as \"HGFhjh\" : ", "HGFhjh", HttpStatus.SC_BAD_REQUEST, "There is no hero with the id [HGFhjh]"},
                {"Y", "Negative - Verifying with passing invalid parameter as \"123456\" : ", "123456", HttpStatus.SC_BAD_REQUEST, "There is no hero with the id [123456]"},
                {"Y", "Negative - Verifying with passing invalid parameter as \"Special Character\" : ", "$^&*^*^", HttpStatus.SC_BAD_REQUEST, "There is no hero with the id [$^&*^*^]"},
                {"Y", "Negative - Verifying with passing invalid parameter as \"Numeric\" : ", "$%YTUJ4546hjk", HttpStatus.SC_BAD_REQUEST, "There is no hero with the id [$%YTUJ4546hjk]"},
        };
        return addSingleHeroToFight;
    }

    @DataProvider(name = "add2HeroesToFightData")
    public static Object[][] add2HeroesToFightData() {
        Object[][] add2HeroesToFight = {
                {"Y", "Positive - Verifying with passing valid parameter for 1st hero_id : ", "HLK", HttpStatus.SC_OK, null},
                {"Y", "Negative - Verifying with passing same as 1st hero_id parameter : ", "HLK", HttpStatus.SC_BAD_REQUEST, "Hulk could not be added because is already in the fight."},
                {"Y", "Positive - Verifying with passing valid parameter for 2nd hero_id : ", "CAM", HttpStatus.SC_OK, null},
                {"Y", "Negative - Verifying with passing same as 2nd hero_id parameter : ", "CAM", HttpStatus.SC_BAD_REQUEST, "Captain America could not be added because is already in the fight."},
        };
        return add2HeroesToFight;
    }

    @DataProvider(name = "add3HeroesToFightData")
    public static Object[][] add3HeroesToFightData() {
        Object[][] add3HeroesToFight = {
                {"Y", "Positive - Verifying with passing valid parameter for 1st hero_id : ", "IRM", HttpStatus.SC_OK, null},
                {"Y", "Negative - Verifying with passing same as 1st hero_id parameter : ", "IRM", HttpStatus.SC_BAD_REQUEST, "Iron Man could not be added because is already in the fight."},
                {"Y", "Positive - Verifying with passing valid parameter for 2nd hero_id : ", "BLW", HttpStatus.SC_OK, null},
                {"Y", "Negative - Verifying with passing same as 2nd hero_id parameter : ", "BLW", HttpStatus.SC_BAD_REQUEST, "Black Widow could not be added because is already in the fight."},
                {"Y", "Positive - Verifying with passing valid parameter for 3rd hero_id : ", "DRS", HttpStatus.SC_OK, null},
                {"Y", "Negative - Verifying with passing same as 3rd hero_id parameter : ", "DRS", HttpStatus.SC_BAD_REQUEST, "Doctor Strange could not be added because is already in the fight."},
        };
        return add3HeroesToFight;
    }

    @DataProvider(name = "add4HeroesToFightData")
    public static Object[][] add4HeroesToFightData() {
        Object[][] add4HeroesToFight = {
                {"Y", "Positive - Verifying with passing valid parameter for 1st hero_id : ", "IRM", HttpStatus.SC_OK, null},
                {"Y", "Negative - Verifying with passing same as 1st hero_id parameter : ", "IRM", HttpStatus.SC_BAD_REQUEST, "Iron Man could not be added because is already in the fight."},
                {"Y", "Positive - Verifying with passing valid parameter for 2nd hero_id : ", "BLW", HttpStatus.SC_OK, null},
                {"Y", "Negative - Verifying with passing same as 2nd hero_id parameter : ", "BLW", HttpStatus.SC_BAD_REQUEST, "Black Widow could not be added because is already in the fight."},
                {"Y", "Positive - Verifying with passing valid parameter for 3rd hero_id : ", "DRS", HttpStatus.SC_OK, null},
                {"Y", "Negative - Verifying with passing same as 3rd hero_id parameter : ", "DRS", HttpStatus.SC_BAD_REQUEST, "Doctor Strange could not be added because is already in the fight."},
                {"Y", "Negative - Verifying with passing valid parameter for 4rd hero_id : ", "VSN", HttpStatus.SC_BAD_REQUEST, "A maximum of 3 heroes are allowed per fight."}
        };
        return add4HeroesToFight;
    }

    @DataProvider(name = "startFightWithSingleHeroData")
    public static Object[][] startFightWithSingleHeroData() {
        Object[][] startFightWithSingleHero = {
                {"Y", "Negative - Verifying with adding single hero to fight : ", HttpStatus.SC_BAD_REQUEST, "You can not start a fight with less than 2 heroes"},
        };
        return startFightWithSingleHero;
    }

    @DataProvider(name = "startFightWith2HeroesData")
    public static Object[][] startFightWith2HeroesData() {
        Object[][] startFightWith2Heroes = {
                {"Y", "Negative - Verifying with adding 2 heroes to fight : ", HttpStatus.SC_OK, "Heroes fought hard! The winner is Black Widow!"},
        };
        return startFightWith2Heroes;
    }

    @DataProvider(name = "startFightWith3HeroesData")
    public static Object[][] startFightWith3HeroesData() {
        Object[][] startFightWith3Heroes = {
                {"Y", "Negative - Verifying with adding more than 2 heroes to fight : ", HttpStatus.SC_OK, "Internal server error"},
        };
        return startFightWith3Heroes;
    }

    @DataProvider(name = "deletedFightData")
    public static Object[][] deletedFightData() {
        Object[][] deletedFight = {
                {"Y", "Positive - Verifying fight has ben deleted successfully : ", HttpStatus.SC_OK, "Fight has been deleted and now all heroes went back to Helicarrier Ship."},
        };
        return deletedFight;
    }
}