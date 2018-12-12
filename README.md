# smarthome

`$ cd /galileo-copy/smarthome/src`

`$ javac -b ../bin -cp ↓(copy follow path) @srcfiles`

/smarthome/lib/jess.jar:/smarthome/lib/jade.jar:/smarthome/src/utils:/smarthome/src/smarthome/agent:src/smarthome/ontology:/galileogen2-gpio/src


`$ cd /galileo-copy/smarthome/bin`

`$ java -cp ↓(copy follow path) utils/Start`

/smarthome/bin:/galileogen2-gpio/bin:/smarthome/lib/jade.jar:/smarthome/lib/jess.jar:/smarthome/bin/smarthome/agent:/smarthome/bin/smarthome/ontology:/smarthome/bin/utils

This program can only light the LED when Analog lightning sensor get the low value, and can not be turned off now.
If you can run LEDoff.sh at /bin directory, you can get off LED.
