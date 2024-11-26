package com.client.cyber.success.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class User {
	
	public User(int i, String string, String string2) {
		// TODO Auto-generated constructor stub
	}

	@Id
	@GeneratedValue
	private int userId;
	private String userName;
	private String password;

	 @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
	 @JsonManagedReference
	 private List<Task> tasks;

}
