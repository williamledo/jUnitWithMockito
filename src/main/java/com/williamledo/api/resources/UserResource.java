package com.williamledo.api.resources;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.williamledo.api.domain.User;
import com.williamledo.api.domain.dto.UserDTO;
import com.williamledo.api.services.UserService;

@RestController
@RequestMapping(value = "/user")
public class UserResource {

	@Autowired
	private ModelMapper mapper;
	
	@Autowired
	private UserService service;
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<UserDTO> findById(@PathVariable Integer id) {
		
		return ResponseEntity.ok().body(mapper.map(service.findById(id), UserDTO.class));
		
	}
	
	@GetMapping
	public ResponseEntity<List<UserDTO>> findAll() {
		List<User> list = service.findAll();
		// transformo a lista em uma stream.map para indicar que vai ser feito em todos os índices, depois mudo a classe para UserDTO e transformo de volta em List
		List<UserDTO> listDTO = list.stream().map(x -> mapper.map(x, UserDTO.class)).collect(Collectors.toList()); 
		return ResponseEntity.ok().body(listDTO);
	}
	
}
