# [Lv0] 다른 사람의 풀이

- 문제 링크: https://school.programmers.co.kr/learn/courses/30/lessons/181943
- 유형: 구현
- 푼 날짜: 2026-10-27
- 언어: Java

---

### 문제 요약

문자열 `my_string`, `overwrite_string`과 정수 `s`가 주어집니다. 문자열 `my_string`의 인덱스 `s`부터 `overwrite_string`의 길이만큼을 문자열 `overwrite_string`으로 바꾼 문자열을 return 하는 solution 함수를 작성

### 접근 방법

- 구간마다 문자열을 charAt으로 잘라서 StringBuilder을 만들어서 붙이기

### 막혔던 점 / 배운 점

- s구간까지 자르고 붙이고 overwrite_string의 길이만큼 잘라서 붙이고 출력하니까 my_string의 나머지 문자열이 출력이 안됐음.

- my_string의 나머지 부분을 출력할때 for문을 새로 만들었음. 시작 인덱스를my_string.length()-s-overwrite_string.length()로 잡음

- overwrite_string + s가 되어야했음. 그래야 나머지 부분부터 시작 인덱스가 잡혔음. 

### 코드

```java
import java.util.*;


class Solution {
    public String solution(String my_string, String overwrite_string, int s) {
        
        
        StringBuilder sb= new StringBuilder();
        for(int i=0; i<s; i++) {
        		sb.append(my_string.charAt(i));
        }
        for(int j=0; j<overwrite_string.length(); j++) {
        	sb.append(overwrite_string.charAt(j));
        }
        for(int k=overwrite_string.length()+s; k<my_string.length(); k++) {
        	sb.append(my_string.charAt(k));
        }
        
        return sb.toString();
        
    }
}
```
