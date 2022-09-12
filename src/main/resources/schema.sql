Drop table monitorsensors.monitorsensors;
Drop table monitorsensors.sensor_types;

CREATE TABLE IF NOT EXISTS monitorsensors.monitorsensors (
  id INT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
  name VARCHAR(30),
  model VARCHAR(15),
  range_from INT,
  range_to INT,
  type_id INT UNSIGNED,
  description VARCHAR(200),
  FOREIGN KEY (type_id) REFERENCES sensor_types(id)
) engine=InnoDB;

INSERT IGNORE INTO monitorsensors.monitorsensors VALUES (1, 'sensor1','model1',1,200,1,'model1');
INSERT IGNORE INTO monitorsensors.monitorsensors VALUES (2, 'sensor2','model2',1,300,2,'model2');
INSERT IGNORE INTO monitorsensors.monitorsensors VALUES (3, 'sensor3','model3',1,500,2,'model3');

CREATE TABLE IF NOT EXISTS monitorsensors.sensor_types (
  id INT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
  type VARCHAR(30)
) engine=InnoDB;

INSERT IGNORE INTO monitorsensors.sensor_types VALUES (1, 'type1');
INSERT IGNORE INTO monitorsensors.sensor_types VALUES (2, 'type2');