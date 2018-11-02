/*
// Employee info
class Employee {
    // It's the unique id of each node;
    // unique id of this employee
    public int id;
    // the importance value of this employee
    public int importance;
    // the id of direct subordinates
    public List<Integer> subordinates;
};
*/


//better solution
class Solution {
    Map<Integer, Employee> emap;
    public int getImportance(List<Employee> employees, int queryid) {
        emap = new HashMap();
        for (Employee e: employees) emap.put(e.id, e);
        return dfs(queryid);
    }
    public int dfs(int eid) {
        Employee employee = emap.get(eid);
        int ans = employee.importance;
        for (Integer subid: employee.subordinates)
            ans += dfs(subid);
        return ans;
    }
}



class Solution1{
    public int getImportance(List<Employee> employees, int id) {
        Map<Integer,Integer> mapImportance = new HashMap<>();
        Map<Integer,List<Integer>> mapSubordinates = new HashMap();

        for(Employee emp: employees){
            mapImportance.computeIfAbsent(emp.id, x -> emp.importance);
            mapSubordinates.computeIfAbsent(emp.id, x -> new ArrayList()).addAll(emp.subordinates);
        }

        int sum = mapImportance.get(id);
        for(int v: mapSubordinates.get(id)){
            Queue<Integer> q = new LinkedList();
            q.add(v);
            while(!q.isEmpty()){
                int a = q.poll();
                List<Integer> l = mapSubordinates.get(a);
                if(l.size()>0)
                    q.addAll(l);
                sum+=mapImportance.get(a);
            }
        }
        return sum;
    }



}