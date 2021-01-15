Heap from Scratch using Down Heaping.

No additional libraries used!

<b>Features:</b>
- Change heap sorting mode between min and max
- Check for internal & external
- If Heap is full, doubles the size of the heap

<b>Efficency Cases:</b>
- Inserting a node:<br>
    <b>Best:</b> O(1)</b> | <b>Worst:</b> O(logn)
    
- Removing a node:<br>
    <b>Best:</b> O(1) | <b>Worst:</b> O(logn)
    
- Down Heaping:<br>
    <b>Best:</b> O(1) | <b>Worst:</b> O(logn)
    
- Find min/max:<br>
    <b>Best:</b> O(1)</b> | <b>Worst:</b> O(1)
    
- Increasing size:<br> 
    <b>Best:</b> O(1) | <b>Worst:</b> O(n)
    
- Swapping modes:<br> 
    <b>Best:</b> O(1) | <b>Worst (Tight Big O)</b>: O(n) (because we are doing an inorder traversal)
