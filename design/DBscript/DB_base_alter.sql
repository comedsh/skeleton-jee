ALTER TABLE `user_address` 
DROP COLUMN `City_Area_ID`,
ADD COLUMN `province_id` BIGINT(20) NULL COMMENT '' AFTER `last_Modified_by`,
ADD COLUMN `city_id` BIGINT(20) NULL COMMENT '' AFTER `province_id`,
ADD COLUMN `area_id` BIGINT(20) NULL COMMENT '' AFTER `city_id`,
ADD COLUMN `province_name` VARCHAR(100) NULL COMMENT '' AFTER `area_id`,
ADD COLUMN `city_name` VARCHAR(100) NULL COMMENT '' AFTER `province_name`,
ADD COLUMN `area_name` VARCHAR(100) NULL COMMENT '' AFTER `city_name`;