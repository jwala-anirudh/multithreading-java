# Multi-threading in Java

![State of threads](./assets/state%20of%20threads.png)

## Main Thread Basics in Java

- Every Java application starts with a default thread called `main`.
- `Thread.currentThread()` returns a reference to the currently executing thread.
- You can get and set:
    - Thread name using `getName()` / `setName(String)`
    - Thread priority using `getPriority()` / `setPriority(int)` (range: 1 to 10, default is 5)
- `Thread.sleep(ms)` pauses the current thread; throws `InterruptedException`.
- The main thread is managed by the JVM and is part of the `Thread` class like any user-defined thread.
- No new threads are created here — just manipulating the existing one.
- Changing name/priority of the main thread is usually just for demo or debugging purposes.

## Sequential Execution Limitation

- Contains three independent tasks: `addition()`, `focus()`, and `printingStars()`.
- All are called sequentially by the main thread — no concurrency.
- `addition()` blocks execution because it waits for user input via `Scanner`.
- Even though `focus()` and `printingStars()` are unrelated to input, they can’t start until `addition()` finishes.
- `focus()` and `printingStars()` both simulate delays using `Thread.sleep(4000)` to mimic time-consuming tasks.
- Demonstrates how single-threaded execution can be inefficient when tasks are independent.
- Sets the stage for introducing multi-threading to run such tasks in parallel.

## Object Separation Without Concurrency

- Breaks independent tasks into separate classes: `Alpha1`, `Beta1`, and `Gamma1`.
- Each class handles one task:
    - `Alpha1.addition()` — user input
    - `Beta1.focus()` — prints message with delay
    - `Gamma1.printingStars()` — prints stars with delay
- Despite the separation of concerns, all tasks still run sequentially.
- Problem from previous file persists: input in `addition()` blocks everything else.
- Demonstrates that splitting logic into different classes doesn't solve execution delay unless actual threads are introduced.
- Prepares the ground to shift from sequential to multi-threaded execution.

## Introducing Multi-threading via Thread Class

- Converts each independent task (`addition`, `focus`, `printingStars`) into its own thread by extending `Thread` class.
- Overrides `run()` method in each class to execute the respective task logic.
- Uses `start()` to initiate concurrent execution of all three threads along with the main thread.
- Calling `run()` directly (instead of `start()`) would execute sequentially — no actual threading.
- Now, user input in `addition()` no longer blocks the other two tasks.
- JVM handles thread scheduling; order of output may vary across runs.
- Shows basic, effective use of multi-threading by extending `Thread`.

## Multi-threading via Runnable Interface

- Refactors thread logic using `Runnable` instead of extending `Thread`.
- Each task class (`Alpha3`, `Beta3`, `Gamma3`) implements `Runnable` and defines logic in `run()`.
- To execute, we create `Thread` objects with Runnable instances and call `start()` on them.
- `Runnable` is preferred over `Thread` inheritance in real-world apps for better object-oriented design and flexibility.
- Threads now run independently — user input or sleep delays in one don’t block the others.
- Thread scheduling and output order are managed by JVM and may vary across runs.
- Demonstrates decoupling task logic from thread management.

## Thread Behavior via Thread Name

- Single `Runnable` class (`Activity`) handles all three tasks.
- Logic inside `run()` branches based on the current thread’s name (`Thread.currentThread().getName()`).
- Three threads are created using the same `Runnable` instance but given distinct names: `ADD`, `FOCUS`, `STAR`.
- Each thread runs a different method (`addition`, `focus`, `printingStars`) based on its name.
- Avoids creating multiple classes or multiple `Runnable` objects — leaner design.
- Demonstrates a common trick to control thread behavior using naming.
- All threads execute independently — concurrent behavior based on task split.

## Thread Synchronization: Method vs Block Level

- Demonstrates thread safety using two approaches:
    - **Method-level locking** (`MyParkingLot.run()` is fully `synchronized`)
    - **Block-level locking** (`MyCar.run()` synchronizes only the critical section)
- Both classes simulate shared car usage with multiple threads.
- Three threads are created per approach, using the same object instance — ensures shared resource context.
- `methodLevelLocking()` → entire `run()` is synchronized; thread-safe but less flexible.
- `blockLevelLocking()` → only the "driving" part is synchronized; allows more concurrency outside the critical section.
- Purpose: prevent race conditions when threads access shared resources.
- Shows difference between locking the full method vs. locking only the required code block.
- Helps understand trade-off: **safety vs performance**.

## Thread Join and Completion Control

- Builds on the previous version by introducing `join()` to manage thread completion order.
- `join()` makes the main thread wait until the target thread finishes execution.
- Ensures that `t1`, `t2`, and `t3` fully complete before the main thread proceeds.
- Prevents premature termination of the main thread while other threads are still running.
- Still includes `isAlive()` to check thread state before and after `start()` and `join()`.
- Key learning: `join()` is crucial when thread completion order matters or when you need full coordination between threads.

## Nested Synchronization & Resource Locking

- Simulates two threads (`Rohan`, `Bishnu`) trying to acquire multiple shared resources (books).
- Each thread tries to lock the same three objects (`java`, `devOps`, `aws`) in the same order using nested `synchronized` blocks.
- Since both threads access resources in **same sequence**, deadlock is avoided.
- Demonstrates how nested locks work and why **consistent locking order** is crucial.
- If threads tried to lock resources in different order, this would risk deadlock.
- Useful pattern to learn **multi-lock coordination** and how to avoid concurrency issues in shared environments.

## Deadlock Scenario with Inconsistent Lock Order

- Same setup as previous file: two threads (`Rohan`, `Bishnu`) accessing shared book resources.
- **Key difference**: threads acquire locks in **different order**:
  - `Rohan`: `AWS → DevOps → Java`
  - `Bishnu`: `Java → DevOps → AWS`
- This **mutual dependency** can lead to deadlock — each thread holds one lock and waits for the other.
- Classic deadlock example: both threads block forever if timing aligns.
- Demonstrates why maintaining a consistent locking order is critical in multi-threaded environments.
- Useful for explaining deadlock conditions and prevention in interviews.
