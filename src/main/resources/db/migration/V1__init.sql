create table AS_ADDR_OBJ
(
    id bigint primary key unique,
    object_id  bigint,
    name       varchar not null,
    type_name  varchar not null,
    start_date timestamp,
    end_date   timestamp,
    is_active  bigint,
    is_actual  bigint
);

create table AS_ADM_HIERARCHY
(
    id bigint primary key unique,
    object_id bigint,
    parent_obj_id bigint,
    start_date timestamp,
    end_date   timestamp,
    is_active  bigint
);
-- ALTER TABLE AS_ADM_HIERARCHY
--     ADD CONSTRAINT FK_OBJ_ID_ON_PR FOREIGN KEY (change_id) REFERENCES AS_ADDR_OBJ (change_id);
-- ALTER TABLE AS_ADM_HIERARCHY
--     ADD CONSTRAINT FK_OBJ_ID_ON_PR FOREIGN KEY (object_id) REFERENCES AS_ADDR_OBJ (object_id);
-- ALTER TABLE AS_ADM_HIERARCHY
--     ADD CONSTRAINT FK_PARENT_OBJ_ID_ON_PR FOREIGN KEY (parent_obj_id) REFERENCES AS_ADDR_OBJ (object_id);


