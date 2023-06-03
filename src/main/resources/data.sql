-- Create 'diagnosis' table
CREATE TABLE diagnosis (
  id INT PRIMARY KEY,
  name VARCHAR(255) NOT NULL,
  price DECIMAL(10, 2) NOT NULL
);

-- Insert diagnoses
INSERT INTO diagnosis (id, name, price) VALUES
  (1, 'Headache', 50.00),
  (2, 'Fever', 40.00),
  (3, 'Fracture', 150.00);


----------------------------------------

-- Create   'physician' table
CREATE TABLE physician (
  id INT PRIMARY KEY,
  name VARCHAR(255) NOT NULL,
  specialization VARCHAR(255) NOT NULL
);


-- Insert  physicians
INSERT INTO physician (id, name, specialization) VALUES
  (1, 'Dr. Smith', 'Neurologist'),
  (2, 'Dr. Johnson', 'Pediatrician'),
  (3, 'Dr. Davis', 'Orthopedic Surgeon');

-----------------------------------------

-- Create 'treatment' table
CREATE TABLE treatment (
  id INT PRIMARY KEY,
  name VARCHAR(255) NOT NULL,
  price DECIMAL(10, 2) NOT NULL,
  diagnosis_id INT NOT NULL,
  FOREIGN KEY (diagnosis_id) REFERENCES diagnosis (id)
);


-- Insert  treatments
INSERT INTO treatment (id, name, price, diagnosis_id) VALUES
  (1, 'Medication', 20.00, 1),
  (2, 'Physical Therapy', 30.00, 3),
  (3, 'Surgery', 100.00, 3);
