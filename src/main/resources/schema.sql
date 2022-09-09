Drop table monitorsensors.monitorsensors;

CREATE TABLE IF NOT EXISTS monitorsensors.monitorsensors (
  id INT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
  name VARCHAR(30),
  model VARCHAR(15),
  range_from INT,
  range_to INT,
  type VARCHAR(15),
  description VARCHAR(200)
) engine=InnoDB;

INSERT IGNORE INTO monitorsensors.monitorsensors VALUES (1, 'sensor1','model1',1,200,'type1','model1');
INSERT IGNORE INTO monitorsensors.monitorsensors VALUES (2, 'sensor2','model2',1,300,'type2','model2');
INSERT IGNORE INTO monitorsensors.monitorsensors VALUES (3, 'sensor3','model3',1,500,'type2','model3');