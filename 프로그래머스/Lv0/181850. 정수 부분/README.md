# [Lv0] 정수 부분

- 문제 링크: https://school.programmers.co.kr/learn/courses/30/lessons/181850
- 유형: 구현
- 푼 날짜: 2026-10-20
- 언어: Java

---

### 문제 요약

실수 `flo`가 매개 변수로 주어질 때, `flo`의 정수 부분을 return하도록 solution 함수를 완성


### 접근 방법

flo가 double이라 int로 형변환해주고  출력

### 막혔던 점 / 배운 점

- 없

### 코드

```java

class Solution {
    public int solution(double flo) {
    	flo = (int) flo;
    	
        return (int)flo ;
    }
}
```
