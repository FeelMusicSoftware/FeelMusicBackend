package feelmusicbackend.demo.repository;

import feelmusicbackend.demo.entity.Song;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface SongRepository {
    public void createSong(Song song);
}
