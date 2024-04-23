<h1 align="center">Daily forecast Application</h1>
Daily forecast application is a simple application consisting of only one screen
with a top bar containing a dropdown menu , this dropdown menu contains cities
names then when the user clicks the search the app hit api and get daily
forecast data for given city name, and cache it.

If a user faces any failure in data retrieval, the app first check if needed
data exists in local cache. If yes app display cached data and show some
warning to indicate it’s not accurate data, if no data cached he see UI
represent this error and option to retry.

## Screenshots
<div align="center">

</div>

## :rocket: Tech stack
- [Clean Architecture](https://blog.cleancoder.com/uncle-bob/2012/08/13/the-clean-architecture.html)
- [Jetpack Compose](https://developer.android.com/jetpack/compose?gclid=CjwKCAiAzKqdBhAnEiwAePEjktk3ROIIxTqejhHWkDEwSaQqoE6GgrNHM8iYKw8xHx5SPPDu0oJ_DxoC8LYQAvD_BwE&gclsrc=aw.ds)
- [Koin dependency injection](https://insert-koin.io/)
- [MVVM](https://en.wikipedia.org/wiki/Model%E2%80%93view%E2%80%93viewmodel)
- [Coroutines](https://developer.android.com/kotlin/coroutines)
- [Retrofit](https://square.github.io/retrofit/)
- [Room](https://developer.android.com/jetpack/androidx/releases/room)
- API Documentation link: https://openweathermap.org/forecast5


## Architecture 
This project uses **MVVM (Model View View-Model)** with **Clean Architecture**.
<div align="center">

</div>

## How to build on your environment
Add your API key for News Api in secret.properties file.
- API_KEY="YOUR_API_KEY"
