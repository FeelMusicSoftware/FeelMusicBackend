package feelmusicbackend.demo.controllers;

import feelmusicbackend.demo.dto.UserResponse;
import feelmusicbackend.demo.entity.Album;
import feelmusicbackend.demo.service.AlbumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/album")
public class AlbumControllers {
    private AlbumService albumService;

    @Autowired
    public AlbumControllers(AlbumService albumService){
        this.albumService=albumService;
    }

    @RequestMapping(method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public Album createAlbum(@RequestBody Album album) {
        return albumService.createAlbum(album);
    }
}
