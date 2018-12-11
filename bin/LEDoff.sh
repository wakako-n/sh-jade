#!/usr/bin/env bash
echo -n "12" > /sys/class/gpio/export
echo -n "out" > /sys/class/gpio/gpio12/direction
echo -n "0" > /sys/class/gpio/gpio12/value    
echo -n "12" > /sys/class/gpio/unexport
   
