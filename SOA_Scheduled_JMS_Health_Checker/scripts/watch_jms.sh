#!/bin/bash

# This script can be used to detect server lock-ups or other problems.
# It works by making sure no 'marker file' exists, then sleeping for a while.
# In the meantime, a server process should write out the 'marker file'.
# If no file exists when this script re-awakens, something is wrong.  If the file does exist, then the server process is healthy.
# The script can be run by cron.  Suggested timings:
# - Have the server replace the file every 20 or 30 seconds.
# - Have this script run every minute, and sleep for 50 seconds.  This should leave plenty of time for normal processing times.

JMS_PROOF_OF_LIFE_FILE=/home/rick/Junk/jms_check.log

echo "Deleting file, if it exists"
rm -rf $JMS_PROOF_OF_LIFE_FILE

# sleep for a while, longer than the time period the ESB application should need to write the file back

echo "About to sleep 50 seconds"
sleep 50s

echo "Now checking for $JMS_PROOF_OF_LIFE_FILE.  If the server is frozen, then no file should be there"

if [ -f $JMS_PROOF_OF_LIFE_FILE ]; then
   echo "File is there, JMS is working"
else
   echo "File does not exist, JMS check process fails.  Something is wrong!"
fi