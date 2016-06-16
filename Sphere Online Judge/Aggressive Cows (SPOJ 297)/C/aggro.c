#include <stdlib.h>
#include <stdio.h>
#include <unistd.h>

#define BUFSIZE 512
#define STD_IN 0
#define MAX_STALLS 100000
#define MAX_POSITION 1000000000
#define MIN_POSITION 0

void merge(int *array, int *lhs, int *rhs, int lcount, int rcount) {
    int arrIdx, lhsIdx, rhsIdx;
    arrIdx = lhsIdx = rhsIdx = 0;

    while (lhsIdx < lcount && rhsIdx < rcount) {
        if (lhs[lhsIdx] < rhs[rhsIdx])
            array[arrIdx++] = lhs[lhsIdx++];
        else
            array[arrIdx++] = rhs[rhsIdx++];
    }

    while (lhsIdx < lcount)
        array[arrIdx++] = lhs[lhsIdx++];

    while (rhsIdx < rcount)
        array[arrIdx++] = rhs[rhsIdx++];
}

void mergeSort(int *array, int n) {
    if (n < 2)
        return;

    int i;
    int mid = n / 2;
    int* lhs = malloc(mid * sizeof(int));
    int* rhs = malloc((n-mid) * sizeof(int));
    
    for (i = 0; i < mid; i++)
        lhs[i] = array[i];

    for (; i < n; i++)
        rhs[i-mid] = array[i];

    mergeSort(lhs, mid);
    mergeSort(rhs, (n-mid));

    merge(array, lhs, rhs, mid, (n-mid));

    free(lhs);
    free(rhs);

}

int main(void) {
    int numTests = 0;
    int numStalls = 0;
    int numCows = 0;
    int i;

    if (!fscanf(stdin, "%d", &numTests)) {
        fprintf(stderr, "scan # of tests failed\n");
        return 2;
    }

    for (i = 0; i < numTests; i++) {
        /* get N and C */
        if (fscanf(stdin, "%d%d", &numStalls, &numCows) < 2) {
            fprintf(stderr, "scan # of stalls and cows failed");
            return 2;
        }
        int j;
        int stalls[numStalls];

        for (j = 0; j < numStalls; j++) {
            if (!fscanf(stdin, "%d", &stalls[j])) {
                fprintf(stderr, "scan of stall location failed");
                return 2;
            }
        }
        
        mergeSort(stalls, numStalls);

        int max = stalls[numStalls-1];
        int min = 0;
        int largest_minDist;

        while (min < max) {
            int numCowsSheltered = 1;
            int prevCowIdx = 0;
            int mid = min + ((max - min) / 2);
            int k;

            for (k = 0; k < numStalls; k++) {
                if ((stalls[k] - stalls[prevCowIdx]) < mid) {
                    continue;
                }
                prevCowIdx = k;
                numCowsSheltered++;
            }

            if (numCowsSheltered < numCows) { /* number too big */
                max = mid;
            } else { /* number just right, or can be bigger */
                largest_minDist = mid;
                min = largest_minDist + 1;
            }
        }
        fprintf(stdout, "%d\n", largest_minDist);
    }
    return 0;
}
