# Style-classes added programmatically to nodes in JavaFX

Style classes are meant to be added just once to an element. Repeat
additions typically have no meaning in the HTML/CSS world. 

In JavaFX, the style classes associated with a node are stored as an 
`ObservableList<?>`. The `List` interface does not prevent styles from 
being added repeatedly. 

However, consider the situation where a style class needs to be used to 
indicate there are errors. Say dialog for some `Task A` requires input steps. 
At the end of a dialog, a text area indicates for `messages` indicating 
either errors in the inputs or that inputs are valid for the task to proceed.
A typical validation routine would check each input sequentially and add
the `error` style to `messages` if it found any errors in a particular input.
However, this has the potential to add the `error` style multiple times to
the `ObservableList<?>` corresponding to the styles classes associated with
the node. This could pose a problem when the validation routine wants to 
remove the `error` class if no errors are found as it doesn't necessarily know
how many attempts were made to correct errors and how many times the `error` 
class may have been added.

Here, I check what the contents of this `ObservableList<?>` are with repeated
attempts to add the same style class to a particular node in a JavaFX scene.