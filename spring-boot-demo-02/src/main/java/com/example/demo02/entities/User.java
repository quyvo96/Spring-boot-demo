package com.example.demo02.entities;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Singular;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "tb-users")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@NonNull
	@Column(unique = true)
	private String username;
	@NonNull
	private String password;

	@Singular
	@ManyToMany(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
	@JoinTable(name = "tb-users_authorities", joinColumns = {
			@JoinColumn(name = "username", referencedColumnName = "username") }, inverseJoinColumns = {
					@JoinColumn(name = "authorities_id", referencedColumnName = "id") })
	private List<Authority> authorities;

	@Builder.Default
	private Boolean accountNonExpired = true;
	@Builder.Default
	private Boolean accountNonLocked = true;
	@Builder.Default
	private Boolean credentialsNonExpired = true;
	@Builder.Default
	private Boolean enabled = true;
	private String emailAddress;
}