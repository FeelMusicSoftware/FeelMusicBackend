package feelmusicbackend.demo.repository;

import feelmusicbackend.demo.dto.ArtistResponse;
import feelmusicbackend.demo.entity.Artist;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ArtistRepository {
    public ArtistResponse findByArtistId(Integer artistId);
    public void createArtist(Artist artist);
    public void updateArtist(Artist artist);
    public void deleteArtist(Integer artistId);

}
