
### How to install MySQL 8 by Yum

# Install Yum repository
wget https://dev.mysql.com/get/mysql80-community-release-el7-1.noarch.rpm
yum localinstall mysql80-community-release-el7-1.noarch.rpm
 
# Update Yum
yum clean all
yum makecache
 
# Install Mysql server
yum install mysql-community-server
 
# Start Mysql service
systemctl start mysqld
 
# Use the 
cat /var/log/mysqld.log | grep password
···