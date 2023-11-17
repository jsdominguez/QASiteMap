package steps;

import driver.DriverBrowser;
import org.testng.annotations.Test;
import pages.SiteMap_Page;

public class SiteMap_Step extends Base_Step {

    SiteMap_Page siteMapPage;

    @Test
    public void validaciondeNotas() {
        dr = new DriverBrowser("chrome");
        siteMapPage = new SiteMap_Page(dr.getDriver());

        dr.getDriver().manage().window().maximize();
        dr.getDriver().get("https://www.americatv.com.pe/sitemap/web?ns_source=organico");
        siteMapPage.ispageComplete();

        siteMapPage.getCantidadNotas();
        siteMapPage.mapearNotas();
        siteMapPage.leerNotas();
        //new Utils().sendStatusAdsSlack(adsStatus);
        closeDriver();
    }
}
