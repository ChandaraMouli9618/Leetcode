class Solution {
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        int n = profits.length;
        Queue<Project> projectQueue = new PriorityQueue<>(new Comparator<Project>() {
            @Override
            public int compare(Project a, Project n) { 
                if (a.p == n.p) {
                    return a.c.compareTo(n.c); 
                }
                return n.p.compareTo(a.p); 
            }
        });

        Project[] projects = new Project[n];
        for (int i = 0; i < n; i++)
            projects[i] = new Project(capital[i], profits[i]);
        Arrays.sort(projects);
        // for (Project p : projects)
        //     System.out.println(p.toString());

        int start = 0;

        while (k > 0 && start < n) {
            if (w >= projects[start].c)
                projectQueue.add(projects[start++]);
            else {
                if (projectQueue.isEmpty())
                    return w;

                Project currNode = projectQueue.poll();
                w += currNode.p;
                k--;
            }
        }
        while (k-- > 0 && !projectQueue.isEmpty())
            w += (projectQueue.poll().p);
        return w;
    }
}

class Project implements Comparable<Project> {
    Integer c;
    Integer p;

    Project(Integer c, Integer p) {
        this.c = c;
        this.p = p;
    }

    public String toString() {
        return "Capital : " + c + "\nProfit : " + p + '\n';
    }

    public int compareTo(Project project) {
        if (c == project.c)
            return project.p.compareTo(p);
        return c.compareTo(project.c);
    }
}