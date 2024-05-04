package com.catfi8h.blog.repository.entities;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.util.List;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
public class Account {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String username;
	private String password;
	private String email;
	private String firstName;
	private String lastName;
	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
//	(fetch = FetchType.EAGER, optional = false)
	@JoinColumn(name = "role_id", referencedColumnName = "id")
//	@OnDelete(action = OnDeleteAction.RESTRICT)
	private Role role;
	
	@OneToMany(mappedBy = "account")
	private List<Post> posts;
}
