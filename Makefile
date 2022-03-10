run:
	docker build -t wallmart-ui:0.0.1 wallmart-ui/
	docker build -t wallmart-api:0.0.1 wallmart-api/
	docker-compose up --build