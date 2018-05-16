Overview:
=========
  
  This is an example application that demonstrates writing and reading a JMS message on a scheduler.  
  The JMS message is then consumed and a flat file is written out.

  This is useful if a second process is polling for the flat file.  (See example 'watch_jms.sh', included here.)
  
  
  The second process could:

  - Delete the file it is watching for.
  - Sleep some amount of time, enough to reasonably allow this ESB application to replace the file.
  - Go looking for the file.  If it is there, we know the ESB application wrote it and thus the components
  the ESB uses (i.e. JMS) are working.  But if the file is NOT there, then we know this ESB application is 
  not healthy, so we should look for reasons why this might be.
