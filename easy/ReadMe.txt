类名：solution+题号
心得体会写在注释里
库函数总结：
1、 java.lang.Character.isLetterOrDigit(char c)方法的声明
	 这个方法就是专门验证，如果字符是字母或数字，此方法返回true，否则为false。
2、优先级队列常用方法：add() = offer()、peek()、poll()
3、栈的pop()、push()、peek()
4、Arrays.toString(数组名) 将数组转成字符串，Arrays.binarySearch(数组名, value) 二分查找
5、s.toCharArray()   将字符串 s 转为字符数组
6、Arrays.equals(arr1, arr2)  比较俩数组是否相等
7、Arrays.asList(v1,v2,v3) 参数最好是引用类型，返回一个[v1,v2,v3] 的数组List
8、System.arraycopy(oldArray, 0, newArray, 0, oldArray.length);
9、如果调用compare方法大于0，就把前一个数和后一个数交换，也就是把大的数放后面了，即所谓的升序。
10、String的 indexOf（int ch），传入字符对应的UniCode编码，然后去从前向后找到该字符在字符串中第一次出现处的索引
11、(count & 1) == 0  最牛逼的判奇偶
12、maxHeap = new PriorityQueue<>((x, y) -> y - x);   降序---大顶堆
13、Comparator：(x, y) return x - y  就是升序，return y - x 就是降序
14、异或的用法：easy---Solution136