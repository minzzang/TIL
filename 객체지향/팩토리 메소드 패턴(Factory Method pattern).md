안녕하세요 이번에는 디자인 패턴 중 하나인 [팩토리 메소드 패턴(Factory method pattern)]에 대해 알아보겠습니다. 

팩토리 메소드 패턴은 객체를 생성하기 위해 인터페이스/추상클래스를 정의하지만, 실제로 어떤 클래스의 인스턴스를 생성할지 결정하는 것은 서브 클래스에게 맡기는 패턴입니다.

팩토리 메소드 패턴에 클래스 다이어그램은 다음과 같습니다.


팩토리 메소드 패턴은 Creator 클래스가 사용하는 Product타입의 인스턴스를 Creator의 서브 클래스에서 생성합니다. Cretor 클래스에서는 자신이 사용하는 Product의 구체적인 클래스를 알지도 못하고 알 필요도 없습니다. Product 인터페이스로 기능을 구현하기 때문에 확장성에도 유리합니다.

이제 코드를 보면서 팩토리 메소드 패턴을 언제 어떻게 사용하는지 알아보겠습니다.
```
public class Factory {

    private Socks socks;

    public void produce() {
        socks = new WhiteSocks();
        socks.make();
        packing();
    }

    private void packing() {
        System.out.println("포장 !");
    }
}
```
이 양말 공장은 처음에는 흰 양말만 생산하는 공장이었습니다. produce() 메소드를 보시면 흰 양말을 생산하고 포장하고 있습니다. 그러다 흰 양말의 인기가 높아져 검정 양말도 제작해달라는 요청이 들어왔습니다. 이런 상황에서 코드를 어떻게 수정해야 할까요? produce() 메소드에서 if문을 이용해 처리할 수도 있지만 검정 양말뿐만 아니라 다른 색 양말도 요청이 들어온다면 코드를 매번 수정해야 하는 상황이 올 수 있습니다. 이럴 때 팩토리 메소드를 사용해서 양말 생성을 Factory 클래스에서 직접 하지 않고 서브 클래스에게 생성에 대한 책임을 맡겨 생성과 기능을 분리할 수 있습니다.

```
public abstract class Factory {

    private Socks socks;

    public void produce() {
        if (socks == null) {
            socks = factoryMethod();
        }
        socks.make();
        packing();
    }

    private void packing() {
        System.out.println("포장 !");
    }

    abstract Socks factoryMethod();
}

public class WhiteSocksFactory extends Factory {
    Socks factoryMethod() {
        return new WhiteSocks();
    }
}

public class BlackSocksFactory extends Factory {
    Socks factoryMethod() {
        return new BlackSocks();
    }
}
```
먼저 Factory 클래스를 추상 클래스로 변경하고 팩토리 메소드를 추상메소드로 만들었습니다. 이제 필요한 색의 양말이 생기면 Factory 클래스를 상속해서 양말의 인스턴스를 생성하면 됩니다.

```
public interface Socks {
    void make();
}

public class WhiteSocks implements Socks {
    public void make() {
        System.out.println("흰 양말 생산 !");
    }
}

public class BlackSocks implements Socks {
    public void make() {
        System.out.println("검정 양말 생산 !");
    }
}
```

WhiteSocks 클래스와 BlackSocks 클래스는 Socks 인터페이스를 구현한 클래스입니다. 새로운 색의 양말이 필요할 때마다 Socks 인터페이스를 구현한 클래스를 생성하면 됩니다. Factory 클래스에서는 구체적인 양말 클래스를 알 필요 없고 Socks 인터페이스로 기능을 구현합니다.

```
public class Main {
    public static void main(String[] args) {
        Factory white = new WhiteSocksFactory();
        white.produce(); // 흰 양말 생산 !

        Factory black = new BlackSocksFactory();
        black.produce(); // 검정 양말 생산 !
    }
}
```
이제 필요한 색의 양말을 생산할 때는 Factory 클래스를 수정하지 않고 Factory 클래스를 상속받아 양말을 생산할 수 있게 되었습니다.

팩토리 메소드 패턴은 OCP 원칙을 지켜 기존의 코드를 변경하지 않고 기능을 추가할 수 있어 확장성이 뛰어난 장점이 있지만 새로운 양말을 추가하려면 Factory 클래스도 상속받아야 하고 양말 클래스도 새로 만들어야 해서 추가할 클래스가 많아진다는 단점이 있습니다. 또 상속을 사용하기 때문에 Factory 클래스가 다른 목적으로 상속을 사용하지 못하고 기능이 수정되면 그 서브 클래스들도 수정해야 할 수도 있는 단점이 있습니다.

### 참조
스프링 입문을 위한 자바 객체 지향의 원리와 이해
https://gdtbgl93.tistory.com/19




