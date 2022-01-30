import java.io.*;
import java.util.*;
import java.lang.*;
import java.util.stream.*;

/*
Power Set: Write a method to return all subsets of a set.
*/
class Solution {
  public static void main(String[] args) {
    ArrayList<Integer> input = new ArrayList<Integer>();
    input.add(5);
    input.add(10);
    input.add(13);
    input.add(15);
    // input.add(18);
    ArrayList<ArrayList<Integer>> result = getSubsets(input, 0);
    ArrayList<ArrayList<Integer>> result2 = findSubSet2(input);

    System.out.println(result.size());
    for (ArrayList<Integer> item : result) {
      System.out.println(Arrays.toString(item.toArray()));
    }
    
    System.out.println(result2.size());
    for (ArrayList<Integer> item : result2) {
      System.out.println(Arrays.toString(item.toArray()));
    }
  }
  
  public static ArrayList<ArrayList<Integer>> findSubSet(ArrayList<Integer> input) {
    ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
    ArrayList<Integer> item = new ArrayList<Integer>();
    result.add(item);
    
    if (input.size() > 0) {
      
      for (int i = 0; i < input.size(); i++) {
        ArrayList<Integer> current = new ArrayList<Integer>();
        if (i + 1 <= input.size()) {
          // System.out.println(Arrays.toString(input.subList(index + 1, input.size()).toArray()));
          current.addAll(input.subList(i + 1, input.size()));
        }
        ArrayList<ArrayList<Integer>> subResult = findSubSet(current);
        for (ArrayList<Integer> sub : subResult) {
          ArrayList<Integer> newsubset = new ArrayList<Integer>();
          newsubset.addAll(sub); //
          newsubset.add(input.get(i));
          result.add(newsubset);
        }
      }
    }
    return result;
  }
  
  public static ArrayList<ArrayList<Integer>> findSubSet2(ArrayList<Integer> input) {
    ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
    if (input.size() == 0) {
      ArrayList<Integer> item = new ArrayList<Integer>();
      result.add(item);
    } else {
      ArrayList<Integer> current = new ArrayList<Integer>();
      if (1 <= input.size()) {
        current.addAll(input.subList(1, input.size()));
      }
      ArrayList<ArrayList<Integer>> subResult = findSubSet(current);
      result.addAll(subResult);
      for (ArrayList<Integer> sub : subResult) {
        ArrayList<Integer> newsubset = new ArrayList<Integer>();
        newsubset.addAll(sub); //
        newsubset.add(input.get(0));
        result.add(newsubset);
      }
    }
    return result;
  }
  
  
  public static ArrayList<ArrayList<Integer>> getSubsets(ArrayList<Integer> set, int index) {
    ArrayList<ArrayList<Integer>> allsubsets;
    if (set.size()== index) {
      allsubsets = new ArrayList<ArrayList<Integer>>();
      allsubsets.add(new ArrayList<Integer>()); // Empty set
    } else {
      allsubsets = getSubsets(set, index+ 1);
      int item= set.get(index);
      ArrayList<ArrayList<Integer>> moresubsets = new ArrayList<ArrayList<Integer>>();
      for (ArrayList<Integer> subset : allsubsets) {
        ArrayList<Integer> newsubset = new ArrayList<Integer>();
        newsubset.addAll(subset); //
        newsubset.add(item);
        moresubsets.add(newsubset);
      }
      allsubsets.addAll(moresubsets);
    }
    return allsubsets;
  } 
}
