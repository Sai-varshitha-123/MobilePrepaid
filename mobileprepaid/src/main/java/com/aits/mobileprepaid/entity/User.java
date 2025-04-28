package com.aits.mobileprepaid.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class User {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
        private Long id;
        private String name;
        private String email;
        private String password;
        private String mobile;
        @Enumerated(EnumType.STRING)
        private Role role;
        @OneToMany(mappedBy="user",cascade=CascadeType.ALL)
        private List<RechargeHistory> history;
        
        public User() {
        	
        }
        public User(String name,String email,String password,String mobile) {
        	this.name=name;
        	this.email=email;
        	this.password=password;
        	this.mobile=mobile;
        }
		public Long getId() {
			return id;
		}
		public void setId(Long id) {
			this.id = id;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getemail() {
			return email;
		}
		public void setemail(String email) {
		  this.email = email;
		}
		public String getPassword() {
			return password;
		}
		public void setPassword(String password) {
			this.password = password;
		}
		public String getMobile() {
			return mobile;
		}
		public void setMobile(String mobile) {
			this.mobile = mobile;
		}
		public Role getRole() {
			return role;
		}
		public void setRole(Role role) {
			this.role = role;
		}
		public List<RechargeHistory> getHistory() {
			return history;
		}
		public void setHistory(List<RechargeHistory> history) {
			this.history = history;
		}
        
        
}
