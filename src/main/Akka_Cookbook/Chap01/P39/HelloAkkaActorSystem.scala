package Chap01.P39

import akka.actor.ActorSystem

class HelloAkkaActorSystem {}


/**
 * 액터 시스템(ActorSystem) 생성
 */
/*
  <액터 시스템이 필요한 이유>
  아카에서 액터 시스템은 모든 아카 앱의 작성 시작점이다.
  기술적으로 액터 시스템은 앱마다 존재하는 비중 있는 체계로, n개의 스레드를 할당한다.
  따라서 다른 액터 시스템을 만들 이유가 있지 않는 한, 앱마다 하나의 액터 시스템을 만들 것을 추천한다.

  액터 시스템은 액터가 사는 집이라 할 수 있으며, 액터의 생명주기를 관리하고 감독한다.
  액터 시스템은 생성 시 세 개의 액터를 시작한다.
  1) /user(감시자 액터) : 모든 사용자 정의 액터는 부모 액터인 유저(user)의 자식으로 만들어진다. 즉, 액터 시스템에서 사용자의 액터를 만들 때,
                       이는 유저(user) 감시자 액터의 자식이 되며, 이 감시자 액터가 사용자의 액터를 감독한다.
                       감시자 액터를 종료시키면 사용자의 액터도 종료된다.
  2) /system(시스템 감시자) : 아카에서는 로깅 또한 액터를 사용해서 구현한다. 이 특별한 감시자는 모든 일반 액터가 종료될 때 로깅 액터를 정지시킨다.
                          이는 유저 감시자 액터를 주시하며, 감시자 액터의 종료에 따라 그 자신의 정지작업을 시작한다.
  3) /(루트감시자) : 루트 감시자는 최고수준 액터라 불리는 모든 액터의 조부모 액터이며, 모든 최고 수준 액터를 감독한다.
                  이 액터의 목적은 모든 형태의 예외에 대해 자식 액터를 종료시키는 것이다. 감시자 액터가 모든 자식 액터를 성공적으로 종료시킬 수 있다면,
                  루트 감시자는 액터 시스템 상태를 종료로 설정한다.
*/
object HelloAkkaActorSystem extends App {
  val actorSystem =  ActorSystem("HelloAkka")

  println(actorSystem)
}
