#! /bin/bash
#Pushes committed changes from current branch into any subtree branch, given:
# - that the name of the subtree repo corresponds to a top-level subfolder of ftc_app
# - the repo name as the first argument (case-sensitive)
# - (optional) the branch name to push to as the second argument (case-sensitive)

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
	git subtree push --prefix="$repo" "$repo" "$branch"
	printf "\nRemote Sync Complete.\n"
fi
