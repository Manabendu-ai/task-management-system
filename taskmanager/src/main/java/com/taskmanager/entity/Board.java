package com.taskmanager.entity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.annotations.CreationTimestamp;

import com.taskmanager.enums.BoardType;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OrderBy;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "boards") 
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Board {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long boardId;

    private String boardName;

    private String projectKey;

    @Enumerated(EnumType.STRING)
    private BoardType boardType;

    @CreationTimestamp
    private LocalDateTime createdAt;

    @OneToMany(mappedBy="board")
    @Builder.Default
    @OrderBy("position")
    private List<BoardColumn> boardColumns = new ArrayList<>();

}
