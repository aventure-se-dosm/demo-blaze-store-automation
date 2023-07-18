package test.runners;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.CucumberOptions.SnippetType;

@CucumberOptions(

		features = { "src/test/resources/" },

		glue = { "business", "test.hooks" },

		plugin = { "summary", "pretty" },

		monochrome = true,

		snippets = SnippetType.CAMELCASE,

		tags = "@ID_0007",
		//tags = "@ID_0001 or @ID_0002 or @ID_0003 or @ID_0004 or @ID_0005",

		dryRun = false

)

@RunWith(Cucumber.class)
public class RunnerTest {

}
