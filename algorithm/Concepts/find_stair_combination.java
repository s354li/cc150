public static ArrayList<ArrayList<Integer>> findStepLists(int stairs) {
    ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
    if (stairs == 0) {
      result.add(new ArrayList<Integer>());
      return result;
    }
    if (stairs < 0) {
      return null;
    }
    for (int i : new int[] { 1, 2, 3 }) {
      if (findStepLists(stairs - i) != null) {
        ArrayList<ArrayList<Integer>> allLists = findStepLists(stairs - i);
        for (ArrayList<Integer> item : allLists) {
          item.add(i);
        }
        result.addAll(allLists);
      }
    }
    return result;
  } 