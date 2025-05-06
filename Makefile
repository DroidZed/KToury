#IMAGE_TAG=latest
include .env

build:
	docker build . -t droidzed/ktoury:$(IMAGE_TAG)

clean:
	.\gradlew clean