#- Base image -#
FROM java:8

#- Author -#
MAINTAINER Vitaliy Tsutsman <vitaliy.tsutsman@musician-virtuoso.com>

#- Create app dir -#
RUN mkdir /opt/edge

# Define dafault value of DB host
ENV DB_HOST localhost

#- Set up work dir -#
WORKDIR /opt/edge

#- Expose port -#
EXPOSE 8765

#- Run app -#
CMD [ "java", "-jar", "/usr/src/edge.jar" ]

#- Add jar into image -#
ADD ./build/libs/edge-1.0.1-SNAPSHOT.jar /usr/src/edge.jar
