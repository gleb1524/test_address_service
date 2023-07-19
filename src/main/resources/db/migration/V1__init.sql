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



