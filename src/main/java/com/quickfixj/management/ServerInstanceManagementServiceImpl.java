package com.quickfixj.management;

import com.google.protobuf.Empty;
import com.quickfixj.management.v1.ServerInstanceList;
import com.quickfixj.management.v1.ServerInstanceManagementService;
import io.quarkus.grpc.GrpcService;
import io.quarkus.hibernate.reactive.panache.common.WithSession;
import io.smallrye.mutiny.Uni;
import jakarta.inject.Inject;
import org.quickfixj.management.v1.ServerInstance;

import java.util.List;

@GrpcService
public class ServerInstanceManagementServiceImpl implements ServerInstanceManagementService {

    @Inject
    ServerInstanceRepository serverInstanceRepository;

    @Inject
    ServerInstanceMapper serverInstanceMapper;

    @Override
    @WithSession
    public Uni<ServerInstanceList> getAllServerInstances(Empty request) {
        return serverInstanceRepository.listAll()
                .map(entities -> {
                    List<ServerInstance> protos = entities.stream()
                            .map(serverInstanceMapper::toProto)
                            .toList();
                    return ServerInstanceList.newBuilder()
                            .addAllServerInstances(protos)
                            .build();
                });
    }

}
