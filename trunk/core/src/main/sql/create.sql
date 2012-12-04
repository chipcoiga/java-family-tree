create table "user" (
    user_id             character varying(32),
    creation_date       timestamp without time zone,
    modification_date   timestamp without time zone,
    email               character varying(255),
    first_name          character varying(64),
    last_name           character varying(64),
    constraint user_pk primary key (user_id)
);

create table family_tree (
    family_tree_id      character varying(32),
    creation_date       timestamp without time zone,
    modification_date   timestamp without time zone,
    user_id             character varying(32) not null,
    constraint family_tree_pk primary key (family_tree_id),
    constraint family_tree_user_fk foreign key (user_id)
        references "user" (user_id)
);

create table individual (
    individual_id       character varying(32),
    family_tree_id      character varying(32),
    creation_date       timestamp without time zone,
    modification_date   timestamp without time zone,
    sosa                character varying(32),
    sex                 character varying(1),
    complete_name       character varying(255),
    first_name          character varying(64),
    last_name           character varying(64),
    middle_names        character varying(64),

    constraint individual_pk primary key (individual_id),
    constraint individual_family_tree_fk foreign key (family_tree_id)
        references family_tree (family_tree_id)
);

create table family (
    family_id           character varying(32),
    family_tree_id      character varying(32),
    creation_date       timestamp without time zone,
    modification_date   timestamp without time zone,
    sosa                character varying(32),

    constraint family_pk primary key (family_id),
    constraint family_family_tree_fk foreign key (family_tree_id)
        references family_tree (family_tree_id)
);

create table family_relation (
    family_relation_id  character varying(32),
    family_tree_id      character varying(32),
    creation_date       timestamp without time zone,
    modification_date   timestamp without time zone,
    family_id           character varying(32),
    individual_id       character varying(32),
    role                character varying(1),

    constraint family_relation_pk primary key (family_relation_id),
    constraint family_relation_family_tree_fk foreign key (family_tree_id)
        references family_tree (family_tree_id),
    constraint family_relation_family_fk foreign key (family_id)
        references family (family_id),
    constraint family_relation_individual_fk foreign key (individual_id)
        references individual (individual_id)
);

create table "date" (
    date_id             character varying(32),
    family_tree_id      character varying(32),
    creation_date       timestamp without time zone,
    modification_date   timestamp without time zone,
    year                integer,
    month               integer,
    day                 integer,
    hour                integer,
    minute              integer,
    second              integer,

    constraint date_pk primary key (date_id),
    constraint date_container_family_tree_fk foreign key (family_tree_id)
        references family_tree (family_tree_id)
);

create table date_container (
    date_container_id   character varying(32),
    family_tree_id      character varying(32),
    creation_date       timestamp without time zone,
    modification_date   timestamp without time zone,
    mode                character varying(1),
    first_date_id       character varying(32),
    second_date_id      character varying(32),

    constraint date_container_pk primary key (date_container_id),
    constraint first_date_date_fk foreign key (first_date_id)
        references "date" (date_id),
    constraint second_date_date_fk foreign key (second_date_id)
        references "date" (date_id),
    constraint date_container_family_tree_fk foreign key (family_tree_id)
        references family_tree (family_tree_id)
);

create table event (
    event_id            character varying(32),
    family_tree_id      character varying(32),
    creation_date       timestamp without time zone,
    modification_date   timestamp without time zone,
    date_container_id   character varying(32),

    constraint event_pk primary key (event_id),
    constraint event_date_container_fk foreign key (date_container_id)
        references date_container (date_container_id),
    constraint event_family_tree_fk foreign key (family_tree_id)
        references family_tree (family_tree_id)
);