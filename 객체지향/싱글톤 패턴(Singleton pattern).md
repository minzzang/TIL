안녕하세요~ 이번에는 디자인 패턴 중 하나인 [싱글톤 패턴(Singleton pattern)]에 대해 알아보겠습니다. 

## 싱글톤 패턴(Singleton Pattern) 이란 ?
싱글톤 패턴은 인스턴스가 오직 1개만 생성되어야 할 때 사용되는 패턴입니다. 애플리케이션이 시작될 때 어떤 클래스가 최초 한 번만 메모리를 할당하고 그 메모리에 인스턴스를 생성합니다.

## 싱글톤을 쓰는 이유
싱글톤 패턴을 사용하면 하나의 인스턴스를 할당할 메모리 공간만 가지기 때문에 메모리 낭비를 방지할 수 있고 효율적입니다. 또한 전역 인스턴스이기 때문에 다른 클래스의 인스턴스들이 데이터를 공유하기 쉽습니다.


## 싱글톤의 문제점
싱글톤 인스턴스의 책임이 많아지거나 많은 데이터를 공유할 경우 다른 클래스 인스턴스들과 결합도가 높아져 OCP(개방 폐쇄 원칙)에 위배됩니다. 또한 멀티 스레드 환경에서 동기화 문제가 발생할 수 있으므로 Thread-safe하게 구현해야 합니다.

## 싱글톤의 다양한 구현

### 1. Eager initialization (이른 초기화 방식)
```
public class SingletonPattern {
    private static SingletonPattern singleton = new SingletonPattern();

    public static SingletonPattern getInstance() {
        return singleton;
    }
}

```
싱글톤을 가장 간단하게 구현할 수 있는 방법입니다. static 변수로 싱글톤 객체를 미리 생성하고 getInstance() 메소드로 싱글톤 인스턴스를 반환합니다. 이 방법은 클래스가 로드되는 시점에 싱글톤 인스턴스가 생성되기 때문에 멀티 스레드 환경에서도 하나의 인스턴스만 생성되는 것이 보장됩니다. 그러나 사용하지 않을 때에도 메모리의 공간을 차지하기 때문에 메모리 공간이 낭비될 수 있습니다.

### 2. Lazy initialization (늦은 초기화 방식)
```
public class SingletonPattern {
    private static SingletonPattern singleton;

    public static SingletonPattern getInstance() {
        if (singleton == null) {
            singleton = new SingletonPattern();
        }
        return singleton;
    }
}

```
늦은 초기화 방식은 사용하지 않을 때에도 메모리 공간을 차지하는 이른 초기화 방식의 단점을 해결해줍니다. static으로 싱글턴 변수를 만들고 getInstance 메소드에서 싱글톤 인스턴스가 null인지 확인하고 null일 경우에만 인스턴스를 생성하고 반환합니다. 이 방식은 메모리 낭비는 없지만 thread safe하지 않습니다. 왜냐하면 싱글톤 인스턴스가 생성되지 않았을 때 2개의 쓰레드에서 동시에 getInstance 메소드를 호출하면 2개의 인스턴스가 생성될 수도 있습니다. 

### 3. Thread safe Lazy initialization (스레드 안전한 늦은 초기화 방식)
```
public class SingletonPattern {
    private static SingletonPattern singleton;

    public static synchronized SingletonPattern getInstance() {
        if (singleton == null) {
            singleton = new SingletonPattern();
        }
        return singleton;
    }
}

```
늦은 초기화 방식에서 getInstance 메소드에 synchronized 키워드를 추가해서 Thread safe 하게 만든 방식입니다. synchronized 자바 내부적으로 lock, unlock을 걸어 한번에 하나의 스레드만 접근하는 것을 보장해주지만 성능이 떨어지는 단점이 있습니다. 
### 4. Double checked locking 방식

```
public class SingletonPattern {
    private static SingletonPattern singleton;

    public static SingletonPattern getInstance() {
        if (singleton == null) {
            synchronized (SingletonPattern.class) {
                if (singleton == null) {
                    singleton = new SingletonPattern();
                }
            }
        }
        return singleton;
    }
}
```

double checked locking 방식은 synchronized 키워드를 메소드에 사용해서 lock을 걸지 않아도 될 코드 부분까지 lock을 걸어 효율이 떨어지는 것을 개선해주는 방식입니다. 메소드에 사용하는 것이 아닌 싱글톤 인스턴스가 null일 경우에만 synchronized를 사용해 한번 더 null 인지 체크한 후 인스턴스를 생성하는 방식입니다.

### 5. initialization on demand holder idiom (holder에 의한 초기화)

```
public class SingletonPattern {
    private static class Holder {
        private static final SingletonPattern singleton = new SingletonPattern();
    }

    public static SingletonPattern getInstance() {
        return Holder.singleton;
    }
}

```

holder에 의한 초기화 방식은 싱글톤 클래스에 내부 클래스를 만든 후 내부 클래스에서 싱글톤 인스턴스를 초기화시키는 방법입니다. getInstance 메소드에서는 내부 클래스의 싱글톤 인스턴스를 반환합니다. 이 방법은 내부 클래스에 static으로 싱글톤 인스턴스를 생성함으로써 메모리에 한 번만 올라가는 것을 보장할 수 있고 싱글톤 클래스가 처음 클래스 로더에 의해 메모리에 올라갈 때는 인스턴스가 생성되지 않고 getInstance 메소드를 호출했을 때 내부 클래스가 메모리에 올라가 인스턴스를 생성합니다. 현재까지 싱글톤 인스턴스를 만들 때 가장 많이 사용하는 방법입니다.

### 참조
https://jeong-pro.tistory.com/86
https://limkydev.tistory.com/67
