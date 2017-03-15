
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
   Defines an updating interface for object that should be notified of changes.
   
# Applicability #

* When a change to one object requires a change to other objects.

* When an object should notify other objects without knowing who these objects are.
  These objects(receivers) may have only one thing in common - which is data.<br>

* When an abstraction has two aspects, one dependent on the
  other.Encapsulating these aspects in separate objects lets you vary
  and reuse them independently.
  
# Known issues #

1. Who triggers the update method?<br>
   Basically, we have two options:<br>
  
  * We can update the observes after the subject's state has been changed. The advantage of this approach is that clients don't need to remember to call the `notify` method manually. The disadvantage is that several consecutive operations will cause several consecutive updates, which may be inefficient.<br>
  
  * We can make clients be responsible for calling the update method. The advantage is that we can code more efficient comparing to previous approach. However, the client have an added responsibility to trigger the update.
