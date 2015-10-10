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
package com.sr.p2p.security;

import com.sr.p2p.model.Resource;
import com.sr.p2p.model.Role;
import com.sr.p2p.model.User;
import com.sr.p2p.model.UserRole;
import com.sr.p2p.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.authority.GrantedAuthorityImpl;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Rob Winch
 *
 */
public class P2PUserDetailsService implements UserDetailsService {

	TestService testService;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.springframework.security.core.userdetails.UserDetailsService#loadUserByUsername
	 * (java.lang.String)
	 */
	public UserDetails loadUserByUsername(String username)
			throws UsernameNotFoundException {
		User user = testService.getUserByUsername(username);
		if (user == null) {
			throw new UsernameNotFoundException("Could not find user " + username);
		}
		Set<UserRole> roles = testService.findUserRoles(user.getId());
		user.setRoles(roles);
		Collection<GrantedAuthority> grantedAuths = obtionGrantedAuthorities(user);
		return new CustomUserDetails(user,grantedAuths);
	}

	private final static class CustomUserDetails extends User implements UserDetails {

		private static final long serialVersionUID = -1003195756083273443L;

		Collection<GrantedAuthority> grantedAuths = null;

		private CustomUserDetails(User user,Collection<GrantedAuthority> grantedAuths) {
			super(user);
			this.grantedAuths = grantedAuths;
		}

		public Collection<? extends GrantedAuthority> getAuthorities() {
			return grantedAuths;
		}

		public String getUsername() {
			return getEmail();
		}

		public boolean isAccountNonExpired() {
			return true;
		}

		public boolean isAccountNonLocked() {
			return true;
		}

		public boolean isCredentialsNonExpired() {
			return true;
		}

		public boolean isEnabled() {
			return true;
		}
	}

	private Set<GrantedAuthority> obtionGrantedAuthorities(User user) {
		Set<GrantedAuthority> authSet = new HashSet<GrantedAuthority>();
		Set<UserRole> roles = user.getRoles();
		for(UserRole role : roles) {
			Set<Resource> tempRes = P2PFilterInvocationSecurityMetadataSource.roleResouceTemp.get(role.getRoleId());
			for(Resource res : tempRes) {
				authSet.add(new GrantedAuthorityImpl(res.getName()));
			}
		}
		return authSet;
	}

	public TestService getTestService() {
		return testService;
	}

	public void setTestService(TestService testService) {
		this.testService = testService;
	}
}
