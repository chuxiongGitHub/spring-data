package com.rainbow;

import com.rainbow.entity.Person;
import com.rainbow.repository.PersonRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringDataApplicationTests {

	@Autowired
	private PersonRepository personRepository;
	@Test
	public void contextLoads() {
	}

	@Test
	public void testJPA(){

		Person person=personRepository.findByLastName("rrr");
		System.out.println(person.getBirth());
	}

}
