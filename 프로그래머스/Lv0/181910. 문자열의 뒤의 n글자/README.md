# [Lv0] 문자열의 뒤의 n글자

- 문제 링크: https://school.programmers.co.kr/learn/courses/30/lessons/181910
- 유형: 구현
- 푼 날짜: 2026-10-20
- 언어: Java

---

### 문제 요약

문자열 `my_string`과 정수 `n`이 매개변수로 주어질 때, `my_string`의 뒤의 `n`글자로 이루어진 문자열을 return 하는 solution 함수

### 접근 방법

- StringBuilder를 사용해서 전체 길이에서 n만큼 뺀 수부터 반복문을 시작해서 append를 한다.

### 막혔던 점 / 배운 점

- 처음에 반복문 시작점을 my_string의 마지막 부분부터 시작해서 n까지 오는 반복문을 잘못 작성했음.

- StringBuilder를 사용하는데 더 익숙해지고 있음.

### 코드

```java
class Solution {
    public String solution(String my_string, int n) {
       
        StringBuilder sb= new StringBuilder();
        for(int i=my_string.length()-n; i<my_string.length(); i++) {
        	sb.append(my_string.charAt(i));
        	
        }
        return sb.toString();
    }
}

```
