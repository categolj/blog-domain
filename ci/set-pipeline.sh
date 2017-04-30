#!/bin/sh
echo y | fly -t home sp -p blog-blog-domain -c pipeline.yml -l ../../credentials.yml
