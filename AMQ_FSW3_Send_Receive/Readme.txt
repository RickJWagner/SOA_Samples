
3 projects used to demonstrate A-MQ processing with SwitchYard.

Message sender reads a file, splits each line into a message and sends to a queue.

Gateway gets message from Sender, sends to Dispatcher.

Dispatcher reads message from Gateway, writes it out to console.


