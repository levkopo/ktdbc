# Kotlin Database Connectivity
[![Kotlin Alpha](https://kotl.in/badges/experimental.svg)](https://kotlinlang.org/docs/components-stability.html)
[![Maven Central](https://img.shields.io/maven-central/v/com.github.levkoposc/ktdbc-core)](https://mvnrepository.com/artifact/com.github.levkoposc/ktdbc-core)
[![GitHub license](https://img.shields.io/badge/license-Apache%20License%202.0-blue.svg?style=flat)](https://www.apache.org/licenses/LICENSE-2.0)
[![Kotlin](https://img.shields.io/badge/kotlin-1.7.20-blue.svg?logo=kotlin)](http://kotlinlang.org)

## Documentation
Dokka: https://levkopo.github.io/ktdbc/

## Install
### Maven
```xml
<!--Common-->
<dependency>
   <groupId>com.github.levkoposc</groupId>
   <artifactId>ktdbc-core</artifactId>
   <version>$ktdbcVersion</version>
</dependency>

<!--JVM-->
<dependency>
    <groupId>com.github.levkoposc</groupId>
    <artifactId>ktdbc-core-jvm</artifactId>
    <version>$ktdbcVersion</version>
</dependency>

<!--Native-->
<dependency>
    <groupId>com.github.levkoposc</groupId>
    <artifactId>ktdbc-core-native</artifactId>
    <version>$ktdbcVersion</version>
</dependency>

<!--JS-->
<dependency>
    <groupId>com.github.levkoposc</groupId>
    <artifactId>ktdbc-core-js</artifactId>
    <version>$ktdbcVersion</version>
</dependency>
```

### Gradle Groovy
```groovy
dependencies {
    // Common
    implementation "com.github.levkoposc:ktdbc-core:$ktdbcVersion"

    // JVM
    implementation "com.github.levkoposc:ktdbc-core-jvm:$ktdbcVersion"
    
    // Native
    implementation "com.github.levkoposc:ktdbc-core-native:$ktdbcVersion"
    
    // JS
    implementation "com.github.levkoposc:ktdbc-core-js:$ktdbcVersion"
}
```


### Gradle Kotlin
```groovy
dependencies {
    // Common
    implementation("com.github.levkoposc:ktdbc-core:$ktdbcVersion")

    // JVM
    implementation("com.github.levkoposc:ktdbc-core-jvm:$ktdbcVersion")
    
    // Native
    implementation("com.github.levkoposc:ktdbc-core-native:$ktdbcVersion")
    
    // JS
    implementation("com.github.levkoposc:ktdbc-core-js:$ktdbcVersion")
}
```