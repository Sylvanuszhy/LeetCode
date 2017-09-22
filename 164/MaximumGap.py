class Solution(object):
    def maximumGap(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        n = len(nums)
        if n<2:
            return 0
        maxVal = max(nums)
        minVal = min(nums)
        bucket = max((maxVal-minVal)/(n-1), 1)
        m = (maxVal-minVal)/bucket+1
        l = [None]*m

        for num in nums:
            k = (num-minVal)/bucket
            if l[k] is None:
                l[k] = (num, num)
            else:
                if num<l[k][0]:
                    l[k] = (num, l[k][1])
                if num>l[k][1]:
                    l[k] = (l[k][0], num)
        
        maxGap = 0
        last = l[0][1]
        for i in range(1, m):
            if l[i] is not None:
                if l[i][0]-last>maxGap:
                    maxGap = l[i][0]-last
                last = l[i][1]
        
        return maxGap

solu = Solution()
nums = [1,1,2,2,2,5,5]
res = solu.maximumGap(nums)
print(res)
