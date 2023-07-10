package test.context;

import java.util.HashMap;
import java.util.Map;

import core.utils.enums.ScenarioContextKeys;
import io.cucumber.java.Status;

public class ScenarioContext {

	private Map<ScenarioContextKeys, Object> map;

	ScenarioContext() {
		this.map = new HashMap<>();
	}

	private Map<ScenarioContextKeys, Object> getMap() {
		return this.map;
	}

	public void comuputeKey(ScenarioContextKeys key, Object value) {
		getMap().put(key, value);
	}

	public String getStringValue(ScenarioContextKeys key) {
		return getValue(key).toString();
	}

	public Object getValue(ScenarioContextKeys key) {
		return getMap().get(key);
	}

	public void resetScenarioContext() {
		getMap().clear();
	}

	public Status getStatus() {
		String s;
		s = getStringValue(ScenarioContextKeys.STATUS);
		return Status.valueOf(getStringValue(ScenarioContextKeys.STATUS));
	}

}
