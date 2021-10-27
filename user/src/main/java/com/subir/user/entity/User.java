package com.subir.user.entity;

import lombok.Data;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import java.util.UUID;

@Table("user")
@Data
public class User {
    @PrimaryKey
    @Column("id")
    private UUID id;
    @Column("name")
    private String name;
    @Column("country")
    private String country;
}
