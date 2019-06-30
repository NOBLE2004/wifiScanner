# Android MVVM Base Architecture for Enterprise Mobile Application using Architectural Components

# Highlights

1. MVVM Architectural pattern
2. Offline Support
3. Unit test demonstration using JUnit and Mockito


The application has been built with **offline support**. It has been designed using **Android Architecture components** with **Room** for offline data caching. The application is built in such a way that whenvever there is a data update (Wifi List), the result will be stored in local database.

The whole application is built based on the MVVM architectural pattern.

# Application Architecture
![alt text](https://cdn-images-1.medium.com/max/1600/1*OqeNRtyjgWZzeUifrQT-NA.png)

The main advatage of using MVVM, there is no two way dependency between ViewModel and Model unlike MVP. Here the view can observe the datachanges in the viewmodel as we are using LiveData which is lifecycle aware. The viewmodel to view communication is achieved through observer pattern (basically observing the state changes of the data in the viewmodel).



# Programming Practices Followed
a) Android Architectural Components <br/>
b) Dagger 2 for Dependency Injection <br/>
c) MVVM <br/>
d) Room for data caching <br/>
e) JUnit and Mockito for Unit testing <br/>
f) Repository pattern <br/>


# How to build ?

Open terminal and type the below command to generate debug build <br/>

``` ./gradlew assembleDebug ```

Open terminal and type the below command to generate release build <br/>

``` ./gradlew assembleRelease ```



# How to generate code coverage report ?

Open terminal and type the following command

```./gradlew clean jacocoTestReport```

The coverage report will be generated on the following path.

``` app/build/reports ```
