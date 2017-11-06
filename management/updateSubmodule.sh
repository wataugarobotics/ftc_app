#! /bin/bash
cd ../

git subtree pull --squash --prefix=[nameOfSubmoduleRepo]/ [nameOfSubmoduleRepo] master

echo "Sync Complete"
