import java.io.*;
import java.util.*;
import java.lang.*;
public class prims {
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
    public static void main(String args[]) {
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
           int cwt=scn.nextInt();
           graph[u].add(new pair(v,cwt));
           graph[v].add(new pair(u,cwt));
       }
    //    for(int i=0;i<graph.length;i++)
    //    {
    //        System.out.println(i+" ");
    //        for(pair p:graph[i])
    //        {
    //            System.out.println(p.vtx+"  "+p.wt);
    //        }
    //    }
      PriorityQueue<pair> pq=new PriorityQueue<>();
      pq.add(new pair(1,0));
      boolean [] visited=new boolean[n+1];
      int answt=0;
      while(pq.size()!=0)
      {
          pair cp=pq.remove();
          //System.out.println(cp.vtx+"--->"+cp.wt);
          if(visited[cp.vtx]==false)
          {
          answt+=cp.wt;
          visited[cp.vtx]=true;
          }
          ArrayList<pair> nbrs=graph[cp.vtx];
          for(pair p:nbrs)
          {
              if(visited[p.vtx]==false)
              {
                  pq.add(p);
              }
          }
      } 
      System.out.println(answt);
    }
}