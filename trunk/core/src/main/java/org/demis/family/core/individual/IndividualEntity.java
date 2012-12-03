package org.demis.family.core.individual;

import org.demis.family.core.AbstractEntity;
import org.demis.family.core.familytree.FamilyTreeEntity;
import org.demis.family.core.user.UserEntity;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

import java.util.List;

import static javax.persistence.FetchType.LAZY;

@Entity
@Table(name="individual")
public class IndividualEntity extends AbstractEntity {

    @Column(name = "individual_id", nullable = false, unique = true, length = 32)
    @GeneratedValue(generator = "strategy-uuid")
    @GenericGenerator(name = "strategy-uuid", strategy = "uuid")
    @Id
    private String id = null;

    @JoinColumn(name = "family_tree_id")
    @ManyToOne(fetch = LAZY)
    private FamilyTreeEntity familyTree;

    public IndividualEntity() {
        // no op
    }

    public FamilyTreeEntity getFamilyTree() {
        return familyTree;
    }

    public void setFamilyTree(FamilyTreeEntity familyTree) {
        this.familyTree = familyTree;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        IndividualEntity that = (IndividualEntity) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }
}
