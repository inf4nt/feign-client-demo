ROOT_DIR=$PWD

cd $ROOT_DIR/api
docker build -t api-feign-client-demo .

cd $ROOT_DIR/client
docker build -t client-feign-client-demo .

cd $ROOT_DIR

docker compose up -d