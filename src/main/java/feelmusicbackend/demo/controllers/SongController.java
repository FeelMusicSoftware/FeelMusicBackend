package feelmusicbackend.demo.controllers;

import feelmusicbackend.demo.dto.SongResponse;
import feelmusicbackend.demo.service.SongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/song")
public class SongController {
    private SongService songService;

    @Autowired
    public SongController(SongService songService){
        this.songService = songService;
    }

    @RequestMapping(method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public SongResponse createSong(@RequestBody SongResponse songResponse) {
        return songService.createSong(songResponse);
    }

}
