package cn.gzm.staticProxy.dao;

/**
 * @author: gzm
 * @date: 19-6-6
 * @description: Pass
 */
public class Proxy implements Rent {
    private Rent host;

    public void setHost(Rent host) {
        this.host = host;
    }

    @Override
    public void rent() {
        vist();
        host.rent();
        fare();
    }
    private void vist() {
        System.out.println("带房客看房");
    }
    private void fare() {
        System.out.println("收取房租");
    }
}
