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
	public void comuputeKeyIfAbsent(ScenarioContextKeys key, Object value) {
		getMap().putIfAbsent(key, value);
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
		try {return getMap().get(key);
	}
		public boolean isKeyPresent(ScenarioContextKeys key) {
			return getMap().containsKey(ScenarioContextKeys.PRODUCT_ID_0008_LIST);
		}
	public void resetScenarioContext() {
		getMap().clear();
	}

}
