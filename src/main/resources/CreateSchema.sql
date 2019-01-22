create tablespace virtual_univeristy 
    datafile 'virtual_univeristy.dat'
    size 10M autoextend on;

create temporary tablespace virtual_univeristy_temp
    tempfile 'virtual_univeristy_temp.dat'
    size 5M autoextend on;
    
CREATE USER VirtualUniveristy
    IDENTIFIED BY qwerty123
    DEFAULT TABLESPACE virtual_univeristy
    TEMPORARY TABLESPACE virtual_univeristy_temp;
  
  
GRANT create session TO VirtualUniveristy;
GRANT create table TO VirtualUniveristy;
GRANT create view TO VirtualUniveristy;
GRANT create any trigger TO VirtualUniveristy;
GRANT create any procedure TO VirtualUniveristy;
GRANT create sequence TO VirtualUniveristy;
GRANT create synonym TO VirtualUniveristy;
grant unlimited tablespace to VirtualUniveristy;
GRANT CONNECT, RESOURCE, DBA TO VirtualUniveristy;