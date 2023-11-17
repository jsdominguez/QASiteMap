package pages;

import org.openqa.selenium.WebDriver;

import java.util.ArrayList;

public class SiteMap_Page extends Base_Page {

    String selector_cantidad_notas = ".folder > .opened > .folder:last-of-type";

    String selector_nota = "> .opened > .line:first-of-type > span:nth-child(2)";

    int cantidad_notas;

    ArrayList<String> notas = new ArrayList<String>();
    public SiteMap_Page(WebDriver driver) {
        super(driver);
    }

    public boolean ispageComplete() {
        return isPageLoadComplete();
    }

    public int getCantidadNotas(){
        cantidad_notas = Integer.parseInt(getCssAtribute(selector_cantidad_notas).split("folder")[1]);
        return cantidad_notas;
    }

    public void mapearNotas(){
        for (int i=1;i<=cantidad_notas;i++){
            String selector = "#folder" + i + " " + selector_nota;
            notas.add(getText(selector));
        }
        notas.add("https://www.americatv.com.pe/esto-es-guerra/alejandra-baigorria-y-onelia-molina-combatiente-ya-no-quiere-competir-contra-guerrera-noticia-19874");
        System.out.println(notas.get(cantidad_notas-1));
    }

    public void leerNotas(){
        for (int i=0;i<notas.size();i++){
            visitUrl(notas.get(i));
            System.out.println("Page "+i + " => " + notas.get(i));
            validatePageNotFound(notas.get(i));
        }
    }
}