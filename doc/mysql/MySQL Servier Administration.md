MySQL Servier Administration

Overview

- Server configuration
- The data directory,particularly the mysql system database
- The server log files
- Management of multiple servers on a single machine

mysqld is the MySQL server

mysqld  configuration

- Startup options that the server support. Command line or configuration files

- Server system variables. Current status and values of startup options

  ```
  mysql> SHOW VARIABLES;
  or
  shell> mysqladmin variables;
  ```

  

- Server status variables. Counters and statistics about runtime operation

  ```
  mysql> SHOW STATUS;
  or
  shell mysqladmin extended-status
  ```

  

- How to set the server SQL mode

- Configuring and using IPv6 support

- Configuring and using time zone support

- Server-side help capabilities

- The server shutdown process.There are performance and reliability considerations depending on the type of table(transational or nontransactional) and whether you use relication.

iterm

Command options,system variables, status variables etc...

Performance Schema:monitoring information

Sys schema:is a set of objects that provide convenient access to data collected by the Performance Schema

Two most important variables : key_buffer_size,table_open_cache

```
shell> mysqld_safe --key_buffer_size=384M --table_open_cache=4000 --sort_buffer_size=4M --read_buffer_size=1M &
```



Option file on windows named my.ini,it included in installation directory.

For non-windows platforms,no default option  file is created during either th server installation or the data directory initialization process.

Some items displayed by the "mysqld --verbose --help" do not appear in SHOW VARIABLES output; this is because they are option only and not system variables






























