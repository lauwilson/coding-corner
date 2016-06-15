#include <stdlib.h>
#include <stdio.h>
#include <unistd.h>

#define BUFSIZE 512
#define STD_IN 0
#define MAX_STALLS 100000

int main(void) {
    int numTests;
    int numStalls;
    int numCows;
    int i;
    char buffer[BUFSIZE];

    numTests = 0;
    numStalls = 0;
    numCows = 0;
    /* get num of tests */
    if (!fgets(buffer, BUFSIZE, stdin)) {
        clearerr(stdin);
        return 1;
        /* TODO: check EOF or error */
    }

    if (!sscanf(buffer, "%d", &numTests)) {
        fprintf(stderr, "scan # of tests failed\n");
        return 2;
    }
    fprintf(stderr, "numTests: %d\n", numTests);

    for (i = 0; i < numTests; i++) {
        /* get N and C */
        if (!fgets(buffer, BUFSIZE, stdin)) {
            clearerr(stdin);
            return 1;
        }
        if (!sscanf(buffer, "%d%d", &numStalls, &numCows)) {
            fprintf(stderr, "scan # of stalls and cows failed");
            return 2;
        } else {
            int j;
            int stalls[MAX_STALLS];

            fprintf(stderr, "numStalls: %d\nnumCows: %d\n", numStalls, numCows);
            for (j = 0; j < numStalls; j++) {
                if (!fgets(buffer, BUFSIZE, stdin)) {
                    clearerr(stdin);
                    return 1;
                }
                if (!sscanf(buffer, "%d", &stalls[j])) {
                    fprintf(stderr, "scan of stall location failed");
                    return 2;
                }
                fprintf(stderr, "location: %d\n", stalls[j]);
            }
            stalls[j] = '\0';

            /* actual logic */


        }

        /* Read in the stall locations */
    }


    return 0;
}
