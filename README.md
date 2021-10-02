# 숫자 야구 게임

## 진행 방법

* 숫자 야구 게임 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 과제를 제출한다.

## 과제 제출 과정

* [과제 제출 방법](https://github.com/next-step/nextstep-docs/tree/master/precourse)

## 구현해야할 기능 목록

- [] 입력
    - [] 사용자 숫자 입력
    - [] 게임 명령어 입력

- [] 출력
    - [] 매칭 결과 출력
        - [] 3스트라이크일 경우
            - [] 게임 종료 메세지 출력

- [] 컴퓨터 (Computer)
    - 속성
        - [] 정답(공 집합)
    - 기능
        - [] 사용자의 공 집합과 비교하여 비교 결과 반환하는 기능

- [] 공 집합 (Balls)
    - 속성
        - [] 3개의 공
            - [] : [ERROR] 3개의 공이 아닐 경우
            - [] : [ERROR] 중복된 수가 포함될 경우
    - 기능
        - [] 공 집합과 비교하여 비교 결과 반환하는 기능

- [] 공 (Ball)
    - 속성
        - [x] 위치
        - [x] 숫자
    - 기능
        - [] 공 비교
            - [] 위치, 값 같은 경우 스트라이크 반환
            - [] 위치는 다르지만, 값 같은 경우 볼 반환
            - [] 둘 다 다를 경우 아무 낫싱 반환

- [x] 위치 (Position)
    - 속성
        - [x] 위치 값
            - [x] : [ERROR] 0 미만 또는 2 초과일 경우

- [x] 숫자 (Number)
    - 속성
        - [x] 숫자 값
            - [x] : [ERROR] 1 미만 또는 9 초과일 경우

- [] 상태 (State)
    - 속성
        - [] 스트라이크, 볼, 낫싱
    - 기능
        - [] 스트라이크인지 확인하는 기능
        - [] 볼인지 확인하는 기능
        - [] 낫싱인지 확인하는 기능

- [] 비교 결과 (Result)
    - 속성
        - [] 스트라이트 개수
        - [] 볼 개수
    - 기능
        - [] 스트라이크 3개인지 확인

- [] 게임 명령어 (Command)
    - 속성
        - [] START(1), EXIT(2)

    - 기능
        - [] 게임 명령어 조회
            - [] 숫자와 일치하는 게임 명령어 반환
            - [] : [ERROR] 1 또는 2가 아닐 경우
        - [] 시작 명령어인지 확인하는 기능
