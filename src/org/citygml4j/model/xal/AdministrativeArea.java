package org.citygml4j.model.xal;

import java.util.List;

public interface AdministrativeArea extends XALBase {
	public List<AddressLine> getAddressLine();
	public List<AdministrativeAreaName> getAdministrativeAreaName();
	public SubAdministrativeArea getSubAdministrativeArea();
	public Locality getLocality();
	public PostOffice getPostOffice();
	public PostalCode getPostalCode();
	public String getType();
	public String getUsageType();
	public String getIndicator();
	public boolean isSetAddressLine();
	public boolean isSetAdministrativeAreaName();
	public boolean isSetSubAdministrativeArea();
	public boolean isSetLocality();
	public boolean isSetPostOffice();
	public boolean isSetPostalCode();
	public boolean isSetType();
	public boolean isSetUsageType();
	public boolean isSetIndicator();
	
	public void addAddressLine(AddressLine addressLine);
	public void setAddressLine(List<AddressLine> addressLine);
	public void addAdministrativeAreaName(AdministrativeAreaName administrativeAreaName);
	public void setAdministrativeAreaName(List<AdministrativeAreaName> administrativeAreaName);
	public void setSubAdministrativeArea(SubAdministrativeArea subAdministrativeArea);
	public void setLocality(Locality locality);
	public void setPostOffice(PostOffice postOffice);
	public void setPostalCode(PostalCode postalCode);
	public void setType(String type);
	public void setUsageType(String usageType);
	public void setIndicator(String indicator);
	public void unsetAddressLine();
	public boolean unsetAddressLine(AddressLine addressLine);
	public void unsetAdministrativeAreaName();
	public boolean unsetAdministrativeAreaName(AdministrativeAreaName administrativeAreaName);
	public void unsetSubAdministrativeArea();
	public void unsetLocality();
	public void unsetPostOffice();
	public void unsetPostalCode();
	public void unsetType();
	public void unsetUsageType();
	public void unsetIndicator();
}