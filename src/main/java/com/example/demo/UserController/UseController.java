package com.example.demo.UserController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.User.UserLoginOrSignUp;
import com.example.demo.UserRepositior.UserDao;

@RestController
@RequestMapping("/user")
@CrossOrigin(origins = "*")
public class UseController {
	
	@Autowired
	
	UserDao userdao;
	
	@PostMapping("/signup")
	public String signup(@RequestBody UserLoginOrSignUp userlogin) {
		if(userdao.findByEmail(userlogin.getEmail()) !=  null) {
			return "Email alreay exists";
		}
		userdao.save(userlogin);
		return "SignUp successful ";
	}
	
	@PostMapping("/login")
	public String login(@RequestBody UserLoginOrSignUp userlogin) {
	    UserLoginOrSignUp user = userdao.findByEmail(userlogin.getEmail());
	    if (user != null && user.getPassword().equals(userlogin.getPassword())) {
	        return "Login successful";
	    } else {
	        return "User does not exist or invalid password";
	    }
	}

}
