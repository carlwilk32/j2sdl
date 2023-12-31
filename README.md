j2sdl (Java-to-SDL)
========

j2sdl is a complete mapping of SDL2 APIs to Java, including extension libs such as SDL_mixer, SDL_image, etc.

## Usage

### Gradle

Add platform dependency to *j2sdl-bom*, followed by other required sdl2 components, for example:

```groovy
dependencies {
    implementation(platform('com.github.carlwilk32:j2sdl-bom:1.0-SNAPSHOT'))
    implementation 'com.github.carlwilk32:j2sdl-core'
    implementation 'com.github.carlwilk32:j2sdl-image'
    implementation 'com.github.carlwilk32:j2sdl-mixer'
}
``` 

Provide definition for GitHub Package Repository within your build script.
NOTE: GitHub Package
Repository [doesn't allow anonymous read](https://docs.github.com/en/packages/learn-github-packages/introduction-to-github-packages#authenticating-to-github-packages)
for public packages. Moreover, GitHub doesn't allow any personal token (string with prefix `ghp_`) to be included in
public repo and will automatically delete corresponding token. As a workaround you can use string interpolation
until [official solution](https://github.com/orgs/community/discussions/26634) will be available.

```groovy
def notSoSecret = 'TF5SxPsRe9qbAueowQKasXChyV7Wry4b0nER'
repositories {
    mavenCentral()
    maven {
        url = uri("https://maven.pkg.github.com/carlwilk32/*")
        credentials {
            username = 'carlwilk32'
            password = "ghp_${notSoSecret}"
        }
    }
}
```

### Maven

For Maven you need to declare dependency management separately as follows

```xml

<dependencyManagement>
    <dependencies>
        <dependency>
            <groupId>com.github.carlwilk32</groupId>
            <artifactId>j2sdl-bom</artifactId>
            <version>1.0-SNAPSHOT</version>
        </dependency>
    </dependencies>
</dependencyManagement>
```

And then declare required dependencies, for example:

```xml

<dependencies>
    <dependency>
        <groupId>com.github.carlwilk32</groupId>
        <artifactId>j2sdl-core</artifactId>
    </dependency>
    <dependency>
        <groupId>com.github.carlwilk32</groupId>
        <artifactId>j2sdl-image</artifactId>
    </dependency>
</dependencies>
```

Additionally, you will need to provide definition for new repo to your settings.xml, for more details refere to official
guide [here](https://docs.github.com/en/packages/working-with-a-github-packages-registry/working-with-the-apache-maven-registry#authenticating-with-a-personal-access-token).

## Publish

This project is configured to publish all libraries to the GitHub Package Registry.
To do so run

```shell
./gradlew publish
```

if you need to publish only specific version than you can provide a fully qualified name, like

```shell
./gradlew :j2sdl-core:publish
```

## More details

Read library specific README to get further details:

- [j2sdl-core](j2sdl-core/README.md)
