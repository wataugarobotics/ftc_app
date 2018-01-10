#! /bin/bash
#Sets up subtree for collaboration from a machine, &
#Pulls latest changes from any subtree branch into current branch, given:
# - that the name of the subtree repo corresponds to a top-level subfolder of ftc_app
# - the repo name as the first argument (case-sensitive)
# - (optional) the branch name to pull as the second argument (case-sensitive)

repo=$1
branch=$2

if [[ -z "$repo" ]]; then
	echo "Error: Please provide a repository name."
else
	if [[ -z "$branch" ]]; then
		echo "No branch specified. Defaulting to master."
		branch="master"
	fi

	cd ..
	git remote add "$repo" "$(cat "$repo/.gitremote")"
	git subtree add --squash --prefix="$repo" "$repo" "$branch"
	git fetch "$repo" "$branch"
	git subtree pull --squash --prefix="$repo" "$repo" "$branch"
	printf "\nLocal Sync Complete.\nRun 'git push' to update remote.\n"
fi
