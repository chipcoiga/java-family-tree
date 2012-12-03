package org.demis.family.core.individual;

import org.demis.family.core.AbstractEntity;
import org.demis.family.core.Sex;
import org.demis.family.core.familyrelation.FamilyRelationEntity;
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

    @Column(name = "sosa", nullable = true)
    private String sosaCode;

    @Column(name = "sex", nullable = true)
    @Enumerated(EnumType.STRING)
    private Sex sex;

    @Column(name = "first_name", nullable = true)
    private String firstName = null;

    @Column(name = "last_name", nullable = true)
    private String lastName = null;

    @Column(name = "complete_name", nullable = true)
    private String completeName = null;

    @Column(name = "middle_names", nullable = true)
    private String middleNames = null;

    @OneToMany(mappedBy = "individual")
    private List<FamilyRelationEntity> relations;

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

    public String getSosaCode() {
        return sosaCode;
    }

    public void setSosaCode(String sosaCode) {
        this.sosaCode = sosaCode;
    }

    public Sex getSex() {
        return sex;
    }

    public void setSex(Sex sex) {
        this.sex = sex;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getCompleteName() {
        return completeName;
    }

    public void setCompleteName(String completeName) {
        this.completeName = completeName;
    }

    public String getMiddleNames() {
        return middleNames;
    }

    public void setMiddleNames(String middleNames) {
        this.middleNames = middleNames;
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

        IndividualEntity that = (IndividualEntity) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }
}
