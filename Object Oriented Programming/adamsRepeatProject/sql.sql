create schema league;
use league;

create table if not exists leagues (
	id int auto_increment,
    serialized_object blob(1023),
    primary key (id)
)