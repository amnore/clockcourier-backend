CUR_TIME    := $(shell date +"%Y-%m-%d_%H.%M.%S")
PROD_CONFIG := /home/xiayi/SE3/backend/application-prod.yml
RESOURCE    := ./src/main/resources
MVN         := ./mvnw
MVN_ARG     := -P prod
PROJ_NAME   := lmcc-backend

.PHONY: all prepare clean build test deploy

all: prepare clean build test deploy

prepare:
        @echo "== Prepare =="
        cp $(PROD_CONFIG) $(RESOURCE)

clean:
        @echo "== Clean =="
ifneq ($(shell docker ps | grep $(PROJ_NAME)),)
        docker stop $(PROJ_NAME)
endif
ifneq ($(shell docker ps -a | grep $(PROJ_NAME)),)
        docker rm $(PROJ_NAME)
endif
ifeq ($(shell docker images | grep $(PROJ_NAME) | wc -l),10)
        docker rmi `docker images | grep $(PROJ_NAME) | awk '{print $$3}'`
endif
        # $(MVN) clean $(MVN_ARG)

build:
        @echo "== Build =="
        $(MVN) install $(MVN_ARG) -DskipTests

test:
        @echo "== Test =="
        $(MVN) test $(MVN_ARG)

deploy:
        @echo "== Deploy =="
        docker build -t se3/$(PROJ_NAME):$(CUR_TIME) .
        docker run -d -p 8082:8082 --name $(PROJ_NAME) se3/$(PROJ_NAME):$(CUR_TIME)
