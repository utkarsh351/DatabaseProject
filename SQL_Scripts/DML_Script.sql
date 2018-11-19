---- Pre Insert TRIGGERS HERE || Write INSERT statements below this section ------
create sequence Schedule_id_seq;

create trigger trg_schedule_id
before insert on Schedule
for each row
begin
  select Schedule_id_seq.nextval
  into :new.schedule_id 
  from dual;
end;
/

create sequence Order_id_seq START WITH 1;

create trigger trg_order_id 
before insert on Orders
for each row
begin
  select Order_id_seq.nextval
  into :new.order_id 
  from dual;
end;
/

create sequence Service_Center_Order_id_seq START WITH 1;

create trigger trg_serive_center_order_id
before insert on Service_center_order
for each row
begin
  select Service_Center_Order_id_seq.nextval
  into :new.service_center_order_id 
  from dual;
end;
/

create sequence Distributor_Order_id_seq START WITH 1;

create trigger trg_distributor_order_id
before insert on Distributor_order
for each row
begin
  select Distributor_Order_id_seq.nextval
  into :new.distributor_order_id 
  from dual;
end;
/

/*
create sequence Maintain_schedule_id_seq;

create trigger trg_maintain_schedule_id
before insert on ance_schedule
for each row
begin
  select Maintain_schedule_id_seq.nextval
  into :new.maintenance_schedule_id
  from dual;
end;
/

create sequence Repair_schedule_id_seq;

create trigger trg_repair_schedule_id
before insert on Repair_schedule
for each row
begin
  select Repair_schedule_id_seq.nextval
  into :new.repair_schedule_id
  from dual;
end;
/
*/
-------------------------------------------------------

INSERT into Service_center
Values(
	'S0001',
	'Downtown Auto Care',
	'1.800.899.9999',
	'Address: 437 Fayetteville St., Raleigh, NC 27601'
);

INSERT into Service_center
Values(
	'S0002',
	'Express Auto Shop',
	'1.704.333.1555',
	'201 N Tryon St, Charlotte, NC 28202'
);
--#Inserting in Manager
INSERT into Users
Values(
	'lacohen@acme.com',
	'temp1'
);
INSERT into Users
Values(
	'deholmes@acme.com',
	'temp1'
);
INSERT into Users
Values(
	'duesparza@acme.com',
	'temp1'
);
INSERT into Users
Values(
	'chpudilo@acme.com',
	'temp1'
);
INSERT into Users
Values(
	'jarivera@acme.com',
	'temp1'
);
INSERT into Users
Values(
	'wimorton@acme.com',
	'temp1'
);
INSERT into Users
Values(
	'rihenderson@acme.com',
	'temp1'
);
INSERT into Users
Values(
	'wimartin@acme.com',
	'temp1'
);
INSERT into Users
Values(
	'anfreeman@acme.com',
	'temp1'
);
INSERT into Users
Values(
	'erfowler@acme.com',
	'temp1'
);
INSERT into Users
Values(
	'pefitzpatrick@acme.com',
	'temp1'
);
INSERT into Users
Values(
	'rophillips@acme.com',
	'temp1'
);

INSERT into Users
Values(
	'jagloss@acme.com',
	'temp1'
);

INSERT into Users
Values(
	'rorichmond@acme.com',
	'temp1'
);
INSERT into Employees
Values(
	950932130,
	'lacohen@acme.com',
	'Larry Cohen',
	'316-978-5494',
	'1979 Henry Street, Raleigh, NC 27606',
	'11000',
	'month',
	Date '2016-08-15',
	'manager',
	'S0001'
);
INSERT into Employees
Values(
	634622236,
	'wimartin@acme.com',
	'Willis Martin',
	'213-988-2011',
	'465 Aviation Way, Raleigh, NC 27601',
	'8000',
	'month',
	Date '2017-12-04',
	'receptionist',
	'S0001'
);
INSERT into Employees
Values(
	557279280,
	'jagloss@acme.com',
	'Jacob Gloss',
	'413-335-9523',
	'2014 Leverton Cove Road, Raleigh, NC 27560',
	'30',
	'hour',
	Date '2018-07-29',
	'mechanic',
	'S0001'
);
INSERT into Employees
Values(
	183683346,
	'anfreeman@acme.com',
	'Anthony Freeman',
	'563-496-7912',
	'1188 Summit Street, Raleigh, NC 27627',
	'40',
	'hour',
	Date '2015-02-09',
	'mechanic',
	'S0001'
);
INSERT into Employees
Values(
	557279281,
	'erfowler@acme.com',
	'Eric Fowler',
	'760-457-9846',
	'1114 Fincham Road, Raleigh, NC 27545',
	'35',
	'hour',
	Date '2016-05-01',
	'mechanic',
	'S0001'
);
INSERT into Employees
Values(
	557279282,
	'rorichmond@acme.com',
	'Roland Richmond',
	'829843373',
	'1951 Little Acres Lane, Raleigh, NC 27513',
	'30',
	'hour',
	Date '2017-12-28',
	'mechanic',
	'S0001'
);
INSERT into Employees
Values(
	557279283,
	'pefitzpatrick@acme.com',
	'Peter Fitzpatrick',
	'315-485-1152',
	'4738 Buckhannan Avenue, Raleigh, NC 27625',
	'34',
	'hour',
	Date '2017-04-12',
	'mechanic',
	'S0001'
);
INSERT into Employees
Values(
	291056276,
	'rophillips@acme.com',
	'Roderick Phillips',
	'901-777-0492',
	'1133 Burton Avenue, Charlotte, NC 28201',
	'12000',
	'month',
	Date '2017-04-15',
	'manager',
	'S0002'
);

INSERT into Employees
Values(
	911639633,
	'deholmes@acme.com',
	'Dena Holmes',
	'972-353-3691',
	'1382 Whispering Pines Circle, Charlotte, NC 28205',
	'9000',
	'month',
	Date '2010-01-04',
	'receptionist',
	'S0002'
);
INSERT into Employees
Values(
	590424694,
	'duesparza@acme.com',
	'Dustin Esparza',
	'956-444-0948',
	'3510 Hemlock Lane, Charlotte, NC 28202',
	'35',
	'hour',
	Date '2017-01-26',
	'mechanic',
	'S0002'
);
INSERT into Employees
Values(
	401671897,
	'chpudilo@acme.com',
	'Charles Pudilo',
	'641-752-9403',
	'196 Park Boulevard, Charlotte, NC 28222',
	'40',
	'hour',
	Date '2016-07-06',
	'mechanic',
	'S0002'
);

INSERT into Employees
Values(
	310773348,
	'jarivera@acme.com',
	'James Rivera',
	'903-967-1809',
	'908 Alpha Avenue, Charlotte, NC 28130',
	'40',
	'hour',
	Date '2013-10-29',
	'mechanic',
	'S0002'
);
INSERT into Employees
Values(
	983204784,
	'wimorton@acme.com',
	'Willis Morton',
	'757-886-6330',
	'404 Tenmile, Charlotte, NC 28134',
	'30',
	'hour',
	Date '2018-10-13',
	'mechanic',
	'S0002'
);
INSERT into Employees
Values(
	187658163,
	'rihenderson@acme.com',
	'Rickie Henderson',
	'931-539-1294',
	'1963 Chenoweth Drive, Charlotte, NC 28228',
	'30',
	'hour',
	Date '2017-03-29',
	'mechanic',
	'S0002'
);

--#Inserting into Customer and their Vehicles [eg for Ethan Hunt]
INSERT into Users
Values(
	'ethanhunt@gmail.com',
	'temp1'
);

INSERT into Users
Values(
	'jarvis@gmail.com',
	'temp1'
);

INSERT into Users
Values(
	'lovestory@gmail.com',
	'temp1'
);

INSERT into Users
Values(
	'venus@gmail.com',
	'temp1'
);

INSERT into Customers
Values(
	'1001',
	'ethanhunt@gmail.com',
	'Tom Cruise',
	'1234567890',
	'203, Park St, Raleigh, NC - 27603',
	'S0001'
);
INSERT into Customers
Values(
	'1002',
	'jarvis@gmail.com',
	'Robert Downey Jr.',
	'9989877791',
	'12-A, High St, Raleigh, NC - 27605',
	'S0001'
);
INSERT into Customers
Values(
	'1003',
	'lovestory@gmail.com',
	'Taylor Swift',
	'8179827199',
	'2A, 3rd Ave, Charlotte, NC - 28134',
	'S0002'
);
INSERT into Customers
Values(
	'1004',
	'venus@gmail.com',
	'Serena Williams',
	'8714791879',
	'90, Gorman St, Charlotte, NC - 28201',
	'S0002'
);

INSERT into Make
Values(
    'Toyota'
);

INSERT into Make
Values(
    'Honda'
);

INSERT into Make
Values(
    'Nissan'
);

INSERT into Vehicles
Values(
	1,
   'Toyota',
   'Corolla'
);
INSERT into Vehicles
Values(
	2,
	'Toyota',
	'Prius'
);
INSERT into Vehicles
Values(
	3,
	'Honda',
	'Civic'
);
INSERT into Vehicles
Values(
	4,
	'Honda',
	'Accord'
);
INSERT into Vehicles
Values(
	5,
	'Nissan',
	'Altima'
);
INSERT into Vehicles
Values(
	6,
	'Nissan',
	'Rogue'
);

INSERT into Owns
Values(
    'XYZ-5643',
  	90452,
  	Date '2018-9-10',
    Date '2009-12-24',
    3,
    'ethanhunt@gmail.com',
    '2009'
);
INSERT into Owns
Values(
    'AHS-3132',
  	65452,
  	Date '2018-8-6',
    Date '2011-01-02',
    2,
    'ethanhunt@gmail.com',
    '2007'
);
INSERT into Owns
Values(
    'IRM-1212',
  	210452,
  	Date '2018-02-11',
    Date '2002-09-07',
    5,
    'jarvis@gmail.com',
    '2001'
);
INSERT into Owns
Values(
    'TSW-3462',
  	NULL,
  	NULL,
    Date '2015-12-09',
    4,
    'lovestory@gmail.com',
    '2015'
);
INSERT into Owns
Values(
    'DEL-8888',
  	31209,
  	Date '2018-02-11',
    Date '2016-05-11',
    6,
    'lovestory@gmail.com',
    '2014'
);
INSERT into Owns
Values(
    'P11-212A',
  	60452,
  	Date '2017-09-01',
    Date '2010-04-14',
    4,
    'venus@gmail.com',
    '2009'
);
INSERT into Owns
Values(
    'WIM-BLE5',
  	19876,
  	Date '2016-11-11',
    Date '2013-03-01',
    2,
    'venus@gmail.com',
    '2013'
);

INSERT into Parts
Values(
    1,
    'Air Filter'
);
INSERT into Parts
Values(
    2,
    'Axel Rod'
);
INSERT into Parts
Values(
    3,
    'Battery'
);
INSERT into Parts
Values(
    4,
    'Brake Fluid'
);
INSERT into Parts
Values(
    5,
    'Brake Shoes'
);
INSERT into Parts
Values(
    6,
    'Camshaft'
);
INSERT into Parts
Values(
    7,
    'Catalytic converter'
);
INSERT into Parts
Values(
    8,
    'Coolant'
);
INSERT into Parts
Values(
    9,
    'Drive belt'
);
INSERT into Parts
Values(
    10,
    'Engine oil'
);
INSERT into Parts
Values(
    11,
    'Gears'
);
INSERT into Parts
Values(
    12,
    'Light assembly'
);
INSERT into Parts
Values(
    13,
    'Oil Filter'
);
INSERT into Parts
Values(
    14,
    'Piston'
);
INSERT into Parts
Values(
    15,
    'Power Steering Fluid'
);
INSERT into Parts
Values(
    16,
    'Spark plug'
);
INSERT into Parts
Values(
    17,
    'Suspension fluid'
);
INSERT into Parts
Values(
    18,
    'Valve'
);
INSERT into Parts
Values(
    19,
    'Wiper Fluid'
);

INSERT into Parts_to_make
Values(
  1,
  'Toyota',
  1,
  11,
  NULL
);
INSERT into Parts_to_make
Values(
  2,
  'Toyota',
  2,
  123,
  2
);
INSERT into Parts_to_make
Values(
  3,
  'Toyota',
  3,
  63,
  6
);
INSERT into Parts_to_make
Values(
  4,
  'Toyota',
  4,
  24,
  NULL
);
INSERT into Parts_to_make
Values(
  5,
  'Toyota',
  5,
  62,
  2
);
INSERT into Parts_to_make
Values(
  6,
  'Toyota',
  6,
  1428,
  3
);
INSERT into Parts_to_make
Values(
  7,
  'Toyota',
  7,
  801,
  1
);
INSERT into Parts_to_make
Values(
  8,
  'Toyota',
  8,
  63,
  NULL
);
INSERT into Parts_to_make
Values(
  9,
  'Toyota',
  9,
  528,
  1
);
INSERT into Parts_to_make
Values(
  10,
  'Toyota',
  10,
  63,
  NULL
);
INSERT into Parts_to_make
Values(
  11,
  'Toyota',
  11,
  523,
  1
);
INSERT into Parts_to_make
Values(
  12,
  'Toyota',
  12,
  617,
  2
);
INSERT into Parts_to_make
Values(
  13,
  'Toyota',
  13,
  36,
  NULL
);
INSERT into Parts_to_make
Values(
  14,
  'Toyota',
  14,
  1256,
  1
);
INSERT into Parts_to_make
Values(
  15,
  'Toyota',
  15,
  17,
  NULL
);
INSERT into Parts_to_make
Values(
  16,
  'Toyota',
  16,
  64,
  2
);
INSERT into Parts_to_make
Values(
  17,
  'Toyota',
  17,
  70,
  NULL
);
INSERT into Parts_to_make
Values(
  18,
  'Toyota',
  18,
  1338,
  1
);
INSERT into Parts_to_make
Values(
  19,
  'Toyota',
  19,
  28,
  NULL
);

INSERT into Parts_to_make
Values(
  20,
  'Honda',
  1,
  59,
  NULL
);
INSERT into Parts_to_make
Values(
  21,
  'Honda',
  2,
  141,
  2
);
INSERT into Parts_to_make
Values(
  22,
  'Honda',
  3,
  79,
  3
);
INSERT into Parts_to_make
Values(
  23,
  'Honda',
  4,
  75,
  NULL
);
INSERT into Parts_to_make
Values(
  24,
  'Honda',
  5,
  41,
  3
);
INSERT into Parts_to_make
Values(
  25,
  'Honda',
  6,
  511,
  2
);
INSERT into Parts_to_make
Values(
  26,
  'Honda',
  7,
  716,
  2
);
INSERT into Parts_to_make
Values(
  27,
  'Honda',
  8,
  10,
  NULL
);
INSERT into Parts_to_make
Values(
  28,
  'Honda',
  9,
  1443,
  1
);
INSERT into Parts_to_make
Values(
  29,
  'Honda',
  10,
  27,
  NULL
);
INSERT into Parts_to_make
Values(
  30,
  'Honda',
  11,
  1344,
  3
);
INSERT into Parts_to_make
Values(
  31,
  'Honda',
  12,
  1342,
  2
);
INSERT into Parts_to_make
Values(
  32,
  'Honda',
  13,
  42,
  NULL
);
INSERT into Parts_to_make
Values(
  33,
  'Honda',
  14,
  1145,
  1
);
INSERT into Parts_to_make
Values(
  34,
  'Honda',
  15,
  24,
  NULL
);
INSERT into Parts_to_make
Values(
  35,
  'Honda',
  16,
  50,
  2
);
INSERT into Parts_to_make
Values(
  36,
  'Honda',
  17,
  77,
  NULL
);
INSERT into Parts_to_make
Values(
  37,
  'Honda',
  18,
  1261,
  2
);
INSERT into Parts_to_make
Values(
  38,
  'Honda',
  19,
  56,
  NULL
);

INSERT into Parts_to_make
Values(
  39,
  'Nissan',
  1,
  61,
  NULL
);
INSERT into Parts_to_make
Values(
  40,
  'Nissan',
  2,
  241,
  3
);
INSERT into Parts_to_make
Values(
  41,
  'Nissan',
  3,
  14,
  3
);
INSERT into Parts_to_make
Values(
  42,
  'Nissan',
  4,
  16,
  NULL
);
INSERT into Parts_to_make
Values(
  43,
  'Nissan',
  5,
  47,
  1
);
INSERT into Parts_to_make
Values(
  44,
  'Nissan',
  6,
  1295,
  2
);
INSERT into Parts_to_make
Values(
  45,
  'Nissan',
  7,
  589,
  1
);
INSERT into Parts_to_make
Values(
  46,
  'Nissan',
  8,
  39,
  NULL
);
INSERT into Parts_to_make
Values(
  47,
  'Nissan',
  9,
  1084,
  3
);
INSERT into Parts_to_make
Values(
  48,
  'Nissan',
  10,
  14,
  NULL
);
INSERT into Parts_to_make
Values(
  49,
  'Nissan',
  11,
  1176,
  3
);
INSERT into Parts_to_make
Values(
  50,
  'Nissan',
  12,
  1367,
  2
);
INSERT into Parts_to_make
Values(
  51,
  'Nissan',
  13,
  61,
  NULL
);
INSERT into Parts_to_make
Values(
  52,
  'Nissan',
  14,
  1341,
  3
);
INSERT into Parts_to_make
Values(
  53,
  'Nissan',
  15,
  20,
  NULL
);
INSERT into Parts_to_make
Values(
  54,
  'Nissan',
  16,
  11,
  1
);
INSERT into Parts_to_make
Values(
  55,
  'Nissan',
  17,
  32,
  NULL
);
INSERT into Parts_to_make
Values(
  56,
  'Nissan',
  18,
  1013,
  1
);
INSERT into Parts_to_make
Values(
  57,
  'Nissan',
  19,
  31,
  NULL
);

INSERT into Distributor
Values(
  'D0001',
  'D1'
);
INSERT into Distributor
Values(
  'D0002',
  'D2'
);

INSERT into Supplies
Values(
  1,
  NULL,
  1,
  'D0001'
);
INSERT into Supplies
Values(
  2,
  5,
  2,
  'D0001'
);
INSERT into Supplies
Values(
  3,
  4,
  3,
  'D0001'
);
INSERT into Supplies
Values(
  4,
  NULL,
  4,
  'D0001'
);
INSERT into Supplies
Values(
  5,
  NULL,
  5,
  'D0001'
);
INSERT into Supplies
Values(
  6,
  4,
  6,
  'D0001'
);
INSERT into Supplies
Values(
  7,
  NULL,
  7,
  'D0001'
);
INSERT into Supplies
Values(
  8,
  NULL,
  8,
  'D0001'
);
INSERT into Supplies
Values(
  9,
  NULL,
  9,
  'D0001'
);
INSERT into Supplies
Values(
  10,
  2,
  10,
  'D0001'
);
INSERT into Supplies
Values(
  11,
  5,
  11,
  'D0001'
);
INSERT into Supplies
Values(
  12,
  3,
  12,
  'D0001'
);
INSERT into Supplies
Values(
  13,
  4,
  13,
  'D0001'
);
INSERT into Supplies
Values(
  14,
  2,
  14,
  'D0001'
);
INSERT into Supplies
Values(
  15,
  5,
  15,
  'D0001'
);
INSERT into Supplies
Values(
  16,
  NULL,
  16,
  'D0001'
);
INSERT into Supplies
Values(
  17,
  NULL,
  17,
  'D0001'
);
INSERT into Supplies
Values(
  18,
  3,
  18,
  'D0001'
);
INSERT into Supplies
Values(
  19,
  NULL,
  19,
  'D0001'
);

INSERT into Supplies
Values(
  20,
  NULL,
  20,
  'D0001'
);
INSERT into Supplies
Values(
  21,
  5,
  22,
  'D0001'
);
INSERT into Supplies
Values(
  22,
  4,
  22,
  'D0001'
);
INSERT into Supplies
Values(
  23,
  NULL,
  23,
  'D0001'
);
INSERT into Supplies
Values(
  24,
  NULL,
  24,
  'D0001'
);
INSERT into Supplies
Values(
  25,
  4,
  25,
  'D0001'
);
INSERT into Supplies
Values(
  26,
  NULL,
  26,
  'D0001'
);
INSERT into Supplies
Values(
  27,
  NULL,
  27,
  'D0001'
);
INSERT into Supplies
Values(
  28,
  NULL,
  28,
  'D0001'
);
INSERT into Supplies
Values(
  29,
  2,
  29,
  'D0001'
);
INSERT into Supplies
Values(
  30,
  5,
  30,
  'D0001'
);
INSERT into Supplies
Values(
  31,
  3,
  31,
  'D0001'
);
INSERT into Supplies
Values(
  32,
  4,
  32,
  'D0001'
);
INSERT into Supplies
Values(
  33,
  2,
  33,
  'D0001'
);
INSERT into Supplies
Values(
  34,
  5,
  34,
  'D0001'
);
INSERT into Supplies
Values(
  35,
  NULL,
  35,
  'D0001'
);
INSERT into Supplies
Values(
  36,
  NULL,
  36,
  'D0001'
);
INSERT into Supplies
Values(
  37,
  3,
  37,
  'D0001'
);
INSERT into Supplies
Values(
  38,
  NULL,
  38,
  'D0001'
);

INSERT into Supplies
Values(
  39,
  NULL,
  39,
  'D0001'
);
INSERT into Supplies
Values(
  40,
  5,
  40,
  'D0001'
);
INSERT into Supplies
Values(
  41,
  4,
  41,
  'D0001'
);
INSERT into Supplies
Values(
  42,
  NULL,
  42,
  'D0001'
);
INSERT into Supplies
Values(
  43,
  NULL,
  43,
  'D0001'
);
INSERT into Supplies
Values(
  44,
  4,
  44,
  'D0001'
);
INSERT into Supplies
Values(
  45,
  NULL,
  45,
  'D0001'
);
INSERT into Supplies
Values(
  46,
  NULL,
  46,
  'D0001'
);
INSERT into Supplies
Values(
  47,
  NULL,
  47,
  'D0001'
);
INSERT into Supplies
Values(
  48,
  2,
  48,
  'D0001'
);
INSERT into Supplies
Values(
  49,
  5,
  49,
  'D0001'
);
INSERT into Supplies
Values(
  50,
  3,
  50,
  'D0001'
);
INSERT into Supplies
Values(
  51,
  4,
  51,
  'D0001'
);
INSERT into Supplies
Values(
  52,
  2,
  52,
  'D0001'
);
INSERT into Supplies
Values(
  53,
  5,
  53,
  'D0001'
);
INSERT into Supplies
Values(
  54,
  NULL,
  54,
  'D0001'
);
INSERT into Supplies
Values(
  55,
  NULL,
  55,
  'D0001'
);
INSERT into Supplies
Values(
  56,
  3,
  56,
  'D0001'
);
INSERT into Supplies
Values(
  57,
  NULL,
  57,
  'D0001'
);

INSERT into Supplies
Values(
  58,
  3,
  1,
  'D0002'
);
INSERT into Supplies
Values(
  59,
  NULL,
  2,
  'D0002'
);
INSERT into Supplies
Values(
  60,
  NULL,
  3,
  'D0002'
);
INSERT into Supplies
Values(
  61,
  4,
  4,
  'D0002'
);
INSERT into Supplies
Values(
  62,
  5,
  5,
  'D0002'
);
INSERT into Supplies
Values(
  63,
  NULL,
  6,
  'D0002'
);
INSERT into Supplies
Values(
  64,
  3,
  7,
  'D0002'
);
INSERT into Supplies
Values(
  65,
  4,
  8,
  'D0002'
);
INSERT into Supplies
Values(
  66,
  2,
  9,
  'D0002'
);
INSERT into Supplies
Values(
  67,
  NULL,
  10,
  'D0002'
);
INSERT into Supplies
Values(
  68,
  NULL,
  11,
  'D0002'
);
INSERT into Supplies
Values(
  69,
  NULL,
  12,
  'D0002'
);
INSERT into Supplies
Values(
  70,
  NULL,
  13,
  'D0002'
);
INSERT into Supplies
Values(
  71,
  NULL,
  14,
  'D0002'
);
INSERT into Supplies
Values(
  72,
  NULL,
  15,
  'D0002'
);
INSERT into Supplies
Values(
  73,
  5,
  16,
  'D0002'
);
INSERT into Supplies
Values(
  74,
  3,
  17,
  'D0002'
);
INSERT into Supplies
Values(
  75,
  NULL,
  18,
  'D0002'
);
INSERT into Supplies
Values(
  76,
  3,
  19,
  'D0002'
);

INSERT into Supplies
Values(
  77,
  3,
  20,
  'D0002'
);
INSERT into Supplies
Values(
  78,
  NULL,
  21,
  'D0002'
);
INSERT into Supplies
Values(
  79,
  NULL,
  22,
  'D0002'
);
INSERT into Supplies
Values(
  80,
  4,
  23,
  'D0002'
);
INSERT into Supplies
Values(
  81,
  5,
  24,
  'D0002'
);
INSERT into Supplies
Values(
  82,
  NULL,
  25,
  'D0002'
);
INSERT into Supplies
Values(
  83,
  3,
  26,
  'D0002'
);
INSERT into Supplies
Values(
  84,
  4,
  27,
  'D0002'
);
INSERT into Supplies
Values(
  85,
  2,
  28,
  'D0002'
);
INSERT into Supplies
Values(
  86,
  NULL,
  29,
  'D0002'
);
INSERT into Supplies
Values(
  87,
  NULL,
  30,
  'D0002'
);
INSERT into Supplies
Values(
  88,
  NULL,
  31,
  'D0002'
);
INSERT into Supplies
Values(
  89,
  NULL,
  32,
  'D0002'
);
INSERT into Supplies
Values(
  90,
  NULL,
  33,
  'D0002'
);
INSERT into Supplies
Values(
  91,
  NULL,
  34,
  'D0002'
);
INSERT into Supplies
Values(
  92,
  5,
  35,
  'D0002'
);
INSERT into Supplies
Values(
  93,
  3,
  36,
  'D0002'
);
INSERT into Supplies
Values(
  94,
  NULL,
  37,
  'D0002'
);
INSERT into Supplies
Values(
  95,
  3,
  38,
  'D0002'
);

INSERT into Supplies
Values(
  96,
  3,
  39,
  'D0002'
);
INSERT into Supplies
Values(
  97,
  NULL,
  40,
  'D0002'
);
INSERT into Supplies
Values(
  98,
  NULL,
  41,
  'D0002'
);
INSERT into Supplies
Values(
  99,
  4,
  42,
  'D0002'
);
INSERT into Supplies
Values(
  100,
  5,
  43,
  'D0002'
);
INSERT into Supplies
Values(
  101,
  NULL,
  44,
  'D0002'
);
INSERT into Supplies
Values(
  102,
  3,
  45,
  'D0002'
);
INSERT into Supplies
Values(
  103,
  4,
  46,
  'D0002'
);
INSERT into Supplies
Values(
  104,
  2,
  47,
  'D0002'
);
INSERT into Supplies
Values(
  105,
  NULL,
  48,
  'D0002'
);
INSERT into Supplies
Values(
  106,
  NULL,
  49,
  'D0002'
);
INSERT into Supplies
Values(
  107,
  NULL,
  50,
  'D0002'
);
INSERT into Supplies
Values(
  108,
  NULL,
  51,
  'D0002'
);
INSERT into Supplies
Values(
  109,
  NULL,
  52,
  'D0002'
);
INSERT into Supplies
Values(
  110,
  NULL,
  53,
  'D0002'
);
INSERT into Supplies
Values(
  111,
  5,
  54,
  'D0002'
);
INSERT into Supplies
Values(
  112,
  3,
  55,
  'D0002'
);
INSERT into Supplies
Values(
  113,
  NULL,
  56,
  'D0002'
);
INSERT into Supplies
Values(
  114,
  3,
  57,
  'D0002'
);

INSERT into Inventory
Values(
  1,
  'S0001',
  1,
  13,
  2,
  5
);
INSERT into Inventory
Values(
  2,
  'S0001',
  2,
  18,
  5,
  7
);
INSERT into Inventory
Values(
  3,
  'S0001',
  3,
  10,
  2,
  5
);
INSERT into Inventory
Values(
  4,
  'S0001',
  4,
  4,
  4,
  6
);
INSERT into Inventory
Values(
  5,
  'S0001',
  5,
  18,
  4,
  3
);
INSERT into Inventory
Values(
  6,
  'S0001',
  6,
  12,
  2,
  5
);
INSERT into Inventory
Values(
  7,
  'S0001',
  7,
  11,
  1,
  5
);
INSERT into Inventory
Values(
  8,
  'S0001',
  8,
  13,
  2,
  4
);
INSERT into Inventory
Values(
  9,
  'S0001',
  9,
  15,
  3,
  5
);
INSERT into Inventory
Values(
  10,
  'S0001',
  10,
  5,
  5,
  5
);
INSERT into Inventory
Values(
  11,
  'S0001',
  11,
  8,
  3,
  5
);
INSERT into Inventory
Values(
  12,
  'S0001',
  12,
  2,
  1,
  8
);
INSERT into Inventory
Values(
  13,
  'S0001',
  13,
  1,
  1,
  4
);
INSERT into Inventory
Values(
  14,
  'S0001',
  14,
  15,
  4,
  2
);
INSERT into Inventory
Values(
  15,
  'S0001',
  15,
  2,
  1,
  5
);
INSERT into Inventory
Values(
  16,
  'S0001',
  16,
  15,
  4,
  5
);
INSERT into Inventory
Values(
  17,
  'S0001',
  17,
  3,
  1,
  5
);
INSERT into Inventory
Values(
  18,
  'S0001',
  18,
  12,
  7,
  5
);
INSERT into Inventory
Values(
  19,
  'S0001',
  19,
  12,
  7,
  5
);

INSERT into Inventory
Values(
  20,
  'S0001',
  20,
  43,
  20,
  5
);
INSERT into Inventory
Values(
  21,
  'S0001',
  21,
  8,
  5,
  7
);
INSERT into Inventory
Values(
  22,
  'S0001',
  22,
  20,
  20,
  5
);
INSERT into Inventory
Values(
  23,
  'S0001',
  23,
  14,
  4,
  6
);
INSERT into Inventory
Values(
  24,
  'S0001',
  24,
  8,
  4,
  3
);
INSERT into Inventory
Values(
  25,
  'S0001',
  25,
  22,
  20,
  5
);
INSERT into Inventory
Values(
  26,
  'S0001',
  26,
  31,
  10,
  5
);
INSERT into Inventory
Values(
  27,
  'S0001',
  27,
  23,
  23,
  4
);
INSERT into Inventory
Values(
  28,
  'S0001',
  28,
  35,
  30,
  5
);
INSERT into Inventory
Values(
  29,
  'S0001',
  29,
  15,
  5,
  5
);
INSERT into Inventory
Values(
  30,
  'S0001',
  30,
  18,
  3,
  5
);
INSERT into Inventory
Values(
  31,
  'S0001',
  31,
  12,
  10,
  8
);
INSERT into Inventory
Values(
  32,
  'S0001',
  32,
  11,
  4,
  4
);
INSERT into Inventory
Values(
  33,
  'S0001',
  33,
  55,
  48,
  2
);
INSERT into Inventory
Values(
  34,
  'S0001',
  34,
  12,
  7,
  5
);
INSERT into Inventory
Values(
  35,
  'S0001',
  35,
  42,
  42,
  5
);
INSERT into Inventory
Values(
  36,
  'S0001',
  36,
  13,
  11,
  5
);
INSERT into Inventory
Values(
  37,
  'S0001',
  37,
  12,
  7,
  5
);
INSERT into Inventory
Values(
  38,
  'S0001',
  38,
  12,
  5,
  5
);

INSERT into Inventory
Values(
  39,
  'S0001',
  39,
  33,
  20,
  5
);
INSERT into Inventory
Values(
  40,
  'S0001',
  40,
  38,
  5,
  7
);
INSERT into Inventory
Values(
  41,
  'S0001',
  41,
  30,
  20,
  5
);
INSERT into Inventory
Values(
  42,
  'S0001',
  42,
  34,
  4,
  6
);
INSERT into Inventory
Values(
  43,
  'S0001',
  43,
  38,
  4,
  3
);
INSERT into Inventory
Values(
  44,
  'S0001',
  44,
  32,
  20,
  5
);
INSERT into Inventory
Values(
  45,
  'S0001',
  45,
  31,
  10,
  5
);
INSERT into Inventory
Values(
  46,
  'S0001',
  46,
  33,
  23,
  4
);
INSERT into Inventory
Values(
  47,
  'S0001',
  47,
  35,
  30,
  5
);
INSERT into Inventory
Values(
  48,
  'S0001',
  48,
  35,
  5,
  5
);
INSERT into Inventory
Values(
  49,
  'S0001',
  49,
  38,
  3,
  5
);
INSERT into Inventory
Values(
  50,
  'S0001',
  50,
  32,
  10,
  8
);
INSERT into Inventory
Values(
  51,
  'S0001',
  51,
  31,
  4,
  4
);
INSERT into Inventory
Values(
  52,
  'S0001',
  52,
  35,
  18,
  2
);
INSERT into Inventory
Values(
  53,
  'S0001',
  53,
  32,
  7,
  5
);
INSERT into Inventory
Values(
  54,
  'S0001',
  54,
  35,
  12,
  5
);
INSERT into Inventory
Values(
  55,
  'S0001',
  55,
  33,
  11,
  5
);
INSERT into Inventory
Values(
  56,
  'S0001',
  56,
  32,
  7,
  5
);
INSERT into Inventory
Values(
  57,
  'S0001',
  57,
  12,
  5,
  5
);

INSERT into Inventory
Values(
  58,
  'S0002',
  1,
  26,
  5,
  6
);
INSERT into Inventory
Values(
  59,
  'S0002',
  2,
  27,
  6,
  10
);
INSERT into Inventory
Values(
  60,
  'S0002',
  3,
  24,
  2,
  3
);
INSERT into Inventory
Values(
  61,
  'S0002',
  4,
  25,
  3,
  3
);
INSERT into Inventory
Values(
  62,
  'S0002',
  5,
  20,
  3,
  5
);
INSERT into Inventory
Values(
  63,
  'S0002',
  6,
  22,
  2,
  6
);
INSERT into Inventory
Values(
  64,
  'S0002',
  7,
  29,
  4,
  5
);
INSERT into Inventory
Values(
  65,
  'S0002',
  8,
  21,
  2,
  4
);
INSERT into Inventory
Values(
  66,
  'S0002',
  9,
  20,
  3,
  4
);
INSERT into Inventory
Values(
  67,
  'S0002',
  10,
  26,
  20,
  5
);
INSERT into Inventory
Values(
  68,
  'S0002',
  11,
  20,
  7,
  5
);
INSERT into Inventory
Values(
  69,
  'S0002',
  12,
  28,
  6,
  3
);
INSERT into Inventory
Values(
  70,
  'S0002',
  13,
  21,
  4,
  5
);
INSERT into Inventory
Values(
  71,
  'S0002',
  14,
  21,
  3,
  5
);
INSERT into Inventory
Values(
  72,
  'S0002',
  15,
  27,
  6,
  4
);
INSERT into Inventory
Values(
  73,
  'S0002',
  16,
  20,
  2,
  4
);
INSERT into Inventory
Values(
  74,
  'S0002',
  17,
  25,
  6,
  6
);
INSERT into Inventory
Values(
  75,
  'S0002',
  18,
  11,
  3,
  6
);
INSERT into Inventory
Values(
  76,
  'S0002',
  19,
  16,
  13,
  5
);

INSERT into Inventory
Values(
  77,
  'S0002',
  20,
  46,
  35,
  6
);
INSERT into Inventory
Values(
  78,
  'S0002',
  21,
  7,
  6,
  10
);
INSERT into Inventory
Values(
  79,
  'S0002',
  22,
  64,
  52,
  3
);
INSERT into Inventory
Values(
  80,
  'S0002',
  23,
  15,
  3,
  3
);
INSERT into Inventory
Values(
  81,
  'S0002',
  24,
  20,
  3,
  5
);
INSERT into Inventory
Values(
  82,
  'S0002',
  25,
  42,
  42,
  6
);
INSERT into Inventory
Values(
  83,
  'S0002',
  26,
  29,
  24,
  5
);
INSERT into Inventory
Values(
  84,
  'S0002',
  27,
  21,
  12,
  4
);
INSERT into Inventory
Values(
  85,
  'S0002',
  28,
  30,
  23,
  4
);
INSERT into Inventory
Values(
  86,
  'S0002',
  29,
  26,
  10,
  5
);
INSERT into Inventory
Values(
  87,
  'S0002',
  30,
  70,
  7,
  5
);
INSERT into Inventory
Values(
  88,
  'S0002',
  31,
  8,
  6,
  3
);
INSERT into Inventory
Values(
  89,
  'S0002',
  32,
  31,
  24,
  5
);
INSERT into Inventory
Values(
  90,
  'S0002',
  33,
  81,
  73,
  5
);
INSERT into Inventory
Values(
  91,
  'S0002',
  34,
  17,
  6,
  4
);
INSERT into Inventory
Values(
  92,
  'S0002',
  35,
  50,
  32,
  4
);
INSERT into Inventory
Values(
  93,
  'S0002',
  36,
  15,
  6,
  6
);
INSERT into Inventory
Values(
  94,
  'S0002',
  37,
  11,
  3,
  6
);
INSERT into Inventory
Values(
  95,
  'S0002',
  38,
  16,
  13,
  5
);

INSERT into Inventory
Values(
  96,
  'S0002',
  39,
  16,
  5,
  6
);
INSERT into Inventory
Values(
  97,
  'S0002',
  40,
  17,
  6,
  10
);
INSERT into Inventory
Values(
  98,
  'S0002',
  41,
  14,
  5,
  3
);
INSERT into Inventory
Values(
  99,
  'S0002',
  42,
  15,
  3,
  3
);
INSERT into Inventory
Values(
  100,
  'S0002',
  43,
  10,
  3,
  5
);
INSERT into Inventory
Values(
  101,
  'S0002',
  44,
  12,
  4,
  6
);
INSERT into Inventory
Values(
  102,
  'S0002',
  45,
  19,
  4,
  5
);
INSERT into Inventory
Values(
  103,
  'S0002',
  46,
  11,
  2,
  4
);
INSERT into Inventory
Values(
  104,
  'S0002',
  47,
  10,
  3,
  4
);
INSERT into Inventory
Values(
  105,
  'S0002',
  48,
  16,
  10,
  5
);
INSERT into Inventory
Values(
  106,
  'S0002',
  49,
  10,
  7,
  5
);
INSERT into Inventory
Values(
  107,
  'S0002',
  50,
  18,
  6,
  3
);
INSERT into Inventory
Values(
  108,
  'S0002',
  51,
  11,
  4,
  5
);
INSERT into Inventory
Values(
  109,
  'S0002',
  52,
  11,
  7,
  5
);
INSERT into Inventory
Values(
  110,
  'S0002',
  53,
  17,
  6,
  4
);
INSERT into Inventory
Values(
  111,
  'S0002',
  54,
  10,
  2,
  4
);
INSERT into Inventory
Values(
  112,
  'S0002',
  55,
  15,
  6,
  6
);
INSERT into Inventory
Values(
  113,
  'S0002',
  56,
  11,
  3,
  6
);
INSERT into Inventory
Values(
  114,
  'S0002',
  57,
  16,
  13,
  5
);
---------------------------------------
INSERT into Charge_type
Values(
   'Low',
   '50'
   );

INSERT into Charge_type
Values(
   'High',
   '65'
   );

INSERT into Service
Values(
	1,
   'Air filter change',
   'Low',
   0.25
);

INSERT into Service
Values(
	2,
   'Battery replacement',
   'Low',
   0.25
);

INSERT into Service
Values(
	3,
   'Brake check',
   'Low',
   0.25
);

INSERT into Service
Values(
	4,
   'Brake repair',
   'Low',
   0.5
);

INSERT into Service
Values(
	5,
   'Camshaft replacement',
   'High',
   1.0
);

INSERT into Service
Values(
	6,
   'Catalytic convertor replacement',
   'High',
   1.0
);

INSERT into Service
Values(
	7,
   'Coolant recycle',
   'Low',
   0.25
);

INSERT into Service
Values(
	8,
   'Drive belt replacement',
   'High',
   1.0
);

INSERT into Service
Values(
	9,
   'Engine oil change',
   'Low',
   0.25
);

INSERT into Service
Values(
	10,
   'Gearbox repair',
   'High',
   1.0
);

INSERT into Service
Values(
	11,
   'Headlights replacement',
   'Low',
   0.5
);

INSERT into Service
Values(
	12,
   'Oil filter change',
   'Low',
   0.25
);

INSERT into Service
Values(
	13,
   'Piston replacement',
   'High',
   1.0
);

INSERT into Service
Values(
	14,
   'Power steering check',
   'Low',
   0.25
);
INSERT into Service
Values(
	15,
   'Spark plugs replacement',
   'Low',
   0.25
);

INSERT into Service
Values(
	16,
   'Suspension check',
   'Low',
   0.25
);

INSERT into Service
Values(
	17,
   'Tail lights replacement',
   'Low',
   0.5
);

INSERT into Service
Values(
	18,
   'Turn lights replacement',
   'Low',
   0.5
);

INSERT into Service
Values(
	19,
   'Valve replacement',
   'High',
   1.0
);

INSERT into Service
Values(
	20,
   'Wheel alignment',
   'High',
   1.0
);

INSERT into Service
Values(
	21,
   'Wiper check',
   'Low',
   0.25
);

INSERT into Involves
Values  (1,
   1,
   1,
   1,
   1
   );

INSERT into Involves
Values  (2,
   1,
   1,
   2,
   1
   );
INSERT into Involves
Values  (3,
   1,
   1,
   3,
   1
   );
INSERT into Involves
Values  (4,
   1,
   1,
   4,
   2
   );
INSERT into Involves
Values  (5,
   1,
   1,
   5,
   1
   );
INSERT into Involves
Values  (6,
   1,
   1,
   6,
   3
   );

INSERT into Involves
Values  (7,
   2,
   3,
   1,
   1
   );

INSERT into Involves
Values  (8,
   2,
   3,
   2,
   1
   );
INSERT into Involves
Values  (9,
   2,
   3,
   3,
   1
   );
INSERT into Involves
Values  (10,
   2,
   3,
   4,
   1
   );
INSERT into Involves
Values  (11,
   2,
   3,
   5,
   1
   );
INSERT into Involves
Values  (12,
   2,
   3,
   6,
   2
   );
INSERT into Involves
Values  (13,
   3,
   4,
   1,
   1
   );
INSERT into Involves
Values  (14,
   3,
   4,
   2,
   1
   );
INSERT into Involves
Values  (15,
   3,
   4,
   3,
   1
   );
INSERT into Involves
Values  (16,
   3,
   4,
   4,
   1
   );
INSERT into Involves
Values  (17,
   3,
   4,
   5,
   1
   );
INSERT into Involves
Values  (18,
   3,
   4,
   6,
   2
   );
INSERT into Involves
Values  (19,
   4,
   5,
   1,
   4
   );
INSERT into Involves
 Values (20,
   4,
   5,
   2,
   4
   );
INSERT into Involves
Values  (21,
   4,
   5,
   3,
   4
   );
INSERT into Involves
Values  (22,
   4,
   5,
   4,
   4
   );
INSERT into Involves
Values  (23,
   4,
   5,
   5,
   4
   );
INSERT into Involves 
Values (24,
   4,
   5,
   6,
   4
   );
INSERT into Involves 
Values (25,
   5,
   6,
   1,
   1
   );
INSERT into Involves 
Values (26,
   5,
   6,
   2,
   1
   );
INSERT into Involves 
Values (27,
   5,
   6,
   3,
   1
   );
INSERT into Involves 
Values (28,
   5,
   6,
   4,
   1
   );
INSERT into Involves 
Values (29,
   5,
   6,
   5,
   1
   );
INSERT into Involves 
Values (30,
   5,
   6,
   6,
   2
   );
INSERT into Involves 
Values (31,
   6,
   7,
   1,
   1
   );
INSERT into Involves 
Values (32,
   6,
   7,
   2,
   1
   );
INSERT into Involves 
Values (33,
   6,
   7,
   3,
   1
   );
INSERT into Involves 
Values (34,
   6,
   7,
   4,
   1
   );
INSERT into Involves 
Values (35,
   6,
   7,
   5,
   1
   );
INSERT into Involves 
Values (36,
   6,
   7,
   6,
   1
   );
INSERT into Involves 
Values (37,
   7,
   8,
   1,
   1
   );
INSERT into Involves 
Values (38,
   7,
   8,
   2,
   1
   );
INSERT into Involves 
Values (39,
   7,
   8,
   3,
   1
   );
INSERT into Involves 
Values (40,
   7,
   8,
   4,
   1
   );
INSERT into Involves 
Values (41,
   7,
   8,
   5,
   2
   );
INSERT into Involves 
Values (42,
   7,
   8,
   6,
   2
   );

INSERT into Involves 
Values (43,
   8,
   9,
   1,
   1
   );
INSERT into Involves 
Values (44,
   8,
   9,
   2,
   1
   );
INSERT into Involves 
Values (45,
   8,
   9,
   3,
   1
   );
INSERT into Involves 
Values (46,
   8,
   9,
   4,
   1
   );
INSERT into Involves 
Values (47,
   8,
   9,
   5,
   1
   );
INSERT into Involves 
Values (48,
   8,
   9,
   6,
   1
   );
INSERT into Involves 
Values (49,
   9,
   10,
   1,
   1
   );
INSERT into Involves 
Values (50,
   9,
   10,
   2,
   1
   );
INSERT into Involves 
Values (51,
   9,
   10,
   3,
   1
   );
INSERT into Involves 
Values (52,
   9,
   10,
   4,
   1
   );
INSERT into Involves 
Values (53,
   9,
   10,
   5,
   2
   );
INSERT into Involves 
Values (54,
   9,
   10,
   6,
   3
   );
INSERT into Involves 
Values (55,
   10,
   11,
   1,
   6
   );
INSERT into Involves 
Values (56,
   10,
   11,
   2,
   6
   );
INSERT into Involves 
Values (57,
   10,
   11,
   3,
   12
   );
INSERT into Involves 
Values (58,
   10,
   11,
   4,
   7
   );
INSERT into Involves 
Values (59,
   10,
   11,
   5,
   7
   );
INSERT into Involves 
Values (60,
   10,
   11,
   6,
   9
   );
INSERT into Involves 
Values (61,
   11,
   12,
   1,
   2
   );
INSERT into Involves 
Values (62,
   11,
   12,
   2,
   2
   );
INSERT into Involves 
Values (63,
   11,
   12,
   3,
   2
   );
INSERT into Involves 
Values (64,
   11,
   12,
   4,
   2
   );
INSERT into Involves 
Values (65,
   11,
   12,
   5,
   2
   );
INSERT into Involves 
Values (66,
   11,
   12,
   6,
   2
   );
INSERT into Involves 
Values (67,
   12,
   13,
   1,
   1
   );
INSERT into Involves 
Values (68,
   12,
   13,
   2,
   1
   );

INSERT into Involves 
Values (69,
   12,
   13,
   3,
   1
   );

INSERT into Involves 
Values (70,
   12,
   13,
   4,
   1
   );

INSERT into Involves 
Values (71,
   12,
   13,
   5,
   1
   );

INSERT into Involves 
Values (72,
   12,
   13,
   6,
   2
   );

INSERT into Involves 
Values (73,
   13,
   14,
   1,
   4
   );
INSERT into Involves 
Values (74,
   13,
   14,
   2,
   4
   );
INSERT into Involves 
Values (75,
   13,
   14,
   3,
   4
   );
INSERT into Involves 
Values (76,
   13,
   14,
   4,
   4
   );
INSERT into Involves 
Values (77,
   13,
   14,
   5,
   6
   );
INSERT into Involves 
Values (78,
   13,
   14,
   6,
   8
   );
INSERT into Involves 
Values (79,
   14,
   15,
   1,
   1
   );
INSERT into Involves 
Values (80,
   14,
   15,
   2,
   1
   );
INSERT into Involves 
Values (81,
   14,
   15,
   3,
   1
   );
INSERT into Involves 
Values (82,
   14,
   15,
   4,
   1
   );
INSERT into Involves 
Values (83,
   14,
   15,
   5,
   1
   );
INSERT into Involves 
Values (84,
   14,
   15,
   6,
   1
   );
INSERT into Involves 
Values (85,
   15,
   16,
   1,
   4
   );
INSERT into Involves 
Values (86,
   15,
   16,
   2,
   4
   );
INSERT into Involves 
Values (87,
   15,
   16,
   3,
   4
   );
INSERT into Involves 
Values (88,
   15,
   16,
   4,
   4
   );
INSERT into Involves 
Values (89,
   15,
   16,
   5,
   6
   );
INSERT into Involves 
Values (90,
   15,
   16,
   6,
   8
   );
INSERT into Involves 
Values (91,
   16,
   17,
   1,
   1
   );
INSERT into Involves 
Values (92,
   16,
   17,
   2,
   1
   );
INSERT into Involves 
Values (93,
   16,
   17,
   3,
   1
   );
INSERT into Involves 
Values (94,
   16,
   17,
   4,
   1
   );
INSERT into Involves 
Values (95,
   16,
   17,
   5,
   1
   );
INSERT into Involves 
Values (96,
   16,
   17,
   6,
   1
   );
INSERT into Involves 
Values (97,
   17,
   12,
   1,
   2
   );
INSERT into Involves 
Values (98,
   17,
   12,
   2,
   2
   );
INSERT into Involves 
Values (99,
   17,
   12,
   3,
   2
   );
INSERT into Involves 
Values (100,
   17,
   12,
   4,
   2
   );
INSERT into Involves 
Values (101,
   17,
   12,
   5,
   2
   );
INSERT into Involves 
Values (102,
   17,
   12,
   6,
   2
   );
INSERT into Involves 
Values (103,
   18,
   12,
   1,
   4
   );
INSERT into Involves 
Values (104,
   18,
   12,
   2,
   4
   );
INSERT into Involves 
Values (105,
   18,
   12,
   3,
   4
   );
INSERT into Involves 
Values (106,
   18,
   12,
   4,
   4
   );
INSERT into Involves 
Values (107,
   18,
   12,
   5,
   4
   );
INSERT into Involves 
Values (108,
   18,
   12,
   6,
   4
   );
INSERT into Involves 
Values (109,
   19,
   18,
   1,
   4
   );
INSERT into Involves 
Values (110,
   19,
   18,
   2,
   4
   );
INSERT into Involves 
Values (111,
   19,
   18,
   3,
   4
   );
INSERT into Involves 
Values (112,
   19,
   18,
   4,
   4
   );
INSERT into Involves 
Values (113,
   19,
   18,
   5,
   6
   );
INSERT into Involves 
Values (114,
   19,
   18,
   6,
   8
   );
INSERT into Involves 
Values (115,
   20,
   2,
   1,
   2
   );
INSERT into Involves 
Values (116,
   20,
   2,
   2,
   2
   );
INSERT into Involves 
Values (117,
   20,
   2,
   3,
   2
   );
INSERT into Involves 
Values (118,
   20,
   2,
   4,
   2
   );
INSERT into Involves 
Values (119,
   20,
   2,
   5,
   2
   );
INSERT into Involves 
Values (120,
   20,
   2,
   6,
   2
   );
INSERT into Involves 
Values (121,
   21,
   19,
   1,
   1
   );
INSERT into Involves 
Values (122,
   21,
   19,
   2,
   1
   );
INSERT into Involves 
Values (123,
   21,
   19,
   3,
   1
   );
INSERT into Involves 
Values (124,
   21,
   19,
   4,
   1
   );
INSERT into Involves 
Values (125,
   21,
   19,
   5,
   1
   );
INSERT into Involves 
Values (126,
   21,
   19,
   6,
   1
   );
--------------------------
   
INSERT into Maintenance 
Values ('A');
INSERT into Maintenance 
Values ('B');
INSERT into Maintenance 
Values ('C');
--------------------------

--Toyota Corolla

INSERT into Maintenance_uses 
Values (9,
   'A',
   5000,
   1);
INSERT into Maintenance_uses 
Values (7,
   'A',
   5000,
   1);
   
INSERT into Maintenance_uses 
Values (9,
   'B',
   25000,
   1);
INSERT into Maintenance_uses 
Values (7,
   'B',
   25000,
   1);
INSERT into Maintenance_uses 
Values (1,
   'B',
   25000,
   1);
INSERT into Maintenance_uses 
Values (12,
   'B',
   25000,
   1);
INSERT into Maintenance_uses 
Values (3,
   'B',
   25000,
   1);
INSERT into Maintenance_uses 
Values (21,
   'B',
   25000,
   1);
INSERT into Maintenance_uses 
Values (15,
   'B',
   25000,
   1);

INSERT into Maintenance_uses 
Values (9,
   'C',
   45000,
   1);
INSERT into Maintenance_uses 
Values (7,
   'C',
   45000,
   1);
INSERT into Maintenance_uses 
Values (1,
   'C',
   45000,
   1);
INSERT into Maintenance_uses 
Values (12,
   'C',
   45000,
   1);
INSERT into Maintenance_uses 
Values (3,
   'C',
   45000,
   1);
INSERT into Maintenance_uses 
Values (21,
   'C',
   45000,
   1);
INSERT into Maintenance_uses 
Values (15,
   'C',
   45000,
   1);
INSERT into Maintenance_uses 
Values (16,
   'C',
   45000,
   1);
INSERT into Maintenance_uses 
Values (4,
   'C',
   45000,
   1);
INSERT into Maintenance_uses 
Values (14,
   'C',
   45000,
   1);
   
--Toyota Prius

INSERT into Maintenance_uses 
Values (9,
   'A',
   10000,
   2);
INSERT into Maintenance_uses 
Values (12,
   'A',
   10000,
   2);
INSERT into Maintenance_uses 
Values (7,
   'A',
   10000,
   2);
   
INSERT into Maintenance_uses 
Values (9,
   'B',
   28000,
   2);
INSERT into Maintenance_uses 
Values (12,
   'B',
   28000,
   2);
INSERT into Maintenance_uses 
Values (7,
   'B',
   28000,
   2);
INSERT into Maintenance_uses 
Values (1,
   'B',
   28000,
   2);
INSERT into Maintenance_uses 
Values (3,
   'B',
   28000,
   2);
INSERT into Maintenance_uses 
Values (21,
   'B',
   28000,
   2);
INSERT into Maintenance_uses 
Values (15,
   'B',
   28000,
   2);
INSERT into Maintenance_uses 
Values (2,
   'B',
   28000,
   2);
   
INSERT into Maintenance_uses 
Values (9,
   'C',
   58000,
   2);
INSERT into Maintenance_uses 
Values (12,
   'C',
   58000,
   2);
INSERT into Maintenance_uses 
Values (7,
   'C',
   58000,
   2);
INSERT into Maintenance_uses 
Values (1,
   'C',
   58000,
   2);
INSERT into Maintenance_uses 
Values (3,
   'C',
   58000,
   2);
INSERT into Maintenance_uses 
Values (21,
   'C',
   58000,
   2);
INSERT into Maintenance_uses 
Values (15,
   'C',
   58000,
   2);
INSERT into Maintenance_uses 
Values (16,
   'C',
   58000,
   2);
INSERT into Maintenance_uses 
Values (4,
   'C',
   58000,
   2);
INSERT into Maintenance_uses 
Values (14,
   'C',
   58000,
   2);
   
--Nissan Altima
   
INSERT into Maintenance_uses 
Values (9,
   'A',
   10000,
   5);
INSERT into Maintenance_uses 
Values (1,
   'A',
   10000,
   5);  
INSERT into Maintenance_uses 
Values (12,
   'A',
   10000,
   5);
INSERT into Maintenance_uses 
Values (7,
   'A',
   10000,
   5); 
   
INSERT into Maintenance_uses 
Values (9,
   'B',
   25000,
   5);
INSERT into Maintenance_uses 
Values (1,
   'B',
   25000,
   5);  
INSERT into Maintenance_uses 
Values (12,
   'B',
   25000,
   5);
INSERT into Maintenance_uses 
Values (7,
   'B',
   25000,
   5);
INSERT into Maintenance_uses 
Values (3,
   'B',
   25000,
   5); 
INSERT into Maintenance_uses 
Values (21,
   'B',
   25000,
   5);
   
INSERT into Maintenance_uses 
Values (9,
   'C',
   50000,
   5);
INSERT into Maintenance_uses 
Values (1,
   'C',
   50000,
   5);  
INSERT into Maintenance_uses 
Values (12,
   'C',
   50000,
   5);
INSERT into Maintenance_uses 
Values (7,
   'C',
   50000,
   5);
INSERT into Maintenance_uses 
Values (3,
   'C',
   50000,
   5); 
INSERT into Maintenance_uses 
Values (21,
   'C',
   50000,
   5);
INSERT into Maintenance_uses 
Values (16,
   'C',
   50000,
   5);
INSERT into Maintenance_uses 
Values (4,
   'C',
   50000,
   5);
INSERT into Maintenance_uses 
Values (14,
   'C',
   50000,
   5);
INSERT into Maintenance_uses 
Values (15,
   'C',
   50000,
   5);
   
--Nissam Rogue

INSERT into Maintenance_uses 
Values (9,
   'A',
   10000,
   6);
INSERT into Maintenance_uses 
Values (1,
   'A',
   10000,
   6); 
INSERT into Maintenance_uses 
Values (14,
   'A',
   10000,
   6);
INSERT into Maintenance_uses 
Values (12,
   'A',
   10000,
   6);
INSERT into Maintenance_uses 
Values (7,
   'A',
   10000,
   6); 
   
INSERT into Maintenance_uses 
Values (9,
   'B',
   37000,
   6);
INSERT into Maintenance_uses 
Values (1,
   'B',
   37000,
   6); 
INSERT into Maintenance_uses 
Values (14,
   'B',
   37000,
   6);
INSERT into Maintenance_uses 
Values (12,
   'B',
   37000,
   6);
INSERT into Maintenance_uses 
Values (7,
   'B',
   37000,
   6); 
INSERT into Maintenance_uses 
Values (16,
   'B',
   37000,
   6);
INSERT into Maintenance_uses 
Values (21,
   'B',
   37000,
   6);
INSERT into Maintenance_uses 
Values (15,
   'B',
   37000,
   6);
   
INSERT into Maintenance_uses 
Values (9,
   'C',
   70000,
   6);
INSERT into Maintenance_uses 
Values (1,
   'C',
   70000,
   6); 
INSERT into Maintenance_uses 
Values (14,
   'C',
   70000,
   6);
INSERT into Maintenance_uses 
Values (12,
   'C',
   70000,
   6);
INSERT into Maintenance_uses 
Values (7,
   'C',
   70000,
   6); 
INSERT into Maintenance_uses 
Values (16,
   'C',
   70000,
   6);
INSERT into Maintenance_uses 
Values (21,
   'C',
   70000,
   6);
INSERT into Maintenance_uses 
Values (15,
   'C',
   70000,
   6);
   
--Honda Accord
   
INSERT into Maintenance_uses 
Values (9,
   'A',
   15000,
   4);
INSERT into Maintenance_uses 
Values (1,
   'A',
   15000,
   4); 
INSERT into Maintenance_uses 
Values (12,
   'A',
   15000,
   4);
INSERT into Maintenance_uses 
Values (7,
   'A',
   15000,
   4); 
   
INSERT into Maintenance_uses 
Values (9,
   'B',
   37000,
   4);
INSERT into Maintenance_uses 
Values (1,
   'B',
   37000,
   4); 
INSERT into Maintenance_uses 
Values (12,
   'B',
   37000,
   4);
INSERT into Maintenance_uses 
Values (7,
   'B',
   37000,
   4);  
INSERT into Maintenance_uses 
Values (3,
   'B',
   37000,
   4); 
INSERT into Maintenance_uses 
Values (21,
   'B',
   37000,
   4); 
INSERT into Maintenance_uses 
Values (15,
   'B',
   37000,
   4); 
   
INSERT into Maintenance_uses 
Values (9,
   'C',
   67000,
   4);
INSERT into Maintenance_uses 
Values (1,
   'C',
   67000,
   4); 
INSERT into Maintenance_uses 
Values (12,
   'C',
   67000,
   4);
INSERT into Maintenance_uses 
Values (7,
   'C',
   67000,
   4);  
INSERT into Maintenance_uses 
Values (3,
   'C',
   67000,
   4); 
INSERT into Maintenance_uses 
Values (21,
   'C',
   67000,
   4); 
INSERT into Maintenance_uses 
Values (15,
   'C',
   67000,
   4);
INSERT into Maintenance_uses 
Values (16,
   'C',
   67000,
   4);
INSERT into Maintenance_uses 
Values (4,
   'C',
   67000,
   4);
INSERT into Maintenance_uses 
Values (14,
   'C',
   67000,
   4);
  
--Honda Civic

INSERT into Maintenance_uses 
Values (9,
   'A',
   14000,
   3);
INSERT into Maintenance_uses 
Values (3,
   'A',
   14000,
   3);
INSERT into Maintenance_uses 
Values (7,
   'A',
   14000,
   3); 
   
INSERT into Maintenance_uses 
Values (9,
   'B',
   29000,
   3);
INSERT into Maintenance_uses 
Values (3,
   'B',
   29000,
   3);
INSERT into Maintenance_uses 
Values (7,
   'B',
   29000,
   3);
INSERT into Maintenance_uses 
Values (1,
   'B',
   29000,
   3);
INSERT into Maintenance_uses 
Values (12,
   'B',
   29000,
   3);
INSERT into Maintenance_uses 
Values (4,
   'B',
   29000,
   3);
INSERT into Maintenance_uses 
Values (21,
   'B',
   29000,
   3);
INSERT into Maintenance_uses 
Values (15,
   'B',
   29000,
   3);
   
INSERT into Maintenance_uses 
Values (9,
   'C',
   44000,
   3);
INSERT into Maintenance_uses 
Values (3,
   'C',
   44000,
   3);
INSERT into Maintenance_uses 
Values (7,
   'C',
   44000,
   3);
INSERT into Maintenance_uses 
Values (1,
   'C',
   44000,
   3);
INSERT into Maintenance_uses 
Values (12,
   'C',
   44000,
   3);
INSERT into Maintenance_uses 
Values (4,
   'C',
   44000,
   3);
INSERT into Maintenance_uses 
Values (21,
   'C',
   44000,
   3);
INSERT into Maintenance_uses 
Values (15,
   'C',
   44000,
   3);
INSERT into Maintenance_uses 
Values (16,
   'C',
   44000,
   3);
INSERT into Maintenance_uses 
Values (14,
   'C',
   44000,
   3);

INSERT into Repair
Values(
  1,
  'Engine knock',
  'Timing issue',
  75
);

INSERT into Repair
Values(
  2,
  'Car drifts in a particular direction',
  'Wheel alignment issue',
  50
);

INSERT into Repair
Values(
  3,
  'Battery does not hold charge',
  '​​Battery needs replacement',
  25
);

INSERT into Repair
Values(
  4,
  'Black/unclean exhaust',
  '​​​​Bad catalytic convertor and filters',
  75
);

INSERT into Repair
Values(
  5,
  'A/C-Heater not working',
  '​​​​Drive belt damaged, coolant not enough, weak battery',
  50
);

INSERT into Repair
Values(
  6,
  'Headlamps/Tail lamps not working',
  '​​​​Light assembly damaged',
  30
);

INSERT into Repair
Values(
  7,
  'Check engine light',
  '​​​​Gearbox and Torque convertor issue',
  100
);

INSERT into Repair_uses
Values(
  8,
  1
);

INSERT into Repair_uses
Values(
  15,
  1
);

INSERT into Repair_uses
Values(
  5,
  1
);

INSERT into Repair_uses
Values(
  19,
  1
);

INSERT into Repair_uses
Values(
  20,
  2
);

INSERT into Repair_uses
Values(
  2,
  3
);

INSERT into Repair_uses
Values(
  1,
  4
);

INSERT into Repair_uses
Values(
  12,
  4
);

INSERT into Repair_uses
Values(
  6,
  4
);

INSERT into Repair_uses
Values(
  8,
  5
);
INSERT into Repair_uses
Values(
  7,
  5
);
INSERT into Repair_uses
Values(
  2,
  5
);

INSERT into Repair_uses
Values(
  11,
  6
);

INSERT into Repair_uses
Values(
  17,
  6
);

INSERT into Repair_uses
Values(
  18,
  6
);

INSERT into Repair_uses
Values(
  13,
  7
);

INSERT into Repair_uses
Values(
  10,
  7
);

INSERT into Repair_uses
Values(
  5,
  7
);
INSERT into Repair_uses
Values(
  19,
  7
);

INSERT into Schedule
Values(
  1,
  TIMESTAMP '2018-09-10 10:00:00',
  'XYZ-5643',
  557279280,
  'complete',
  TIMESTAMP '2018-09-10 13:00:00'
);

INSERT into Schedule
Values(
  1,
  TIMESTAMP '2018-02-25 09:00:00',
  'XYZ-5643',
  557279281,
  'complete',
  TIMESTAMP '2018-02-25 11:30:00'
);

INSERT into Schedule
Values(
  1,
  TIMESTAMP '2017-10-15 08:00:00',
  'XYZ-5643',
  183683346,
  'complete',
  TIMESTAMP '2017-10-15 09:00:00'
);

INSERT into Schedule
Values(
  1,
  TIMESTAMP '2018-08-06 08:00:00',
  'AHS-3132',
  557279282,
  'complete',
  TIMESTAMP '2018-08-06 08:30:00'
);

INSERT into Schedule
Values(
  1,
  TIMESTAMP '2018-05-15 10:30:00',
  'AHS-3132',
  557279283,
  'complete',
  TIMESTAMP '2018-05-15 13:00:00'
);

INSERT into Schedule
Values(
  1,
  TIMESTAMP '2018-01-28 12:00:00',
  'AHS-3132',
  557279283,
  'complete',
  TIMESTAMP '2018-01-28 13:00:00'
);

INSERT into Schedule
Values(
  1,
  TIMESTAMP '2018-02-11 08:30:00',
  'IRM-1212',
  557279281,
  'complete',
  TIMESTAMP '2018-02-11 09:30:00'
);

INSERT into Schedule
Values(
  1,
  TIMESTAMP '2017-12-10 09:30:00',
  'IRM-1212',
  557279281,
  'complete',
  TIMESTAMP '2017-12-10 12:30:00'
);

INSERT into Schedule
Values(
  1,
  TIMESTAMP '2017-01-20 10:00:00',
  'IRM-1212',
  557279281,
  'complete',
  TIMESTAMP '2017-01-20 11:30:00'
);
INSERT into Schedule
Values(
  1,
  TIMESTAMP '2018-02-11 08:30:00',
  'DEL-8888',
  187658163,
  'complete',
  TIMESTAMP '2018-02-11 10:00:00'
);
INSERT into Schedule
Values(
  1,
  TIMESTAMP '2016-11-05 09:00:00',
  'DEL-8888',
  401671897,
  'complete',
  TIMESTAMP '2016-11-05 10:30:00'
);

INSERT into Schedule
Values(
  1,
  TIMESTAMP '2017-09-01 09:00:00',
  'P11-212A',
  590424694,
  'complete',
  TIMESTAMP '2017-09-01 11:00:00'
);

INSERT into Schedule
Values(
  1,
  TIMESTAMP '2014-06-15 08:30:00',
  'P11-212A',
  310773348,
  'complete',
  TIMESTAMP '2014-06-15 09:30:00'
);

INSERT into Schedule
Values(
  1,
  TIMESTAMP '2016-11-11 08:30:00',
  'WIM-BLE5',
  310773348,
  'complete',
  TIMESTAMP '2016-11-11 09:30:00'
);

INSERT into Schedule
Values(
  1,
  TIMESTAMP '2016-01-02 14:00:00',
  'WIM-BLE5',
  401671897,
  'complete',
  TIMESTAMP '2016-01-02 15:30:00'
);
INSERT into Schedule
Values(
  1,
  TIMESTAMP '2015-09-30 11:00:00',
  'WIM-BLE5',
  401671897,
  'complete',
  TIMESTAMP '2015-09-30 14:30:00'
);

INSERT into Repair_schedule
Values(
  4,
  3
);
INSERT into Repair_schedule
Values(
  11,
  6
);
INSERT into Repair_schedule
Values(
  15,
  5
);
INSERT into Repair_schedule
Values(
  16,
  1
);

INSERT into Maintenance_schedule
Values(
  1,
  'C'
);

INSERT into Maintenance_schedule
Values(
  2,
  'B'
);
INSERT into Maintenance_schedule
Values(
  3,
  'C'
);
INSERT into Maintenance_schedule
Values(
  5,
  'B'
);
INSERT into Maintenance_schedule
Values(
  6,
  'A'
);
INSERT into Maintenance_schedule
Values(
  7,
  'A'
);
INSERT into Maintenance_schedule
Values(
  8,
  'C'
);
INSERT into Maintenance_schedule
Values(
  9,
  'B'
);
INSERT into Maintenance_schedule
Values(
  10,
  'A'
);
INSERT into Maintenance_schedule
Values(
  12,
  'B'
);
INSERT into Maintenance_schedule
Values(
  13,
  'A'
);
INSERT into Maintenance_schedule
Values(
  14,
  'A'
);

INSERT into Orders
Values(
  1,
  DATE '2014-06-09',
  DATE '2014-06-13',
  DATE '2014-06-18',
  3,
  5,
  'complete'
);

INSERT into Orders
Values(
  1,
  DATE '2015-09-16',
  DATE '2015-09-21',
  DATE '2015-09-21',
  38,
  5,
  'complete'
);

INSERT into Orders
Values(
  1,
  DATE '2016-02-10',
  DATE '2016-02-11',
  DATE '2016-02-11',
  30,
  5,
  'complete'
);

INSERT into Orders
Values(
  1,
  DATE '2017-08-09',
  DATE '2017-08-10',
  DATE '2017-08-11',
  46,
  4,
  'complete'
);

INSERT into Orders
Values(
  1,
  DATE '2018-10-04',
  DATE '2018-10-05',
  DATE '2018-10-05',
  1,
  6,
  'complete'
);

INSERT into Orders
Values(
  1,
  DATE '2018-10-26',
  DATE '2018-11-01',
  DATE '2018-11-05',
  44,
  5,
  'complete'
);

INSERT into Orders
Values(
  1,
  DATE '2018-11-09',
  DATE '2018-11-14',
  Null,
  38,
  7,
  'delayed'
);
INSERT into Orders
Values(
  1,
  DATE '2018-11-07',
  DATE '2018-11-14',
  Null,
  21,
  12,
  'delayed'
);
INSERT into Orders
Values(
  1,
  DATE '2018-11-08',
  DATE '2018-11-14',
  Null,
  25,
  6,
  'delayed'
);
INSERT into Orders
Values(
  1,
  DATE '2018-11-08',
  DATE '2018-11-14',
  Null,
  32,
  5,
  'delayed'
);
INSERT into Orders
Values(
  1,
  DATE '2018-11-08',
  DATE '2018-11-14',
  Null,
  23,
  5,
  'delayed'
);

INSERT into Service_center_order
Values(
1,
'S0002',
'S0001',
3
);

INSERT into Service_center_order
Values(
1,
'S0001',
'S0002',
4
);

INSERT into Service_center_order
Values(
1,
'S0002',
'S0001',
5
);

INSERT into Distributor_order
Values(
1,
'S0001',
'D0001',
1
);

INSERT into Distributor_order
Values(
1,
'S0001',
'D0002',
2
);

INSERT into Distributor_order
Values(
1,
'S0001',
'D0001',
6
);

INSERT into Distributor_order
Values(
1,
'S0002',
'D0002',
7
);
INSERT into Distributor_order
Values(
1,
'S0002',
'D0001',
8
);
INSERT into Distributor_order
Values(
1,
'S0002',
'D0001',
9
);
INSERT into Distributor_order
Values(
1,
'S0002',
'D0001',
10
);
INSERT into Distributor_order
Values(
1,
'S0002',
'D0002',
11
);

------------
ALTER TABLE Inventory
  ADD uncommited_current_quantity INTEGER;
  
Update Inventory
set
uncommited_current_quantity = current_quantity;
-------------

---- Post Insert TRIGGERS HERE || Write INSERT statements above this
create sequence Emp_id_seq START WITH 999204784;

create trigger trg_emp_id
before insert on Employees
for each row
begin
  select Emp_id_seq.nextval
  into :new.eid
  from dual;
end;
/

create sequence Cust_id_seq START WITH 1006;

create trigger trg_cust_id
before insert on Customers
for each row
begin
  select Cust_id_seq.nextval
  into :new.id
  from dual;
end;
/

------------------------
