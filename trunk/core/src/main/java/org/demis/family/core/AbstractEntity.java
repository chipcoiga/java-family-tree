package org.demis.family.core;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import java.util.Date;

@MappedSuperclass
public abstract class AbstractEntity {

    @Column(name = "creation_date", nullable = false)
    private Date creationDate = null;

    @Column(name = "modification_date", nullable = false)
    private Date modificationDate = null;

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
