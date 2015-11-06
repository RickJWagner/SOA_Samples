
The REST svc can be deployed to EAP (i.e. 6.1.1).  Call it like this:  http://localhost:8080/REST_Svc/rest/members/1

The SY service must have the reference configured to point to the backend svc.  SY can be called like this:
http://localhost:8080/member-binding/member

or 

curl --data "" http://localhost:8080/member-binding/member

