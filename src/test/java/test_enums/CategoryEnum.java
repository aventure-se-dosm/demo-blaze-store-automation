package test_enums;

import org.apache.commons.lang3.StringUtils;

public enum CategoryEnum {
	LAPTOPS, MONITORS, PHONES;

	public String getCapitalizedName() {
		return StringUtils.capitalize(this.name().toLowerCase());
	}
}
