package com.quickfixj.management;

import jakarta.persistence.*;

import java.util.Objects;

@Entity(name = "ServerInstance")
@Table(name = "server_instance")
public class ServerInstanceEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "server_instance_id")
    public Long serverInstanceId; // Matches ServerInstanceId.value

    @Column(name = "name", nullable = false)
    public String name;

    @Column(name = "cluster_url")
    public String clusterUrl;

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        ServerInstanceEntity that = (ServerInstanceEntity) o;
        return Objects.equals(serverInstanceId, that.serverInstanceId) && Objects.equals(name, that.name) && Objects.equals(clusterUrl, that.clusterUrl);
    }

    @Override
    public int hashCode() {
        return Objects.hash(serverInstanceId, name, clusterUrl);
    }

    @Override
    public String toString() {
        return "ServerInstanceEntity{" +
                "serverInstanceId='" + serverInstanceId + '\'' +
                ", name='" + name + '\'' +
                ", clusterUrl='" + clusterUrl + '\'' +
                '}';
    }

}