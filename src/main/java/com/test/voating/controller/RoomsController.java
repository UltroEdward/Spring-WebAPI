package com.test.voating.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.test.voating.model.VoteRoom;
import com.test.voating.service.VoteRoomService;

@RestController
@RequestMapping(value = "/rooms")
public class RoomsController {

	@Autowired
	private VoteRoomService voteService;

	@RequestMapping( method = RequestMethod.GET)
	public List<VoteRoom> getRooms() {
		List<VoteRoom> userDetails = voteService.findAll();
		return userDetails;
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public VoteRoom getRoom(@PathVariable int id) {
		return voteService.findById(id);
	}
	
	@RequestMapping( method = RequestMethod.POST)
	public VoteRoom addRoom(VoteRoom room) {
		voteService.addVoteRoom(room);
		return room;
	}

}