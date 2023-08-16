CREATE TABLE activity (
  activity_id INT PRIMARY KEY AUTO_INCREMENT,
  name VARCHAR(100) NOT NULL,
  description TEXT,
  image_url VARCHAR(255),
  price DECIMAL(10, 2),
  is_in_simulator TINYINT(1) DEFAULT 0,
  is_handicap_accessible TINYINT(1) DEFAULT 0,
  created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);


INSERT INTO activity (name, description, image_url, price, is_in_simulator, is_handicap_accessible)
VALUES
    ('Parachute Jump', 'Experience the thrill of freefalling from an airplane.', 'parachute_jump.jpg', 250.00, 0, 0),
    ('Bungee Jumping', 'Take the leap and feel the adrenaline rush.', 'bungee_jump.jpg', 150.00, 0, 0),
    ('White Water Rafting', 'Navigate through the rapids for an exhilarating adventure.', 'water_rafting.jpg', 80.00, 0, 0),
    ('Rock Climbing', 'Challenge yourself to scale vertical cliffs.', 'rock_climbing.jpg', 120.00, 0, 0),
    ('Indoor Skydiving', 'Experience the sensation of skydiving in a controlled wind tunnel.', 'indoor_skydiving.jpg', 100.00, 1, 1),
    ('Virtual Roller Coaster', 'Enjoy the thrills of a roller coaster in a virtual reality simulator.', 'virtual_roller_coaster.jpg', 80.00, 1, 1),
    ('Flight Simulator Experience', 'Take control of a realistic flight simulator and pilot an aircraft.', 'flight_simulator.jpg', 120.00, 1, 1),
    ('Virtual Scuba Diving', 'Explore underwater wonders through virtual reality scuba diving.', 'virtual_scuba_diving.jpg', 90.00, 1, 1),
    ('Indoor Surfing', 'Ride the waves on an indoor surfing simulator.', 'indoor_surfing.jpg', 70.00, 1, 1),
    ('Driving Simulator', 'Test your driving skills on a high-fidelity car driving simulator.', 'driving_simulator.jpg', 80.00, 1, 1);
