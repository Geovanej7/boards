package com.br.board.model.card;

import com.br.board.util.entity.AuditableEntity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Card extends AuditableEntity {

    @Column(nullable = false)
    private String title;
    @Column(nullable = false)
    private String description;
}
