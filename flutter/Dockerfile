FROM clojure

RUN apt-get update
RUN apt-get install -y curl git wget unzip libgconf-2-4 gdb libstdc++6 libglu1-mesa fonts-droid-fallback lib32stdc++6
RUN apt-get clean
RUN apt-get update && apt-get install -y wget gpg apt-transport-https
RUN wget -qO- https://dl-ssl.google.com/linux/linux_signing_key.pub | gpg  --dearmor -o /usr/share/keyrings/dart.gpg
RUN echo 'deb [signed-by=/usr/share/keyrings/dart.gpg arch=amd64] https://storage.googleapis.com/download.dartlang.org/linux/debian stable main' | tee /etc/apt/sources.list.d/dart_stable.list
RUN apt-get update && apt-get install -y dart
RUN clojure -Ttools install-latest :lib io.github.seancorfield/deps-new :as new

COPY flutter /flutter
COPY flutter/entrypoint.sh /entrypoint.sh

# download Flutter SDK from Flutter Github repo
RUN git clone https://github.com/flutter/flutter.git /usr/local/flutter

# Set flutter environment path
ENV PATH="/usr/local/flutter/bin:/usr/local/flutter/bin/cache/dart-sdk/bin:${PATH}"

# Run flutter doctor
RUN flutter doctor

# Enable flutter web
RUN flutter channel master
RUN flutter upgrade
RUN flutter config --enable-web

ENTRYPOINT /entrypoint.sh
# something like this : clj -M:cljd flutter -d web-server --web-port=1234
