# mcon-agnum 신규 프로젝트 시작 가이드

이 디렉토리는 mcon-agnum을 참조하는 신규 Android 앱 프로젝트를 빠르게 시작하기 위한 템플릿입니다.

## 빠른 시작 (Quick Start)

### 1. 사전 요구사항

- mcon-agnum 로컬 Maven 배포 완료:
  ```bash
  cd mcon-agnum
  ANDROID_HOME=/home/gflasher/android-sdk \
    MCON_LOCAL_MAVEN_REPO=~/mcon-maven-repo \
    LIB_VERSION=1.0.0 \
    ./gradlew publishAllPublicationsToLocalDirRepository
  ```

### 2. 새 앱 디렉토리 생성

```bash
mkdir my-new-app && cd my-new-app
```

### 3. 템플릿 파일 복사

```bash
TEMPLATE=mcon-platform/config/new-app-template

cp $TEMPLATE/settings.gradle.kts .
mkdir -p gradle app
cp $TEMPLATE/gradle/libs.versions.toml gradle/
cp $TEMPLATE/app/build.gradle.kts app/
```

### 4. 앱 정보 수정

- `settings.gradle.kts`: `rootProject.name = "my-new-app"` → 실제 앱 이름
- `app/build.gradle.kts`:
  - `namespace = "com.example.mynewapp"` → 실제 패키지명
  - `applicationId = "com.example.mynewapp"` → 실제 앱 ID

### 5. 빌드 확인

```bash
ANDROID_HOME=/home/gflasher/android-sdk \
  MCON_LOCAL_MAVEN_REPO=~/mcon-maven-repo \
  ./gradlew :app:assembleDebug
```

## 파일 구조

```
new-app-template/
├── settings.gradle.kts        # 로컬 Maven 저장소 + 모듈 등록
├── gradle/
│   └── libs.versions.toml     # mcon-agnum BOM + 의존성 버전 카탈로그
├── app/
│   └── build.gradle.kts       # 앱 모듈 — BOM 기반 의존성 선언
└── README.md                  # 이 파일
```

## mcon-agnum 버전 업데이트

1. `gradle/libs.versions.toml`에서 버전 변경:
   ```toml
   mcon-agnum = "1.1.0"   # 새 버전
   ```
2. 빌드 확인:
   ```bash
   MCON_LOCAL_MAVEN_REPO=~/mcon-maven-repo ./gradlew :app:assembleDebug
   ```

## 더 알아보기

- [mcon-agnum ONBOARDING.md](../../../mcon-agnum/ONBOARDING.md)
- 로컬 Maven 저장소: `~/mcon-maven-repo/com/mc-on/`
