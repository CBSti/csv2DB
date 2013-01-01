csv2DB
======

Requirements
============

* [HEDL - Hibernate Entity Description Language](http://www.hibernate-dsl.org/index.php/HEDL)
* [Maven](apache.maven.org)
* MySql Database

Table Creation
==============

Because it looks like hibernate has some problems to create the table shema automatically (due to synta error for inno db 
dialect) here is what must be executed to setup the database:

```sql
CREATE TABLE `IdentityGenerator` (
  `sequence_name` varchar(100) DEFAULT NULL,
  `next_hi_value` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8
```
```sql
CREATE TABLE `location` (
  `id` int(11) NOT NULL,
  `latitude` double DEFAULT NULL,
  `locationnumber` int(11) DEFAULT NULL,
  `longitude` double DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8
```
```sql
CREATE TABLE `dataset` (
  `id` int(11) NOT NULL,
  `acquisitiondate` datetime DEFAULT NULL,
  `remark` longtext,
  `repetition` int(11) DEFAULT NULL,
  `rotation` int(11) DEFAULT NULL,
  `standingyear` int(11) DEFAULT NULL,
  `treetype` int(11) DEFAULT NULL,
  `location` int(11) DEFAULT NULL,
  `measurementvalues` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK5605B478FF8951AC` (`location`),
  KEY `FK5605B4789ED5BBDA` (`measurementvalues`),
  CONSTRAINT `FK5605B4789ED5BBDA` FOREIGN KEY (`measurementvalues`) REFERENCES `measurementvalues` (`id`),
  CONSTRAINT `FK5605B478FF8951AC` FOREIGN KEY (`location`) REFERENCES `location` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8
```
```sql
CREATE TABLE `measurementvalues` (
  `id` int(11) NOT NULL,
  `bhd_1` double DEFAULT NULL,
  `bhd_2` double DEFAULT NULL,
  `bhd_3` double DEFAULT NULL,
  `bhd_4` double DEFAULT NULL,
  `bhd_5` double DEFAULT NULL,
  `bhd_6` double DEFAULT NULL,
  `bhd_7` double DEFAULT NULL,
  `bhd_8` double DEFAULT NULL,
  `d_01_1` double DEFAULT NULL,
  `d_01_2` double DEFAULT NULL,
  `d_01_3` double DEFAULT NULL,
  `d_01_4` double DEFAULT NULL,
  `d_01_5` double DEFAULT NULL,
  `d_01_6` double DEFAULT NULL,
  `d_01_7` double DEFAULT NULL,
  `d_01_8` double DEFAULT NULL,
  `height` double DEFAULT NULL,
  `l_1` double DEFAULT NULL,
  `l_2` double DEFAULT NULL,
  `l_3` double DEFAULT NULL,
  `l_4` double DEFAULT NULL,
  `l_5` double DEFAULT NULL,
  `l_6` double DEFAULT NULL,
  `l_7` double DEFAULT NULL,
  `l_8` double DEFAULT NULL,
  `numberofsprouds` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8
```

License
========

    This program is free software: you can redistribute it and/or modify
    it under the terms of the GNU General Public License as published by
    the Free Software Foundation, either version 3 of the License, or
    (at your option) any later version.

    This program is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU General Public License for more details.

    You should have received a copy of the GNU General Public License
    along with this program.  If not, see <http://www.gnu.org/licenses/>.
