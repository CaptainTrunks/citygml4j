/*
 * This file is part of citygml4j.
 * Copyright (c) 2007 - 2012
 * Institute for Geodesy and Geoinformation Science
 * Technische Universität Berlin, Germany
 * http://www.igg.tu-berlin.de/
 *
 * The citygml4j library is free software:
 * you can redistribute it and/or modify it under the terms of the
 * GNU Lesser General Public License as published by the Free
 * Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * 
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 * 
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library. If not, see 
 * <http://www.gnu.org/licenses/>.
 * 
 * $Id: ValueArray.java 542 2012-11-29 20:56:44Z nagel $
 */
package org.citygml4j.model.gml.valueObjects;

import java.util.Arrays;
import java.util.List;

import org.citygml4j.builder.copy.CopyBuilder;
import org.citygml4j.model.common.visitor.GMLFunctor;
import org.citygml4j.model.common.visitor.GMLVisitor;
import org.citygml4j.model.gml.GMLClass;

public class ValueArray extends CompositeValue {
	private String codeSpace;
	private String uom;
	
	public ValueArray() {
		
	}
	
	public ValueArray(List<Value> values) {
		for (Value value : values)
			addValueComponent(new ValueProperty(value));
	}
	
	public ValueArray(Value... values) {
		this(Arrays.asList(values));
	}
	
	public String getCodeSpace() {
		return codeSpace;
	}

	public String getUom() {
		return uom;
	}

	public boolean isSetCodeSpace() {
		return codeSpace != null;
	}

	public boolean isSetUom() {
		return uom != null;
	}

	public void setCodeSpace(String codeSpace) {
		this.codeSpace = codeSpace;
	}

	public void setUom(String uom) {
		this.uom = uom;
	}

	public void unsetCodeSpace() {
		codeSpace = null;
	}

	public void unsetUom() {
		uom = null;
	}

	@Override
	public GMLClass getGMLClass() {
		return GMLClass.VALUE_ARRAY;
	}

	@Override
	public Object copyTo(Object target, CopyBuilder copyBuilder) {
		ValueArray copy = (target == null) ? new ValueArray() : (ValueArray)target;
		super.copyTo(copy, copyBuilder);
		
		if (isSetCodeSpace())
			copy.setCodeSpace(copyBuilder.copy(codeSpace));
		
		if (isSetUom())
			copy.setUom(copyBuilder.copy(uom));
		
		return copy;
	}

	@Override
	public Object copy(CopyBuilder copyBuilder) {
		return copyTo(new ValueArray(), copyBuilder);
	}

	@Override
	public void accept(GMLVisitor visitor) {
		visitor.visit(this);
	}

	@Override
	public <T> T accept(GMLFunctor<T> visitor) {
		return visitor.apply(this);
	}

}
