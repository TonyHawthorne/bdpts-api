# BPDTS API Reference
DWP interview API calling the API at the below URL in order to return people living in or within 50 miles of London.

`https://bpdts-test-app.herokuapp.com/`

# Instructions
Instructions for the task are describe here:
`https://bpdts-test-app.herokuapp.com/instructions`


# Overview

The code found here is written using Java, Spring and maven.
Loading the code into a suitable IDE and running the main application will run a local
tomcat webserver at localhost:8080.

# API

` GET localhost:8080/users/london`
` GET localhost:8080/users/london/within/50`

The above URLs will produce the required data, provided the underlying APIs are currently
available.

# Returned JSON Data Format
Below JSON represents a typical returned dataset, formatted here for readability.
[
  {
    "id":266,
    "first_name":"Ancell",
    "last_name":"Garnsworthy",
    "email":"agarnsworthy7d@seattletimes.com",
    "ip_address":"67.4.69.137",
    "latitude":51.6553959,
    "longitude":0.0572553
  },
  {
    "id":322,
    "first_name":"Hugo",
    "last_name":"Lynd",
    "email":"hlynd8x@merriam-webster.com",
    "ip_address":"109.0.153.166",
    "latitude":51.6710832,
    "longitude":0.8078532
  },
  ...
]

# Deployment 
Altering the maven targets to create war files would build a deployable web archive file
which can be deployed to any number of target servers.
It would be advisable to pull the source and run the build via a suitable CI tool such as Jenkins
which would potentially be configured for deployment too, or perhaps you may use Ansible, depending on the platform and how many deployment points you have. 

# Security
Security is not enabled in this Spring Boot application by default, however adding spring-boot-starter-security as a maven dependency would cause all URLs to automatically be locked down until or unless further authentication code is added. Personally I have not used this before but I understand a useful guide to template this can be found here, only you'd need to customise of course:
https://spring.io/guides/gs/securing-web/ 


# Miscellaneous
Test coverage
Test coverage is partial at this point and would need to be expanded into mocking further responses, including checking for http 200 status on successful calls as well as simulating a few invalid calls and catching the expected responses.
Caching
In a simliar real-world environment there might be scope for caching a few things in this implementation, perhaps the users themselves with some sort of time-to-live that still allowed for updates to user data, and perhaps the results of the distance between two points calculations could also be considered, however further discussion and testing would be required.

