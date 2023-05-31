package br.com.uniamerica.imobiliaria.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import org.hibernate.envers.AuditTable;
import org.hibernate.envers.Audited;

@Entity
@Audited
@Table(name = "comprador",schema = "public")
@AuditTable(value = "comprador_audit", schema = "audit")
public class Comprador extends AbstractEntity {
    @Getter
    @Column(name="documento",nullable=false)
    private String documento;
}
