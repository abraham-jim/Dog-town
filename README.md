# Dog-town

Android Basics II: Project 1 - Dog of the Day

In this project, you’ll build an app that displays an image of the dog using the API https://dog.ceo/dog-api/documentation/.

Your completed app should:
Display a dog image (a jpg image is returned from calling the endpoint https://dog.ceo/api/breeds/image/random)
Have a button that lets the user generate a new image

Sample app screenshot:

![DogTown1](https://user-images.githubusercontent.com/73762759/145702166-e50cfb25-b12e-4b62-bd5f-242e19961572.png)

![DogTown2](https://user-images.githubusercontent.com/73762759/145702170-90f138a2-99c0-4928-b6d2-7fcb27e61fea.png)


Notes about the API:
The main endpoint we’ll be utilizing is: https://dog.ceo/api/breeds/image/random 

The API response from that endpoint looks like:
{
    "message": "https://images.dog.ceo/breeds/briard/n02105251_7738.jpg",
    "status": "success"
}

You can read more about the specific endpoint here: https://dog.ceo/dog-api/documentation/random 
Topics covered:
Understand how to make web API requests using network calls
Understand how to parse API responses 
Understand how to load images from a network location and display them
Resources:
Optional Inspirational Quotes exercise (https://github.com/calren/InspirationalQuotesExercise)
Complete project demonstrating how to make API requests and parse API responses
Android Basics pathway: Get and display data from the internet
Extra Challenges:
Let user input dog breed and see dog images from just that breed (check out endpoints for breed specific images: ​​https://dog.ceo/dog-api/documentation/breed)
Add loading and error images (you can see examples of how to do this in Step 3 of the Load and display images from the Internet codelab)
