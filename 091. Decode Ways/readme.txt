A message containing letters from A-Z is being encoded to numbers using the following mapping:

'A' -> 1
'B' -> 2
...
'Z' -> 26
Given an encoded message containing digits, determine the total number of ways to decode it.

For example,
Given encoded message "12", it could be decoded as "AB" (1 2) or "L" (12).

The number of ways decoding "12" is 2.



DecodeWays这个解决方法太耗时
DecodeWays优化之后得到DecodeWays2
DecodeWays2的优点是添加了数组private int[] youhua;
该数组记录字符串后缀剩下多少位时，会产生多少编码方法
讨论区的一个方法（C++）
class Solution {
public:
    int numDecodings(string s) {
    int rows = s.size()+1;
    if (rows == 1) return 0;
    vector<int> A(rows, 0);
    A[0] = 1;
    for(int i = 1; i < rows; i++){
        // from one-digit number , range is from 1 to 9
        if (s[i-1] >= '1' && s[i-1] <= '9') A[i] += A[i-1];
        // form two-digit number, the range is from 10 to 26
        if (i-2 >= 0 && s.substr(i-2, 2) <= "26" && s.substr(i-2, 2) >= "10"){
            A[i] += A[i-2];
        }
    }
    return A[rows-1];
}
};