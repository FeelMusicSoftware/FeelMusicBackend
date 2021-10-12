package feelmusicbackend.demo.repository;

import feelmusicbackend.demo.entity.Artist;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ArtistRepository {
    public void createArtist(Artist artist);
}
