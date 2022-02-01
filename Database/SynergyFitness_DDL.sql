create schema if not exists synergyfitness;
DROP TABLE IF EXISTS role CASCADE;
DROP TABLE IF EXISTS roles CASCADE;
DROP TABLE IF EXISTS person CASCADE;
DROP TABLE IF EXISTS media CASCADE;
DROP TABLE IF EXISTS calorie_tracker CASCADE;
DROP TABLE IF EXISTS about_me CASCADE;
DROP TABLE IF EXISTS post CASCADE;
DROP TABLE IF EXISTS user_comment CASCADE;
DROP TABLE IF EXISTS users CASCADE;

create table if not exists user_role(
	role_id serial primary key,
	role_name varchar(25) not null
);


create table if not exists person(
	user_id serial primary key,
	role_id integer not null references user_role(role_id),
	assigned_trainer integer references person(user_id),
	gym_user_name varchar(50) not null,
	passwd varchar(50) not null,
	first_name varchar(50),
	last_name varchar(50),
	sign_in_counter integer,
	tracker_id integer,
	last_sign_in_date date
);


create table if not exists calorie_tracker(
	tracker_id serial primary key,
	user_id integer not null references person(user_id),
	total_calories integer,
	food_list varchar(250) 
);
create table if not exists media(
	media_id serial primary key,
	post_id integer not null,
	file_name varchar(50),
	media_url varchar(100) 
);
create table if not exists about_me(
	about_me_id serial primary key,
	user_id integer not null references person(user_id),
	media_id integer not NULL REFERENCES media(media_id),
	description varchar(500),
	trainer_age integer,
	certs varchar(500),
	experience varchar(500)
);
create table if not exists post(
	post_id serial primary key,
	user_id integer not null references person(user_id),
	post_data varchar(250) not null
);

create table if not exists user_comment(
	comment_id serial primary key,
	user_id integer not null references person(user_id),
	post_id integer not null references post(post_id),
	reply_id integer,
	comment_data varchar(500) not null
);
alter table if exists media
add foreign key(post_id) references post(post_id);
alter table if exists user_comment
add foreign key(reply_id) references user_comment(comment_id);
alter table if exists person
add foreign key(tracker_id) references calorie_tracker(tracker_id);

alter table if exists media	alter column post_id drop not null;