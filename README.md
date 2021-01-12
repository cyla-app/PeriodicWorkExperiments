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

Findings for AWM PeriodicWorkRequests so far:
* After initially starting the app, it sends requests every 1 to 2 minutes
* After sending the app to the background for the first time, it sends requests every 15 minutes, +-2min
    * That is if the device is not in doze mode
    * If in doze mode, no requests are made until the app is in foreground
    * When it is in foreground, the missed requests are now made
    * Afterwards, the cycle continues as usual
* Adding an initial delay (e.g. for sending requests at a fixed time of the day) does not work properly
    using the pre-implemented AWM methods
