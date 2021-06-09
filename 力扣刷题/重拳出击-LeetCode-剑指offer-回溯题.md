# 回溯算法-层次化理解回溯过程

# 前言

二刷[LeetCode-剑指offer-12-矩阵中的路径](https://blog.csdn.net/qyb19970829/article/details/113358518)的时候，回想自己曾今做回溯题的时候，简直心里发怵，但是现在我想重拳出击 。

每次做回溯题或者递归调用，**心里要有一颗树的印象**，因为递归的调用，都是从一个点跳跃到另外一个点，这个和树的结构是极其类似的！

如果凭空想象，是无法记住那么多调用过程的，就好像现在的人们为什么喜欢用思维导图一样，尤其树状图，可以让自己思维发散的同时不至于迷失。**递归调用的时候是发散，而回调返回的时候是收敛。**

另外**要有层次化的意识**，在相同的层次即树的深度相同时，可能还会有其他的节点，但是要记住，**同一层下的数据是共享的，是同一份数据**！

> **题目引子**：
>
> 请设计一个函数，用来判断在一个矩阵中是否存在一条包含某字符串所有字符的路径。路径可以从矩阵中的任意一格开始，每一步可以在矩阵中向左、右、上、下移动一格。如果一条路径经过了矩阵的某一格，那么该路径不能再次进入该格子。例如，在下面的3×4的矩阵中包含一条字符串“bfce”的路径（路径中的字母用加粗标出）。
>
> [["a","b","c","e"],
> ["s","f","c","s"],
> ["a","d","e","e"]]
>
> 但矩阵中不包含字符串“abfb”的路径，因为字符串的第一个字符b占据了矩阵中的第一行第二个格子之后，路径不能再次进入这个格子。
>
>  
>
> 示例 1：
>
> 输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCCED"
> 输出：true
> 示例 2：
>
> 输入：board = [["a","b"],["c","d"]], word = "abcd"
> 输出：false

# 重拳出击时刻

## 先上代码

```java
class Solution {
    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;
        boolean[][] visited = new boolean[m][n];;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(dfs(visited, board, word, i, j, 0)) return true;
            }
        }
        return false;
    }

    public boolean dfs(boolean[][] visited, char[][] board, String word, int i , int j, int count){
        // i < 0 || i >= board.length || j < 0 || j >= board[0].length 这些条件需要写在最前面，起到短路作用
        // 如果 visited[i][j] || board[i][j] != word.charAt(count) 则该元素不是要
        if(i < 0 || i >= board.length || j < 0 || j >= board[0].length || visited[i][j] || board[i][j] != word.charAt(count)) return false;
        if(count == word.length() - 1) return true;
        // 给该元素做标记，代表已经访问过了
        visited[i][j] = true;
        boolean res = dfs(visited, board, word, i + 1, j, count + 1)
                    || dfs(visited, board, word, i - 1, j, count + 1)
                    || dfs(visited, board, word, i, j + 1, count + 1)
                    || dfs(visited, board, word, i, j - 1, count + 1);
        // 回溯，将原来访问过的数据取消掉
        visited[i][j] = false;
        return res;
    }
}
```

俩for循环，无疑就是遍历数组元素呗，第一个尝试的数组元素a（0,0），这个显然是不符合要求的（`board[i][j] != word.charAt(count)`），于是j++，对b进行搜索，bfce是符合要求的，元素的递归调用按照1~8顺序进行，而最主要的就是理解这1~8的递归调用过程如何进行的。

![剑指offer-12-矩阵中的路径06](https://gitee.com/qiangyuanbao/MyBlogPic/raw/master/img/%E5%89%91%E6%8C%87offer-12-%E7%9F%A9%E9%98%B5%E4%B8%AD%E7%9A%84%E8%B7%AF%E5%BE%8406.jpeg)

## 完整解释

1. 第0层，最初的函数调用，b符合要求，count=0，给b做了标记，代表b已经访问过。然后就遇到了下面的一大串代码，**很多个递归调用，也就意味着有很多个选择**，注意这几个选择是 `||` 连接的，也就是说只要有一条路的返回值是true，后面的选择就不会继续了，因为短路效应，||运算是一个找true的过程。对于 `&&`，只要有一个选择是false，就不会继续了，是一个找false的过程。相反，如果找不到自己想要的结果，就会一直做选择。另外，**选择是顺序执行的**，先要选择1，再选择2，3，4。
   + 第一个选择`dfs(visited, board, word, i + 1, j, count + 1)`：b往下走一格，count + 1.
   + 第二个选择`dfs(visited, board, word, i - 1, j, count + 1)`：b往上走一格，count + 1.
   + 第三个选择`dfs(visited, board, word, i, j + 1, count + 1)`：b往右走一格，count + 1.
   + 第四个选择`dfs(visited, board, word, i, j - 1, count + 1)`：b往左走一格，count + 1.

```java
boolean res = dfs(visited, board, word, i + 1, j, count + 1)
                    || dfs(visited, board, word, i - 1, j, count + 1)
                    || dfs(visited, board, word, i, j + 1, count + 1)
                    || dfs(visited, board, word, i, j - 1, count + 1);
```

2. 第1层，选择1，count + 1，向下走一格，此时遇到了f，f满足条件，给其做标记。这个时候f和第0层的b一样，遇到了四个选择，那就同样的处理呗。

3. 第2层：
   + **第一层的f选择1**：向下走一格，遇到d，但是此时d是不符合条件的(`board[i][j] != word.charAt(count)`)，所以返回false；
   + 无奈递归调用又回到了第1层，既然选择1走不通，那**第一层的f就选择2**，向上走一格，找到了b，但是b是标记过的（`visited[i][j]`），也只好返回false；
   + 无奈递归调用又回到了第1层，既然选择2也走不通，那**第一层的f就选择3**，向右走一格，找到了c，谢天谢地，c终于符合了要求！于是给它做了标记，count + 1，这个时候c又要继续选择。
4. 第3层：此时c默认选择了1，向下走一格，count + 1，真是lucky，e是满足要求的，而且这个时候count已经达到了预期值`count == word.length() - 1`，顺利给上层的c返回一个true。

到此为止，自顶至下的递归调用（套娃）已经结束，接下来就是要收尾了~需要将未执行完的操作完成掉！

> 此处可以配合我先前的博客记录：[三张图简单理解回溯算法](https://blog.csdn.net/qyb19970829/article/details/113665450)

回调过程，**只需要返还自己曾经做过的选择即可**，这样就可以一层一层自底向上完成回溯过程~

## 层次化图解

![剑指offer-12-矩阵中的路径03](https://gitee.com/qiangyuanbao/MyBlogPic/raw/master/img/%E5%89%91%E6%8C%87offer-12-%E7%9F%A9%E9%98%B5%E4%B8%AD%E7%9A%84%E8%B7%AF%E5%BE%8403.jpeg)

