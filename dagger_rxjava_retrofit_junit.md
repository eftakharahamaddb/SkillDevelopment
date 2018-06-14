1) Making App with many methods and class... can cause a web like complicated pattern and will not fall into 'SOLID' pattern<br>

S - Single Responsibility Pattern.
O - Open-closed Principle
L - Liskov Substitution Principle
I - Interface Segregations Principle
D - Dependency Inversion Principle

<h2>Dagger 2: Dagger is a dependency injection </h2>
<br/> Before we go here are some term we must understand
 
 ```

 @Provides
 @Inject
 @Component
 @Module
 
  1) Which object do you want to inject ?
     -- use @Provides to create a method that return this object.
	 
  2) Where do u want to inject this object?
     -- use @Inject in the place where u want to use this and 
		create an interface @Component that contains all th places where u will use this object.
	 
  3) How will u construct this object ?
	 -- create a class @Module that contains your method with @Provides in it.

 Fresh way of understanding is below the image of defining different term...
 
 ```
 ![](https://github.com/eftakharahamaddb/SkillDevelopment/blob/master/images/dagger_snappet.JPG)
