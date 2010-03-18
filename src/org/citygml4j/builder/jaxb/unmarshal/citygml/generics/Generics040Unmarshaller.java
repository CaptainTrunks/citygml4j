package org.citygml4j.builder.jaxb.unmarshal.citygml.generics;

import javax.xml.bind.JAXBElement;

import org.citygml4j.builder.jaxb.unmarshal.JAXBUnmarshaller;
import org.citygml4j.builder.jaxb.unmarshal.citygml.CityGMLUnmarshaller;
import org.citygml4j.impl.citygml.generics.DateAttributeImpl;
import org.citygml4j.impl.citygml.generics.DoubleAttributeImpl;
import org.citygml4j.impl.citygml.generics.GenericCityObjectImpl;
import org.citygml4j.impl.citygml.generics.IntAttributeImpl;
import org.citygml4j.impl.citygml.generics.StringAttributeImpl;
import org.citygml4j.impl.citygml.generics.UriAttributeImpl;
import org.citygml4j.jaxb.citygml._0_4.DateAttributeType;
import org.citygml4j.jaxb.citygml._0_4.DoubleAttributeType;
import org.citygml4j.jaxb.citygml._0_4.GenericCityObjectType;
import org.citygml4j.jaxb.citygml._0_4.IntAttributeType;
import org.citygml4j.jaxb.citygml._0_4.StringAttributeType;
import org.citygml4j.jaxb.citygml._0_4.UriAttributeType;
import org.citygml4j.jaxb.citygml._0_4._GenericAttributeType;
import org.citygml4j.model.citygml.CityGML;
import org.citygml4j.model.citygml.generics.DateAttribute;
import org.citygml4j.model.citygml.generics.DoubleAttribute;
import org.citygml4j.model.citygml.generics.GenericAttribute;
import org.citygml4j.model.citygml.generics.GenericCityObject;
import org.citygml4j.model.citygml.generics.IntAttribute;
import org.citygml4j.model.citygml.generics.StringAttribute;
import org.citygml4j.model.citygml.generics.UriAttribute;
import org.citygml4j.model.module.citygml.GenericsModule;
import org.citygml4j.xml.io.reader.MissingADESchemaException;

public class Generics040Unmarshaller {
	private final GenericsModule module = GenericsModule.v0_4_0;
	private final JAXBUnmarshaller jaxb;
	private final CityGMLUnmarshaller citygml;

	public Generics040Unmarshaller(CityGMLUnmarshaller citygml) {
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

		if (src instanceof GenericCityObjectType)
			dest = unmarshalGenericCityObject((GenericCityObjectType)src);
		else if (src instanceof DateAttributeType)
			dest = unmarshalDateAttribute((DateAttributeType)src);
		else if (src instanceof DoubleAttributeType)
			dest = unmarshalDoubleAttribute((DoubleAttributeType)src);
		else if (src instanceof IntAttributeType)
			dest = unmarshalIntAttribute((IntAttributeType)src);
		else if (src instanceof StringAttributeType)
			dest = unmarshalStringAttribute((StringAttributeType)src);
		else if (src instanceof UriAttributeType)
			dest = unmarshalUriAttribute((UriAttributeType)src);

		return dest;
	}

	public void unmarshalGenericAttribute(_GenericAttributeType src, GenericAttribute dest) {
		if (src.isSetName())
			dest.setName(src.getName());
	}

	public void unmarshalGenericCityObject(GenericCityObjectType src, GenericCityObject dest) throws MissingADESchemaException {
		citygml.getCore040Unmarshaller().unmarshalCityObject(src, dest);

		if (src.isSetClazz())
			dest.setClazz(src.getClazz());

		if (src.isSetFunction())
			dest.setFunction(src.getFunction());

		if (src.isSetUsage())
			dest.setUsage(src.getUsage());

		if (src.isSetLod0Geometry())
			dest.setLod0Geometry(jaxb.getGMLUnmarshaller().unmarshalGeometryProperty(src.getLod0Geometry()));

		if (src.isSetLod1Geometry())
			dest.setLod1Geometry(jaxb.getGMLUnmarshaller().unmarshalGeometryProperty(src.getLod1Geometry()));

		if (src.isSetLod2Geometry())
			dest.setLod2Geometry(jaxb.getGMLUnmarshaller().unmarshalGeometryProperty(src.getLod2Geometry()));

		if (src.isSetLod3Geometry())
			dest.setLod3Geometry(jaxb.getGMLUnmarshaller().unmarshalGeometryProperty(src.getLod3Geometry()));

		if (src.isSetLod4Geometry())
			dest.setLod4Geometry(jaxb.getGMLUnmarshaller().unmarshalGeometryProperty(src.getLod4Geometry()));

		if (src.isSetLod0ImplicitRepresentation())
			dest.setLod0ImplicitRepresentation(citygml.getCore040Unmarshaller().unmarshalImplicitRepresentationProperty(src.getLod0ImplicitRepresentation()));

		if (src.isSetLod1ImplicitRepresentation())
			dest.setLod1ImplicitRepresentation(citygml.getCore040Unmarshaller().unmarshalImplicitRepresentationProperty(src.getLod1ImplicitRepresentation()));

		if (src.isSetLod2ImplicitRepresentation())
			dest.setLod2ImplicitRepresentation(citygml.getCore040Unmarshaller().unmarshalImplicitRepresentationProperty(src.getLod2ImplicitRepresentation()));

		if (src.isSetLod3ImplicitRepresentation())
			dest.setLod3ImplicitRepresentation(citygml.getCore040Unmarshaller().unmarshalImplicitRepresentationProperty(src.getLod3ImplicitRepresentation()));

		if (src.isSetLod4ImplicitRepresentation())
			dest.setLod4ImplicitRepresentation(citygml.getCore040Unmarshaller().unmarshalImplicitRepresentationProperty(src.getLod4ImplicitRepresentation()));

		if (src.isSetLod0TerrainIntersection())
			dest.setLod0TerrainIntersection(jaxb.getGMLUnmarshaller().unmarshalMultiCurveProperty(src.getLod0TerrainIntersection()));

		if (src.isSetLod1TerrainIntersection())
			dest.setLod1TerrainIntersection(jaxb.getGMLUnmarshaller().unmarshalMultiCurveProperty(src.getLod1TerrainIntersection()));

		if (src.isSetLod2TerrainIntersection())
			dest.setLod2TerrainIntersection(jaxb.getGMLUnmarshaller().unmarshalMultiCurveProperty(src.getLod2TerrainIntersection()));

		if (src.isSetLod3TerrainIntersection())
			dest.setLod3TerrainIntersection(jaxb.getGMLUnmarshaller().unmarshalMultiCurveProperty(src.getLod3TerrainIntersection()));

		if (src.isSetLod4TerrainIntersection())
			dest.setLod4TerrainIntersection(jaxb.getGMLUnmarshaller().unmarshalMultiCurveProperty(src.getLod4TerrainIntersection()));
	}

	public GenericCityObject unmarshalGenericCityObject(GenericCityObjectType src) throws MissingADESchemaException {
		GenericCityObject dest = new GenericCityObjectImpl(module);
		unmarshalGenericCityObject(src, dest);

		return dest;
	}

	public void unmarshalDateAttribute(DateAttributeType src, DateAttribute dest) {
		unmarshalGenericAttribute(src, dest);

		if (src.isSetValue())
			dest.setValue(src.getValue().toGregorianCalendar());
	}

	public DateAttribute unmarshalDateAttribute(DateAttributeType src) {
		DateAttribute dest = new DateAttributeImpl(module);
		unmarshalDateAttribute(src, dest);

		return dest;		
	}

	public void unmarshalDoubleAttribute(DoubleAttributeType src, DoubleAttribute dest) {
		unmarshalGenericAttribute(src, dest);

		if (src.isSetValue())
			dest.setValue(src.getValue());
	}

	public DoubleAttribute unmarshalDoubleAttribute(DoubleAttributeType src) {
		DoubleAttribute dest = new DoubleAttributeImpl(module);
		unmarshalDoubleAttribute(src, dest);

		return dest;		
	}

	public void unmarshalIntAttribute(IntAttributeType src, IntAttribute dest) {
		unmarshalGenericAttribute(src, dest);

		if (src.isSetValue())
			dest.setValue(src.getValue().intValue());
	}

	public IntAttribute unmarshalIntAttribute(IntAttributeType src) {
		IntAttribute dest = new IntAttributeImpl(module);
		unmarshalIntAttribute(src, dest);

		return dest;		
	}

	public void unmarshalStringAttribute(StringAttributeType src, StringAttribute dest) {
		unmarshalGenericAttribute(src, dest);

		if (src.isSetValue())
			dest.setValue(src.getValue());
	}

	public StringAttribute unmarshalStringAttribute(StringAttributeType src) {
		StringAttribute dest = new StringAttributeImpl(module);
		unmarshalStringAttribute(src, dest);

		return dest;		
	}

	public void unmarshalUriAttribute(UriAttributeType src, UriAttribute dest) {
		unmarshalGenericAttribute(src, dest);

		if (src.isSetValue())
			dest.setValue(src.getValue());
	}

	public UriAttribute unmarshalUriAttribute(UriAttributeType src) {
		UriAttribute dest = new UriAttributeImpl(module);
		unmarshalUriAttribute(src, dest);

		return dest;		
	}

}