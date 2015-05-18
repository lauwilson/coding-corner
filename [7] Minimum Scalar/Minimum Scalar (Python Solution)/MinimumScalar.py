def main():
    print('Starting Minimum Scalar')
    f = open('A-small-practice.in', 'r')
    print(f.name + '\n=======')
    find_minimum(f)
        


def set_output(file):
    name = file.name
    name = name.split('.')[0]
    output = open(name + '-output.txt', 'w')
    return output

def find_minimum(file):
    output = set_output(file)
    numberTestCases = int(file.readline())

    for case in range(1, numberTestCases):
        vectorSize = int(file.readline())
        vector1 = get_vector(file.readline())
        vector2 = get_vector(file.readline())
        vector1.sort()
        vector2.sort()
        minimumVector = 0

        for i, j in zip(range(1, vectorSize), range(vectorSize, 1, -1)):
            minimumVector += vector1[i-1] * vector2[j-1]
        
        print('Case #' + str(case) + ': ' + str(minimumVector))

def get_vector(vectorString):
    return [int(x) for x in vectorString.split()]

if __name__ == '__main__':
    string = "1 2 3 4 5 6 7"
    print(get_vector(string))
    #main()

