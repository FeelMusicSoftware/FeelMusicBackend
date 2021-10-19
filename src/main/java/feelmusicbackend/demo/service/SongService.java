package feelmusicbackend.demo.service;

import feelmusicbackend.demo.dto.SongResponse;
import feelmusicbackend.demo.entity.*;
import feelmusicbackend.demo.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SongService {
    private SongRepository songRepository;
    private AlbumRepository albumRepository;
    private GenreRepository genreRepository;
    private LanguageRepository languageRepository;
    private ArtistRepository artistRepository;
    private TransactionRepository transactionRepository;

    @Autowired
    public SongService(SongRepository songRepository,AlbumRepository albumRepository, GenreRepository genreRepository, LanguageRepository languageRepository, ArtistRepository artistRepository, TransactionRepository transactionRepository){
        this.songRepository = songRepository;
        this.albumRepository = albumRepository;
        this.genreRepository = genreRepository;
        this.languageRepository = languageRepository;
        this.artistRepository = artistRepository;
        this.transactionRepository = transactionRepository;
    }

    public SongResponse createSong(SongResponse songResponse){
        Song song = new Song();
        Album album = new Album();
        Genre genre = new Genre();
        Language language = new Language();
        Artist artist = new Artist();
        album.setName(songResponse.getNameAlbum());
        album.setSongName(songResponse.getSongAlbum());
        albumRepository.createAlbum(album);
        int albumId = transactionRepository.getLastInsertId();
        //System.out.println("AAAAAA dddd"+album.getName());
        //System.out.println("AAAAAA"+albumId);
        genre.setName(songResponse.getNameGenre());
        genre.setDescription(songResponse.getDescription());
        genreRepository.createGenre(genre);
        int genreId = transactionRepository.getLastInsertId();
        language.setLanguage(songResponse.getLanguage());
        languageRepository.createLanguage(language);
        int languageId = transactionRepository.getLastInsertId();
        artist.setIdArtist(songResponse.getIdArtist());
        song.setIdAlbum(albumId);
        song.setIdGenre(genreId);
        song.setIdLanguage(languageId);
        song.setIdArtist(songResponse.getIdArtist());
        song.setName(songResponse.getNameSong());
        song.setDuration(songResponse.getDurationSong());
        song.setMood(songResponse.getMoodSong());
        songRepository.createSong(song);
        int songId = transactionRepository.getLastInsertId();
        songResponse.setIdSong(songId);
        songResponse.setIdAlbum(albumId);
        songResponse.setIdGenre(genreId);
        songResponse.setIdLanguage(languageId);
        //System.out.println("songsd  "+songResponse.getIdAlbum());
        return songResponse;
    }

}
