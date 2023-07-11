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

	public void comuputeKey(ScenarioContextKeys key, Object value) {
		getMap().put(key, value);
	}

	private Map<ScenarioContextKeys, Object> getMap() {
		return this.map;
	}

	public Status getStatus() {
		return Status.valueOf(getStringValue(ScenarioContextKeys.STATUS));
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

}
