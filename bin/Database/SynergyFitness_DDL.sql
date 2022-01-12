DROP TABLE IF EXISTS roles CASCADE;
DROP TABLE IF EXISTS users CASCADE;
DROP TABLE IF EXISTS media CASCADE;
DROP TABLE IF EXISTS calorie_tracker CASCADE;
DROP TABLE IF EXISTS about_me CASCADE;
DROP TABLE IF EXISTS roles CASCADE;
DROP TABLE IF EXISTS post CASCADE;
DROP TABLE IF EXISTS user_comment CASCADE;

create table if not exists roles(
	role_id serial primary key,
	role_name varchar(25) not null
);


create table if not exists users(
	user_id serial primary key,
	role_id integer not null references roles(role_id),
	assigned_trainer integer references users(user_id),
	gym_user_name varchar(50) not null,
	passwd varchar(50) not null,
	first_name varchar(50),
	last_name varchar(50),
	Last_Sign_In_Date date
);


create table if not exists calorie_tracker(
	tracker_id serial primary key,
	user_id integer not null references users(user_id),
	total_calories integer not null,
	food_list varchar(250) 
);
create table if not exists media(
	media_id serial primary key,
	post_id integer not null,
	media_path varchar(100) not null
);
create table if not exists about_me(
	about_me_id serial primary key,
	user_id integer not null references users(user_id),
	media_id integer not NULL REFERENCES media(media_id),
	description varchar(500),
	trainer_age integer,
	certs varchar(500),
	experience varchar(500)
);
create table if not exists post(
	post_id serial primary key,
	user_id integer not null references users(user_id),
	post_data varchar(250) not null
);

create table if not exists user_comment(
	user_comment_id serial primary key,
	user_id integer not null references users(user_id),
	post_id integer not null references post(post_id),
	reply_id integer references user_comment(user_comment_id),
	comment_data varchar(500) not null
);
alter table if exists media
add foreign key(post_id) references post(post_id);