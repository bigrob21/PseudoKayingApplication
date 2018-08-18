#!/bin/sh
## M3_HOME_REPO should be where your .m2 location is stashed, in most installs it is $HOME/.m2/repository
export M3_REPO_HOME=$HOME/.m2
echo "Setting M3_REPO_HOME to $M3_REPO_HOME"
docker build -t ums .
echo "***** DONE *****"
sleep 2
docker image prune -f
docker images
sleep 2

