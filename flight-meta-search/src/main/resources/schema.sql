-- create database
CREATE DATABASE flight;

-- create user and grant permission to flight database
GRANT ALL PRIVILEGES ON flight.* TO 'application'@'%' identified by 'application';

-- create airport table
CREATE TABLE `airports` (
  `id` bigint(20) NOT NULL,
  `code` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `created_at` datetime DEFAULT NULL,
  `updated_at` datetime DEFAULT NULL,
  `deleted` bit(1) DEFAULT 0,
  PRIMARY KEY (`id`),
  UNIQUE KEY `airport_code` (`code`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- create providers table
CREATE TABLE `providers` (
  `id` bigint(20) NOT NULL,
  `code` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `created_at` datetime DEFAULT NULL,
  `updated_at` datetime DEFAULT NULL,
  `deleted` bit(1) DEFAULT 0,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- create schedule table
CREATE TABLE `schedules` (
  `id` bigint(20) NOT NULL,
  `departure_airport_code` varchar(255) DEFAULT NULL,
  `provider_code` varchar(255) DEFAULT NULL,
  `arrival_airport_code` varchar(255) DEFAULT NULL,
  `base_price` decimal(19,2) DEFAULT NULL,
  `created_at` datetime DEFAULT NULL,
  `updated_at` datetime DEFAULT NULL,
  `deleted` bit(1) DEFAULT 0,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1


CREATE TABLE `hibernate_sequence` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1
