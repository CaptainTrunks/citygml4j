package org.citygml4j.builder.jaxb.unmarshal.citygml.cityfurniture;

import javax.xml.bind.JAXBElement;
import javax.xml.namespace.QName;

import org.citygml4j.builder.jaxb.unmarshal.JAXBUnmarshaller;
import org.citygml4j.builder.jaxb.unmarshal.citygml.CityGMLUnmarshaller;
import org.citygml4j.impl.citygml.cityfurniture.CityFurnitureImpl;
import org.citygml4j.jaxb.citygml.frn._1.CityFurnitureType;
import org.citygml4j.model.citygml.CityGML;
import org.citygml4j.model.citygml.ade.ADEComponent;
import org.citygml4j.model.citygml.cityfurniture.CityFurniture;
import org.citygml4j.model.module.citygml.CityFurnitureModule;
import org.citygml4j.xml.io.reader.MissingADESchemaException;

public class CityFurniture100Unmarshaller {
	private final CityFurnitureModule module = CityFurnitureModule.v1_0_0;
	private final JAXBUnmarshaller jaxb;
	private final CityGMLUnmarshaller citygml;

	public CityFurniture100Unmarshaller(CityGMLUnmarshaller citygml) {
		this.citygml = citygml;
		jaxb = citygml.getJAXBUnmarshaller();
	}

	public CityGML unmarshal(JAXBElement<?> src) throws MissingADESchemaException {
		return unmarshal(src.getValue());
	}

	public CityGML unmarshal(Object src) throws MissingADESchemaException {
		if (src instanceof JAXBElement<?>)
			return unmarshal((JAXBElement<?>)src);

		CityGML dest = null;

		if (src instanceof CityFurnitureType)
			dest = unmarshalCityFurniture((CityFurnitureType)src);

		return dest;
	}

	public void unmarshalCityFurniture(CityFurnitureType src, CityFurniture dest) throws MissingADESchemaException {
		citygml.getCore100Unmarshaller().unmarshalCityObject(src, dest);

		if (src.isSetClazz())
			dest.setClazz(src.getClazz());

		if (src.isSetFunction())
			dest.setFunction(src.getFunction());

		if (src.isSetLod1Geometry())
			dest.setLod1Geometry(jaxb.getGMLUnmarshaller().unmarshalGeometryProperty(src.getLod1Geometry()));

		if (src.isSetLod2Geometry())
			dest.setLod2Geometry(jaxb.getGMLUnmarshaller().unmarshalGeometryProperty(src.getLod2Geometry()));

		if (src.isSetLod3Geometry())
			dest.setLod3Geometry(jaxb.getGMLUnmarshaller().unmarshalGeometryProperty(src.getLod3Geometry()));

		if (src.isSetLod4Geometry())
			dest.setLod4Geometry(jaxb.getGMLUnmarshaller().unmarshalGeometryProperty(src.getLod4Geometry()));

		if (src.isSetLod1ImplicitRepresentation())
			dest.setLod1ImplicitRepresentation(citygml.getCore100Unmarshaller().unmarshalImplicitRepresentationProperty(src.getLod1ImplicitRepresentation()));

		if (src.isSetLod2ImplicitRepresentation())
			dest.setLod2ImplicitRepresentation(citygml.getCore100Unmarshaller().unmarshalImplicitRepresentationProperty(src.getLod2ImplicitRepresentation()));

		if (src.isSetLod3ImplicitRepresentation())
			dest.setLod3ImplicitRepresentation(citygml.getCore100Unmarshaller().unmarshalImplicitRepresentationProperty(src.getLod3ImplicitRepresentation()));

		if (src.isSetLod4ImplicitRepresentation())
			dest.setLod4ImplicitRepresentation(citygml.getCore100Unmarshaller().unmarshalImplicitRepresentationProperty(src.getLod4ImplicitRepresentation()));

		if (src.isSetLod1TerrainIntersection())
			dest.setLod1TerrainIntersection(jaxb.getGMLUnmarshaller().unmarshalMultiCurveProperty(src.getLod1TerrainIntersection()));

		if (src.isSetLod2TerrainIntersection())
			dest.setLod2TerrainIntersection(jaxb.getGMLUnmarshaller().unmarshalMultiCurveProperty(src.getLod2TerrainIntersection()));

		if (src.isSetLod3TerrainIntersection())
			dest.setLod3TerrainIntersection(jaxb.getGMLUnmarshaller().unmarshalMultiCurveProperty(src.getLod3TerrainIntersection()));

		if (src.isSetLod4TerrainIntersection())
			dest.setLod4TerrainIntersection(jaxb.getGMLUnmarshaller().unmarshalMultiCurveProperty(src.getLod4TerrainIntersection()));
	}

	public CityFurniture unmarshalCityFurniture(CityFurnitureType src) throws MissingADESchemaException {
		CityFurniture dest = new CityFurnitureImpl(module);
		unmarshalCityFurniture(src, dest);

		return dest;
	}
	
	public boolean assignGenericProperty(ADEComponent genericProperty, QName substitutionGroup, CityGML dest) {
		String name = substitutionGroup.getLocalPart();
		boolean success = true;
		
		if (dest instanceof CityFurniture && name.equals("_GenericApplicationPropertyOfCityFurniture"))
			((CityFurniture)dest).addGenericApplicationPropertyOfCityFurniture(genericProperty);		
		else
			success = false;
		
		return success;
	}

}
