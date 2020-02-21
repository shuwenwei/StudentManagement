create_db_sql="create database if not exists stu_db;"
mysql -uroot -p123456 -e "${create_db_sql}"
mysql -uroot -p123456 -D stu_db < /usr/local/stu_db.sql