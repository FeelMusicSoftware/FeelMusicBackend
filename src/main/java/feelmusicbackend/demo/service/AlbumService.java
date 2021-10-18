package feelmusicbackend.demo.service;

import feelmusicbackend.demo.entity.Album;
import feelmusicbackend.demo.repository.AlbumRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AlbumService {
    private AlbumRepository albumRepository;

    @Autowired
    public AlbumService(AlbumRepository albumRepository){
        this.albumRepository = albumRepository;
    }

    public Album createAlbum(Album album){
        Album album1 = new Album();
        album1.setName(album.getName());
        album1.setSongName(album.getSongName());
        albumRepository.createAlbum(album1);
        return album;
    }
}
