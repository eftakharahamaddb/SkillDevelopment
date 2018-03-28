# SkillDevelopment
Guideleines of Text writing
``
 1) Using emoji
 You can add emoji to your writing by typing :EMOJICODE:
 @octocat :+1: This PR looks great - it's ready to merge! :shipit:
 https://www.webpagefx.com/tools/emoji-cheat-sheet/
 
 2) Task lists
 To create a task list, preface list items with [ ]. To mark a task as complete, use [x]
 
 3) Lists
 You can make an unordered list by preceding one or more lines of text with - or *.
	- George Washington
	- John Adams
	- Thomas Jefferson
 
 4) Nested List
 You can create a nested list by indenting one or more list items below another item.
 1. First list item
   - First nested list item
     - Second nested list item
 
 5) Relative links
 You can define relative links and image paths in your rendered files to help readers navigate to other files in your repository.
 [Contribution guidelines for this project](docs/CONTRIBUTING.md)
 
 6 Section links
 You can link directly to a section in a rendered file by hovering over the section heading to expose the link:
 
 7) Links
 You can create an inline link by wrapping link text in brackets [ ], and then wrapping the URL in parentheses ( ). You can also use the keyboard shortcut command + k to create a link.
 
 8) Quoting code
 You can call out code or a command within a sentence with single backticks. The text within the backticks will not be formatted.
 Use `git status` to list all new or modified files that haven't yet been committed.
 
 9) Quoting text
 You can quote text with a >.
 
 In the words of Abraham Lincoln:
 
> Pardon my French

10) Styling text

Bold				**
Italic				*
Strikethrough 		~~
Bold and italic		** ** and _ _


11) Headings
# The largest heading
## The second largest heading
###### The smallest heading


``
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

