# Getting started with Git and GitHub

### Step1. git config

```
$ git config --global user.name "...."
$ git config --global user.email ...@....
```

### Step2. git init

1. Create a folder for local storage
2. Execute Git Bash, and then type 'git init'

```
$ (....file addresse...)
$ git init
```

if you see (master), that's good start.

### Step3. git add

1. write a file or a folder name

```
git add ......
```

### Step4. git commit

+ git commit command is to save your changes to the local repository

+ a commit is not transferred to the remote server. it only saves a new commit object in the local Git repository.
+ a message let others know what you've changed and why.

```
$ git commit -m "...message..."
```

### Step5. git remote

setting repository 

```
$ git remote add origin https://github.com/ohg147/test.git
```

### Step6. git push

+ to send the changes to your remote repository
+ you can see everything is up to date by running the command 'git status'

```
$ git push -u origin master
$ git status
```



now, you can check your files on your Github!