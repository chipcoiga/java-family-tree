package org.demis.family.core.familyrelation;

import org.demis.family.core.AbstractEntity;
import org.demis.family.core.FamilyRole;
import org.demis.family.core.family.FamilyEntity;
import org.demis.family.core.familytree.FamilyTreeEntity;
import org.demis.family.core.individual.IndividualEntity;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

import static javax.persistence.FetchType.LAZY;

@Entity
@Table(name="family_relation")
public class FamilyRelationEntity extends AbstractEntity {

    @Column(name = "family_relation_id", nullable = false, unique = true, length = 32)
    @GeneratedValue(generator = "strategy-uuid")
    @GenericGenerator(name = "strategy-uuid", strategy = "uuid")
    @Id
    private String id = null;

    @JoinColumn(name = "family_tree_id")
    @ManyToOne(fetch = LAZY)
    private FamilyTreeEntity familyTree;

    @JoinColumn(name = "family_id")
    @ManyToOne(fetch = LAZY)
    private FamilyEntity family;

    @JoinColumn(name = "individual_id")
    @ManyToOne(fetch = LAZY)
    private IndividualEntity individual;

    @Column(name = "role", nullable = true)
    @Enumerated(EnumType.STRING)
    private FamilyRole role;

    public FamilyRelationEntity() {
        // nop op
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

    public FamilyEntity getFamily() {
        return family;
    }

    public void setFamily(FamilyEntity family) {
        this.family = family;
    }

    public IndividualEntity getIndividual() {
        return individual;
    }

    public void setIndividual(IndividualEntity individual) {
        this.individual = individual;
    }

    public FamilyRole getRole() {
        return role;
    }

    public void setRole(FamilyRole role) {
        this.role = role;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        FamilyRelationEntity that = (FamilyRelationEntity) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }
}
