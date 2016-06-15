def main():
    """
    Main driver function for MinimumScalar.py
    """

    print('Starting Minimum Scalar')
    f1 = open('A-small-practice.in', 'r')
    find_minimum(f1)
    f1.close()

    f2 = open('A-large-practice.in', 'r')
    find_minimum(f2)
    f2.close()
        


def set_output(file):
    """
    Returns a new file with the same file prefix as the input.

    Args:
        file : The input file from which data is read.
    """

    name = file.name
    name = name.split('.')[0]
    output = open(name + '-output.txt', 'w')
    return output

def find_minimum(file):
    """
    Finds the minimum vectors of all case inputs from the file.

    Function outputs the minimum vector for each case into a file.

    Args:
        file : The file with information regarding the number of cases
               and vector size.
    """

    output = set_output(file)
    numberTestCases = int(file.readline())

    for case in range(0, numberTestCases):
        vectorSize = int(file.readline())
        vector1 = get_vector(file.readline())
        vector2 = get_vector(file.readline())
        vector1.sort()
        vector2.sort()
        minimumVector = 0

        # minimum vector equals sum of smallest element in vector1 multiplied with 
        # largest element in vector2, repeated for each incrementally larger/smaller
        # element in each list.
        for i, j in zip(range(0, vectorSize), range(vectorSize, 0, -1)):
            minimumVector += vector1[i] * vector2[j-1]
        
        print('Case #' + str(case+1) + ': ' + str(minimumVector))
        output.write('Case #' + str(case+1) + ': ' + str(minimumVector) + '\n')

    output.flush()
    output.close()

def get_vector(vectorString):
    """
    Returns an int array representing a vector.

    Args:
        vectorString : The ints of the vector read from file as a string.

    Returns:
        An int[] representing the vector.
    """

    return [int(x) for x in vectorString.split()]

# main entry point for script.
if __name__ == '__main__':
    main()

