package org.citygml4j.builder.jaxb.marshal.citygml.relief;

import javax.xml.bind.JAXBElement;

import org.citygml4j.builder.jaxb.marshal.JAXBMarshaller;
import org.citygml4j.builder.jaxb.marshal.citygml.CityGMLMarshaller;
import org.citygml4j.jaxb.citygml._0_4.BreaklineReliefType;
import org.citygml4j.jaxb.citygml._0_4.MassPointReliefType;
import org.citygml4j.jaxb.citygml._0_4.ObjectFactory;
import org.citygml4j.jaxb.citygml._0_4.RasterReliefType;
import org.citygml4j.jaxb.citygml._0_4.ReliefComponentPropertyType;
import org.citygml4j.jaxb.citygml._0_4.ReliefFeatureType;
import org.citygml4j.jaxb.citygml._0_4.TINReliefType;
import org.citygml4j.jaxb.citygml._0_4.TinPropertyType;
import org.citygml4j.jaxb.citygml._0_4._ReliefComponentType;
import org.citygml4j.jaxb.gml._3_1_1.TriangulatedSurfaceType;
import org.citygml4j.model.citygml.ade.ADEComponent;
import org.citygml4j.model.citygml.relief.BreaklineRelief;
import org.citygml4j.model.citygml.relief.MassPointRelief;
import org.citygml4j.model.citygml.relief.RasterRelief;
import org.citygml4j.model.citygml.relief.ReliefComponent;
import org.citygml4j.model.citygml.relief.ReliefComponentProperty;
import org.citygml4j.model.citygml.relief.ReliefFeature;
import org.citygml4j.model.citygml.relief.ReliefModuleComponent;
import org.citygml4j.model.citygml.relief.TINRelief;
import org.citygml4j.model.citygml.relief.TinProperty;

public class Relief040Marshaller {
	private final ObjectFactory dem = new ObjectFactory();
	private final JAXBMarshaller jaxb;
	private final CityGMLMarshaller citygml;

	public Relief040Marshaller(CityGMLMarshaller citygml) {
		this.citygml = citygml;
		jaxb = citygml.getJAXBMarshaller();
	}

	public JAXBElement<?> marshalJAXBElement(Object src) {
		JAXBElement<?> dest = null;

		if (src instanceof ReliefModuleComponent)
			src = marshal(src);

		if (src instanceof BreaklineReliefType)
			dest = dem.createBreaklineRelief((BreaklineReliefType)src);
		else if (src instanceof MassPointReliefType)
			dest = dem.createMassPointRelief((MassPointReliefType)src);
		else if (src instanceof RasterReliefType)
			dest = dem.createRasterRelief((RasterReliefType)src);
		else if (src instanceof ReliefFeatureType)
			dest = dem.createReliefFeature((ReliefFeatureType)src);
		else if (src instanceof TINReliefType)
			dest = dem.createTINRelief((TINReliefType)src);

		return dest;
	}

	public Object marshal(Object src) {
		Object dest = null;

		if (src instanceof BreaklineRelief)
			dest = marshalBreaklineRelief((BreaklineRelief)src);
		else if (src instanceof MassPointRelief)
			dest = marshalMassPointRelief((MassPointRelief)src);
		else if (src instanceof RasterRelief)
			dest = marshalRasterRelief((RasterRelief)src);
		else if (src instanceof ReliefComponentProperty)
			dest = marshalReliefComponentProperty((ReliefComponentProperty)src);
		else if (src instanceof ReliefFeature)
			dest = marshalReliefFeature((ReliefFeature)src);
		else if (src instanceof TinProperty)
			dest = marshalTinProperty((TinProperty)src);
		else if (src instanceof TINRelief)
			dest = marshalTINRelief((TINRelief)src);

		return dest;
	}

	public void marshalReliefComponent(ReliefComponent src, _ReliefComponentType dest) {
		citygml.getCore040Marshaller().marshalCityObject(src, dest);

		if (src.isSetLod())
			dest.setLod(src.getLod());

		if (src.isSetExtent())
			dest.setExtent(jaxb.getGMLMarshaller().marshalPolygonProperty(src.getExtent()));

		if (src.isSetGenericApplicationPropertyOfReliefComponent()) {
			for (ADEComponent adeComponent :src.getGenericApplicationPropertyOfReliefComponent())
				if (adeComponent.isSetContent())
					dest.get_GenericApplicationPropertyOfReliefComponent().add(citygml.ade2jaxbElement(adeComponent));
		}
	}

	public void marshalBreaklineRelief(BreaklineRelief src, BreaklineReliefType dest) {
		marshalReliefComponent(src, dest);

		if (src.isSetRidgeOrValleyLines())
			dest.setRidgeOrValleyLines(jaxb.getGMLMarshaller().marshalMultiCurveProperty(src.getRidgeOrValleyLines()));

		if (src.isSetBreaklines())
			dest.setBreaklines(jaxb.getGMLMarshaller().marshalMultiCurveProperty(src.getBreaklines()));

		if (src.isSetGenericApplicationPropertyOfBreaklineRelief()) {
			for (ADEComponent adeComponent :src.getGenericApplicationPropertyOfBreaklineRelief())
				if (adeComponent.isSetContent())
					dest.get_GenericApplicationPropertyOfBreaklineRelief().add(citygml.ade2jaxbElement(adeComponent));
		}
	}

	public BreaklineReliefType marshalBreaklineRelief(BreaklineRelief src) {
		BreaklineReliefType dest = dem.createBreaklineReliefType();
		marshalBreaklineRelief(src, dest);

		return dest;
	}

	public void marshalMassPointRelief(MassPointRelief src, MassPointReliefType dest) {
		marshalReliefComponent(src, dest);

		if (src.isSetReliefPoints())
			dest.setReliefPoints(jaxb.getGMLMarshaller().marshalMultiPointProperty(src.getReliefPoints()));

		if (src.isSetGenericApplicationPropertyOfMassPointRelief()) {
			for (ADEComponent adeComponent :src.getGenericApplicationPropertyOfMassPointRelief())
				if (adeComponent.isSetContent())
					dest.get_GenericApplicationPropertyOfMassPointRelief().add(citygml.ade2jaxbElement(adeComponent));
		}
	}

	public MassPointReliefType marshalMassPointRelief(MassPointRelief src) {
		MassPointReliefType dest = dem.createMassPointReliefType();
		marshalMassPointRelief(src, dest);

		return dest;
	}

	public void marshalRasterRelief(RasterRelief src, RasterReliefType dest) {
		marshalReliefComponent(src, dest);

		if (src.isSetGenericApplicationPropertyOfRasterRelief()) {
			for (ADEComponent adeComponent :src.getGenericApplicationPropertyOfRasterRelief())
				if (adeComponent.isSetContent())
					dest.get_GenericApplicationPropertyOfRasterRelief().add(citygml.ade2jaxbElement(adeComponent));
		}
	}

	public RasterReliefType marshalRasterRelief(RasterRelief src) {
		RasterReliefType dest = dem.createRasterReliefType();
		marshalRasterRelief(src, dest);

		return dest;
	}

	public ReliefComponentPropertyType marshalReliefComponentProperty(ReliefComponentProperty src) {
		ReliefComponentPropertyType dest = dem.createReliefComponentPropertyType();
		jaxb.getGMLMarshaller().marshalAssociation(src, dest);

		if (src.isSetReliefComponent()) {
			JAXBElement<?> elem = jaxb.marshalJAXBElement(src.getReliefComponent());
			if (elem != null && elem.getValue() instanceof _ReliefComponentType)
				dest.set_Object((JAXBElement<?>)elem);
		}

		return dest;
	}

	public void marshalReliefFeature(ReliefFeature src, ReliefFeatureType dest) {
		citygml.getCore040Marshaller().marshalCityObject(src, dest);

		if (src.isSetLod())
			dest.setLod(src.getLod());

		if (src.isSetReliefComponent()) {
			for (ReliefComponentProperty reliefComponentProperty : src.getReliefComponent())
				dest.getReliefComponent().add(marshalReliefComponentProperty(reliefComponentProperty));
		}

		if (src.isSetGenericApplicationPropertyOfReliefFeature()) {
			for (ADEComponent adeComponent :src.getGenericApplicationPropertyOfReliefFeature())
				if (adeComponent.isSetContent())
					dest.get_GenericApplicationPropertyOfReliefFeature().add(citygml.ade2jaxbElement(adeComponent));
		}
	}

	public ReliefFeatureType marshalReliefFeature(ReliefFeature src) {
		ReliefFeatureType dest = dem.createReliefFeatureType();
		marshalReliefFeature(src, dest);

		return dest;
	}

	public TinPropertyType marshalTinProperty(TinProperty src) {
		TinPropertyType dest = dem.createTinPropertyType();
		jaxb.getGMLMarshaller().marshalAssociation(src, dest);

		if (src.isSetTriangulatedSurface()) {
			JAXBElement<?> elem = jaxb.marshalJAXBElement(src.getTriangulatedSurface());
			if (elem != null && elem.getValue() instanceof TriangulatedSurfaceType)
				dest.set_Object((JAXBElement<?>)elem);
		}

		return dest;
	}

	public void marshalTINRelief(TINRelief src, TINReliefType dest) {
		marshalReliefComponent(src, dest);

		if (src.isSetTin())
			dest.setTin(marshalTinProperty(src.getTin()));

		if (src.isSetGenericApplicationPropertyOfTinRelief()) {
			for (ADEComponent adeComponent :src.getGenericApplicationPropertyOfTinRelief())
				if (adeComponent.isSetContent())
					dest.get_GenericApplicationPropertyOfTinRelief().add(citygml.ade2jaxbElement(adeComponent));
		}
	}

	public TINReliefType marshalTINRelief(TINRelief src) {
		TINReliefType dest = dem.createTINReliefType();
		marshalTINRelief(src, dest);

		return dest;
	}

}