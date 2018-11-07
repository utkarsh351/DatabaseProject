#Intering in Service Center
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
	"2016-09-15",
	"S0001"
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

INSERT into Owns
  ("XYZ-5643",
  	"90452",
  	"2018-9-10",
    "2009-12-24",
    1,
    "ethanhunt@gmail.com"
   );
INSERT into Owns
  ("AHS-3132",
  	"65452",
  	"2018-8-6",
    "2011-01-02",
    2,
    "ethanhunt@gmail.com"
   );