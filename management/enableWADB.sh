#! /bin/bash
#Enables Wireless ADB for the phone currently connected via USB, given:
# - the TCP port to use [1024 to 65535]

port=$1

if [[ -z "$port" ]]; then
	echo "No port specified. Defaulting to 5555."
	port=5555
fi
adb tcpip ${port}
printf "\nWireless ADB Enabled.\n"