-- USER DDL
   CREATE TABLE users ( 
      id SERIAL PRIMARY KEY,
      username VARCHAR(100) UNIQUE NOT NULL, 
      email VARCHAR(100) UNIQUE NOT NULL, 
      password bytea NOT NULL, 
      profile VARCHAR(100), 
      salt bytea NOT NULL, 
      rating int DEFAULT 0,
      createdon TIMESTAMP DEFAULT current_timestamp
      );
