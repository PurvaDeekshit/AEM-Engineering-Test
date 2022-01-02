Part 4 : EFK integration
1) git clone https://github.com/PurvaDeekshit/AEM-Engineering-Test.git
2) cd AEM-Engineering-Test/efk-integration
3) mvn clean install
4) docker-compose up
5) After all docker containers started successfully, test application running: http://localhost:8080/romannumeral?query=10
6) Check elasticsearch running:  http://localhost:9200/
    Expected output:
   {
  "name" : "a46aa09e30e3",
  "cluster_name" : "docker-cluster",
  "cluster_uuid" : "xnkMxG74RXqjcwnnAowfzg",
  "version" : {
    "number" : "7.13.1",
    "build_flavor" : "default",
    "build_type" : "docker",
    "build_hash" : "9a7758028e4ea59bcab41c12004603c5a7dd84a9",
    "build_date" : "2021-05-28T17:40:59.346932922Z",
    "build_snapshot" : false,
    "lucene_version" : "8.8.2",
    "minimum_wire_compatibility_version" : "6.8.0",
    "minimum_index_compatibility_version" : "6.0.0-beta1"
  },
  "tagline" : "You Know, for Search"
}
7) Check Kibana running : http://localhost:5601/app/home
8) Create index pattern with “fluentd-*”
9) Go to Analytics -> Discover section.
Test url :http://localhost:8080/romannumeral?query=123
