package org.demis.family.core.family;

import org.apache.log4j.Logger;
import org.demis.family.core.AbstractEntity;
import org.demis.family.core.familyrelation.FamilyRelationEntity;
import org.demis.family.core.familytree.FamilyTreeEntity;
import org.demis.family.core.individual.IndividualEntity;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.List;

import static javax.persistence.FetchType.LAZY;

@Entity
@Table(name="family")
public class FamilyEntity extends AbstractEntity {

    private static final Logger logger = Logger.getLogger(FamilyEntity.class);

    @Column(name = "family_id", nullable = false, unique = true, length = 32)
    @GeneratedValue(generator = "strategy-uuid")
    @GenericGenerator(name = "strategy-uuid", strategy = "uuid")
    @Id
    private String id = null;

    @JoinColumn(name = "family_tree_id")
    @ManyToOne(fetch = LAZY)
    private FamilyTreeEntity familyTree;

    @Column(name = "sosa", nullable = true)
    private String sosaCode;

    @OneToMany(mappedBy = "family")
    private List<FamilyRelationEntity> relations;

    public FamilyEntity() {
        // no op
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public FamilyTreeEntity getFamilyTree() {
        return familyTree;
    }

    public void setFamilyTree(FamilyTreeEntity familyTree) {
        this.familyTree = familyTree;
    }

    public String getSosaCode() {
        return sosaCode;
    }

    public void setSosaCode(String sosaCode) {
        this.sosaCode = sosaCode;
    }

    public List<FamilyRelationEntity> getRelations() {
        return relations;
    }

    public void setRelations(List<FamilyRelationEntity> relations) {
        this.relations = relations;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        FamilyEntity that = (FamilyEntity) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }
}
