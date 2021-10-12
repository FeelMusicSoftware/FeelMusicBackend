package feelmusicbackend.demo.controllers;

import feelmusicbackend.demo.dto.ArtistResponse;
import feelmusicbackend.demo.dto.UserResponse;
import feelmusicbackend.demo.service.ArtistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/artist")
public class ArtistController {
    private ArtistService artistService;

    @Autowired
    public ArtistController(ArtistService artistService){
        this.artistService = artistService;
    }

    @RequestMapping(method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ArtistResponse createArtist(@RequestBody ArtistResponse artistResponse) {
        return artistService.createArtist(artistResponse);
    }
}
