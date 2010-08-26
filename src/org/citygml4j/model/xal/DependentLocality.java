package org.citygml4j.model.xal;

import java.util.List;

import org.citygml4j.model.common.child.Child;
import org.citygml4j.model.common.copy.Copyable;
import org.citygml4j.model.common.visitor.XALFunctor;
import org.citygml4j.model.common.visitor.XALVisitor;

public interface DependentLocality extends XAL, Child, Copyable {
	public List<AddressLine> getAddressLine();
	public List<DependentLocalityName> getDependentLocalityName();
	public DependentLocalityNumber getDependentLocalityNumber();
	public PostBox getPostBox();
	public LargeMailUser getLargeMailUser();
	public PostOffice getPostOffice();
	public PostalRoute getPostalRoute();
	public Thoroughfare getThoroughfare(); 
	public Premise getPremise();
	public DependentLocality getDependentLocality();
	public PostalCode getPostalCode();
	public String getType();
	public String getUsageType();
	public String getConnector();
	public String getIndicator();
	public boolean isSetAddressLine();
	public boolean isSetDependentLocalityName();
	public boolean isSetDependentLocalityNumber();
	public boolean isSetPostBox();
	public boolean isSetLargeMailUser();
	public boolean isSetPostOffice();
	public boolean isSetPostalRoute();
	public boolean isSetThoroughfare(); 
	public boolean isSetPremise();
	public boolean isSetDependentLocality();
	public boolean isSetPostalCode();
	public boolean isSetType();
	public boolean isSetUsageType();
	public boolean isSetConnector();
	public boolean isSetIndicator();
	
	public void addAddressLine(AddressLine addressLine);
	public void setAddressLine(List<AddressLine> addressLine);
	public void addDependentLocalityName(DependentLocalityName dependentLocalityName);
	public void setDependentLocalityName(List<DependentLocalityName> dependentLocalityName);
	public void setDependentLocalityNumber(DependentLocalityNumber dependentLocalityNumber);
	public void setPostBox(PostBox postBox);
	public void setLargeMailUser(LargeMailUser largeMailUser);
	public void setPostOffice(PostOffice postOffice);
	public void setThoroughfare(Thoroughfare thoroughfare);
	public void setPostalRoute(PostalRoute postalRoute);
	public void setPremise(Premise premise);
	public void setDependentLocality(DependentLocality dependentLocality);
	public void setPostalCode(PostalCode postalCode);
	public void setType(String type);
	public void setUsageType(String usageType);
	public void setConnector(String connector);
	public void setIndicator(String indicator);
	public void unsetAddressLine();
	public boolean unsetAddressLine(AddressLine addressLine);
	public void unsetDependentLocalityName();
	public boolean unsetDependentLocalityName(DependentLocalityName dependentLocalityName);
	public void unsetDependentLocalityNumber();
	public void unsetPostBox();
	public void unsetLargeMailUser();
	public void unsetPostOffice();
	public void unsetPostalRoute();
	public void unsetThoroughfare(); 
	public void unsetPremise();
	public void unsetDependentLocality();
	public void unsetPostalCode();
	public void unsetType();
	public void unsetUsageType();
	public void unsetConnector();
	public void unsetIndicator();
	
	public void visit(XALVisitor visitor);
	public <T> T visit(XALFunctor<T> visitor);
}
