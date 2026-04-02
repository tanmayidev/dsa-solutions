type F = (...args: number[]) => void

function debounce(fn: F, t: number): F {
    let timeoutId: ReturnType<typeof setTimeout>;

    return function(...args) {
        // Clear the previous timer if it exists
        clearTimeout(timeoutId);

        // Start a new timer that executes fn after t milliseconds
        timeoutId = setTimeout(() => {
            fn(...args);
        }, t);
    }
};

/**
 * const log = debounce(console.log, 100);
 * log('Hello'); // cancelled
 * log('Hello'); // cancelled
 * log('Hello'); // Logged at t=100ms
 */