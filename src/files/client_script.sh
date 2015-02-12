#!/bin/bash
openssl req -x509 -newkey rsa:1024 -keyout CAprivkey.pem -out CA.crt
keytool -import -file CA.crt -alias firstCA -keystore clienttruststore
keytool -genkeypair -alias client -keystore clientkeystore
keytool -certreq -alias client -file signrequest.csr -keystore clientkeystore
openssl x509 -req -in signrequest.csr -CA CA.crt -CAkey CAprivkey.pem -out signedcert.crt -CAcreateserial
keytool -importcert -alias root -file CA.crt -keystore clientkeystore
keytool -importcert -trustcacerts -alias client -file signedcert.crt -keystore clientkeystore
$SHELL