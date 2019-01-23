#!/bin/sh

set -e

sbt "project scommons-examples-puzzle15" clean fullOptJS::webpack
cp "puzzle15/target/scala-2.12/scalajs-bundler/main/styles/scommons-examples-puzzle15-opt.css" "docs/assets/styles/scommons-examples-puzzle15-opt.css"
cp "puzzle15/target/scala-2.12/scalajs-bundler/main/scommons-examples-puzzle15-opt-library.js" "docs/assets/scommons-examples-puzzle15-opt-library.js"
cp "puzzle15/target/scala-2.12/scalajs-bundler/main/scommons-examples-puzzle15-opt-loader.js" "docs/assets/scommons-examples-puzzle15-opt-loader.js"
cp "puzzle15/target/scala-2.12/scalajs-bundler/main/scommons-examples-puzzle15-opt.js" "docs/assets/scommons-examples-puzzle15-opt.js"

sbt "project scommons-examples-server" clean package
cp -r "server/target/web/web-modules/main/webjars/lib/scommons-client-assets" "docs/assets/lib/"
