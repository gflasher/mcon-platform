// mcon-agnum BOM (Bill of Materials) 모듈 [MCO-661]
// groupId: com.mc-on
// artifactId: mcon-agnum-bom
//
// 소비자 사용법 (신규 앱 build.gradle.kts):
//   implementation(platform("com.mc-on:mcon-agnum-bom:1.0.0"))
//   implementation("com.mc-on:core-network")          // 버전 생략 가능
//   implementation("com.mc-on:core-ui")

plugins {
    `java-platform`
    `maven-publish`
}

val libVersion: String = System.getenv("LIB_VERSION")
    ?: project.findProperty("libVersion")?.toString()
    ?: "1.0.0-SNAPSHOT"

val localMavenRepo: String = System.getenv("MCON_LOCAL_MAVEN_REPO")
    ?: "${System.getProperty("user.home")}/mcon-maven-repo"

// BOM은 다른 모듈을 제약(constraints)으로 선언
dependencies {
    constraints {
        // KMP 공통 아티팩트
        api("com.mc-on:core-network:$libVersion")
        api("com.mc-on:core-database:$libVersion")
        api("com.mc-on:core-testing:$libVersion")
        api("com.mc-on:core-ui:$libVersion")
        api("com.mc-on:shared:$libVersion")

        // Android 타겟 아티팩트 (kotlin-multiplatform 자동 생성)
        api("com.mc-on:core-network-android:$libVersion")
        api("com.mc-on:core-database-android:$libVersion")
        api("com.mc-on:core-testing-android:$libVersion")
        api("com.mc-on:core-ui-android:$libVersion")
        api("com.mc-on:shared-android:$libVersion")
    }
}

publishing {
    publications {
        create<MavenPublication>("bom") {
            groupId = "com.mc-on"
            artifactId = "mcon-agnum-bom"
            version = libVersion
            from(components["javaPlatform"])

            pom {
                name.set("Mcon.Agnum BOM")
                description.set("Bill of Materials for Mcon.Agnum library modules")
                url.set("https://github.com/mc-on/mcon-agnum")
            }
        }
    }

    repositories {
        maven {
            name = "LocalDir"
            url = uri(localMavenRepo)
        }
    }
}
