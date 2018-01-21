class Point:
    def __init__(self, a=0, b=0):
        self.x = a
        self.y = b

class Solution:
    def maxPoints(self, points):
        """
        :type points: List[Point]
        :rtype: int
        """
        n = len(points)
        d = {}
        maxCount = 0
        for i in range(n):
            d.clear()
            t = 0
            overlap = 0
            for j in range(i+1, n):
                x = points[i].x-points[j].x
                y = points[i].y-points[j].y
                if x == 0 and y == 0:
                    overlap += 1
                    continue
                m = self.gcd(x, y)
                x /= m
                y /= m
                if (x, y) in d:
                    d[(x, y)] += 1
                else:
                    d[(x, y)] = 1
                t = max([t, d[(x, y)]])
            maxCount = max([maxCount, t+overlap+1])
        return maxCount
    
    def gcd(self, a, b):
        if b == 0:
            return a
        else:
            return self.gcd(b, a%b)
    