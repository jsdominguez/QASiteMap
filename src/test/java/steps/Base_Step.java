package steps;

import driver.DriverBrowser;

public class Base_Step {

    DriverBrowser dr;
    //edge / chrome
    public Base_Step(){
        dr = new DriverBrowser("chrome");
    }

    public void closeDriver(){
        dr.getDriver().close();
        dr.getDriver().quit();
    }

    public String isAdsPresent(boolean isAds, String espacio){
        String adsFound = "Ok";
        if (!isAds){ adsFound = "Not Found"; }
        return espacio+ " : "+adsFound+"\n";
    }
}
