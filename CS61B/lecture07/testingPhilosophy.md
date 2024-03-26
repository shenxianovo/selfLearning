# ADD (Autograder Driven Ddevelopment)
- Worst way to approach programming
- Read and (mostly) understand the spec.
- Write entire program.
- Compile. Fix all compilation errors.
- Send to autograder. Get many errors.
- Until correct, repeat randomly.(Run autograder; add print statements to zero in one bug; make changes)


slow and unsafe...  guess and fix

# Unit Test 
- JUnit
## Why
- Build condidence in basic modules.
- Decrease deguging time
- Clarify the task
## Why not
- Building tests need time.
- May provide false confidence.
- Hard to test units that rely on others.

# TDD (Test Driven Development)
- Identify a new feature.
- Write a unit test for that feature.
- Run the test, it should be fail.
- Write the code that passes that test.
- Refactor code to make it faster, cleaner, etc.

# Integrated Testing
idea: Tests cover many units at once.
- Not JUnit's focus, but JUnit can do this.
## Why
- Unit testing is not enough to ensure modules interact properly or that system works as expected.
## Why not
- Can be tedious to do manully.
- Can be challenging to automate.
- Testing at highest level of abstruction may miss subtle or rare errors.
 
