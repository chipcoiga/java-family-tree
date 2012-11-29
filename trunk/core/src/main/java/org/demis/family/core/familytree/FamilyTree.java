package org.demis.family.core.familytree;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;


@Entity
@Table(name="family_tree")
public class FamilyTree {

    @Column(name = "family_tree_id", nullable = false, unique = true, length = 32)
    @GeneratedValue(generator = "strategy-uuid")
    @GenericGenerator(name = "strategy-uuid", strategy = "uuid")
    @Id
    private String familyTreeId = null;

    public FamilyTree() {
        // no op
    }

    public FamilyTree(String familyTreeId) {
        this.familyTreeId = familyTreeId;
    }

    public String getFamilyTreeId() {
        return familyTreeId;
    }

    public void setFamilyTreeId(String familyTreeId) {
        this.familyTreeId = familyTreeId;
    }
}
