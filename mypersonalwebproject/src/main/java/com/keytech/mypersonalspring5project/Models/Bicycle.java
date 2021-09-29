package com.keytech.mypersonalspring5project.Models;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class Bicycle {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String name;
	private String usage;
	
	@ManyToMany
	@JoinTable(name = "manufacturer_bicycle", joinColumns = @JoinColumn(name = "bicycle_id"),
	inverseJoinColumns = @JoinColumn(name = "manufacturer_id"))
	Set<Manufacturer> manufacturers = new HashSet<>();

	public Bicycle() {
		super();
		
	}

	public Bicycle(String name, String usage) {
		super();
		this.name = name;
		this.usage = usage;
	}

	public Bicycle(String name, String usage, Set<Manufacturer> manufacturers) {
		super();
		this.name = name;
		this.usage = usage;
		this.manufacturers = manufacturers;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUsage() {
		return usage;
	}

	public void setUsage(String usage) {
		this.usage = usage;
	}

	public Set<Manufacturer> getManufacturers() {
		return manufacturers;
	}

	public void setManufacturers(Set<Manufacturer> manufacturers) {
		this.manufacturers = manufacturers;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Bicycle other = (Bicycle) obj;
		return Objects.equals(id, other.id);
	}
	
	
	
}
