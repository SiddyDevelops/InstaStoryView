# InstaStoryView

<p align="center">
  <img height=200px src="https://user-images.githubusercontent.com/72121163/152954424-8740f28c-b8d2-4188-aa0f-41c2c03fb839.png" />
<p/>

## About
***The InstaStoryView is a custom Android library which is hosted on ***Jitpack***. This library allows user to easily use the Instagram-Story like features in their Android Applications. All you need to do is add ImageURLs, ProfileURL and what you will get is a progressive and interactive story view in which you can pause a progressive story and move forwards or backwards.*** 

[![](https://jitpack.io/v/SiddyDevelops/InstaStoryView.svg)](https://jitpack.io/#SiddyDevelops/InstaStoryView)
![Minimum SDK Version](https://img.shields.io/badge/minSdkVersion-23-brightgreen)
[![Platform](https://img.shields.io/badge/platform-android-green.svg)](http://developer.android.com/index.html)

---

## Installation:
- Step 1. Add it in your root build.gradle at the end of repositories:
```
allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
```
- Step 2. Add the dependency:
```
dependencies {
	        implementation 'com.github.SiddyDevelops:InstaStoryView:1.0.0'
	}
```

---

## Usage:
- The very first step is to include ``<uses-permission android:name="android.permission.INTERNET" />`` in the ``AndroidManifest.xml`` of your project.

- In order to use the functionality of this library you need to create your own RecyclerView-Adapters and Viewholders which will inflate the StoryViewer. So all the code/modifications are needed to be done inside the RecyclerViewAdapter.

![01](https://user-images.githubusercontent.com/72121163/153535279-3df75127-384b-4e65-81a6-359c55353459.png)

---
	
## From the Developer:

This Android Library is developed by <a href="https://siddydevelops.github.io/">Siddharth Singh<a/>. Show your support by forking and liking this repository.
  
Follow my <a href="https://github.com/SiddyDevelops#connect-with-me">Social Handles<a/> for more projects.
  
Enjoy Coding!! 🚀 ✨

---
