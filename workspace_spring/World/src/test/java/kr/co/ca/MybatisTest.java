package kr.co.ca;

import java.sql.Connection;

import javax.inject.Inject;
import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)

@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/spring/**/*.xml" })
public class MybatisTest {

   @Inject
   private SqlSessionFactory sqlFactory;

   @Test
   public void testSession() {
      SqlSession session = null;
      try {
         session = sqlFactory.openSession();
         System.out.println("===================");
      } catch (Exception e) {
         e.printStackTrace();
      } finally {
         try {
            if (session != null) {
               session.close();
            }
         } catch (Exception e2) {
            e2.printStackTrace();
         }
      }
   }
}
