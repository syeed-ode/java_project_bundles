package com.syeedode.authservices;

import com.sun.deploy.util.StringUtils;
import com.syeedode.authservices.amazon.LunchSolution;
import com.syeedode.authservices.amazon.Solution;

/**
 * Amazon Interview
 * <p>
 * Author: syeedode
 * Date: 5/29/17
 */
public class AmazonInterview {
    public static void main(String [] args) {
        System.out.println("Hello World");
//        Solution solution = new Solution();
//        for(Integer i : solution.getAnagramIndicesTwo("bcdaghbabcdaij","bcda")){
//            System.out.println(i);
//        }
        LunchSolution l = new LunchSolution();
        String[][] lmp = {
                  {"Pizza", "Italian"}
                , {"Curry", "Indian"}
                , {"Masala","Indian"}
        };
        String[][] tcP = {
                {"Jose","Italian"}
            ,   {"John","Indian"}
            ,   {"Sarah","*"}};
        l.matchLunches(lmp,tcP);
    }
}
