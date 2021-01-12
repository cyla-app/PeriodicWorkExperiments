# PeriodicWorkExperiments

Android App doing nothing but periodically sending a get request.
Used for testing and evaluating methods on how to periodically perform some work.
Android Work Manager (AWM) PeriodicWorkRequests appear to be the best solution.

Methods discarded:
* Handlers - don't run when idle
* chained AWM OneTimeWorkRequests - exponentially multiply the number of requests after each round

Methods to potentially explore:
* AlarmManager

To do:
* Clarify: Is the work to be executed at the same time for every user or to be distributed over the day?
* Clarify: Is the work to be deferred while the device is in doze mode?
* Implement the above when decided and if needed
