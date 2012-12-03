package org.demis.family.core.user;

import org.demis.family.core.AbstractEntity;
import org.demis.family.core.familytree.FamilyTreeEntity;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="\"user\"")
public class UserEntity extends AbstractEntity {

    @Column(name = "user_id", nullable = false, unique = true, length = 32)
    @GeneratedValue(generator = "strategy-uuid")
    @GenericGenerator(name = "strategy-uuid", strategy = "uuid")
    @Id
    private String id = null;

    @Column(name = "email", nullable = true)
    private String email = null;

    @Column(name = "first_name", nullable = true)
    private String firstName = null;

    @Column(name = "last_name", nullable = true)
    private String lastName = null;

    @OneToMany(mappedBy = "user")
    private List<FamilyTreeEntity> familyTrees;

    public UserEntity() {
        // no op
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public List<FamilyTreeEntity> getFamilyTrees() {
        return familyTrees;
    }

    public void setFamilyTrees(List<FamilyTreeEntity> familyTrees) {
        this.familyTrees = familyTrees;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserEntity that = (UserEntity) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }
}
