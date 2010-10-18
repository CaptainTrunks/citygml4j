/*
 * This file is part of citygml4j.
 * Copyright (c) 2007 - 2010
 * Institute for Geodesy and Geoinformation Science
 * Technische Universitaet Berlin, Germany
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
 */
package org.citygml4j.model.gml.base;

import java.util.List;

import org.citygml4j.model.gml.GML;
import org.citygml4j.model.gml.basicTypes.Code;


public interface StandardObjectProperties extends GML {
	public List<Code> getName();
	public StringOrRef getDescription();
	public List<MetaDataProperty> getMetaDataProperty();
	public boolean isSetName();
	public boolean isSetDescription();
	public boolean isSetMetaDataProperty();

	public void addName(Code name);
	public void setName(List<Code> name);
	public void setDescription(StringOrRef description);
	public void addMetaDataProperty(MetaDataProperty metaDataProperty);
	public void setMetaDataProperty(List<MetaDataProperty> metaDataProperty);
	public void unsetName();
	public boolean unsetName(Code name);
	public void unsetDescription();
	public void unsetMetaDataProperty();
	public boolean unsetMetaDataProperty(MetaDataProperty metaDataProperty);
}
