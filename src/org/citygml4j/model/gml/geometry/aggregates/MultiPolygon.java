/*
 * citygml4j - The Open Source Java API for CityGML
 * https://github.com/citygml4j
 * 
 * Copyright (C) 2013 - 2015,
 * Claus Nagel <claus.nagel@gmail.com>
 *
 * The citygml4j library is free software:
 * you can redistribute it and/or modify it under the terms of the
 * GNU Lesser General Public License as published by the Free
 * Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * 
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU Lesser General Public License for more details.
 */
package org.citygml4j.model.gml.geometry.aggregates;

import java.util.Arrays;
import java.util.List;

import org.citygml4j.builder.copy.CopyBuilder;
import org.citygml4j.geometry.BoundingBox;
import org.citygml4j.model.common.child.ChildList;
import org.citygml4j.model.common.visitor.GMLFunctor;
import org.citygml4j.model.common.visitor.GMLVisitor;
import org.citygml4j.model.common.visitor.GeometryFunctor;
import org.citygml4j.model.common.visitor.GeometryVisitor;
import org.citygml4j.model.gml.GMLClass;
import org.citygml4j.model.gml.geometry.primitives.Polygon;
import org.citygml4j.model.gml.geometry.primitives.PolygonProperty;

public class MultiPolygon extends AbstractGeometricAggregate {
	private List<PolygonProperty> polygonMember;

	public MultiPolygon() {
		
	}
	
	public MultiPolygon(List<Polygon> polygons) {
		for (Polygon polygon : polygons)
			addPolygonMember(new PolygonProperty(polygon));
	}
	
	public MultiPolygon(Polygon... polygons) {
		this(Arrays.asList(polygons));
	}
	
	public void addPolygonMember(PolygonProperty polygonMember) {
		if (this.polygonMember == null)
			this.polygonMember = new ChildList<PolygonProperty>(this);

		this.polygonMember.add(polygonMember);
	}

	public List<PolygonProperty> getPolygonMember() {
		if (polygonMember == null)
			polygonMember = new ChildList<PolygonProperty>(this);

		return polygonMember;
	}

	public boolean isSetPolygonMember() {
		return polygonMember != null && !polygonMember.isEmpty();
	}

	public void setPolygonMember(List<PolygonProperty> polygonMember) {
		this.polygonMember = new ChildList<PolygonProperty>(this, polygonMember);
	}

	public void unsetPolygonMember() {
		if (isSetPolygonMember())
			polygonMember.clear();
			
		polygonMember = null;
	}

	public boolean unsetPolygonMember(PolygonProperty polygonMember) {
		return isSetPolygonMember() ? this.polygonMember.remove(polygonMember) : false;
	}

	public BoundingBox calcBoundingBox() {
		BoundingBox bbox = new BoundingBox();
		
		if (isSetPolygonMember()) {
			for (PolygonProperty polygonProperty : getPolygonMember())
				if (polygonProperty.isSetPolygon())
					bbox.update(polygonProperty.getPolygon().calcBoundingBox());
		}
		
		if (bbox.getLowerCorner().isEqual(Double.MAX_VALUE) && 
				bbox.getUpperCorner().isEqual(-Double.MAX_VALUE))
			return null;
		else
			return bbox;
	}

	public GMLClass getGMLClass() {
		return GMLClass.MULTI_POLYGON;
	}

	public Object copy(CopyBuilder copyBuilder) {
		return copyTo(new MultiPolygon(), copyBuilder);
	}

	@Override
	public Object copyTo(Object target, CopyBuilder copyBuilder) {
		MultiPolygon copy = (target == null) ? new MultiPolygon() : (MultiPolygon)target;
		super.copyTo(copy, copyBuilder);

		if (isSetPolygonMember()) {
			for (PolygonProperty part : polygonMember) {
				PolygonProperty copyPart = (PolygonProperty)copyBuilder.copy(part);
				copy.addPolygonMember(copyPart);

				if (part != null && copyPart == part)
					part.setParent(this);
			}
		}

		return copy;
	}
	
	public void accept(GeometryVisitor visitor) {
		visitor.visit(this);
	}

	public <T> T accept(GeometryFunctor<T> visitor) {
		return visitor.apply(this);
	}
	
	public void accept(GMLVisitor visitor) {
		visitor.visit(this);
	}
	
	public <T> T accept(GMLFunctor<T> visitor) {
		return visitor.apply(this);
	}

}
