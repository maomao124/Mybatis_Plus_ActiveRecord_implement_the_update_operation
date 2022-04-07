package mapper;

import com.baomidou.mybatisplus.core.MybatisSqlSessionFactoryBuilder;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import data.Student;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Project name(项目名称)：Mybatis_Plus_ActiveRecord实现更新操作
 * Package(包名): mapper
 * Class(测试类名): StudentMapperTest
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2022/4/7
 * Time(创建时间)： 18:18
 * Version(版本): 1.0
 * Description(描述)： 测试类
 */


class StudentMapperTest
{
    /**
     * Update.
     *
     * @throws IOException the io exception
     */
    @Test
    public void update() throws IOException
    {
        String resource = "mybatis-config.xml";
        //读取配置文件mybatis-config.xml
        InputStream config = Resources.getResourceAsStream(resource);
        //根据配置文件构建SqlSessionFactory
        SqlSessionFactory sqlSessionFactory = new MybatisSqlSessionFactoryBuilder().build(config);
        //通过SqlSessionFactory创建SqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();

        Student student = new Student();
        student.setStudent_no(202012341062L);
        student.setBirthday("2002");
        student.setId_card("123456");

        boolean b = student.updateById();
        System.out.println(b);
    }

    /**
     * Update 1.
     *
     * @throws IOException the io exception
     */
    @Test
    public void update1() throws IOException
    {
        String resource = "mybatis-config.xml";
        //读取配置文件mybatis-config.xml
        InputStream config = Resources.getResourceAsStream(resource);
        //根据配置文件构建SqlSessionFactory
        SqlSessionFactory sqlSessionFactory = new MybatisSqlSessionFactoryBuilder().build(config);
        //通过SqlSessionFactory创建SqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();

        Student student = new Student();
//        student.setStudent_no(202012341062L);
//        student.setBirthday("2002");
//        student.setId_card("123456");

        UpdateWrapper<Student> updateWrapper = new UpdateWrapper<>();
        updateWrapper.set("birthday", "2002").set("id_card", "123456")
                .eq("student_no", 202012341062L);

        boolean b = student.update(updateWrapper);
        System.out.println(b);
    }
}