-- Sample data for Hospital Billing System
-- This file populates the database with test data

-- Insert sample diagnoses
INSERT INTO diagnosis (code, description, category, is_active) VALUES
('A00.0', 'Cholera due to Vibrio cholerae 01, biovar cholerae', 'Infectious Disease', true),
('I10', 'Essential (primary) hypertension', 'Cardiovascular', true),
('E11.9', 'Type 2 diabetes mellitus without complications', 'Endocrine', true),
('J45.909', 'Unspecified asthma, uncomplicated', 'Respiratory', true),
('M54.5', 'Low back pain', 'Musculoskeletal', true);

-- Insert sample physicians
INSERT INTO physician (first_name, last_name, specialty, phone_number, email, license_number) VALUES
('John', 'Smith', 'Cardiology', '(555) 123-4567', 'john.smith@hospital.com', 'MD12345'),
('Sarah', 'Johnson', 'Endocrinology', '(555) 234-5678', 'sarah.johnson@hospital.com', 'MD23456'),
('Michael', 'Williams', 'Pulmonology', '(555) 345-6789', 'michael.williams@hospital.com', 'MD34567'),
('Emily', 'Brown', 'Orthopedics', '(555) 456-7890', 'emily.brown@hospital.com', 'MD45678'),
('David', 'Davis', 'Infectious Disease', '(555) 567-8901', 'david.davis@hospital.com', 'MD56789');

-- Insert sample treatments
-- Treatments for Cholera (diagnosis_id = 1)
INSERT INTO treatment (name, description, cost, duration, diagnosis_id, code) VALUES
('Intravenous Rehydration', 'IV fluid replacement therapy', 250.00, 60, 1, 'CPT-12345'),
('Oral Rehydration Therapy', 'ORS administration and monitoring', 75.00, 30, 1, 'CPT-12346');

-- Treatments for Hypertension (diagnosis_id = 2)
INSERT INTO treatment (name, description, cost, duration, diagnosis_id, code) VALUES
('Blood Pressure Monitoring', '24-hour blood pressure monitoring', 150.00, 1440, 2, 'CPT-23456'),
('Antihypertensive Medication', 'Prescription and consultation', 100.00, 20, 2, 'CPT-23457');

-- Treatments for Diabetes (diagnosis_id = 3)
INSERT INTO treatment (name, description, cost, duration, diagnosis_id, code) VALUES
('Blood Glucose Monitoring', 'Continuous glucose monitoring setup', 300.00, 30, 3, 'CPT-34567'),
('Insulin Therapy Consultation', 'Insulin management and education', 200.00, 45, 3, 'CPT-34568'),
('Diabetic Diet Planning', 'Nutritionist consultation', 125.00, 60, 3, 'CPT-34569');

-- Treatments for Asthma (diagnosis_id = 4)
INSERT INTO treatment (name, description, cost, duration, diagnosis_id, code) VALUES
('Pulmonary Function Test', 'Spirometry and lung capacity testing', 180.00, 45, 4, 'CPT-45678'),
('Nebulizer Treatment', 'Bronchodilator nebulization', 95.00, 20, 4, 'CPT-45679');

-- Treatments for Low Back Pain (diagnosis_id = 5)
INSERT INTO treatment (name, description, cost, duration, diagnosis_id, code) VALUES
('Physical Therapy Session', 'Therapeutic exercises and manual therapy', 120.00, 60, 5, 'CPT-56789'),
('Spinal Manipulation', 'Chiropractic adjustment', 85.00, 30, 5, 'CPT-56790'),
('Pain Management Consultation', 'Assessment and treatment planning', 175.00, 40, 5, 'CPT-56791');
