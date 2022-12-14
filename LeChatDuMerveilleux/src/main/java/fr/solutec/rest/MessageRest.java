package fr.solutec.rest;

import java.util.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


import fr.solutec.entities.Message;
import fr.solutec.repository.MessageRepository;

@RestController @CrossOrigin("*")
public class MessageRest {
	
	@Autowired
	private MessageRepository messageRepo;
	
	@GetMapping("/chattin")
	public Iterable<Message> getAllMessage() {
		return messageRepo.findAll();
	}
	
	@PostMapping("/chattin")
	public Message saveMemo(@RequestBody Message m) {
		m.setDate(new Date());
		return messageRepo.save(m);
	}
	
	@GetMapping("/message/rooms/{id}")
	public Iterable<Message> getAllMessage(@PathVariable Long id){
		return messageRepo.findByRoomId(id);
	}
	
}
