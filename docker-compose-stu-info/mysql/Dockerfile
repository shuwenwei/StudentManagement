FROM mysql
ENV WORK_PATH /usr/local

ENV MYSQL_ROOT_PASSWORD 123456

ENV AUTO_RUN_DIR /docker-entrypoint-initdb.d

ENV MYSQL_FILE stu_db.sql

ENV INSTALL_DATA_SHELL mysql-entrypoint.sh

COPY ./$MYSQL_FILE $WORK_PATH/
COPY ./$INSTALL_DATA_SHELL $AUTO_RUN_DIR/

RUN chmod a+x $AUTO_RUN_DIR/$INSTALL_DATA_SHELL
