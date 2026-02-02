package com.taskmanager.entity;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;

import com.taskmanager.enums.Role;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "user_profiles") 
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class UserProfileUpdate {
 
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    private String userName;

    @Column(unique = true)
    private String email;

    private String department;

    private String designation;

    private String organizationName; 

    @Enumerated(EnumType.STRING)
    private Role role;
 
    private boolean active=true;

    @CreationTimestamp
    private LocalDateTime createdAt;

}
