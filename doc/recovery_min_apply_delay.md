```
# By default, a standby server restores XLOG records from the primary as  
# soon as possible. If you want to explicitly delay the replay of committed  
# transactions from the master, specify a minimum apply delay. For example,  
# if you set this parameter to 5min, the standby will replay each transaction  
# commit only when the system time on the standby is at least five minutes  
# past the commit time reported by the master.  
#  
recovery_min_apply_delay = 0  
```

比如某个事务包含了DDL操作，那么这笔操作马上会在HOT STANDBY执行，锁在hot standby也同时被加载。
但是当遇到这个事务的commit record时，由于设置了recovery_min_apply_delay，这笔record被延迟执行，这个锁也会延迟到这笔record被apply为止。
在此延迟时间段内，对这个被执行DDL的表的QUERY都会被堵塞。







