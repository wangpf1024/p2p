/*
 * Copyright 2002-2013 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.sr.p2p.model;


import org.springframework.security.crypto.password.PasswordEncoder;


import java.io.Serializable;
import java.util.Set;

/**
 * Represents a user in our system.
 *
 * <p>
 * In a real system use {@link PasswordEncoder} to ensure the password is secured
 * properly. This demonstration does not address this due to time restrictions.
 * </p>
 *
 * @author Rob Winch
 */

public class User implements Serializable {

	private static final long serialVersionUID = -6540780111618159858L;

	private Long id;
	private String firstName;
	private String lastName;
	private String email;
	private String password;
    private String userName;

    private int isAccountNonExpired;
	private int isAccountNonLocked;
    private int isCredentialsNonExpired;
    private int isEnabled;

	Set<UserRole> roles;

	public User() {
	}

	public User(User user) {
		this.id = user.id;
		this.firstName = user.firstName;
		this.lastName = user.lastName;
		this.email = user.email;
		this.password = user.password;
		this.userName= user.userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		}
		else if (!id.equals(other.id))
			return false;
		return true;
	}

	public Set<UserRole> getRoles() {
		return roles;
	}

	public void setRoles(Set<UserRole> roles) {
		this.roles = roles;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public int getIsAccountNonExpired() {
		return isAccountNonExpired;
	}

	public void setIsAccountNonExpired(int isAccountNonExpired) {
		this.isAccountNonExpired = isAccountNonExpired;
	}

	public int getIsAccountNonLocked() {
		return isAccountNonLocked;
	}

	public void setIsAccountNonLocked(int isAccountNonLocked) {
		this.isAccountNonLocked = isAccountNonLocked;
	}

	public int getIsCredentialsNonExpired() {
		return isCredentialsNonExpired;
	}

	public void setIsCredentialsNonExpired(int isCredentialsNonExpired) {
		this.isCredentialsNonExpired = isCredentialsNonExpired;
	}

	public int getIsEnabled() {
		return isEnabled;
	}

	public void setIsEnabled(int isEnabled) {
		this.isEnabled = isEnabled;
	}
}