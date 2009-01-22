package org.citygml4j.impl.jaxb.citygml;

import org.citygml4j.impl.jaxb.citygml.relief._0_4.Relief040FactoryImpl;
import org.citygml4j.impl.jaxb.citygml.relief._1.Relief100FactoryImpl;
import org.citygml4j.model.citygml.relief.BreaklineRelief;
import org.citygml4j.model.citygml.relief.MassPointRelief;
import org.citygml4j.model.citygml.relief.RasterRelief;
import org.citygml4j.model.citygml.relief.ReliefComponentProperty;
import org.citygml4j.model.citygml.relief.ReliefFactory;
import org.citygml4j.model.citygml.relief.ReliefFeature;
import org.citygml4j.model.citygml.relief.ReliefModule;
import org.citygml4j.model.citygml.relief.TINRelief;
import org.citygml4j.model.citygml.relief.TinProperty;

public abstract class AbstractReliefFactoryImpl implements ReliefFactory {
	private static Relief040FactoryImpl factory040 = new Relief040FactoryImpl();
	private static Relief100FactoryImpl factory100 = new Relief100FactoryImpl();
	
	public static ReliefFactory getInstance(ReliefModule module) {
		switch (module) {
		case v0_4_0:
			return factory040;
		default:
			return factory100;
		}
	}
	
	@Override
	public abstract BreaklineRelief createBreaklineRelief();

	@Override
	public abstract MassPointRelief createMassPointRelief();

	@Override
	public abstract RasterRelief createRasterRelief();

	@Override
	public abstract ReliefComponentProperty createReliefComponentProperty();

	@Override
	public abstract ReliefFeature createReliefFeature();

	@Override
	public abstract TINRelief createTINRelief();

	@Override
	public abstract TinProperty createTinProperty();

}