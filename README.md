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
 <img src="https://github.com/AzizaHelmy/Daily_Forecast/assets/31763341/4ce9cf09-d748-4a24-8159-0f43f3d2fe61" alt="Screenshot 1" width="200" style="border: 5px solid #ccc; border-radius: 15px;">
  <img src="https://github.com/AzizaHelmy/Daily_Forecast/assets/31763341/7ef84154-f7b3-4171-a422-f2e8ba8897b0" alt="Screenshot 2" width="200" style="border: 5px solid #ccc; border-radius: 15px;">
  <img src="https://github.com/AzizaHelmy/Daily_Forecast/assets/31763341/bc43b549-9514-4ad5-b667-0f3165e1ac93" alt="Screenshot 3" width="200" style="border: 5px solid #ccc; border-radius: 15px;">
  <img src="https://github.com/AzizaHelmy/Daily_Forecast/assets/31763341/7565a40c-85aa-4092-a1b4-66713d868437" alt="Screenshot 3" width="200" style="border: 5px solid #ccc; border-radius: 15px;">
  <img src="https://github.com/AzizaHelmy/Daily_Forecast/assets/31763341/79ac818a-2b6c-4588-b955-9fceb69508b2" alt="Screenshot 3" width="200" style="border: 5px solid #ccc; border-radius: 15px;">
   <img src="https://github.com/AzizaHelmy/Daily_Forecast/assets/31763341/bcb890a0-6638-4624-be64-0cf1315ded49" alt="Screenshot 3" width="200" style="border: 5px solid #ccc; border-radius: 15px;">
</div>

## Achivments 🎉🎉

enjoy: https://wakatime.com/@aziza/projects/fdgiutzvmx?start=2024-04-17&end=2024-04-23

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
This project uses **MVVM (Model View View-Model).
<div align="center">

</div>

## How to build on your environment
Add your API key for News Api in secret.properties file.
- API_KEY="YOUR_API_KEY"
