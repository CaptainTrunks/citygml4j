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
 * $Id$
 */
package org.citygml4j.xml.validation;

import javax.xml.bind.ValidationEventHandler;

import org.citygml4j.model.module.ModuleContext;
import org.citygml4j.model.module.citygml.CityGMLVersion;
import org.citygml4j.xml.schema.SchemaHandler;

public interface Validator {
	public SchemaHandler getSchemaHandler();
	public ValidationEventHandler getValidationEventHandler();
	public void setSchemaHandler(SchemaHandler schemaHandler);
	public void setValidationEventHandler(ValidationEventHandler validationEventHandler);
	
	public void validate(Object object, ModuleContext moduleContext) throws CityGMLValidateException;	
	public void validate(Object object, CityGMLVersion version) throws CityGMLValidateException;
}
