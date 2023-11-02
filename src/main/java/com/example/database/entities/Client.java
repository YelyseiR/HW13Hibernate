package com.example.database.entities;

import jakarta.persistence.*;
import lombok.Data;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Entity
@Table(name = "clients")
@Data
public class Client {

    private static final Logger LOG = LogManager.getLogger(Client.class);

    @Id
    @Column(name = "id")
    private long id;

    @Column(name = "first_name", length = 201)
    private String firstName;

    @Column(name = "last_name", length = 201)
    private String lastName;

    @PostPersist
    public void logNewClientPersisted() {
        LOG.info("Persisted client: '{} {}'", firstName, lastName);
    }

    @PostLoad
    public void logUserLoad() {
        LOG.info("Loaded client: '{} {}'", firstName, lastName);
    }

    @PostUpdate
    public void logUserUpdated() {
        LOG.info("Updated client: '{} {}'", firstName, lastName);
    }

    @PostRemove
    public void logClientRemoval() {
        LOG.info("Deleted client: '{} {}'", firstName, lastName);
    }
}
