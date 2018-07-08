# leetcode
leetcode题目的解析及代码

## 树

### 数据结构

Java API Queue 三个方法

```  
boolean add(T t) 增加一个元索 如果队列已满，则抛出一个IllegalStateException异常
T element() 移除并返回队列头部的元素 如果队列为空，则抛出一个NoSuchElementException异常
T remove() 返回队列头部的元素 如果队列为空，则抛出一个NoSuchElementException异常
```

### 二叉树的先序、中序、后序遍历（递归+非递归）
- 递归方式比较简单实现。
- 非递归（利用栈）
  先序、中序类似，访问过可以直接从栈中pop出来；后序入栈只有当左右子树都遍历结束才能pop出来。需要记录刚刚**访问过**的节点，如果刚刚访问过，就不再访问。

##
