import java.util.*;
import java.io.*;
import java.lang.*;
public class Main
{
    public static class pair implements Comparable<pair>
    {
        int vtx;
        int wt;
        pair(int vtx,int wt)
        {
            this.vtx=vtx;
            this.wt=wt;
        }
        public int compareTo(pair other)
        {
            return this.wt-other.wt;
        }
    }
    public static int dij(ArrayList<pair>[] graph,int src,int dest)
    {
        int [] visited=new int[graph.length];
        Arrays.fill(visited,Integer.MAX_VALUE);
        PriorityQueue<pair> pq=new PriorityQueue<>();
        pq.add(new pair(src,0));
        //System.out.println("---------------");
        while(pq.size()!=0)
        {
            pair cp=pq.remove();
            //System.out.println(cp.vtx+" "+cp.wt);
            visited[cp.vtx]=Math.min(visited[cp.vtx],cp.wt);
            for(pair nbr:graph[cp.vtx])
            {
              if(visited[nbr.vtx]==Integer.MAX_VALUE)
              {
                  pq.add(new pair(nbr.vtx,cp.wt+nbr.wt));
              }
            }
        }
        //System.out.println("----------------------------");
        // for(int i=0;i<visited.length;i++)
        // {
        //     System.out.println(visited[i]+" "+i);
        // }
        return visited[dest];
    }
   public static void main(String[] args) {
       Scanner scn=new Scanner(System.in);
       int n=scn.nextInt();
       int m=scn.nextInt();
       ArrayList<pair>[] graph=new ArrayList[n+1];
       for(int i=0;i<graph.length;i++)
       {
           graph[i]=new ArrayList<>();
       }
       for(int i=0;i<m;i++)
       {
           int u=scn.nextInt();
           int v=scn.nextInt();
           //pair p=new pair(v,0);
           graph[u].add(new pair(v,0));
           graph[v].add(new pair(u,1));
       }
       System.out.println(dij(graph,1,n));
   }
}