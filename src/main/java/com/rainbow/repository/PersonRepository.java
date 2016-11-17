package com.rainbow.repository;

import com.rainbow.entity.Person;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * 1、Repository是一个空接口，即是一个标记接口
 * 2、若我们定义的接口继承了Repository，则该接口会被IOC容器识别为一个Repository Bean，纳入到IOC容器中，
 * 进而可以在该接口中定义满足一些规范的方法。
 *3、实际上，也可以通过@RepositoryDefinition()注解的方式来替代继承Repository接口
 *@RepositoryDefinition(domainClass = Person.class,idClass = Integer.class)
 */
public interface PersonRepository extends JpaRepository<Person,Integer>,JpaSpecificationExecutor<Person>,TestRepository{
    Person findByLastName(String lastName);

    //where lastName like ?%
    List<Person> findByLastNameStartingWith(String lastName);

    //where lastName like ?% and id< ?
    List<Person> getByLastNameStartingWithAndIdLessThan(String lastName,Integer id);

    //查询Id最大的那个Person(注意：from后面跟着的实体名Person)
    //使用@Query注解可以自定义JPQL，语句实现更灵活的查询
    @Query("select p from Person p where p.id=(select max(p2.id) from Person p2)")
    Person findMaxIdPerson();;

    //为Query注解传递参数方式1：使用占位符(参数有顺序)
    @Query("select p from Person p where p.lastName=?1 and p.email=?2")
    List<Person> testQueryAnnotationParams(String lastName,String email);

    //为Query注解传递参数方式2：命名参数的方式(参数无顺序)
    @Query("select p from Person p where p.lastName=:lastName and p.email=:email")
    List<Person> testQueryAnnotationParams2(@Param("email") String email, @Param("lastName") String lastName);

    //Like参数的传递(在占位符上使用%)
    @Query("select p from Person p where p.lastName like %?1% or p.email like %?2%")
    List<Person> testQueryAnnotationLikeParam(String lastName,String email);
    //Like参数的传递(在占位符上使用%)

    //使用原生的SQL注解
    @Query(value = "select count(id) from person",nativeQuery = true)
    int getPersonCount();


    //可以通过自定义的JPQL完成update和delete操作，注意：JPQL不支持插入语句（insert）
    //在Query注解中，编写JPQL语句，但必须使用@Modiying进行修饰，以通知spring data，这是一个update或者是delete
    //update或者是delete操作需要使用事物，此时需要定义Service层，在Service层上添加事物操作
    //默认情况下，springdata的每个方法上都是有事物的，但都是一个只读事物，他们不能完成修改操作
    @Modifying
    @Query("update Person p set p.email=?1 where id=?2")
    int updatePersonLastName(String email,Integer id);
}
