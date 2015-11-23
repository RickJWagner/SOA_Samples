This directory contains 2 projects that can demonstrate SwitchYard calling a REST application protected by basic authentication.


---------------------------------------------------------------------
The first project is 'A_RESTAPP_wBasicAuth'.  It is based on the 'tasks-rs' EAP quickstart.  It packages a REST application that offers a method:
http://localhost:8280/A_REST_wBASIC_AUTH/greet/Rick

This call should get back a response:
Hello Rick

This project uses BASIC authentication, looking for the role 'guest'.  This can be accomplished by using the 'add-user.sh' script for EAP.

The entire exchange (captured on TcpMon) will look something like this:

GET /A_REST_wBASIC_AUTH/greet/Rick HTTP/1.1
Host: 127.0.0.1:8280
Connection: keep-alive
User-Agent: Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/46.0.2490.80 Safari/537.36
Authorization: Basic Z3Vlc3Q6UGFzc3dvcmQxIQ==
Accept: */*
Accept-Encoding: gzip, deflate, sdch
Accept-Language: en-US,en;q=0.8


HTTP/1.1 200 OK
Server: Apache-Coyote/1.1
Pragma: No-cache
Cache-Control: no-cache
Expires: Wed, 31 Dec 1969 18:00:00 CST
Content-Type: text/xml
Content-Length: 10
Date: Mon, 23 Nov 2015 19:37:31 GMT

Hello Rick

------------------------------------------------------------------------


The second application is 'A_REST_wBASICAUTH_SY'.  It uses a cron timer to produce an incoming message, a Bean component to do something, and a REST reference that calls the BASIC AUTH protected service.


