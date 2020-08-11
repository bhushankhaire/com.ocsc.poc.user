## Copyright © 2020, Oracle and/or its affiliates. 
## All rights reserved. The Universal Permissive License (UPL), Version 1.0 as shown at http://oss.oracle.com/licenses/upl

#!/bin/bash
#sudo runuser -l opc -c "sudo docker login -u '<username>' -p '<ocir-token>' <region-prefix-name>"
sudo runuser -l opc -c 'kubectl apply -f /var/lib/jenkins/workspace/com.ocsc.poc.user/deployment.yml'
