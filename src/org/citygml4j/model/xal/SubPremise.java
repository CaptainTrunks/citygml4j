package org.citygml4j.model.xal;

import java.util.List;

import org.citygml4j.model.common.child.Child;
import org.citygml4j.model.common.copy.Copyable;
import org.citygml4j.model.common.visitor.XALFunctor;
import org.citygml4j.model.common.visitor.XALVisitor;

public interface SubPremise extends XAL, Child, Copyable {
	public List<AddressLine> getAddressLine();
	public List<SubPremiseName> getSubPremiseName();
	public SubPremiseLocation getSubPremiseLocation();
	public List<SubPremiseNumber> getSubPremiseNumber();
	public List<SubPremiseNumberPrefix> getSubPremiseNumberPrefix();
	public List<SubPremiseNumberSuffix> getSubPremiseNumberSuffix();
	public List<BuildingName> getBuildingName();
	public Firm getFirm();
	public MailStop getMailStop();
	public PostalCode getPostalCode();
	public SubPremise getSubPremise();
	public String getType();
	public boolean isSetAddressLine();
	public boolean isSetSubPremiseName();
	public boolean isSetSubPremiseLocation();
	public boolean isSetSubPremiseNumber();
	public boolean isSetSubPremiseNumberPrefix();
	public boolean isSetSubPremiseNumberSuffix();
	public boolean isSetBuildingName();
	public boolean isSetFirm();
	public boolean isSetMailStop();
	public boolean isSetPostalCode();
	public boolean isSetSubPremise();
	public boolean isSetType();
	
	public void addAddressLine(AddressLine addressLine);
	public void setAddressLine(List<AddressLine> addressLine);
	public void addSubPremiseName(SubPremiseName subPremiseName);
	public void setSubPremiseName(List<SubPremiseName> subPremiseName);
	public void setSubPremiseLocation(SubPremiseLocation subPremiseLocation);
	public void addSubPremiseNumber(SubPremiseNumber subPremiseNumber);
	public void setSubPremiseNumber(List<SubPremiseNumber> subPremiseNumber);
	public void addSubPremiseNumberPrefix(SubPremiseNumberPrefix subPremiseNumberPrefix);
	public void setSubPremiseNumberPrefix(List<SubPremiseNumberPrefix> subPremiseNumberPrefix);
	public void addSubPremiseNumberSuffix(SubPremiseNumberSuffix subPremiseNumberSuffix);
	public void setSubPremiseNumberSuffix(List<SubPremiseNumberSuffix> subPremiseNumberSuffix);
	public void addBuildingName(BuildingName buildingName);
	public void setBuildingName(List<BuildingName> buildingName);
	public void setFirm(Firm firm);
	public void setMailStop(MailStop mailStop);
	public void setPostalCode(PostalCode postalCode);
	public void setSubPremise(SubPremise subPremise);
	public void setType(String type);
	public void unsetAddressLine();
	public boolean unsetAddressLine(AddressLine addressLine);
	public void unsetSubPremiseName();
	public boolean unsetSubPremiseName(SubPremiseName subPremiseName);
	public void unsetSubPremiseLocation();
	public void unsetSubPremiseNumber();
	public boolean unsetSubPremiseNumber(SubPremiseNumber subPremiseNumber);
	public void unsetSubPremiseNumberPrefix();
	public boolean unsetSubPremiseNumberPrefix(SubPremiseNumberPrefix subPremiseNumberPrefix);
	public void unsetSubPremiseNumberSuffix();
	public boolean unsetSubPremiseNumberSuffix(SubPremiseNumberSuffix subPremiseNumberSuffix);
	public void unsetBuildingName();
	public boolean unsetBuildingName(BuildingName buildingName);
	public void unsetFirm();
	public void unsetMailStop();
	public void unsetPostalCode();
	public void unsetSubPremise();
	public void unsetType();
	
	public void visit(XALVisitor visitor);
	public <T> T visit(XALFunctor<T> visitor);
}
