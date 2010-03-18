package org.citygml4j.impl.citygml.vegetation;

import java.util.ArrayList;
import java.util.List;

import org.citygml4j.builder.copy.CopyBuilder;
import org.citygml4j.commons.child.ChildList;
import org.citygml4j.impl.gml.BoundingShapeImpl;
import org.citygml4j.model.citygml.CityGMLClass;
import org.citygml4j.model.citygml.ade.ADEComponent;
import org.citygml4j.model.citygml.core.ImplicitRepresentationProperty;
import org.citygml4j.model.citygml.vegetation.SolitaryVegetationObject;
import org.citygml4j.model.gml.BoundingShape;
import org.citygml4j.model.gml.GeometryProperty;
import org.citygml4j.model.gml.Length;
import org.citygml4j.model.module.citygml.VegetationModule;
import org.citygml4j.visitor.GMLFunction;
import org.citygml4j.visitor.GMLVisitor;
import org.citygml4j.visitor.FeatureFunction;
import org.citygml4j.visitor.FeatureVisitor;

public class SolitaryVegetationObjectImpl extends VegetationObjectImpl implements SolitaryVegetationObject {
	private String clazz;
	private List<String> function;
	private String species;
	private Length height;
	private Length trunkDiameter;
	private Length crownDiameter;
	private GeometryProperty lod1Geometry;
	private GeometryProperty lod2Geometry;
	private GeometryProperty lod3Geometry;
	private GeometryProperty lod4Geometry;
	private ImplicitRepresentationProperty lod1ImplicitRepresentation;
	private ImplicitRepresentationProperty lod2ImplicitRepresentation;
	private ImplicitRepresentationProperty lod3ImplicitRepresentation;
	private ImplicitRepresentationProperty lod4ImplicitRepresentation;
	private List<ADEComponent> ade;
	
	public SolitaryVegetationObjectImpl() {

	}

	public SolitaryVegetationObjectImpl(VegetationModule module) {
		super(module);
	}
	
	public void addFunction(String function) {
		if (this.function == null)
			this.function = new ArrayList<String>();
		
		this.function.add(function);
	}

	public void addGenericApplicationPropertyOfSolitaryVegetationObject(ADEComponent ade) {
		if (this.ade == null)
			this.ade = new ChildList<ADEComponent>(this);

		this.ade.add(ade);
	}

	public String getClazz() {
		return clazz;
	}

	public Length getCrownDiameter() {
		return crownDiameter;
	}

	public List<String> getFunction() {
		if (function == null)
			function = new ArrayList<String>();
		
		return function;
	}

	public List<ADEComponent> getGenericApplicationPropertyOfSolitaryVegetationObject() {
		if (ade == null)
			ade = new ChildList<ADEComponent>(this);

		return ade;
	}

	public Length getHeight() {
		return height;
	}

	public GeometryProperty getLod1Geometry() {
		return lod1Geometry;
	}

	public ImplicitRepresentationProperty getLod1ImplicitRepresentation() {
		return lod1ImplicitRepresentation;
	}

	public GeometryProperty getLod2Geometry() {
		return lod2Geometry;
	}

	public ImplicitRepresentationProperty getLod2ImplicitRepresentation() {
		return lod2ImplicitRepresentation;
	}

	public GeometryProperty getLod3Geometry() {
		return lod3Geometry;
	}

	public ImplicitRepresentationProperty getLod3ImplicitRepresentation() {
		return lod3ImplicitRepresentation;
	}

	public GeometryProperty getLod4Geometry() {
		return lod4Geometry;
	}

	public ImplicitRepresentationProperty getLod4ImplicitRepresentation() {
		return lod4ImplicitRepresentation;
	}

	public String getSpecies() {
		return species;
	}

	public Length getTrunkDiameter() {
		return trunkDiameter;
	}

	public boolean isSetClazz() {
		return clazz != null;
	}

	public boolean isSetCrownDiameter() {
		return crownDiameter != null;
	}

	public boolean isSetFunction() {
		return function != null && !function.isEmpty();
	}

	public boolean isSetGenericApplicationPropertyOfSolitaryVegetationObject() {
		return ade != null && !ade.isEmpty();
	}

	public boolean isSetHeight() {
		return height != null;
	}

	public boolean isSetLod1Geometry() {
		return lod1Geometry != null;
	}

	public boolean isSetLod1ImplicitRepresentation() {
		return lod1ImplicitRepresentation != null;
	}

	public boolean isSetLod2Geometry() {
		return lod2Geometry != null;
	}

	public boolean isSetLod2ImplicitRepresentation() {
		return lod2ImplicitRepresentation != null;
	}

	public boolean isSetLod3Geometry() {
		return lod3Geometry != null;
	}

	public boolean isSetLod3ImplicitRepresentation() {
		return lod3ImplicitRepresentation != null;
	}

	public boolean isSetLod4Geometry() {
		return lod4Geometry != null;
	}

	public boolean isSetLod4ImplicitRepresentation() {
		return lod4ImplicitRepresentation != null;
	}

	public boolean isSetSpecies() {
		return species != null;
	}

	public boolean isSetTrunkDiameter() {
		return trunkDiameter != null;
	}

	public void setClazz(String clazz) {
		this.clazz = clazz;
	}

	public void setCrownDiameter(Length crownDiameter) {
		if (crownDiameter != null)
			crownDiameter.setParent(this);
		
		this.crownDiameter = crownDiameter;
	}

	public void setFunction(List<String> function) {
		this.function = function;
	}

	public void setGenericApplicationPropertyOfSolitaryVegetationObject(List<ADEComponent> ade) {
		this.ade = new ChildList<ADEComponent>(this, ade);
	}

	public void setHeight(Length height) {
		if (height != null)
			height.setParent(this);
		
		this.height = height;
	}

	public void setLod1Geometry(GeometryProperty lod1Geometry) {
		if (lod1Geometry != null)
			lod1Geometry.setParent(this);
		
		this.lod1Geometry = lod1Geometry;
	}

	public void setLod1ImplicitRepresentation(ImplicitRepresentationProperty lod1ImplicitRepresentation) {
		if (lod1ImplicitRepresentation != null)
			lod1ImplicitRepresentation.setParent(this);
		
		this.lod1ImplicitRepresentation = lod1ImplicitRepresentation;
	}

	public void setLod2Geometry(GeometryProperty lod2Geometry) {
		if (lod2Geometry != null)
			lod2Geometry.setParent(this);
		
		this.lod2Geometry = lod2Geometry;
	}

	public void setLod2ImplicitRepresentation(ImplicitRepresentationProperty lod2ImplicitRepresentation) {
		if (lod2ImplicitRepresentation != null)
			lod2ImplicitRepresentation.setParent(this);
		
		this.lod2ImplicitRepresentation = lod2ImplicitRepresentation;
	}

	public void setLod3Geometry(GeometryProperty lod3Geometry) {
		if (lod3Geometry != null)
			lod3Geometry.setParent(this);
		
		this.lod3Geometry = lod3Geometry;
	}

	public void setLod3ImplicitRepresentation(ImplicitRepresentationProperty lod3ImplicitRepresentation) {
		if (lod3ImplicitRepresentation != null)
			lod3ImplicitRepresentation.setParent(this);
		
		this.lod3ImplicitRepresentation = lod3ImplicitRepresentation;
	}

	public void setLod4Geometry(GeometryProperty lod4Geometry) {
		if (lod4Geometry != null)
			lod4Geometry.setParent(this);
		
		this.lod4Geometry = lod4Geometry;
	}

	public void setLod4ImplicitRepresentation(ImplicitRepresentationProperty lod4ImplicitRepresentation) {
		if (lod4ImplicitRepresentation != null)
			lod4ImplicitRepresentation.setParent(this);
		
		this.lod4ImplicitRepresentation = lod4ImplicitRepresentation;
	}

	public void setSpecies(String species) {
		this.species = species;
	}

	public void setTrunkDiameter(Length trunkDiameter) {
		if (trunkDiameter != null)
			trunkDiameter.setParent(this);
		
		this.trunkDiameter = trunkDiameter;
	}

	public void unsetClazz() {
		clazz = null;
	}

	public void unsetCrownDiameter() {
		if (isSetCrownDiameter())
			crownDiameter.unsetParent();
		
		crownDiameter = null;
	}

	public void unsetFunction() {
		function = null;
	}

	public boolean unsetFunction(String function) {
		return isSetFunction() ? this.function.remove(function) : false;
	}

	public void unsetGenericApplicationPropertyOfSolitaryVegetationObject() {
		if (isSetGenericApplicationPropertyOfSolitaryVegetationObject())
			ade.clear();

		ade = null;
	}

	public boolean unsetGenericApplicationPropertyOfSolitaryVegetationObject(ADEComponent ade) {
		return isSetGenericApplicationPropertyOfSolitaryVegetationObject() ? this.ade.remove(ade) : false;
	}

	public void unsetHeight() {
		if (isSetHeight())
			height.unsetParent();
		
		height = null;
	}

	public void unsetLod1Geometry() {
		if (isSetLod1Geometry())
			lod1Geometry.unsetParent();
		
		lod1Geometry = null;
	}

	public void unsetLod1ImplicitRepresentation() {
		if (isSetLod1ImplicitRepresentation())
			lod1ImplicitRepresentation.unsetParent();
		
		lod1ImplicitRepresentation = null;
	}

	public void unsetLod2Geometry() {
		if (isSetLod2Geometry())
			lod2Geometry.unsetParent();
		
		lod2Geometry = null;
	}

	public void unsetLod2ImplicitRepresentation() {
		if (isSetLod2ImplicitRepresentation())
			lod2ImplicitRepresentation.unsetParent();
		
		lod2ImplicitRepresentation = null;
	}

	public void unsetLod3Geometry() {
		if (isSetLod3Geometry())
			lod3Geometry.unsetParent();
		
		lod3Geometry = null;
	}

	public void unsetLod3ImplicitRepresentation() {
		if (isSetLod3ImplicitRepresentation())
			lod3ImplicitRepresentation.unsetParent();
		
		lod3ImplicitRepresentation = null;
	}

	public void unsetLod4Geometry() {
		if (isSetLod4Geometry())
			lod4Geometry.unsetParent();
		
		lod4Geometry = null;
	}

	public void unsetLod4ImplicitRepresentation() {
		if (isSetLod4ImplicitRepresentation())
			lod4ImplicitRepresentation.unsetParent();
		
		lod4ImplicitRepresentation = null;
	}

	public void unsetSpecies() {
		species = null;
	}

	public void unsetTrunkDiameter() {
		if (isSetTrunkDiameter())
			trunkDiameter.unsetParent();
		
		trunkDiameter = null;
	}

	@Override
	public BoundingShape calcBoundedBy(boolean setBoundedBy) {
		BoundingShape boundedBy = new BoundingShapeImpl();
		GeometryProperty geometryProperty = null;

		for (int lod = 1; lod < 5; lod++) {
			switch (lod) {
			case 1:
				geometryProperty = lod1Geometry;
				break;
			case 2:
				geometryProperty = lod2Geometry;
				break;
			case 3:
				geometryProperty = lod3Geometry;
				break;
			case 4:
				geometryProperty = lod4Geometry;
				break;
			}
			
			if (geometryProperty != null) {
				if (geometryProperty.isSetGeometry()) {
					calcBoundedBy(boundedBy, geometryProperty.getGeometry());
				} else {
					// xlink
				}
			}
		}
		
		if (boundedBy.isSetEnvelope()) {
			if (setBoundedBy)
				setBoundedBy(boundedBy);

			return boundedBy;
		} else
			return null;
	}

	@Override
	public CityGMLClass getCityGMLClass() {
		return CityGMLClass.SOLITARYVEGETATIONOBJECT;
	}

	public Object copy(CopyBuilder copyBuilder) {
		return copyTo(new SolitaryVegetationObjectImpl(), copyBuilder);
	}

	@SuppressWarnings("unchecked")
	@Override
	public Object copyTo(Object target, CopyBuilder copyBuilder) {
		SolitaryVegetationObject copy = (target == null) ? new SolitaryVegetationObjectImpl() : (SolitaryVegetationObject)target;
		super.copyTo(copy, copyBuilder);
		
		if (isSetClazz())
			copy.setClazz(copyBuilder.copy(clazz));

		if (isSetFunction())
			copy.setFunction((List<String>)copyBuilder.copy(function));
		
		if (isSetSpecies())
			copy.setSpecies(copyBuilder.copy(species));
		
		if (isSetHeight()) {
			copy.setHeight((Length)copyBuilder.copy(height));
			if (copy.getHeight() == height)
				height.setParent(this);
		}
		
		if (isSetTrunkDiameter()) {
			copy.setTrunkDiameter((Length)copyBuilder.copy(trunkDiameter));
			if (copy.getTrunkDiameter() == trunkDiameter)
				trunkDiameter.setParent(this);
		}
		
		if (isSetCrownDiameter()) {
			copy.setCrownDiameter((Length)copyBuilder.copy(crownDiameter));
			if (copy.getCrownDiameter() == crownDiameter)
				crownDiameter.setParent(this);
		}
		
		if (isSetLod1Geometry()) {
			copy.setLod1Geometry((GeometryProperty)copyBuilder.copy(lod1Geometry));
			if (copy.getLod1Geometry() == lod1Geometry)
				lod1Geometry.setParent(this);
		}

		if (isSetLod2Geometry()) {
			copy.setLod2Geometry((GeometryProperty)copyBuilder.copy(lod2Geometry));
			if (copy.getLod2Geometry() == lod2Geometry)
				lod2Geometry.setParent(this);
		}
		
		if (isSetLod3Geometry()) {
			copy.setLod3Geometry((GeometryProperty)copyBuilder.copy(lod3Geometry));
			if (copy.getLod3Geometry() == lod3Geometry)
				lod3Geometry.setParent(this);
		}
		
		if (isSetLod4Geometry()) {
			copy.setLod4Geometry((GeometryProperty)copyBuilder.copy(lod4Geometry));
			if (copy.getLod4Geometry() == lod4Geometry)
				lod4Geometry.setParent(this);
		}
		
		if (isSetLod1ImplicitRepresentation()) {
			copy.setLod1ImplicitRepresentation((ImplicitRepresentationProperty)copyBuilder.copy(lod1ImplicitRepresentation));
			if (copy.getLod1ImplicitRepresentation() == lod1ImplicitRepresentation)
				lod1ImplicitRepresentation.setParent(this);
		}
		
		if (isSetLod2ImplicitRepresentation()) {
			copy.setLod2ImplicitRepresentation((ImplicitRepresentationProperty)copyBuilder.copy(lod2ImplicitRepresentation));
			if (copy.getLod2ImplicitRepresentation() == lod2ImplicitRepresentation)
				lod2ImplicitRepresentation.setParent(this);
		}
		
		if (isSetLod3ImplicitRepresentation()) {
			copy.setLod3ImplicitRepresentation((ImplicitRepresentationProperty)copyBuilder.copy(lod3ImplicitRepresentation));
			if (copy.getLod3ImplicitRepresentation() == lod3ImplicitRepresentation)
				lod3ImplicitRepresentation.setParent(this);
		}
		
		if (isSetLod4ImplicitRepresentation()) {
			copy.setLod4ImplicitRepresentation((ImplicitRepresentationProperty)copyBuilder.copy(lod4ImplicitRepresentation));
			if (copy.getLod4ImplicitRepresentation() == lod4ImplicitRepresentation)
				lod4ImplicitRepresentation.setParent(this);
		}
		
		if (isSetGenericApplicationPropertyOfSolitaryVegetationObject()) {
			for (ADEComponent part : ade) {
				ADEComponent copyPart = (ADEComponent)copyBuilder.copy(part);
				copy.addGenericApplicationPropertyOfSolitaryVegetationObject(copyPart);

				if (part != null && copyPart == part)
					part.setParent(this);
			}
		}

		return copy;
	}
	
	public void visit(FeatureVisitor visitor) {
		visitor.accept(this);
	}
	
	public <T> T apply(FeatureFunction<T> visitor) {
		return visitor.accept(this);
	}
	
	public void visit(GMLVisitor visitor) {
		visitor.accept(this);
	}
	
	public <T> T apply(GMLFunction<T> visitor) {
		return visitor.accept(this);
	}

}