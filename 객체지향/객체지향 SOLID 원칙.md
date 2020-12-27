# 1. SRP - 단일 책임 원칙
작성된 클래스는 하나의 기능만 가지며 클래스가 제공하는 모든 서비스는 그 하나의 책임을 수행하는데 집중되어 있어야 한다는 원칙입니다.

클래스의 책임이 여러 개이면 관계가 복잡해지고 응집도가 낮아져서 유지 보수하기 어려운 코드가 됩니다.
# 2. OCP - 개방 폐쇄 원칙

개방 폐쇄 원칙이란 기존 코드를 변경하지 않으면서 기능을 추가할 수 있도록 설계해야 한다는 뜻입니다. 확장에는 열려(Open)있고 변경에는 닫혀(Closed)있는 구조입니다. 예제를 통해 OCP에 대해 자세히 알아보겠습니다.

``` 
public class Computer {

    private AKeyboard aKeyboard = new AKeyboard();

    public void boot() {
        System.out.println("부팅 중");
        aKeyboard.connect();
    }

    public static void main(String[] args) {
        Computer computer = new Computer();
        computer.boot();
    }
}

public class AKeyboard {

    public void connect() {
        System.out.println("Akeyboard가 연결 되었습니다.");
    }
}

```

컴퓨터에 a키보드를 연결해서 사용하는 예제입니다. 부팅도 잘되고 키보드도 잘 연결되지만 만약 b키보드로 교체한다면 어떻게 될까요? 컴퓨터 클래스 코드에서 a키보드를 사용하는 부분을 모두 b키보드를 사용하도록 수정해야 합니다. 이런 상황에서 바뀔 수 있는 키보드 부분을 추상화한다면 기존의 코드를 변경하지 않고 키보드를 교체할 수 있습니다.

```
public class Computer {

    private final Keyboard keyboard;

    public Computer(Keyboard keyboard) {
        this.keyboard = keyboard;
    }

    public void boot() {
        System.out.println("부팅 중");
        keyboard.connect();
    }

    public static void main(String[] args) {
        Computer computer = new Computer(new BKeyboard());
        computer.boot();
    }
}

public class BKeyboard implements Keyboard {

    public void connect() {
        System.out.println("Bkeyboard가 연결 되었습니다.");
    }
}

```

컴퓨터에서 구체적인 a키보드, b키보드를 사용하는 것이 아니라 키보드 인터페이스를 만들어 사용할 키보드를 주입하는 식으로 코드를 변경하면 키보드를 교체할 때 컴퓨터 코드를 변경하지 않고 새로운 키보드 클래스만 추가하는 방식으로 키보드를 변경할 수 있게 됩니다.


# 3. LSP - 리스코프 치환 원칙
서브 타입은 언제나 자신의 상위 타입으로 교체할 수 있어야 한다는 원칙입니다. 즉 부모 클래스를 상속할 때, 부모 클래스가 사용되는 곳은 아무 문제없이 자식 클래스도 사용할 수 있어야 합니다. 그렇지 않으면 상속을 잘못 사용하고 있는 것입니다.

### 리스코프 치환 원칙이 왜 중요한가 ?
1. 이 원칙을 지키지 않으면 클래스 계층이 지저분해집니다. 서브클래스 인스턴스를 파라미터로 전달했을 때 메소드가 이상하게 작동할 수 있습니다.
2. 슈퍼클래스에 대해 작성된 단위테스트가 서브클래스에 대해서는 작동되지 않을 것입니다.


# 4. ISP - 인터페이스 분리 원칙
한 클래스는 자신이 사용하지 않는 인터페이스는 구현하지 않아야 합니다.
즉 필요 없는 기능을 구현하지 않도록 인터페이스를 분리해야 한다는 원칙입니다. 스마트폰 예제를 통해 자세히 알아보겠습니다.

```
public interface SmartPhone {
    void sms();
    void camera();
}

public class Iphone6 implements SmartPhone {

    public void sms() {
        System.out.println("문자 전송");
    }

    public void camera() {
        System.out.println("카메라");
    }

}
```
sms와 camera기능이 있는 스마트폰 인터페이스를 작성하고 인터페이스를 구현한 아이폰6을 만들었습니다. 향후 출시될 아이폰7을 개발하고 있는데 아이폰7에는 배터리 절약기능이 추가될 예정입니다. 스마트폰 인터페이스에 배터리 추가 기능을 넣으면 어떻게 될까요?

```
public interface SmartPhone {
    void sms();
    void camera();
    void saveBattery();
}

public class Iphone7 implements SmartPhone {

    public void sms() {
        System.out.println("문자 전송");
    }

    public void camera() {
        System.out.println("카메라");
    }

    public void saveBattery() {
        System.out.println("배터리 절약");
    }
}

public class Iphone6 implements SmartPhone {

    public void sms() {
        System.out.println("문자 전송");
    }

    public void camera() {
        System.out.println("카메라");
    }

    public void saveBattery() {
        System.out.println("지원되지 않는 기능입니다.");
    }
}


```
아이폰 7은 잘 작동하는 것을 확인할 수 있습니다. 그런데 아이폰6에는 배터리 절약기능이 없습니다. 하지만 스마트폰 인터페이스를 구현했기 때문에 불필요한 구현이 발생하게 됩니다. 이런 경우에는 스마트폰 인터페이스에 신규 기능을 추가하는 것이 아닌 인터페이스를 분리해 새로운 인터페이스를 작성해 아이폰 7에 새로운 인터페이스를 구현하게 하여 ISP를 만족하게 할 수 있습니다.

```
public class Iphone7 implements SmartPhone, Saving {

    public void sms() {
        System.out.println("문자 전송");
    }

    public void camera() {
        System.out.println("카메라");
    }

    public void saveBattery() {
        System.out.println("배터리 절약");
    }
}


public class Iphone6 implements SmartPhone {

    public void sms() {
        System.out.println("문자 전송");
    }

    public void camera() {
        System.out.println("카메라");
    }
}
```

아이폰7에는 스마트폰과 세이빙 인터페이스를 구현하게 하고 아이폰6에는 스마트폰 인터페이스만 구현하게 했습니다. 이런 식으로 기존의 인터페이스를 분리하면 불필요한 메소드 작성을 피할 수 있습니다.


# 5. DIP - 의존 역전 원칙
상위 모듈은 하위 모듈을 직접 의존하지 않고 추상화된 것을 의존해야 한다는 원칙입니다. 또한 추상화된 것은 구체적인 것에 의존하면 안 되고 구체적인 것이 추상화된 것에 의존해야 합니다. 자동차와 타이어 예제를 통해 자세히 알아보겠습니다. 

```
public class Car {

    private RegularTire regularTire = new RegularTire();

    public void getTire() {
        regularTire.tire();
    }

    public static void main(String[] args) {
        Car car = new Car();
        car.getTire();
    }
}

public class RegularTire {
    public void tire() {
        System.out.println("일반 타이어입니다.");
    }
}

```
자동차가 일반 타이어를 직접 의존하고 있는 상태입니다. 상위 모듈(Car)이 하위 모듈(RegularTire)을 직접 의존하고 있으므로 DIP원칙에 위배됩니다. 상위 모듈이 하위 모듈이 아닌 추상화된 것을 의존하게 하고 하위 모듈도 추상화된 것을 의존하게 하여 의존성을 역전시켜 보겠습니다.

```
public class Car {

    private Tire tire;

    public Car(Tire tire) {
        this.tire = tire;
    }

    public void getTire() {
        tire.tire();
    }

    public static void main(String[] args) {
        Car carWithSnowTire = new Car(new SnowTire());
        carWithSnowTire.getTire(); // 스노우 타이어입니다.

        Car carWithRegularTire = new Car(new RegularTire());
        carWithRegularTire.getTire(); // 일반 타이어입니다.
    }
}

public interface Tire {
    void tire();
}

public class SnowTire implements Tire{
    public void tire() {
        System.out.println("스노우 타이어입니다.");
    }
}

```

상위 모듈(Car)이 하위 모듈(SnowTire, regularTire)을 직접 의존하지 않고 하위 모듈에 추상화인 Tire인터페이스를 의존하게 하고 하위모듈이 Tire인터페이스를 의존하게 하여 의존성을 역전시켰습니다. 의존성을 역전시키므로 하위 모듈이 수정되어도 상위 모듈에 영향을 주지 않는 코드를 만들 수 있었습니다.




## 참조

http://www.nextree.co.kr/p6960/
https://velog.io/@kyle/%EA%B0%9D%EC%B2%B4%EC%A7%80%ED%96%A5-SOLID-%EC%9B%90%EC%B9%99-%EC%9D%B4%EB%9E%80
https://lng1982.tistory.com/124