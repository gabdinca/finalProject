insert into ingredient
values (1, 'onion');
insert into ingredient
values (2, 'garlic');
insert into ingredient
values (3, 'fish');
insert into ingredient
values (4, 'pasta');
insert into ingredient
values (5, 'chicken');
insert into ingredient
values (6, 'pork');

insert into user
values (1, 25, 'iulian.marcu@gmail.com', true, 'marcu', 'iulian', true,
        '$2a$10$snXYE3FdVZYWXRZjuSoIIOFPxU6Tf0EZcrRa4Xg45wou3TyNKPNg6', 'ADMIN');
insert into user
values (2, 35, 'gabi@gmail.com', true, 'dinca', 'gabriel', true,
        '$2a$10$eyv6ad0LEoZE8vvR8HG.r.19w4pxHpItzCx9MoIgpDXPOSfXWS4ve', 'ADMIN');
insert into user
values (3, 22, 'user@user.com', true, 'user', 'user', true, 'password', 'USER');

insert into recipe
values (1, 'description1', 'preparation instruction 1', 'APPROVED', 'title1');
insert into recipe
values (2, 'description2', 'preparation instruction 2', 'APPROVED', 'title2');
insert into recipe
values (3, 'description3', 'preparation instruction 3', 'APPROVED', 'title3');
insert into recipe
values (4, 'description4', 'preparation instruction 4', 'APPROVED', 'title4');
insert into recipe
values (5, 'description5', 'preparation instruction 5', 'APPROVED', 'title5');