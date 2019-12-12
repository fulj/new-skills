https://juejin.im/post/5c714d18f265da2d98090503
#####################git cherry-pick###########################
左开右闭区间
git cherry-pick <start-commit-id>..<end-commit-id>
闭区间
git cherry-pick <start-commit-id>^..<end-commit-id>

git cherry-pick --continue
git cherry-pick --quit
git cherry-pick --abort

#####################git 合并commit###########################
压缩最后四次提交 -i 表示 interactor 交互式
git rebase -i HEAD~4

pick 改为 squash 简写 s 
意思是将最后三次的提交压缩到倒数第四次提交

如果有冲突 解冲突后
git add.
git rebase --continue
如果放弃本次压缩
git rebase --abort

然后就是写注释 合并后的commit的描述信息

推远程 
git push origin branch_name
强推
git push -f origin branch_name

#####################git 回退commit###########################
撤销了commit但是修改的代码仍然保留
git reset --soft HEAD^
--mixed 
意思是：不删除工作空间改动代码，撤销commit，并且撤销git add . 操作
这个为默认参数,git reset --mixed HEAD^ 和 git reset HEAD^ 效果是一样的。

--soft  
不删除工作空间改动代码，撤销commit，不撤销git add . 

--hard
删除工作空间改动代码，撤销commit，撤销git add . 

注意完成这个操作后，就恢复到了上一次的commit状态。

顺便说一下，如果commit注释写错了，只是想改一下注释，只需要：
git commit --amend

此时会进入默认vim编辑器，修改注释完毕后保存就好了。

上一个版本
git reset --hard HEAD^
上上个，依次类推
git reset --hard HEAD^^
上10个版本
git reset --hard HEAD~10

根据commit
git reset --hard c46850a803e


没有add到暂存区的回退
git checkout -- readme.txt
add 到暂存区的回退
git reset HEAD readme.txt

==========已经push上去的代码回退 git 让单个文件回退到指定版本================

src/main/resources/application.yaml  aa0f56d5046ba3baef

git log --author="傅良军 <wb-flj593682@alibaba-inc.com>" ./adb/biz/mysql/mysql_on_ecs/mysql_base.py

git checkout ea60cbb17757b ./adb/biz/mysql/mysql_on_ecs/mysql_base.py 某个文件要回退到某个commit点
git commit -m "revert mysql_base" #提交


#####################git log###########################
git reflog
git log --pretty=oneline
git log --graph --pretty=oneline
git log --author="傅良军 <wb-flj593682@alibaba-inc.com>" -p 
git log --pretty=oneline --author="傅良军 <wb-flj593682@alibaba-inc.com>" -p 

git log -p可以查看每个commit的改动细节（到改动文件的每一行）
git log --stat查看简要统计（哪几个文件改动了）
git show 指定commit 指定文件名查看指定commit的指定文件改动细节

#####################git 删分支 重命名###########################
git origin -d 分支名 删除远程分支


a. 重命名远程分支对应的本地分支
git branch -m oldName newName
b. 删除远程分支
git push --delete origin oldName
c. 上传新命名的本地分支
git push origin newName
d.把修改后的本地分支与远程分支关联
git branch --set-upstream-to origin/newName

删远程分支
git push origin --delete <BranchName>
删本地分支
git branch -d <BranchName>

######################修改的文件列表##############################
git log --name-status 每次修改的文件列表, 显示状态
git log --name-only 每次修改的文件列表
git log --stat 每次修改的文件列表, 及文件修改的统计
git whatchanged 每次修改的文件列表
git whatchanged --stat 每次修改的文件列表, 及文件修改的统计
git show 显示最后一次的文件改变的具体内容



git 上传 GitHub
git init
git add.
git commit -m ""
git remote add origin https://github.com/xxx.git
git pull origin master
git push origin 



从参数模板中获取参数，去掉固定参数（因为固定参数是用户传的）剩下的参数加上用户传的固定参数，就是所有参数]

###############################git 删除远程仓库中的某个文件或文件夹#######################################

git rm -r -n --cached  */git/\*      //-n：加上这个参数，执行命令时，是不会删除任何文件，而是展示此命令要删除的文件列表预览。

git rm -r --cached  */git/\*      //最终执行命令.

git commit -m"移除src目录下所有文件的版本控制"    //提交

git push origin master   //提交到远程服务器


####################################git stash ################################################################
https://blog.csdn.net/anhenzhufeng/article/details/78052418
这是一个非常常用的场景,我正在一个分支上修改功能,然后遇到一个bug需要解决,我得切换到其他分支来修改这个bug,但是目前的功能还在开发阶段,还不成熟,还不想执行add和commit,执行这两个后就会在历史中有记录,并不想这样做,于是就有了git stash功能,把我当前的修改暂时保存起来,然后回来的时候再取出来继续开发功能.
git stash是针对整个git工程来进行保存的,也就是说区分不了branch.比如我在a分支git stash save "sss"暂存了一个修改,那么我切换到b分支,我使用git stash pop 就能把在a分支保存的"sss"这个修改同步到了b分支上.所以当我们需要在不同的分支上取出不同的分支上保存的修改,那么就用到了git stash list,这个命令可以把在所有分支上暂存的信息显示出来,

git stash
或者
git stash save “修改的信息"

git stash pop
或者
git stash list
git stash apply stash@{0}


================================================================================================
查看某个commitid 的变更
git show CommitID


########################################revert and reflog##################################################
git revert 用法
git revert 撤销 某次操作，此次操作之前和之后的commit和history都会保留，并且把这次撤销
作为一次最新的提交
    * git revert HEAD                  撤销前一次 commit
    * git revert HEAD^               撤销前前一次 commit
    * git revert commit （比如：fa042ce57ebbe5bb9c8db709f719cec2c58ee7ff）撤销指定的版本，撤销也会作为一次提交进行保存。
git revert是提交一个新的版本，将需要revert的版本的内容再反向修改回去，
版本会递增，不影响之前提交的内容

git revert 和 git reset的区别 
1. git revert是用一次新的commit来回滚之前的commit，git reset是直接删除指定的commit。 
2. 在回滚这一操作上看，效果差不多。但是在日后继续merge以前的老版本时有区别。因为git revert是用一次逆向的commit“中和”之前的提交，因此日后合并老的branch时，导致这部分改变不会再次出现，但是git reset是之间把某些commit在某个branch上删除，因而和老的branch再次merge时，这些被回滚的commit应该还会被引入。 
3. git reset 是把HEAD向后移动了一下，而git revert是HEAD继续前进，只是新的commit的内容和要revert的内容正好相反，能够抵消要被revert的内容。
-------------------------------------------------------------------------------------------------------------
git reflog 可以查看所有分支的所有操作记录（包括（包括commit和reset的操作），包括已经被删除的commit记录，git log则不能察看已经删除了的commit记录，而且跟进结果可以回退道某一个修改：