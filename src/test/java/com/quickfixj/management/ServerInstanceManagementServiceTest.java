package com.quickfixj.management;

import com.google.protobuf.Empty;
import com.quickfixj.management.v1.ServerInstanceList;
import com.quickfixj.management.v1.ServerInstanceManagementService;
import io.quarkus.grpc.GrpcClient;
import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;
import org.quickfixj.management.v1.ServerInstance;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@QuarkusTest
public class ServerInstanceManagementServiceTest {

    @GrpcClient
    ServerInstanceManagementService client;

    @Test
    public void getAllServerInstances() {
        ServerInstanceList response = client.getAllServerInstances(Empty.getDefaultInstance())
                .await().atMost(Duration.ofSeconds(5));
        assertNotNull(response);
        assertEquals(1, response.getServerInstancesCount());

        ServerInstance instance1 = response.getServerInstancesList().get(0);
        assertEquals(1, instance1.getServerInstanceId().getValue());
        assertEquals("test1", instance1.getName());
    }

}