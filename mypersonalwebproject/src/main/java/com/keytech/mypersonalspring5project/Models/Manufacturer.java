package com.keytech.mypersonalspring5project.Models;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Manufacturer {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String name;
	private String location;
	
	@ManyToMany(mappedBy = "manufacturers")
	private Set<Bicycle> bicycles = new HashSet<>();

	public Manufacturer() {
		super();
		 
	}

	public Manufacturer(String name, String location) {
		super();
		this.name = name;
		this.location = location;
	}

	public Manufacturer(String name, String location, Set<Bicycle> bicycles) {
		super();
		this.name = name;
		this.location = location;
		this.bicycles = bicycles;
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

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public Set<Bicycle> getBicycles() {
		return bicycles;
	}

	public void setBicycles(Set<Bicycle> bicycles) {
		this.bicycles = bicycles;
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
		Manufacturer other = (Manufacturer) obj;
		return Objects.equals(id, other.id);
	}
	
	
	
}
