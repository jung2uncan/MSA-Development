#!/bin/bash

kubectl config set-context --current --namespace=$HASH

echo fs.inotify.max_user_watches=524288 | sudo tee -a /etc/sysctl.conf && sudo sysctl -p
#
## start zookeeper
$kafka_home/bin/zookeeper-server-start.sh -daemon $kafka_home/config/zookeeper.properties &
#
## start kafka broker
$kafka_home/bin/kafka-server-start.sh -daemon $kafka_home/config/server.properties &

node /home/theia/src-gen/backend/main.js /home/project --hostname=0.0.0.0

#yarn theia start /home/project --hostname=0.0.0.0
#mkdir /root/.theia
#echo '{"workbench.colorTheme": "light","workbench.iconTheme": "theia-file-icons"}' > /root/.theia/settings.json
