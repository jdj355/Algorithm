# [Lv0] 대소문자 바꿔서 출력하기

- 문제 링크: https://school.programmers.co.kr/learn/courses/30/lessons/181949
- 유형: 구현
- 푼 날짜: 2026-10-24
- 언어: Java

---

### 문제 요약

영어 알파벳으로 이루어진 문자열 `str`이 주어집니다. 각 알파벳을 대문자는 소문자로 소문자는 대문자로 변환해서 출력하는 코드를 작성



### 접근 방법

- 문자열로 하나를 charAt으로 뽑아서 그게 대문자이면 소문자로 변경하고, 소문자면 대문자로 변경

### 막혔던 점 / 배운 점

- 인덱스가 굳이 필요없으면 가독성을 위해서 
향상된 for문 사용하기
문자열을 toCharArray로 배열로 만들어서 쓰면 하나씩 뽑아서 비교하기 편함.

### 코드

```java
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String a = sc.next();
        StringBuilder sb = new StringBuilder();
        // 대문자는 소문자로, 소문자는 대문자로 변경
        for(int i=0; i<a.length(); i++) {
        	// 만약 a.chatAt(i)가 대문자면 소문자로 변경
			if(a.charAt(i) == a.toUpperCase().charAt(i)){
				sb.append(Character.toLowerCase(a.charAt(i)));
			}else {
				sb.append(Character.toUpperCase(a.charAt(i)));
			}
        }
        System.out.println(sb.toString());
    }
}
```

### 클로드가 개선해준 코드

```java
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        StringBuilder sb = new StringBuilder();

        for (char c : str.toCharArray()) {
            sb.append(Character.isUpperCase(c)
                    ? Character.toLowerCase(c)
                    : Character.toUpperCase(c));
        }
        System.out.println(sb);
    }
}
```
