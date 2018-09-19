'''
list of integers must first be sorted by frequency and then by value.
example [4, 5, 6, 5, 4, 3] => [3, 6, 4, 4, 5, 5]
'''
import collections

def custom_sort(arr):
    map = collections.defaultdict(list)
    arrcount = collections.Counter(arr)

    for a in arrcount:
        map[arrcount[a]].append(a)

    keylist = [mkey for mkey in map]

    keylist.sort()
    ans = []
    for key in keylist:
        for val in sorted(map[key]):
            ans += [val] * key

    print(ans)


custom_sort([4, 5, 6, 5, 4, 3])
