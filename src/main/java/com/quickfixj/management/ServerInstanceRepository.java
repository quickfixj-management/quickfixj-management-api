package com.quickfixj.management;

import io.quarkus.hibernate.reactive.panache.PanacheRepositoryBase;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class ServerInstanceRepository implements PanacheRepositoryBase<ServerInstanceEntity, Long> {

}