[![Build Status](https://travis-ci.org/avionipevaju/AudiosphereConnector.svg?branch=master)](https://travis-ci.org/avionipevaju/AudiosphereConnector)
# AudiosphereConnector
Java OSGI project that relies heavily on Apache Camel framework which enables integration with Audiosphere platform. https://github.com/avionipevaju/Audiosphere

## Getting Started

These instructions will get you a copy of the project up and running on your local machine for development and testing purposes. See deployment for notes on how to deploy the project on a live system.

### Prerequisites

Before running AudiosphereConnector locally the following requirements must be met
  - Apache Karaf container setup on your local machine

### Installing

1. Download latest Apache Karaf runtime from https://karaf.apache.org/download.html and unpack

```
wget -P opt/  https://www-eu.apache.org/dist/karaf/4.2.2/apache-karaf-4.2.2.tar.gz

```

2. Unpack Apache Karaf archive

```
tar xvzf opt/test/apache-karaf-4.2.2.tar.gz -C opt
```

3. Build project - Run maven install inside project directory

```
mvn clean install
```

4. Start Karaf and install AudiosphereConnector

```
cd opt/apache-karaf-4.2.2
./bin/start
./bin/client
```
You will be displayed a Karaf console. Inside the console run

```
feature:repo-add mvn:org.avionipevaju.audiosphere/audiosphere-core/1.0.0/xml/features
feature:install audiosphere-core
```
You can check the logs if everything is correctly started

```
console:log tail
```

End with an example of getting some data out of the system or using it for a little demo


## Built With

* [Apahce Camel](http://camel.apache.org/) - Java Integration Framework
* [Maven](https://maven.apache.org/) - Dependency Management
* [Karaf](https://karaf.apache.org/) - Container in which the project is depolyed
