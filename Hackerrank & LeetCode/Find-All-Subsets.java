    public static List<List<Integer>> findAllSubsets(int[] set) {
        int n = set.length;
        List<List<Integer>> allSubSets = new ArrayList<List<Integer>>();
        for(int i = 0; i < (1<<n); i++) {
            List<Integer> temp = new ArrayList<>();
            for(int j = 0; j < n; j++) {
                if((i & (1 << j)) > 0) {
                    temp.add(set[j]);
                }
            }
            allSubSets.add(temp);
        }
        return allSubSets;
    }
