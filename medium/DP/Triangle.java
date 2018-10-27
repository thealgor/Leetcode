class Triangle {
    public int minimumTotal(List<List<Integer>> triangle) {
        List<Integer> list = new ArrayList(triangle.get(triangle.size()-1));
        int m = triangle.size();
        System.out.println(list);
        for(int layer=m-2;layer>=0;layer--){
            for(int j=0;j<=layer;j++){
                list.set(j,triangle.get(layer).get(j)+Math.min(list.get(j), list.get(j+1)));
            }
            //System.out.println(list);
        }
        return list.get(0);

    }
}