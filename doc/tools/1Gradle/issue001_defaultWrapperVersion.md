## �����������Ĵ��
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
һ��ʼ�Ǻõ�������������ܲ��������Ͱѱ��ص�gradle������һ�����ͱ�������ˣ����google��һ���϶�û�����
����˵���������⣬����Could not GET�Ǹ�url��ַȥ��������Խ���Ǻõģ������һ����Ŵ���
��������Ǵ�������⣬���˴����Ǳ��������ҿ����У�ж��gradle����װidea����������ok�˰ɣ�����û�뵽���������
```$xslt
    ���Ǽ�¼������Ϣ�� cannot resolve ... ɶɶ��
```
�����ҿ��ռ������������ԡ���������֤�漣��ʱ������½���gradle��Ŀ��Ȼ����build�ˣ�������֮ǰ�ϵ���Ŀһֱ
��ס�������������顣���������������������idea�½�����ĿĬ��gradle-wrapper.properties����İ汾���������ұ���װ��idea
google��һ������ӯ������������ͬ�����⣬��idea����Դ���һ����һ�� default wrapper version �����ұ��صĳ�ͻ�ˣ�
�ɴ�Ͳ��ñ���װ���ˣ��������� default wrapper version ���õġ��������Ȳ�Ϲ���ˣ������㻵������û���ֳɽ���ķ���
���Ҫ�㵽����������������
------
����build�Ժ�Ȼ����������junit��Ȼ˵ no task avaliable��
���������
```$xslt
Went to Settings > Build, Execution, Deployment > Build Tools > Gradle and changed Run tests using: from Gradle (Default) to IntelliJ IDEA.
```