package cn.gzm.staticProxy.dao;

/**
 * @author: gzm
 * @date: 19-6-6
 * @description: Pass
 */
public class Host implements Rent {
    @Override
    public void rent() {
        System.out.println("房屋出租");
    }
}
