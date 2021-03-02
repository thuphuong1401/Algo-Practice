/*
https://massivealgorithms.blogspot.com/2016/03/dropbox-interview-misc.html

Write a class for an ID allocator that can allocate and release IDs
*/

First approach: 
- Use a queue and a hash set. Queue contains free ID, hash set contains allocated IDs.
- allocate(): 
  + Check whether the queue is empty. If empty => runs out of free ID to allocate. If not, poll queue, add such value to hash set (make that value allocated)
- release():
  + Remove value from hash set. Add back to queue
=> O(1) both operations, but O(n) space

-----------------------------------------------------

Second approach:
- Use bitset to save space. Still O(1) both operations but saves space

-----------------------------------------------------

Third approach:
- Use binary heap

https://github.com/insideofdrop/Dropbox-Interview-Prep/blob/main/code/allocate_id.py
