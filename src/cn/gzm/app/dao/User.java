package cn.gzm.app.dao;

/**
 * @author: gzm
 * @date: 19-6-5
 * @description: Pass
 */
public class User {
    private String name;

    public User(String name) {
        this.name = name;
    }

    public User() {
        this.name = null;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
