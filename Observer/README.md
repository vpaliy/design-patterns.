
# Intent #

Define a one-to-many dependency between objects so that when one object changes state, 
all its dependents are notified and automatically updated.

# Key concepts #

* `Observable` or `Subject` <br>

   A `Subject` or an `Observer` may have any number of dependent objects, known as observers. 
   When its state changes, it notifies every single subscriber. It sends out these notifications without 
   having to know who its observers are.
   
* `Observer`

   This is a dependent object of an `Observable`.
  
