from typing import List


class HW7:
    def minMeetingRooms(self, intervals: List[List[int]]) -> int:
        intervals = sorted(intervals, key = lambda  x : x[0])
        activeRooms = []
        maxRooms = 0
        for i in range(len(intervals)):
            j = len(activeRooms)
            while j > 0:
                if activeRooms[j - 1][1] <= intervals[i][0]:
                    activeRooms.pop(j - 1)
                j -= 1
            activeRooms.append(intervals[i])
            if len(activeRooms) > maxRooms:
                maxRooms = len(activeRooms)
        return maxRooms

    # O(n) solution
    def minMeetingRooms2(self, intervals: List[List[int]]) -> int:
        intervals = sorted(intervals, key=lambda x: x[1],reverse=True)
        startTimes = []
        endTimes = []
        for i in intervals:
            endTimes.append(i[1])
        intervals = sorted(intervals, key=lambda x: x[0],reverse=True)
        for i in intervals:
            startTimes.append(i[0])
        maxRooms = 0
        minRooms = 0
        while len(startTimes) > 0:
            time = 0
            if startTimes[-1] <= endTimes[-1]:
                time = startTimes[-1]
            else:
                time = endTimes[-1]
            while len(startTimes) > 0 and startTimes[-1] == time:
                startTimes.pop()
                minRooms += 1
            while len(endTimes) > 0 and endTimes[-1] == time:
                endTimes.pop()
                minRooms -= 1
            if minRooms > maxRooms:
                maxRooms = minRooms
        return maxRooms

hw7 = HW7()
interval = [[0,5],[5,10],[15,20]]
print(hw7.minMeetingRooms(interval))
print(hw7.minMeetingRooms2(interval))