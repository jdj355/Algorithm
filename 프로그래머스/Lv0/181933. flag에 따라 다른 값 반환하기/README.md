# [Lv0] flag에 따라 다른 값 반환하기

- 문제 링크: https://school.programmers.co.kr/learn/courses/30/lessons/181933
- 유형: 구현
- 푼 날짜: 2026-10-20
- 언어: Java

---

### 문제 요약

두 정수 `a`, `b`와 boolean 변수 `flag`가 매개변수로 주어질 때, `flag`가 true면 `a` + `b`를 false면 `a` - `b`를 return 하는 solution 함수

### 접근 방법

- if 조건문으로 flag가 true일때와 false일때를 나눠서 생각했음.

### 막혔던 점 / 배운 점

- 딱히 없음

### 코드

```java
class Solution {
	public int solution(int a, int b, boolean flag) {
      
        if(flag== true) {
        	return a+b;
        }else{
        	return a-b;
        }
		
        
```
