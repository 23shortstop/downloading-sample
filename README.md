File downloading in Lift
========================

It is a code sample for the article "File downloading in Lift", which explains two implementations of file downloading
from a server in Lift framework. The first implementation uses ResponseShortcutException and it is described in the Lift
Cookbook. The second one uses a REST service.

### Running the sample
Clone the sample, cd into the "downloading-sample" directory. Start the sbt console with the following command::
```
$ ./sbt
```
Then start a container inside the sbt console:
```
  > container:start
```
Browse to http://localhost:8080 to see running sample.

To stop a container type:
```
  > container:stop
```