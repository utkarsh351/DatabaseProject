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
	'S0002'
);

INSERT into Manager
Values(
	950932130
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

INSERT into Vehicles
Values(
	1,
   'Honda',
   'Civic',
   '2009'
);
INSERT into Vehicles
Values(
	2,
	'Toyota',
	'Prius',
	'2007'
);
INSERT into Vehicles
Values(
	3,
	'Nissan',
	'Altima',
	'2001'
);
INSERT into Vehicles
Values(
	4,
	'Honda',
	'Accord',
	'2015'
);
INSERT into Vehicles
Values(
	5,
	'Nissan',
	'Rogue',
	'2014'
);
INSERT into Vehicles
Values(
	6,
	'Honda',
	'Accord',
	'2009'
);
INSERT into Vehicles
Values(
	7,
	'Toyota',
	'Prius',
	'2013'
);

INSERT into Owns
Values(
    'XYZ-5643',
  	90452,
  	Date '2018-9-10',
    Date '2009-12-24',
    1,
    'ethanhunt@gmail.com'
);
INSERT into Owns
Values(
    'AHS-3132',
  	65452,
  	Date '2018-8-6',
    Date '2011-01-02',
    2,
    'ethanhunt@gmail.com'
);
INSERT into Owns
Values(
    'RM-1212',
  	210452,
  	Date '2018-02-11',
    Date '2002-09-07',
    3,
    'jarvis@gmail.com'
);
INSERT into Owns
Values(
    'TSW-3462',
  	NULL,
  	NULL,
    Date '2015-12-09',
    4,
    'lovestory@gmail.com'
);
INSERT into Owns
Values(
    'DEL-8888',
  	31209,
  	Date '2018-02-11',
    Date '2016-05-11',
    5,
    'lovestory@gmail.com'
);
INSERT into Owns
Values(
    'P11-212A',
  	60452,
  	Date '2017-09-01',
    Date '2010-04-14',
    6,
    'venus@gmail.com'
);
INSERT into Owns
Values(
    'WIM-BLE5',
  	19876,
  	Date '2016-11-11',
    Date '2013-03-01',
    7,
    'venus@gmail.com'
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

INSERT into Make
Values(
    1,
    'Toyota'
);

INSERT into Make
Values(
    2,
    'Honda'
);

INSERT into Make
Values(
    3,
    'Nissan'
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

