package feelmusicbackend.demo.repository;

import feelmusicbackend.demo.entity.Person;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface PersonRepository {
    public Person findByPersonId(Integer personId);
    public void createPerson(Person person);
    public void updatePerson(Person person);
}
