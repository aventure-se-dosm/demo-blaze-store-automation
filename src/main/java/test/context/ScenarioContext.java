package test.context;

import java.util.HashMap;
import java.util.Map;

import core.utils.enums.ScenarioContextKeys;

public class ScenarioContext {

	private Map<ScenarioContextKeys, Object> map;

	ScenarioContext() {
		this.map = new HashMap<>();
	}

	public void comuputeKey(ScenarioContextKeys key, Object value) {
		map.put(key, value);
	}

	public String getStringValue(ScenarioContextKeys key) {
	//mas em que momento esse valor é inserido?
		return getValue(key).toString();
	}

	public Object getValue(ScenarioContextKeys key) {
		return map.get(key);
	}

}
