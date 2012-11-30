package org.demis.family.core.familytree;

import org.demis.family.core.AbstractEntity;
import org.demis.family.core.user.UserEntity;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;
import static javax.persistence.FetchType.LAZY;


@Entity
@Table(name="family_tree")
public class FamilyTreeEntity extends AbstractEntity {

    @Column(name = "family_tree_id", nullable = false, unique = true, length = 32)
    @GeneratedValue(generator = "strategy-uuid")
    @GenericGenerator(name = "strategy-uuid", strategy = "uuid")
    @Id
    private String id = null;

    @JoinColumn(name = "user_id")
    @ManyToOne(fetch = LAZY)
    private UserEntity user;

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
