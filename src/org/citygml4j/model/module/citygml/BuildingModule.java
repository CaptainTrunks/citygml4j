package org.citygml4j.model.module.citygml;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

import org.citygml4j.model.citygml.CityGML;
import org.citygml4j.model.citygml.building.Building;
import org.citygml4j.model.citygml.building.BuildingFurniture;
import org.citygml4j.model.citygml.building.BuildingInstallation;
import org.citygml4j.model.citygml.building.BuildingPart;
import org.citygml4j.model.citygml.building.CeilingSurface;
import org.citygml4j.model.citygml.building.ClosureSurface;
import org.citygml4j.model.citygml.building.Door;
import org.citygml4j.model.citygml.building.FloorSurface;
import org.citygml4j.model.citygml.building.GroundSurface;
import org.citygml4j.model.citygml.building.IntBuildingInstallation;
import org.citygml4j.model.citygml.building.InteriorWallSurface;
import org.citygml4j.model.citygml.building.RoofSurface;
import org.citygml4j.model.citygml.building.Room;
import org.citygml4j.model.citygml.building.WallSurface;
import org.citygml4j.model.citygml.building.Window;
import org.citygml4j.model.module.Module;

public class BuildingModule extends AbstractCityGMLModule {
	private static final List<BuildingModule> instances = new ArrayList<BuildingModule>();

	public static final BuildingModule v1_0_0;
	public static final BuildingModule v0_4_0;

	private BuildingModule (
			CityGMLModuleType type, 
			CityGMLModuleVersion version,
			String namespaceURI, 
			String namespacePrefix, 
			String schemaLocation,
			Module... dependencies) {
		super(type, version, namespaceURI, namespacePrefix, schemaLocation, dependencies);		
		instances.add(this);
	}

	static {
		v1_0_0 = new BuildingModule (
				CityGMLModuleType.BUILDING,
				CityGMLModuleVersion.v1_0_0,
				"http://www.opengis.net/citygml/building/1.0",
				"bldg",
				"http://schemas.opengis.net/citygml/building/1.0/building.xsd",			
				CoreModule.v1_0_0);

		v0_4_0 = new BuildingModule (
				CityGMLModuleType.BUILDING,
				CoreModule.v0_4_0.getVersion(),
				CoreModule.v0_4_0.getNamespaceURI(),
				CoreModule.v0_4_0.getNamespacePrefix(),
				CoreModule.v0_4_0.getSchemaLocation(),		
				CoreModule.v0_4_0);
		
		v1_0_0.elementMap = new HashMap<String, Class<? extends CityGML>>();
		v1_0_0.elementMap.put("Building", Building.class);
		v1_0_0.elementMap.put("BuildingPart", BuildingPart.class);
		v1_0_0.elementMap.put("Room", Room.class);
		v1_0_0.elementMap.put("IntBuildingInstallation", IntBuildingInstallation.class);
		v1_0_0.elementMap.put("BuildingInstallation", BuildingInstallation.class);
		v1_0_0.elementMap.put("BuildingFurniture", BuildingFurniture.class);
		v1_0_0.elementMap.put("InteriorWallSurface", InteriorWallSurface.class);
		v1_0_0.elementMap.put("RoofSurface", RoofSurface.class);
		v1_0_0.elementMap.put("ClosureSurface", ClosureSurface.class);
		v1_0_0.elementMap.put("WallSurface", WallSurface.class);
		v1_0_0.elementMap.put("FloorSurface", FloorSurface.class);
		v1_0_0.elementMap.put("CeilingSurface", CeilingSurface.class);
		v1_0_0.elementMap.put("GroundSurface", GroundSurface.class);
		v1_0_0.elementMap.put("Window", Window.class);
		v1_0_0.elementMap.put("Door", Door.class);
		v0_4_0.elementMap = v1_0_0.elementMap;
		
		v1_0_0.propertySet = new HashSet<String>();
		v1_0_0.propertySet.add("address");
		v1_0_0.propertySet.add("boundedBy");
		v1_0_0.propertySet.add("opening");
		v1_0_0.propertySet.add("outerBuildingInstallation");
		v1_0_0.propertySet.add("interiorBuildingInstallation");
		v1_0_0.propertySet.add("interiorRoom");
		v1_0_0.propertySet.add("consistsOfBuildingPart");
		v1_0_0.propertySet.add("interiorFurniture");
		v1_0_0.propertySet.add("roomInstallation");
		v0_4_0.propertySet = v1_0_0.propertySet;
	}
	
	public static List<BuildingModule> getInstances() {
		return instances;
	}
}