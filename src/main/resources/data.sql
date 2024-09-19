-- Create 'diagnosis' table
CREATE TABLE diagnosis (
  id INT PRIMARY KEY AUTO_INCREMENT,
  name VARCHAR(255) NOT NULL,
  price DECIMAL(10, 2) NOT NULL
);

-- Insert diagnoses
INSERT INTO diagnosis (name, price) VALUES
  ('Headache', 50.00),
  ('Fever', 40.00),
  ('Fracture', 150.00);

----------------------------------------

-- Create 'physician' table
CREATE TABLE physician (
  id INT PRIMARY KEY AUTO_INCREMENT,
  name VARCHAR(255) NOT NULL,
  specialization VARCHAR(255) NOT NULL
);

-- Insert physicians
INSERT INTO physician (name, specialization) VALUES
  ('Dr. Smith', 'Neurologist'),
  ('Dr. Johnson', 'Pediatrician'),
  ('Dr. Davis', 'Orthopedic Surgeon');

-----------------------------------------

-- Create 'treatment' table
CREATE TABLE treatment (
  id INT PRIMARY KEY AUTO_INCREMENT,
  name VARCHAR(255) NOT NULL,
  price DECIMAL(10, 2) NOT NULL,
  diagnosis_id INT NOT NULL,
  FOREIGN KEY (diagnosis_id) REFERENCES diagnosis (id)
);

-- Insert treatments
INSERT INTO treatment (name, price, diagnosis_id) VALUES
  ('Medication', 20.00, 1),
  ('Physical Therapy', 30.00, 3),
  ('Surgery', 100.00, 3);
