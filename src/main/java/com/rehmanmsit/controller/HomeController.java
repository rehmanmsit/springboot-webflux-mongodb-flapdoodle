package com.rehmanmsit.controller;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.rehmanmsit.controller.vo.InitialPostRequestVO;
import com.rehmanmsit.controller.vo.InitialPostResponseVO;
import com.rehmanmsit.repository.UserRepository;
import com.rehmanmsit.repository.entity.Address;
import com.rehmanmsit.repository.entity.User;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 *
 * @author Rehman
 *
 */

@RestController
public class HomeController {

	@Autowired
	private UserRepository userRepo;

	@PostMapping(value = "/addUser",
			produces = MediaType.APPLICATION_JSON_VALUE,
			consumes = MediaType.APPLICATION_JSON_VALUE)
	public Mono<InitialPostResponseVO> handleInitialPostRequest(@RequestBody InitialPostRequestVO initialPostRequestVO) {

		return Mono.just(initialPostRequestVO)
				.flatMap(request -> {
					User user = new User();
					user.setId(request.getId());
					user.setName(request.getName());
					user.setAge(request.getAge());
					Address address = new Address();
					BeanUtils.copyProperties(request.getAddress(), address);
					user.setAddress(address);
					return userRepo.save(user);
				}).map(user -> {
					InitialPostResponseVO response = new InitialPostResponseVO();
					response.setMessage("Insertion Successful");
					response.setUser(user);
					return response;
				});
	}

	@GetMapping("/getUsers")
	public Flux<User> getUser() {
		return userRepo.findAll();
	}

}
