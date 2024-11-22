--delete user if exists
DROP USER IF EXISTS 'admin_ensf480_movies_db'@'%'; 
-- Create the admin user
CREATE USER 'admin_ensf480_movies_db'@'%' IDENTIFIED BY 'oop';
GRANT ALL PRIVILEGES ON ensf480_term_project_movies_db.* TO 'admin_ensf480_movies_db'@'%';

-- Apply changes to ensure the privileges take effect
FLUSH PRIVILEGES;

-- command to see if user exists
SELECT User, Host FROM mysql.user;
