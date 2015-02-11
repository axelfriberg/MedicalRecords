#!/bin/bash
keytool -genkeypair -alias server -keystore serverkeystore
keytool -certreq -alias server -file serversignrequest.csr -keystore serverkeystore
openssl x509 -req -in serversignrequest.csr -CA CA.crt -CAkey CAprivkey.pem -out serversignedcert.crt
keytool -importcert -alias root -file CA.crt -keystore serverkeystore
keytool -importcert -trustcacerts -alias server -file serversignedcert.crt -keystore serverkeystore
$SHELL