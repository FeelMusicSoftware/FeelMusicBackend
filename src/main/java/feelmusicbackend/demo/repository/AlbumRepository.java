package feelmusicbackend.demo.repository;

import feelmusicbackend.demo.entity.Album;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AlbumRepository {

    public void createAlbum(Album album);
}
