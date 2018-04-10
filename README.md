# SkillDevelopment
Guideleines of Text writing
https://help.github.com/articles/basic-writing-and-formatting-syntax/#headings
Starting skill Development
## Material Design 
### ToolBar, ActionBar, Menu, NavigationDrawer... :
Simply old time we were using ActionBar in our android app to maintain the navigationm but now days it is deprecated and a this term is replaced with AppBar.

To use the app bar we ..
1) Always use Any them of AppCompact with Theme..... . NoActionBar. // Because we will setup our own app bar using ToolBar.
2) Craeate TollBar into seprate file, so that we can re use this toll bar according to our theme colors e..etc.
3) We can inflate the menu in that app bar, setup and enble home button, navigate to current to previuos activity using this button.

.....In above we can also add the collapsing tool bar according to nested scroll behavious, please see the 'AppBarCordinatorActivity' for the collapsable app bar.

4) For Drawer option we simply keep DrwerLayout on top of every layout, make two layout inside of it, one for drawer items and second for content items.. now as content items layout you can include your cordinator layout of constraint layout, wheteever u want according to need.

5) Now In this activity we setup same as toolbar and 'ActionBarDrawerToggle' and this manages the all state of open drawer and close drawer. below is the code of toggle..

```
ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(

                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState(); 
```

6) Now to setup the drawer content we can use the NavigationView and setting the menus , it is the best way to manage the drawer...but if we want it according our own recycler view or expandable recycler view we can set it.

Material Design [Sample 1](https://github.com/saulmm/Android-Material-Examples).
Material Design [Sample 2](https://github.com/rey5137/material).
Material Design [Sample 3](https://github.com/wasabeef/awesome-android-ui).

## Android Development Architecture Patterns
Architecture pattern [Here](https://developer.android.com/topic/libraries/architecture/guide.html#common_architectural_principles).

Generally for development of android we uses Activities, Fragment, Services, Content provider and Broadcast receiver...

For example, consider what happens when you share a photo in your favorite social network app. The app triggers a camera intent from which the Android OS launches a camera app to handle the request. At this point, the user leaves the social network app but their experience is seamless. The camera app, in turn, may trigger other intents, like launching the file chooser, which may launch another app. Eventually the user comes back to the social networking app and shares the photo. Also, the user could be interrupted by a phone call at any point in this process and come back to share the photo after finishing the phone call.

The point of all this is that your app components can be launched individually and out-of-order, and can be destroyed at anytime by the user or the system. Because app components are ephemeral and their lifecycle (when they are created and destroyed) are not under your control, you should not store any app data or state in your app components and your app components should not depend on each other.


