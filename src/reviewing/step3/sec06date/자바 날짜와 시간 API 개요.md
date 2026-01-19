## 1. 날짜/시간 연산이 복잡한 이유
- 윤년(Leap Year): 4년, 100년, 400년 주기로 달라지는 2월의 일수 계산 필요.
- 월별 일수 상이: 28, 29, 30, 31일 등 불규칙함.
- 일광 절약 시간(DST, Summer Time): 특정 기간에 1시간을 당기거나 늦추는 변환 로직 필요.
- 타임존(Timezone): GMT(구 표준) -> UTC(현 표준, 원자시계 기반) 변환 및 국가별 시차 고려.
  => 핵심: 개발자가 직접 계산하기엔 너무 복잡하고 버그 위험이 큼. 라이브러리가 필수적임.

## 2.자바 날짜 라이브러리의 변천사

### [JDK 1.0] java.util.Date (Legacy)
- 문제점: 타임존 처리 미흡, 날짜 연산 불편.
- 치명적 단점: '가변 객체(Mutable)'임. (데이터 수정이 가능하여 사이드 이펙트 발생 위험 큼)
- 해결: Calendar 클래스 도입으로 타임존 지원 개선, 날짜 연산 추가 메서드 제공

### [JDK 1.1] java.util.Calendar (Legacy) 
- Date의 대안으로 등장. 타임존 지원 개선, 날짜 연산 기능 추가.
- 여전한 문제점:
    1. 사용성 최악: 월(Month)이 0부터 시작함 (1월 = 0). 실수를 유발하는 설계.
    2. 가변 객체: 여전히 값이 변경 가능하며, 스레드 안전성 문제 존재.
    3. 성능 이슈.

### [Joda-Time]
- 표준 API가 너무 구려서 등장한 오픈소스 라이브러리. 불변 객체, 직관적인 API 제공.
- 자바 표준이 아니라는 점만 제외하면 완벽했음.

### [JDK 1.8] java.time 패키지 (Modern Standard)
- Joda-Time의 장점을 흡수하여 자바 표준(JSR-310)으로 탑재.
- 특징:
    1. 불변 객체(Immutable): 안전성 보장 (Thread-safe).
    2. 직관성: 월이 1부터 시작함. 메서드명이 명확함 (plusDays, withYear 등).
    3. 구성: LocalDate(날짜), LocalTime(시간), LocalDateTime(날짜+시간), ZonedDateTime(타임존) 등.

### [기타] 오픈소스의 대표 사례 
- 불편한 표준(Date, Calendar)을 대체하기 위해 오픈소스(Joda-Time)가 등장했고, 결국 그 철학이 자바 표준(Java 8)으로 흡수됨. (JPA가 Hibernate를 표준화한 것과 유사한 사례)

## 3. 자바 날짜와 시간 라이브러리 소개

### 기본 날짜와 시간 (Local)
- **LocalDate, LocalTime, LocalDateTime**
- 'Local'이라는 접두사는 세계 시간대(Timezone) 정보를 포함하지 않는다는 의미.
- 생일, 기념일, 혹은 특정 지역 내부의 스케줄 등 타임존 변환이 필요 없는 단순 날짜/시간 데이터에 사용.

### 타임존을 포함한 날짜와 시간 (Zoned)
- **ZonedDateTime**
    - 시간대(Timezone ID, 예: Asia/Seoul) 정보와 UTC 기준의 고정된 시차 정보(Offset, 예: +09:00) 포함하여 날짜와 시간을 표현.
    - 일광 절약 시간(DST) 규칙이 자동으로 적용됨.
- **OffsetDateTime**
    - UTC 기준의 고정된 시차(Offset) 정보만 포함.
    - 타임존 ID나 DST 규칙은 고려하지 않음. (DB 저장이나 로그 기록 등에 주로 사용)

### 기계 중심의 시간 (Instant)
- **Instant**
    - UTC 기준의 타임라인상 특정 지점(Timestamp)을 나타냄.
    - 1970년 1월 1일 0시(UTC)부터 경과된 시간을 초(Seconds)와 나노초(Nanoseconds) 단위로 저장.
    - 사람이 읽는 용도보다는 로그 기록, 실행 시간 측정 등 시스템 관점의 시간에 최적화됨.

### 시간의 간격 (Amount of Time)
- **Period**: 날짜 기반의 간격 (년, 월, 일). 예) "D-Day까지 1년 2개월 남음"
- **Duration**: 시간 기반의 간격 (시, 분, 초, 나노초). 예) "라면 끓이는 시간 4분 30초"

### 기타 부분적인 시간
- **Year, Month, YearMonth, MonthDay**
- 년도, 월, 혹은 '2024년 5월'이나 '12월 25일'처럼 특정 날짜 정보의 일부만 필요할 때 사용.

## 4. 날짜와 시간의 핵심 인터페이스

자바의 날짜/시간 라이브러리는 역할에 따라 명확하게 인터페이스가 분리되어 있음. 크게 '시간 자체'를 다루는 것과 '시간의 구성요소(단위, 필드)'를 다루는 것으로 나뉨.

### 1) 날짜와 시간 인터페이스 (Temporal 패밀리)
날짜와 시간을 표현하고 조작하기 위한 핵심 인터페이스들.

- **TemporalAccessor (Read-Only)**
    - 날짜와 시간 정보를 읽기(Read) 위한 최소한의 기능을 제공하는 상위 인터페이스.
    - 단순히 "지금이 몇 시지?"와 같이 정보를 조회하는 역할.
- **Temporal (Read & Write)**
    - `TemporalAccessor`의 하위 인터페이스로, 날짜와 시간을 조작(Write)하는 기능이 추가됨.
    - `plus`, `minus`, `with` 등의 메서드를 통해 시간을 더하거나 빼거나 변경 가능.
    - **구현체**: `LocalDateTime`, `ZonedDateTime`, `Instant` 등 우리가 주로 쓰는 클래스들.
- **TemporalAmount**
    - 시간의 간격(양, Amount)을 나타내는 인터페이스.
    - `Temporal` 객체에 더하거나 뺄 수 있는 시간의 양을 정의.
    - **구현체**: `Duration` (시간 기준), `Period` (날짜 기준).

### 2) 시간의 단위와 필드 (Unit vs Field)
시간을 측정하거나(단위), 특정 부분만 떼어내어(필드) 다루기 위한 개념.

- **TemporalUnit (시간의 단위)**
    - 시간을 측정하는 기준 단위를 의미. (얼마나 지났나? 무엇을 기준으로 더할까?)
    - 구현체: 주로 ChronoUnit 열거형(Enum)
    - 예) `DAYS`(일), `MONTHS`(월), `HOURS`(시간), `SECONDS`(초) 등.
- **TemporalField (시간의 필드)**
    - 날짜와 시간을 구성하는 **특정 항목(성분)**을 의미. (전체 날짜 중 '월'만 필요해!)
    - 구현체: ChronoField 열거형(Enum)
    - 예) `YEAR`(연도), `MONTH_OF_YEAR`(월), `DAY_OF_MONTH`(일), `HOUR_OF_DAY`(시) 등.
    - 비교: `2024년 8월 2일`이 있다면, 전체 데이터를 쪼개는 각각의 항목(연, 월, 일)이 바로 Field

### [참고] 시간 관련 개념의 기술적 구분 및 용도

**1. Period/Duration (객체) vs TemporalUnit (기준)**
- Period, Duration: 시간의 양(Amount)을 저장하는 객체. `plus(TemporalAmount)`와 같이 객체 자체를 넘겨 연산함.
- TemporalUnit (ChronoUnit): 미리 정의된 연산의 기준(Enum). `plus(10, ChronoUnit.DAYS)`와 같이 정수 값과 함께 넘겨, 해당 정수가 어떤 단위인지 정의함.

**2. TemporalUnit (단위) vs TemporalField (필드)**
- **TemporalUnit (단위)**: 상대적 연산에 사용.
    - 시간의 흐름(경과), 차이 계산, 덧셈/뺄셈에 관여.
    - 예) `DAYS`: 현재에서 1일이 지났다는 '크기'를 의미.
- **TemporalField (필드)**: 절대적 접근에 사용.
    - 날짜/시간 객체를 구성하는 특정 성분의 값 추출(Get) 및 수정(With).
    - 예) `DAY_OF_MONTH`: 이번 달의 며칠째인지 나타내는 '성분'을 의미.

**3. 기술적 동작 차이**
- Unit (덧셈): 1월 30일에 `1 Unit(Days)`를 더하면 1월 31일 (시간 흐름).
- Field (수정): 1월 30일의 `Field(Day)`를 1로 수정하면 1월 1일 (성분 교체).