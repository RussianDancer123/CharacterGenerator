alter table ability_score_value drop foreign key FKfgc3m0rp2d8006itui4bmlbqh;
alter table ability_score_value drop foreign key FKayvidj0s0sbco0xu985rptskx;
alter table player_character drop foreign key FKs0brww9ncr2tidkxf0rdcj4hi;
alter table player_character drop foreign key FKd3i045gwtsayw8j8efdu7fqka;
alter table player_character drop foreign key FKnh37lmrp33chyvdh42jrvltvn;
alter table player_character drop foreign key FK4ippnwl1lbi78cm4jd4yk3y46;
alter table player_character drop foreign key FKe92jp6dxkymq89otsxfymkaod;
alter table player_character_spells drop foreign key FKfy74hu74j6ngi0jcucy9don6k;
alter table player_character_spells drop foreign key FKq383y8ms7eu9u8geske6abxvl;
alter table race drop foreign key FK4oby53hukqadi8x6ciiuyvkqs;
alter table spell drop foreign key FKk5bajc8j0gugqangl2roivvxb;
drop table if exists ability_score;
drop table if exists ability_score_value;
drop table if exists alignment;
drop table if exists background;
drop table if exists character_class;
drop table if exists player_character;
drop table if exists player_character_spells;
drop table if exists race;
drop table if exists race_details;
drop table if exists spell;
drop table if exists spell_details;
drop table if exists sub_race;
