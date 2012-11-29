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
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU Lesser General Public License for more details.
 * 
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library. If not, see 
 * <http://www.gnu.org/licenses/>.
 */
package org.citygml4j.builder.jaxb.unmarshal.citygml.relief;

import javax.xml.bind.JAXBElement;
import javax.xml.namespace.QName;

import org.citygml4j.builder.jaxb.unmarshal.JAXBUnmarshaller;
import org.citygml4j.builder.jaxb.unmarshal.citygml.CityGMLUnmarshaller;
import org.citygml4j.jaxb.citygml.dem._2.AbstractReliefComponentType;
import org.citygml4j.jaxb.citygml.dem._2.BreaklineReliefType;
import org.citygml4j.jaxb.citygml.dem._2.GridPropertyType;
import org.citygml4j.jaxb.citygml.dem._2.MassPointReliefType;
import org.citygml4j.jaxb.citygml.dem._2.RasterReliefType;
import org.citygml4j.jaxb.citygml.dem._2.ReliefComponentPropertyType;
import org.citygml4j.jaxb.citygml.dem._2.ReliefFeatureType;
import org.citygml4j.jaxb.citygml.dem._2.TINReliefType;
import org.citygml4j.jaxb.citygml.dem._2.TinPropertyType;
import org.citygml4j.model.citygml.CityGML;
import org.citygml4j.model.citygml.ade.ADEComponent;
import org.citygml4j.model.citygml.relief.AbstractReliefComponent;
import org.citygml4j.model.citygml.relief.BreaklineRelief;
import org.citygml4j.model.citygml.relief.GridProperty;
import org.citygml4j.model.citygml.relief.MassPointRelief;
import org.citygml4j.model.citygml.relief.RasterRelief;
import org.citygml4j.model.citygml.relief.ReliefComponentProperty;
import org.citygml4j.model.citygml.relief.ReliefFeature;
import org.citygml4j.model.citygml.relief.TINRelief;
import org.citygml4j.model.citygml.relief.TinProperty;
import org.citygml4j.model.common.base.ModelObject;
import org.citygml4j.model.gml.geometry.primitives.TriangulatedSurface;
import org.citygml4j.model.gml.xlink.XLinkActuate;
import org.citygml4j.model.gml.xlink.XLinkShow;
import org.citygml4j.model.gml.xlink.XLinkType;
import org.citygml4j.model.module.citygml.ReliefModule;
import org.citygml4j.xml.io.reader.MissingADESchemaException;

public class Relief200Unmarshaller {
	private final ReliefModule module = ReliefModule.v2_0_0;
	private final JAXBUnmarshaller jaxb;
	private final CityGMLUnmarshaller citygml;

	public Relief200Unmarshaller(CityGMLUnmarshaller citygml) {
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
					
		if (src instanceof BreaklineReliefType)
			dest = unmarshalBreaklineRelief((BreaklineReliefType)dest);
		else if (src instanceof GridPropertyType)
			dest = unmarshalGridProperty((GridPropertyType)src);
		else if (src instanceof MassPointReliefType)
			dest = unmarshalMassPointRelief((MassPointReliefType)src);
		else if (src instanceof RasterReliefType)
			dest = unmarshalRasterRelief((RasterReliefType)src);
		else if (src instanceof ReliefComponentPropertyType)
			dest = unmarshalReliefComponentProperty((ReliefComponentPropertyType)src);
		else if (src instanceof ReliefFeatureType)
			dest = unmarshalReliefFeature((ReliefFeatureType)src);
		else if (src instanceof TinPropertyType)
			dest = unmarshalTinProperty((TinPropertyType)src);
		else if (src instanceof TINReliefType)
			dest = unmarshalTINRelief((TINReliefType)src);
		
		return dest;
	}

	public void unmarshalAbstractReliefComponent(AbstractReliefComponentType src, AbstractReliefComponent dest) throws MissingADESchemaException {
		citygml.getCore200Unmarshaller().unmarshalAbstractCityObject(src, dest);
		
		if (src.isSetLod())
			dest.setLod(src.getLod());
		
		if (src.isSetExtent())
			dest.setExtent(jaxb.getGMLUnmarshaller().unmarshalPolygonProperty(src.getExtent()));
	}
	
	public void unmarshalBreaklineRelief(BreaklineReliefType src, BreaklineRelief dest) throws MissingADESchemaException {
		unmarshalAbstractReliefComponent(src, dest);
		
		if (src.isSetRidgeOrValleyLines())
			dest.setRidgeOrValleyLines(jaxb.getGMLUnmarshaller().unmarshalMultiCurveProperty(src.getRidgeOrValleyLines()));
		
		if (src.isSetBreaklines())
			dest.setBreaklines(jaxb.getGMLUnmarshaller().unmarshalMultiCurveProperty(src.getBreaklines()));
	}
	
	public BreaklineRelief unmarshalBreaklineRelief(BreaklineReliefType src) throws MissingADESchemaException {
		BreaklineRelief dest = new BreaklineRelief(module);
		unmarshalBreaklineRelief(src, dest);

		return dest;
	}
	
	public GridProperty unmarshalGridProperty(GridPropertyType src) throws MissingADESchemaException {
		GridProperty dest = new GridProperty();
		
		if (src.isSetRectifiedGridCoverage())
			dest.setRectifiedGridCoverage(jaxb.getGMLUnmarshaller().unmarshalRectifiedGridCoverage(src.getRectifiedGridCoverage()));
		
		if (src.isSet_ADEComponent())
			dest.setGenericADEComponent(jaxb.getADEUnmarshaller().unmarshal(src.get_ADEComponent()));

		if (src.isSetRemoteSchema())
			dest.setRemoteSchema(src.getRemoteSchema());

		if (src.isSetType())
			dest.setType(XLinkType.fromValue(src.getType().value()));

		if (src.isSetHref())
			dest.setHref(src.getHref());

		if (src.isSetRole())
			dest.setRole(src.getRole());

		if (src.isSetArcrole())
			dest.setArcrole(src.getArcrole());

		if (src.isSetTitle())
			dest.setTitle(src.getTitle());

		if (src.isSetShow())
			dest.setShow(XLinkShow.fromValue(src.getShow().value()));

		if (src.isSetActuate())
			dest.setActuate(XLinkActuate.fromValue(src.getActuate().value()));
		
		return dest;
	}
	
	public void unmarshalMassPointRelief(MassPointReliefType src, MassPointRelief dest) throws MissingADESchemaException {
		unmarshalAbstractReliefComponent(src, dest);
		
		if (src.isSetReliefPoints())
			dest.setReliefPoints(jaxb.getGMLUnmarshaller().unmarshalMultiPointProperty(src.getReliefPoints()));
	}
	
	public MassPointRelief unmarshalMassPointRelief(MassPointReliefType src) throws MissingADESchemaException {
		MassPointRelief dest = new MassPointRelief(module);
		unmarshalMassPointRelief(src, dest);

		return dest;
	}
	
	public void unmarshalRasterRelief(RasterReliefType src, RasterRelief dest) throws MissingADESchemaException {
		unmarshalAbstractReliefComponent(src, dest);
		
		if (src.isSetGrid())
			dest.setGrid(unmarshalGridProperty(src.getGrid()));
	}
	
	public RasterRelief unmarshalRasterRelief(RasterReliefType src) throws MissingADESchemaException {
		RasterRelief dest = new RasterRelief(module);
		unmarshalRasterRelief(src, dest);

		return dest;
	}

	public ReliefComponentProperty unmarshalReliefComponentProperty(ReliefComponentPropertyType src) throws MissingADESchemaException {
		ReliefComponentProperty dest = new ReliefComponentProperty(module);

		if (src.isSet_ReliefComponent()) {
			ModelObject object = jaxb.unmarshal(src.get_ReliefComponent());
			if (object instanceof AbstractReliefComponent)
				dest.setObject((AbstractReliefComponent)object);
		}
		
		if (src.isSet_ADEComponent())
			dest.setGenericADEComponent(jaxb.getADEUnmarshaller().unmarshal(src.get_ADEComponent()));

		if (src.isSetRemoteSchema())
			dest.setRemoteSchema(src.getRemoteSchema());

		if (src.isSetType())
			dest.setType(XLinkType.fromValue(src.getType().value()));

		if (src.isSetHref())
			dest.setHref(src.getHref());

		if (src.isSetRole())
			dest.setRole(src.getRole());

		if (src.isSetArcrole())
			dest.setArcrole(src.getArcrole());

		if (src.isSetTitle())
			dest.setTitle(src.getTitle());

		if (src.isSetShow())
			dest.setShow(XLinkShow.fromValue(src.getShow().value()));

		if (src.isSetActuate())
			dest.setActuate(XLinkActuate.fromValue(src.getActuate().value()));

		return dest;
	}
	
	public void unmarshalReliefFeature(ReliefFeatureType src, ReliefFeature dest) throws MissingADESchemaException {
		citygml.getCore200Unmarshaller().unmarshalAbstractCityObject(src, dest);
		
		if (src.isSetLod())
			dest.setLod(src.getLod());
		
		if (src.isSetReliefComponent()) {
			for (ReliefComponentPropertyType reliefComponentProperty : src.getReliefComponent())
				dest.addReliefComponent(unmarshalReliefComponentProperty(reliefComponentProperty));
		}
	}
	
	public ReliefFeature unmarshalReliefFeature(ReliefFeatureType src) throws MissingADESchemaException {
		ReliefFeature dest = new ReliefFeature(module);
		unmarshalReliefFeature(src, dest);

		return dest;
	}

	public TinProperty unmarshalTinProperty(TinPropertyType src) throws MissingADESchemaException {
		TinProperty dest = new TinProperty(module);

		if (src.isSetTriangulatedSurface()) {
			ModelObject object = jaxb.unmarshal(src.getTriangulatedSurface());
			if (object instanceof TriangulatedSurface)
				dest.setObject((TriangulatedSurface)object);
		}
		
		if (src.isSetRemoteSchema())
			dest.setRemoteSchema(src.getRemoteSchema());

		if (src.isSetType())
			dest.setType(XLinkType.fromValue(src.getType().value()));

		if (src.isSetHref())
			dest.setHref(src.getHref());

		if (src.isSetRole())
			dest.setRole(src.getRole());

		if (src.isSetArcrole())
			dest.setArcrole(src.getArcrole());

		if (src.isSetTitle())
			dest.setTitle(src.getTitle());

		if (src.isSetShow())
			dest.setShow(XLinkShow.fromValue(src.getShow().value()));

		if (src.isSetActuate())
			dest.setActuate(XLinkActuate.fromValue(src.getActuate().value()));

		return dest;
	}
	
	public void unmarshalTINRelief(TINReliefType src, TINRelief dest) throws MissingADESchemaException {
		unmarshalAbstractReliefComponent(src, dest);
		
		if (src.isSetTin())
			dest.setTin(unmarshalTinProperty(src.getTin()));
	}
	
	public TINRelief unmarshalTINRelief(TINReliefType src) throws MissingADESchemaException {
		TINRelief dest = new TINRelief(module);
		unmarshalTINRelief(src, dest);

		return dest;
	}	
	
	public boolean assignGenericProperty(ADEComponent genericProperty, QName substitutionGroup, CityGML dest) {
		String name = substitutionGroup.getLocalPart();
		boolean success = true;
		
		if (dest instanceof AbstractReliefComponent && name.equals("_GenericApplicationPropertyOfReliefComponent"))
			((AbstractReliefComponent)dest).addGenericApplicationPropertyOfReliefComponent(genericProperty);
		else if (dest instanceof BreaklineRelief && name.equals("_GenericApplicationPropertyOfBreaklineRelief"))
			((BreaklineRelief)dest).addGenericApplicationPropertyOfBreaklineRelief(genericProperty);
		else if (dest instanceof MassPointRelief && name.equals("_GenericApplicationPropertyOfMassPointRelief"))
			((MassPointRelief)dest).addGenericApplicationPropertyOfMassPointRelief(genericProperty);
		else if (dest instanceof RasterRelief && name.equals("_GenericApplicationPropertyOfRasterRelief"))
			((RasterRelief)dest).addGenericApplicationPropertyOfRasterRelief(genericProperty);
		else if (dest instanceof ReliefFeature && name.equals("_GenericApplicationPropertyOfReliefFeature"))
			((ReliefFeature)dest).addGenericApplicationPropertyOfReliefFeature(genericProperty);
		else if (dest instanceof TINRelief && name.equals("_GenericApplicationPropertyOfTinRelief"))
			((TINRelief)dest).addGenericApplicationPropertyOfTinRelief(genericProperty);
		else 
			success = false;
		
		return success;
	}
	
}
