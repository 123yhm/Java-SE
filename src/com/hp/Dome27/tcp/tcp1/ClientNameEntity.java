package com.hp.Dome27.tcp.tcp1;

public class ClientNameEntity {
    private String name;
    private String ip;

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ClientNameEntity(String name, String ip) {
        this.name = name;
        this.ip = ip;
    }

    @Override
    public String toString() {
        return "ClientNameEntity{" +
                "name='" + name + '\'' +
                ", ip='" + ip + '\'' +
                '}';
    }

    public ClientNameEntity(String name) {
        this.name = name;
    }
    public ClientNameEntity(){
        super();
    }
}
