package org.citygml4j.model.citygml.texturedsurface;

import java.util.List;

import org.citygml4j.model.common.child.Child;
import org.citygml4j.model.common.copy.Copyable;

public interface _Color extends TexturedSurfaceModuleComponent, Child, Copyable {
	public Double getRed();
	public Double getGreen();
	public Double getBlue();
	public List<Double> toList();

	public void setRed(Double red);
	public void setGreen(Double green);
	public void setBlue(Double blue);
	public void setColor(List<Double> color);
}
