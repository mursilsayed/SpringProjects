export JAVA_OPTS="
-Dcom.sun.management.jmxremote
-Dcom.sun.management.jmxremote.local.only=false
-Dcom.sun.management.jmxremote.authenticate=false
-Dcom.sun.management.jmxremote.port=9000
-Dcom.sun.management.jmxremote.rmi.port=9000
-Djava.rmi.server.hostname=127.0.0.1
-Dcom.sun.management.jmxremote.ssl=false"