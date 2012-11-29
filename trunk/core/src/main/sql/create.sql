create table family_tree (
    family_tree_id   character varying(32),
    creation_date timestamp without time zone,
    modification_date timestamp without time zone,
    constraint family_tree_pk primary key (family_tree_id)
);

create table individual (
    individual_id   character varying(32),
    family_tree_id   character varying(32),
    creation_date timestamp without time zone,
    modification_date timestamp without time zone,

    constraint individual_pk primary key (individual_id),
    constraint individual_family_tree_fk foreign key (family_tree_id)
        references family_tree (family_tree_id)
);

create table family (
    family_id   character varying(32),
    family_tree_id   character varying(32),
    creation_date timestamp without time zone,
    modification_date timestamp without time zone,

    constraint family_pk primary key (family_id),
    constraint family_family_tree_fk foreign key (family_tree_id)
        references family_tree (family_tree_id)
);