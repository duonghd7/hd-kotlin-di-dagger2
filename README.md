# Kotlin Dependency Injection With Dagger2

### Prepare
1. Install [Android Studio](https://developer.android.com/studio/index.html) version 3.0.1 or more
2. Create new android project and check on **"Include Kotlin support"**

![image](https://user-images.githubusercontent.com/18477507/35255147-2ea4d6c4-0020-11e8-84c0-4e57b42d8b3c.png)

### I. Compile library
- [build.gradle](https://github.com/duonghd7/hd-kotlin-di-dagger2/blob/master/app/build.gradle) module app
```
    apply plugin: "kotlin-kapt"

    def dagger = 2.24
    def daggerCompiler = 2.24

    kapt {
        generateStubs = true
    }

    dependencies {
        ...

        implementation "com.google.dagger:dagger:$dagger"
        implementation "com.google.dagger:dagger-android:$dagger"
        kapt "com.google.dagger:dagger-compiler:$daggerCompiler"
        kapt "com.google.dagger:dagger-android-processor:$daggerCompiler"
    }
```

### II. Config
1. Create folder and files folow structure
```
    PACKAGE
    |-- domain
        |-- home
            |-- HomeActivity.kt
            |-- HomeComponent.kt
        |-- second
            |-- SecondActivity.kt
            |-- SecondComponent.kt
    |-- infrastructures
        |-- model
            |-- Person.kt
        |-- module
            |-- ActivityModule.kt
            |-- ApplicationComponent.kt
            |-- ApplicationModule.kt
        |-- scope
            |-- ActivityScope.kt
            |-- ApplicationScope.kt
    |-- MainApplication.kt
```

2. Create files and content flow as
- [ApplicationScope.kt](https://github.com/duonghd7/hd-kotlin-di-dagger2/blob/master/app/src/main/java/hd/kotlin/dagger2/infrastructures/scope/ApplicationScope.kt)
- [ActivityScope.kt](https://github.com/duonghd7/hd-kotlin-di-dagger2/blob/master/app/src/main/java/hd/kotlin/dagger2/infrastructures/scope/ActivityScope.kt)
- [ApplicationModule.kt](https://github.com/duonghd7/hd-kotlin-di-dagger2/blob/master/app/src/main/java/hd/kotlin/dagger2/infrastructures/module/ApplicationModule.kt)
- [ApplicationComponent.kt](https://github.com/duonghd7/hd-kotlin-di-dagger2/blob/master/app/src/main/java/hd/kotlin/dagger2/infrastructures/module/ApplicationComponent.kt)
- [ActivityModule.kt](https://github.com/duonghd7/hd-kotlin-di-dagger2/blob/master/app/src/main/java/hd/kotlin/dagger2/infrastructures/module/ActivityModule.kt)
- [Person.kt](https://github.com/duonghd7/hd-kotlin-di-dagger2/blob/master/app/src/main/java/hd/kotlin/dagger2/infrastructures/model/Person.kt)
- [HomeActivity.kt](https://github.com/duonghd7/hd-kotlin-di-dagger2/blob/master/app/src/main/java/hd/kotlin/dagger2/domain/home/HomeActivity.kt)
- [HomeComponent.kt](https://github.com/duonghd7/hd-kotlin-di-dagger2/blob/master/app/src/main/java/hd/kotlin/dagger2/domain/home/HomeComponent.kt)
- [SecondActivity.kt](https://github.com/duonghd7/hd-kotlin-di-dagger2/blob/master/app/src/main/java/hd/kotlin/dagger2/domain/second/SecondActivity.kt)
- [SecondComponent.kt](https://github.com/duonghd7/hd-kotlin-di-dagger2/blob/master/app/src/main/java/hd/kotlin/dagger2/domain/second/SecondComponent.kt)
- [MainApplication.kt](https://github.com/duonghd7/hd-kotlin-di-dagger2/blob/master/app/src/main/java/com/hdd/kotlindiwithdagger2/MainApplication.kt)
- [AndroidManifest.xml](https://github.com/duonghd7/hd-kotlin-di-dagger2/blob/master/app/src/main/AndroidManifest.xml)
```
    <application
        ...
        android:name=".MainApplication">
        
        ...
    </application>
```
- [activity_home.xml](https://github.com/duonghd7/hd-kotlin-di-dagger2/blob/master/app/src/main/res/layout/activity_home.xml)
- [activity_second.xml](https://github.com/duonghd7/hd-kotlin-di-dagger2/blob/master/app/src/main/res/layout/activity_second.xml)

### III. Use
- In [ApplicationModule](https://github.com/duonghd7/hd-kotlin-di-dagger2/blob/master/app/src/main/java/com/hdd/kotlindiwithdagger2/infrastructures/module/ApplicationModule.kt), create [Person](https://github.com/duonghd7/hd-kotlin-di-dagger2/blob/master/app/src/main/java/com/hdd/kotlindiwithdagger2/infrastructures/model/Person.kt) for app
```
    @Module
    class ApplicationModule(val app: Application) {
        ...

        @Provides
        @ApplicationScope
        fun providePerson(): Person {
            return Person("Alice", 30)
        }
    }
```
- In [ApplicationComponent](https://github.com/duonghd7/hd-kotlin-di-dagger2/blob/master/app/src/main/java/com/hdd/kotlindiwithdagger2/infrastructures/module/ApplicationComponent.kt) provide resources created by [ApplicationModule](https://github.com/duonghd7/hd-kotlin-di-dagger2/blob/master/app/src/main/java/com/hdd/kotlindiwithdagger2/infrastructures/module/ApplicationModule.kt)
```
    @ApplicationScope
    @Component(modules = arrayOf(ApplicationModule::class))
    interface ApplicationComponent {
        fun person(): Person
    }
```
- In each activity will inject to use without create new **Person**
```
    @Inject lateinit var person: Person
```
**HomeActivity:**

<kbd>![image](https://user-images.githubusercontent.com/18477507/35257627-fbb50a06-002c-11e8-834b-bc3e99e8bf1d.png)</kbd>

**SecondActivity:**

<kbd>![image](https://user-images.githubusercontent.com/18477507/35257653-2640bcfc-002d-11e8-8d24-8a560aa46214.png)</kbd>
