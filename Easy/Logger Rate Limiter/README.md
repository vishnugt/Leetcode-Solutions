Question: https://leetcode.com/problems/logger-rate-limiter/

 

This might look like an easy question, but there are two approaches.

Naive Approach : Just have a map with key vs last received message time, which is okay.

Best Approach: You have a linked list of tuple of messageKey and time, and a hashSet of messageKeys

 