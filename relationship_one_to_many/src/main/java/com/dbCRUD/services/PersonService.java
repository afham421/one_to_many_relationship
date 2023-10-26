package com.dbCRUD.services;

import com.dbCRUD.dao.PersonDao;
import com.dbCRUD.entity.Person;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class PersonService {


    @Autowired
    private PersonDao personDao;

    public List<Person> getAllPerson(){
        List<Person> all = personDao.findAll();
        return all;

    }
    public Optional<Person> findPersonById(long id){
        Optional<Person> byId = null;
        try {
             byId = personDao.findById(id);
        }catch (Exception e){
            log.error(ExceptionUtils.getStackTrace(e));
        }
        return byId;

    }

    public void addPerson(Person person) {
        try {
            personDao.save(person);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Person updatePerson(Person person , long id){

        person.setId(id); // ab agr user jo id dy ga woh is person ko assign ho jay gi // or wohi id wala person update ho ga
        Person update = personDao.save(person);
        return update;
    }


    public void deletePerson(long id){
        personDao.deleteById(id);
    }


}
