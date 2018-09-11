package net.htmlonlnie.util;


import javax.servlet.http.Cookie;
import java.util.ArrayList;

public class Utils {


    public static void displayCookies(Cookie[] cookies) {
        ArrayList<CookieStructure> list = new ArrayList<>();
        for (Cookie cookie : cookies) {
            String key = cookie.getName();
            String value = cookie.getValue();
            int maxAge = cookie.getMaxAge();
            String path = cookie.getPath();
            list.add(new CookieStructure(key, value, maxAge, path));

        }
        System.out.println(list);
    }

    public static Cookie getCookieByName(String checkName, Cookie[] cookies) {

        for (Cookie cookie : cookies) {
            String name = cookie.getName();
            if (checkName.equalsIgnoreCase(name)) {
                return cookie;
            }
        }
        return null;
    }

    public static boolean isSetByName(String checkName, Cookie[] cookies) {

        return getCookieByName(checkName, cookies) != null;
    }




    static class CookieStructure {
        private String key;
        private String value;
        private int maxAge;
        private String path;

        @Override
        public String toString() {
            return "CookieStructure{" +
                    "key='" + key + '\'' +
                    ", value='" + value + '\'' +
                    ", maxAge=" + maxAge +
                    ", path='" + path + '\'' +
                    '}';
        }

        CookieStructure(String key, String value, int maxAge, String path) {
            this.key = key;
            this.value = value;
            this.maxAge = maxAge;
            this.path = path;
        }
    }
}
