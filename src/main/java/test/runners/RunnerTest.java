package test.runners;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.CucumberOptions.SnippetType;

@CucumberOptions(

		features = { "src/test/resources/login.feature" },

		glue = { "business.steps", "test.hooks" },

		plugin = { "summary", "pretty" },

		monochrome = true,

		snippets = SnippetType.CAMELCASE,

		tags = "@ID_0001",

		dryRun = true

)

@RunWith(Cucumber.class)
public class RunnerTest {

}
