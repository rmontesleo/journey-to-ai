plugins {
	java
	id("org.springframework.boot") version "3.3.4"
	id("io.spring.dependency-management") version "1.1.6"
}

group = "com.oreilly.ai.demo"
version = "0.0.1-SNAPSHOT"

java {
	toolchain {
		languageVersion = JavaLanguageVersion.of(21)
	}
}

repositories {
	mavenCentral()
}

dependencies {
	// https://mvnrepository.com/artifact/com.google.code.gson/gson
	implementation("com.google.code.gson:gson:2.11.0")

	implementation ("dev.langchain4j:langchain4j-open-ai:0.35.0")
	implementation ("dev.langchain4j:langchain4j:0.35.0")

	// Logging
	implementation("org.slf4j:slf4j-api:2.0.12")
	implementation("ch.qos.logback:logback-classic:1.5.3")
	implementation("org.apache.logging.log4j:log4j-core:2.23.1")

	
	testImplementation(platform("org.junit:junit-bom:5.10.0"))
	testImplementation("org.junit.jupiter:junit-jupiter")
}

tasks.test {
	useJUnitPlatform()
}
