package com.fh.arithmetic;

import org.junit.Test;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class Test1 extends BaseTest {

    @Test
    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if(map.containsKey(complement)){
                return new int[]{map.get(complement),i};
            }
            map.put(nums[i],i);
        }

        return null;
    }



     public class ListNode {
          int val;
          ListNode next;
         ListNode(int x) { val = x; }
      }


    @Test
    public ListNode reverseLinkList(ListNode node) {

        return null;
    }

}
