package fi.digiprojekti.yummy.web;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import fi.digiprojekti.yummy.domain.RegisterNewUser;
import fi.digiprojekti.yummy.domain.User;
import fi.digiprojekti.yummy.domain.UserRepository;

@Controller
public class UserController {
	
	@Autowired
	private UserRepository userRepository;
	
	@RequestMapping(value = "signup")
	public String addNewUser(Model model) {
		model.addAttribute("registernewuser", new RegisterNewUser());
		return "signup";
	}
	
	@RequestMapping(value = "saveuser", method = RequestMethod.POST)
	public String save(@Valid @ModelAttribute("registernewuser") RegisterNewUser registerNewUser, BindingResult bindingResult) {
		if (!bindingResult.hasErrors()) {
			if (registerNewUser.getPassword().equals(registerNewUser.getPasswordCheck())) {
				String password = registerNewUser.getPassword();
				BCryptPasswordEncoder bc = new BCryptPasswordEncoder();
				String hashPassword = bc.encode(password);
				
				User newUser = new User();
				newUser.setPasswordHash(hashPassword);
				newUser.setUsername(registerNewUser.getUsername());
				newUser.setFirstname(registerNewUser.getFirstname());
				newUser.setLastname(registerNewUser.getLastname());
				newUser.setRole(registerNewUser.getRole().toUpperCase());
				if (userRepository.findByUsername(registerNewUser.getUsername()) == null) {
					userRepository.save(newUser);
				}
				else {
					bindingResult.rejectValue("username", "err.username", "Tämä käyttäjänimi on jo olemassa");    	
		    		return "signup";
				}
				
			}
			else {
				bindingResult.rejectValue("passwordCheck", "err.passCheck", "Salasanat eivät täsmää");    	
    			return "signup";
			}
			
		}
		else {
			return "signup";
		}
		return "redirect:/login";
	}

}
