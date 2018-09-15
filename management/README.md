# Multi-Team FTC Codebase Management Tools
A set of bash scripts for maintaining the structure of the Watauga Robotics FTC Codebase. PLEASE follow these instructions as closely as possible to avoid catastrophic issues (especially sensitive procedures will be marked with a *).

Note: Running any of these scripts from a bash terminal requires the following syntax - `./SCRIPT_NAME.sh ARGUMENT_1 ARGUMENT_2` - and is cap-sensitive

### pullSubtree & pushSubtree (push requires subtree repo admin priveleges)
These are to be regularly used by maintainers of the subtree repositories (team repos and WataugaFTCResources) to pull the latest code and push any changes to branches, allowing independent management from the overall structure of ftc_app. The pullSubtree command should be used at least once after cloning ftc_app on any subtree repositories that will be used.

Pulling from a Subtree: `./pullSubtree.sh REPOSITORY_NAME BRANCH_NAME` (branch name is not required if pulling from master)
Pushing to a Subtree: `./pushSubtree.sh REPOSITORY_NAME BRANCH_NAME` (branch name not required if pushing to master - not recommended if multiple people are working at once) after adding and committing all changes (check with `git status`)

### updateSDK* (requires ftc_app admin priveleges)
Allows for updating to the latest official version of ftc_app without affecting local changes, which is an essential task that should be done at least once yearly (preferably after each update, as soon as the codebase is structurally stable).

Procedure:
1. Ensure you have write permissions on the Watauga Robotics ftc_app repository.
2. Add, commit, and push all unstaged changes to ftc_app and all subtrees. Running `git status` should return "up to date" "nothing to commit, working tree clean".
3. Double check release log on ftctechnh/ftc_app for any special instructions or catastrophic changes.
4. Run the script with no arguments (`./updateSDK.sh`). Provide a merge message when prompted.
5. Assuming all goes well, open the updated ftc_app in Android Studio and let Gradle Build run.
6. If prompted, REFUSE ANY UPDATES TO GRADLE (they may ruin SDK dependency), and DO NOT CHANGE GRADLE FILES MANUALLY, even if there are warnings. FTC will update these in their own time (the only exception here is getting our team projects changed to match ONLY WHEN the official module links are changed by FTC (ex: compile => implementation).
7. If there are any mistakes made in the previous steps (which can definitely happen), reset your local copy to the last pushed commit with `git reset --hard HEAD` followed by `git clean -f -d`, and repeat from step 4.
8. If everything looks good, push all changes (no adding or committing necessary) with `git push`, and consider using pushSubtree on each subtree repository (team repos and WataugaFTCResources) to ensure any gradle changes are propogated.
9. If any mistakes are discovered after committing and pushing, see [this forum post](https://stackoverflow.com/questions/4114095/how-to-revert-a-git-repository-to-a-previous-commit) for instructions on reverting to previous commits.

### enableWABD & connectWABD
These are experimental tools designed to automate setup of wireless code deployment and debugging. Instructions will come when these procedures are more fully tested.
