package com.syeedode.authservices.affinity;

import com.sun.deploy.util.StringUtils;

import java.util.List;
import java.util.Map;

public class AffMapPrinter {

    public void printAffinityMap(Map<List<String>, Integer> stringListMap) {
        for(List<String> site : stringListMap.keySet()){
            System.out.println("Site(s): " + StringUtils.join(site,",")
                    + " - infinity: " + stringListMap.get(site));
        }
    }
}
