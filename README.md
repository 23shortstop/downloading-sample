File downloading in Lift
========================

Code sample for the article "File downloading in Lift".
This sample shows few implementations of file downloading from a server in Lift framework. The first implementation uses
ResponseShortcutException described in the Lift Cookbook. The second one shows how to create a REST service which can be
used for file downloading.

### Running the sample
Clone the sample, cd into the "downloading-sample" directory. Then type:
```
$ ./sbt
  > container:start
```
and you should be able to browse to http://localhost:8080 and see running sample.
