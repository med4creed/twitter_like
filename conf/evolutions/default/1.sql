# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table groupe (
  id                        bigint not null,
  nom_groupe                varchar(30) not null,
  date_creation             timestamp,
  user_admin_id             bigint,
  constraint pk_groupe primary key (id))
;

create table message (
  id                        bigint not null,
  msg                       varchar(255),
  date_creation             timestamp,
  user_id                   bigint,
  grp_id                    bigint,
  constraint pk_message primary key (id))
;

create table utilisateur (
  id                        bigint not null,
  nom                       varchar(30) not null,
  pnom                      varchar(30) not null,
  pseudo                    varchar(30) not null,
  mail                      varchar(255) not null,
  mdp                       varchar(30),
  date_inscription          timestamp,
  constraint uq_utilisateur_pseudo unique (pseudo),
  constraint uq_utilisateur_mail unique (mail),
  constraint pk_utilisateur primary key (id))
;


create table groupe_utilisateur (
  groupe_id                      bigint not null,
  utilisateur_id                 bigint not null,
  constraint pk_groupe_utilisateur primary key (groupe_id, utilisateur_id))
;
create sequence groupe_seq;

create sequence message_seq;

create sequence utilisateur_seq;

alter table groupe add constraint fk_groupe_userAdmin_1 foreign key (user_admin_id) references utilisateur (id) on delete restrict on update restrict;
create index ix_groupe_userAdmin_1 on groupe (user_admin_id);
alter table message add constraint fk_message_user_2 foreign key (user_id) references utilisateur (id) on delete restrict on update restrict;
create index ix_message_user_2 on message (user_id);
alter table message add constraint fk_message_grp_3 foreign key (grp_id) references groupe (id) on delete restrict on update restrict;
create index ix_message_grp_3 on message (grp_id);



alter table groupe_utilisateur add constraint fk_groupe_utilisateur_groupe_01 foreign key (groupe_id) references groupe (id) on delete restrict on update restrict;

alter table groupe_utilisateur add constraint fk_groupe_utilisateur_utilisa_02 foreign key (utilisateur_id) references utilisateur (id) on delete restrict on update restrict;

# --- !Downs

SET REFERENTIAL_INTEGRITY FALSE;

drop table if exists groupe;

drop table if exists groupe_utilisateur;

drop table if exists message;

drop table if exists utilisateur;

SET REFERENTIAL_INTEGRITY TRUE;

drop sequence if exists groupe_seq;

drop sequence if exists message_seq;

drop sequence if exists utilisateur_seq;

