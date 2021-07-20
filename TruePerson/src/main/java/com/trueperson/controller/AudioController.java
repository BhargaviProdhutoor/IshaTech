package com.trueperson.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.trueperson.model.Audio;
import com.trueperson.service.AudioService;


@RestController
public class AudioController {

	
	@Autowired
	private AudioService auService; 
	
	@GetMapping("/listaudio")
	private List<Audio> getAllAudios()
	{
		return auService.getAllAudios();
	}
	
	@PostMapping("/saveaudio")
	public ResponseEntity<Audio> saveAudio(@RequestBody Audio audio)
	{
   return new ResponseEntity<Audio>(auService.saveAudio(audio),
		   HttpStatus.CREATED);
		}
	
	@GetMapping("/audio/{auid}")
	public ResponseEntity<Audio> getAudioById(@PathVariable("auid") UUID auid){
		   
	return new ResponseEntity<Audio>(auService.getAudioById(auid), HttpStatus.OK);
		}
	
	@PutMapping("/audio/{auid}")
	public ResponseEntity<Audio> updateAudio(@PathVariable("auid") UUID auid,
    @RequestBody Audio audio){
       return new ResponseEntity<Audio>(auService.updateAudio(audio, auid), HttpStatus.OK);
    }
	
	@DeleteMapping("/audio/{auid}")
	 public ResponseEntity<String> deleteAudio(@PathVariable("auid") UUID auid){
		auService.deleteAudio(auid);
		return new ResponseEntity<String>("Audio Deleted Successfully!", HttpStatus.OK);
	}
}
