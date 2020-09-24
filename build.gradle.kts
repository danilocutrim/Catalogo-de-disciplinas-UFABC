import org.springframework.boot.gradle.tasks.bundling.BootJar

plugins {
	id("org.springframework.boot") version "2.3.3.RELEASE"
	id("io.spring.dependency-management") version "1.0.10.RELEASE"
	kotlin("jvm") version "1.3.72"
	kotlin("plugin.spring") version "1.3.72"
}

repositories {
	jcenter()
	mavenCentral()
}

subprojects{
	group = "br.com.ufabc"
	version = "0.0.1-SNAPSHOT"
	apply(plugin = "kotlin")
	apply(plugin = "idea")
	apply(plugin = "kotlin-spring")
	apply(plugin = "io.spring.dependency-management")
	apply(plugin = "org.springframework.boot")


	repositories {
		jcenter()
		mavenCentral()
	}
	dependencies {
		testImplementation("org.mockito:mockito-core:2.21.0")
		testImplementation("com.nhaarman:mockito-kotlin:1.6.0")
		testImplementation("org.junit.jupiter:junit-jupiter-api:5.6.2")
		testImplementation("org.junit.jupiter:junit-jupiter-engine:5.6.2")
		testImplementation("org.assertj:assertj-core:3.16.1")
		testImplementation("org.jeasy:easy-random-core:4.2.0")
		testImplementation("io.rest-assured:rest-assured:4.3.0")
		testImplementation("org.mockito:mockito-inline:3.3.3")
	}

	tasks.compileKotlin {
		kotlinOptions {
			freeCompilerArgs = listOf("-Xjvm-default=enable")
			allWarningsAsErrors = false
			jvmTarget = "1.8"
		}
	}
	tasks.withType<Test> {
		useJUnitPlatform()
	}
}

tasks.getByName<BootJar>("bootJar") {
	enabled = false
}

tasks.getByName<Jar>("jar") {
	enabled = true
}

