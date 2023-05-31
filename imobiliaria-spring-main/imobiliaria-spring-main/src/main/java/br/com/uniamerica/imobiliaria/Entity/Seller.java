package br.com.uniamerica.imobiliaria.Entity;

import jakarta.persistence.*;
import org.hibernate.envers.AuditTable;
import org.hibernate.envers.Audited;

@Entity
@Table(name = "vendedor",schema = "public")
@Audited
@AuditTable(value = "vendedor_audit", schema = "audit")
public class Seller extends Pessoa {
}
