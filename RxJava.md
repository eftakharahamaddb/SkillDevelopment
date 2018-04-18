# RxJava

### Sources :
**Observable\<T\>**    
  1) 0 or n items
  2) Complete or error<br>
  3) Does not have backpressure
  
**Flowable\<T\>**
  1) 0 or n items
  2) Complete or error
  3) Has backpressure
  
  >Backpressure Means:It allows to controle how fast source can be emits data.
  e.g. when we uses motione event or database quesry
