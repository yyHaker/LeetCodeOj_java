package com.yyHaker.common.utils;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * GraphStudy
 *
 * @author Le Yuan
 * @date 2017/3/20
 */
public class GraphStudy {
    public static void main(String[]args){
        int n=8,e=9;//分别代表结点个数和边的数目
        String labels[]={"A","B","C","D","E","F","G","H"};//结点的标识
        boolean []isVisited1=new boolean[n];
        boolean []isVisited2=new boolean[n];
        Graph graph=new Graph(n);
        for(String label:labels) {
               graph.insertVetex(label);                 //插入结点
        }
        //插入九条边
        graph.insertEdge(0, 1, 1);
        graph.insertEdge(0, 2, 1);
        graph.insertEdge(1, 3, 1);
        graph.insertEdge(1, 4, 1);
        graph.insertEdge(2, 5, 1);
        graph.insertEdge(2, 6, 1);
        graph.insertEdge(3, 7, 1);
        graph.insertEdge(4, 7, 1);
        graph.insertEdge(5, 6, 1);

        graph.insertEdge(1, 0, 1);
        graph.insertEdge(2, 0, 1);
        graph.insertEdge(3, 1, 1);
        graph.insertEdge(4, 1, 1);
        graph.insertEdge(5, 2, 1);
        graph.insertEdge(6, 2, 1);
        graph.insertEdge(7, 3, 1);
        graph.insertEdge(7, 4, 1);
        graph.insertEdge(6, 5, 1);

        System.out.println("深度优先搜索序列为：");
        graph.depthFirstSearch(isVisited1,0);
        System.out.println();
        System.out.println("广度优先搜索序列为：");
        graph.broadFirstSearch(isVisited2,0);
    }
}

/**
 * 采用邻接矩阵存储，并处理相关问题
 * 1.在邻接矩阵中，两个顶点连接用相应的权值表示，不连接用0表示
 */
class Graph{
    private ArrayList vertexList;   //存储顶点的数组列表
    private int[][] edges;                //邻接矩阵，用来存储边
    private int numOfEdges;           //边的数目

    public Graph(int n){  //参数n表示顶点的个数
        edges=new int[n][n];
        vertexList=new ArrayList(n);
        numOfEdges=0;
    }

    public int getNumOfEdges(){
        return  numOfEdges;
    }

    public int getNumOfVertex(){
        return vertexList.size();
    }

    //返回指定位置i的顶点
    public Object getVertexByIndex(int i){
        return vertexList.get(i);
    }

    //返回顶点v1、v2的权值
    public int getWeight(int v1,int v2){
        return edges[v1][v2];
    }

    //插入顶点
    public void insertVetex(Object vertex){
        vertexList.add(vertexList.size(),vertex);
    }

    //插入边
    public void insertEdge(int v1,int v2,int weight){
        edges[v1][v2]=weight;
        numOfEdges++;
    }

    //删除边
    public void deleteEdge(int v1,int v2){
        edges[v1][v2]=0;
        numOfEdges--;
    }

    //得到第一个邻接顶点的下标
    public int getFirstNeighbor(int index){
         for(int j=0;j<vertexList.size();j++){
             if(edges[index][j]>0){
                 return j;
             }
         }
         return -1;
    }

    //根据前一个邻接顶点的下标来取得下一个邻接顶点
     public int  getNextNeighbor(int index,int v1){
         for(int j=v1+1;j<vertexList.size();j++){
             if(edges[index][j]>0){
                 return j;
             }
         }
         return -1;
     }

     //深度优先遍历
     public void depthFirstSearch(boolean[]isVisited,int i){
         System.out.print(getVertexByIndex(i)+" ");
           isVisited[i]=true;

         int w=getFirstNeighbor(i);
         while(w!=-1){
             if(!isVisited[w]){
                 depthFirstSearch(isVisited,w);
             }
             w=getNextNeighbor(i,w);
         }
     }

     //广度优先遍历
     public void broadFirstSearch(boolean[]isVisited,int index){
         int u,w;
         LinkedList queue=new LinkedList();

         //顶点入队列
         queue.addLast(index);
         while(!queue.isEmpty()){
             //顶点出队列
             u=(Integer) queue.removeFirst();
             //访问顶点i
             System.out.print(getVertexByIndex(u)+" ");
             isVisited[u]=true;

             //将u的所有子节点添加到队列中
              for(int j=0;j<vertexList.size();j++){
                  if(edges[u][j]>0&&!isVisited[j]){
                       queue.addLast(j);
                        isVisited[j]=true;
                  }
              }

         }

     }
}
