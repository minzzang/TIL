안녕하세요 이번에는 [Garbage Collection]에 대해 알아보겠습니다.

# Garbage collection 이란 ?
Garbage collection이란 쓰레기 수거라는 뜻으로 자바에서 자동으로 메모리 관리를 해주는 알고리즘입니다. 쓰레기란 더이 상 사용되지 않는 객체를 뜻하며 이러한 객체들은 메모리에서 해제 되어야 합니다. GC는 더 이상 사용되지 않는 불필요한 객체들을 정리해주는 작업을 합니다.

# GC의 원리

GC 작업을 하는 가비지 콜렉터는 3가지 역할을 담당합니다.
- 메모리 할당
- 사용 중인 메모리 인식
- 사용하지 않는 메모리 인식

가비지 컬렉터가 객체를 할당하는 영역을 힙 영역이라고 합니다. GC는 이 힙 영역에서 일어나는데 힙 영역에 대해 자세히 알아 보겠습니다.

힙 영역은 Young, Old, Perm 영역으로 나뉩니다. Perm 영역은 자바 8부터는 사라지는 영역이므로 Young, Old 영역에 대해 알아 보겠습니다. 

- Young 영역
  - Young 영역은 Eden 영역과 2개의 Survivor 영역으로 나뉩니다.
  - 객체가 처음 생성되면 Eden 영역에 할당 됩니다.
  - Eden 영역에 데이터가 가득 차면 GC가 발생되어 참조되지 않는 객체들이 삭제되고 살아남은 객체들은 Survivor 영역으로 이동합니다.
  - Young 영역에서 발생하는 GC를 Minor GC라고 부릅니다. 
- Old 영역
  - 접근 불가능 상태로 되지 않아 Young 영역에서 살아남은 객체들이 복사되는 영역입니다.
  - 대부분 Young 영역보다 크게 할당되며 Eden 영역에서 크기가 큰 객체들은 Survior 영역으로 이동하지 않고 바로 Old 영역으로 이동합니다.
  - Old 영역에서 발생하는 GC를 Major GC라고 부릅니다.


# 5가지 GC 방식
## Serial GC
Serial GC는 Young 영역과 Old 영역이 연속적으로 일어납니다. Old 영역의 GC는 mark-sweep-compact 알고리즘을 사용하는데 이 알고리즘은 3 단계로 수행됩니다.
- Old 영역에 있는 객체 중에 살아 있는 객체를 식별합니다. (Mark)
- Old 영역에서 살아 있는 객체를 제외한 쓰레기 객체를 제거합니다. (Sweep)
- 필요 없는 객체를 지운 빈 공간을 없애기 위해 객체를 한 곳에 모읍니다. (compact)

Serial CG는 하나의 CPU만 사용하기 때문에 성능이 많이 떨어져 운영 서버에서는 잘 사용하지 않는 방식입니다.

## Parallel GC
Parallel GC는 CPU의 대기시간을 최소화하는 것을 목표로 하고 있습니다. 그래서 Serial GC와는 다르게 Minor GC를 할 때 여러 개의 스레드로 병렬로 처리를 합니다. Major GC는 Serial GC와 같은 mark-sweep-compact 알고리즘을 사용합니다.

## Parallel Compacting GC
Parallel Compactiong GC은 Major GC를 할 때 mark-summary-compaction 이라는 새로운 알고리즘을 사용합니다.
- 살아 있는 객체를 식별하여 표시하는 단계입니다. (mark)
- 이전 GC의 컴팩션된 영역에 살아있는 객체를 조사합니다. (summary)
- 객체를 한 곳에 모으는 컴팩션을 수행합니다. (compact)

Parallel compacting GC와 Parallel GC의 차이점은 두번 째 단계인 sweep과 summary의 차이입니다. sweep은 단일 스레드로 처리되고 summary는 여러 스레드가 Old 영역을 분리하여 살아있는 객체를 조사합니다.

## CMS GC
CMS GC는 low-latency collector로도 알려져 있고, 힙 메모리 영역의 크기가 클 때 적합합니다. CMS는 Major GC를 수행할 때 mark-sweep-comapct 보다 복잡한 알고리즘을 사용합니다.
- 


## G1 GC

?