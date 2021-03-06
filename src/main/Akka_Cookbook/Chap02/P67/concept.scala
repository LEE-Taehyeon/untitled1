package Chap02.P67

class concept {}

/*
  아카 -  감시와 모니터링
  : 감시와 모니터링으로 수일, 수개월, 수년간 중단없이 계속 시행할 수 있는 장애 허용(fault-tolerant)시스템을 작성할 수 있다.
  1) 장애 허용
   : 장애 허용은 시스템의 속성으로, 장애시 고장나기보다는 항상 반응성을 유지하려 하는 것을 말한다. 이런 시스템은 장애 허용 시스템이나 회복력 있는 시스템이라고
   알려져 있다. 즉, 장애허용시스템은 완전히 가동 중일 때 보다 더 혹은 덜 가동되려 하는 시스템으로, 컴포넌트의 부분적인 장애로 인해 어쩌면 처리량의 감소나
   응답시간의 연장을 야기할 수 있다.
   컴포넌트가 실패하더라도, 전체 시스템은 절대로 정지되지 않는다. 다만 처리량이 감소한 채 가동되며 반응성을 유지한다.

   이런 시스템을 디자인하기 전에 주지해야하는 내용이 있다.
     - 시스템을 컴포넌트로 나누기 : 각각 어떤 기능에 대한 책임이 있는 컴포넌트로 나누는 것이다. 시스템의 컴포넌트 중 하나에서 특정 장애가 발생하더라도
     시스템의 다른 부분에 간섭하지 않아야 하며, 시스템의 연쇄적으로 장애가 발생하지 않아야 한다.
     - 시스템의 중요한 컴포넌트에 집중하기 : 시스템이 가져야 하는 중요한 부분이 있다. 이런 부분은 정확하지 않은 결과를 피하기 위해 고장 난 부분으로부터의
     간섭없이 작동해야한다.
     - 중요한 컴포넌트 백업 : 고장이 난 경우 유사한 컴포넌트가 시스템의 고가용성을 보장할 수 있다.

   일반적으로 시스템의 장애 허용성을 구축하는 방법은 다음과 같다.
    - 중복 : 시스템 컴포넌트의 인스턴스를 여러 개 실행시켜 장애가 발생하면 다른 인스턴스가 요청을 처리하도록 하는 것이다.
    - 복제 : 컨포넌트의 인스턴스를 여러개 준비해 이들 모두에게 요청을 직접 송신하는 것이다. 이를 근거로 결과 중 하나를 선택한다.
    - 격리 : 컴포넌트가 각 프로세스에서 실행되도록 유지하며, 메세지 전달로 통신해 우려 사항을 격리시켜 이들 사이의 결합을 완화시키는 것이다.
    이는 어떤 컴포넌트든 다른 컴포넌트의 실패에 영향을 받지 않게 하려는 것이다.
    - 위임 : task 의 처리 책임을 다른 컴포넌트로 넘겨 위임 컴포넌트가 처리하게 하거나, 아니면 실패 처리 또는 경과 보고 등 추가 동작이 필요한 경우 위임된
    작업의 진행과정을 선택적으로 관찰하려는 것이다.

  2) 컴포넌트
   : 소프트웨어 시스템에서 독립적인 업무 또는 기능을 수행하는 모듈로서 이후 시스템을 유지보수 하는데 있어 교체 가능한 부품이다.
   하드웨어는 각각 독립된 기능을 가진 모듈로 만들어진다. 이 제품들은 회사 상관없이 서로 조합하여 하나의 제품이 만들어진다.
   이러한 제품들의 부품은 문제가 발생했을 시, 해당 부품만 다른 부품으로 바꾸어도 제품은 문제없이 작동한다.
   그러나 소프트웨어의 상황은 다르다. 소프트웨어는 독립적으로 개발되지 않은 경우가 많을 뿐더러, 독립적으로 개발되더도 다른 모듈과의 호환을 생각하지 않고 개발한다.
   이는 결국 소프트웨어의 재사용을 어렵게 하고 유지보수 비용이 크게 증가하는 원인이 된다. 이러한 상황에서 소프트웨어의 재사용의 중요성과 필용성을 위해
   나온 기술이 컴포넌트 기술이다. 즉, 컴포넌트는 독립적이며, 격리되고, 캡슐화된 개체로 다른 컴포넌트에 영향을 주지 않는다.

  3) 아카는 어떻게 이들 모두에 부합하는가
   - 아카 슈퍼바이저 액터는 감독하는 액터의 실행을 재개, 중단, 재시작, 종료할 수 있다. 따라서 장애 허용을 위한 방법을 제공한다.
   - 아카는 부모-자식 모델 액터를 제공하므로, 앱을 나무와 같은 계층 구조로 구축할 수 있다.
   - 고장난 경우 중복된 액터를 만들고, 감독 전략을 통해 장애가 발생한 액터를 교체할 수 있다.
   - 아카 액터는 컴포넌트로서 생명주기를 가진다. 즉, 고장난 액터를 파기할 수 있다.
   - 비동기 메세지 던달은 서로 다른 컴포넌트의 우려사항을 분리할 수 있도록 두 액터 사이에 경계를 만들게 해준다.




 */
