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
import com.sr.p2p.model.User;
import com.sr.p2p.model.UserRole;
import com.sr.p2p.service.RoleResourcesService;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.GrantedAuthorityImpl;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;


import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Rob Winch
 *
 */
public class P2PUserDetailsService implements UserDetailsService {

	RoleResourcesService roleResourcesService;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.springframework.security.core.userdetails.UserDetailsService#loadUserByUsername
	 * (java.lang.String)
	 */
	public UserDetails loadUserByUsername(String username)
			throws UsernameNotFoundException {
		User user = roleResourcesService.getUserByUsername(username);
		if (user == null) {
			throw new UsernameNotFoundException("Could not find user " + username);
		}
		Set<UserRole> roles = roleResourcesService.findUserRoles(user.getId());
		user.setRoles(roles);
		//用户权限
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
			return getUserName();
		}

		public boolean isAccountNonExpired() {
			return getIsAccountNonExpired() > 0 ? false : true;
		}

		public boolean isAccountNonLocked() {
			return getIsAccountNonLocked() > 0 ? false : true;
		}

		public boolean isCredentialsNonExpired() {
			return getIsCredentialsNonExpired() > 0 ? false : true;
		}

		public boolean isEnabled() {
			return getIsEnabled() > 0 ? false : true;
		}
	}

	//加载用户权限
	private Set<GrantedAuthority> obtionGrantedAuthorities(User user) {
		Set<GrantedAuthority> authSet = new HashSet<GrantedAuthority>();
		Set<UserRole> roles = user.getRoles();
		for(UserRole role : roles) {
			//用户角色对应的资源
			Set<Resource> tempRes = P2PFilterInvocationSecurityMetadataSource.roleResouces.get(role.getRoleId());
			//认证用户角色
			for(Resource res : tempRes) {
				authSet.add(new GrantedAuthorityImpl(res.getName()));
			}
		}
		return authSet;
	}

	public RoleResourcesService getRoleResourcesService() {
		return roleResourcesService;
	}

	public void setRoleResourcesService(RoleResourcesService roleResourcesService) {
		this.roleResourcesService = roleResourcesService;
	}

}
