package runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
//Which feature file to run,can be specific or folder level where all
//the features file will run.we can group as well by putting individual feature file names in""


@CucumberOptions(features="src/test/resources/Features/Magento.feature",glue="definition",dryRun=false,plugin= {"html:Reports.html"})
public class TestRunner {

}
