#! /bin/bash
# Updates the FTC SDK fork to the latest official master repo.
# WARNING! For this to work without trouble, no changes to the
# SDK structure/files should be made, only additions!
cd ..
git remote add upstream https://github.com/ftctechnh/ftc_app.git
git fetch upstream/master
git checkout master
git merge upstream/master
printf "\nLocal Sync Complete.\nRun 'git push' to update remote.\n"
