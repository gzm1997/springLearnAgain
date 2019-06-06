package cn.gzm.staticProxy.test;

import cn.gzm.staticProxy.dao.Host;
import cn.gzm.staticProxy.dao.Proxy;

/**
 * @author: gzm
 * @date: 19-6-6
 * @description: Pass
 */
public class Test {
    public static void main(String[] args) {
        Host host = new Host();
        Proxy proxy = new Proxy();
        proxy.setHost(host);
        proxy.rent();
    }
}
