package com.hf.springmvc.beans;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity  
@Table(name = "t_role") 
public class Role {
	@Id  
    @GeneratedValue(strategy = GenerationType.AUTO)  
    Integer id;  
    /**角色名**/  
    String name;  
    /**角色说明**/  
    String description;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}  
    
    
    
}
