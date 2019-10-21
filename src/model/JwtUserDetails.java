package model;

import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class JwtUserDetails implements UserDetails {

	private String userName;
	private Long Id;
	private String token;
	private Collection<? extends GrantedAuthority> authorities;
	
	
	public JwtUserDetails(String userName, String id, String token, List<GrantedAuthority> grantedAuthorities) {
	
		this.userName = userName;
		this.Id = Id;
		this.authorities = authorities;
		this.token = token;
	
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return authorities;
	}
	
	@Override
	public String getUsername() {
		return userName;
	}

	@Override
	public boolean isAccountNonExpired() {
		return false;
	}

	@Override
	public boolean isAccountNonLocked() {

		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

	public String getUserName() {
		return userName;
	}

	public Long getId() {
		return Id;
	}

	public String getToken() {
		return token;
	}

	public void setAuthorities(Collection<? extends GrantedAuthority> authorities) {
		this.authorities = authorities;
	}
}
