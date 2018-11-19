# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table booked_slots (
  slot_id                       bigint auto_increment not null,
  vehicle_type                  varchar(9),
  vehicle_id                    bigint,
  type                          varchar(9),
  constraint ck_booked_slots_vehicle_type check (vehicle_type in ('HATCHBACK','SUV','SEDAN')),
  constraint ck_booked_slots_type check (type in ('HATCHBACK','SUV','SEDAN')),
  constraint pk_booked_slots primary key (slot_id)
);

create table bookings (
  booking_id                    bigint auto_increment not null,
  vehicle_id                    bigint,
  type                          varchar(9),
  user_id                       bigint,
  start_time                    datetime(6),
  end_time                      datetime(6),
  canceled                      tinyint(1) default 0,
  constraint ck_bookings_type check (type in ('HATCHBACK','SUV','SEDAN')),
  constraint pk_bookings primary key (booking_id)
);

create table users (
  user_id                       bigint auto_increment not null,
  first_name                    varchar(255),
  last_name                     varchar(255),
  constraint pk_users primary key (user_id)
);

create table vehicles (
  id                            bigint auto_increment not null,
  type                          varchar(9),
  base_price                    bigint,
  registration_number           varchar(255),
  constraint ck_vehicles_type check (type in ('HATCHBACK','SUV','SEDAN')),
  constraint pk_vehicles primary key (id)
);

alter table booked_slots add constraint fk_booked_slots_vehicle_id foreign key (vehicle_id) references vehicles (id) on delete restrict on update restrict;
create index ix_booked_slots_vehicle_id on booked_slots (vehicle_id);

alter table bookings add constraint fk_bookings_vehicle_id foreign key (vehicle_id) references vehicles (id) on delete restrict on update restrict;
create index ix_bookings_vehicle_id on bookings (vehicle_id);

alter table bookings add constraint fk_bookings_user_id foreign key (user_id) references users (user_id) on delete restrict on update restrict;
create index ix_bookings_user_id on bookings (user_id);


# --- !Downs

alter table booked_slots drop foreign key fk_booked_slots_vehicle_id;
drop index ix_booked_slots_vehicle_id on booked_slots;

alter table bookings drop foreign key fk_bookings_vehicle_id;
drop index ix_bookings_vehicle_id on bookings;

alter table bookings drop foreign key fk_bookings_user_id;
drop index ix_bookings_user_id on bookings;

drop table if exists booked_slots;

drop table if exists bookings;

drop table if exists users;

drop table if exists vehicles;

