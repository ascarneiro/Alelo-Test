## Oracle 12C XE Docker

* The persistent data are located in the volume created with docker-compose file.
* Run instance of docker 12c
  ```bash
   docker-compose up -d
  ```
* Exec bash into docker container
  ```bash
  docker-compose exec oracle bash
  ```
* Exec sqlplus: once in the docker-container exec
  ```bash
  sqlplus system/oracle
  ```


* [image](https://hub.docker.com/r/truevoly/oracle-12c/)
