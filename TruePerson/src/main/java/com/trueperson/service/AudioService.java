package com.trueperson.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.trueperson.exception.ResourceNotFoundException;
import com.trueperson.model.Audio;
import com.trueperson.repository.AudioRepository;

@Service
public class AudioService {

	@Autowired
	AudioRepository auRepo;
	
	public List<Audio> getAllAudios() {
		
		return auRepo.findAll();
	}

	public Audio saveAudio(Audio audio) {
		
		return auRepo.save(audio);
	}

	public Audio getAudioById(UUID auid) {
		
		return auRepo.findById(auid).orElseThrow(() -> 
		new ResourceNotFoundException("Audio", "Id", auid));
				
	}

	public Audio updateAudio(Audio audio, UUID auid) {
		Audio existingAudio = auRepo.findById(auid).orElseThrow(
				() -> new ResourceNotFoundException("Audio", "Id", auid)); 
		
		existingAudio.setCreatedBy(audio.getCreatedBy());
		existingAudio.setCreatedDate(audio.getCreatedDate());
		existingAudio.setFileName(audio.getFileName());
		existingAudio.setDescription(audio.getDescription());
		existingAudio.setLink(audio.getLink());
		existingAudio.setUpdatedBy(audio.getUpdatedBy());
		existingAudio.setUpdatedDate(audio.getUpdatedDate());
		existingAudio.setUser_id(audio.getUser_id());

		auRepo.save(existingAudio);
		return existingAudio;

	}

	public void deleteAudio(UUID auid) {
		
		auRepo.findById(auid).orElseThrow(() ->
		new ResourceNotFoundException("Audio", "Id", auid));
		
		 auRepo.deleteById(auid);
	}

}
