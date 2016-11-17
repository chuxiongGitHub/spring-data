package com.rainbow;

import com.rainbow.entity.Person;
import com.rainbow.repository.PersonRepository;
import com.rainbow.service.PersonService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.domain.Sort.Order;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.test.context.junit4.SpringRunner;

import javax.persistence.criteria.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringDataApplicationTests {

    @Autowired
    private PersonRepository personRepository;
    @Autowired
    private PersonService personService;

    @Test
    public void contextLoads() {
    }

    @Test
    public void testJPA() {

        Person person = personRepository.findByLastName("rrr");
        System.out.println(person.getBirth());
    }

    @Test
    public void testKeyWords() {
        List<Person> list = personRepository.findByLastNameStartingWith("s");
        System.out.println(list);
    }

    @Test
    public void testKeyWords2() {
        List<Person> list = personRepository.getByLastNameStartingWithAndIdLessThan("s", 5);
        System.out.println(list.size());
    }

    @Test
    public void testQuery() {
        Person person = personRepository.findMaxIdPerson();
        System.out.println(person);
    }

    @Test
    public void testQueryAnnotationParams() {
        List<Person> list = personRepository.testQueryAnnotationParams("rrr", "dsfsd");
        System.out.println(list.size());
    }

    @Test
    public void testQueryAnnotationParams2() {
        List<Person> list = personRepository.testQueryAnnotationParams2("rrr", "dsfsd");
        System.out.println(list.size());
    }

    @Test
    public void testQueryLikeParam() {
        List<Person> list = personRepository.testQueryAnnotationLikeParam("s", "d");
        System.out.println(list.size());
    }

    @Test
    public void testCount() {
        int count = personRepository.getPersonCount();
        System.out.println(count);
    }

    @Test
    public void test() {
        int count = personService.updateLastName("dd", 1);
        System.out.println(count);
    }

    @Test
    public void testSave() {
        List<Person> persons = new ArrayList<>();
        for (int i = 'a'; i <= 'z'; i++) {
            Person person = new Person();
            person.setBirth(new Date());
            person.setLastName("彩虹" + (char) i);
            person.setEmail((char) i + "836908728@qq.com" + (char) i);
            person.setId(i + 1);
            persons.add(person);
            System.out.println("执行保存方法");
        }
        personService.savePersons(persons);
    }

    @Test
    public void testPagingAndSortingRepository() {
        //pageNo的记录是从1开始
        int pageNo = 6 - 1;
        int pageSize = 5;
        //Pageable接口通常使用的其PageRequest实现类，其中封装了分页的相关信息（page，size，sort）
        //排序相关,Sort封装了排序的信息
        //Order是针对于某一个属性进行升序还是降序
        Order order1 = new Sort.Order(Direction.DESC, "id");
        Order order2 = new Sort.Order(Direction.ASC, "email");
        //sort可以包含多个
        Sort sort = new Sort(order1, order2);
        PageRequest pageable = new PageRequest(pageNo, pageSize, sort);
        Page<Person> page = personRepository.findAll(pageable);
        System.out.println("总记录数：" + page.getTotalElements());
        System.out.println("当前第几页：" + (page.getNumber()) + 1);
        System.out.println("总页数：" + page.getTotalPages());
        System.out.println("当前页面的list：" + page.getContent());
        System.out.println("当前页面的记录数：" + page.getNumberOfElements());
    }

    @Test
    public void testJpaRepository() {
        Person person = new Person();
        person.setBirth(new Date());
        person.setLastName("云南");
        person.setEmail("836908728@qq.com");
        person.setId(27);
        Person person1 = personRepository.saveAndFlush(person);
        System.out.println(person == person1);
    }

    @Test
    /**
     * 实现带查询条件的分页：
     * 使用JpaSpecificationExecutor的Page<T> findAll(Specification<T> spec,Pageable pageable)
     * Specification:封装了JPA Criteria查询的查询条件
     * Pageable:封装了请求分页的信息，例如：pageNo，pageSize，Sort
     */
    public void testJpaSpecificationExecutor(){

        int pageNo=3-1;
        int pageSize=5;
        PageRequest pageRequest=new PageRequest(pageNo,pageSize);
        Specification<Person> specification=new Specification<Person>() {
            /**
             *
             * @param root ：代表查询的实体类
             * @param criteriaQuery：可以从中得到root对象，即告知JPA Criteria查询要查询哪一个实体类，还可以添加查询条件
             *                     还可以结合EntityManager对象得到最终查询的TypeQuery对象
             * @param criteriaBuilder：CriteriaBuilder 用于创建Criteria相关对象的工厂，当然可以从中获取到Predicate对象
             * @return Predicate类型，代表一个查询条件
             */
            @Override
            //如：实现id>5
            public Predicate toPredicate(Root<Person> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                Path path=root.get("id");
                Predicate predicate=criteriaBuilder.gt(path,5);
                return predicate;
            }
        };
        Page<Person> page=personRepository.findAll(specification,pageRequest);
        System.out.println("总记录数：" + page.getTotalElements());
        System.out.println("当前第几页：" + (page.getNumber() + 1));
        System.out.println("总页数：" + page.getTotalPages());
        System.out.println("当前页面的list：" + page.getContent());
        System.out.println("当前页面的记录数：" + page.getNumberOfElements());
    }


    @Test
    public  void test22(){
        personRepository.test();
    }
}
