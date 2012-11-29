package org.demis.family.web.familytree;

/**
 * Created with IntelliJ IDEA.
 * User: kermabon
 * Date: 28/11/12
 * Time: 08:41
 * To change this template use File | Settings | File Templates.
 */
public class FamilyTreeExposed {

    private String familyTreeId = null;

    public final static String URI_BASE = "/familytrees/";

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
}
