package cn.gzm.app.service.impl;

import cn.gzm.app.dao.UserDao;
import cn.gzm.app.service.UserDataService;

import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

/**
 * @author: gzm
 * @date: 19-6-4
 * @description: Pass
 */
public class UserDataServiceImpl implements UserDataService {
    private UserDao userDao = null;
    private String[] books;
    private List<String> hobbies;
    private Map<String, String> cards;
    private Set<String> games;
    private Properties properties;

    public UserDataServiceImpl() {
        System.out.println("这是UserDataServiceImpl无参构造函数");
    }
    public UserDataServiceImpl(UserDao userDao) {
        System.out.println("这是UserDataServiceImpl有参构造函数");
        this.userDao = userDao;
    }

    public void setUserDao(UserDao userDao) {
        System.out.println("这是UserDataServiceImpl的set函数");
        this.userDao = userDao;
    }

    public void setBooks(String[] books) {
        this.books = books;
    }

    public void setHobbies(List<String> hobbies) {
        this.hobbies = hobbies;
    }

    public void setCards(Map<String, String> cards) {
        this.cards = cards;
    }

    public void setGames(Set<String> games) {
        this.games = games;
    }

    public void setProperties(Properties properties) {
        this.properties = properties;
    }

    @Override
    public void getUser() {
        userDao.getUser();
    }
}
