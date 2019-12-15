
    alter table `administrator` 
       drop 
       foreign key FK_2a5vcjo3stlfcwadosjfq49l1;

    alter table `anonymous` 
       drop 
       foreign key FK_6lnbc6fo3om54vugoh8icg78m;

    alter table `applications` 
       drop 
       foreign key `FKj2gllxnbrvk83wdygiyxdul40`;

    alter table `applications` 
       drop 
       foreign key `FKfott6wy710nqog2etbl4atl2c`;

    alter table `audit_record` 
       drop 
       foreign key `FKdcrrgv6rkfw2ruvdja56un4ji`;

    alter table `audit_record` 
       drop 
       foreign key `FKlbvbyimxf6pxvbhkdd4vfhlnd`;

    alter table `auditor` 
       drop 
       foreign key FK_clqcq9lyspxdxcp6o4f3vkelj;

    alter table `authenticated` 
       drop 
       foreign key FK_h52w0f3wjoi68b63wv9vwon57;

    alter table `commercial_banner` 
       drop 
       foreign key `FKd0k52g7lcacefcp62kb4p9aor`;

    alter table `consumer` 
       drop 
       foreign key FK_6cyha9f1wpj0dpbxrrjddrqed;

    alter table `descriptor_duty` 
       drop 
       foreign key `FK57eqqlhihwvd53ykpmsiqlx2p`;

    alter table `descriptor_duty` 
       drop 
       foreign key `FKqitedkrksd2w8qyp1fp5eao9f`;

    alter table `employer` 
       drop 
       foreign key FK_na4dfobmeuxkwf6p75abmb2tr;

    alter table `job` 
       drop 
       foreign key `FKfqwyynnbcsq0htxho3vchpd2u`;

    alter table `job` 
       drop 
       foreign key `FK3rxjf8uh6fh2u990pe8i2at0e`;

    alter table `message` 
       drop 
       foreign key `FKn5adlx3oqjna7aupm8gwg3fuj`;

    alter table `message_thread_user_account` 
       drop 
       foreign key `FKtglq9xf20msr37ngr5q0x35d0`;

    alter table `message_thread_user_account` 
       drop 
       foreign key `FKtchis3o5qij98x87mty6hdk4d`;

    alter table `non_commercial_banner` 
       drop 
       foreign key `FKpcpr0xb5k7s4rxv5pulstt5v9`;

    alter table `provider` 
       drop 
       foreign key FK_b1gwnjqm6ggy9yuiqm0o4rlmd;

    alter table `sponsor` 
       drop 
       foreign key FK_20xk0ev32hlg96kqynl6laie2;

    alter table `worker` 
       drop 
       foreign key FK_l5q1f33vs2drypmbdhpdgwfv3;

    drop table if exists `administrator`;

    drop table if exists `announcement`;

    drop table if exists `anonymous`;

    drop table if exists `applications`;

    drop table if exists `audit_record`;

    drop table if exists `auditor`;

    drop table if exists `authenticated`;

    drop table if exists `banner`;

    drop table if exists `challenge`;

    drop table if exists `commercial_banner`;

    drop table if exists `consumer`;

    drop table if exists `delgado_bulletin`;

    drop table if exists `descriptor`;

    drop table if exists `descriptor_duty`;

    drop table if exists `duty`;

    drop table if exists `employer`;

    drop table if exists `fernandez_bulletin`;

    drop table if exists `garcia_bulletin`;

    drop table if exists `guerrero_bulletin`;

    drop table if exists `hu_bulletin`;

    drop table if exists `investor_records`;

    drop table if exists `job`;

    drop table if exists `message`;

    drop table if exists `message_thread`;

    drop table if exists `message_thread_user_account`;

    drop table if exists `non_commercial_banner`;

    drop table if exists `offer`;

    drop table if exists `provider`;

    drop table if exists `records`;

    drop table if exists `request2`;

    drop table if exists `shout`;

    drop table if exists `soto_bulletin`;

    drop table if exists `spam`;

    drop table if exists `sponsor`;

    drop table if exists `user_account`;

    drop table if exists `worker`;

    drop table if exists `hibernate_sequence`;
