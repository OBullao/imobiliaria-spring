package br.com.uniamerica.imobiliaria.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.envers.AuditTable;
import org.hibernate.envers.Audited;

@Entity
@Table(name = "admin",schema = "public")
@Audited
@AuditTable(value = "adminAudit", schema = "audit")
public class Admin extends Pessoa {
    @Getter
    @Setter
    @Column(name="password",nullable=false,length=100)
    private String password;

}

