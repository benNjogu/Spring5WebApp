package com.keytech.mypersonalspring5project.Bootstrap;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import com.keytech.mypersonalspring5project.Models.Bicycle;
import com.keytech.mypersonalspring5project.Models.Manufacturer;
import com.keytech.mypersonalspring5project.Repositories.BicycleRepository;
import com.keytech.mypersonalspring5project.Repositories.ManufacturerRepository;

@Component
public class Bootstrap implements ApplicationListener<ContextRefreshedEvent>{

	private BicycleRepository bicycleRepository;
	private ManufacturerRepository manufacturerRepository;

	public Bootstrap(BicycleRepository bicycleRepository, ManufacturerRepository manufacturerRepository) {
		super();
		this.bicycleRepository = bicycleRepository;
		this.manufacturerRepository = manufacturerRepository;
	}
	
	private void initData() {
		
		Manufacturer manufacturer = new Manufacturer("Liangfeng", "China");
		Bicycle bicycle = new Bicycle("Liangfeng", "mountain");
		manufacturer.getBicycles().add(bicycle);
		bicycle.getManufacturers().add(manufacturer);
		

		manufacturerRepository.save(manufacturer);
		bicycleRepository.save(bicycle);
		
		Manufacturer manufacturer2 = new Manufacturer("Beijing", "China");
		Bicycle bicycle2 = new Bicycle("Beijing", "moutain");
		manufacturer2.getBicycles().add(bicycle2);
		bicycle2.getManufacturers().add(manufacturer2);

		manufacturerRepository.save(manufacturer2);
		bicycleRepository.save(bicycle2);
		
		Manufacturer manufacturer3 = new Manufacturer("Swing", "UK");
		Bicycle bicycle3 = new Bicycle("Swing", "OffRoad");
		manufacturer3.getBicycles().add(bicycle3);
		bicycle3.getManufacturers().add(manufacturer3);

		manufacturerRepository.save(manufacturer3);
		bicycleRepository.save(bicycle3);
		
	}

	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		initData();
	}

	
	
	

}
