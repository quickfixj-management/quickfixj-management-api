package com.quickfixj.management;

import jakarta.enterprise.context.ApplicationScoped;
import org.quickfixj.management.v1.ServerInstance;
import org.quickfixj.management.v1.ServerInstanceId;

@ApplicationScoped
public class ServerInstanceMapper {

    public ServerInstance toProto(ServerInstanceEntity entity) {
        if (entity == null) return null;

        var builder = ServerInstance.newBuilder()
                .setName(entity.name)
                .setClusterUrl(entity.clusterUrl != null ? entity.clusterUrl : "");

        if (entity.serverInstanceId != null) {
            builder.setServerInstanceId(ServerInstanceId.newBuilder()
                    .setValue(entity.serverInstanceId)
                    .build());
        }

        return builder.build();
    }

    public ServerInstanceEntity toEntity(ServerInstance proto) {
        ServerInstanceEntity entity = new ServerInstanceEntity();
        if (proto.hasServerInstanceId()) {
            entity.serverInstanceId = proto.getServerInstanceId().getValue();
        }
        entity.name = proto.getName();
        entity.clusterUrl = proto.getClusterUrl();
        return entity;
    }

}