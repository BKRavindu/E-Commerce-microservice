package com.pm.inventoryservice;

import org.springframework.boot.SpringApplication;

public class TestInventoryServiceApplication {

	public static void main(String[] args) {
		SpringApplication.from(com.pm.inventoryservice.InventoryServiceApplication::main).with(TestcontainersConfiguration.class).run(args);
	}

}
