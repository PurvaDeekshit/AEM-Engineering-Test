**Part 2: Monitoring using Prometheus and Grafana**

**Steps to run:**

1) git clone https://github.com/PurvaDeekshit/AEM-Engineering-Test.git
2) cd AEM-Engineering-Test/prometheus-grafana-integration
3) mvn clean install
4) docker-compose up

Test using browser:

1) Check the actuator endpoint:
http://localhost:8080/admin

2) General actuator endpoints:
http://localhost:8080/admin/health

{"status":"UP","components":{"diskSpace":{"status":"UP","details":{"total":250685575168,"free":206251069440,"threshold":10485760,"exists":true}},"ping":{"status":"UP"}}}

3) Check the Prometheus actuator endpoint:
http://localhost:8080/admin/prometheus

4) Check Prometheus endpoint:
http://localhost:9090/graph?g0.expr=go_memstats_alloc_bytes&g0.tab=0&g0.stacked=0&g0.show_exemplars=0&g0.range_input=5m

5) Check Grafana endpoint: 
http://localhost:3000/login

    5.1) Give Username and Password as “admin”.

    5.2) Click “Skip” on the “ Create New Password” page.

    5.3) From the icon list on the left side of the “New Dashboard” page, click on     Configuration -> Data sources -> Add data source -> Prometheus -> Select.

    5.4) On the “Settings” page, in the HTTp section, paste the URL as: http://host.docker.internal:9090.

    5.5) Click on “Save & test”.

    5.6) From the icon list on the left side, click on Create -> Dashboard -> Add a new panel.

    5.7) Add the required metrics for checking the logs on the web service by selecting the parameters from “Metrics browser”.

    5.8) To add more parameters, click on “+Query”.

    5.9) Click on “Apply” and the logs will be displayed on the dashboard, specifying the usage and requests that are generated on the web service.
