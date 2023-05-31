package br.com.uniamerica.imobiliaria.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.envers.AuditTable;
import org.hibernate.envers.Audited;

@Entity
@Table(name = "Owner",schema = "public")
@Audited
@AuditTable(value = "   Owner_audit", schema = "audit")
public class Owner extends Pessoa {
    @Setter
    @Getter
    @Column(name="documento",nullable=false)
    private String documento;
}
