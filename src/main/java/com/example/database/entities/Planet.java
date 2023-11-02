package com.example.database.entities;

import jakarta.persistence.*;
import lombok.Data;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Entity
@Table(name = "planets")
@Data
public class Planet {

    private static final Logger LOG = LogManager.getLogger(Planet.class);

    @Id
    @Column(name = "id")
    private String id;

    @Column(name = "name", length = 501)
    private String name;

    @PostPersist
    public void logNewClientPersisted() {
        LOG.info("Persisted planet: '{}'", name);
    }

    @PostLoad
    public void logUserLoad() {
        LOG.info("Loaded planet: '{}'", name);
    }

    @PostUpdate
    public void logUserUpdated() {
        LOG.info("Updated planet: '{}'", name);
    }

    @PostRemove
    public void logClientRemoval() {
        LOG.info("Deleted planet: '{}'", name);
    }
}
