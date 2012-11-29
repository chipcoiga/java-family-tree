package org.demis.family.web.familytree;

/**
 * Created with IntelliJ IDEA.
 * UserEntity: kermabon
 * Date: 28/11/12
 * Time: 08:41
 * To change this template use File | Settings | File Templates.
 */
public class FamilyTreeExposed {

    private String familyTreeId = null;

    public final static String URI_BASE = "/familytrees/";

    public long creationDate = -1;

    public long modificationDate = -1;

    private String URI = null;

    public String getFamilyTreeId() {
        return familyTreeId;
    }

    public void setFamilyTreeId(String familyTreeId) {
        this.familyTreeId = familyTreeId;
    }

    public String getURI() {
        return URI;
    }

    public void setURI(String URI) {
        this.URI = URI;
    }

    public long getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(long creationDate) {
        this.creationDate = creationDate;
    }

    public long getModificationDate() {
        return modificationDate;
    }

    public void setModificationDate(long modificationDate) {
        this.modificationDate = modificationDate;
    }
}
