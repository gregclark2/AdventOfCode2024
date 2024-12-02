

def main():
    infile = open('../../Day1_1input.txt')
    leftList = []
    rightList = []



    #prime read
    line = infile.readline()
    buffer = line.split()
    leftList.append(buffer[0])
    rightList.append(buffer[1])
    result1 = 0


    while line:
        line = infile.readline()
        buffer = line.split()
        if buffer:

            leftList.append(buffer[0])
            rightList.append(buffer[1])

    leftList.sort()
    rightList.sort()
    counter = 0
    while counter < len(leftList):
        print(leftList[counter])
        result1 = result1 + abs(int(leftList[counter]) - int(rightList[counter]))

        counter += 1

    print(len(leftList))
    print(counter)
    print(result1)
    print(leftList)

    #part 2

    #get rid of duplicates
    leftset = set(leftList)
    rightset = set(rightList)
    #gives us single unique matches to use as keys
    union_set = leftset.union(rightset)

    counts = {}
    for s in union_set:
        for r in rightList:
            if s == r:
                if s not in counts:
                    counts.update({s: 1})
                else:
                    update_num = counts.get(s)
                    update_num += 1
                    counts.update({s: update_num})
    result2 = 0
    for key, value in counts.items():
        result2 += int(key) * int(value)
    print(result2)

# current answer for part 2 here is 57345675, should be 26407426
# I got it in Java
main()
