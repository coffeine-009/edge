#- Base image -#
FROM java:8

#- Author -#
MAINTAINER Vitaliy Tsutsman <vitaliy.tsutsman@musician-virtuoso.com>

# Define dafault value of DB host
ENV DB_HOST localhost

#- Expose port -#
EXPOSE 8765

#- Run app -#
CMD [ "java", "-jar", "/opt/edge.jar" ]

#- Add jar into image -#
ADD ./build/libs/edge-*.jar /opt/edge.jar
