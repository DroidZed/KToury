include .env

image:
	docker build -t droidzed/ktoury:$(IMAGE_TAG) .

clean:
	.\gradlew clean

up:
	docker compose up -d

down:
	docker compose down

keycloak:
	kc start-dev
