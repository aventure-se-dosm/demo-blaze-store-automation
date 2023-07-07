package core.managers;

import core.utils.Screenshoter;
import core.utils.TimeUtils;
import core.utils.enums.ValidFileFormats.ImageFormats;
import test.context.TestContext;

public class EvidenceManager {

	private Screenshoter screenshoter;

	private TimeUtils timeUtils;

	public EvidenceManager() {
		this.screenshoter = new Screenshoter();
		this.timeUtils = new TimeUtils();
	}

	public void createEvidence() {

		screenshoter.takeScreenshot(getDefaultEvidencePath(), getDefaultFileNameOutput(),
				ImageFormats.valueOf(getDefaultEvidenceFormat().toUpperCase()));
	}

	private String getDefaultEvidenceFormat() {
		return TestContext.getConfigReader().getDefaultEvidenceFormat();
	}

	private String getDefaultEvidencePath() {
		return TestContext.getConfigReader().getDefaultEvidencePath();
	}

	private String getDefaultFileNameOutput() {

		return String.join("_", TestContext.getCurrentScenarioId(), TestContext.getStatusPTString(),
				timeUtils.getFormattedDateTimeNow());
	}

}
