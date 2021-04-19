#Documentação Swager em pasta especifica
#Swagger HUB?
      https://app.swaggerhub.com/apis/ascarneiro/Soolved/1.0.0
#Quando rodar aplicaçao pode ser acessada e testada em: http://localhost:8091/ascarneiro/Soolved/1.0.0/swagger-ui.html



#Uso da imagem Oracle 12 no Docker
# terminal com usuario root
sudo su

# Listar imagens do oracle 12c
docker search oracle

# Utiizar imagem
truevoly/oracle-12c                   Copy of sath89/oracle-12c image ......

# Baixar imagem
docker pull truevoly/oracle-12c

# Verificar se baixou imagem
docker images

# Subir container docker oracle 12c
docker run -d -p 8080:8080 -p 1521:1521 -v /u01/app/oracle truevoly/oracle-12c

#acompanhar startup do banco
docker logs -f ffbeb07058449672c640ddb4e59b8376dae2e3b4dd54142871da7adbc069ee79 {id}

# Ao receber mensagem abaixo
Database ready to use. Enjoy! ;)

#verificar se container rodando
docker ps

#Acessar container
docker exec -it ef7e5bc1c20e /bin/bash ##(ef7e5bc1c20e este ID muda)

#Acessar com usuario Oracle
su oracle

#conectar com usuario DBA
$ORACLE_HOME/bin/sqlplus / as sysdba

#baixar instancia
shutdown; 
#subir instancia
startup;

#criar tablespace usuario bspdb
create tablespace bspdb datafile '/u01/app/oracle/oradata/xe/bspdb.dbf' size 3000m;

#criar usuario bspdb
create user bspdb identified by 123456 default tablespace bspdb;

#grant dba para bspdb
grant dba, connect to bspdb;

#alterar senha usuario system
alter user system identified by system;  

#teste
exit;  -- sair do sqlplus
#obter nome do SID
lsnrctl status --Obter NOME_SERVICO DO listener (ABAIXO EXEMPLO) NESTE CASO xeXDB
#conectar no SQLPLUS com usuario bspdb

oracle@d19feac14968:/$ $ORACLE_HOME/bin/sqlplus bspdb/123456@//192.168.40.183:31995/xeXDB 



