안녕하세요 이번에는 디자인 패턴 중 하나인 [전략 패턴(Strategy pattern)]에 대해 알아보겠습니다. 먼저 전략 패턴을 구성하는 3가지 요소에 대해 알아보겠습니다.

1. 전략 메서드를 가진 전략 객체
2. 전략 객체를 사용하는 컨텍스트(전략 객체의 사용자/소비자)
3. 전략 객체를 생성해 컨텍스트에 주입하는 클라이언트(제3자, 전략 객체의 공급자)

전략 패턴은 객체의 행위를 동적으로 바꾸고 싶은 경우 직접 수정하지 않고 전략을 바꿔서 행위를 유연하게 확장하는 방법입니다. 전략 패턴을 구성하는 3가지 요소로 예를 들어 설명하겠습니다. 아이가 밥을 먹을 때 포크만 사용하다 커가면서 엄마가 젓가락 사용법을 알려줘서 젓가락으로 밥을 먹는다고 상상했을 때 포크와 젓가락은 전략이 되고 아이는 컨텍스트, 엄마는 클라이언트가 됩니다.


```
public interface Strategy {
    void eat();
}

public class StrategyFork implements Strategy {
    public void eat() {
        System.out.println("포크로 밥을 먹는다");
    }
}

public class StrategyChopstick implements Strategy {
    public void eat() {
        System.out.println("젓가락으로 밥을 먹는다.");
    }
}

```
전략 인터페이스를 정의하고 포크와 젓가락을 사용하는 전략을 구현했습니다.

```
public class Child {
    int age;

    Child(int age) {
        this.age = age;
    }

    void eat(Strategy strategy) {
        strategy.eat();
    }

    void setAge(int age) {
        this.age = age;
    }
}

```
전략을 사용할 컨텍스트인 Child 클래스를 만들어 전략을 주입받는 eat 메소드를 구현했습니다. 

```
public class Mother {
    public static void main(String[] args) {
        Child ceolsu = new Child(3);
        Strategy fork = new StrategyFork();
        ceolsu.eat(fork);

        System.out.println("4년 후....");

        ceolsu.setAge(7);
        Strategy chopstick = new StrategyChopstick();
        ceolsu.eat(chopstick);

    }
}

```
전략을 생성하고 컨텍스트에 전략을 주입해주는 Mother 클래스입니다. 3살인 철수는 포크 전략을 주입받아 밥을 먹을 때 포크를 사용하고 4년 후 7살이 되어서 젓가락으로 밥을 먹습니다.

전략 패턴을 사용하지 않으면 Child 클래스 코드에 밥을 먹을 때 포크를 사용할지 젓가락을 사용하는지 구체적으로 구현되어야 합니다. 이러면 전략을 수정해야 될 때 Child 코드를 수정해야 하고 사용할 전략들이 많아질수록 수정은 어려워지고 OCP(개방 폐쇄 원칙)에 위배됩니다.

전략 패턴을 사용할 경우 전략을 주입함으로써 Child 클래스에서 기능을 쉽게 확장할 수 있는 장점이 있습니다.

### 참조
스프링 입문을 위한 자바 객체 지향의 원리와 이해
https://limkydev.tistory.com/84


