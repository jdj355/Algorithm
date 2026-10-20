# [Lv0] 문자열로 변환

- 문제 링크: https://school.programmers.co.kr/learn/courses/30/lessons/181845
- 유형: 구현
- 푼 날짜: 2026-10-20
- 언어: Java

---



### 문제 요약

정수 `n`이 주어질 때, `n`을 문자열로 변환하여 return하도록 solution 함수를 완성


### 접근 방법

- StringBuilder를 만들어서 n을 넣어 문자로 만들고 출력

### 막혔던 점 / 배운 점

- 두번째 풀이가 더 간단했음. 단순하게 숫자를 문자열로 바꿔주는 String.valueOf()가 있었음.

### 코드

```java
class Solution {
    public String solution(int n) {
        StringBuilder sb= new StringBuilder();
        	sb.append(n);
       
        return sb.toString();
    }
}
```

```java

class Solution {
    public String solution(int n) {
        
    
        return String.valueOf(n);
    }
}
```
