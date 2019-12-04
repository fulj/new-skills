## mysql 主从延迟

<img src="../images/mysql 主从延迟/image-20191202195244377.png" alt="image-20191202195244377" style="zoom:50%;" />

### 检查方法

1. show slave statusG命令输出的Seconds_Behind_Master参数的值来判断

   Seconds_Behind_Master 是通过比较sql_thread执行的event的timestamp和 io_thread复制好的event的timestamp（简写为ts）进行比较，而得到的这么一个差值。

