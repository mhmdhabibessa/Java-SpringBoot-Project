package com.axsosacademy.demo.services;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.axsosacademy.demo.models.Order;
import com.axsosacademy.demo.models.Painting;
import com.axsosacademy.demo.models.Role;
import com.axsosacademy.demo.models.User;
import com.axsosacademy.demo.repositories.RoleRepository;
import com.axsosacademy.demo.repositories.UserRepository;

@Service
public class UserService {
	
    private UserRepository userRepository;
    private RoleRepository roleRepository;
    private BCryptPasswordEncoder bCryptPasswordEncoder;
	public UserService(UserRepository userRepository, RoleRepository roleRepository,
			BCryptPasswordEncoder bCryptPasswordEncoder) {
		this.userRepository = userRepository;
		this.roleRepository = roleRepository;
		this.bCryptPasswordEncoder = bCryptPasswordEncoder;
	}
	
	public Role findRoleById(Long id) {
		Optional<Role> optionalRole = roleRepository.findById(id);
	    if(optionalRole.isPresent()) {
	        return optionalRole.get();
	    } else {
	        return null;
	    }
	}
	
	public User findUserById(Long id) {
		Optional<User> optionalUser = userRepository.findById(id);
	    if(optionalUser.isPresent()) {
	        return optionalUser.get();
	    } else {
	        return null;
	    }
	}
    
    
    // 1
    public void saveWithUserRole(User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        Role r = findRoleById( (long) 1);
        user.setRole(r);
        userRepository.save(user);
    }
     
     // 2 
    public void saveUserWithAdminRole(User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        Role r = findRoleById( (long) 2);
        user.setRole(r);
        userRepository.save(user);
    }    
    
    // 3
    public User findByUsername(String email) {
        return userRepository.findByEmail(email);
    }

    public List<User> getAll(){
    	return (List<User>) userRepository.findAll();
    }

	public void deleteUser(long id) {
		userRepository.deleteById(id);	
	}

	public void addAdmin(long id) {
		User user = userRepository.findById(id).orElse(null);
		Role r = findRoleById( (long) 2);
        user.setRole(r);
		userRepository.save(user);
	}

	public List<User> getNonAdmin() {
		List<User> nonAdmin = userRepository.findNonAdmin();
		return nonAdmin;
	}

	public void addToCart(long cid, long pid , long uid) {
		User user = findUserById(uid);
		if(user.getOrders() == null) {
			List<Order> order = user.getOrders();
			order.add(null);
		}
		
	}


    
//    sddsdfgfdgdfdfdfd




}
