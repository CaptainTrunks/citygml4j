package org.citygml4j.impl.jaxb.citygml.relief._1;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.xml.bind.JAXBElement;

import org.citygml4j.impl.jaxb.ModelMapper;
import org.citygml4j.jaxb.citygml.dem._1.RasterReliefType;
import org.citygml4j.model.citygml.CityGMLClass;
import org.citygml4j.model.citygml.ade.ADEComponent;
import org.citygml4j.model.citygml.relief.RasterRelief;

public class RasterReliefImpl extends ReliefComponentImpl implements RasterRelief {
	private RasterReliefType rasterReliefType;

	public RasterReliefImpl() {
		this(new RasterReliefType());
	}

	public RasterReliefImpl(RasterReliefType rasterReliefType) {
		super(rasterReliefType);
		this.rasterReliefType = rasterReliefType;
	}

	@Override
	public CityGMLClass getCityGMLClass() {
		return CityGMLClass.RASTERRELIEF;
	}

	@Override
	public RasterReliefType getJAXBObject() {
		return rasterReliefType;
	}

	@Override
	public void calcBoundedBy() {
		super.calcBoundedBy();
	}

	@Override
	public void addGenericApplicationPropertyOfRasterRelief(ADEComponent adeObject) {
		JAXBElement<?> jaxbElem = ModelMapper.ADE.toJAXB(adeObject);
		if (jaxbElem != null)
			rasterReliefType.get_GenericApplicationPropertyOfRasterRelief().add(jaxbElem);
	}

	@Override
	public List<ADEComponent> getGenericApplicationPropertyOfRasterRelief() {
		List<ADEComponent> adeList = new ArrayList<ADEComponent>();

		for (JAXBElement<?> elem : rasterReliefType.get_GenericApplicationPropertyOfRasterRelief()) {
			if (elem.getValue() != null) {
				ADEComponent ade = ModelMapper.ADE.toADEComponent(elem.getValue(), elem.getName());
				if (ade != null)
					adeList.add(ade);
			}
		}

		return adeList;
	}

	@Override
	public void setGenericApplicationPropertyOfRasterRelief(List<ADEComponent> adeObject) {
		List<JAXBElement<?>> elemList = new ArrayList<JAXBElement<?>>();

		for (ADEComponent ade : adeObject) {
			JAXBElement<?> elem = ModelMapper.ADE.toJAXB(ade);
			if (elem != null)
				elemList.add(elem);
		}

		if (!elemList.isEmpty()) {
			rasterReliefType.unset_GenericApplicationPropertyOfRasterRelief();
			rasterReliefType.get_GenericApplicationPropertyOfRasterRelief().addAll(elemList);
		}
	}

	@Override
	public boolean isSetGenericApplicationPropertyOfRasterRelief() {
		return rasterReliefType.isSet_GenericApplicationPropertyOfRasterRelief();
	}

	@Override
	public void unsetGenericApplicationPropertyOfRasterRelief() {
		rasterReliefType.unset_GenericApplicationPropertyOfRasterRelief();
	}
	
	@Override
	public boolean unsetGenericApplicationPropertyOfRasterRelief(ADEComponent adeObject) {
		if (rasterReliefType.isSet_GenericApplicationPropertyOfRasterRelief()) {
			Iterator<JAXBElement<?>> iter = rasterReliefType.get_GenericApplicationPropertyOfRasterRelief().iterator();
			while (iter.hasNext()) {
				JAXBElement<?> elem = iter.next();
				if (elem.getValue() != null && elem.getValue().equals(adeObject.getJAXBObject())) {
					iter.remove();
					return true;
				}
			}				
		}

		return false;
	}
	
}
