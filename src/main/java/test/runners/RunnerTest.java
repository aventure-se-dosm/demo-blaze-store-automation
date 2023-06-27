package test.runners;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.CucumberOptions.SnippetType;

@CucumberOptions(

		features = { "src/test/resources/login.feature" },

		glue = { "business.steps", "hooks" },

		plugin = { "summary" },

		snippets = SnippetType.CAMELCASE,

		tags = "@ID_0001",

		dryRun = false

)

@RunWith(Cucumber.class)
public class RunnerTest {

}
