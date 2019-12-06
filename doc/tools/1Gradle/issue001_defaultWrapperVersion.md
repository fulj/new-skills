## 这两天遇到的大坑
```$xslt
11:26:47 PM: Executing task 'build'...

> Task :compileJava FAILED

FAILURE: Build failed with an exception.

* What went wrong:
Execution failed for task ':compileJava'.
> Could not resolve all files for configuration ':compileClasspath'.
   > Could not resolve org.junit.jupiter:junit-jupiter:5.5.2.
> Could not get resource 'https://repo.maven.apache.org/maven2/org/junit/jupiter/junit-jupiter/5.5.2/junit-jupiter-5.5.2.pom'.
   > Could not GET 'https://repo.maven.apache.org/maven2/org/junit/jupiter/junit-jupiter/5.5.2/junit-jupiter-5.5.2.pom'.
      > Connect to localhost:55110 [localhost/127.0.0.1, localhost/0:0:0:0:0:0:0:1] failed: Connection refused (Connection refused)
```
一开始是好的我想后来不能跑测试用例就把本地的gradle升级，一升级就报这个错了，结果google了一晚上都没解决。
网上说是网络问题，我拿Could not GET那个url地址去浏览器上试结果是好的，尼玛我还开着代理。
心想可能是代理的问题，关了代理还是报错。于是我开大招，卸载gradle，重装idea。心想这下ok了吧，万万没想到，报错变了
```$xslt
    忘记记录错误信息了 cannot resolve ... 啥啥的
```
最后逼我开终极大招重启电脑。。。。见证奇迹的时候，这回新建的gradle项目尽然可以build了，但是我之前老的项目一直
卡住。尼玛心乱如麻。。整理心情继续看发现用idea新建的项目默认gradle-wrapper.properties里面的版本，并不是我本地装的idea
google了一下热泪盈眶，有人遇见同样问题，是idea插件自带的一个有一个 default wrapper version ，跟我本地的冲突了？
干脆就不用本地装的了，就用它的 default wrapper version 蛮好的。。。。先不瞎搞了，环境搞坏网上又没有现成解决的方法
真的要搞到怀疑人生。。。。
------
可以build以后竟然。。。运行junit竟然说 no task avaliable。
解决方法：
```$xslt
Went to Settings > Build, Execution, Deployment > Build Tools > Gradle and changed Run tests using: from Gradle (Default) to IntelliJ IDEA.
```