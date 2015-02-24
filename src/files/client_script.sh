#!/bin/bash
openssl req -x509 -newkey rsa:1024 -keyout CAprivkey.pem -out CA.crt
keytool -import -file CA.crt -alias firstCA -keystore clienttruststore
keytool -genkeypair -alias client -keystore clientkeystore
keytool -certreq -alias client -file signrequest.csr -keystore clientkeystore
openssl x509 -req -in signrequest.csr -CA CA.crt -CAkey CAprivkey.pem -out signedcert.crt -CAcreateserial
keytool -importcert -alias root -file CA.crt -keystore clientkeystore
keytool -importcert -trustcacerts -alias client -file signedcert.crt -keystore clientkeystore
$SHELL

# How to create a new user, change ID in the code below to something that is logical for your needs. Must be run from files dir.
# keytool -genkeypair -alias ID -keystore IDkeystore
# keytool -certreq -alias ID -file IDsignrequest.csr -keystore IDkeystore
# openssl x509 -req -in IDsignrequest.csr -CA CA.crt -CAkey CAprivkey.pem -out IDsignedcert.crt
# keytool -importcert -alias root -file CA.crt -keystore IDkeystore
# keytool -importcert -trustcacerts -alias ID -file IDsignedcert.crt -keystore IDkeystore