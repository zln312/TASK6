


import com.cache.CacheImpl;
import com.cache.Memcached;

import com.model.Excellent;
import org.junit.Test;
import org.junit.runner.RunWith;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:ApplicationContext.xml")

public class DemoDao {
    @Autowired
    CacheImpl cache;
    @Test
    public void add() {
        Excellent excellent=new Excellent();
        excellent.setId(12);
        excellent.setSalary(2311);
        excellent.setJob("adfas");
        excellent.setPicture("asdf");
        excellent.setStatus(1);
        excellent.setName("ada");
        excellent.setProfession("qwer");
        excellent.setDescription("qweq");
      cache.add(String.valueOf(excellent.getId()),excellent);
        System.out.println( cache.selectOne(String.valueOf(12)) );
    }
}