create table family_tree (
    family_tree_id   character varying(32),
    constraint family_tree_pk primary key (family_tree_id)
);

create table family (
    family_id   character varying(32),
    constraint family_pk primary key (family_id)
);