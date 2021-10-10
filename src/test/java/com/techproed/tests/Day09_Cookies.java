package com.techproed.tests;

import com.techproed.utilities.TestBase;
import org.junit.Test;
import org.openqa.selenium.Cookie;

import java.util.Set;

public class Day09_Cookies extends TestBase {

    @Test
    public void handleCookies(){
//        Class: Day09_Cookies
//        Method: handleCookies
// -Go to amazon
        driver.get("https://www.amazon.com");
//        1. Find the total number of cookies

        //getCookies() returns all of the cookies in the browser
        Set<Cookie> allCookies = driver.manage().getCookies();
        int numberOfCookies = allCookies.size();
        System.out.println("Number of Cookies => " + numberOfCookies);

//        2. Print all the cookies
        for (Cookie eachCookie : allCookies) {
            System.out.println("Cookie Names are: " + eachCookie.getName());
            System.out.println("Cookie Values are: " + eachCookie.getValue());
        }
//        3. Get the cookies by their name
        System.out.println("Cookie named csm-hit => "+ driver.manage().getCookieNamed("csm-hit"));

//        4. Add new cookie
        //Creating a new cookie
        Cookie myCookie = new Cookie("My fav cookie", "Cookie Monster in SesameStreet");
        //adding the cookie
        driver.manage().addCookie(myCookie);

        allCookies = driver.manage().getCookies();

        System.out.println("Number of Cookie => "+allCookies.size());//10

//        5. Delete cookie by name
        driver.manage().deleteCookieNamed("ubid-main");
        allCookies = driver.manage().getCookies();
        System.out.println("Number of Cookies => "+ allCookies.size());//9

//        6. Delete all of the cookies
        driver.manage().deleteAllCookies();
        allCookies = driver.manage().getCookies();
        System.out.println("Number of Cookies => "+ allCookies.size());//0



    }

}
