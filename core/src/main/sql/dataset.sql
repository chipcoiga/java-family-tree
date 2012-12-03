insert into "user" (user_id, creation_date, modification_date, email, firstname, lastname) values ('aze', current_date, current_date, 'aze@email.com', 'A', 'B');

insert into family_tree (family_tree_id, creation_date, modification_date, user_id) values ('abc', current_date, current_date, 'aze');
insert into family_tree (family_tree_id, creation_date, modification_date, user_id) values ('def', current_date, current_date, 'aze');