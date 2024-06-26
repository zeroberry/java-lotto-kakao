# 로또

## 진행 방법

* 로또 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 코드 리뷰 요청을 한다.
* 코드 리뷰 피드백에 대한 개선 작업을 하고 다시 PUSH한다.
* 모든 피드백을 완료하면 다음 단계를 도전하고 앞의 과정을 반복한다.

## 온라인 코드 리뷰 과정

* [텍스트와 이미지로 살펴보는 온라인 코드 리뷰 과정](https://github.com/next-step/nextstep-docs/tree/master/codereview)

## 구현할 기능 목록

### 로또 볼(LottoBall)

- [x] 하나의 번호를 가지고 있다.
  - 번호는 1~45까지 존재한다.

### 로또 그룹(LottoGroup)

- [x] 6개의 로또 볼로 구성된다.
  - 로또 볼들은 중복이 존재하지 않는다.
- [x] 다른 로또 그룹과 비교해 일치하는 볼의 개수를 반환할 수 있다.

### 당첨 그룹 (WinningGroup)

- [x] 하나의 로또 그룹과 보너스 볼로 구성된다.
  - 로또 그룹에 속한 볼과 보너스 볼은 모두 중복되지 않는다.
- [x] 하나의 로또 그룹과 비교해 게임 결과를 반환할 수 있다.
- [x] 입력을 통해 생성한다.
  - 입력은 쉼표(,)로 구분되는 한 줄의 문자로 구성된다.
    - 총 6개의 번호를 입력 받아야 한다.
  - 보너스 볼을 입력받는다.
    - 하나의 번호만 입력 받는다.

### 구입 금액(PurchaseMoney)

- [x] 1000단위의 자연수로 구성된다.
- [x] 구입 금액을 입력받는다.
  - 1000원 단위로 입력받는다.

### 구입 개수(PurchaseCount)

- [x] 자연수로 구성된다.

### 당첨금(WinningMoney)

- [x] 0 이상의 정수로 구성된다.
  - int의 범위를 넘어도 올바르게 생성되어야 한다.

### 로또 머신(LottoMachine)

- [x] 구입 개수에 맞게 자동으로 로또 그룹을 만들어준다.

### 로또 게임(LottoGame)

- [x] 1개 이상의 로또 그룹을 가지고 있다.
  - 구입 개수만큼의 로또 그룹을 생성한다.
- [x] 당첨 그룹을 받아 당첨 통계를 반환할 수 있다.

### 게임 결과(LottoRoundResult)

- [x] 당첨 번호와 로또 그룹과의 비교를 통해 등수를 반환할 수 있다.
  - 2개 이하의 번호가 일치하면 꽝에 해당한다.
  - 3개의 번호가 일치하면 5등에 해당한다.
  - 4개의 번호가 일치하면 4등에 해당한다.
  - 5개의 번호가 일치하면 3등에 해당한다.
  - 6개의 번호가 일치하는데 그 중 하나가 보너스 번호이면 2등에 해당한다.
  - 6개의 번호가 일치하고, 일치한 번호들 중 보너스 번호가 없으면 1등에 해당한다.

### 당첨 통계(WinningStatistics)

- [x] 1개 이상의 게임 결과를 가지고 있다.
  - 당첨 통계가 가진 게임 결과의 개수는 구입 개수와 일치한다.
- [x] 수익률을 계산할 수 있다.
  - 수익률은 `당첨금 / 구입 금액`에 해당한다.

### 수익률(RevenueRate)

- [x] 소수점 둘째 자리까지 표현하는 하나의 소수로 구성된다.
  - 소수점 셋째 자리에서 반올림한다.
