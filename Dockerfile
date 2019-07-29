#FROM postgres:11.1-alpine
#RUN mkdir /sql
#ENV POSTGRES_DB quiztest
#ENV POSTGRES_USER 'csf'
#ENV POSTGRES_PASSWORD 'KBP6WXGPS387090EZMG8'

#VOLUME ./db_initial.sql /docker-entrypoint-initdb.d/db_initial.sql
#VOLUME ./.tmp/data:/var/lib/postgresql/data

#COPY src/main/resources/sql_scripts/* /sql/

FROM minio/minio
ENV MINIO_ACCESS_KEY “KBP6WXGPS387090EZMG8”
ENV MINIO_SECRET_KEY “DRjFXylyfMqn2zilAr33xORhaYz5r9e8r37XPz3A”

#VOLUME ./.minio-data /export

FROM redis:5.0.3-alpine



