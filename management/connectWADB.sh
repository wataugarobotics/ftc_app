#! /bin/bash
#Connects ADB to a phone over WiFi Direct, given:
# - the TCP port to use [1024 to 65535]

port=$1

if [[ -z "$port" ]]; then
	echo "No port specified. Defaulting to 5555."
	port=5555
fi
adb connect "192.168.49.1:$port"
printf "\nWireless ADB Connected.\n"