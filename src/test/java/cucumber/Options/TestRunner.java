package cucumber.Options;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
@RunWith(Cucumber.class	)
@CucumberOptions(features = "src/test/java/features",glue={"Stepdefinitions"}
, plugin = {"pretty","json:target/jsonreports/cucumber-report.json"})
public class TestRunner {

}
