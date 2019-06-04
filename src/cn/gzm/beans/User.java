package cn.gzm.beans;

/**
 * @author: gzm
 * @date: 19-6-4
 * @description: Pass
 */
public class User {
    private String name;

    public User() {
        System.out.println("User正在被创建");
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
