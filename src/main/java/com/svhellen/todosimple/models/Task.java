package com.svhellen.todosimple.models;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = Task.TABLE_NAME)
public class Task {
	public static final String TABLE_NAME = "task";
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", unique = true)
	private Long id;
	
	@ManyToOne
	@JoinColumn(name = "user_id", nullable = false, updatable = false)
	private User user;
	
	@Column(name = "title", length = 100, nullable = false, unique = true )
	@NotNull
	@NotEmpty
	@Size(min = 2, max = 100)
	private String title;
	
	@Column(name = "description", length = 255)
	private String description;

	public Task() {
	}

	public Task(Long id, User user, String title, String description) {
		this.id = id;
		this.user = user;
		this.title = title;
		this.description = description;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = (prime * result + (this.id == null ? 0 : this.id.hashCode()));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if(obj == null) {
			return false;
		}
		if (!(obj instanceof User))
			return false;
		
		Task other = (Task) obj;
		if (this.id == null)
			if (other.id != null)
				return false;
			else if (!this.id.equals(other.id))
				return false;
		return Objects.equals(this.id, other.id) && Objects.equals(this.user, other.user)
				&& Objects.equals(this.title, other.title);
	}
	
}
