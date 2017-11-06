#! /bin/bash
cd ../
git remote add upstream https://github.com/ftctechnh/ftc_app.git
git fetch upstream
git checkout master
git merge upstream/master
git push
echo "Sync Complete"
