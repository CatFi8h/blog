package com.catfi8h.blog.repository.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Authority {

	@Id
	@Column(length = 16)
	private String name;
	
	@Override
	public String toString() {
		return "Authority{" +
				       "name='" + name + '\'' +
				       '}';
	}
}
