# Mcon.Agnum 환경 변수 표준 [MCO-661]

## 필수 환경 변수

| 환경 변수 | 기본값 | 용도 |
|-----------|--------|------|
| `MCON_LOCAL_MAVEN_REPO` | `~/mcon-maven-repo` | 로컬 Maven artifact 저장소 경로 |
| `LIB_VERSION` | `1.0.0-SNAPSHOT` | 배포할 라이브러리 버전 |

---

## 개발 환경 설정 방법

### macOS / Linux (~/.zshrc 또는 ~/.bashrc)

```bash
# Mcon.Agnum 로컬 Maven 저장소
export MCON_LOCAL_MAVEN_REPO="$HOME/mcon-maven-repo"
```

설정 후 적용:
```bash
source ~/.zshrc
```

### Windows (PowerShell 프로파일)

```powershell
$env:MCON_LOCAL_MAVEN_REPO = "$env:USERPROFILE\mcon-maven-repo"
```

---

## 로컬 배포 명령

### SNAPSHOT 배포 (개발 중)

```bash
# 모든 모듈 로컬 Maven에 배포
./gradlew publishAllPublicationsToLocalDirRepository

# 특정 모듈만 배포
./gradlew :core:core-ui:publishAllPublicationsToLocalDirRepository
```

### 특정 버전으로 배포

```bash
LIB_VERSION=1.0.0 ./gradlew publishAllPublicationsToLocalDirRepository
```

---

## 소비 프로젝트 설정 (mcon-platform 등)

### settings.gradle.kts

```kotlin
// Composite Build 조건부 활성화 (개발/디버깅용)
val agnumDir = file("../mcon-agnum")
if (agnumDir.exists()) {
    includeBuild(agnumDir) {
        dependencySubstitution {
            substitute(module("com.mc-on:core-network")).using(project(":core:core-network"))
            substitute(module("com.mc-on:core-database")).using(project(":core:core-database"))
            substitute(module("com.mc-on:core-testing")).using(project(":core:core-testing"))
            substitute(module("com.mc-on:core-ui")).using(project(":core:core-ui"))
            substitute(module("com.mc-on:shared")).using(project(":shared"))
        }
    }
}

dependencyResolutionManagement {
    repositories {
        // 로컬 Maven 저장소 (프로덕션 빌드)
        val localMavenRepo = System.getenv("MCON_LOCAL_MAVEN_REPO")
            ?: "${System.getProperty("user.home")}/mcon-maven-repo"
        maven { url = uri(localMavenRepo) }

        google()
        mavenCentral()
    }
}
```

### 앱 모듈 build.gradle.kts

```kotlin
dependencies {
    // BOM으로 버전 일괄 관리
    implementation(platform("com.mc-on:mcon-agnum-bom:1.0.0"))

    // 버전 생략 가능
    implementation("com.mc-on:core-ui")
    implementation("com.mc-on:core-network")
    implementation("com.mc-on:shared")
}
```

---

## 디렉토리 구조 예시

```
~/mcon-maven-repo/
└── com/
    └── mc-on/
        ├── mcon-agnum-bom/
        │   └── 1.0.0/
        │       ├── mcon-agnum-bom-1.0.0.pom
        │       └── mcon-agnum-bom-1.0.0.module
        ├── core-network/
        │   └── 1.0.0/
        │       ├── core-network-1.0.0.module
        │       └── core-network-1.0.0.pom
        ├── core-network-android/
        │   └── 1.0.0/
        │       ├── core-network-android-1.0.0.aar
        │       └── core-network-android-1.0.0.pom
        └── ...
```

---

## CI/CD 환경 (GitHub Actions)

GitHub Actions에서는 `MCON_LOCAL_MAVEN_REPO`를 워크스페이스 내 경로로 지정하고
빌드 후 artifact로 업로드합니다. 다운스트림 CI에서 해당 artifact를 다운로드 후
동일 경로에 배치하여 사용합니다.

자세한 내용은 `.github/workflows/publish-local.yml` 및 `release.yml` 참조.
