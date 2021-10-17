package feelmusicbackend.demo.service;

import feelmusicbackend.demo.dto.ArtistResponse;
import feelmusicbackend.demo.dto.UserResponse;
import feelmusicbackend.demo.entity.Artist;
import feelmusicbackend.demo.entity.Person;
import feelmusicbackend.demo.entity.User;
import feelmusicbackend.demo.repository.ArtistRepository;
import feelmusicbackend.demo.repository.PersonRepository;
import feelmusicbackend.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ArtistService {
    private PersonRepository personRepository;
    private UserRepository userRepository;
    private ArtistRepository artistRepository;

    @Autowired
    public ArtistService(PersonRepository personRepository, UserRepository userRepository, ArtistRepository artistRepository){
        this.personRepository = personRepository;
        this.userRepository = userRepository;
        this.artistRepository = artistRepository;
    }

    public ArtistResponse findByArtistId(Integer artistId){
        return artistRepository.findByArtistId(artistId);
    }

    public ArtistResponse createArtist(ArtistResponse artistResponse){
        Person person = new Person();
        User user = new User();
        Artist artist = new Artist();
        person.setName(artistResponse.getName());
        person.setFirstSurname(artistResponse.getFirstSurname());
        person.setSecondSurname(artistResponse.getSecondSurname());
        person.setPhone(artistResponse.getPhone());
        personRepository.createPerson(person);
        int personId=personRepository.getLastInsertId();
        user.setIdPerson(personId);
        user.setUsername(artistResponse.getUsername());
        user.setEmail(artistResponse.getEmail());
        user.setPassword(artistResponse.getPassword());
        userRepository.createUser(user);
        int userId=personRepository.getLastInsertId();
        artist.setCountry(artistResponse.getCountry());
        artist.setArtistName(artistResponse.getArtistName());
        artist.setIdUser(userId);
        artistRepository.createArtist(artist);
        int artistId=personRepository.getLastInsertId();
        artistResponse.setIdUser(userId);
        artistResponse.setIdPerson(personId);
        artistResponse.setIdArtist(artistId);
        return artistResponse;
    }

    public ArtistResponse updateArtist(ArtistResponse artistResponse){
        Person person = new Person();
        User user = new User();
        Artist artist = new Artist();
        person.setIdPerson(artistResponse.getIdPerson());
        person.setName(artistResponse.getName());
        person.setFirstSurname(artistResponse.getFirstSurname());
        person.setSecondSurname(artistResponse.getSecondSurname());
        person.setPhone(artistResponse.getPhone());
        personRepository.updatePerson(person);
        user.setIdUser(artistResponse.getIdUser());
        user.setIdPerson(artistResponse.getIdPerson());
        user.setUsername(artistResponse.getUsername());
        user.setEmail(artistResponse.getEmail());
        user.setPassword(artistResponse.getPassword());
        userRepository.updateUser(user);
        artist.setIdUser(artistResponse.getIdUser());
        artist.setCountry(artistResponse.getCountry());
        artist.setArtistName(artistResponse.getArtistName());
        artistRepository.updateArtist(artist);
        return artistResponse;
    }

    public void deleteArtist(Integer artistId) {
        artistRepository.deleteArtist(artistId);
    }

}
