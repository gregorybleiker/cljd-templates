#!/bin/bash
# Read options and corresponding values
while getopts "u:n:" option; do
    case "$option" in
        n) Name=${OPTARG};;
        u) User=${OPTARG};;
    esac
done

echo "creating ${User}/${Name} project"
clojure -Tnew create :template com.github.gregorybleiker/cljd-templates%flutter%clojuredart/flutter :name $User/$Name
