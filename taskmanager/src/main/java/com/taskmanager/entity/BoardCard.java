package com.taskmanager.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Index;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "board_card", indexes = {
    @Index(name="idx_board_card", columnList = "board_id, position, board_column_id ")
}) 
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class BoardCard {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long boardCardId;

    private Long issueId;

    private Long boardId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "board_column_id", nullable = false)
    private BoardColumn boardColumn;

    private Integer position;

}
