package medium.Backtracking;

class FactorCombinations {
    public List<List<Integer>> getFactors(int n) {
        List<List<Integer>> results = new ArrayList<List<Integer>>();
        List<Integer> result = new ArrayList<Integer>();
        getFactors(2,result, n,results);
        return results;
    }

    public void getFactors(int start, List<Integer> result, int n,List<List<Integer>> results){
        if(n<=1){
            if(result.size()>1){
                results.add(new ArrayList<Integer>(result));
            }
        }

        for(int i=start;i<=n;i++){
            if(n%i==0){
                result.add(i);
                getFactors(i,result,n/i,results);
                result.remove(result.size()-1);
            }
        }

    }

