package com.spring.service;

import com.spring.dao.UserDao;
import com.spring.domain.User;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.sql.Date;
import java.text.SimpleDateFormat;

/**
 * Created by Allen Yang
 * 2018/5/4 9:01
 */
public class UserService {
    /*  Long类型转换为String */
    public static String longToString(Long mysqlBigInt){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        /*  java.util.Date是毫秒单位 mysqlBigint是秒单位 */
        java.util.Date judt = new Date(mysqlBigInt * 1000);
        /*  返回格式化时间戳字符串 */
        return simpleDateFormat.format(judt);
    }
    /*  date转换为long */
    public static Long dateTolong(java.util.Date judt){
        /*  date.getTime()所返回的是一个long型的毫秒数,除以1000得到秒  */
        return judt.getTime()/1000;
    }

    @Test//增
    public void demo1(){
        User user = new User();
        user.setId(11);
        user.setName("赖小七");
        user.setQQ("123432123");
        user.setTrain_major("Java");
        user.setAdmiss_time((long)20180321);
        user.setGraduate_school("中国戏剧学院");
        user.setOnline_number("2131");
        user.setDaily_link("http://www.jnshu.com/daily/53594?dailyType=others&total=7&page=1&uid=19204&sort=0&orderBy=9");
        user.setOath("么么哒");
        user.setCoaching_senior("大爹");
        user.setWhere_know("知乎");
        user.setCreate_at(dateTolong(new java.util.Date()));
        user.setUpdate_at(dateTolong(new java.util.Date()));

        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("applicationContext.xml");
        UserDao dao = (UserDao) applicationContext.getBean("userDao");
        dao.addUser(user);
    }

    @Test//改
    public void demo2(){
        User user = new User();
        user.setId(20);
        user.setName("赖美云");
        user.setQQ("123432123");
        user.setTrain_major("Java");
        user.setAdmiss_time((long)20180321);
        user.setGraduate_school("中国戏剧学院");
        user.setOnline_number("2131");
        user.setDaily_link("http://www.jnshu.com/daily/53594?dailyType=others&total=7&page=1&uid=19204&sort=0&orderBy=9");
        user.setOath("你的努力和小心机，从一到三以来逐步让走进大众的视野");
        user.setCoaching_senior("大爹");
        user.setWhere_know("知乎");
        user.setCreate_at(dateTolong(new java.util.Date()));
        user.setUpdate_at(dateTolong(new java.util.Date()));

        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("applicationContext.xml");
        UserDao dao = (UserDao) applicationContext.getBean("userDao");
        dao.update(user);
    }

    @Test//删
    public void demo3(){
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("applicationContext.xml");
        UserDao dao = (UserDao) applicationContext.getBean("userDao");
        dao.delete(21);
    }

    @Test//查（查询一个用户）
    public void demo4(){
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("applicationContext.xml");
        UserDao dao=(UserDao) applicationContext.getBean("userDao");
        User user=dao.getOneUser(13);
        System.out.println(user.getId());
        System.out.println(user.getName());
        System.out.println(user.getQQ());
        System.out.println(user.getTrain_major());
        System.out.println(user.getAdmiss_time());
        System.out.println(user.getGraduate_school());
        System.out.println(user.getOnline_number());
        System.out.println(user.getDaily_link());
        System.out.println(user.getOath());
        System.out.println(user.getCoaching_senior());
        System.out.println(user.getWhere_know());
        System.out.println(longToString(user.getCreate_at()));
        System.out.println(longToString(user.getUpdate_at()));

    }
}
