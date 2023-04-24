FROM mysql:8
WORKDIR /workspace
COPY ./init-mysql.sql /docker-entrypoint-initdb.d/
EXPOSE 3306