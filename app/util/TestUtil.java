package util;

import play.db.Database;

import java.util.HashMap;
import java.util.Map;

public class TestUtil {

    public static Map<String, String> map = new HashMap<String, String>();
    public static Database database;

    public static Map<String,String> getMapDetails(){
        map.put("db.default.url", "jdbc:mysql://localhost/jiopay_test");
        map.put("db.default.user", "root");
        map.put("db.default.password", "password");
        map.put("db.default.jndiName","DefaultDS");
        return map;
    }

    public static Database getDatabase(){
//        database = Helpers.fakeApplication(map).injector().instanceOf(Database.class);
        return database;
    }

}
