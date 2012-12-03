package org.demis.family.core.familytree;

import org.apache.log4j.Logger;
import org.demis.family.core.AbstractEntity;
import org.demis.family.core.family.FamilyEntity;
import org.demis.family.core.individual.IndividualEntity;
import org.demis.family.core.user.UserEntity;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

import static javax.persistence.FetchType.LAZY;


@Entity
@Table(name="family_tree")
public class FamilyTreeEntity extends AbstractEntity {

    private static final Logger logger = Logger.getLogger(FamilyTreeEntity.class);

    @Column(name = "family_tree_id", nullable = false, unique = true, length = 32)
    @GeneratedValue(generator = "strategy-uuid")
    @GenericGenerator(name = "strategy-uuid", strategy = "uuid")
    @Id
    private String id = null;

    @JoinColumn(name = "user_id")
    @ManyToOne(fetch = LAZY)
    private UserEntity user;

    @OneToMany(mappedBy = "familyTree")
    private List<IndividualEntity> individuals;

    @OneToMany(mappedBy = "familyTree")
    private List<FamilyEntity> families;

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

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    // Individuals
    public List<IndividualEntity> getIndividuals() {
        return individuals;
    }

    public void setIndividuals(List<IndividualEntity> individuals) {
        this.individuals = individuals;
    }

    public IndividualEntity getIndividual(String sosaCode) {
        if (individuals == null) {
            return null;
        }
        if (sosaCode == null)
            return null;
        for (IndividualEntity individual: individuals) {
            if (sosaCode.equals(individual.getSosaCode())) {
                return individual;
            }
        }
        return null;
    }

    public void addIndividual(IndividualEntity individual) {
        if (individual == null) {
            logger.warn("Try to add null individual to familyTree");
            return;
        }
        if (individuals == null) {
            individuals = new ArrayList<IndividualEntity>();
        }
        individuals.add(individual);
    }

    public void removeIndividual(IndividualEntity individual) {
        if (individual == null) {
            logger.warn("Try to remove null individual to familyTree");
            return;
        }
        if (individuals != null) {
            individuals.remove(individual);
        }
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    // Families
    public List<FamilyEntity> getFamilies() {
        return families;
    }

    public void setFamilies(List<FamilyEntity> families) {
        this.families = families;
    }

    public FamilyEntity getFamily(String sosaCode) {
        if (families == null) {
            return null;
        }
        if (sosaCode == null)
            return null;
        for (FamilyEntity family: families) {
            if (sosaCode.equals(family.getSosaCode())) {
                return family;
            }
        }
        return null;
    }

    public void addFamily(FamilyEntity family) {
        if (family == null) {
            logger.warn("Try to add null family to familyTree");
            return;
        }
        if (families == null) {
            families = new ArrayList<FamilyEntity>();
        }
        families.add(family);
    }

    public void removeFamily(FamilyEntity family) {
        if (family == null) {
            logger.warn("Try to remove null family to familyTree");
            return;
        }
        if (families != null) {
            families.remove(family);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        FamilyTreeEntity that = (FamilyTreeEntity) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }
}
