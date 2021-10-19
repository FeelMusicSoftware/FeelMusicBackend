package feelmusicbackend.demo.repository;

import feelmusicbackend.demo.entity.Language;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface LanguageRepository {
    public void createLanguage(Language language);
}
