Part 2: Monitoring using Prometheus and Grafana

1) git clone https://github.com/PurvaDeekshit/AEM-Engineering-Test.git
2) cd AEM-Engineering-Test/prometheus-grafana-integration
3) mvn clean install
4) docker-compose up

Test using browser:
Check the actuator end point
http://localhost:8080/admin

Check the Prometheus actuator end point
http://localhost:8080/admin/prometheus

General actuator endpoints
http://localhost:8080/admin/health

{"status":"UP","components":{"diskSpace":{"status":"UP","details":{"total":250685575168,"free":206251069440,"threshold":10485760,"exists":true}},"ping":{"status":"UP"}}}

Check Prometheus endpoint
http://localhost:9090/graph?g0.expr=go_memstats_alloc_bytes&g0.tab=0&g0.stacked=0&g0.show_exemplars=0&g0.range_input=5m

Grafana endpoint 
http://localhost:3000/dashboard/new?orgId=1&editPanel=2&from=now-5m&to=now
