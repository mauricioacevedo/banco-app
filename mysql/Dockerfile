# imagen mysql de dockerhub 
FROM mysql:8

RUN ["sed", "-i", "s/exec \"$@\"/echo \"not running $@\"/", "/usr/local/bin/docker-entrypoint.sh"]


ENV MYSQL_ROOT_PASSWORD=123456 MYSQL_DATABASE=banco

# add initial script to database
COPY ./scripts/ /docker-entrypoint-initdb.d/

RUN ["/usr/local/bin/docker-entrypoint.sh", "mysqld", "--datadir", "/initialized-db"]