package feelmusicbackend.demo.repository;

import feelmusicbackend.demo.entity.Genre;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface GenreRepository {
    public void createGenre(Genre genre);

}
