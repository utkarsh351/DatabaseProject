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

INSERT into Distributor
Values(
  1,
  'D1'
);
INSERT into Distributor
Values(
  2,
  'D2'
);


INSERT into Supplies
Values(
  1,
  NULL,
  1,
  1
);
INSERT into Supplies
Values(
  2,
  5,
  2,
  1
);
INSERT into Supplies
Values(
  3,
  4,
  3,
  1
);
INSERT into Supplies
Values(
  4,
  NULL,
  4,
  1
);
INSERT into Supplies
Values(
  5,
  NULL,
  5,
  1
);
INSERT into Supplies
Values(
  6,
  4,
  6,
  1
);
INSERT into Supplies
Values(
  7,
  NULL,
  7,
  1
);
INSERT into Supplies
Values(
  8,
  NULL,
  8,
  1
);
INSERT into Supplies
Values(
  9,
  NULL,
  9,
  1
);
INSERT into Supplies
Values(
  10,
  2,
  10,
  1
);
INSERT into Supplies
Values(
  11,
  5,
  11,
  1
);
INSERT into Supplies
Values(
  12,
  3,
  12,
  1
);
INSERT into Supplies
Values(
  13,
  4,
  13,
  1
);
INSERT into Supplies
Values(
  14,
  2,
  14,
  1
);
INSERT into Supplies
Values(
  15,
  5,
  15,
  1
);
INSERT into Supplies
Values(
  16,
  NULL,
  16,
  1
);
INSERT into Supplies
Values(
  17,
  NULL,
  17,
  1
);
INSERT into Supplies
Values(
  18,
  3,
  18,
  1
);
INSERT into Supplies
Values(
  19,
  NULL,
  19,
  1
);

INSERT into Supplies
Values(
  20,
  NULL,
  20,
  1
);
INSERT into Supplies
Values(
  21,
  5,
  22,
  1
);
INSERT into Supplies
Values(
  22,
  4,
  22,
  1
);
INSERT into Supplies
Values(
  23,
  NULL,
  23,
  1
);
INSERT into Supplies
Values(
  24,
  NULL,
  24,
  1
);
INSERT into Supplies
Values(
  25,
  4,
  25,
  1
);
INSERT into Supplies
Values(
  26,
  NULL,
  26,
  1
);
INSERT into Supplies
Values(
  27,
  NULL,
  27,
  1
);
INSERT into Supplies
Values(
  28,
  NULL,
  28,
  1
);
INSERT into Supplies
Values(
  29,
  2,
  29,
  1
);
INSERT into Supplies
Values(
  30,
  5,
  30,
  1
);
INSERT into Supplies
Values(
  31,
  3,
  31,
  1
);
INSERT into Supplies
Values(
  32,
  4,
  32,
  1
);
INSERT into Supplies
Values(
  33,
  2,
  33,
  1
);
INSERT into Supplies
Values(
  34,
  5,
  34,
  1
);
INSERT into Supplies
Values(
  35,
  NULL,
  35,
  1
);
INSERT into Supplies
Values(
  36,
  NULL,
  36,
  1
);
INSERT into Supplies
Values(
  37,
  3,
  37,
  1
);
INSERT into Supplies
Values(
  38,
  NULL,
  38,
  1
);

INSERT into Supplies
Values(
  39,
  NULL,
  39,
  1
);
INSERT into Supplies
Values(
  40,
  5,
  40,
  1
);
INSERT into Supplies
Values(
  41,
  4,
  41,
  1
);
INSERT into Supplies
Values(
  42,
  NULL,
  42,
  1
);
INSERT into Supplies
Values(
  43,
  NULL,
  43,
  1
);
INSERT into Supplies
Values(
  44,
  4,
  44,
  1
);
INSERT into Supplies
Values(
  45,
  NULL,
  45,
  1
);
INSERT into Supplies
Values(
  46,
  NULL,
  46,
  1
);
INSERT into Supplies
Values(
  47,
  NULL,
  47,
  1
);
INSERT into Supplies
Values(
  48,
  2,
  48,
  1
);
INSERT into Supplies
Values(
  49,
  5,
  49,
  1
);
INSERT into Supplies
Values(
  50,
  3,
  50,
  1
);
INSERT into Supplies
Values(
  51,
  4,
  51,
  1
);
INSERT into Supplies
Values(
  52,
  2,
  52,
  1
);
INSERT into Supplies
Values(
  53,
  5,
  53,
  1
);
INSERT into Supplies
Values(
  54,
  NULL,
  54,
  1
);
INSERT into Supplies
Values(
  55,
  NULL,
  55,
  1
);
INSERT into Supplies
Values(
  56,
  3,
  56,
  1
);
INSERT into Supplies
Values(
  57,
  NULL,
  57,
  1
);

INSERT into Supplies
Values(
  58,
  3,
  1,
  2
);
INSERT into Supplies
Values(
  59,
  NULL,
  2,
  2
);
INSERT into Supplies
Values(
  60,
  NULL,
  3,
  2
);
INSERT into Supplies
Values(
  61,
  4,
  4,
  2
);
INSERT into Supplies
Values(
  62,
  5,
  5,
  2
);
INSERT into Supplies
Values(
  63,
  NULL,
  6,
  2
);
INSERT into Supplies
Values(
  64,
  3,
  7,
  2
);
INSERT into Supplies
Values(
  65,
  4,
  8,
  2
);
INSERT into Supplies
Values(
  66,
  2,
  9,
  2
);
INSERT into Supplies
Values(
  67,
  NULL,
  10,
  2
);
INSERT into Supplies
Values(
  68,
  NULL,
  11,
  2
);
INSERT into Supplies
Values(
  69,
  NULL,
  12,
  2
);
INSERT into Supplies
Values(
  70,
  NULL,
  13,
  2
);
INSERT into Supplies
Values(
  71,
  NULL,
  14,
  2
);
INSERT into Supplies
Values(
  72,
  NULL,
  15,
  2
);
INSERT into Supplies
Values(
  73,
  5,
  16,
  2
);
INSERT into Supplies
Values(
  74,
  3,
  17,
  2
);
INSERT into Supplies
Values(
  75,
  NULL,
  18,
  2
);
INSERT into Supplies
Values(
  76,
  3,
  19,
  2
);

INSERT into Supplies
Values(
  77,
  3,
  20,
  2
);
INSERT into Supplies
Values(
  78,
  NULL,
  21,
  2
);
INSERT into Supplies
Values(
  79,
  NULL,
  22,
  2
);
INSERT into Supplies
Values(
  80,
  4,
  23,
  2
);
INSERT into Supplies
Values(
  81,
  5,
  24,
  2
);
INSERT into Supplies
Values(
  82,
  NULL,
  25,
  2
);
INSERT into Supplies
Values(
  83,
  3,
  26,
  2
);
INSERT into Supplies
Values(
  84,
  4,
  27,
  2
);
INSERT into Supplies
Values(
  85,
  2,
  28,
  2
);
INSERT into Supplies
Values(
  86,
  NULL,
  29,
  2
);
INSERT into Supplies
Values(
  87,
  NULL,
  30,
  2
);
INSERT into Supplies
Values(
  88,
  NULL,
  31,
  2
);
INSERT into Supplies
Values(
  89,
  NULL,
  32,
  2
);
INSERT into Supplies
Values(
  90,
  NULL,
  33,
  2
);
INSERT into Supplies
Values(
  91,
  NULL,
  34,
  2
);
INSERT into Supplies
Values(
  92,
  5,
  35,
  2
);
INSERT into Supplies
Values(
  93,
  3,
  36,
  2
);
INSERT into Supplies
Values(
  94,
  NULL,
  37,
  2
);
INSERT into Supplies
Values(
  94,
  3,
  38,
  2
);

INSERT into Supplies
Values(
  95,
  3,
  39,
  2
);
INSERT into Supplies
Values(
  96,
  NULL,
  40,
  2
);
INSERT into Supplies
Values(
  97,
  NULL,
  41,
  2
);
INSERT into Supplies
Values(
  98,
  4,
  42,
  2
);
INSERT into Supplies
Values(
  99,
  5,
  43,
  2
);
INSERT into Supplies
Values(
  100,
  NULL,
  44,
  2
);
INSERT into Supplies
Values(
  101,
  3,
  45,
  2
);
INSERT into Supplies
Values(
  102,
  4,
  46,
  2
);
INSERT into Supplies
Values(
  103,
  2,
  47,
  2
);
INSERT into Supplies
Values(
  104,
  NULL,
  48,
  2
);
INSERT into Supplies
Values(
  105,
  NULL,
  49,
  2
);
INSERT into Supplies
Values(
  106,
  NULL,
  50,
  2
);
INSERT into Supplies
Values(
  107,
  NULL,
  51,
  2
);
INSERT into Supplies
Values(
  108,
  NULL,
  52,
  2
);
INSERT into Supplies
Values(
  109,
  NULL,
  53,
  2
);
INSERT into Supplies
Values(
  110,
  5,
  54,
  2
);
INSERT into Supplies
Values(
  111,
  3,
  55,
  2
);
INSERT into Supplies
Values(
  112,
  NULL,
  56,
  2
);
INSERT into Supplies
Values(
  113,
  3,
  57,
  2
);

