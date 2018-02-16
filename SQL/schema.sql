CREATE DATABASE ih_test;

CREATE TABLE ih_test.customer (
  id int(10) unsigned NOT NULL auto_increment,
  customerName VARCHAR(64) NOT NULL,
  customerId VARCHAR(64),
  PRIMARY KEY(id)
);

CREATE TABLE ih_test.customer_detail (
  id int(10) unsigned NOT NULL auto_increment,
  customerId VARCHAR(64),
  address VARCHAR(32) NOT NULL,
  state VARCHAR(16) NOT NULL,
  zip VARCHAR(12),
  phone VARCHAR(16),
  PRIMARY KEY (id)
);

CREATE TABLE ih_test.purchases (
  id int(10) unsigned NOT NULL auto_increment,
  customerId VARCHAR(64),
  partNum VARCHAR(31) NOT NULL,
  description VARCHAR(128),
  units int(16),
  unitCost float(32),
  PRIMARY KEY (id)
);

GRANT SELECT,INSERT,UPDATE,DELETE ON ih_test.* to ih_user;