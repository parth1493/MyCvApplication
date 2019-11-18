# MyCvApplication
An Android App that shows my CV and skill and about me.

 <img src="https://raw.githubusercontent.com/parth1493/MyCvApplication/master/UI/src/main/res/drawable/Screenshot_20191118-134926.png" width="200" style="max-width:100%;"> <img src="https://raw.githubusercontent.com/parth1493/MyCvApplication/master/UI/src/main/res/drawable/Screenshot_20191118-134935.png" width="200" style="max-width:100%;">  <img src="https://raw.githubusercontent.com/parth1493/MyCvApplication/master/UI/src/main/res/drawable/Screenshot_20191118-134941.png" width="200" style="max-width:100%;"> <img src="https://raw.githubusercontent.com/parth1493/MyCvApplication/master/UI/src/main/res/drawable/Screenshot_20191118-134946.png" width="200" style="max-width:100%;">  
 
 #### App Features
* Users can view my CV.
* Users can call me by presing call me tab.
* Users can connected me on linked of see my github or send me eamil.

#### App Architecture 
Based on mvvm architecture and repository pattern.

<img src="https://raw.githubusercontent.com/parth1493/MyCvApplication/master/UI/src/main/res/drawable/3.png" width="500" style="max-width:500%;">

 #### The app includes the following main components:

* A local database that servers as a single source of truth for data presented to the user. 
* A web api service.
* A repository that works with the database and the api service, providing a unified data interface.
* A ViewModel that provides data specific for the UI.
* The UI, which shows a visual representation of the data in the ViewModel.
* Unit Test cases for API service, Database, Repository and ViewModel.

#### App Module
* <b>domain</b> 
* <b>data</b>
* <b>remote</b> 
* <b>cache</b>
* <b>presentaion</b>
* <b>presentaion</b>

#### App Specs
* Minimum SDK 26
* [Java8](https://java.com/en/download/faq/java8.xml) (in [master](https://github.com/parth1493/MyCvApplication))
* MVVM Architecture
* Android Architecture Components (LiveData, Lifecycle, ViewModel, Room Persistence Library, Recycleview, Cardview)
* [RxJava2](https://github.com/ReactiveX/RxJava) for implementing Observable pattern.
* [Dagger 2](https://google.github.io/dagger/) for dependency injection.
* [Retrofit 2](https://square.github.io/retrofit/) for API integration.
* [Gson](https://github.com/google/gson) for serialisation.
* [Okhhtp3](https://github.com/square/okhttp) for implementing interceptor, logging and mocking web server.
* [Mockito](https://site.mockito.org/) for implementing unit test cases
* [Glide](https://github.com/bumptech/glide) for image loading.
