j2sdl (Java-to-SDL)
========

j2sdl is a complete mapping of SDL2 APIs to Java, including extension libs such as SDL_mixer, SDL_image, etc.

## How to use it

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

## More details

Read library specific README to get further details:
- [j2sdl-core](j2sdl-core/README.md)
