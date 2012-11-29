package org.demis.family.core.familytree;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;


@Entity
@Table(name="family_tree")
public class FamilyTreeEntity {

    @Column(name = "family_tree_id", nullable = false, unique = true, length = 32)
    @GeneratedValue(generator = "strategy-uuid")
    @GenericGenerator(name = "strategy-uuid", strategy = "uuid")
    @Id
    private String id = null;

    @Column(name = "creation_date", nullable = false)
    private Date creationDate = null;

    @Column(name = "modification_date", nullable = false)
    private Date modificationDate = null;

    public FamilyTreeEntity() {
        // no op
    }

    public FamilyTreeEntity(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public Date getModificationDate() {
        return modificationDate;
    }

    public void setModificationDate(Date modificationDate) {
        this.modificationDate = modificationDate;
    }
}
