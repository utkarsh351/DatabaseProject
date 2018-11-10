CREATE TABLE Users
  (email VARCHAR(50),
   password VARCHAR(20),
  PRIMARY KEY (email)
   );
   
CREATE TABLE Service_center
  (sc_id VARCHAR(50),
   name VARCHAR(50) NOT NULL,
   tel VARCHAR(10),
   addr VARCHAR(50),
  PRIMARY KEY (sc_id)
   );

CREATE TABLE Employees
  (eid INTEGER,
   email VARCHAR(50) UNIQUE,
   name VARCHAR(50),
   tel VARCHAR(10),
   addr VARCHAR(50),
   wage INTEGER,
   freq INTEGER,
   s_date DATE,
   service_centre_id VARCHAR(50),
  PRIMARY KEY (eid),
  FOREIGN KEY (email)
   REFERENCES Users,
  FOREIGN KEY (service_centre_id )
   REFERENCES Service_center
   );

CREATE TABLE Payment_cycle
  (pcid INTEGER,
   start_date DATE,
   end_date DATE,
  PRIMARY KEY (pcid)
   );

CREATE UNIQUE INDEX uq_Payment_cycle
  ON Payment_cycle(start_date, end_date);
  
CREATE TABLE Payment_record
  (eid INTEGER NOT NULL,
   pcid INTEGER NOT NULL,
   units INTEGER,
  PRIMARY KEY (eid,pcid),
    FOREIGN KEY (eid)
   REFERENCES Employees,
    FOREIGN KEY (pcid)
   REFERENCES Payment_cycle
   );

CREATE TABLE Manager
  (mananger_id INTEGER,
  PRIMARY KEY (mananger_id),
  FOREIGN KEY (mananger_id)
   REFERENCES Employees
   );
   
CREATE TABLE Receptionist
  (receptionist_id INTEGER,
  PRIMARY KEY (receptionist_id),
  FOREIGN KEY (receptionist_id)
   REFERENCES Employees
   );
   
CREATE TABLE Mechanic
  (mechanic_id INTEGER,
  PRIMARY KEY (mechanic_id),
  FOREIGN KEY (mechanic_id)
   REFERENCES Employees
   );
   
CREATE TABLE Customers
  (id VARCHAR(50) UNIQUE,
   email VARCHAR(50),
   name VARCHAR(50),
   tel VARCHAR(10),
   addr VARCHAR(50),
   sc_id VARCHAR(50),
  PRIMARY KEY (email),
  FOREIGN KEY (email)
   REFERENCES Users,   
   FOREIGN KEY (sc_id)
   REFERENCES Service_center
   );
   

CREATE TABLE Vehicles
  (vehicle_id INTEGER,
   make VARCHAR(50),
   model VARCHAR(10),
   year VARCHAR(50),
  PRIMARY KEY (vehicle_id)
   );
   
CREATE TABLE Make
(vehicle_id INTEGER,
make VARCHAR(50),
PRIMARY KEY (make),
FOREIGN KEY(vehicle_id) REFERENCES Vehicles
);

CREATE TABLE Owns
  (plate_no VARCHAR(50),
   last_rec_mileage INTEGER,
   last_repair_date DATE,
   purchase_date DATE,
   vehicle_id INTEGER NOT NULL,
   email VARCHAR(50) NOT NULL,
  PRIMARY KEY (plate_no),
    FOREIGN KEY (vehicle_id)
   REFERENCES Vehicles,
    FOREIGN KEY (email)
   REFERENCES Customers
   );

CREATE TABLE Schedule
  (schedule_id INTEGER,
   start_time TIMESTAMP,
   customer_plate_no VARCHAR(50) NOT NULL,
   mechanic_id INTEGER NOT NULL,
   end_time TIMESTAMP,
   status VARCHAR(20),
  PRIMARY KEY (schedule_id),
   FOREIGN KEY (customer_plate_no)
   REFERENCES Owns,
   FOREIGN KEY (mechanic_id)
   REFERENCES Mechanic
   );
   
CREATE TABLE Maintenance
  (mid INTEGER,
   maintenance_type VARCHAR(20),
  PRIMARY KEY (mid)
   );
   
CREATE TABLE Repair
  (rid INTEGER,
   name VARCHAR(20),
   diagnostic_cost INTEGER,
  PRIMARY KEY (rid)
   );
   
CREATE TABLE Maintenance_schedule
  (maintenance_schedule_id INTEGER,
   mid INTEGER NOT NULL,
  PRIMARY KEY (maintenance_schedule_id),
    FOREIGN KEY (maintenance_schedule_id)
   REFERENCES Schedule,
   FOREIGN KEY (mid)
   REFERENCES Maintenance
   );
   
CREATE TABLE Repair_schedule
  (repair_schedule_id INTEGER,
   rid INTEGER NOT NULL,
  PRIMARY KEY (repair_schedule_id),
    FOREIGN KEY (repair_schedule_id)
   REFERENCES Schedule,
   FOREIGN KEY (rid)
   REFERENCES Repair
   );
   
CREATE TABLE Charge_type
  (charge_type_id INTEGER,
   charge_type VARCHAR(20),
   rate INTEGER,
  PRIMARY KEY (charge_type_id)
   );
   
CREATE TABLE Service
  (sid INTEGER,
   name VARCHAR(20),
   charge_type_id INTEGER NOT NULL,
   hours_to_complete INTEGER,
  PRIMARY KEY (sid),
   FOREIGN KEY (charge_type_id)
   REFERENCES Charge_type
   );
   
CREATE TABLE Maintenance_uses
  (sid INTEGER NOT NULL,
   mid INTEGER NOT NULL,
   miles INTEGER NOT NULL,
   vehicle_id INTEGER NOT NULL,
  PRIMARY KEY (sid,mid),
   FOREIGN KEY (sid)
   REFERENCES Service,
   FOREIGN KEY (mid)
   REFERENCES Maintenance,
   FOREIGN KEY(vehicle_id) 
   REFERENCES Vehicles
   );

CREATE TABLE Repair_uses
  (sid INTEGER NOT NULL,
   rid INTEGER NOT NULL,
  PRIMARY KEY (sid,rid),
   FOREIGN KEY (sid)
   REFERENCES Service,
   FOREIGN KEY (rid)
   REFERENCES Repair
   );
   
  CREATE TABLE Invoice
  (plate_no VARCHAR(50) NOT NULL,
   schedule_id INTEGER NOT NULL,
   customer_email VARCHAR(50),
  PRIMARY KEY (plate_no,schedule_id),
   FOREIGN KEY (plate_no)
   REFERENCES Owns,
   FOREIGN KEY (schedule_id)
   REFERENCES Schedule,
   FOREIGN KEY (customer_email)
   REFERENCES Customers
   );

CREATE TABLE Parts
  (part_id INTEGER,
   name VARCHAR(50) NOT NULL,
	PRIMARY KEY (part_id)
   );
   
CREATE TABLE Parts_to_make
(parts_to_make_id INTEGER,
  make VARCHAR(50),
  part_id INTEGER,
  unit_price FLOAT NOT NULL,
  warranty Integer,
  PRIMARY KEY (parts_to_make_id),
  UNIQUE(make, part_id),
  FOREIGN KEY (make) REFERENCES Make,
  FOREIGN KEY (part_id) REFERENCES Parts
);

CREATE TABLE Distributor
  (distributor_id INTEGER,
   dname VARCHAR(50) NOT NULL,
  PRIMARY KEY (distributor_id)
   );
   
CREATE TABLE Supplies
  (supply_id INTEGER,
   window INTEGER,
   parts_to_make_id INTEGER NOT NULL,
   distibutor_id INTEGER NOT NULL,
  PRIMARY KEY (supply_id),
   FOREIGN KEY (parts_to_make_id)
   REFERENCES Parts_to_make,
   FOREIGN KEY (distibutor_id)
   REFERENCES Distributor
   );
   
CREATE TABLE Orders
  (order_id INTEGER,
   quantity INTEGER,
   status VARCHAR(40),
   order_date DATE,
  PRIMARY KEY (order_id),
  CHECK (status IN ('pending','complete','delayed'))
   );

CREATE TABLE Inventory
  (inventory_id INTEGER,
   service_center_id VARCHAR(50) NOT NULL,
   parts_to_make_id INTEGER NOT NULL,
   current_quantity INTEGER,
   min_order_thold INTEGER,
   min_quant_thold INTEGER,
   PRIMARY KEY (inventory_id),
   FOREIGN KEY (service_center_id)
   REFERENCES Service_center,
   FOREIGN KEY (parts_to_make_id)
   REFERENCES Parts_to_make
   );
   
CREATE TABLE Involves
  (involves_id INTEGER,
   service_id INTEGER NOT NULL,
   part_id INTEGER NOT NULL,
   vehicle_id INTEGER NOT NULL,
   quantity INTEGER,
  PRIMARY KEY (involves_id),
   FOREIGN KEY (service_id)
   REFERENCES Service,
   FOREIGN KEY (part_id)
   REFERENCES Parts,
   FOREIGN KEY (vehicle_id)
   REFERENCES Vehicles
   );
   
CREATE TABLE Notification
  (notification_id INTEGER,
   order_id INTEGER NOT NULL,
   message VARCHAR(100),
  PRIMARY KEY (notification_id),
   FOREIGN KEY (order_id)
   REFERENCES Orders
   );

   CREATE TABLE Service_center_order
  (service_center_order_id INTEGER,
   requester_center_inventory_id INTEGER NOT NULL,
   service_center_provider_id VARCHAR(50) NOT NULL,
   order_id INTEGER NOT NULL,
  PRIMARY KEY (service_center_order_id),
   FOREIGN KEY (requester_center_inventory_id)
   REFERENCES Inventory,
   FOREIGN KEY (service_center_provider_id)
   REFERENCES Service_center,
   FOREIGN KEY (order_id)
   REFERENCES Orders
   );
   
CREATE TABLE Distributor_order
  (distributor_order_id INTEGER,
   requester_center_inventory_id INTEGER NOT NULL,
   distributor_id INTEGER NOT NULL,
   order_id INTEGER NOT NULL,
  PRIMARY KEY (distributor_order_id),
   FOREIGN KEY (requester_center_inventory_id)
   REFERENCES Inventory,
   FOREIGN KEY (distributor_id)
   REFERENCES Distributor,
   FOREIGN KEY (order_id)
   REFERENCES Orders
   );
   
--   If anything you update put a ---- line and then write here so that it can be 
-- changed in the database as well. 
-- don't just make the change in above tables. Always write separately

   