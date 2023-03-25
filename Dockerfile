FROM jbangdev/jbang-action
COPY ["Application.java", "application.properties", "/"]
CMD ["Application.java"]
EXPOSE 8080