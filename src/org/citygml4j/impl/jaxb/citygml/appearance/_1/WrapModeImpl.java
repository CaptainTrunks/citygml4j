package org.citygml4j.impl.jaxb.citygml.appearance._1;

import org.citygml4j.model.citygml.CityGMLClass;
import org.citygml4j.model.citygml.CityGMLModule;
import org.citygml4j.model.citygml.appearance.AppearanceModule;
import org.citygml4j.model.citygml.appearance.WrapMode;

public enum WrapModeImpl implements WrapMode {
	NONE("none"),
	WRAP("wrap"),
	MIRROR("mirror"),
	CLAMP("clamp"),
	BORDER("border");
	
	private final String value;

	WrapModeImpl(String v) {
		value = v;
	}

	@Override
	public String getValue() {
		return value;
	}

	public static WrapModeImpl fromValue(String v) {
		v = v.trim().toLowerCase();
		
		for (WrapModeImpl c: WrapModeImpl.values()) {
			if (c.value.equals(v)) {
				return c;
			}
		}

		return NONE;
	}

	@Override
	public CityGMLClass getCityGMLClass() {
		return CityGMLClass.WRAPMODE;
	}

	@Override
	public final CityGMLModule getCityGMLModule() {
		return AppearanceModule.v1_0_0;
	}
	
	public String toString() {
		return value;
	}
}