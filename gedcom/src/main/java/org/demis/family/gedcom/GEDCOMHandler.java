package org.demis.family.gedcom;

import org.apache.log4j.Logger;
import org.demis.family.core.family.FamilyEntity;
import org.demis.family.core.familytree.FamilyTreeEntity;
import org.demis.family.core.individual.IndividualEntity;

import java.util.Stack;

public class GEDCOMHandler {

    private static final Logger logger = Logger.getLogger(GEDCOMHandler.class);

    private int currentlevel = -1;

    private Stack objectstack = new Stack();

    private FamilyTreeEntity familyTree;

    public void handle(GEDCOMTuple tuple) {
        logger.debug("handle tuple : " + tuple);
        logger.debug("handle tuple : " + objectstack);
        // All line except end of file
        // detect end of object description by a level decrease
        if (!"TRLR".equals(tuple.getCode())) {
            while (tuple.getLevel() <= currentlevel) {
                objectstack.pop();
                currentlevel--;
            }
            currentlevel = tuple.getLevel();
        }
        if ("HEAD".equals(tuple.getCode())) {
            familyTree = new FamilyTreeEntity();
            objectstack.push(familyTree);
        }
//        else if ("SUBN".equals(tuple.getCode())) {
//            handleSubmission(tuple);
//        }
        else if ("INDI".equals(tuple.getCode()) && tuple.getLevel() == 0) {
            handleIndividual(tuple);
        }
        else if ("FAM".equals(tuple.getCode()) && tuple.getLevel() == 0) {
            handleFamily(tuple);
        }
//        else if ("OBJE".equals(tuple.getCode()) && tuple.getLevel() == 0) {
//            handleMultimedia(tuple);
//        }
//        else if ("NOTE".equals(tuple.getCode())) {
//            handleNote(tuple);
//        }
//        else if ("REPO".equals(tuple.getCode()) && tuple.getLevel() == 0) {
//            handleRepository(tuple);
//        }
//        else if ("SOUR".equals(tuple.getCode())) {
//            handleSource(tuple);
//        }
//        else if ("SUBM".equals(tuple.getCode())) {
//            handleSubmitter(tuple);
//        }
//        else if ("VERS".equals(tuple.getCode())) {
//            handleVersion(tuple);
//        }
        else if ("NAME".equals(tuple.getCode())) {
            handleName(tuple);
        }
//        else if ("CORP".equals(tuple.getCode())) {
//            handleCorporate(tuple);
//        }
//        else if ("ADDR".equals(tuple.getCode())) {
//            handleAddress(tuple);
//        }
//        else if ("CONT".equals(tuple.getCode())) {
//            handleContinue(tuple);
//        }
//        else if ("ADR1".equals(tuple.getCode())) {
//            handleAddressLine1(tuple);
//        }
//        else if ("ADR2".equals(tuple.getCode())) {
//            handleAddressLine2(tuple);
//        }
//        else if ("CITY".equals(tuple.getCode())) {
//            handleCity(tuple);
//        }
//        else if ("STAE".equals(tuple.getCode())) {
//            handleState(tuple);
//        }
//        else if ("POST".equals(tuple.getCode())) {
//            handlePostalCode(tuple);
//        }
//        else if ("CTRY".equals(tuple.getCode())) {
//            handleContry(tuple);
//        }
//        else if ("PHON".equals(tuple.getCode())) {
//            handlePhoneNumber(tuple);
//        }
//        else if ("DATA".equals(tuple.getCode())) {
//            handleData(tuple);
//        }
//        else if ("DATE".equals(tuple.getCode())) {
//            handleDate(tuple);
//        }
//        else if ("CORP".equals(tuple.getCode())) {
//            handleCopyright(tuple);
//        }
//        else if ("DEST".equals(tuple.getCode())) {
//            handleDestination(tuple);
//        }
//        else if ("TIME".equals(tuple.getCode())) {
//            handleTime(tuple);
//        }
//        else if ("FILE".equals(tuple.getCode())) {
//            handleFilename(tuple);
//        }
//        else if ("FORM".equals(tuple.getCode())) {
//            handleFormat(tuple);
//        }
//        else if ("CHAR".equals(tuple.getCode())) {
//            handleCharset(tuple);
//        }
//        else if ("LANG".equals(tuple.getCode())) {
//            handleLanguage(tuple);
//        }
//        else if ("PLAC".equals(tuple.getCode())) {
//            handlePlace(tuple);
//        }
//        else if ("CONC".equals(tuple.getCode())) {
//            handleConcat(tuple);
//        }
//        else if (  "ANUL".equals(tuple.getCode())
//                || "CENS".equals(tuple.getCode())
//                || "DIV".equals(tuple.getCode())
//                || "DIVF".equals(tuple.getCode())
//                || "ENGA".equals(tuple.getCode())
//                || "MARR".equals(tuple.getCode())
//                || "MARB".equals(tuple.getCode())
//                || "MARC".equals(tuple.getCode())
//                || "MARL".equals(tuple.getCode())
//                || "MARS".equals(tuple.getCode())
//                || "EVEN".equals(tuple.getCode())
//                ) {
//            handleEvent(tuple);
//        }
//        else if ("TYPE".equals(tuple.getCode())) {
//            handleType(tuple);
//        }
//        else if ("HUSB".equals(tuple.getCode())) {
//            handleHusband(tuple);
//        }
//        else if ("WIFE".equals(tuple.getCode())) {
//            handleWife(tuple);
//        }
//        else if ("CHIL".equals(tuple.getCode())) {
//            handleChild(tuple);
//        }
//        else if ("NCHI".equals(tuple.getCode())) {
//            handleChildrenNumber(tuple);
//        }
//        else if ("RESN".equals(tuple.getCode())) {
//            handleRestrictionNotice(tuple);
//        }
//        else if ("RFN".equals(tuple.getCode())) {
//            handlePermanentRecordFileNumber(tuple);
//        }
//        else if ("AFN".equals(tuple.getCode())) {
//            handleAncestralFileNumber(tuple);
//        }
//        else if ("REFN".equals(tuple.getCode())) {
//            handleUserReferenceNumber(tuple);
//        }
//        else if ("RIN".equals(tuple.getCode())) {
//            handleAutomatedRecordId(tuple);
//        }
        else {
            objectstack.push(tuple);
        }
    }

    private void handleAutomatedRecordId(GEDCOMTuple tuple) {
//        if (!(objectstack.peek() instanceof IndividualModel)
//                && !(objectstack.peek() instanceof FamilyModel)) {
//            logger.warn("No automated record id container for : " + tuple);
//        }
//        objectstack.push(tuple);
    }

    private void handleUserReferenceNumber(GEDCOMTuple tuple) {
//        if (!(objectstack.peek() instanceof IndividualModel)
//                && !(objectstack.peek() instanceof FamilyModel)) {
//            logger.warn("No user reference number container for : " + tuple);
//        }
//        objectstack.push(tuple);
    }

    private void handleAncestralFileNumber(GEDCOMTuple tuple) {
//        if (!(objectstack.peek() instanceof IndividualModel)) {
//            logger.warn("No ancestral file number container for : " + tuple);
//        }
//        objectstack.push(tuple);
    }

    private void handlePermanentRecordFileNumber(GEDCOMTuple tuple) {
//        if (!(objectstack.peek() instanceof IndividualModel)) {
//            logger.warn("No permanent record file number container for : " + tuple);
//        }
//        objectstack.push(tuple);
    }

    private void handleRestrictionNotice(GEDCOMTuple tuple) {
//        if (!(objectstack.peek() instanceof IndividualModel)) {
//            logger.warn("No restriction notice container for : " + tuple);
//            objectstack.push(tuple);
//        }
//        else {
//            ((IndividualModel)(objectstack.peek())).setRestrictionNotice(RestrictionNotice.getRestrictionNotice(tuple.getInfo()).getId());
//        }
    }

    private void handleChildrenNumber(GEDCOMTuple tuple) {
//        if (!(objectstack.peek() instanceof FamilyModel)) {
//            logger.warn("No children number container for : " + tuple);
//        }
//        objectstack.push(tuple);
    }

    private void handleChild(GEDCOMTuple tuple) {
//        if (objectstack.peek() instanceof FamilyModel) {
//            IndividualModel individual = familyTree.getIndividuals(tuple.getRef());
//            ((FamilyModel)objectstack.peek()).addChild(individual);
//        }
//        else {
//            logger.warn("No child container for : " + tuple);
//        }
//        objectstack.push(tuple);
    }

    private void handleWife(GEDCOMTuple tuple) {
//        if (objectstack.peek() instanceof FamilyModel) {
//            IndividualModel individual = familyTree.getIndividuals(tuple.getRef());
//            ((FamilyModel)objectstack.peek()).addParent(individual);
//        }
//        else {
//            logger.warn("No wife container for : " + tuple);
//        }
//        objectstack.push(tuple);
    }


    private void handleHusband(GEDCOMTuple tuple) {
//        if (objectstack.peek() instanceof FamilyModel) {
//            IndividualModel individual = familyTree.getIndividuals(tuple.getRef());
//            ((FamilyModel)objectstack.peek()).addParent(individual);
//        }
//        else {
//            logger.warn("No husband container for : " + tuple);
//        }
//        objectstack.push(tuple);
    }

    private void handleType(GEDCOMTuple tuple) {
//        if (objectstack.peek() instanceof EventModel) {
//            ((EventModel)(objectstack.peek())).setType(tuple.getInfo());
//        }
//        else {
//            logger.warn("No type container for " + tuple);
//        }
//        objectstack.push(tuple);
    }

    private void handleEvent(GEDCOMTuple tuple) {
//        EventModel event = new EventModel();
//        event.setPrimaryType(tuple.getCode());
//        if (objectstack.peek() instanceof FamilyModel) {
//            ((FamilyModel)(objectstack.peek())).addEvent(event);
//        }
//        else {
//            logger.warn("No event container for " + tuple);
//        }
//        objectstack.push(event);
    }

    private void handlePlace(GEDCOMTuple tuple) {
//        if (objectstack.peek() instanceof FamilyTreeModel) {
//            ((FamilyTreeModel)(objectstack.peek())).setPlaceHierarchy(tuple.getInfo());
//            objectstack.push(tuple);
//        }
//        else if (objectstack.peek() instanceof PlaceContainer) {
//            PlaceModel place = new PlaceModel();
//            place.setPlaceHierarchy(tuple.getInfo());
//            ((PlaceContainer)(objectstack.peek())).setPlace(place);
//            objectstack.push(place);
//        }
//        else {
//            logger.warn("No place container for " + tuple);
//            objectstack.push(tuple);
//        }
    }

    private void handleLanguage(GEDCOMTuple tuple) {
//        if (objectstack.peek() instanceof FamilyTreeModel) {
//            ((FamilyTreeModel)(objectstack.peek())).setLanguage(tuple.getInfo());
//        }
//        else {
//            logger.warn("No language container for " + tuple);
//        }
//        objectstack.push(tuple);
    }

    private void handleCharset(GEDCOMTuple tuple) {
//        if (objectstack.peek() instanceof FamilyTreeModel) {
//            ((FamilyTreeModel)(objectstack.peek())).setCharset(tuple.getInfo());
//        }
//        else {
//            logger.warn("No language container for " + tuple);
//        }
//        objectstack.push(tuple);
    }

    private void handleFormat(GEDCOMTuple tuple) {
//        if (objectstack.peek() instanceof PlaceModel) {
//            ((PlaceModel)(objectstack.peek())).setPlaceHierarchy(tuple.getInfo());
//        }
//        else if (objectstack.peek() instanceof FamilyTreeModel) {
//            ((FamilyTreeModel)(objectstack.peek())).setGedcomFormat(tuple.getInfo());
//        }
//        else {
//            logger.warn("No format container for " + tuple);
//        }
//        objectstack.push(tuple);
    }

    private void handleFilename(GEDCOMTuple tuple) {
//        if (objectstack.peek() instanceof FamilyTreeModel) {
//            ((FamilyTreeModel)(objectstack.peek())).setFilename(tuple.getInfo());
//        }
//        else {
//            logger.warn("No filename container for " + tuple);
//        }
//        objectstack.push(tuple);
    }

    private void handleTime(GEDCOMTuple tuple) {
//        if (objectstack.peek() instanceof FamilyTreeModel) {
//            ((FamilyTreeModel)(objectstack.peek())).setTransmissionTime(tuple.getInfo());
//        }
//        else {
//            logger.warn("No time container for " + tuple);
//        }
//        objectstack.push(tuple);
    }


    private void handleDestination(GEDCOMTuple tuple) {
//        if (objectstack.peek() instanceof FamilyTreeModel) {
//            ((FamilyTreeModel)(objectstack.peek())).setDestination(tuple.getInfo());
//        }
//        else {
//            logger.warn("No destination container for " + tuple);
//        }
//        objectstack.push(tuple);
    }

    private void handleCopyright(GEDCOMTuple tuple) {
//        if (objectstack.peek() instanceof FamilyTreeSourceModel) {
//            ((FamilyTreeSourceModel)(objectstack.peek())).setDataCopyright(tuple.getInfo());
//        }
//        else if (objectstack.peek() instanceof FamilyTreeModel) {
//            ((FamilyTreeModel)(objectstack.peek())).setCopyright(tuple.getInfo());
//        }
//        else {
//            logger.warn("No copyright container for " + tuple);
//        }
//        objectstack.push(tuple);
    }

    private void handleDate(GEDCOMTuple tuple) {
//        DateModel date = GEDCOMDateParser.parseDate(tuple.getInfo());
//        if (objectstack.peek() instanceof FamilyTreeSourceModel) {
//            ((FamilyTreeSourceModel)(objectstack.peek())).setDataPublicationDate(tuple.getInfo());
//        }
//        else if (objectstack.peek() instanceof FamilyTreeModel) {
//            ((FamilyTreeModel)(objectstack.peek())).setTransmissionDate(tuple.getInfo());
//        }
//        else {
//            logger.warn("No date container for " + tuple);
//        }
//        objectstack.push(tuple);
    }

    private void handleData(GEDCOMTuple tuple) {
//        if (objectstack.peek() instanceof FamilyTreeSourceModel) {
//            ((FamilyTreeSourceModel)(objectstack.peek())).setDataName(tuple.getInfo());
//        }
//        else {
//            logger.warn("No data container for " + tuple);
//        }
//        objectstack.push(tuple);
    }

    private void handlePhoneNumber(GEDCOMTuple tuple) {
//        PhoneNumberModel phoneNumber = new PhoneNumberModel();
//        phoneNumber.setPhoneNumber(tuple.getInfo());
//        if (objectstack.peek() instanceof PhoneNumberContainer) {
//            ((PhoneNumberContainer)(objectstack.peek())).addPhoneNumber(phoneNumber);
//        }
//        else {
//            logger.warn("No phone number container for " + tuple);
//        }
//        objectstack.push(phoneNumber);
    }

    private void handleContry(GEDCOMTuple tuple) {
//        if (objectstack.peek() instanceof AddressModel) {
//            AddressModel address = ((AddressModel)(objectstack.peek()));
//            address.setContry(tuple.getInfo());
//        }
//        else {
//            logger.warn("AddressModel contry not for an AddressModel object");
//        }
//        objectstack.push(tuple);
    }

    private void handlePostalCode(GEDCOMTuple tuple) {
//        if (objectstack.peek() instanceof AddressModel) {
//            AddressModel address = ((AddressModel)(objectstack.peek()));
//            address.setPostalCode(tuple.getInfo());
//        }
//        else {
//            logger.warn("AddressModel postal code not for an AddressModel object");
//        }
//        objectstack.push(tuple);
    }

    private void handleState(GEDCOMTuple tuple) {
//        if (objectstack.peek() instanceof AddressModel) {
//            AddressModel address = ((AddressModel)(objectstack.peek()));
//            address.setState(tuple.getInfo());
//        }
//        else {
//            logger.warn("AddressModel state not for an AddressModel object");
//        }
//        objectstack.push(tuple);
    }

    private void handleCity(GEDCOMTuple tuple) {
//        if (objectstack.peek() instanceof AddressModel) {
//            AddressModel address = ((AddressModel)(objectstack.peek()));
//            address.setCity(tuple.getInfo());
//        }
//        else {
//            logger.warn("AddressModel city not for an AddressModel object");
//        }
//        objectstack.push(tuple);
    }

    private void handleAddressLine2(GEDCOMTuple tuple) {
//        if (objectstack.peek() instanceof AddressModel) {
//            AddressModel address = ((AddressModel)(objectstack.peek()));
//            address.setLine2(tuple.getInfo());
//        }
//        else {
//            logger.warn("AddressModel line 2 not for an AddressModel object");
//        }
//        objectstack.push(tuple);
    }

    private void handleAddressLine1(GEDCOMTuple tuple) {
//        if (objectstack.peek() instanceof AddressModel) {
//            AddressModel address = ((AddressModel)(objectstack.peek()));
//            address.setLine1(tuple.getInfo());
//        }
//        else {
//            logger.warn("AddressModel line 1 not for an AddressModel object");
//        }
//        objectstack.push(tuple);
    }

    private void handleContinue(GEDCOMTuple tuple) {
//        if (tuple.getInfo() != null) {
//            handleConcatOrContinue("\n" + tuple.getInfo());
//        }
//        else {
//            handleConcatOrContinue(tuple.getInfo());
//        }
//        objectstack.push(tuple);
    }

    private void handleConcat(GEDCOMTuple tuple) {
//        handleConcatOrContinue(tuple.getInfo());
//        objectstack.push(tuple);
    }

    private void handleConcatOrContinue(String text) {
//        if (objectstack.peek() instanceof AddressModel) {
//            AddressModel address = ((AddressModel)(objectstack.peek()));
//            address.setLine(address.getLine() + text);
//        }
//        else if (objectstack.peek() instanceof GEDCOMTuple) {
//            GEDCOMTuple previous = (GEDCOMTuple)(objectstack.peek());
//            if ("NOTE".equals(previous.getCode())) {
//                familyTree.setNote(familyTree.getNote() + text);
//            }
//            else {
//                logger.warn("No concate, continue container for " + text);
//            }
//        }
//        else {
//            logger.warn("No concate, continue container for " + text);
//        }
    }

    private void handleAddress(GEDCOMTuple tuple) {
//        AddressModel address = new AddressModel();
//        address.setLine(tuple.getInfo());
//        if (objectstack.peek() instanceof AddressContainer) {
//            ((AddressContainer)(objectstack.peek())).setAddress(address);
//        }
//        else {
//            logger.warn("No address container for " + tuple);
//        }
//        objectstack.push(address);
    }

    private void handleCorporate(GEDCOMTuple tuple) {
//        FamilyTreeSourceCorporationModel corporation = new FamilyTreeSourceCorporationModel();
//        corporation.setName(tuple.getInfo());
//        ((FamilyTreeSourceModel)(objectstack.peek())).setCorporations(corporation);
//        objectstack.push(corporation);
    }

    private void handleName(GEDCOMTuple tuple) {
//        if (objectstack.peek() instanceof FamilyTreeSourceModel) {
//            ((FamilyTreeSourceModel)(objectstack.peek())).setName(tuple.getInfo());
//        }
//        else if (objectstack.peek() instanceof IndividualModel) {
//            ((IndividualEntity)(objectstack.peek())).setCompleteName(tuple.getInfo());
//            IndividualNameModel name = new IndividualNameModel();
//            ((IndividualModel)(objectstack.peek())).addIndividualName(name);
//            name.setPersonalName(tuple.getInfo());
//        }
//        objectstack.push(tuple);
    }

    private void handleVersion(GEDCOMTuple tuple) {
//        if (objectstack.peek() instanceof FamilyTreeSourceModel) {
//            ((FamilyTreeSourceModel)(objectstack.peek())).setVersion(tuple.getInfo());
//        }
//        else if (objectstack.peek() instanceof GEDCOMTuple) {
//            GEDCOMTuple previous = ((GEDCOMTuple)(objectstack.peek()));
//            if ("GEDC".equals(previous.getCode())) {
//                familyTree.setGedcomVersion(tuple.getInfo());
//            }
//            else if ("CHAR".equals(previous.getCode())) {
//                familyTree.setCharsetVersion(tuple.getInfo());
//            }
//            else {
//                logger.warn("No container for version for " + tuple);
//            }
//        }
//        else if (objectstack.peek() instanceof FamilyTreeModel) {
//            ((FamilyTreeModel)(objectstack.peek())).setGedcomVersion(tuple.getInfo());
//        }
//        else {
//            logger.warn("No container for version for " + tuple);
//        }
//        objectstack.push(tuple);
    }

    private void handleSubmission(GEDCOMTuple tuple) {
//        SubmissionModel submission = familyTree.getSubmission(tuple.getRef());
//        if (submission == null) {
//            submission = new SubmissionModel();
//            submission.setIdent(tuple.getRef());
//            familyTree.addSubmission(submission);
//        }
//        if (tuple.getLevel() > 0) {
//            if (objectstack.peek() instanceof FamilyTreeModel) {
//                ((FamilyTreeModel)(objectstack.peek())).addFileSubmission(submission);
//            }
//            else {
//                logger.warn("No submission container for " + tuple);
//            }
//        }
//        objectstack.push(submission);
    }

    private void handleSubmitter(GEDCOMTuple tuple) {
//        SubmitterModel submitter = familyTree.getSubmitter(tuple.getRef());
//        if (submitter == null) {
//            submitter = new SubmitterModel();
//            submitter.setIdent(tuple.getRef());
//            familyTree.addSubmitter(submitter);
//        }
//        if (tuple.getLevel() > 0) {
//            if (objectstack.peek() instanceof FamilyTreeModel) {
//                ((FamilyTreeModel)(objectstack.peek())).addFileSubmitter(submitter);
//            }
//            else if (objectstack.peek() instanceof  SubmitterContainer) {
//                ((SubmitterContainer)(objectstack.peek())).addSubmitter(submitter);
//            }
//            else {
//                logger.warn("No submitter container for " + tuple);
//            }
//        }
//        objectstack.push(submitter);
    }

    private void handleSource(GEDCOMTuple tuple) {
//        // Primary source declaration
//        if (!(objectstack.size() > 0 && objectstack.peek() instanceof FamilyTreeModel)) {
//            SourceModel source = familyTree.getSource(tuple.getRef());
//            if (source == null) {
//                source = new SourceModel();
//                source.setIdent(tuple.getRef());
//            }
//            if (tuple.getLevel() == 0) {
//                familyTree.addSource(source);
//            }
//            else if (objectstack.size() > 0 && objectstack.peek() instanceof SourceContainer) {
//                ((SourceContainer)(objectstack.peek())).addSource(source);
//            }
//
//            objectstack.push(source);
//        }
//        // Header source
//        else {
//            FamilyTreeSourceModel source = new FamilyTreeSourceModel();
//            source.setApprovedSystemId(tuple.getInfo());
//            familyTree.setSource(source);
//            objectstack.push(source);
//        }
//
    }

    private void handleRepository(GEDCOMTuple tuple) {
//        RepositoryModel repository = familyTree.getRepository(tuple.getRef());
//        if (repository == null) {
//            repository = new RepositoryModel();
//            repository.setIdent(tuple.getRef());
//            familyTree.addRepository(repository);
//        }
//        objectstack.push(repository);
    }

    private void handleNote(GEDCOMTuple tuple) {
//        if (tuple.getRef() != null) {
//            NoteModel note = familyTree.getNote(tuple.getRef());
//            if (note == null) {
//                note = new NoteModel();
//                note.setIdent(tuple.getRef());
//                familyTree.addNote(note);
//            }
//            if (objectstack.peek() instanceof NoteContainer) {
//                ((NoteContainer)(objectstack.peek())).addNote(note);
//            }
//            objectstack.push(note);
//        }
//        else if (objectstack.peek() instanceof FamilyTreeModel) {
//            ((FamilyTreeModel)(objectstack.peek())).setNote(tuple.getInfo());
//            objectstack.push(tuple);
//        }
//        else {
//            logger.warn("No note container for " + tuple);
//            objectstack.push(tuple);
//        }
    }

    private void handleMultimedia(GEDCOMTuple tuple) {
//        MultimediaModel multimedia = familyTree.getMultimedia(tuple.getRef());
//        if (multimedia == null) {
//            multimedia = new MultimediaModel();
//            multimedia.setIdent(tuple.getRef());
//            familyTree.addMultimedia(multimedia);
//        }
//        objectstack.push(multimedia);
//
    }

    private void handleFamily(GEDCOMTuple tuple) {
        FamilyEntity family = familyTree.getFamily(tuple.getRef());
        if (family == null) {
            family = new FamilyEntity();
            family.setSosaCode(tuple.getRef());
            familyTree.addFamily(family);
        }
        objectstack.push(family);
    }

    private void handleIndividual(GEDCOMTuple tuple) {
        IndividualEntity individual = familyTree.getIndividual(tuple.getRef());
        if (individual == null) {
            individual = new IndividualEntity();
            individual.setSosaCode(tuple.getRef());
            familyTree.addIndividual(individual);
        }
        objectstack.push(individual);
    }

    public FamilyTreeEntity getFamilyTree() {
        return familyTree;
    }
}
