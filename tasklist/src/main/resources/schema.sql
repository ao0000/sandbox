create table if not exists task_list(
    id varchar(8) primary key,
    task varchar(256),
    deadline varchar(10),
    done boolean
);