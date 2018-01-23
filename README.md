# Kotlin Dependency Injection With Dagger2

### Prepare
1. Install [Android Studio](https://developer.android.com/studio/index.html) version 3.0.1 or more
2. Create new android project and check on "Include Kotlin support"

![image](https://user-images.githubusercontent.com/18477507/35255147-2ea4d6c4-0020-11e8-84c0-4e57b42d8b3c.png)

### I. Compile library
- [build.gradle](https://github.com/duonghd7/hd-kotlin-di-dagger2/blob/master/app/build.gradle) module app
```
    apply plugin: "kotlin-kapt"

    def AAVersion = '4.4.0'
    def daggerVersion = '2.11'

    kapt {
        generateStubs = true
    }

    dependencies {
        ...

        kapt "org.androidannotations:androidannotations:$AAVersion"
        implementation "org.androidannotations:androidannotations-api:$AAVersion"

        kapt "com.google.dagger:dagger-compiler:$daggerVersion"
        implementation "com.google.dagger:dagger:$daggerVersion"
        provided 'org.glassfish:javax.annotation:10.0-b28'
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
    |-- infastructures
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
- [ApplicationScope.kt](https://github.com/duonghd7/hd-kotlin-di-dagger2/blob/master/app/src/main/java/com/hdd/kotlindiwithdagger2/infrastructures/scope/ApplicationScope.kt)
- [ActivityScope.kt](https://github.com/duonghd7/hd-kotlin-di-dagger2/blob/master/app/src/main/java/com/hdd/kotlindiwithdagger2/infrastructures/scope/ActivityScope.kt)
- [ApplicationModule.kt](https://github.com/duonghd7/hd-kotlin-di-dagger2/blob/master/app/src/main/java/com/hdd/kotlindiwithdagger2/infrastructures/module/ApplicationModule.kt)
- [ApplicationComponent.kt](https://github.com/duonghd7/hd-kotlin-di-dagger2/blob/master/app/src/main/java/com/hdd/kotlindiwithdagger2/infrastructures/module/ApplicationComponent.kt)
- [ActivityModule.kt](https://github.com/duonghd7/hd-kotlin-di-dagger2/blob/master/app/src/main/java/com/hdd/kotlindiwithdagger2/infrastructures/module/ActivityModule.kt)
- [Person.kt](https://github.com/duonghd7/hd-kotlin-di-dagger2/blob/master/app/src/main/java/com/hdd/kotlindiwithdagger2/infrastructures/model/Person.kt)
- [HomeActivity.kt](https://github.com/duonghd7/hd-kotlin-di-dagger2/blob/master/app/src/main/java/com/hdd/kotlindiwithdagger2/domain/home/HomeActivity.kt)
- [HomeComponent.kt](https://github.com/duonghd7/hd-kotlin-di-dagger2/blob/master/app/src/main/java/com/hdd/kotlindiwithdagger2/domain/home/HomeComponent.kt)
- [SecondActivity.kt](https://github.com/duonghd7/hd-kotlin-di-dagger2/blob/master/app/src/main/java/com/hdd/kotlindiwithdagger2/domain/second/SecondActivity.kt)
- [SecondComponent.kt](https://github.com/duonghd7/hd-kotlin-di-dagger2/blob/master/app/src/main/java/com/hdd/kotlindiwithdagger2/domain/second/SecondComponent.kt)
- [MainApplication.kt](https://github.com/duonghd7/hd-kotlin-di-dagger2/blob/master/app/src/main/java/com/hdd/kotlindiwithdagger2/MainApplication.kt)
- Edit [AndroidManifest.xml](https://github.com/duonghd7/hd-kotlin-di-dagger2/blob/master/app/src/main/AndroidManifest.xml)
```
    <application
        android:name=".MainApplication_"
        ...

        <activity android:name=".domain.home.HomeActivity_">
              <intent-filter>
                  <action android:name="android.intent.action.MAIN"/>
                  <category android:name="android.intent.category.LAUNCHER"/>
              </intent-filter>
          </activity>

          <activity android:name=".domain.second.SecondActivity_"/>
    </application>
```

### III. Use
- In [ApplicationModule](https://github.com/duonghd7/hd-kotlin-di-dagger2/blob/master/app/src/main/java/com/hdd/kotlindiwithdagger2/infrastructures/module/ApplicationModule.kt), create [Person](https://github.com/duonghd7/hd-kotlin-di-dagger2/blob/master/app/src/main/java/com/hdd/kotlindiwithdagger2/infrastructures/model/Person.kt) for app.
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
- In [ApplicationComponent](https://github.com/duonghd7/hd-kotlin-di-dagger2/blob/master/app/src/main/java/com/hdd/kotlindiwithdagger2/infrastructures/module/ApplicationComponent.kt) provide resources created by [ApplicationModule](https://github.com/duonghd7/hd-kotlin-di-dagger2/blob/master/app/src/main/java/com/hdd/kotlindiwithdagger2/infrastructures/module/ApplicationModule.kt).
```
    @ApplicationScope
    @Component(modules = arrayOf(ApplicationModule::class))
    interface ApplicationComponent {
        fun person(): Person
    }
```
- In each activity will inject to use without create new Person
```
    @Inject lateinit var person: Person
```
> HomeActivity:

<kbd>![image](https://user-images.githubusercontent.com/18477507/35257627-fbb50a06-002c-11e8-834b-bc3e99e8bf1d.png)</kbd>

> SecondActivity:

<kbd>![image](https://user-images.githubusercontent.com/18477507/35257653-2640bcfc-002d-11e8-8d24-8a560aa46214.png)</kbd>
