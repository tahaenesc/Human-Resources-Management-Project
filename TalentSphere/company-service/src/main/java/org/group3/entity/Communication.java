package org.group3.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.group3.entity.enums.EStatus;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Entity
@Table(name = "tbl_communication")
public class Communication implements IStatus{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnore
    Company company;

    String name;

    String phoneNumber;

    @Enumerated(EnumType.STRING)
    @Builder.Default
    EStatus status = EStatus.ACTIVE;
}
