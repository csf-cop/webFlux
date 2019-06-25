up: build
	@docker-compose up -d app

stop:
	@docker-compose stop

build:
	@docker-compose build app

clean:
	@docker ps -aq -f status=exited | xargs docker rm
	@docker images -q -f dangling=true | xargs docker rmi
	@find . -name "__pycache__" | xargs rm -rf

clean-data:
	@rm -rf ./.tmp/data

clean-all: clean clean-data