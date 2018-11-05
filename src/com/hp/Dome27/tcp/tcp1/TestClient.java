package com.hp.Dome27.tcp.tcp1;

import com.sun.tools.internal.ws.wsdl.document.soap.SOAPUse;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class TestClient {
    @Test
    public void test(){
        List<ClientNameEntity> list=new ArrayList();
        list.add(new ClientNameEntity("小明",""));
        list.add(new ClientNameEntity("小彪"));
        list.add(new ClientNameEntity("小芳"));
        list.add(new ClientNameEntity("小灿"));

        for (ClientNameEntity li:list) {
            System.out.println(li.getName());
        }
    }
}
