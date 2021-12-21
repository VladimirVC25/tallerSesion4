package utils;

import net.masterthought.cucumber.Configuration;
import net.masterthought.cucumber.ReportBuilder;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class ReportCucumber {

    public static void main(String []args) throws InterruptedException {

        Thread.sleep(10000);
        String ruta=new File("").getAbsolutePath()+"/build/reports/cucumber/";
        File reportFolder = new File(ruta+"JBGroupReport");

        List<String> jsonList = new ArrayList<>();
        jsonList.add(ruta+"report.json");

        Configuration configuration = new Configuration(reportFolder,"Movile Training");
        configuration.setBuildNumber("V0001");
        configuration.addClassifications("Owner","JBGroup");
        configuration.addClassifications("OS","Android");
        configuration.addClassifications("Branch","Develop");

        ReportBuilder reportBuilder = new ReportBuilder(jsonList,configuration) ;
        reportBuilder.generateReports();


    }

}
