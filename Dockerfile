FROM jbangdev/jbang-action
COPY ["Application.java", "application.properties", "/"]
CMD ["Application.java"]