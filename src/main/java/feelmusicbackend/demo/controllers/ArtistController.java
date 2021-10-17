package feelmusicbackend.demo.controllers;

import feelmusicbackend.demo.dto.ArtistResponse;
import feelmusicbackend.demo.dto.UserResponse;
import feelmusicbackend.demo.service.ArtistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

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

    @RequestMapping(method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public ArtistResponse updateArtist(@RequestBody ArtistResponse artistResponse){
        artistService.updateArtist(artistResponse);
        return artistResponse;
    }

    @RequestMapping(method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    public void deleteArtist(@RequestParam Integer artistId, HttpServletRequest request){
        artistService.deleteArtist(artistId);
    }

    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ArtistResponse findByUserId(@RequestParam Integer artistId, HttpServletRequest request){
        return artistService.findByArtistId(artistId);
    }
}
