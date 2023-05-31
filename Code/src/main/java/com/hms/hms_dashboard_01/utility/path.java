package com.hms.hms_dashboard_01.utility;

import java.util.Objects;

public class path {
    public static String getPath(String type, String fxml){

        if(Objects.equals(type, "source")){
            String path = "/com/hms/hms_dashboard_01/ui/"+fxml+".fxml";
            System.out.println(path);
            return path;
        }
        String path = "/com/hms/hms_dashboard_01/ui/"+type+"/"+fxml+".fxml";
        System.out.println(path);
        return path;
    }
    public static String getPath(String pkg, String subPkg, String fxml){

        if(Objects.equals(pkg, "source")){
            String path = "/com/hms/hms_dashboard_01/ui/"+pkg+"/"+ subPkg+"/"+fxml+".fxml";
            System.out.println(path);
            return path;
        }
        String path = "/com/hms/hms_dashboard_01/ui/"+pkg+"/"+subPkg+"/"+fxml+".fxml";
        System.out.println(path);
        return path;
    }

}
