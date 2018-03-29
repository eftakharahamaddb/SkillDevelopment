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

#### Material Design [SAMPLE EXMAPLE](https://github.com/AnderWeb/discreteSeekBar).
