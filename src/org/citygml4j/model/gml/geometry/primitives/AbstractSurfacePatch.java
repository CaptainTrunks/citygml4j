package org.citygml4j.model.gml.geometry.primitives;

import org.citygml4j.geometry.BoundingBox;
import org.citygml4j.model.common.association.Associable;
import org.citygml4j.model.common.child.Child;
import org.citygml4j.model.common.copy.Copyable;
import org.citygml4j.model.gml.GML;

public interface AbstractSurfacePatch extends GML, Associable, Child, Copyable {
	public BoundingBox calcBoundingBox();
}
