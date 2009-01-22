package org.citygml4j.model.citygml.ade;

import java.util.List;

public interface ADE {
	public String getNamespaceUri();	
	public List<Package> getJAXBPackages();	
	public List<ADEModelMapper> getADEModelMapper();	
	public List<ADEConvertBuilder> getADEConvertBuilder();
}