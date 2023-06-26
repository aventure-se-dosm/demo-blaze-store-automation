package core.runners;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@CucumberOptions(
		
		features = {
				"src/test/resoures/signup.feature",
				"src/test/resoures/login.feature",
				"src/test/resoures/logout.feature",
		},

		glue = {

		},
		
		plugin = { "pretty", "summary" },

		tags = "",
		
		dryRun = false

)

@RunWith(Cucumber.class)
public class RunnerTest {

}
