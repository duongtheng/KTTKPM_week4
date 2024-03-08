package com.example.demoredisspringboot.entity;

import lombok.*;
import org.springframework.data.annotation.*;
import org.springframework.data.redis.core.RedisHash;
import org.springframework.data.redis.core.index.Indexed;

@Data
@AllArgsConstructor
@NoArgsConstructor
@RedisHash(value = "Customer")
public class Customer {
    @Id
    @Indexed
    private int id; // "indexed" for faster retrieval,
    // @Id for marking this field as the key
    private String name;
    private long phone;
    private String email;
}
