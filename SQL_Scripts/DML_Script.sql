#Inserting in Service Center
INSERT into Service_center
Values(
	"S0001",
	"Downtown Auto Care",
	"1.800.899.9999",
	"Address: 437 Fayetteville St., Raleigh, NC 27601"
);

#Inserting in Manager
INSERT into Users
Values(
	"lacohen@acme.com",
	"temp1"
);

INSERT into Employees
Values(
	950932130,
	"lacohen@acme.com",
	"Larry Cohen",
	"316-978-5494",
	"1979 Henry Street, Raleigh, NC 27606",
	"11000",
	"month",
	"2016-08-15",
	"S0001"
);
INSERT into Employees
Values(
	634622236,
	"wimartin@acme.com",
	"Willis Martin",
	"213-988-2011",
	"465 Aviation Way, Raleigh, NC 27601",
	"8000",
	"month",
	"2017-12-04",
	"S0001"
);
INSERT into Employees
Values(
	557279280,
	"jagloss@acme.com",
	"Jacob Gloss",
	"413-335-9523",
	"2014 Leverton Cove Road, Raleigh, NC 27560",
	"30",
	"hour",
	"2018-07-29",
	"S0001"
);
INSERT into Employees
Values(
	183683346,
	"anfreeman@acme.com",
	"Anthony Freeman",
	"563-496-7912",
	"1188 Summit Street, Raleigh, NC 27627",
	"40",
	"hour",
	"2015-02-09",
	"S0001"
);
INSERT into Employees
Values(
	557279281,
	"erfowler@acme.com",
	"Eric Fowler",
	"760-457-9846",
	"1114 Fincham Road, Raleigh, NC 27545",
	"35",
	"hour",
	"2016-05-01",
	"S0001"
);
INSERT into Employees
Values(
	557279282,
	"erfowler@acme.com",
	"Roland Richmond",
	"829843373",
	"1951 Little Acres Lane, Raleigh, NC 27513",
	"35",
	"hour",
	"2017-12-28",
	"S0001"
);
INSERT into Employees
Values(
	557279283,
	"pefitzpatrick@acme.com",
	"Peter Fitzpatrick",
	"315-485-1152",
	"4738 Buckhannan Avenue, Raleigh, NC 27625",
	"34",
	"hour",
	"2017-04-12",
	"S0001"
);
INSERT into Employees
Values(
	291056276,
	"rophillips@acme.com",
	"Roderick Phillips",
	"901-777-0492",
	"1133 Burton Avenue, Charlotte, NC 28201",
	"12000",
	"month",
	"2017-04-15",
	"S0002"
);
INSERT into Employees
Values(
	911639633,
	"deholmes@acme.com",
	"Dena Holmes",
	"972-353-3691",
	"1382 Whispering Pines Circle, Charlotte, NC 28205",
	"9000",
	"month",
	"2010-01-04",
	"S0002"
);
INSERT into Employees
Values(
	590424694,
	"duesparza@acme.com",
	"Dustin Esparza",
	"956-444-0948",
	"3510 Hemlock Lane, Charlotte, NC 28202",
	"35",
	"hour",
	"2017-01-26",
	"S0002"
);
INSERT into Employees
Values(
	401671897,
	"chpudilo@acme.com",
	"Charles Pudilo",
	"641-752-9403",
	"196 Park Boulevard, Charlotte, NC 28222",
	"40",
	"hour",
	"2016-07-06",
	"S0002"
);
INSERT into Employees
Values(
	310773348,
	"jarivera@acme.com",
	"James Rivera",
	"903-967-1809",
	"908 Alpha Avenue, Charlotte, NC 28130",
	"40",
	"hour",
	"2013-10-29",
	"S0002"
);
INSERT into Employees
Values(
	983204784,
	"wimorton@acme.com",
	"Willis Morton",
	"757-886-6330",
	"404 Tenmile, Charlotte, NC 28134",
	"30",
	"hour",
	"2018-10-13",
	"S0002"
);
INSERT into Employees
Values(
	187658163,
	"rihenderson@acme.com",
	"Rickie Henderson",
	"931-539-1294",
	"1963 Chenoweth Drive, Charlotte, NC 28228",
	"30",
	"hour",
	"2017-03-29",
	"S0002"
);

INSERT into Manager
Values(
	950932130
);

#Inserting into Customer and their Vehicles [eg for Ethan Hunt]
INSERT into Users
Values(
	"ethanhunt@gmail.com",
	"temp1"
);

INSERT into Customers
Values(
	"1001"
	"ethanhunt@gmail.com",
	"Tom Cruise",
	"1234567890",
	"203, Park St, Raleigh, NC - 27603",
	"S0001"
);
INSERT into Customers
Values(
	"1002"
	"jarvis@gmail.com",
	"Robert Downey Jr.",
	"9989877791",
	"12-A, High St, Raleigh, NC - 27605",
	"S0001"
);
INSERT into Customers
Values(
	"1003"
	"lovestory@gmail.com",
	"Taylor Swift",
	"8179827199",
	"2A, 3rd Ave, Charlotte, NC - 28134",
	"S0002"
);
INSERT into Customers
Values(
	"1004"
	"venus@gmail.com",
	"Serena Williams",
	"8714791879",
	"90, Gorman St, Charlotte, NC - 28201",
	"S0002"
);

INSERT into Vehicles
Values(
	1,
   "Honda",
   "Civic",
   "2009"
);
INSERT into Vehicles
Values(
	2,
	"Toyota",
	"Prius",
	"2007"
);
INSERT into Vehicles
Values(
	3,
	"Nissan",
	"Altima",
	"2001"
);
INSERT into Vehicles
Values(
	4,
	"Honda",
	"Accord",
	"2015"
);
INSERT into Vehicles
Values(
	5,
	"Nissan",
	"Rogue",
	"2014"
);
INSERT into Vehicles
Values(
	6,
	"Honda",
	"Accord",
	"2009"
);
INSERT into Vehicles
Values(
	7,
	"Toyota",
	"Prius",
	"2013"
);

INSERT into Owns
Values(
    "XYZ-5643",
  	90452,
  	"2018-9-10",
    "2009-12-24",
    1,
    "ethanhunt@gmail.com"
);
INSERT into Owns
Values(
    "AHS-3132",
  	65452,
  	"2018-8-6",
    "2011-01-02",
    2,
    "ethanhunt@gmail.com"
);
INSERT into Owns
Values(
    "RM-1212",
  	210452,
  	"2018-02-11",
    "2002-09-07",
    3,
    "jarvis@gmail.com"
);
INSERT into Owns
Values(
    "TSW-3462",
  	NULL,
  	NULL,
    "2015-12-09",
    4,
    "lovestory@gmail.com"
);
INSERT into Owns
Values(
    "DEL-8888",
  	31209,
  	"2018-02-11",
    "2016-05-11",
    5,
    "lovestory@gmail.com"
);
INSERT into Owns
Values(
    "P11-212A",
  	60452,
  	"2017-09-01",
    "2010-04-14",
    6,
    "venus@gmail.com"
);
INSERT into Owns
Values(
    "WIM-BLE5",
  	19876,
  	"2016-11-11",
    "2013-03-01",
    7,
    "venus@gmail.com"
);
