#!/bin/bash

[ ! -d "./bin" ] && mkdir ./bin
[ ! "$(ls -A ./bin)" ] && javac -d bin src/*.java src/model/*.java

cd bin

java Runner
