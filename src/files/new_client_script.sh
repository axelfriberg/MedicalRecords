#!/bin/bash
# How to create a new user, change $1 in the code below to something that is logical for your needs. Must be run from files dir.
keytool -genkeypair -alias $1 -keystore $1keystore
keytool -certreq -alias $1 -file $1signrequest.csr -keystore $1keystore
openssl x509 -req -in $1signrequest.csr -CA CA.crt -CAkey CAprivkey.pem -out $1signedcert.crt
keytool -importcert -alias root -file CA.crt -keystore $1keystore
keytool -importcert -trustcacerts -alias $1 -file $1signedcert.crt -keystore $1keystore
$SHELL