# JVM 구조와 JAVA 메모리 구조

안녕하세요. 이번에는 [JVM 구조와 JAVA 메모리 구조]에 대해 알아보겠습니다. 

JVM의 구성은 크게 4가지로 나뉩니다. 각각의 특징을 살펴보겠습니다.

### 1. Class Loader 
Class Loader는 런타임에 컴파일된 클래스 파일들을 JVM의 Runtime Data Area에 적재합니다.

### 2. Execution Engine 
Runtime Data Area에 있는 자바 바이트 코드를 기계어로 변경해 명령어 단위로 실행합니다. 명령어를 한 줄씩 읽어서 실행하는 인터프리터 방식과 바이트 코드 전체를 읽고 실행하는 JIT 컴파일러가 있습니다.
### 3. Garbage Collector
JVM은 Garbage Collecotr를 통해 메모리 관리 기능을 자동으로 수행합니다.
더 이상 사용되지 않는 객체는 메모리에서 제거됩니다.
### 4. Runtime Data Area
JVM의 메모리 영역으로 자바 애플리케이션을 실행할 때 사용되는 데이터들을 적재하는 영역입니다. 세부적으로 Method Area, Heap area, Stack area, PC register, Native Method Stack으로 나뉩니다.
  


#### 1. Method Area  
필드 정보, 상수 풀, static 변수, 생성자와 메소드를 저장하는 공간입니다. Method Area는 JVM이 구동될 때 모든 스레드가 공유하는 영역입니다.

#### 2. Heap Area
런타임에 동적으로 할당하여 사용하는 영역입니다. new 키워드로 생선된 객체와 배열을 저장합니다. Heap Area는 Garbage Collector가 참조되지 않는 객체를 확인해서 제거하는 영역입니다.
#### 3. Stack Area 
각 스레드마다 하나씩 존재하며, 스레드가 시작될 때 할당됩니다. 자바에서는 제일 처음 스레드가 main() 메소드를 실행합니다. 메소드를 호출할 때마다 프레임을 추가하고 메소드가 종료되면 해당 프레임을 제거합니다. 가장 위에 있는 메소드가 현재 실행 중인 메소드이고 나머지 메소드는 대기 상태입니다.
Stack Area에서는 지역 변수, 매개 변수, 연산 중 발생하는 임시 데이터를 저장합니다.

#### 4. PC Register 
현재 수행 중인 JVM 명령 주소를 저장하는 영역입니다.

#### 5. Native Method stack 
자바 외 언어로 작성된 네이티브 코드를 위한 stack입니다. 네이티브 메소드의 매개변수, 지역변수 등을 바이트 코드로 저장합니다.


### 참조
https://goddaehee.tistory.com/149
https://hoonmaro.tistory.com/19
https://jeong-pro.tistory.com/148
