FROM clojure

RUN apt-get update && apt-get install -y wget gpg apt-transport-https
RUN wget -qO- https://dl-ssl.google.com/linux/linux_signing_key.pub | gpg  --dearmor -o /usr/share/keyrings/dart.gpg
RUN echo 'deb [signed-by=/usr/share/keyrings/dart.gpg arch=amd64] https://storage.googleapis.com/download.dartlang.org/linux/debian stable main' | tee /etc/apt/sources.list.d/dart_stable.list
RUN apt-get update && apt-get install -y dart
RUN clojure -Ttools install-latest :lib io.github.seancorfield/deps-new :as new

COPY dart-cli /dart-cli
COPY dart-cli/entrypoint.sh /entrypoint.sh

ENTRYPOINT /entrypoint.sh
